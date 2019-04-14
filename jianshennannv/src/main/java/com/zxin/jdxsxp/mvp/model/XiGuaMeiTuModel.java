package com.zxin.jdxsxp.mvp.model;

import com.alibaba.fastjson.JSON;
import com.zxin.jdxsxp.api.RequestParameter;
import com.zxin.jdxsxp.api.ZXinJdxsxpApi;
import com.zxin.jdxsxp.bean.AlbumModel;
import com.zxin.jdxsxp.bean.CommentToalModel;
import com.zxin.root.bean.DynamicModel;
import com.zxin.jdxsxp.bean.HomeTagModel;
import com.zxin.jdxsxp.bean.OtherUserAlbumModel;
import com.zxin.jdxsxp.bean.OtherUserInfoTopModel;
import com.zxin.jdxsxp.bean.SearchListModel;
import com.zxin.jdxsxp.bean.SearchTagModel;
import com.zxin.jdxsxp.bean.UserAlbumModel;
import com.zxin.jdxsxp.bean.UserModel;
import com.zxin.jdxsxp.bean.ViewResult;
import com.zxin.jdxsxp.util.MeiNvPicturePreferences;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class XiGuaMeiTuModel extends BaseModel {

    public void getHomeTagList() {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("type","1");
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getHomeTagList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<HomeTagModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<HomeTagModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getHomeList(int tagId,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("type","1");
        parameter.put("tagId",String.valueOf(tagId));
        parameter.put("size","20");
        if (MeiNvPicturePreferences.getUserInfos()!=null){
            parameter.put("userId", String.valueOf(MeiNvPicturePreferences.getUserInfos().getUserId()));
        }
        parameter.put("page",String.valueOf(pageNum));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getHomeList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<AlbumModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<AlbumModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getUserInfo(int toUserId) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("userId",String.valueOf(MeiNvPicturePreferences.getUserId()));
        parameter.put("toUserId",String.valueOf(toUserId));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getUserInfo(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<OtherUserInfoTopModel>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<OtherUserInfoTopModel> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getUserAttenList(int toUserId,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("fromUserId",String.valueOf(MeiNvPicturePreferences.getUserId()));
        parameter.put("toUserId",String.valueOf(toUserId));
        parameter.put("page",String.valueOf(pageNum));
        parameter.put("size","10");
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getUserAttenList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<OtherUserAlbumModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<OtherUserAlbumModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getUserDynamicList(int toUserId,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("userId",String.valueOf(MeiNvPicturePreferences.getUserId()));
        if (toUserId!=-1)
            parameter.put("toUserId",String.valueOf(toUserId));
        parameter.put("page",String.valueOf(pageNum));
        parameter.put("pageSize","10");
        ZXinJdxsxpApi api = getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(), ZXinJdxsxpApi.class);
        Observable<ViewResult<List<DynamicModel>>> obser = toUserId!=-1 ? api.getUserDynamicList(JSON.toJSONString(parameter)):api.getDynamicList(JSON.toJSONString(parameter));
        obser.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<DynamicModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<DynamicModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(), strData.getData());
                        else
                            getListener().onFailure(getTag(), strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), ex.getMessage());
                    }
                });
    }

    public void userLogin(String phone,String passwd) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("phone",phone);
        parameter.put("passwd",passwd);
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .userLogin(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<UserModel>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<UserModel> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getVideoItemList(int tagId,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("tagId",String.valueOf(tagId));
        parameter.put("type","2");
        parameter.put("page",String.valueOf(pageNum));
        if (MeiNvPicturePreferences.getUserInfos()!=null){
            parameter.put("userId", String.valueOf(MeiNvPicturePreferences.getUserInfos().getUserId()));
        }
        parameter.put("size",String.valueOf(20));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getVideoItemList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<AlbumModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<AlbumModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getBrowseVideo(int albumId) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("albumId",String.valueOf(albumId));
        if (MeiNvPicturePreferences.getUserInfos()!=null){
            UserModel user = MeiNvPicturePreferences.getUserInfos();
            parameter.put("userId", String.valueOf(user.getUserId()));
            parameter.put("token", user.getToken());
        }
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getBrowseVideo(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<UserAlbumModel>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<UserAlbumModel> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getAlbumUserList(int toUserId,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("fromUserId",String.valueOf(MeiNvPicturePreferences.getUserId()));
        parameter.put("toUserId",String.valueOf(toUserId));
        parameter.put("page",String.valueOf(pageNum));
        parameter.put("size",String.valueOf(10));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getAlbumUserList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<UserAlbumModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<UserAlbumModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getCommentsList(int albumId,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("albumId",String.valueOf(albumId));
        parameter.put("page",String.valueOf(pageNum));
        parameter.put("size",String.valueOf(10));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getCommentsList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<CommentToalModel>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<CommentToalModel> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getAlbumDetail(int albumId) {
        Map<String, String> parameter = RequestParameter.commonReq();
        UserModel user = MeiNvPicturePreferences.getUserInfos();
        if (user!=null){
            parameter.put("userId", String.valueOf(user.getUserId()));
        }
        parameter.put("albumId",String.valueOf(albumId));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getAlbumDetail(user.getToken(),parameter.get("userId"),JSON.toJSONString(parameter),parameter.get("version"),parameter.get("packId"),parameter.get("channel"),parameter.get("os"))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<UserAlbumModel>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<UserAlbumModel> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void updateAlbumThumb(int albumId,boolean isThumb ,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        if (MeiNvPicturePreferences.getUserInfos()!=null){
            UserModel user = MeiNvPicturePreferences.getUserInfos();
            parameter.put("userId", String.valueOf(user.getUserId()));
            parameter.put("token", user.getToken());
        }
        parameter.put("albumId",String.valueOf(albumId));
        parameter.put("type",String.valueOf(isThumb?2:1));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .updateAlbumThumb(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),true);
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    /****
     * 关注
     * @param tuid
     * @param tag
     */
    public void updateUserAtten(int tuid,boolean tag) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("fuid",String.valueOf(MeiNvPicturePreferences.getUserInfos().getUserId()));
        parameter.put("tuid",String.valueOf(tuid));
        parameter.put("type",String.valueOf(tag?2:1));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .updateUserAtten(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),true);
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    /****
     * 收藏
     * @param albumId
     * @param tag
     */
    public void updateUserCllect(int albumId,boolean tag) {
        Map<String, String> parameter = RequestParameter.commonReq();
        parameter.put("userId",String.valueOf(MeiNvPicturePreferences.getUserInfos().getUserId()));
        parameter.put("albumId",String.valueOf(albumId));
        parameter.put("type",String.valueOf(tag?2:1));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .updateUserCllect(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),true);
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getHotTagsList() {
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getHotTagsList(JSON.toJSONString(RequestParameter.commonReq()))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<List<SearchTagModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<List<SearchTagModel>> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getSearchItemList(int searchTag,String keyWord,int pageNum) {
        Map<String, String> parameter = RequestParameter.commonReq();
        if (searchTag!=0) {
            parameter.put("type",String.valueOf(searchTag));
        }
        parameter.put("userId",String.valueOf(MeiNvPicturePreferences.getUserInfos().getUserId()));
        parameter.put("keyWord",keyWord);
        parameter.put("defaultKeyWord","邻家");
        parameter.put("page",String.valueOf(pageNum));
        parameter.put("pageSize",String.valueOf(20));
        getHttpService().getZXinJdxsxpApi(StringUtils.getUrl(),ZXinJdxsxpApi.class)
                .getSearchItemList(JSON.toJSONString(parameter))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ViewResult<SearchListModel>>(getContext(), true) {
                    @Override
                    protected void onDone(ViewResult<SearchListModel> strData) {
                        if (strData.isOk())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),strData.getTips());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

}
