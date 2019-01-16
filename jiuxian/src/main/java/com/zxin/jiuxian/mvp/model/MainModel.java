package com.zxin.jiuxian.mvp.model;

import com.zxin.jiuxian.api.RequestParameter;
import com.zxin.jiuxian.api.RootResult;
import com.zxin.jiuxian.api.ZXinJiuXianApi;
import com.zxin.jiuxian.bean.CircleActInfoResult;
import com.zxin.jiuxian.bean.HomeHeaderResult;
import com.zxin.jiuxian.bean.HomeTabIconResult;
import com.zxin.jiuxian.bean.HomeWineListResult;
import com.zxin.jiuxian.bean.JiuXianUriUtils;
import com.zxin.jiuxian.bean.LaunchPageInfoResult;
import com.zxin.jiuxian.bean.SeckillInfoHomeResult;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import java.util.Map;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class MainModel extends BaseModel {

    public void openImage() {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("Type", "3");
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web10, ZXinJiuXianApi.class)
                .openImage(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<LaunchPageInfoResult>>(getContext(), false) {
                    @Override
                    protected void onDone(RootResult<LaunchPageInfoResult> strData) {
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

    public void recommend(String proIds, String pageIndex) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("proIds", proIds);
        parameterMap.put("pageIndex", pageIndex);
        parameterMap.put("pageSize", "20");
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web10, ZXinJiuXianApi.class)
                .recommend(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<HomeWineListResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<HomeWineListResult> strData) {
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

    public void getHomePageInfoAmend() {
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web10, ZXinJiuXianApi.class)
                .getHomePageInfoAmend(RequestParameter.getParameter())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<HomeHeaderResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<HomeHeaderResult> strData) {
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

    public void getMiaoPaiProForIndex() {
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web10, ZXinJiuXianApi.class)
                .getMiaoPaiProForIndex(RequestParameter.getParameter())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<SeckillInfoHomeResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<SeckillInfoHomeResult> strData) {
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

    public void getCircleActInfo() {
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web10, ZXinJiuXianApi.class)
                .getCircleActInfo(RequestParameter.getParameter())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<CircleActInfoResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<CircleActInfoResult> strData) {
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

    public void getTabMainIcon(int height,int width,String iconVersion) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("apiVersion", "1.2");
        parameterMap.put("height",String.valueOf(height));
        parameterMap.put("width", String.valueOf(width));
        parameterMap.put("mark", iconVersion);
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web10, ZXinJiuXianApi.class)
                .getTabMainIcon(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<HomeTabIconResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<HomeTabIconResult> strData) {
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
