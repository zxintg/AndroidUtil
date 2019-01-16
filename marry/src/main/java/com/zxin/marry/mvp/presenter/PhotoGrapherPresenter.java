package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.PhotoGrapherModel;
import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.mvp.view.PhotoGrapherContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/5/21.
 */

public class PhotoGrapherPresenter extends BasePresenter<PhotoGrapherContract, PhotoGrapherModel> implements MvpCallback{

    public void initDatas(PhotoGrapherContract.PhotoAndMakeupArtistView listener,Object... parameter) {
        getView().setP(this);
        getView().setPhotoAndMakeupArtistListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initReserveRecordDatas(PhotoGrapherContract.ReserveRecordView listener,Object... parameter) {
        getView().setP(this);
        getView().setReserveRecordListener(listener);
        getView().setReserveRecordParameter(parameter);
        getView().initReserveRecordDatas();
        getModel().setListener(this);
    }

    public void getDesignAndCameraDetail(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_PhotoAndCameraDetail);
        getModel().getDesignAndCameraDetail(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getReserveRecordList(String orderid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveRecordList);
        getModel().getReserveRecordList(SharedPreferencesManager.getMarryUid(),orderid);
    }


    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_PhotoAndCameraDetail:
                getView().onResultSuccess(data);
                break;
            case MarryIntegerUtil.WEB_API_ReserveRecordList:
                getView().onResultReserveRecordDatas(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_PhotoAndCameraDetail:
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
