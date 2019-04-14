package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.ShoppingCarModel;
import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.mvp.view.ShoppingCarContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ShoppingCarPresenter extends BasePresenter<ShoppingCarContract, ShoppingCarModel> implements MvpCallback{

    public void initDatas(ShoppingCarContract.MainTopicView listener,Object... parameter) {
        getView().setP(this);
        getView().setMainTopicViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }
    public void getCartList() {
        getModel().setTag(MarryIntegerUtil.WEB_API_CartList);
        getModel().getCartList(SharedPreferencesManager.getMarryUid());
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_CartList:
                getView().onResultCartListSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
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

    }

}
