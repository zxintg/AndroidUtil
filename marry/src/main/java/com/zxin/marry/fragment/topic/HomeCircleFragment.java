package com.zxin.marry.fragment.topic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.mvp.presenter.CirclePresenter;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/2.
 */

public class HomeCircleFragment extends BaseFragment implements BaseFragment.LazyLoadingListener, CircleContract.HomeCircleItemView{
    @InjectPresenter
    CirclePresenter presenter;
    private CircleForm.Circle mCircle;

    public static Fragment newInstance(CircleForm.Circle mCircle, String id) {
        HomeCircleFragment fragment = new HomeCircleFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, id);
        args.putParcelable("mCircle",mCircle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        mCircle = getArguments().getParcelable("mCircle");
        presenter.initHomeCircleItemDatas(this,mCircle,getArguments().getString(StringUtils.FRAGMENT_DATA),getChildFragmentManager());
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_homecircle;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_recycle_review);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_common_refresh);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }
}
