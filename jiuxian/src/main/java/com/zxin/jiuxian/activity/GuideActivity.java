package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.service.WelcomeImageDownloadService;
import com.zxin.jiuxian.util.JiuXianSharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/3.
 */

public class GuideActivity extends BaseActivity {
    private ViewPager mViewPager;

    private List<ImageView> imageViewList;

    @Override
    public void initData() {
        mViewPager = getViewById(R.id.vp_guide);

        int[] imageResIDs = {R.drawable.icon_guide1,R.drawable.icon_guide2,R.drawable.icon_guide3};
        imageViewList = new ArrayList<>();
        for (int i = 0; i < imageResIDs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(imageResIDs[i]);
            imageViewList.add(iv);
        }
        imageViewList.get(imageResIDs.length-1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JiuXianSharedPreferences.setIsFirstEnter(false);
                startService(new Intent(mContext, WelcomeImageDownloadService.class));
                startActivity(new Intent(mContext, MainActivity.class));
                onBackPressed();
            }
        });
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
            /*
             * 删除元素
             */
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = imageViewList.get(position);
                container.addView(iv);// 1. 向ViewPager中添加一个view对象
                return iv; // 2. 返回当前添加的view对象
            }
        });
    }

    @Override
    public int setLayout() {
        return R.layout.activity_jiuxian_guide;
    }

    @Override
    public void onClick(View v) {

    }
}
