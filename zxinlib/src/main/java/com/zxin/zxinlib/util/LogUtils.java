package com.zxin.zxinlib.util;

import android.util.Log;

import com.zxin.zxinlib.app.BaseApplication;


/**
 * service-下载接口
 * Created by hy on 2017/9/18.
 */

public class LogUtils {
    private static final String TAG = BaseApplication.getInstance().getMyPackageName();
    //  public static final boolean isDebug = BuildConfig.DEBUG;

    /**
     * 打印一个debug等级的 log
     */
    public static void d(String msg) {
        if (true) {
            Log.d("jiemo_" + TAG, msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(String msg) {
        if (true) {
            Log.e("disanxuetang" + TAG, msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(Class cls, String msg) {
        if (true) {
            Log.e("jiemo_" + cls.getSimpleName(), msg);
        }
    }

}
