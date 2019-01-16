package com.zxin.jiuxian.mvp.model;

import com.zxin.jiuxian.api.RequestParameter;
import com.zxin.jiuxian.bean.JiuXianUriUtils;
import com.zxin.jiuxian.api.RootResult;
import com.zxin.jiuxian.api.ZXinJiuXianApi;
import com.zxin.jiuxian.bean.CateLeftPageResult;
import com.zxin.jiuxian.bean.CatePageResult;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ClassiftyModel extends BaseModel {

    public void getCategoryList() {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("apiVersion","1.1");
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web9, ZXinJiuXianApi.class)
                .getCategoryList(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<CateLeftPageResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<CateLeftPageResult> strData) {
                        if (strData.isBusinessOk())
                            getListener().onSuccess(getTag(), strData.getResult());
                        else
                            getListener().onFailure(getTag(), strData.getErrMsg());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), ex.getMessage());
                    }
                });
    }

    public void getCategoryDetail(String cateId) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("id",cateId);
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web9, ZXinJiuXianApi.class)
                .getCategoryDetail(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<CatePageResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<CatePageResult> strData) {
                        if (strData.isBusinessOk())
                            getListener().onSuccess(getTag(), strData.getResult());
                        else
                            getListener().onFailure(getTag(), strData.getErrMsg());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), ex.getMessage());
                    }
                });
    }
}
