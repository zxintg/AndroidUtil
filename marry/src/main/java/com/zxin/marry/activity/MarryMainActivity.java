package com.zxin.marry.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class MarryMainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
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
        mPagerView = getViewById(R.id.vp_marrymain_pager);
        mRadioGroup = getViewById(R.id.rg_marrymain_bar);
    }

    private void setView() {
        mRadioGroup.removeAllViews();
        mPagerView.removeAllViews();
        titleList.addAll(TitleBarUtil.newInstance().getBarTitleList());
        for (MainBarBean title:titleList){
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setText(title.label);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight=1;
            radioButton.setCompoundDrawablePadding(2);
            radioButton.setGravity(Gravity.CENTER_HORIZONTAL);
            radioButton.setTextColor(getResources().getColorStateList(R.color.radio_color_bg));
            radioButton.setTextSize(13);
            radioButton.setPadding(8,8,8,8);
            radioButton.setLayoutParams(layoutParams);
            Drawable drawable = UiUtils.getDrawable(title.labSource);
            //drawable.setBounds(0,0,20,20);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
            radioButton.setCompoundDrawablesWithIntrinsicBounds(null,drawable,null,null);
            radioButton.setButtonDrawable(null);
            radioButton.setBackground(null);
            radioButton.setTag(title.index);
            mRadioGroup.addView(radioButton);
            radioButton.setChecked(title.index==0);
            mFragmentList.add(title.fragment);
        }

        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        mPagerView.setAdapter(pageAdapter);
        mPagerView.setOffscreenPageLimit(titleList.size());

        mRadioGroup.setOnCheckedChangeListener(this);
        mPagerView.addOnPageChangeListener(this);
        mPagerView.setCurrentItem(2);
    }


    @Override
    public int setLayout() {
        return R.layout.activity_marry_main;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        mPagerView.setCurrentItem((int)group.findViewById(checkedId).getTag());
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

    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11004:
                //订单详情
                mRadioGroup.check(mRadioGroup.getChildAt(1).getId());
                mPagerView.setCurrentItem(1);
                break;
        }
        return false;
    }

}
