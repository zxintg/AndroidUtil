package com.zxin.zxinlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.transition.CustPagerTransformer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class ViewPagerTransitionView extends LinearLayout {

    private int pager_bgcolor;
    private int pager_bgres;
    private boolean is_indicator;
    private boolean is_zoom;
    private boolean is_detail;

    private LinearLayout ll_viewpager;
    private TextView indicatorTv;
    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>(); // 供ViewPager使用


    public ViewPagerTransitionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**加载布局文件*/
        LayoutInflater.from(context).inflate(R.layout.common_viewpager, this, true);
        ll_viewpager = (LinearLayout) findViewById(R.id.ll_viewpager);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        indicatorTv = (TextView) findViewById(R.id.indicator_tv);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerTransition);
        pager_bgcolor = typedArray.getColor(R.styleable.ViewPagerTransition_pager_bgcolor, Color.WHITE);
        pager_bgres = typedArray.getResourceId(R.styleable.ViewPagerTransition_pager_bgres, -1);
        is_indicator = typedArray.getBoolean(R.styleable.ViewPagerTransition_is_indicator, false);
        is_zoom = typedArray.getBoolean(R.styleable.ViewPagerTransition_is_zoom, true);
        is_detail = typedArray.getBoolean(R.styleable.ViewPagerTransition_is_detail, true);

        typedArray.recycle();

        setBackground();
        setParameter();
    }

    public void setBackground() {
        if (pager_bgres == -1)
            ll_viewpager.setBackgroundColor(pager_bgcolor);
        else
            ll_viewpager.setBackgroundResource(pager_bgres);
    }

    private void setParameter() {
        // 1. viewPager添加parallax效果，使用PageTransformer就足够了
        viewPager.setPageTransformer(false, new CustPagerTransformer(getContext()));
    }

    public void setFragmentList(List<Fragment> list){
        fragmentList.clear();
        fragmentList.addAll(list);

        viewPager.setAdapter(new FragmentStatePagerAdapter(AppManager.getAppManager().getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position % 10);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(list.size());
        // 3. viewPager滑动时，调整指示器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateIndicatorTv();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        updateIndicatorTv();
    }


    /**
     * 更新指示器
     */
    private void updateIndicatorTv() {
        if (!is_indicator)
            return;
        int totalNum = viewPager.getAdapter().getCount();
        int currentItem = viewPager.getCurrentItem() + 1;
        indicatorTv.setText(Html.fromHtml("<font color='#12edf0'>" + currentItem + "</font>  /  " + totalNum));
    }


}
