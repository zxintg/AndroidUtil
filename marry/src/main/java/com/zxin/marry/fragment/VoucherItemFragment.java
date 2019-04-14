package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class VoucherItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,OrderContract.VoucherItemView {

    @InjectPresenter
    OrderPresenter presenter;

    private String voucher_state;

    public static VoucherItemFragment newInstance(String voucher_state) {
        VoucherItemFragment fragment = new VoucherItemFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, voucher_state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        voucher_state = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initVoucherOrderDatas(this,voucher_state);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.common_refresh_notitle;
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

