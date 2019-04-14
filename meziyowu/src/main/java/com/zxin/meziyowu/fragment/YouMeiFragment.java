package com.zxin.meziyowu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.zxin.meziyowu.R;
import com.zxin.meziyowu.activity.YoMeiCollectActivity;
import com.zxin.meziyowu.activity.YoMeiLocalVideoActivity;
import com.zxin.meziyowu.base.BaseFragment;
import com.zxin.meziyowu.mvp.presenter.YoMeiMainPresenter;
import com.zxin.meziyowu.mvp.view.YoMeiMainContract;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2018/9/28.
 */

public class YouMeiFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,YoMeiMainContract.YoMeiMainView {
    @InjectPresenter
    YoMeiMainPresenter presenter;

    private TitleBean titleBean;

    public static YouMeiFragment newInstance(TitleBean titleBean) {
        YouMeiFragment fragment = new YouMeiFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setTitleViewOnclick(R.id.ccb_youmei_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        presenter.initDatas(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_yowuwallpaper;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            startActivity(new Intent(mContext,YoMeiCollectActivity.class));
            return;
        }
        if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext,YoMeiLocalVideoActivity.class));
            return;
        }
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getYoMeiTagList();
    }

    @Override
    public PagerSlidingTabStrip getPagerSlidingTabStrip() {
        return getViewById(R.id.pst_yomei_title);
    }

    @Override
    public ViewPager getViewPager() {
        return getViewById(R.id.vp_yomei_content);
    }
}
