package com.common.camera.activity;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.common.camera.R;
import com.common.camera.fragment.AlbumFragment;
import com.common.camera.model.PhotoPreviewBean;
import com.common.camera.view.PhotoView;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.SystemBarTintManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/4.
 *
 * 相册预览
 *
 */

public class AlbumPreviewActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mTitle,mContent,mExplain,mExplainNum,mDianZanNum;
    private ViewPager mVContent;
    private PhotoPreviewBean previewBean;
    private RelativeLayout mHeadLay;
    private LinearLayout mBtmLay;
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制竖屏
        initWindow();
        setContentView(R.layout.activity_albumpreview);
        initView();
        initDatas();
        setDates();
    }

    private void initView() {
        mHeadLay = (RelativeLayout) findViewById(R.id.rl_albumpreview_headlay);
        mBtmLay = (LinearLayout) findViewById(R.id.ll_albumpreview_btm);
        mTitle = (TextView) findViewById(R.id.tv_albumpreview_title);
        mVContent = (ViewPager) findViewById(R.id.vp_albumpreview_content);
        mContent = (TextView) findViewById(R.id.tv_albumpreview_content);
        mExplain = (TextView) findViewById(R.id.tv_albumpreview_explain);
        mExplainNum = (TextView) findViewById(R.id.tv_albumpreview_explainnum);
        mDianZanNum = (TextView) findViewById(R.id.tv_albumpreview_dianzannum);
    }

    private void initDatas() {
        previewBean = getIntent().getParcelableExtra(BaseStringUtils.ACTIVITY_DATA);
        mFragmentList.clear();
        for (PhotoPreviewBean.PhotoPreview preBean : previewBean.photoList){
            mFragmentList.add(AlbumFragment.newInstance(preBean));
        }
    }

    private void setDates() {
        findViewById(R.id.btn_albumpreview_close).setOnClickListener(this);
        findViewById(R.id.btn_albumpreview_more).setOnClickListener(this);
        mExplain.setOnClickListener(this);
        mExplainNum.setOnClickListener(this);
        mDianZanNum.setOnClickListener(this);
        mHeadLay.setPadding(mHeadLay.getPaddingLeft(), mHeadLay.getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), mHeadLay.getPaddingRight(), mHeadLay.getPaddingBottom());

        mTitle.setText((previewBean.index+1)+"/"+previewBean.count);
        mContent.setText(previewBean.content);
        mExplain.setText(previewBean.explain);
        mExplainNum.setText(String.valueOf(previewBean.explainNum));
        mDianZanNum.setText(String.valueOf(previewBean.zanNum));
        mVContent.removeAllViews();
        mVContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()){
            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }
        });
        mVContent.setCurrentItem(previewBean.index);
        mVContent.setOffscreenPageLimit(mFragmentList.size());

        mVContent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTitle.setText((position+1)+"/"+previewBean.count);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @TargetApi(19)
    private void initWindow() {
        //家长端
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setTintResource(R.drawable.top_bar_ffff);
            tintManager.setTintAlpha(0f);
        }
    }

    @Override
    public void onClick(View v) {
        //返回
        if (v.getId() == R.id.btn_albumpreview_close) {
            onBackPressed();
            return;
        }
    }

    public void ClickNotifyView(PhotoView mPhotoView, PhotoPreviewBean.PhotoPreview previewBean) {
        if (mHeadLay.getVisibility()==View.VISIBLE && mBtmLay.getVisibility()==View.VISIBLE){
            //隐藏
            mHeadLay.setVisibility(View.GONE);
            mBtmLay.setVisibility(View.GONE);
        }else{
            //展示
            mHeadLay.setVisibility(View.VISIBLE);
            mBtmLay.setVisibility(View.VISIBLE);
        }
    }
}
