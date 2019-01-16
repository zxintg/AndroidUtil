package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.CommonModel;
import com.zxin.marry.mvp.model.DiscoveryModel;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.marry.mvp.view.UserContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class UserPresenter extends BasePresenter<UserContract, CommonModel> implements MvpCallback{

    public void initDatas(UserContract.MineMainView listener,Object... parameter) {
        getView().setP(this);
        getView().setMineMainViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initDatas(UserContract.MineUserCenterView listener,Object... parameter) {
        getView().setP(this);
        getView().setMineUserCenterViewListener(listener);
        getView().setUserCenterParameter(parameter);
        getView().initUserCenterDatas();
        getModel().setListener(this);
    }

    public void getUserInfo(String userId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_UserInfo);
        getModel().getUserInfo(userId);
    }

    public void updateUserSex(String userId,String sex){
        getModel().setTag(MarryIntegerUtil.WEB_API_UpdateUserSex);
        getModel().updateUserSex(userId,sex);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_UserInfo:
                getView().onResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_UpdateUserSex:
                getView().onUpdateUserSexs(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_UserInfo:
                ToastUtil.showShort(msg);
                break;
            case MarryIntegerUtil.WEB_API_UpdateUserSex:
                getView().onUpdateUserSexsFail();
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

    }

}
