package com.zxin.router.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for route.
 * <p>
 * Created by zxin on 2016/12/20.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {
    /**
     * Route path.
     */
    String[] value();

    /**
     * The interceptors' name.
     */
    String[] interceptors() default {};
    /**
     *路由的路径，标识一个路由节点
     */
    //String path();

    /**
     * 将路由节点进行分组，可以实现按组动态加载
     */
    String group() default "";

    /**
     * 路由节点名称，可用于生成javadoc文档
     */
    String name() default "undefined";

    /**
     * 用32位int类型标示，可用于页面的一些配置
     */
    int extras() default Integer.MIN_VALUE;

    /**
     * 路由的优先级
     */
    int priority() default -1;
}