package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.CaseDetailsBean;
import com.zxin.marry.bean.CollectionBean;
import com.zxin.marry.bean.GoodsDetailsBean;
import com.zxin.marry.bean.MarryProductForm;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import com.zxin.zxinlib.util.SharedPreferencesManager;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class ProductModel extends BaseModel {

    /******
     * 商品列表
     */
    public void getProductList(String goodtypeid,int page,String pagetime) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getProductList(goodtypeid,page,pagetime,"15")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MarryProductForm>(getContext(), true) {
                    @Override
                    protected void onDone(MarryProductForm strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getGoodsDetails(String goodId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getGoodsDetails(goodId, SharedPreferencesManager.getMarryUid())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<GoodsDetailsBean>(getContext(), true) {
                    @Override
                    protected void onDone(GoodsDetailsBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void inPutCart(String goodId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .inPutCart(goodId,"1",SharedPreferencesManager.getMarryUid())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CollectionBean>(getContext(), true) {
                    @Override
                    protected void onDone(CollectionBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void setCollection(String goodId,String isCancel) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .setCollection(goodId,isCancel,SharedPreferencesManager.getMarryUid())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CollectionBean>(getContext(), true) {
                    @Override
                    protected void onDone(CollectionBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getShopCaseDetails(String caseId,String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getShopCaseDetails(caseId,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CaseDetailsBean>(getContext(), true) {
                    @Override
                    protected void onDone(CaseDetailsBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
