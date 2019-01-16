package com.zxin.router;

import android.util.Log;

import com.zxin.router.annotation.Interceptor;

/**
 * Global interceptor.
 * <p>
 * Created by zxin on 2017/9/11.
 */
@Interceptor("GlobalInterceptor")
public class GlobalInterceptor implements RouteInterceptor {
    @Override
    public boolean intercept(Object source, RouteRequest routeRequest) {
        Log.d("GlobalInterceptor", String.format("{uri: %s, interceptor: %s}",
                routeRequest.getUri().toString(), GlobalInterceptor.class.getName()));
        return false;
    }
}
