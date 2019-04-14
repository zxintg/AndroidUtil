package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/8/31.
 */

public class FindBaiDuFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MeiZiMainContract.FindBaiDuView {
    @InjectPresenter
    MeiZiMainPresenter presenter;

    private String title;
    public static FindBaiDuFragment newInstance(String titleBean) {
        FindBaiDuFragment fragment = new FindBaiDuFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        title = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initFindBaiDuDatas(this,title);
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
