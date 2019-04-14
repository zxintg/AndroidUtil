package com.zxin.jdxsxp.mvp.presenter;

import android.view.View;
import com.zxin.jdxsxp.mvp.model.XiGuaMeiTuModel;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.jdxsxp.util.MeiNvPicturePreferences;
import com.zxin.jdxsxp.util.MeiZiIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.Md5Util;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class XiGuaMainPresenter extends BasePresenter<XiGuaMainContract, XiGuaMeiTuModel> implements MvpCallback{

    public void initUserLoginDatas(XiGuaMainContract.UserLoginView listener,Object... parameter) {
        getView().setP(this);
        getView().setUserLoginView(listener);
        getView().initUserLoginDatas();
        getModel().setListener(this);
    }

    public void initDatas(XiGuaMainContract.XiGuaMainView listener,Object... parameter) {
        getView().setP(this);
        getView().setXiGuaMainView(listener);
        getModel().setListener(this);
    }

    public void initXiGuaItemDatas(XiGuaMainContract.XiGuaMainItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setParameter(parameter);
        getView().setXiGuaMainItemView(listener);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initUserInfoDatas(XiGuaMainContract.UserInfoView listener,Object... parameter) {
        getView().setP(this);
        getView().setUserInfoView(listener);
        getView().initUserInfoDatas();
        getModel().setListener(this);
    }

    public void initUserAttenDatas(XiGuaMainContract.UserAttenView listener,Object... parameter) {
        getView().setP(this);
        getView().setUserAttenParameter(parameter);
        getView().setUserAttenView(listener);
        getView().initUserAttenDatas();
        getModel().setListener(this);
    }

    public void initUserDynamicDatas(XiGuaMainContract.UserDynamicView listener,Object... parameter) {
        getView().setP(this);
        getView().setUserDynamicParameter(parameter);
        getView().setUserDynamicView(listener);
        getView().initUserDynamicDatas();
        getModel().setListener(this);
    }

    public void initVideoItemDatas(XiGuaMainContract.VideoItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setVideoItemParameter(parameter);
        getView().setVideoItemView(listener);
        getView().initVideoItemDatas();
        getModel().setListener(this);
    }

    public void initHPlayerDatas(XiGuaMainContract.HPlayerView listener,Object... parameter) {
        getView().setP(this);
        getView().setHPlayerParameter(parameter);
        getView().setHPlayerView(listener);
        getView().initHPlayerDatas();
        getModel().setListener(this);
    }

    public void initSearchMeiTuDatas(XiGuaMainContract.SearchMeiTuView listener,Object... parameter) {
        getView().setP(this);
        getView().setSearchMeiTuView(listener);
        getView().initSearchMeiTuDatas();
        getModel().setListener(this);
    }

    public void initSearchItemDatas(XiGuaMainContract.SearchItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setSearchItemParameter(parameter);
        getView().setSearchItemView(listener);
        getView().initSearchItemDatas();
        getModel().setListener(this);
    }

    public void searchItemDatasNotify(String keyWord) {
        getView().searchItemDatasNotify(keyWord);
    }

    public void getHomeTagList() {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_HOME_TAG_ALBUM);
        getModel().getHomeTagList();
    }

    public void userLogin(String phone,String passwd) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_UserLogin);
        getModel().userLogin(phone, Md5Util.md5Password(passwd));
    }

    public void getHomeList(int tagId,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_HOME_ALBUM);
        getModel().getHomeList(tagId,pageNum);
    }

    public void getUserInfo(int userId) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_UserInfo);
        getModel().getUserInfo(userId);
    }

    public void getUserAttenList(int toUserId,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_UserAttenList);
        getModel().getUserAttenList(toUserId,pageNum);
    }

    public void getUserDynamicList(int toUserId,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_UserDynamicList);
        getModel().getUserDynamicList(toUserId,pageNum);
    }

    public void getVideoItemList(int tagId,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_VideoItemList);
        getModel().getVideoItemList(tagId,pageNum);
    }

    public void getBrowseVideo(int albumId) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_BrowseVideo);
        getModel().getBrowseVideo(albumId);
    }

    public void getAlbumUserList(int albumId) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_AlbumUserList);
        getModel().getAlbumUserList(albumId,1);
    }

    public void getCommentsList(int albumId,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_CommentsList);
        getModel().getCommentsList(albumId,pageNum);
    }

    public void getAlbumDetail(int albumId) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_AlbumDetail);
        getModel().getAlbumDetail(albumId);
    }

    public void getHotTagsList() {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_HistoryTagsList);
        getModel().getHotTagsList();
    }

    public void getSearchItemList(int searchTag,String keyWord,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_SearchItemList);
        getModel().getSearchItemList(searchTag,keyWord,pageNum);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MeiZiIntegerUtil.WEB_API_UserLogin:
                getView().onResultLoginSuccess(data);
                break;
            case MeiZiIntegerUtil.WEB_API_HOME_TAG_ALBUM:
                getView().onResultSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_HOME_ALBUM:
                getView().onResultMeiNvListSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_UserInfo:
                getView().onResultUserInfoSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_UserAttenList:
                getView().onResultUserAttenSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_UserDynamicList:
                getView().onResultUserDynamicSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_VideoItemList:
                getView().onResultVideoItemSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_BrowseVideo:
            case MeiZiIntegerUtil.WEB_API_AlbumDetail:
            case MeiZiIntegerUtil.WEB_API_AlbumUserList:
            case MeiZiIntegerUtil.WEB_API_CommentsList:
                getView().onResultBrowseVideoSuccess(data);
                break;
            case MeiZiIntegerUtil.WEB_API_HistoryTagsList:
                getView().onResultHistoryTagsSuccess(data);
                break;
            case MeiZiIntegerUtil.WEB_API_SearchItemList:
                getView().onResultSearchItemSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MeiZiIntegerUtil.WEB_API_HOME_TAG_ALBUM:
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
        getView().OnClick(v);
    }

}
