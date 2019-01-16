package com.zxin.jiuxian.mvp.presenter;

import android.view.View;

import com.zxin.jiuxian.mvp.model.UserModel;
import com.zxin.jiuxian.mvp.view.UserContract;
import com.zxin.jiuxian.util.JiuXianIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class UserPresenter extends BasePresenter<UserContract, UserModel> implements MvpCallback{

  public void initDatas(UserContract.PasswordLoginView listener, Object... parameter) {
        getView().setP(this);
        getView().setPasswordLoginView(listener);
        getView().initDatas();
        getModel().setListener(this);
    }

  public void initMineDatas(UserContract.MineView listener, Object... parameter) {
        getView().setP(this);
        getView().setMineView(listener);
        getView().initMineViewDatas();
        getModel().setListener(this);
    }

    public void passwordLogin(String phone, String pass) {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_PasswordLogin);
        getModel().passwordLogin(phone,pass);
    }

    public void getModuleData() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_ModuleData);
        getModel().getModuleData();
    }

    public void getWinebibber() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_Winebibber);
        getModel().getWinebibber();
    }

    public void getClubUserProduct() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_ClubUserProduct);
        getModel().getClubUserProduct();
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case JiuXianIntegerUtil.WEB_API_PasswordLogin:
                getView().onResultSuccess(data);
                break;

            case JiuXianIntegerUtil.WEB_API_ModuleData:
            case JiuXianIntegerUtil.WEB_API_Winebibber:
            case JiuXianIntegerUtil.WEB_API_ClubUserProduct:
                getView().onResultMineViewSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case JiuXianIntegerUtil.WEB_API_PasswordLogin:
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
