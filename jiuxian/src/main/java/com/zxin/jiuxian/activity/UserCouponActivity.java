package com.zxin.jiuxian.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.bean.MainBarBean;
import com.zxin.jiuxian.util.TitleBarUtil;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */

public class UserCouponActivity extends BaseActivity {
    private PagerSlidingTabStrip mTitleTab;
    private ViewPager mViewPager;
    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn);
        initView();
        setView();
    }

    private void initView() {
        mTitleTab = getViewById(R.id.pst_coupon_title);
        mViewPager = getViewById(R.id.user_coupon_content);
    }

    private void setView() {
        titleList.addAll(TitleBarUtil.newInstance().getUserCouponList());
        for (MainBarBean titleBean : titleList){
            mFragmentList.add(titleBean.fragment);
        }
        mViewPager.removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(pageAdapter);
        mViewPager.setOffscreenPageLimit(titleList.size());
        mTitleTab.setViewPager(mViewPager);
    }
    @Override
    public int setLayout() {
        return R.layout.activity_user_coupon;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }
    }
}
