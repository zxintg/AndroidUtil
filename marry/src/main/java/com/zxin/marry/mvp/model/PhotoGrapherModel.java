package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.CameramandBean;
import com.zxin.marry.bean.OnLineCameraForm;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import com.zxin.root.util.SharedPreferencesManager;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class PhotoGrapherModel extends BaseModel {

    /******
     * 详情
     */
    public void getDesignAndCameraDetail(String uid, String orderid, String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getDesignAndCameraDetail(uid,orderid,shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CameramandBean>(getContext(), true) {
                    @Override
                    protected void onDone(CameramandBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getReserveRecordList(String uid, String orderid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getReserveRecordList(uid,orderid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<OnLineCameraForm>(getContext(), true) {
                    @Override
                    protected void onDone(OnLineCameraForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
