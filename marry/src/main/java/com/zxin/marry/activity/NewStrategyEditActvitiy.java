package com.zxin.marry.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.dao.HttpUrlDaoUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */

public class NewStrategyEditActvitiy extends BaseActivity implements RadioGroup.OnCheckedChangeListener ,ViewPager.OnPageChangeListener {
    private String mOrderId,mShopid,showouter;

    private RelativeLayout mTitleLayout;
    private RadioGroup mTableLayout;
    private ViewPager mViewPager;

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合

    @Override
    public void initData() {
        mOrderId = getIntent().getStringExtra("orderid");
        mShopid = getIntent().getStringExtra("shopid");
        showouter = getIntent().getStringExtra("showouter");

        mTitleLayout = getViewById(R.id.rl_atrategy_title);
        mTableLayout = getViewById(R.id.rg_atrategy_title);
        mViewPager = getViewById(R.id.vp_atrategy_fragment);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SystemInfoUtil.dip2px(45) + SystemInfoUtil.getStatusBarHeight());
        //params.setMargins(0, SystemInfoUtil.getStatusBarHeight(), 0, 0);
        mTitleLayout.setPadding(0, mTitleLayout.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), 0, 0);
        mTitleLayout.setLayoutParams(params);

        titleList.clear();
        mFragmentList.clear();
        mViewPager.removeAllViews();

        titleList.addAll(TitleBarUtil.newInstance().getNewStrategyEditList(mOrderId,mShopid,showouter));
        for (MainBarBean mainBar : titleList){
            mFragmentList.add(mainBar.fragment);
        }
        mViewPager.setAdapter(new ViewPageFragmentAdapter(mFragmentList, titleList));
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(titleList.size());
        mTableLayout.setOnCheckedChangeListener(this);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setCurrentItem(0);

        setViewOnclick(R.id.tv_atrategy_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_strategy_edit;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_atrategy_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        mViewPager.setCurrentItem(Integer.parseInt(group.findViewById(checkedId).getTag()+""));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTableLayout.check(position==0?R.id.rb_atrategy_outdoor:R.id.rb_atrategy_indoor);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
