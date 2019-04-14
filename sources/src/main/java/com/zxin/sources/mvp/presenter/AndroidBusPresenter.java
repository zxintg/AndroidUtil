package com.zxin.sources.mvp.presenter;

import android.view.View;

import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.util.HtmlOperatorUtil;
import com.zxin.sources.mvp.model.SourcesModel;
import com.zxin.sources.mvp.view.AndroidBusContract;
import com.zxin.sources.mvp.view.YunShangContract;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.ToastUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/21.
 */

public class AndroidBusPresenter extends BasePresenter<AndroidBusContract, SourcesModel> implements MvpCallback{

    public void initDatas(AndroidBusContract.AndroidBusView listener,Object... parameter) {
        getView().setP(this);
        getView().setAndroidBusViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
    }

    public void getAndroidBusList(int pageNum) {
        getModel().setListener(this);
        getModel().setTag(IntegerUtil.WEB_API_AndroidBus);
        getModel().getAndroidBusList(pageNum);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case IntegerUtil.WEB_API_AndroidBus:
                ResponseBody body = (ResponseBody) data;
                try {
                    getView().onResultSuccess(HtmlOperatorUtil.getInstance().getAndroidBusList(body.string()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case IntegerUtil.WEB_API_AndroidBus:
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

    }
}
