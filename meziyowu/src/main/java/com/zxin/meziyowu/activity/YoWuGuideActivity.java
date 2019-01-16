package com.zxin.meziyowu.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseActivity;
import com.zxin.meziyowu.util.YoWuSharedPreferences;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */

public class YoWuGuideActivity extends BaseActivity {
    private ViewPager mViewPager;

    private List<ImageView> imageViewList;

    @Override
    public void initData() {
        mViewPager = getViewById(R.id.vp_guide);

        int[] imageResIDs = {R.drawable.guidance_1,R.drawable.guidance_2,R.drawable.guidance_3,R.drawable.guidance_4,R.drawable.guidance_5};
        imageViewList = new ArrayList<>();
        for (int i = 0; i < imageResIDs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(imageResIDs[i]);
            imageViewList.add(iv);
        }
        imageViewList.get(imageResIDs.length-1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoWuSharedPreferences.setIsFirstEnter(false);
                startActivity(new Intent(mContext, YoWuMainActivity.class));
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
        return R.layout.activity_yowu_guide;
    }

    @Override
    public void onClick(View v) {

    }
}
