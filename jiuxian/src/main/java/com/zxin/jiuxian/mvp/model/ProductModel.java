package com.zxin.jiuxian.mvp.model;

import com.zxin.jiuxian.api.RequestParameter;
import com.zxin.jiuxian.api.RootResult;
import com.zxin.jiuxian.api.ZXinJiuXianApi;
import com.zxin.jiuxian.bean.CommendDetailTabResult;
import com.zxin.jiuxian.bean.DeliveryTimeResult;
import com.zxin.jiuxian.bean.JiuXianUriUtils;
import com.zxin.jiuxian.bean.LoginInfoResult;
import com.zxin.jiuxian.bean.ProductDetailResult;
import com.zxin.jiuxian.bean.ProductListInfoResult;
import com.zxin.jiuxian.bean.RecommendInfoResult;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import java.util.Map;

import retrofit2.http.Query;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ProductModel extends BaseModel {

    public void searchProduct(int pageIndex, String startPrice,String endPrice,String orderBy,String categoryId, String attrsId, String keyword, boolean isTopTopic) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("pageIndex", String.valueOf(pageIndex));
        parameterMap.put("pageSize", "10");
        if (!StringUtils.textIsEmpty(startPrice)) {
            parameterMap.put("startPrice", startPrice);
        }
        if (!StringUtils.textIsEmpty(endPrice)) {
            parameterMap.put("endPrice", endPrice);
        }
        if (!StringUtils.textIsEmpty(orderBy)) {
            parameterMap.put("orderBy", orderBy);
        }
        if (!StringUtils.textIsEmpty(categoryId)) {
            parameterMap.put("categoryId", categoryId);
        }
        if (!StringUtils.textIsEmpty(keyword)) {
            parameterMap.put("keyword", keyword);
        }
        parameterMap.put("attrsId", attrsId);
        parameterMap.put("isTopTopic", String.valueOf(isTopTopic));
        parameterMap.put("supportSearchCondition", String.valueOf(1));
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web9, ZXinJiuXianApi.class)
                .searchProduct(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<ProductListInfoResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<ProductListInfoResult> strData) {
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

    public void proDetail(String proId) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("proId", proId);
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web9, ZXinJiuXianApi.class)
                .proDetail(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<ProductDetailResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<ProductDetailResult> strData) {
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

    public void getProductComment(String productId) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("productId", productId);
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web14, ZXinJiuXianApi.class)
                .getProductComment(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<CommendDetailTabResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<CommendDetailTabResult> strData) {
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

    public void intendingDeliveryTime(String areaId,String proId) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("areaId", areaId);
        parameterMap.put("proId", proId);
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web9, ZXinJiuXianApi.class)
                .intendingDeliveryTime(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<DeliveryTimeResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<DeliveryTimeResult> strData) {
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

    public void getProductOfRecommendInfo(String productIds,String refer,String page) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("productIds", productIds);
        parameterMap.put("refer", refer);
        parameterMap.put("page", page);
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web14, ZXinJiuXianApi.class)
                .getProductOfRecommendInfo(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<RecommendInfoResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<RecommendInfoResult> strData) {
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
