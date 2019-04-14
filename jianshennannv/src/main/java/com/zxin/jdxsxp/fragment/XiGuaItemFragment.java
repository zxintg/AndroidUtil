package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/9/5.
 */

public class XiGuaItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,XiGuaMainContract.XiGuaMainItemView {
    @InjectPresenter
    XiGuaMainPresenter presenter;

    private int typeId;

    public static XiGuaItemFragment newInstance(int typeId) {
        XiGuaItemFragment fragment = new XiGuaItemFragment();
        Bundle args = new Bundle();
        args.putInt(StringUtils.FRAGMENT_DATA, typeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        typeId = getArguments().getInt(StringUtils.FRAGMENT_DATA);
        presenter.initXiGuaItemDatas(this,typeId);
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
