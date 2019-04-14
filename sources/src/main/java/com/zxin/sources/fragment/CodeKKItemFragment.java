package com.zxin.sources.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.sources.R;
import com.zxin.sources.base.BaseFragment;
import com.zxin.sources.mvp.presenter.CodeKKPresenter;
import com.zxin.sources.mvp.view.CodeKKContract;
import com.zxin.sources.util.StringUtils;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/5.
 */

public class CodeKKItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,CodeKKContract.CodeView {
    private TitleBean titleBean;

    @InjectPresenter
    CodeKKPresenter presenter;

    public static CodeKKItemFragment newInstance(TitleBean titleBean) {
        CodeKKItemFragment fragment = new CodeKKItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this,titleBean);
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
    public void onDestroy() {
        super.onDestroy();
        // 断开View引用
        if (presenter != null)
            presenter.detachView();
    }

    @Override
    public RefreshCommonView getRecyclerView() {
        return (RefreshCommonView) getViewById(R.id.rcv_mine_commonlayout);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.loadDatas();
    }

}
