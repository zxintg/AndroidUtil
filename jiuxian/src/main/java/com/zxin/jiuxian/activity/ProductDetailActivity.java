package com.zxin.jiuxian.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.bean.MainBarBean;
import com.zxin.jiuxian.util.TitleBarUtil;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */

public class ProductDetailActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    private FrameLayout mTitle;
    private ViewPager mPagerView;
    private RadioGroup mRadioGroup;

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void initData() {
        mTitle = getViewById(R.id.fl_product_detail);
        mPagerView = getViewById(R.id.product_details_viewpager);
        mRadioGroup = getViewById(R.id.product_details_tab);

        mTitle.setPadding(mTitle.getPaddingLeft(),mTitle.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), mTitle.getPaddingRight(),mTitle.getPaddingBottom());

        mPagerView.removeAllViews();
        mFragmentList.clear();
        titleList.addAll(TitleBarUtil.newInstance().getProductDetailList(getIntent().getStringExtra("proId")));
        for (MainBarBean bar : titleList){
            mFragmentList.add(bar.fragment);
        }
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mPagerView.setAdapter(pageAdapter);
        mPagerView.setOffscreenPageLimit(titleList.size());

        mRadioGroup.setOnCheckedChangeListener(this);
        mPagerView.addOnPageChangeListener(this);
        mPagerView.setCurrentItem(0);

        setViewOnclick(R.id.titile_left_imageview);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_product_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.titile_left_imageview){
            onBackPressed();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mRadioGroup.check(mRadioGroup.getChildAt(position).getId());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        mPagerView.setCurrentItem(Integer.parseInt(String.valueOf(group.findViewById(checkedId).getTag())));
    }
}
