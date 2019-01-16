package com.zxin.router;

import android.net.Uri;

import com.zxin.router.matcher.AbsMatcher;
import com.zxin.router.template.InterceptorTable;
import com.zxin.router.template.RouteTable;
import com.zxin.router.template.TargetInterceptors;
import com.zxin.router.util.RLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry class.
 * <p>
 * Created by zxin on 2016/12/20.
 */
public class Router {
    /**
     * You can get the raw uri in target page by call <code>intent.getStringExtra(Router.RAW_URI)</code>.
     */
    public static final String RAW_URI = "raw_uri";

    private static List<RouteInterceptor> sGlobalInterceptors = new ArrayList<>();


    public static void initialize(Configuration configuration) {
        RLog.showLog(configuration.debuggable);
        AptHub.registerModules(configuration.modules);
    }

    public static IRouter build(String path) {
        return build(path == null ? null : Uri.parse(path));
    }

    public static IRouter build(Uri uri) {
        return new RealRouter().build(uri);
    }

    /**
     * Custom route table.
     */
    public static void handleRouteTable(RouteTable routeTable) {
        if (routeTable != null) {
            routeTable.handle(AptHub.routeTable);
        }
    }

    /**
     * Custom interceptor table.
     */
    public static void handleInterceptorTable(InterceptorTable interceptorTable) {
        if (interceptorTable != null) {
            interceptorTable.handle(AptHub.interceptorTable);
        }
    }

    /**
     * Custom targets' interceptors.
     */
    public static void handleTargetInterceptors(TargetInterceptors targetInterceptors) {
        if (targetInterceptors != null) {
            targetInterceptors.handle(AptHub.targetInterceptors);
        }
    }

    /**
     * Auto inject params from bundle.
     *
     * @param obj Instance of Activity or Fragment.
     */
    public static void injectParams(Object obj) {
        RealRouter.injectParams(obj);
    }

    /**
     * Global interceptor.
     */
    public static void addGlobalInterceptor(RouteInterceptor routeInterceptor) {
        sGlobalInterceptors.add(routeInterceptor);
    }

    public static List<RouteInterceptor> getGlobalInterceptors() {
        return sGlobalInterceptors;
    }

    /**
     * Register your own matcher.
     *
     */
    public static void registerMatcher(AbsMatcher matcher) {
        MatcherRegistry.register(matcher);
    }

    public static void clearMatcher() {
        MatcherRegistry.clear();
    }
}
