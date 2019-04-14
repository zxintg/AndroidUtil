package com.zxin.sources.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.zxin.sources.R;
import com.zxin.sources.base.BaseActivity;
import com.zxin.sources.fragment.CodeKKItemFragment;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.ContentUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */

public class CodeKKActivity extends BaseActivity {
    private CommonCrosswiseBar mTitle;
    private PagerSlidingTabStrip mTitleTab;
    private ViewPager mViewPager;

    private ArrayList<TitleBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void initData() {
        titleList.clear();
        mFragmentList.clear();
        initView();
        setView();
    }

    private void setView() {
        titleList.addAll(ContentUtil.getInstance().getCodeKKTitleBeanList());
        for (TitleBean titleBean : titleList){
            mFragmentList.add(CodeKKItemFragment.newInstance(titleBean));
        }
        mViewPager.removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(pageAdapter);
        mViewPager.setOffscreenPageLimit(titleList.size());
        mTitleTab.setViewPager(mViewPager);
    }

    private void initView() {
        mTitle = (CommonCrosswiseBar) getViewById(R.id.ccb_codekk_head);
        mTitleTab = (PagerSlidingTabStrip) getViewById(R.id.pst_codekk_title);
        mViewPager = (ViewPager) getViewById(R.id.vp_codekk_pager);
        mTitle.setOnClickListener(R.id.common_bar_leftBtn,this);
        setViewOnclick(R.id.tv_codekk_edittitle);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_codekk;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

}
