package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/9/5.
 */

public class UserDynamicFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,XiGuaMainContract.UserDynamicView {
    private int toUserId;
    @InjectPresenter
    XiGuaMainPresenter presenter;

    public static UserDynamicFragment newInstance(int toUserId) {
        UserDynamicFragment fragment = new UserDynamicFragment();
        Bundle args = new Bundle();
        args.putInt(StringUtils.FRAGMENT_DATA, toUserId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        toUserId = getArguments().getInt(StringUtils.FRAGMENT_DATA);
        presenter.initUserDynamicDatas(this,toUserId);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_dynamic;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBar() {
        return getViewById(R.id.ccb_jdxsxp_title);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_mine_commonlayout);
    }
}
