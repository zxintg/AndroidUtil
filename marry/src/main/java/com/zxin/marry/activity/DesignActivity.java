package com.zxin.marry.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.fragment.IndicatorPagerFragment;
import com.zxin.root.view.ViewPagerTransitionView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/27.
 */

public class DesignActivity extends BaseActivity {

    private ViewPagerTransitionView viewPager;

    @Override
    public void initData() {
        viewPager = getViewById(R.id.viewPager);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new IndicatorPagerFragment().newInstance(R.drawable.marry_design_1));
        fragmentList.add(new IndicatorPagerFragment().newInstance(R.drawable.marry_design_2));
        fragmentList.add(new IndicatorPagerFragment().newInstance(R.drawable.marry_design_3));
        fragmentList.add(new IndicatorPagerFragment().newInstance(R.drawable.marry_design_4));
        viewPager.setFragmentList(fragmentList);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_design;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.common_bar_rightBtn){
            Intent intent = getIntent();
            intent.setClass(mContext,ShopListActivity.class);
            startActivity(intent);
            onBackPressed();
        }
    }
}
