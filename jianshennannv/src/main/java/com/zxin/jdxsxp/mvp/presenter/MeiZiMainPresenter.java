package com.zxin.jdxsxp.mvp.presenter;

import android.os.Handler;
import android.view.View;
import com.zxin.jdxsxp.bean.MeiZuHome;
import com.zxin.jdxsxp.bean.MeiZuHot;
import com.zxin.jdxsxp.mvp.model.MeiZiMainModel;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.jdxsxp.util.MeiZiIntegerUtil;
import com.zxin.jdxsxp.util.TitleBarUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MeiZiMainPresenter extends BasePresenter<MeiZiMainContract, MeiZiMainModel> implements MvpCallback{

    public void initDatas(MeiZiMainContract.MeiZiMainView listener,Object... parameter) {
        getView().setP(this);
        getView().setBeikeSearchView(listener);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initSpecialDatas(MeiZiMainContract.SpecialView listener,Object... parameter) {
        getView().setP(this);
        getView().setSpecialView(listener);
        getView().initSpecialDatas();
        getModel().setListener(this);
    }

    public void initMNDetailDatas(MeiZiMainContract.MeiZiDeatilView listener,Object... parameter) {
        getView().setP(this);
        getView().setMeiZiDeatilView(listener);
        getView().setMNDetailParameter(parameter);
        getView().initMeiZiDeatilDatas();
        getModel().setListener(this);
    }

    public void initAnalysisDatas(MeiZiMainContract.AnalysisView listener,Object... parameter) {
        getView().setP(this);
        getView().setAnalysisView(listener);
        getView().initAnalysisDatas();
        getModel().setListener(this);
    }

    public void initWallPaperItemDatas(MeiZiMainContract.WallPaperItemView listener,Object... parameter) {
        getView().setP(this);
        getView().setWallPaperItemView(listener);
        getView().setWallPaperItemParameter(parameter);
        getView().initWallPaperItemDatas();
        getModel().setListener(this);
    }

    public void initFindDatas(MeiZiMainContract.FindView listener,Object... parameter) {
        getView().setP(this);
        getView().setFindView(listener);
        getView().initFindDatas();
        getModel().setListener(this);
    }

    public void initFindBaiDuDatas(MeiZiMainContract.FindBaiDuView listener,Object... parameter) {
        getView().setP(this);
        getView().setFindBaiDuView(listener);
        getView().setFindBaiDuParameter(parameter);
        getView().initFindBaiDuDatas();
        getModel().setListener(this);
    }

    public void initFindSouGouDatas(MeiZiMainContract.FindSouGouView listener,Object... parameter) {
        getView().setP(this);
        getView().setFindSouGouView(listener);
        getView().setFindSouGouParameter(parameter);
        getView().initFindSouGouDatas();
        getModel().setListener(this);
    }

    public void initFind360Datas(MeiZiMainContract.Find360View listener,Object... parameter) {
        getView().setP(this);
        getView().setFind360View(listener);
        getView().setFind360Parameter(parameter);
        getView().initFind360Datas();
        getModel().setListener(this);
    }

    public void initMeinvPicDetailDatas(MeiZiMainContract.MeinvPicDetailView listener,Object... parameter) {
        getView().setP(this);
        getView().setMeinvPicDetailView(listener);
        getView().setMeinvPicDetailParameter(parameter);
        getView().initMeinvPicDetailDatas();
        getModel().setListener(this);
    }

    public void getMainMeiZiApi() {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_MainMeiZiApi);
        getModel().getMainMeiZiApi();
    }

    public void getMainHotApi(int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_MainHotApi);
        getModel().getMainHotApi(pageNum);
    }

    public void getMeiNvListApi(int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_MeiNvListApi);
        getModel().getMeiNvListApi(pageNum);
    }

    public void getMeiNvDetailApi(String meiId,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_MeiNvDetailApi);
        getModel().getMeiNvDetailApi(meiId,pageNum);
    }

    public void getArticleListApi() {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_ArticleListApi);
        getModel().getArticleListApi();
    }

    public void getWallPaperItemList(String type,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_WallPaperItemApi);
        getModel().getWallPaperItemList(type,pageNum);
    }

    public void getFindBaiDuList(String keyword,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_FindBaiDuListApi);
        getModel().getFindBaiDuList(keyword,pageNum);
    }

    public void getFind360List(String keyword,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_Find360ListApi);
        getModel().getFind360List(keyword,pageNum);
    }

    public void getFindSouGouList(String keyword,int pageNum) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_FindSouGouListApi);
        getModel().getFindSouGouList(keyword,pageNum);
    }

    public void getMeiNvLocalList() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().onResulFindSuccess(TitleBarUtil.newInstance().getMeiNvLocalList());
            }
        }, 100);
    }

    public void getPicDetailList(String albumAddress) {
        getModel().setTag(MeiZiIntegerUtil.WEB_API_PicDetailList);
        getModel().getPicDetailList(albumAddress);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){
            case MeiZiIntegerUtil.WEB_API_MainMeiZiApi:
            case MeiZiIntegerUtil.WEB_API_MainHotApi:
                if (data instanceof MeiZuHome.ValueBean)
                    getView().onResultSuccess(data);
                if (data instanceof MeiZuHot.ResBean)
                    getView().onResultHotSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_MeiNvListApi:
                    getView().onResultMeiNvListSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_MeiNvDetailApi:
                    getView().onResultMeiNvDetailSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_ArticleListApi:
                    getView().onResultArticleListSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_WallPaperItemApi:
                    getView().onResulWallPaperItemSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_FindBaiDuListApi:
                    getView().onResultFindBaiDuSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_Find360ListApi:
                    getView().onResultFind360Success(data);
                break;

            case MeiZiIntegerUtil.WEB_API_FindSouGouListApi:
                    getView().onResultFindSouGouSuccess(data);
                break;

            case MeiZiIntegerUtil.WEB_API_PicDetailList:
                    getView().onResultMeinvPicDetailSuccess(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MeiZiIntegerUtil.WEB_API_MainMeiZiApi:
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
