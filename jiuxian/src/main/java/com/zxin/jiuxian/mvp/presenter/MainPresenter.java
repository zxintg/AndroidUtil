package com.zxin.jiuxian.mvp.presenter;

import android.view.View;
import com.zxin.jiuxian.bean.HomeTabIconResult;
import com.zxin.jiuxian.bean.LaunchPageInfoResult;
import com.zxin.jiuxian.mvp.model.MainModel;
import com.zxin.jiuxian.mvp.view.MainContract;
import com.zxin.jiuxian.util.JiuXianIntegerUtil;
import com.zxin.jiuxian.util.JiuXianSharedPreferences;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MainPresenter extends BasePresenter<MainContract, MainModel> implements MvpCallback {

    public void initMainDatas(MainContract.MainBannerView listener, Object... parameter) {
        getView().setP(this);
        getView().setMainBannerViewListener(listener);
        getView().initMainDatas();
        getModel().setListener(this);
    }

    public void initWelcomeServiceDatas(MainContract.WelcomeImageServiceListener listener, Object... parameter) {
        getView().setP(this);
        getView().setWelcomeImageListener(listener);
        getModel().setListener(this);
    }

    public void initDatas(MainContract.JiuXianMainView listener, Object... parameter) {
        getView().setP(this);
        getView().setJiuXianMainViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void getHomePageInfoAmend() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_HomePageInfoAmend);
        getModel().getHomePageInfoAmend();
    }


    public void getMiaoPaiProForIndex(){
        getModel().setTag(JiuXianIntegerUtil.WEB_API_MiaoPaiProForIndex);
        getModel().getMiaoPaiProForIndex();
    }

    public void getCircleActInfo() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_CircleActInfo);
        getModel().getCircleActInfo();
    }

    public void openImage() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_OpenImage);
        getModel().openImage();
    }

    public void recommend(String proIds, String pageIndex) {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_MainRecommend);
        getModel().recommend(proIds,pageIndex);
    }

    public void getTabMainIcon() {
        getModel().setTag(JiuXianIntegerUtil.WEB_API_TabMainIcon);
        getModel().getTabMainIcon(SystemInfoUtil.getScreenHeight(),SystemInfoUtil.getScreenWidth(), JiuXianSharedPreferences.tab_icon_version());
}

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage) {
            case JiuXianIntegerUtil.WEB_API_OpenImage:
            case JiuXianIntegerUtil.WEB_API_HomePageInfoAmend:
            case JiuXianIntegerUtil.WEB_API_MiaoPaiProForIndex:
            case JiuXianIntegerUtil.WEB_API_CircleActInfo:
            case JiuXianIntegerUtil.WEB_API_MainRecommend:
            case JiuXianIntegerUtil.WEB_API_TabMainIcon:
                if (data instanceof LaunchPageInfoResult){
                    getView().onResultMainBannerSuccess(data);
                    return;
                }

                if (data instanceof HomeTabIconResult){
                    getView().onResultTabMainIconSuccess(data);
                    return;
                }
                getView().onResultSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage) {
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
