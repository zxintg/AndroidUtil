package com.zxin.executor.config;

import com.zxin.executor.callback.AsyncCallback;
import com.zxin.executor.callback.ThreadCallback;

import java.util.concurrent.Executor;

/**
 * <pre>
 *     @author zxin
 *     time  : 2019/02/02
 *     desc  : 存储当前任务的某些配置
 *     revise:
 * </pre>
 */

public final class ThreadConfigs {

    /**
     * 线程的名称
     * 通过setName方法设置
     */
    public String name;
    /**
     * 线程执行延迟的时间
     * 通过setDelay方法设置
     */
    public long delay;
    /**
     * 线程执行者
     * JAVA或者ANDROID
     */
    public Executor deliver;
    /**
     * 用户任务的状态回调callback
     */
    public ThreadCallback callback;
    /**
     * 异步callback回调callback
     */
    public AsyncCallback asyncCallback;

}
