package com.zxin.network.mvp.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 注入P on 2018/5/24.
 */

@Target(ElementType.FIELD)//Target指定了InjectView注解作用对象是成员变量
@Retention(RetentionPolicy.RUNTIME)//Retention指定了注解有效期直到运行时时期
public @interface InjectPresenter {//InjectView用于注入view，其实就是用来代替findViewById方法
}
