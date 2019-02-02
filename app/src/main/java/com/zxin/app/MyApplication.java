package com.zxin.app;

import com.zxin.executor.PoolThread;
import com.zxin.service.InitializeService;
import com.zxin.zxinlib.app.BaseApplication;

/**
 * Created by hy on 2017/9/22.
 */
public class MyApplication extends BaseApplication {
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
        InitializeService.start(this);
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
