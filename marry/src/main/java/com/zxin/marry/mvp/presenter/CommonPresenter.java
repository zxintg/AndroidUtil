package com.zxin.marry.mvp.presenter;

import android.view.View;
import com.zxin.marry.mvp.model.CommonModel;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class CommonPresenter extends BasePresenter<CommonContract, CommonModel> implements MvpCallback{

    public void initDatas(CommonContract.WeComeView listener,Object... parameter) {
        getView().setP(this);
        getView().setWeComeViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initServiceCenterDatas(CommonContract.ServiceCenterView listener,Object... parameter) {
        getView().setP(this);
        getView().setServiceCenterViewListener(listener);
        getView().setParameter(parameter);
        getModel().setListener(this);
    }

    public void initSceneDetailsDatas(CommonContract.SceneDetailsView listener, Object... parameter){
        getView().setP(this);
        getView().setSceneDetailsViewListener(listener);
        getView().setSceneDetailsParameter(parameter);
        getView().initSceneDetailsDatas();
        getModel().setListener(this);
    }

    public void initCityListDatas(CommonContract.CityListView listener ,Object... parameter){
        getView().setP(this);
        getView().setCityListViewListener(listener);
        getView().setCityListViewParameter(parameter);
        getView().initCityListViewDatas();
        getModel().setListener(this);
    }

    public void initCollectionItemDatas(CommonContract.MineCollectView listener ,Object... parameter){
        getView().setP(this);
        getView().setMineCollectViewListener(listener);
        getView().setMineCollectViewParameter(parameter);
        getView().initMineCollectViewDadas();
        getModel().setListener(this);
    }

    public void initShippingAddressDatas(CommonContract.MineAddressView listener ,Object... parameter){
        getView().setP(this);
        getView().setMineAddressViewListener(listener);
        getView().initMineAddressViewDadas();
        getModel().setListener(this);
    }

    public void initAddShippingAddressDatas(CommonContract.AddressModifyView listener ,Object... parameter){
        getView().setP(this);
        getView().setAddressModifyViewListener(listener);
        getView().initAddressModifyViewParameter(parameter);
        getView().initAddressModifyViewDadas();
        getModel().setListener(this);
    }

    public void initMarriedProcessDatas(CommonContract.MarriProcessView listener ,Object... parameter){
        getView().setP(this);
        getView().setMarriProcessViewListener(listener);
        getModel().setListener(this);
    }

    public void openCitystartLoacl() {
        getView().startLoacl();
    }

    public void stopLoacl() {
        getView().stopLoacl();
    }

    public void getCheckedCity(String cityName) {
        getModel().setTag(MarryIntegerUtil.WEB_API_CheckedCity);
        getModel().checkCity(cityName);
    }

    public void getTencentAds() {
        getModel().setTag(MarryIntegerUtil.WEB_API_MarryADs);
        getModel().getAdsList();
    }

    public void getServiceCenterDatas(String orderid, String shopid) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ServiceCenter);
        getModel().getServiceCenterDatas(SharedPreferencesManager.getMarryUid(),shopid);
    }

    public void getAddressList() {
        getModel().setTag(MarryIntegerUtil.WEB_API_AddressList);
        getModel().getAddressList(SharedPreferencesManager.getMarryUid());
    }

    public void setAddressDefault(String addressId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_setAddressDefault);
        getModel().setAddressDefault(SharedPreferencesManager.getMarryUid(),addressId);
    }

    public void deleteAddress(String addressId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_DeleteAddress);
        getModel().deleteAddress(SharedPreferencesManager.getMarryUid(),addressId);
    }

    public void addAddress(String name,String phone,String info,String address,String isDefault) {
        getModel().setTag(MarryIntegerUtil.WEB_API_AddAddress);
        getModel().addAddress(SharedPreferencesManager.getMarryUid(),name,phone,info,address,isDefault);
    }

    public void modifyAddress(String addressId,String name,String phone,String info,String address,String isDefault) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ModifyAddress);
        getModel().modifyAddress(SharedPreferencesManager.getMarryUid(),name,phone,info,address,isDefault,addressId);
    }

    public void upDatasSeneCollect(String mOrderId, String mShopid, String mLineId, String sceneid, String flag) {
        getModel().setTag(MarryIntegerUtil.WEB_API_UpDatasSeneCollect);
        switch (flag){
            case "收藏":
                getModel().updatasSeneCollect(SharedPreferencesManager.getMarryUid(),mOrderId,mShopid,mLineId,sceneid,"1");
                break;

            case "取消收藏":
                getModel().updatasSeneCollect(SharedPreferencesManager.getMarryUid(),mOrderId,mShopid,mLineId,sceneid,"2");
                break;
        }
    }

    public void getCityList() {
        getModel().setTag(MarryIntegerUtil.WEB_API_CityList);
        getModel().getCityList();
    }

    public void getCollectList(String fav_type) {
        getModel().setTag(MarryIntegerUtil.WEB_API_CollectList);
        getModel().getCollectList(fav_type,SharedPreferencesManager.getMarryUid());
    }

    public void getMarriProcess() {
        getModel().setTag(MarryIntegerUtil.WEB_API_MarriProcess);
        getModel().getMarriProcess();
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){

            case MarryIntegerUtil.WEB_API_CheckedCity:
                getView().onResultCheckedCitySuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_MarryADs:
                getView().onAdsResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ServiceCenter:
                getView().onResultServiceCenterSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_UpDatasSeneCollect:
                getView().onResultUpdatasSeneCollectSuccess();
                break;

            case MarryIntegerUtil.WEB_API_CityList:
                getView().onResultCityListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_CollectList:
                getView().onResultCollectListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_AddressList:
                getView().onResultAddressListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_setAddressDefault:
                ToastUtil.showShort("设置默认地址成功");
                getAddressList();
                break;

            case MarryIntegerUtil.WEB_API_DeleteAddress:
                ToastUtil.showShort("删除成功");
                getAddressList();
                break;

            case MarryIntegerUtil.WEB_API_AddAddress:
                getView().onResultAddAddressSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ModifyAddress:
                getView().onResultModifyAddressSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_MarriProcess:
                getView().onResultMarriProcessSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_MarryADs:
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
        getView().OnClick(v);
    }

}
