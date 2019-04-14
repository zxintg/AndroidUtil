package com.zxin.jdxsxp.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseFragment;
import com.zxin.jdxsxp.mvp.presenter.MeiZiMainPresenter;
import com.zxin.jdxsxp.mvp.view.MeiZiMainContract;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.jdxsxp.util.TitleBarUtil;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;

/**
 * Created by Administrator on 2018/8/29.
 */

public class FindFragment extends BaseFragment implements BaseFragment.LazyLoadingListener , MeiZiMainContract.FindView {
    private TitleBean titleBean;
    @InjectPresenter
    MeiZiMainPresenter presenter;

    public static FindFragment newInstance(TitleBean titleBean) {
        FindFragment fragment = new FindFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initFindDatas(this);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_jdxsxpfind;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getMeiNvLocalList();
    }

    @Override
    public LinearLayout getHeadView() {
        return getViewById(R.id.ll_find_head);
    }

    @Override
    public SearchView getSearchView() {
        return getViewById(R.id.et_find_search);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_find_content);
    }
}

