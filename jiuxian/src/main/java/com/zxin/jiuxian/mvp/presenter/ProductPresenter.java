package com.zxin.jiuxian.mvp.presenter;

import android.view.View;

import com.zxin.jiuxian.mvp.model.ProductModel;
import com.zxin.jiuxian.mvp.model.UserModel;
import com.zxin.jiuxian.mvp.view.ProductContract;
import com.zxin.jiuxian.mvp.view.UserContract;
import com.zxin.jiuxian.util.JiuXianIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ProductPresenter extends BasePresenter<ProductContract, ProductModel> implements MvpCallback{

  public void initDatas(ProductContract.ProductListView listener, Object... parameter) {
        getView().setP(this);
        getView().setProductListView(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

  public void initProductGoodsDatas(ProductContract.ProductGoodsView listener, Object... parameter) {
        getView().setP(this);
        getView().setProductGoodsView(listener);
        getView().initProductGoodsDatas();
        getModel().setListener(this);
    }

    public void searchProduct(int pageIndex, String startPrice,String endPrice,String orderBy,String categoryId, String attrsId, String keyword, boolean isTopTopic){
        getModel().setTag(JiuXianIntegerUtil.WEB_API_SearchProduct);
        getModel().searchProduct(pageIndex, startPrice,endPrice,orderBy,categoryId, attrsId, keyword, isTopTopic);
    }

    public void proDetail(String proId){
        getModel().setTag(JiuXianIntegerUtil.WEB_API_ProductDetail);
        getModel().proDetail(proId);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case JiuXianIntegerUtil.WEB_API_SearchProduct:
                getView().onResultSuccess(data);
                break;

            case JiuXianIntegerUtil.WEB_API_ProductDetail:
                getView().onResultProductGoodsSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case JiuXianIntegerUtil.WEB_API_SearchProduct:
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
