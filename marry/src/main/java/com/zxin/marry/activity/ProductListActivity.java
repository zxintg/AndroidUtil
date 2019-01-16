package com.zxin.marry.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.fragment.product.ProductFragment;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class ProductListActivity extends BaseActivity {
    private PagerSlidingTabStrip mTitleTab;
    private ViewPager mViewPager;

    private int position;
    private ArrayList<TitleBean> titleList;
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void initData() {
        position = getIntent().getIntExtra("position",0);
        titleList = getIntent().getParcelableArrayListExtra("ProductTypes");
        initView();
        setView();
    }

    private void initView() {
        mTitleTab = getViewById(R.id.pst_product_title);
        mViewPager = getViewById(R.id.vp_product_fragment);
    }

    private void setView() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        for (TitleBean titleBean : titleList){
            mFragmentList.add(ProductFragment.newInstance(titleBean));
        }
        mViewPager.removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mViewPager.setAdapter(pageAdapter);
        mViewPager.setOffscreenPageLimit(titleList.size());
        mTitleTab.setViewPager(mViewPager);
        mViewPager.setCurrentItem(position);
    }


    @Override
    public int setLayout() {
        return R.layout.activity_product_list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }
}
