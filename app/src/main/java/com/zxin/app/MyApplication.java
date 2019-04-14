package com.zxin.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.zxin.basemodel.app.BaseApplication;
import com.zxin.network.util.NetworkUtil;
import com.zxin.router.Configuration;
import com.zxin.router.Router;
import com.zxin.root.BuildConfig;
import com.zxin.root.app.GreenDaoManager;
import com.zxin.root.exception.CrashHandler;
import com.zxin.root.util.LogUtils;
import com.zxin.root.util.ToastUtil;
import com.zxin.network.PoolThread;
import com.zxin.service.InitializeService;
import com.zxin.root.app.BaseApplication;

/**
 * Created by hy on 2017/9/22.
 */
public class MyApplication extends BaseApplication {
    private static Context mContext;
    private static volatile MyApplication application = null;
    private PoolThread executor;

    //私有化，防止外部调取再次初始化
    public static synchronized MyApplication getInstance() {
        if (application==null)
            application = new MyApplication();
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //初始化线程池管理器
        initThreadPool();
        //InitializeService.start(this);
        mContext = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //全局错误信息
                CrashHandler crashHandler = CrashHandler.getInstance();
                crashHandler.init(application);
                Thread.setDefaultUncaughtExceptionHandler(crashHandler);
                //腾讯X5
                QbSdk.initX5Environment(contextApp, null);
                //初始化DB(拷贝数据到数据库)
                GreenDaoManager.getInstance();
                //在这里初始化
                Fresco.initialize(mContext);
                //阿里百川
                AlibcTradeSDK.asyncInit(application, new AlibcTradeInitCallback() {
                    public void onFailure(int paramAnonymousInt, String paramAnonymousString) {
                        LogUtils.d("阿里百川 实初始化失败 -code:" + paramAnonymousInt + "|msg:" + paramAnonymousString);
                    }
                    public void onSuccess() {
                        LogUtils.d("阿里百川====》初始化成功");
                    }
                });
            }
        }).start();
        //customizable init option
        BugtagsOptions options = new BugtagsOptions.Builder().
                trackingLocation(true).//是否获取位置
                trackingCrashLog(true).//是否收集crash
                trackingConsoleLog(true).//是否收集console log
                trackingUserSteps(true).//是否收集用户操作步骤
                enableCapturePlus(true).
                build();

        Bugtags.addUserStep("custom step");
        Bugtags.start(BuildConfig.DEBUG ? "e8c283891f44c4c44f3e3f12a32bc3be" : "e8c283891f44c4c44f3e3f12a32bc3be", this, Bugtags.BTGInvocationEventBubble, options);
        // 初始化路由（https://github.com/chenenyu/Router）
        Router.initialize(new Configuration.Builder()
                // 调试模式，开启后会打印log
                .setDebuggable(BuildConfig.DEBUG)
                // 模块名(即project.name)，每个使用Router的module都要在这里注册
                .registerModules("jianshennannv","sources", "marry","jiuxian","meziyowu", "app")
                .build());
        //百度地图 在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(application);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    /**
     * 初始化线程池管理器
     */
    private void initThreadPool() {
        // 创建一个独立的实例进行使用
        executor = PoolThread.ThreadBuilder
                .createFixed(5)
                .setPriority(Thread.MAX_PRIORITY)
                .setCallback(new LogCallback())
                .build();
    }

    /**
     * 获取线程池管理器对象，统一的管理器维护所有的线程池
     * @return                      executor对象
     */
    public PoolThread getExecutor(){
        if(executor ==null){
            executor = PoolThread.ThreadBuilder
                    .createFixed(5)
                    .setPriority(Thread.MAX_PRIORITY)
                    .setCallback(new LogCallback())
                    .build();
        }
        return executor;
    }
}
