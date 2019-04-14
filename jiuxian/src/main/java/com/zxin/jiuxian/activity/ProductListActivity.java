package com.zxin.jiuxian.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.bean.MainBarBean;
import com.zxin.jiuxian.mvp.presenter.ProductPresenter;
import com.zxin.jiuxian.mvp.view.ProductContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */

public class ProductListActivity extends BaseActivity implements ProductContract.ProductListView {
    @InjectPresenter
    ProductPresenter presenter;

    private DrawerLayout drawerLayout;
    private LinearLayout mTitle;

    @Override
    public void initData() {
        mTitle = getViewById(R.id.linearListTitle);
        drawerLayout = getViewById(R.id.dl_goodslist);

        mTitle.setPadding(mTitle.getPaddingLeft(),mTitle.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), mTitle.getPaddingRight(),mTitle.getPaddingBottom());
        setViewOnclick(R.id.mGoodsListBackImg,R.id.mGoodsConditionTv);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        presenter.initDatas(this,getIntent().getBooleanExtra("isTopTopic",false),getIntent().getStringExtra("categoryId"),getIntent().getStringExtra("startPrice"),getIntent().getStringExtra("endPrice"),getIntent().getStringExtra("cateAttrId"));
    }

    @Override
    public int setLayout() {
        return R.layout.activity_goods_list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.mGoodsListBackImg){
            onBackPressed();
        }
        if (v.getId()==R.id.mGoodsConditionTv){
            if (!drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_productlist_commonlayout);
    }

    @Override
    public ImageButton getGoToView() {
        return getViewById(R.id.mCommendGoTop);
    }
}
