package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.HybridMessageBean;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class MessageModel extends BaseModel {

    /******
     * 圈子列表
     */
    public void getMessageList(String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getMessageList(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<HybridMessageBean>(getContext(), true) {
                    @Override
                    protected void onDone(HybridMessageBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
