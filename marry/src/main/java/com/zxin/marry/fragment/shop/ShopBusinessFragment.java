package com.zxin.marry.fragment.shop;

import android.os.Bundle;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.DiscoveryPresenter;
import com.zxin.marry.mvp.view.MainDiscoveryContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/27.
 */

public class ShopBusinessFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MainDiscoveryContract.ShopBusinessView{
    private String scId;
    private String name;
    private String cityId;

    @InjectPresenter
    DiscoveryPresenter presenter;

    public static ShopBusinessFragment newInstance(String scId,String name,String cityId) {
        ShopBusinessFragment fragment = new ShopBusinessFragment();
        Bundle args = new Bundle();
        args.putString("scId", scId);
        args.putString("name", name);
        args.putString("cityId", cityId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        scId = getArguments().getString("scId");
        name = getArguments().getString("name");
        cityId = getArguments().getString("cityId");
        presenter.initShopBusinessDatas(this,scId,name,cityId);
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
