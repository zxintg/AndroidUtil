package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.bean.CityForm;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.mvp.model.DiscoveryModel;
import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class DiscoveryPresenter extends BasePresenter<MainDiscoveryContract, DiscoveryModel> implements MvpCallback{

    public void initDatas(MainDiscoveryContract.DiscoveryView listener,Object... parameter) {
        getView().setP(this);
        getView().setDiscoveryViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initNationwideDatas(MainDiscoveryContract.NationwideView listener,Object... parameter) {
        getView().setP(this);
        getView().setNationwideViewListener(listener);
        getView().setNationwideViewParameter(parameter);
        getView().initNationwideViewDatas();
        getModel().setListener(this);
    }

    public void initDiscoveryCityDatas(MainDiscoveryContract.DiscoveryCityView listener,Object... parameter) {
        getView().setP(this);
        getView().setDiscoveryCityViewListener(listener);
        getView().setDiscoveryCityParameter(parameter);
        getView().initDiscoveryCityDatas();
        getModel().setListener(this);
    }

    public void initShopListDatas(MainDiscoveryContract.ShopListView listener,Object... parameter) {
        getView().setP(this);
        getView().setShopListViewListener(listener);
        getView().setShopListViewParameter(parameter);
        getView().initShopListViewDatas();
        getModel().setListener(this);
    }

    public void initShopComboDatas(MainDiscoveryContract.ShopComboView listener,Object... parameter) {
        getView().setP(this);
        getView().setShopComboViewListener(listener);
        getView().setShopComboViewParameter(parameter);
        getView().initShopComboViewDatas();
        getModel().setListener(this);
    }

    public void initShopCaseDatas(MainDiscoveryContract.ShopCaseView listener,Object... parameter) {
        getView().setP(this);
        getView().setShopCaseViewListener(listener);
        getView().setShopCaseViewParameter(parameter);
        getView().initShopCaseViewDatas();
        getModel().setListener(this);
    }

    public void initShopBusinessDatas(MainDiscoveryContract.ShopBusinessView listener,Object... parameter) {
        getView().setP(this);
        getView().setShopBusinessViewListener(listener);
        getView().setShopBusinessViewParameter(parameter);
        getView().initShopBusinessViewDatas();
        getModel().setListener(this);
    }

    public void getCheckedCity(String cityName) {
        getModel().setTag(MarryIntegerUtil.WEB_API_CheckedCity);
        getModel().checkCity(cityName);
    }

    public void modifyDiscovery(CityForm.City city) {
        getView().modifyDiscovery(city);
    }

    public void getNationwideDatas(String cityid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_NationwideDatas);
        getModel().getNationwideDatas(cityid);
    }

    public void getDiscoveryCityDatas(String cityid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_DiscoveryCity);
        getModel().getDiscoveryCityDatas(cityid);
    }

    public void getDiscoveryCityCheckedCity(String cityName) {
        getModel().setTag(MarryIntegerUtil.WEB_API_DiscoveryCityCheckedCity);
        getModel().checkCity(cityName);
    }

    public void getShopListBanner(String sc_id,String cityId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ShopListBanner);
        getModel().getShopListBanner(sc_id,cityId);
    }

    public void getShopComboList(int page,String pagetime,String sc_id,String cityid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ShopComboList);
        getModel().getShopGoodsList(page,pagetime,sc_id,cityid);
    }

    public void getShopCaseList(int page,String pagetime,String sc_id,String cityid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ShopCaseList);
        getModel().getShopCaseList(page,pagetime,sc_id,cityid);
    }

    public void getShopBusinessList(int page,String pagetime,String areaid,String sc_id,String cityid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ShopBusinessList);
        getModel().getShopList(page,pagetime,areaid,sc_id,cityid);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_CheckedCity:
                getView().onResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_NationwideDatas:
                getView().onResultNationwideDatasSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_DiscoveryCity:
                getView().onResultDiscoveryCitySuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_DiscoveryCityCheckedCity:
                getView().onResultDiscoveryCityCheckedCitySuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ShopListBanner:
            case MarryIntegerUtil.WEB_API_ShopComboList:
                if (data instanceof RecommendForm)
                    getView().onResultShopListBannerSuccess(data);
                else
                    getView().onResultShopComboListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ShopCaseList:
                    getView().onResultShopCaseListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ShopBusinessList:
                    getView().onResultShopBusinessListSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_CheckedCity:
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
