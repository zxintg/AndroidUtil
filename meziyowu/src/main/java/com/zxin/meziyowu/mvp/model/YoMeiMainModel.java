package com.zxin.meziyowu.mvp.model;

import com.zxin.meziyowu.api.YoWuUriUtils;
import com.zxin.meziyowu.api.ZXinYoWuApi;
import com.zxin.meziyowu.bean.YoMeiBean;
import com.zxin.meziyowu.bean.YoMeiDeatilBean;
import com.zxin.meziyowu.bean.YoMeiTagModel;
import com.zxin.meziyowu.bean.YoWuResult;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class YoMeiMainModel extends BaseModel {

    public void getYoMeiTagList() {
        getHttpService().getZXinMeiZiYoWuApi(YoWuUriUtils.Url_Web1,ZXinYoWuApi.class)
                .getHomeTagList("")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<YoWuResult<List<YoMeiTagModel>>>(getContext(), true) {
                    @Override
                    protected void onDone(YoWuResult<List<YoMeiTagModel>> strData) {
                        if (strData.isResult())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),"错误信息");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getYoMeiListByTag(int typeId,int pageNum) {
        getHttpService().getZXinMeiZiYoWuApi(YoWuUriUtils.Url_Web1,ZXinYoWuApi.class)
                .getYoMeiListByTag("0",typeId,pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<YoWuResult<List<YoMeiBean>>>(getContext(), true) {
                    @Override
                    protected void onDone(YoWuResult<List<YoMeiBean>> strData) {
                        if (strData.isResult())
                            getListener().onSuccess(getTag(),strData);
                        else
                            getListener().onFailure(getTag(),"错误信息");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getYoMeiVideoDetail(String userId,String userKey,String macid,int videoId) {
        getHttpService().getZXinMeiZiYoWuApi(YoWuUriUtils.Url_Web1,ZXinYoWuApi.class)
                .getYoMeiVideoDetail(userId,userKey,macid,videoId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<YoWuResult<YoMeiDeatilBean>>(getContext(), true) {
                    @Override
                    protected void onDone(YoWuResult<YoMeiDeatilBean> strData) {
                        if (strData.isResult())
                            getListener().onSuccess(getTag(),strData.getData());
                        else if (strData.getErrorCode()==501)
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),"错误信息");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getYoMeiDetail(String userId,String userKey,int video) {
        getHttpService().getZXinMeiZiYoWuApi(YoWuUriUtils.Url_Web1,ZXinYoWuApi.class)
                .getYoMeiDetail(userId,userKey,video)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<YoWuResult<YoMeiDeatilBean>>(getContext(), true) {
                    @Override
                    protected void onDone(YoWuResult<YoMeiDeatilBean> strData) {
                        if (strData.isResult())
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),"错误信息");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getYoMeiDetailList(int video,int pageNum) {
        getHttpService().getZXinMeiZiYoWuApi(YoWuUriUtils.Url_Web1,ZXinYoWuApi.class)
                .getYoMeiDetailList(video,pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<YoWuResult<List<YoMeiBean>>>(getContext(), true) {
                    @Override
                    protected void onDone(YoWuResult<List<YoMeiBean>> strData) {
                        if (strData.isResult())
                            getListener().onSuccess(getTag(),strData);
                        else
                            getListener().onFailure(getTag(),"错误信息");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

}
