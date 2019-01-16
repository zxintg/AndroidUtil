package com.zxin.network.util;

/**
 * Created by Administrator on 2018/8/2.
 */
@SuppressWarnings("JniMissingFunction")
public class JniClient {
    static {
        System.loadLibrary("HomeLinkNdk");
    }

    public static native String GetAppId(Object paramObject);

    public static native String GetAppSecret(Object paramObject);
}
