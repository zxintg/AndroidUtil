package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.CommonModel;
import com.zxin.marry.mvp.view.UserLoginContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class UserLoginPresenter extends BasePresenter<UserLoginContract, CommonModel> implements MvpCallback{

    public void initDatas(UserLoginContract.AccountLoginView listener,Object... parameter) {
        getView().setP(this);
        getView().setAccountLoginViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initMarryLoginDatas(UserLoginContract.MarrayLoginView listener,Object... parameter) {
        getView().setP(this);
        getView().setMarrayLoginViewListener(listener);
        getView().initMarrayLoginViewDatas();
        getModel().setListener(this);
    }

    public void accountLogin(String username,String password) {
        getModel().setTag(MarryIntegerUtil.WEB_API_AccountLogin);
        getModel().accountLogin(username,password);
    }

    public void sendVerifyLogin(String ver) {
        getModel().setTag(MarryIntegerUtil.WEB_API_SendVerify);
        getModel().sendVerifyLogin(ver);
    }

    public void verifyLogin(String phone,String ver) {
        getModel().setTag(MarryIntegerUtil.WEB_API_VerifyLogin);
        getModel().verifyLogin(phone,ver);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_AccountLogin:
                getView().onResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_SendVerify:
                getView().onResultSendVerifySuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_VerifyLogin:
                getView().onResultVerifyLoginSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_AccountLogin:
                ToastUtil.showShort(msg);
                break;
        }
    }

    @Override
    public void onComplete(int tager) {
        getView().onComplete();
    }


    @Override
    public void loadDatas() {
        getView().loadDatas();
    }

    @Override
    public void OnClick(View v) {
        getView().OnClick(v);
    }
}
