package com.zxin.app;

import android.util.Log;

import com.zxin.network.callback.ThreadCallback;


/**
 * <pre>
 *     @author zxin
 *     time  : 2019/02/02
 *     desc  : 回调数据
 *     revise:
 * </pre>
 */
public class LogCallback implements ThreadCallback {

    private final String TAG = "LogCallback";

    @Override
    public void onError(String name, Throwable t) {
        Log.e(TAG, "LogCallback"+"------onError"+"-----"+name+"----"+Thread.currentThread()+"----"+t.getMessage());
    }

    @Override
    public void onCompleted(String name) {
        Log.e(TAG, "LogCallback"+"------onCompleted"+"-----"+name+"----"+Thread.currentThread());
    }

    @Override
    public void onStart(String name) {
        Log.e(TAG, "LogCallback"+"------onStart"+"-----"+name+"----"+Thread.currentThread());
    }
}
