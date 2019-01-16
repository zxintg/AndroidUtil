package com.zxin.jdxsxp.mvp.model;

import com.zxin.jdxsxp.api.JdxsxpUriUtils;
import com.zxin.jdxsxp.api.ZXinJdxsxpApi;
import com.zxin.jdxsxp.bean.ArticleListBean;
import com.zxin.jdxsxp.bean.MZPicModle;
import com.zxin.jdxsxp.bean.MeiZuHome;
import com.zxin.jdxsxp.bean.MeiZuHot;
import com.zxin.jdxsxp.bean.MeiZuMeiZiDetail;
import com.zxin.jdxsxp.bean.MeinvBaogaoBean;
import com.zxin.jdxsxp.bean.MinvBaoGaodetail;
import com.zxin.jdxsxp.bean.SearchBaiduPic;
import com.zxin.jdxsxp.bean.SearchSouGou;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class MeiZiMainModel extends BaseModel {

    public void getMainMeiZiApi() {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web1,ZXinJdxsxpApi.class)
                .getMainMeiZiApi()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MeiZuHome>(getContext(), true) {
                    @Override
                    protected void onDone(MeiZuHome strData) {
                        if (strData.getCode()==200)
                            getListener().onSuccess(getTag(),strData.getValue());
                        else
                            getListener().onFailure(getTag(),strData.getMessage());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getMainHotApi(int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web2,ZXinJdxsxpApi.class)
                .getMainHotApi(20,pageNum*20)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MeiZuHot>(getContext(), true) {
                    @Override
                    protected void onDone(MeiZuHot strData) {
                        if (strData.getCode()==0)
                            getListener().onSuccess(getTag(),strData.getRes());
                        else
                            getListener().onFailure(getTag(),strData.getMsg());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getMeiNvListApi(int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web2,ZXinJdxsxpApi.class)
                .getMeiNvListApi(20,pageNum*20)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MeiZuHot>(getContext(), true) {
                    @Override
                    protected void onDone(MeiZuHot strData) {
                        if (strData.getCode()==0)
                            getListener().onSuccess(getTag(),strData.getRes());
                        else
                            getListener().onFailure(getTag(),strData.getMsg());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getMeiNvDetailApi(String meiId,int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web2,ZXinJdxsxpApi.class)
                .getMeiNvDetailApi(meiId,20,pageNum*20)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MeiZuMeiZiDetail>(getContext(), true) {
                    @Override
                    protected void onDone(MeiZuMeiZiDetail strData) {
                        if (strData.getCode()==0)
                            getListener().onSuccess(getTag(),strData.getRes());
                        else
                            getListener().onFailure(getTag(),strData.getMsg());
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getArticleListApi() {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web3,ZXinJdxsxpApi.class)
                .getArticleListApi()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ArticleListBean>(getContext(), true) {
                    @Override
                    protected void onDone(ArticleListBean strData) {
                        if (strData.getSuccess()==1)
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),"异常");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getWallPaperItemList(String type,int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web4,ZXinJdxsxpApi.class)
                .getWallPaperItemList(type+pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<List<MeinvBaogaoBean>>(getContext(), true) {
                    @Override
                    protected void onDone(List<MeinvBaogaoBean> strData) {
                        if (strData!=null)
                            getListener().onSuccess(getTag(),strData);
                        else
                            getListener().onFailure(getTag(),"异常");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getFindBaiDuList(String keyword,int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web5,ZXinJdxsxpApi.class)
                .getFindBaiDuList(keyword,pageNum*20)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<SearchBaiduPic>(getContext(), true) {
                    @Override
                    protected void onDone(SearchBaiduPic strData) {
                        if (strData!=null)
                            getListener().onSuccess(getTag(),strData.getData());
                        else
                            getListener().onFailure(getTag(),"异常");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getFind360List(String keyword,int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web6,ZXinJdxsxpApi.class)
                .getFind360List(keyword,pageNum*20)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MZPicModle>(getContext(), true) {
                    @Override
                    protected void onDone(MZPicModle strData) {
                        if (strData!=null)
                            getListener().onSuccess(getTag(),strData.getValue());
                        else
                            getListener().onFailure(getTag(),"异常");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getFindSouGouList(String keyword,int pageNum) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web7,ZXinJdxsxpApi.class)
                .getFindSouGouList(keyword,pageNum*20)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<SearchSouGou>(getContext(), true) {
                    @Override
                    protected void onDone(SearchSouGou strData) {
                        if (strData!=null)
                            getListener().onSuccess(getTag(),strData);
                        else
                            getListener().onFailure(getTag(),"异常");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

    public void getPicDetailList(String albumAddress) {
        getHttpService().getZXinJdxsxpApi(JdxsxpUriUtils.Url_Web4,ZXinJdxsxpApi.class)
                .getPicDetailList("v4/"+albumAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MinvBaoGaodetail>(getContext(), true) {
                    @Override
                    protected void onDone(MinvBaoGaodetail strData) {
                        if (strData!=null)
                            getListener().onSuccess(getTag(),strData);
                        else
                            getListener().onFailure(getTag(),"异常");
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),ex.getMessage());
                    }
                });
    }

}
