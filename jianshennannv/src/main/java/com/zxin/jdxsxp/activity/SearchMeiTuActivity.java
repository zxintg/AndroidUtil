package com.zxin.jdxsxp.activity;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2018/9/7.
 */

public class SearchMeiTuActivity extends BaseActivity implements XiGuaMainContract.SearchMeiTuView {
    @InjectPresenter
    XiGuaMainPresenter presenter;

    @Override
    public void initData() {
        setViewOnclick(R.id.tv_search_back);
        presenter.initSearchMeiTuDatas(this);
        presenter.getHotTagsList();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_meitu_search;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_search_back){
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (getDrawerLayoutView().isDrawerOpen(GravityCompat.END)){
            getDrawerLayoutView().closeDrawer(GravityCompat.END);
            return;
        }
        finish();
    }

    @Override
    public DrawerLayout getDrawerLayoutView() {
        return getViewById(R.id.dl_search_layout);
    }

    @Override
    public LinearLayout ll_search_head() {
        return getViewById(R.id.ll_search_head);
    }

    @Override
    public SearchView et_search_search() {
        return getViewById(R.id.et_search_search);
    }

    @Override
    public TextView tv_search_tags() {
        return getViewById(R.id.tv_search_tags);
    }

    @Override
    public PagerSlidingTabStrip getPagerSlidingTabStrip() {
        return getViewById(R.id.pst_search_title);
    }

    @Override
    public ViewPager vp_search_content() {
        return getViewById(R.id.vp_search_content);
    }

    @Override
    public TextView tv_search_history() {
        return getViewById(R.id.tv_search_history);
    }

    @Override
    public RecyclerView rv_search_history() {
        return getViewById(R.id.rv_search_history);
    }

    @Override
    public RecyclerView rv_search_hot() {
        return getViewById(R.id.rv_search_hot);
    }
}
