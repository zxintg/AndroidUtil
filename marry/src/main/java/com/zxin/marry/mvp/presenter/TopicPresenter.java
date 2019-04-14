package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class TopicPresenter extends BasePresenter<MainTopicContract, TopicModel> implements MvpCallback{

    public void initDatas(MainTopicContract.MainTopicView listener,Object... parameter) {
        getView().setP(this);
        getView().setMainTopicViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initMineTopicViewDatas(MainTopicContract.MineTopicView listener,Object... parameter) {
        getView().setP(this);
        getView().setMineTopicViewListener(listener);
        getView().setMineTopicViewParameter(parameter);
        getView().initMineTopicViewDatas();
        getModel().setListener(this);
    }

    public void initHotNewsDetailDatas(MainTopicContract.HotNewsDetailView listener,Object... parameter) {
        getView().setP(this);
        getView().setHotNewsDetailViewListener(listener);
        getView().setHotNewsDetailViewParameter(parameter);
        getView().initHotNewsDetailViewDatas();
        getModel().setListener(this);
    }

    public void initHotNewsViewDatas(MainTopicContract.HotNewsView listener,Object... parameter) {
        getView().setP(this);
        getView().setHotNewsViewListener(listener);
        getModel().setListener(this);
    }

    public void initHotNewsItemDatas(MainTopicContract.HotNewsItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setHotNewsItemViewListener(listener);
        getView().setHotNewsItemViewParameter(parameter);
        getView().initHotNewsItemViewDatas();
        getModel().setListener(this);
    }

    public void getTopicDetail(String themeId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_TopicDetail);
        getModel().getTopicDetail(SharedPreferencesManager.getMarryUid(),themeId);
    }

    public void getMineTopicList(String type,int pageNum,String pagetime,String pagetype) {
        getModel().setTag(MarryIntegerUtil.WEB_API_MineTopicList);
        getModel().getMineTopicList(SharedPreferencesManager.getMarryUid(),type,pagetype,pageNum,pagetime);
    }

    public void getPostsInfo(String posts_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_PostsInfo);
        getModel().getPostsInfo(posts_id);
    }

    public void getHontNewsMenus() {
        getModel().setTag(MarryIntegerUtil.WEB_API_HontNewsMenus);
        getModel().getHontNewsMenus();
    }

    public void getHontNewsList(String term_id,int pageNum,String pagetype,String pagetime) {
        getModel().setTag(MarryIntegerUtil.WEB_API_HontNewsList);
        getModel().getHontNewsList(term_id,pageNum,pagetype,pagetime);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){

            case MarryIntegerUtil.WEB_API_TopicDetail:
                getView().onResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_MineTopicList:
                getView().onResultMineTopicListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_PostsInfo:
                getView().onResultPostsInfoSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_HontNewsMenus:
                getView().onResultHotNewsMenusSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_HontNewsList:
                getView().onResultHontNewsListSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_TopicDetail:
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
