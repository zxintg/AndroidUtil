package com.zxin.marry.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.mvp.presenter.CirclePresenter;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2018/6/14.
 */

public class HomeCircleActivity extends BaseActivity implements CircleContract.HomeCircleView {
    private CircleForm.Circle mCircle;

    @InjectPresenter
    CirclePresenter presenter;

    @Override
    public void initData() {
        mCircle =  getIntent().getParcelableExtra("Circle");
        presenter.initHomeCircleDatas(this,mCircle);
        presenter.getHomeCircleList(null,"up",null,mCircle.getCircle_id(),mCircle.getThclass_id());
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_home_circle;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.common_bar_rightBtn){
            presenter.checkNick();
        }
    }

    @Override
    public AppBarLayout getAppBarLayoutView() {
        return getViewById(R.id.ab_circle_bar);
    }

    @Override
    public SimpleDraweeView getIVTopView() {
        return getViewById(R.id.iv_top);
    }

    @Override
    public TextView getTVTitleView() {
        return getViewById(R.id.tv_title);
    }

    @Override
    public TextView getTVCountView() {
        return getViewById(R.id.tv_count);
    }

    @Override
    public TextView getTVDescribeView() {
        return getViewById(R.id.tv_describe);
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
        return getViewById(R.id.tabStripLayout);
    }

    @Override
    public ViewPager getViewPagerView() {
        return getViewById(R.id.vp_circle_fragment);
    }
}
