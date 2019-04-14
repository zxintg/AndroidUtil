package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;

/**
 * Created by Administrator on 2018/8/29.
 */

public class AnalysisFragment extends BaseFragment implements BaseFragment.LazyLoadingListener ,MeiZiMainContract.AnalysisView {
    @InjectPresenter
    MeiZiMainPresenter presenter;

    private TitleBean titleBean;

    public static AnalysisFragment newInstance(TitleBean titleBean) {
        AnalysisFragment fragment = new AnalysisFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initAnalysisDatas(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_jdxsxpanalysis;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getArticleListApi();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_jdxsxp_commonlayout);
    }
}
