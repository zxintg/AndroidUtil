package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/5.
 */

public class WallPaperItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MeiZiMainContract.WallPaperItemView{
    private TitleBean titleBean;
    @InjectPresenter
    MeiZiMainPresenter presenter;

    public static WallPaperItemFragment newInstance(TitleBean titleBean) {
        WallPaperItemFragment fragment = new WallPaperItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initWallPaperItemDatas(this,titleBean);
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
    public RefreshCommonView getRefreshCommonView() {
        return (RefreshCommonView) getViewById(R.id.rcv_mine_commonlayout);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }

}
