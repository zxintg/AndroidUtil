package com.zxin.jdxsxp.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.bean.HomeTagModel;
import com.zxin.jdxsxp.bean.MainBarBean;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.jdxsxp.util.TitleBarUtil;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */

public class UserInfoActivity extends BaseActivity implements XiGuaMainContract.UserInfoView {
    @InjectPresenter
    XiGuaMainPresenter presenter;

    private PagerSlidingTabStrip tabStrip;
    private ViewPager viewPager;

    private int userId;
    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;
    @Override
    public void initData() {
        userId = getIntent().getIntExtra("KD",0);
        presenter.initUserInfoDatas(this);
        presenter.getUserInfo(userId);
        tabStrip = getViewById(R.id.pst_user_title);
        viewPager = getViewById(R.id.vp_user_content);
        titleList.addAll(TitleBarUtil.newInstance().getUserDetailTitle(userId));
        for (MainBarBean titleBean : titleList){
            mFragmentList.add(titleBean.fragment);
        }
        viewPager.removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        viewPager.setCurrentItem(0);
        viewPager.setAdapter(pageAdapter);
        viewPager.setOffscreenPageLimit(titleList.size());
        tabStrip.setViewPager(viewPager);

        setTitleViewOnclick(R.id.ccb_jdxsxp_title,R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_user_details_info;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public AppBarLayout getAppBarLayoutView() {
        return getViewById(R.id.ab_user_bar);
    }

    @Override
    public Toolbar getToolbarView() {
        return getViewById(R.id.appbar_layout_toolbar);
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_jdxsxp_title);
    }

    @Override
    public ImageView iv_user_ivImage() {
        return getViewById(R.id.iv_user_ivImage);
    }

    @Override
    public RelativeLayout head_bg() {
        return getViewById(R.id.head_bg);
    }

    @Override
    public ImageView image_user_info_head() {
        return getViewById(R.id.image_user_info_head);
    }

    @Override
    public ImageView iv_user_v() {
        return getViewById(R.id.iv_user_v);
    }

    @Override
    public TextView tv_atten() {
        return getViewById(R.id.tv_atten);
    }

    @Override
    public LinearLayout layout_follow() {
        return getViewById(R.id.layout_follow);
    }

    @Override
    public TextView tv_city() {
        return getViewById(R.id.tv_city);
    }

    @Override
    public LinearLayout layout_gift() {
        return getViewById(R.id.layout_gift);
    }

    @Override
    public TextView tv_bwh() {
        return getViewById(R.id.tv_bwh);
    }

    @Override
    public LinearLayout layout_level() {
        return getViewById(R.id.layout_level);
    }

    @Override
    public TextView tv_height() {
        return getViewById(R.id.tv_height);
    }
}
