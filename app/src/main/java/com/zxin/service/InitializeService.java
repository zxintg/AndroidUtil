package com.zxin.service;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.zxin.app.MyApplication;
import com.zxin.network.util.NetworkUtil;
import com.zxin.router.Configuration;
import com.zxin.router.Router;
import com.zxin.root.BuildConfig;
import com.zxin.basemodel.app.GreenDaoManager;
import com.zxin.root.exception.CrashHandler;
import com.zxin.root.util.LogUtils;
import com.zxin.root.util.ToastUtil;


/**
 * <pre>
 *     @author zxin
 *     time  : 2019/02/02
 *     desc  : 初始化工作，子线程，处理耗时操作和避免在application做过多初始化工作，比如初始化数据库等等
 *     revise:
 * </pre>
 */
@SuppressLint("Registered")
public class InitializeService extends IntentService {

    private static final String ACTION_INIT = "initApplication";

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }

    /**
     * 在构造函数中传入线程名字
     **/
    public InitializeService(){
        //注意这里需要写类的名称
        super("InitializeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT.equals(action)) {
                initApplication();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.e("InitializeService 初始化======》onCreate");
    }

    private void initApplication() {
        //处理耗时操作和避免在application做过多初始化工作，比如初始化数据库等等
        LogUtils.e("InitializeService 初始化");
        //全局错误信息
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        //腾讯X5
        QbSdk.initX5Environment(this, null);
        //初始化DB(拷贝数据到数据库)
        GreenDaoManager.getInstance();
        //在这里初始化
        Fresco.initialize(this);
        //阿里百川
        AlibcTradeSDK.asyncInit(MyApplication.getInstance(), new AlibcTradeInitCallback() {
            public void onFailure(int paramAnonymousInt, String paramAnonymousString) {
                LogUtils.d("阿里百川 实初始化失败 -code:" + paramAnonymousInt + "|msg:" + paramAnonymousString);
            }

            public void onSuccess() {
                LogUtils.d("阿里百川====》初始化成功");
            }
        });
        //customizable init option
        BugtagsOptions options = new BugtagsOptions.Builder().
                trackingLocation(true).//是否获取位置
                trackingCrashLog(true).//是否收集crash
                trackingConsoleLog(true).//是否收集console log
                trackingUserSteps(true).//是否收集用户操作步骤
                enableCapturePlus(true).
                build();

        Bugtags.addUserStep("custom step");
        Bugtags.start(BuildConfig.DEBUG ? "e8c283891f44c4c44f3e3f12a32bc3be" : "e8c283891f44c4c44f3e3f12a32bc3be", MyApplication.getInstance(), Bugtags.BTGInvocationEventBubble, options);
        // 初始化路由（https://github.com/chenenyu/Router）
        Router.initialize(new Configuration.Builder()
                // 调试模式，开启后会打印log
                .setDebuggable(BuildConfig.DEBUG)
                // 模块名(即project.name)，每个使用Router的module都要在这里注册
                .registerModules("jianshennannv", "sources", "marry", "jiuxian", "meziyowu", "app")
                .build());
        //百度地图 在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        LogUtils.e("InitializeService 初始化======》onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    private int netWarnning = 0;

    //内部类ConnectionChangeReceiver
    public class ConnectionChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!NetworkUtil.isNetWorkAviliable(context) && netWarnning < 1) {
                netWarnning++;
                ToastUtil.showShort("当前网络不可用");
            } else {
                netWarnning = 0;
            }
        }
    }

}
