package com.zxin.marry.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.MainCriclePresenter;
import com.zxin.marry.mvp.view.MainCricleContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MarriageCircleFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MainCricleContract.MainCricleView {
    private TitleBean titleBean;
    @InjectPresenter
    MainCriclePresenter presenter;

    public static MarriageCircleFragment newInstance(TitleBean titleBean) {
        MarriageCircleFragment fragment = new MarriageCircleFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.ll_more);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_marriage_circle;
    }

    @Override
    public void onClick(View v) {
        presenter.OnClick(v);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getHomeList();
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_main_commonlayout);
    }


    @Override
    public CommonCrosswiseBar getMoreView() {
        return getViewById(R.id.ll_more);
    }

    @Override
    public RecyclerView getDragView() {
        return getViewById(R.id.dragRecyclerView);
    }

}
