package com.zxin.marry.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 兑换券 on 2018/6/13.
 */

public class MarryCDkeyVoucherActivity extends BaseActivity {
    private PagerSlidingTabStrip mTitleTab;
    private ViewPager mViewPager;
    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void initData() {
        titleList.clear();
        mFragmentList.clear();
        initView();
        setView();
    }

    private void initView() {
        mTitleTab = getViewById(R.id.pst_cdkeyvoucher_title);
        mViewPager = getViewById(R.id.vp_cdkeyvoucher_fragment);
    }

    private void setView() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        titleList.addAll(TitleBarUtil.newInstance().getCDKeyVoucherList());
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
        return R.layout.activity_cdkeyvoucher;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }
}
