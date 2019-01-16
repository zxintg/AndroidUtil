package com.zxin.marry.mvp.model;

import android.text.TextUtils;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.Entity;
import com.zxin.marry.bean.MarryProductForm;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.marry.bean.ShopInformation;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import com.zxin.zxinlib.util.SharedPreferencesManager;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class DiscoveryModel extends BaseModel {

    /******
     * 详情
     */
    public void checkCity(String cityName) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .checkCity(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<Entity>(getContext(), true) {
                    @Override
                    protected void onDone(Entity strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getNationwideDatas(String cityId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getNationwideDatas(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MarryProductForm>(getContext(), true) {
                    @Override
                    protected void onDone(MarryProductForm strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getDiscoveryCityDatas(String cityId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getDiscoveryCityDatas(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShopClassBean>(getContext(), true) {
                    @Override
                    protected void onDone(ShopClassBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getShopListBanner(String sc_id,String cityId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getShopListBanner(sc_id,cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RecommendForm>(getContext(), true) {
                    @Override
                    protected void onDone(RecommendForm strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getShopGoodsList(int page, String pagetime, String sc_id,String cityid) {
            getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                    .getShopGoodsList(page, "up", pagetime, "10", sc_id,cityid)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new AbsAPICallback<ShopInformation>(getContext(), true) {
                        @Override
                        protected void onDone(ShopInformation strData) {
                            getListener().onSuccess(getTag(), strData);
                        }

                        @Override
                        public void onResultError(ResultException ex) {
                            getListener().onFailure(getTag(), "异常");
                        }
                    });
    }

    public void getShopCaseList(int page, String pagetime, String sc_id,String cityid) {
            getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                    .getShopCaseList(page, "up", pagetime, "10", sc_id,cityid)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new AbsAPICallback<ShopInformation>(getContext(), true) {
                        @Override
                        protected void onDone(ShopInformation strData) {
                            getListener().onSuccess(getTag(), strData);
                        }

                        @Override
                        public void onResultError(ResultException ex) {
                            getListener().onFailure(getTag(), "异常");
                        }
                    });
    }

    public void getShopList(int page, String pagetime, String areaid, String sc_id,String cityid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getShopList(page, "up", pagetime, "10", areaid, sc_id,cityid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShopInformation>(getContext(), true) {
                    @Override
                    protected void onDone(ShopInformation strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }
}
