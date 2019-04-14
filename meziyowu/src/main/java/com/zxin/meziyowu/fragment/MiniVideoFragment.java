package com.zxin.meziyowu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseFragment;
import com.zxin.meziyowu.bean.MainBarBean;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.meziyowu.util.TitleBarUtil;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */

public class MiniVideoFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;
    private PagerSlidingTabStrip mTitleTab;
    private ViewPager mViewPager;

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    public static MiniVideoFragment newInstance(TitleBean titleBean) {
        MiniVideoFragment fragment = new MiniVideoFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        mTitleTab =  getViewById(R.id.pst_minivideo_title);
        mViewPager = getViewById(R.id.vp_minivideo_content);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_minivideo;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        titleList.addAll(TitleBarUtil.newInstance().getMiniVideoTitleList());
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
}
