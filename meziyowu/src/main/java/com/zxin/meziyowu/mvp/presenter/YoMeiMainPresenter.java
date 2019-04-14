package com.zxin.meziyowu.mvp.presenter;

import android.view.View;

import com.zxin.meziyowu.bean.YoMeiDeatilBean;
import com.zxin.meziyowu.mvp.model.YoMeiMainModel;
import com.zxin.meziyowu.mvp.view.YoMeiMainContract;
import com.zxin.meziyowu.util.YoWuIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class YoMeiMainPresenter extends BasePresenter<YoMeiMainContract, YoMeiMainModel> implements MvpCallback {

    public void initDatas(YoMeiMainContract.YoMeiMainView listener, Object... parameter) {
        getView().setP(this);
        getView().setYoMeiMainView(listener);
        getModel().setListener(this);
    }

    public void initYoMeiItemDatas(YoMeiMainContract.YoMeiItemView listener, Object... parameter) {
        getView().setP(this);
        getView().setParameter(parameter);
        getView().setYoMeiItemView(listener);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initYoMeiUserDetailDatas(YoMeiMainContract.YoMeiInfoView listener, Object... parameter) {
        getView().setP(this);
        getView().setYoMeiInfoView(listener);
        getView().initYoMeiInfoDatas();
        getModel().setListener(this);
    }

    public void initMiniVideoItemDatas(YoMeiMainContract.MiniVideoItemView listener, Object... parameter) {
        getView().setP(this);
        getView().setParameter(parameter);
        getView().setMiniVideoItemView(listener);
        getView().initMiniVideoItemDatas();
        getModel().setListener(this);
    }

    public void getYoMeiTagList() {
        getModel().setTag(YoWuIntegerUtil.WEB_API_YoMeiTagApi);
        getModel().getYoMeiTagList();
    }

    public void getYoMeiListByTag(int typeId, int pageNum) {
        getModel().setTag(YoWuIntegerUtil.WEB_API_YoMeiTagListApi);
        getModel().getYoMeiListByTag(typeId, pageNum);
    }

    public void getYoMeiVideoDetail(int videoId) {
        getModel().setTag(YoWuIntegerUtil.WEB_API_YoMeiVideoDetail);
        getModel().getYoMeiVideoDetail("497166","51388723df0619cd1e9476ec99f48d3b","ffffffff-d211-d0ee-ffff-ffffbb89ef0c",videoId);
    }

    public void getYoMeiDetail(int videoId) {
        getModel().setTag(YoWuIntegerUtil.WEB_API_YoMeiDetail);
        getModel().getYoMeiDetail("497166","51388723df0619cd1e9476ec99f48d3b",videoId);
    }

    public void getYoMeiDetailList(int videoId, int pageNum) {
        getModel().setTag(YoWuIntegerUtil.WEB_API_YoMeiDetailList);
        getModel().getYoMeiDetailList(videoId, pageNum);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage) {
            case YoWuIntegerUtil.WEB_API_YoMeiTagApi:
                getView().onResultSuccess(data);
                break;

            case YoWuIntegerUtil.WEB_API_YoMeiTagListApi:
                getView().onResultYoMeiListSuccess(data);
                break;

            case YoWuIntegerUtil.WEB_API_YoMeiVideoDetail:
                getView().onResultYoMeiVideoSuccess(data);
                break;

            case YoWuIntegerUtil.WEB_API_YoMeiDetail:
            case YoWuIntegerUtil.WEB_API_YoMeiDetailList:
                if (data instanceof YoMeiDeatilBean)
                    getView().onResultYoMeiDetailSuccess(data);
                else
                    getView().onResultYoMeiDetailListSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage) {
            case YoWuIntegerUtil.WEB_API_YoMeiTagApi:
                ToastUtil.showShort(msg);
                break;

            default:
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
