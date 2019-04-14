package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/9/7.
 */

public class SearchItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener ,XiGuaMainContract.SearchItemView {
    @InjectPresenter
    XiGuaMainPresenter presenter;
    private int tag;

    public static SearchItemFragment newInstance(int tag) {
        SearchItemFragment fragment = new SearchItemFragment();
        Bundle args = new Bundle();
        args.putInt(StringUtils.FRAGMENT_DATA, tag);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        tag = getArguments().getInt(StringUtils.FRAGMENT_DATA);
        presenter.initSearchItemDatas(this,tag);
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

    //接受event事件
    @Override
    public void onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11021://收藏刷新
                presenter.searchItemDatasNotify(bundle.getString(StringUtils.EVENT_DATA));
                break;
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_mine_commonlayout);
    }
}
