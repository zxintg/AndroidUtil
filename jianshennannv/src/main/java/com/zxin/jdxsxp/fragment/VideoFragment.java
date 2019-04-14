package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.bean.MainBarBean;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.jdxsxp.util.TitleBarUtil;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */

public class VideoFragment extends BaseFragment implements BaseFragment.LazyLoadingListener {
    private TitleBean titleBean;
    private PagerSlidingTabStrip mTitleTab;
    private ViewPager mViewPager;

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    public static VideoFragment newInstance(TitleBean titleBean) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        mTitleTab =  getViewById(R.id.pst_video_title);
        mViewPager = getViewById(R.id.vp_video_content);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_jdxsxpvideo;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        titleList.addAll(TitleBarUtil.newInstance().getVideoTitleList());
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
