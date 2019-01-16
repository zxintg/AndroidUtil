package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.mvp.model.ShopModel;
import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.mvp.view.ShopContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ShopPresenter extends BasePresenter<ShopContract, ShopModel> implements MvpCallback{

    public void initShopDetailsDatas(ShopContract.MainTopicView listener, Object... parameter) {
        getView().setP(this);
        getView().setMainTopicViewListener(listener);
        getView().setMainTopicViewParameter(parameter);
        getView().initMainTopicViewDatas();
        getModel().setListener(this);
    }

    public void initGoodsListDatas(ShopContract.GoodsListView listener, Object... parameter) {
        getView().setP(this);
        getView().setGoodsListViewListener(listener);
        getView().setGoodsListViewParameter(parameter);
        getView().initGoodsListViewDatas();
        getModel().setListener(this);
    }

    public void initShopCaseDatas(ShopContract.ShopCaseView listener, Object... parameter) {
        getView().setP(this);
        getView().setShopCaseViewListener(listener);
        getView().setShopCaseViewParameter(parameter);
        getView().initShopCaseViewDatas();
        getModel().setListener(this);
    }

    public void initCommentListDatas(ShopContract.ShopCommentView listener, Object... parameter) {
        getView().setP(this);
        getView().setShopCommentViewListener(listener);
        getView().setShopCommentViewParameter(parameter);
        getView().initShopCommentViewDatas();
        getModel().setListener(this);
    }

    public void getShopDetail(String store_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ShopDetail);
        getModel().getShopDetail(SharedPreferencesManager.getMarryUid(),store_id);
    }

    public void getStoreGoodsList(String store_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_StoreGoodsList);
        getModel().getStoreGoodsList(store_id);
    }

    public void getStoreCaseList(String store_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_StoreCaseList);
        getModel().getStoreCaseList(store_id);
    }

    public void getStoreCommentList(String store_id) {
        getModel().setTag(MarryIntegerUtil.WEB_API_StoreCommentList);
        getModel().getStoreCommentList(store_id);
    }


    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){

            case MarryIntegerUtil.WEB_API_ShopDetail:
                getView().onResultShopDetailSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_StoreGoodsList:
                getView().onResultStoreGoodsListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_StoreCaseList:
                getView().onResultShopCaseListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_StoreCommentList:
                getView().onResultShopCommentListSuccess(data);
                break;

        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
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
