package com.zxin.router;

import android.net.Uri;

import java.io.Serializable;

/**
 * <p>
 * Created by zxin on 2016/12/20.
 */
public interface RouteCallback extends Serializable {
    /**
     * Callback
     *
     * @param state   {@link RouteResult}
     * @param uri     Uri
     * @param message notice msg
     */
    void callback(RouteResult state, Uri uri, String message);
}
