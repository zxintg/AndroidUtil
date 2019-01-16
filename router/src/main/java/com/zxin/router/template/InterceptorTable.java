package com.zxin.router.template;

import com.zxin.router.RouteInterceptor;

import java.util.Map;

/**
 * Interceptor table mapping.
 * <p>
 * Created by zxin on 2017/6/30.
 */
public interface InterceptorTable {
    /**
     * Mapping between name and interceptor.
     *
     * @param map name -> interceptor.
     */
    void handle(Map<String, Class<? extends RouteInterceptor>> map);
}
