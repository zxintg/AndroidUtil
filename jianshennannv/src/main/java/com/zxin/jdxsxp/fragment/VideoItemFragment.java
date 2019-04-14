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
 * Created by Administrator on 2018/8/29.
 */

public class VideoItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,XiGuaMainContract.VideoItemView{
    @InjectPresenter
    XiGuaMainPresenter presenter;

    private int titleBean;

    public static VideoItemFragment newInstance(int titleBean) {
        VideoItemFragment fragment = new VideoItemFragment();
        Bundle args = new Bundle();
        args.putInt(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getInt(StringUtils.FRAGMENT_DATA);
        presenter.initVideoItemDatas(this,titleBean);
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
