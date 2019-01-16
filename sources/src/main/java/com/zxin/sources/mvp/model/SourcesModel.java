package com.zxin.sources.mvp.model;

import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class SourcesModel extends BaseModel {

    public void getCodeKKList(String mesg,int pageNum) {
        getHttpService().getZXinWebApi("http://p.codekk.com/")
                .getCodeKKList(mesg,pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ResponseBody>(getContext(), true) {
                    @Override
                    protected void onDone(ResponseBody strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    /****
     * 云商
     * @param pageNum
     */
    public void getYunShangList(int pageNum) {
        getHttpService().getZXinWebApi("http://www.ynshangji.com/")
                .getYunShangList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ResponseBody>(getContext(), true) {
                    @Override
                    protected void onDone(ResponseBody strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    /*****
     * 安卓 BUS
     * @param pageNum
     */
    public void getAndroidBusList(int pageNum) {
        getHttpService().getZXinWebApi("http://www.apkbus.com/")
                .getAndroidBusList(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ResponseBody>(getContext(), true) {
                    @Override
                    protected void onDone(ResponseBody strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
