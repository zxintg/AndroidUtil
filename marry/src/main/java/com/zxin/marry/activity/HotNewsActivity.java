package com.zxin.marry.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2018/6/27.
 */

public class HotNewsActivity extends BaseActivity implements MainTopicContract.HotNewsView {
    @InjectPresenter
    TopicPresenter presenter;

    @Override
    public void initData() {
        presenter.initHotNewsViewDatas(this);
        presenter.getHontNewsMenus();
        setTitleViewOnclick(R.id.ccb_marray_title, R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_hotnews;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    @Override
    public PagerSlidingTabStrip getPagerSlidingTabStripView() {
        return getViewById(R.id.pst_hontnew_title);
    }

    @Override
    public ViewPager getViewPagerView() {
        return getViewById(R.id.content_view);
    }
}
