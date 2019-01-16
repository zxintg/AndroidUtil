package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.SubjectDetailForm;
import com.zxin.marry.bean.SubjectForm;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class CircleModel extends BaseModel {

    /******
     * 圈子列表
     */
    public void getCircleList(int pageNum) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getCircleList(10,"down",pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CircleForm>(getContext(), true) {
                    @Override
                    protected void onDone(CircleForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getHomeCircleList(Integer pageNum,String pagetype,String pagetime,String circle_id,String thclass_id) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getHomeCircleList(pageNum,pagetype,pagetime,"10",circle_id,thclass_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<TopicForm>(getContext(), true) {
                    @Override
                    protected void onDone(TopicForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void checkNick(String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .checkNick(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<TopicDetailForm>(getContext(), true) {
                    @Override
                    protected void onDone(TopicDetailForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getSubjectList(int pageNum,String pageType,String pagetime) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getSubjectList(pageNum,pageType,pagetime,"10")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<SubjectForm>(getContext(), true) {
                    @Override
                    protected void onDone(SubjectForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getSubjectDetail(String topicid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getSubjectDetail(topicid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<SubjectDetailForm>(getContext(), true) {
                    @Override
                    protected void onDone(SubjectDetailForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
