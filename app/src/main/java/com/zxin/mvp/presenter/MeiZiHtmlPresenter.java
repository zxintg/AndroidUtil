package com.zxin.mvp.presenter;

import android.view.View;

import com.zxin.mvp.model.TestOneModel;
import com.zxin.mvp.view.TestHtmlContract;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.util.HtmlOperatorUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.ToastUtil;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MeiZiHtmlPresenter extends BasePresenter<TestHtmlContract, TestOneModel> implements MvpCallback{
    private String type = "38";

    public void initDatas(TestHtmlContract.TestView listener) {
        getView().setP(this);
        getView().setTestViewListener(listener);
        getView().initDatas();
    }

    public void getTestMeiZi(int pageNum) {
        getModel().setListener(this);
        getModel().setTag(IntegerUtil.WEB_API_TestMeiZiHtml);
        getModel().getMeiziHtmlList(pageNum);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case IntegerUtil.WEB_API_TestMeiZiHtml:
                ResponseBody body = (ResponseBody) data;
                try {
                    getView().onResultSuccess(HtmlOperatorUtil.getInstance().getDoubanMeiziList(body.string()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case IntegerUtil.WEB_API_TestMeiZiHtml:
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

    }

    @Override
    public void OnClick(View v) {

    }
}
