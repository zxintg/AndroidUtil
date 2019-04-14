package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class CollectionItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,CommonContract.MineCollectView {
    private String fav_type;
    @InjectPresenter
    CommonPresenter presenter;

    public static CollectionItemFragment newInstance(String fav_type) {
        CollectionItemFragment fragment = new CollectionItemFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, fav_type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        fav_type = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initCollectionItemDatas(this,fav_type);
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
