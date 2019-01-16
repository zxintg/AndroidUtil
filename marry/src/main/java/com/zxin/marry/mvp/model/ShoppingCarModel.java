package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.CartListBean;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ShoppingCarModel extends BaseModel {

    /******
     * 详情
     */
    public void getCartList(String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getCartList(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CartListBean>(getContext(), true) {
                    @Override
                    protected void onDone(CartListBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
