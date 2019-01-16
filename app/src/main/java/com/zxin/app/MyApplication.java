package com.zxin.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.baidu.mapapi.SDKInitializer;
import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.zxin.network.util.NetworkUtil;
import com.zxin.router.Configuration;
import com.zxin.router.Router;
import com.zxin.zxinlib.BuildConfig;
import com.zxin.zxinlib.app.BaseApplication;
import com.zxin.zxinlib.app.GreenDaoManager;
import com.zxin.zxinlib.exception.CrashHandler;
import com.zxin.zxinlib.util.LogUtils;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by hy on 2017/9/22.
 */
public class MyApplication extends BaseApplication {
    private static Context mContext;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
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
        //百度地图
        SDKInitializer.initialize(application);
    }

    public static MyApplication getInstance() {
        return application;
    }

    /**
     * @return 全局的上下文
     */
    public Context getmContext() {
        return mContext;
    }

    private int netWarnning = 0;

    //内部类ConnectionChangeReceiver
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!NetworkUtil.isNetWorkAviliable(application) && netWarnning < 1) {
                netWarnning++;
                ToastUtil.showShort("当前网络不可用");
            } else {
                netWarnning = 0;
            }
        }
    }
}
