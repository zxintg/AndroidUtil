package com.zxin.jiuxian.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.network.mvp.presenter.BasePresenter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/28.
 */

public abstract class BaseService extends Service {
    //一个View 里面肯定有多个Presenter情况，怎么处理，Dagger处理
    private List<BasePresenter> mPresenterList;

    @Override
    public void onCreate() {
        super.onCreate();
        injectPresener();
        initData();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 数据初始化
     * 默认在onStart中调用
     * 建议增加数据恢复判断，配合onSaveInstanceState使用
     */
    public abstract void initData();
    /*****
     * 注入Presenter 通过反射(或者Dagger)
     */
    private void injectPresener(){
        mPresenterList = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                //创建注入
                Class<? extends BasePresenter> presenterClazz = null;
                try {
                    //获取这个类
                    presenterClazz = ( Class<? extends BasePresenter> ) field.getType();
                } catch (Exception e) {
                    // 乱七八糟一些注入
                    throw new RuntimeException("Presenter 注入错误 ====》not support inject presenter" + field.getType());
                }
                try {
                    //创建BasePresenter对象
                    BasePresenter basePresenter = presenterClazz.newInstance();
                    //attach
                    basePresenter.attachView(getApplicationContext());
                    mPresenterList.add(basePresenter);
                    field.setAccessible(true);
                    field.set(this, basePresenter);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解绑Presenter
        if (mPresenterList==null||mPresenterList.isEmpty())
            return;
        for (BasePresenter presenter : mPresenterList) {
            presenter.detachView();
        }
    }
}
