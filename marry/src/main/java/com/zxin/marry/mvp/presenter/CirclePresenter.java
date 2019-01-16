package com.zxin.marry.mvp.presenter;

import android.view.View;
import com.zxin.marry.mvp.model.CircleModel;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class CirclePresenter extends BasePresenter<CircleContract, CircleModel> implements MvpCallback{

    public void initDatas(CircleContract.MainCircleView listener,Object... parameter) {
        getView().setP(this);
        getView().setMainCircleViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initHomeCircleDatas(CircleContract.HomeCircleView listener,Object... parameter) {
        getView().setP(this);
        getView().setHomeCircleViewListener(listener);
        getView().setHomeCircleViewParameter(parameter);
        getView().initHomeCircleViewDatas();
        getModel().setListener(this);
    }

    public void initHomeCircleItemDatas(CircleContract.HomeCircleItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setHomeCircleItemViewListener(listener);
        getView().setHomeCircleItemViewParameter(parameter);
        getView().initHomeCircleItemViewDatas();
        getModel().setListener(this);
    }

    public void initSubjectListDatas(CircleContract.SubjectListView listener,Object... parameter) {
        getView().setP(this);
        getView().setSubjectListViewListener(listener);
        getView().initSubjectListViewDatas();
        getModel().setListener(this);
    }

    public void initSubjectDetailDatas(CircleContract.SubjectDetailView listener,Object... parameter) {
        getView().setP(this);
        getView().setSubjectDetailViewListener(listener);
        getView().setSubjectDetailParameter(parameter);
        getView().initSubjectDetailViewDatas();
        getModel().setListener(this);
    }

    public void getCircleList(int pageNum) {
        getModel().setTag(MarryIntegerUtil.WEB_API_CircleList);
        getModel().getCircleList(pageNum);
    }

    public void getHomeCircleList(Integer pageNum,String pageType,String pagetime,String circle_id,String thclass_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_HomeCircleList);
        getModel().getHomeCircleList(pageNum,pageType,pagetime,circle_id,thclass_id);
    }

    public void getCircleItemList(Integer pageNum,String pageType,String pagetime,String circle_id,String thclass_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_CircleItemList);
        getModel().getHomeCircleList(pageNum,pageType,pagetime,circle_id,thclass_id);
    }

    public void checkNick() {
        getModel().setTag(MarryIntegerUtil.WEB_API_CheckNick);
        getModel().checkNick(SharedPreferencesManager.getMarryUid());
    }

    public void getSubjectList(int pageNum,String pageType,String pagetime) {
        getModel().setTag(MarryIntegerUtil.WEB_API_SubjectList);
        getModel().getSubjectList(pageNum,pageType,pagetime);
    }

    public void getSubjectDetail(String topicid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_SubjectDetail);
        getModel().getSubjectDetail(topicid);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_CircleList:
                getView().onResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_HomeCircleList:
                getView().onResultHomeCircleListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_CircleItemList:
                getView().onResultCircleItemListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_CheckNick:
                getView().onResultCheckNickSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_SubjectList:
                getView().onResultSubjectListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_SubjectDetail:
                getView().onResultSubjectDetailSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_CircleList:
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

    }

}
