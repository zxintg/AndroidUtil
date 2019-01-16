package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.baidu.mapapi.cloud.CloudManager;
import com.baidu.mapapi.cloud.LocalSearchInfo;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.mvp.model.MessageModel;
import com.zxin.marry.mvp.model.ToolsModel;
import com.zxin.marry.mvp.view.MessageContract;
import com.zxin.marry.mvp.view.ToolsContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ToolsPresenter extends BasePresenter<ToolsContract, ToolsModel> implements MvpCallback{

    public void initDatas(ToolsContract.ToolsTaskView listener,Object... parameter) {
        getView().setP(this);
        getView().setToolsTaskViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initTaskItemDatas(ToolsContract.TaskItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setTaskItemViewListener(listener);
        getView().setTaskItemViewParameter(parameter);
        getView().initTaskItemViewDatas();
        getModel().setListener(this);
    }

    public void initRegistDatas(ToolsContract.ToolsRegistView listener,Object... parameter) {
        getView().setP(this);
        getView().setToolsRegistViewListener(listener);
        getView().initToolsRegistViewDatas();
        getModel().setListener(this);
    }

    public void getUserMessage() {
        getModel().setTag(MarryIntegerUtil.WEB_API_UserMessage);
        getModel().getUserMessage(SharedPreferencesManager.getMarryUid());
    }

    public void getTaskList(String taskType) {
        getModel().setTag(MarryIntegerUtil.WEB_API_TaskList);
        getModel().getTaskList(SharedPreferencesManager.getMarryUid(),taskType,SharedPreferencesManager.getMarryUserInfo(UserCommon.class).getData().getMarrydate());
    }

    public void getMarryRegistList(int pageNum) {
        getModel().setTag(MarryIntegerUtil.WEB_API_MarryRegistList);
        getModel().getMarryRegistList(SharedPreferencesManager.getMarryCity(CityForm.City.class).getCity(),"婚姻登记处",pageNum);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_UserMessage:
                getView().onResultSuccess(data);
                break;
            case MarryIntegerUtil.WEB_API_TaskList:
                getView().onResultTaskListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_MarryRegistList:
                getView().onResultRegistViewSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_UserMessage:
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
