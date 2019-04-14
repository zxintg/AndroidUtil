package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.mvp.presenter.MainPresenter;
import com.zxin.jiuxian.mvp.view.MainContract;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.banner.VerticalBannerView;

/**
 * Created by Administrator on 2018/8/6.
 */

public class HomeFragment extends BaseFragment implements BaseFragment.LazyLoadingListener, MainContract.JiuXianMainView {
    @InjectPresenter
    MainPresenter presenter;

    private TitleBean titleBean;

    public static HomeFragment newInstance(TitleBean titleBean) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this, getChildFragmentManager());
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_mainhome;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_cate);
    }

    @Override
    public RelativeLayout getMainhomeTitleView() {
        return getViewById(R.id.ll_mainhome_title);
    }

    @Override
    public RelativeLayout getCaptureWineBubbleView() {
        return getViewById(R.id.main_home_capture_wine_bubble);
    }

    @Override
    public ImageView iv_back_top() {
        return getViewById(R.id.iv_back_top);
    }

    @Override
    public ImageView iv_circleactinfo() {
        return getViewById(R.id.iv_circleactinfo);
    }

    @Override
    public ConvenientBanner mian_child_1() {
        return getViewById(R.id.mian_child_1);
    }

    @Override
    public RecyclerView mian_child_2() {
        return getViewById(R.id.mian_child_2);
    }

    @Override
    public LinearLayout mian_child_3() {
        return getViewById(R.id.mian_child_3);
    }

    @Override
    public ImageView mian_child_3_1() {
        return getViewById(R.id.mian_child_3_1);
    }

    @Override
    public ImageView mian_child_3_2() {
        return getViewById(R.id.mian_child_3_2);
    }

    @Override
    public ImageView mian_child_3_3() {
        return getViewById(R.id.mian_child_3_3);
    }

    @Override
    public ImageView mian_child_3_4() {
        return getViewById(R.id.mian_child_3_4);
    }

    @Override
    public ImageView mian_child_3_5() {
        return getViewById(R.id.mian_child_3_5);
    }

    @Override
    public ImageView mian_child_3_6() {
        return getViewById(R.id.mian_child_3_6);
    }

    @Override
    public LinearLayout mian_child_4() {
        return getViewById(R.id.mian_child_4);
    }

    @Override
    public ImageView mian_child_4_1() {
        return getViewById(R.id.mian_child_4_1);
    }

    @Override
    public VerticalBannerView mian_child_4_2() {
        return getViewById(R.id.mian_child_4_2);
    }

    @Override
    public LinearLayout mian_child_5() {
        return getViewById(R.id.mian_child_5);
    }

    @Override
    public TextView mian_child_5_1() {
        return getViewById(R.id.mian_child_5_1);
    }

    @Override
    public LinearLayout mian_child_5_2() {
        return getViewById(R.id.mian_child_5_2);
    }

    @Override
    public TextView mian_child_5_3() {
        return getViewById(R.id.mian_child_5_3);
    }

    @Override
    public RecyclerView mian_child_6() {
        return getViewById(R.id.mian_child_6);
    }

    @Override
    public ConvenientBanner mian_child_7() {
        return getViewById(R.id.mian_child_7);
    }

    @Override
    public ConvenientBanner mian_child_8() {
        return getViewById(R.id.mian_child_8);
    }

    @Override
    public LinearLayout mian_child_9() {
        return getViewById(R.id.mian_child_9);
    }

    @Override
    public ImageView mian_child_9_1() {
        return getViewById(R.id.mian_child_9_1);
    }

    @Override
    public ImageView mian_child_9_2() {
        return getViewById(R.id.mian_child_9_2);
    }

    @Override
    public ImageView mian_child_9_3() {
        return getViewById(R.id.mian_child_9_3);
    }

    @Override
    public RecyclerView mian_child_10() {
        return getViewById(R.id.mian_child_10);
    }

    @Override
    public ConvenientBanner mian_child_11() {
        return getViewById(R.id.mian_child_11);
    }

    @Override
    public ImageView mian_child_12_1() {
        return getViewById(R.id.mian_child_12_1);
    }

    @Override
    public ImageView mian_child_12_2() {
        return getViewById(R.id.mian_child_12_2);
    }

    @Override
    public ImageView mian_child_12_3() {
        return getViewById(R.id.mian_child_12_3);
    }

    @Override
    public ImageView mian_child_12_4() {
        return getViewById(R.id.mian_child_12_4);
    }

    @Override
    public ImageView mian_child_12_5() {
        return getViewById(R.id.mian_child_12_5);
    }

    @Override
    public ImageView mian_child_12_6() {
        return getViewById(R.id.mian_child_12_6);
    }

    @Override
    public ConvenientBanner mian_child_13() {
        return getViewById(R.id.mian_child_13);
    }

    @Override
    public RecyclerView mian_child_14() {
        return getViewById(R.id.mian_child_14);
    }

    @Override
    public ConvenientBanner mian_child_15() {
        return getViewById(R.id.mian_child_15);
    }

    @Override
    public ImageView mian_child_16() {
        return getViewById(R.id.mian_child_16);
    }

    @Override
    public RecyclerView mian_child_16_1() {
        return getViewById(R.id.mian_child_16_1);
    }

    @Override
    public RadioGroup ll_title_layout() {
        return getViewById(R.id.ll_title_layout);
    }

    @Override
    public RecyclerView user_home_content() {
        return getViewById(R.id.user_home_content);
    }
}
