package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.MarryRegistList;
import com.zxin.marry.bean.ShopCaseBean;
import com.zxin.marry.bean.ShopDetails;
import com.zxin.marry.bean.ShopGoodsBean;
import com.zxin.marry.bean.StoreCommentList;
import com.zxin.marry.bean.TaskListCommon;
import com.zxin.marry.bean.UserCommon;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ToolsModel extends BaseModel {

    /******
     * 详情
     */
    public void getUserMessage(String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getUserMessage(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<UserCommon>(getContext(), true) {
                    @Override
                    protected void onDone(UserCommon strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getMarryRegistList(String region, String tags, int pageNum) {
        getHttpService().getZXinMarryApi("http://api.map.baidu.com/", ZXinMarryApi.class)
                .getMarryRegistList(region,tags,pageNum,10)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MarryRegistList>(getContext(), true) {
                    @Override
                    protected void onDone(MarryRegistList strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getTaskList(String uid,String taskType,String marryDate) {
        switch (taskType){
            case "get_tasks_date":
                getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                        .getTaskList1(uid,uid,marryDate)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbsAPICallback<TaskListCommon>(getContext(), true) {
                            @Override
                            protected void onDone(TaskListCommon strData) {
                                getListener().onSuccess(getTag(), strData);
                            }

                            @Override
                            public void onResultError(ResultException ex) {
                                getListener().onFailure(getTag(), "异常");
                            }
                        });
                break;

            case "get_tasks":
                getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                        .getTaskList2(uid,uid,marryDate)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbsAPICallback<TaskListCommon>(getContext(), true) {
                            @Override
                            protected void onDone(TaskListCommon strData) {
                                getListener().onSuccess(getTag(), strData);
                            }

                            @Override
                            public void onResultError(ResultException ex) {
                                getListener().onFailure(getTag(), "异常");
                            }
                        });
                break;

            case "get_overtasks_date":
                getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                        .getTaskList3(uid,uid,marryDate)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new AbsAPICallback<TaskListCommon>(getContext(), true) {
                            @Override
                            protected void onDone(TaskListCommon strData) {
                                getListener().onSuccess(getTag(), strData);
                            }

                            @Override
                            public void onResultError(ResultException ex) {
                                getListener().onFailure(getTag(), "异常");
                            }
                        });
                break;

        }

    }

}
