package com.zxin.jdxsxp.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.bean.MainBarBean;
import com.zxin.jdxsxp.util.TitleBarUtil;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.util.SelectorUtil;
import com.zxin.root.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private MyViewPager mPagerView;
    private RadioGroup mRadioGroup;
    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void initData() {
        mFragmentList.clear();
        initView();
        setView();
    }

    private void initView() {
        mPagerView = getViewById(R.id.vp_jdxsxp_pager);
        mRadioGroup = getViewById(R.id.rg_jdxsxp_bar);
    }

    private void setView() {
        mRadioGroup.removeAllViews();
        mPagerView.removeAllViews();
        titleList.addAll(TitleBarUtil.newInstance().getBarTitleList());
        for (MainBarBean title : titleList) {
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setText(title.label);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1;
            radioButton.setCompoundDrawablePadding(2);
            radioButton.setGravity(Gravity.CENTER_HORIZONTAL);
            radioButton.setTextColor(getResources().getColorStateList(R.color.radio_color_jdxsxp));
            radioButton.setTextSize(13);
            radioButton.setPadding(8, 8, 8, 8);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setBackground(null);
            radioButton.setTag(title.index);
            SelectorUtil.addSelectorFromDrawable(title.labImage,title.labImage2, 150,150,radioButton);
            radioButton.setButtonDrawable(null);
            mRadioGroup.addView(radioButton);
            radioButton.setChecked(title.index == 0);
            mFragmentList.add(title.fragment);
        }

        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mPagerView.setAdapter(pageAdapter);
        mPagerView.setOffscreenPageLimit(titleList.size());

        mRadioGroup.setOnCheckedChangeListener(this);
        mPagerView.addOnPageChangeListener(this);
        mPagerView.setCurrentItem(0);
        mPagerView.setNestedScrollingEnabled(false);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_jdxsxpmain;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        mPagerView.setCurrentItem((int) group.findViewById(checkedId).getTag());
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
    public void onClick(View v) {

    }
}
