package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.mvp.presenter.ClassiftyPresenter;
import com.zxin.jiuxian.mvp.view.ClassiftyContract;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ClassifyAllFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,ClassiftyContract.ClassifyAllView {
    @InjectPresenter
    ClassiftyPresenter presenter;

    private TitleBean titleBean;

    public static ClassifyAllFragment newInstance(TitleBean titleBean) {
        ClassifyAllFragment fragment = new ClassifyAllFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initClassifyAllDatas(this);
        setLazyLoadingListener(this);
    }
    @Override
    public int setLayout() {
        return R.layout.common_recycle_notitle;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getCategoryAllDetail(String.valueOf(titleBean.id));
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.rv_recycle_review);
    }
}
