package com.zxin.marry.fragment.topic;

import android.os.Bundle;
import android.view.View;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/7/3.
 */

public class HotNewsItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,MainTopicContract.HotNewsItemView {

    private String term_id;
    @InjectPresenter
    TopicPresenter presenter;

    public static HotNewsItemFragment newInstance(String term_id) {
        HotNewsItemFragment fragment = new HotNewsItemFragment();
        Bundle args = new Bundle();
        args.putString(StringUtils.FRAGMENT_DATA, term_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        term_id = getArguments().getString(StringUtils.FRAGMENT_DATA);
        presenter.initHotNewsItemDatas(this,term_id);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return  R.layout.frag_hot;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        getRefreshCommonView().notifyData();
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.cb_slidePage);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_hotnews_commonlayout);
    }
}
