package com.zxin.jiuxian.mvp.model;

import com.zxin.jiuxian.api.RequestParameter;
import com.zxin.jiuxian.bean.JiuXianUriUtils;
import com.zxin.jiuxian.api.RootResult;
import com.zxin.jiuxian.api.ZXinJiuXianApi;
import com.zxin.jiuxian.bean.ClubUserProduct;
import com.zxin.jiuxian.bean.LoginInfoResult;
import com.zxin.jiuxian.bean.UserCenterModuleData;
import com.zxin.jiuxian.bean.UserCenterResult;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import java.util.Map;

import retrofit2.http.Field;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class UserModel extends BaseModel {

    /******
     * 账号密码登录
     */
    public void passwordLogin(String phone, String pass) {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("userName",phone);
        parameterMap.put("passWord",pass);
        parameterMap.put("blackBox","");
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web8, ZXinJiuXianApi.class)
                .passwordLogin(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<LoginInfoResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<LoginInfoResult> strData) {
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

    public void getModuleData() {
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web8, ZXinJiuXianApi.class)
                .getModuleData(RequestParameter.getParameter())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<UserCenterModuleData>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<UserCenterModuleData> strData) {
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

    public void getWinebibber() {
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web8, ZXinJiuXianApi.class)
                .getWinebibber(RequestParameter.getParameter())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<UserCenterResult>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<UserCenterResult> strData) {
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

    /******
     * 我的 会员推荐
     */
    public void getClubUserProduct() {
        Map<String, String> parameterMap = RequestParameter.getParameter();
        parameterMap.put("pageIndex","1");
        parameterMap.put("pageSize","10");
        getHttpService().getZXinJiuXianApi(JiuXianUriUtils.Url_Web8, ZXinJiuXianApi.class)
                .getClubUserProduct(parameterMap)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RootResult<ClubUserProduct>>(getContext(), true) {
                    @Override
                    protected void onDone(RootResult<ClubUserProduct> strData) {
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
