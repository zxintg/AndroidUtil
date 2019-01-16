package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.ArticlesBean;
import com.zxin.marry.bean.PostsInfoBean;
import com.zxin.marry.bean.ShopCaseBean;
import com.zxin.marry.bean.ShopDetails;
import com.zxin.marry.bean.ShopGoodsBean;
import com.zxin.marry.bean.StoreCommentList;
import com.zxin.marry.bean.TermsBean;
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

public class ShopModel extends BaseModel {

    /******
     * 详情
     */
    public void getShopDetail(String uid,String store_id) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getShopDetail(uid, store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShopDetails>(getContext(), true) {
                    @Override
                    protected void onDone(ShopDetails strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getStoreGoodsList(String store_id) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getStoreGoodsList(store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShopGoodsBean>(getContext(), true) {
                    @Override
                    protected void onDone(ShopGoodsBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getStoreCaseList(String store_id) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getStoreCaseList(store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShopCaseBean>(getContext(), true) {
                    @Override
                    protected void onDone(ShopCaseBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getStoreCommentList(String store_id) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getStoreCommentList(store_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<StoreCommentList>(getContext(), true) {
                    @Override
                    protected void onDone(StoreCommentList strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

}
