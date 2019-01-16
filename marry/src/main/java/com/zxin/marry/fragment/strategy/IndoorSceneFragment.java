package com.zxin.marry.fragment.strategy;

import android.os.Bundle;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/11.
 */

public class IndoorSceneFragment extends BaseFragment implements BaseFragment.LazyLoadingListener ,OrderContract.IndoorSceneView {
    private String orderid,shopid,showouter;

    @InjectPresenter
    OrderPresenter presenter;

    public static IndoorSceneFragment newInstance(String mOrderId,String mShopid,String showouter) {
        IndoorSceneFragment fragment = new IndoorSceneFragment();
        Bundle args = new Bundle();
        args.putString("orderid", mOrderId);
        args.putString("shopid", mShopid);
        args.putString("showouter", showouter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        orderid = getArguments().getString("orderid");
        shopid = getArguments().getString("shopid");
        showouter = getArguments().getString("showouter");
        presenter.initIndoorSceneDatas(this,orderid,shopid,showouter);

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
