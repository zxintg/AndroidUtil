package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class PayOrderItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,OrderContract.PayOrderItemView {
    private String order_state;
    @InjectPresenter
    OrderPresenter presenter;

    public static PayOrderItemFragment newInstance(String order_state) {
        PayOrderItemFragment fragment = new PayOrderItemFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, order_state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        order_state = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initPayOrderItemDatas(this,order_state,getChildFragmentManager());
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
