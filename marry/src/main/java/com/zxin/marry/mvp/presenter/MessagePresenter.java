package com.zxin.marry.mvp.presenter;

import android.os.Message;
import android.view.View;

import com.zxin.marry.mvp.model.CircleModel;
import com.zxin.marry.mvp.model.MessageModel;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.marry.mvp.view.MessageContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MessagePresenter extends BasePresenter<MessageContract, MessageModel> implements MvpCallback{

    public void initDatas(MessageContract.MainMesssageView listener,Object... parameter) {
        getView().setP(this);
        getView().setMesssageViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void getMessageList() {
        getModel().setTag(MarryIntegerUtil.WEB_API_MessageList);
        getModel().getMessageList(SharedPreferencesManager.getMarryUid());
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_MessageList:
                getView().onResultSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_MessageList:
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
