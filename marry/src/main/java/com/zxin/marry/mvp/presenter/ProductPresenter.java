package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.bean.CollectionBean;
import com.zxin.marry.mvp.model.ProductModel;
import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.mvp.view.ProductContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ProductPresenter extends BasePresenter<ProductContract, ProductModel> implements MvpCallback{

    public void initProductListDatas(ProductContract.ProductListView listener,Object... parameter) {
        getView().setP(this);
        getView().setProductListViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initGoodsDetailsDatas(ProductContract.GoodsDetailView listener,Object... parameter) {
        getView().setP(this);
        getView().setGoodsDetailViewListener(listener);
        getView().setGoodsDetailViewParameter(parameter);
        getView().initGoodsDetailViewDatas();
        getModel().setListener(this);
    }

    public void initShopCaseDetailsDatas(ProductContract.ShopCaseView listener,Object... parameter) {
        getView().setP(this);
        getView().setShopCaseViewListener(listener);
        getView().setShopCaseViewParameter(parameter);
        getView().initShopCaseViewDatas();
        getModel().setListener(this);
    }

    public void getProductList(String goodtypeid,int page,String pagetime) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ProductList);
        getModel().getProductList(goodtypeid,page,pagetime);
    }

    public void getGoodsDetails(String goodId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_GoodsDetails);
        getModel().getGoodsDetails(goodId);
    }

    public void inPutCart(String goodId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_InPutCart);
        getModel().inPutCart(goodId);
    }

    public void setCollection(String goodId,String isCancel) {
        getModel().setTag(MarryIntegerUtil.WEB_API_Collection);
        getModel().setCollection(goodId,isCancel);
    }

    public void getShopCaseDetails(String caseId) {
        getModel().setTag(MarryIntegerUtil.WEB_API_ShopCaseDetails);
        getModel().getShopCaseDetails(caseId,SharedPreferencesManager.getMarryUid());
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_ProductList:
                getView().onResultProductListSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_GoodsDetails:
                getView().onResultGoodsDetailsSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_InPutCart:
                ToastUtil.showShort(((CollectionBean)data).getMessage());
                break;

            case MarryIntegerUtil.WEB_API_Collection:
                getView().onResultCollectionSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ShopCaseDetails:
                getView().onResultShopCaseSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_ProductList:
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
