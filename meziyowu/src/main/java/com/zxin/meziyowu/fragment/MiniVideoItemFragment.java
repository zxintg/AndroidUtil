package com.zxin.meziyowu.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseFragment;
import com.zxin.meziyowu.mvp.presenter.YoMeiMainPresenter;
import com.zxin.meziyowu.mvp.view.YoMeiMainContract;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/9/28.
 */

public class MiniVideoItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,YoMeiMainContract.MiniVideoItemView{
    @InjectPresenter
    YoMeiMainPresenter presenter;

    private int titleBean;

    public static MiniVideoItemFragment newInstance(int titleBean) {
        MiniVideoItemFragment fragment = new MiniVideoItemFragment();
        Bundle args = new Bundle();
        args.putInt(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getInt(StringUtils.FRAGMENT_DATA);
        presenter.initMiniVideoItemDatas(this,titleBean);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.common_refresh_notitle2;
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
        return getViewById(R.id.rcv_mine_commonlayout);
    }
}
