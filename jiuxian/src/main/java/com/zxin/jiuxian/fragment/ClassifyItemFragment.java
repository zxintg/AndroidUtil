package com.zxin.jiuxian.fragment;

import android.os.Bundle;
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

public class ClassifyItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,ClassiftyContract.ClassifyItemView {
    @InjectPresenter
    ClassiftyPresenter presenter;

    private TitleBean titleBean;

    public static ClassifyItemFragment newInstance(TitleBean titleBean) {
        ClassifyItemFragment fragment = new ClassifyItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initClassifyItemDatas(this,String.valueOf(titleBean.id));
        setLazyLoadingListener(this);
    }
    @Override
    public int setLayout() {
        return R.layout.fragment_cate_gridview;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getCategoryDetail(String.valueOf(titleBean.id));
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_cate);
    }

    @Override
    public ConvenientBanner getConvenientBannerView() {
        return getViewById(R.id.convenientBanner);
    }
}
