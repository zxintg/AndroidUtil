package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class TopicItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MainTopicContract.MineTopicView {
    private String type;

    @InjectPresenter
    TopicPresenter presenter;

    public static TopicItemFragment newInstance(String type) {
        TopicItemFragment fragment = new TopicItemFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        type = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initMineTopicViewDatas(this,type);
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
