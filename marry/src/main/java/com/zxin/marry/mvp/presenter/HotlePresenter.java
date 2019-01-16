package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.bean.CityForm;
import com.zxin.marry.bean.HotelListBean;
import com.zxin.marry.bean.HotelSearchBean;
import com.zxin.marry.bean.RecommendHotelBean;
import com.zxin.marry.bean.ThreeHotelBean;
import com.zxin.marry.mvp.model.CircleModel;
import com.zxin.marry.mvp.model.HotleModel;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.marry.mvp.view.HotleContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class HotlePresenter extends BasePresenter<HotleContract, HotleModel> implements MvpCallback{

    public void initFindHotleDatas(HotleContract.FindHotleView listener,Object... parameter) {
        getView().setP(this);
        getView().setFindHotleViewListener(listener);
        getView().initFindHotleViewDatas();
        getModel().setListener(this);
    }

    public void initStoreDetailsDatas(HotleContract.StoreDetailsView listener,Object... parameter) {
        getView().setP(this);
        getView().setStoreDetailsViewListener(listener);
        getView().setStoreDetailsViewParameter(parameter);
        getView().initStoreDetailsViewDatas();
        getModel().setListener(this);
    }

    public void initWeddingPartyDatas(HotleContract.WeddingPartyView listener,Object... parameter) {
        getView().setP(this);
        getView().setWeddingPartyViewListener(listener);
        getView().initWeddingPartyViewDatas();
        getModel().setListener(this);
    }

    public void initHotelListDatas(HotleContract.HotelListView listener,Object... parameter) {
        getView().setP(this);
        getView().setHotelListViewListener(listener);
        getView().setHotelListViewParameter(parameter);
        getView().initHotelListViewDatas();
        getModel().setListener(this);
    }

    public void initHallDetailsDatas(HotleContract.HallDetailsView listener,Object... parameter) {
        getView().setP(this);
        getView().setHallDetailsViewListener(listener);
        getView().setHallDetailsViewParameter(parameter);
        getView().initHallDetailsViewDatas();
        getModel().setListener(this);
    }

    public void initBanquetMoreHallDatas(HotleContract.BanquetHallView listener,Object... parameter) {
        getView().setP(this);
        getView().setBanquetHallViewListener(listener);
        getView().setBanquetHallViewParameter(parameter);
        getView().initBanquetHallViewDatas();
        getModel().setListener(this);
    }

    public void initHotelMoreCaseDatas(HotleContract.CaseListView listener,Object... parameter) {
        getView().setP(this);
        getView().setCaseListViewListener(listener);
        getView().setCaseListViewParameter(parameter);
        getView().initCaseListViewDatas();
        getModel().setListener(this);
    }

    public void initHotelMoreDishsDatas(HotleContract.DishsListView listener,Object... parameter) {
        getView().setP(this);
        getView().setDishsListViewListener(listener);
        getView().setDishsListViewParameter(parameter);
        getView().initDishsListViewDatas();
        getModel().setListener(this);
    }

    public void getFindHotleDetail() {
        getModel().setTag(MarryIntegerUtil.WEB_API_FindHotleDetail);
        getModel().getFindHotleDetail();
    }

    public void getRecommendHotelList() {
        getModel().setTag(MarryIntegerUtil.WEB_API_RecommendHotelList);
        getModel().getRecommendHotelList(SharedPreferencesManager.getMarryCity(CityForm.City.class).getFeastid());
    }

    public void getWeddingDetail(String hotelId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_WeddingDetail);
        getModel().getWeddingDetail(hotelId);
    }

    public void getWeddingParty() {
        getModel().setTag(MarryIntegerUtil.WEB_API_WeddingMain);
        getModel().getWeddingMain(SharedPreferencesManager.getMarryCity(CityForm.City.class).getFeastid());
    }

    public void getHotelList(String areaid,String optionsite_id,String price_sort,String optionsiteid, String optiontableid,String optionpriceid,String area_id,String table_max,int pageNum,String pageType,String pagetime) {
        getModel().setTag(MarryIntegerUtil.WEB_API_HotelList);
        getModel().getHotelList(SharedPreferencesManager.getMarryCity(CityForm.City.class).getFeastid(),areaid,optionsite_id,price_sort,optionsiteid,optiontableid,optionpriceid,area_id,table_max,pageNum,pageType,pagetime);
    }

    public void getHoteSearch() {
        getModel().setTag(MarryIntegerUtil.WEB_API_HoteSearch);
        getModel().getHoteSearch(SharedPreferencesManager.getMarryCity(CityForm.City.class).getFeastid());
    }

    public void getBanquetHallDetails(String id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_BanquetHallDetails);
        getModel().getBanquetHallDetails(id);
    }

    public void getBanquetMoreList(String hotelId,int pageNum,String pageType,String pagetime) {
        getModel().setTag(MarryIntegerUtil.WEB_API_BanquetMore);
        getModel().getBanquetMoreList(hotelId,pageNum,pageType,pagetime);
    }

    public void getCaseMoreList(String hotelId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_CaseMore);
        getModel().getCaseMoreList(hotelId);
    }

    public void getDishsMoreList(String hotelId,int pageNum,String pageType,String pagetime) {
        getModel().setTag(MarryIntegerUtil.WEB_API_DishsMore);
        getModel().getDishsMoreList(hotelId,pageNum,pageType,pagetime);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_FindHotleDetail:
            case MarryIntegerUtil.WEB_API_RecommendHotelList:
                if (data instanceof ThreeHotelBean)
                    getView().onResultFindHotleDetailSuccess(data);
                else if (data instanceof RecommendHotelBean)
                    getView().onResultRecommendHotelListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_WeddingDetail:
                getView().onResultWeddingDetailSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_WeddingMain:
                getView().onResultWeddingPartySuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_HotelList:
            case MarryIntegerUtil.WEB_API_HoteSearch:
                if (data instanceof HotelListBean)
                    getView().onResultHotelListSuccess(data);
                else if (data instanceof HotelSearchBean)
                    getView().onResultHoteSearchSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_BanquetHallDetails:
                getView().onResultBanquetHallDetailsSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_BanquetMore:
                getView().onResultBanquetHallMoreSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_CaseMore:
                getView().onResultCaseListMoreSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_DishsMore:
                getView().onResultDishsListMoreSuccess(data);
                break;

        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_CircleList:
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
