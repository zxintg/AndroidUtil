package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.CommonModel;
import com.zxin.marry.mvp.view.MainCricleContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MainCriclePresenter extends BasePresenter<MainCricleContract, CommonModel> implements MvpCallback{

    public void initDatas(MainCricleContract.MainCricleView listener,Object... parameter) {
        getView().setP(this);
        getView().setMainCricleViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void getHomeList() {
        getModel().setTag(MarryIntegerUtil.WEB_API_HomeList);
        getModel().getHomeList();
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_HomeList:
                getView().onResultSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_HomeList:
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
