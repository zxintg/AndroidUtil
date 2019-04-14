package com.zxin.jdxsxp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.activity.SearchMeiTuActivity;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2018/8/29.
 */

public class HomeFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,XiGuaMainContract.XiGuaMainView {
    @InjectPresenter
    XiGuaMainPresenter presenter;

    private TitleBean titleBean;

    public static HomeFragment newInstance(TitleBean titleBean) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this);
        setLazyLoadingListener(this);
        setTitleViewOnclick(R.id.ccb_jdxsxp_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_jdxsxphome;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext, SearchMeiTuActivity.class));
        }
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getHomeTagList();
    }

    @Override
    public PagerSlidingTabStrip getPagerSlidingTabStrip() {
        return getViewById(R.id.pst_home_title);
    }

    @Override
    public ViewPager getViewPager() {
        return getViewById(R.id.vp_home_content);
    }
}
