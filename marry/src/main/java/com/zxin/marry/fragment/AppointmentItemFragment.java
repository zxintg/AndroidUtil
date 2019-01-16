package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class AppointmentItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,OrderContract.AppointmentListView {
    @InjectPresenter
    OrderPresenter presenter;

    private String appointment_isfeed;

    public static AppointmentItemFragment newInstance(String appointment_isfeed) {
        AppointmentItemFragment fragment = new AppointmentItemFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, appointment_isfeed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        appointment_isfeed = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initAppointmentItemDatas(this,appointment_isfeed);
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
