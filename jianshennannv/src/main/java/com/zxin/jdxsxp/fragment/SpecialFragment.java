package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/8/29.
 */

public class SpecialFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MeiZiMainContract.SpecialView {
    @InjectPresenter
    MeiZiMainPresenter presenter;


    private TitleBean titleBean;

    public static SpecialFragment newInstance(TitleBean titleBean) {
        SpecialFragment fragment = new SpecialFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initSpecialDatas(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_jdxsxpspecial;
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
        return getViewById(R.id.rcv_jdxsxp_commonlayout);
    }
}