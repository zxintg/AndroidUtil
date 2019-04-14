package com.zxin.mvp.presenter;

import android.view.View;

import com.zxin.mvp.view.TestJsonContract;
import com.zxin.mvp.model.TestOneModel;
import com.zxin.network.MvpCallback;
import com.zxin.network.bean.HuaBanMeiziInfo;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.util.HtmlOperatorUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.ToastUtil;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MeiZiJsonPresenter extends BasePresenter<TestJsonContract, TestOneModel> implements MvpCallback{
    private String type = "38";

    public void initDatas(TestJsonContract.TestView listener) {
        getView().setP(this);
        getView().setTestViewListener(listener);
        getView().initDatas();
    }

    public void getTestMeiZi(int pageNum) {
        getModel().setListener(this);
        getModel().setTag(IntegerUtil.WEB_API_TestMeiZiJson);
        getModel().getMeiziJsonList(type,pageNum);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case IntegerUtil.WEB_API_TestMeiZiJson:
                ResponseBody newDatas = (ResponseBody) data;
                List<HuaBanMeiziInfo>  list= null;
                try {
                    list = HtmlOperatorUtil.getInstance().createFromJson(newDatas.string()).infos;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                getView().onResultSuccess(list);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case IntegerUtil.WEB_API_TestMeiZiJson:
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
