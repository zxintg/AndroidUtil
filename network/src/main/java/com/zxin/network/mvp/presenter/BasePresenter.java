package com.zxin.network.mvp.presenter;

import android.content.Context;
import android.view.View;
import com.zxin.network.mvp.model.BaseModel;
import com.zxin.network.mvp.view.IBaseView;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/5/21.
 */

public abstract class BasePresenter <V extends IBaseView, M extends BaseModel> {

    private V mView;
    private M mModel;

    /**
     * 绑定View
     *
     * @param mContext
     */
    public void attachView(Context mContext) {
        //动态代理（接口）
        //view.getClass().getSuperclass()
        /*mView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在View层显示数据之前用户可能退出了View层的页面，会在Activity的onDestroy()方法中会把mView置为null
                //由于View层都是接口，这里采用了动态代理，如果在View层显示数据之前用户可能退出了View层的页面，返回null的话，onSuccess()方法不会执行
                if (mView == null) {
                    return null;
                }
                //每次调用View层接口的方法，都会执行这里
                return method.invoke(view, args);
            }
        });*/
        //动态创建Model？怎么创建创建？？？用反射创建
        Type[] params = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        try {
            //最好是判断下类型
            mView = (V) ((Class) params[0]).newInstance();
            mView.setContext(mContext);
            mModel = (M) ((Class) params[1]).newInstance();
            mModel.setContext(mContext);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解绑View
     */
    public void detachView() {
        mView = null;
        mModel = null;
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }

    public abstract void loadDatas();

    public abstract void OnClick(View v);

}
