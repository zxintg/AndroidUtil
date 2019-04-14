package com.zxin.marry.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.banner.VerticalBannerView;

/**
 * Created by Administrator on 2018/7/10.
 */

public class GoodsMoreActivity extends BaseActivity implements MainDiscoveryContract.NationwideView{
    private CityForm.City mCity;
    @InjectPresenter
    DiscoveryPresenter presenter;
    @Override
    public void initData() {
        mCity = SharedPreferencesManager.getMarryCity(CityForm.City.class);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.sdv_subject);
        presenter.initNationwideDatas(this,mCity,GoodsMoreActivity.class.getName());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_goodsmore;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.sdv_subject){
            startActivity(new Intent(mContext,SubjectListActivity.class));
        }
    }
    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_nationwide_commonlayout);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_goods_clazz);
    }

    @Override
    public SimpleDraweeView getSDVSubjectView() {
        return getViewById(R.id.sdv_subject);
    }

    @Override
    public LinearLayout getLLMarryHotView() {
        return getViewById(R.id.ll_marry_hot);
    }

    @Override
    public VerticalBannerView getVerticalBannerView() {
        return getViewById(R.id.vbv_banner);
    }
}
