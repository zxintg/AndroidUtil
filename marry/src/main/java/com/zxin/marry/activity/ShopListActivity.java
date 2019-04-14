package com.zxin.marry.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.fragment.shop.ShopBusinessFragment;
import com.zxin.marry.fragment.shop.ShopCaseFragment;
import com.zxin.marry.fragment.shop.ShopComboFragment;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class ShopListActivity extends BaseActivity implements MainDiscoveryContract.ShopListView {
    @InjectPresenter
    DiscoveryPresenter presenter;

    private String scId;
    private String name;
    private String cityId;

    @Override
    public void initData() {
        scId = getIntent().getStringExtra("sc_id");
        name = getIntent().getStringExtra("name");
        cityId = getIntent().getStringExtra("CityId");

        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initShopListDatas(this,scId,name,cityId);

        presenter.getShopListBanner(scId,cityId);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_shop_list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public AppBarLayout getAppBarLayoutView() {
        return getViewById(R.id.ab_shoplist_bar);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.cb_shop_slidePage);
    }

    @Override
    public Toolbar getToolbarView() {
        return getViewById(R.id.appbar_layout_toolbar);
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public PagerSlidingTabStrip getPagerSlidingTabStripView() {
        return getViewById(R.id.pst_shop_title);
    }

    @Override
    public ViewPager getViewPagerView() {
        return getViewById(R.id.vp_shop_content);
    }
}
