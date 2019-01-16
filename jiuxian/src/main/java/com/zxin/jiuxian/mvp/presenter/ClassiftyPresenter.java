package com.zxin.jiuxian.mvp.presenter;

import android.view.View;
import com.zxin.jiuxian.mvp.model.ClassiftyModel;
import com.zxin.jiuxian.mvp.view.ClassiftyContract;
import com.zxin.jiuxian.util.JiuXianIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.zxinlib.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class ClassiftyPresenter extends BasePresenter<ClassiftyContract, ClassiftyModel> implements MvpCallback{

  public void initDatas(ClassiftyContract.ClassifyView listener, Object... parameter) {
        getView().setP(this);
        getView().setClassifyView(listener);
        getView().initDatas();
        getModel().setListener(this);
    }

  public void initClassifyItemDatas(ClassiftyContract.ClassifyItemView listener, Object... parameter) {
        getView().setP(this);
        getView().setClassifyItemView(listener);
        getView().setClassifyItemParameter(parameter);
        getView().initClassifyItemDatas();
        getModel().setListener(this);
    }

  public void initClassifyAllDatas(ClassiftyContract.ClassifyAllView listener, Object... parameter) {
        getView().setP(this);
        getView().setClassifyAllView(listener);
        getView().initClassifyAllDatas();
        getModel().setListener(this);
    }

    public void getCategoryList(){
        getModel().setTag(JiuXianIntegerUtil.WEB_API_CategoryList);
        getModel().getCategoryList();
    }

    public void getCategoryAllDetail(String cateId){
        getModel().setTag(JiuXianIntegerUtil.WEB_API_CategoryDetail);
        getModel().getCategoryDetail(cateId);
    }

    public void getCategoryDetail(String cateId){
        getModel().setTag(JiuXianIntegerUtil.WEB_API_CategoryItemDetail);
        getModel().getCategoryDetail(cateId);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){

            case JiuXianIntegerUtil.WEB_API_CategoryList:
                getView().onResultSuccess(data);
                break;

            case JiuXianIntegerUtil.WEB_API_CategoryDetail:
                getView().onResultClassifyAllSuccess(data);
                break;

            case JiuXianIntegerUtil.WEB_API_CategoryItemDetail:
                getView().onResultClassifyItemSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case JiuXianIntegerUtil.WEB_API_CategoryList:
                ToastUtil.showShort(msg);
                break;
            case JiuXianIntegerUtil.WEB_API_CategoryDetail:
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
