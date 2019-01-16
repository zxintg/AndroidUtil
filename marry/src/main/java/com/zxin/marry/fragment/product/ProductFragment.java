package com.zxin.marry.fragment.product;

import android.os.Bundle;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.mvp.presenter.ProductPresenter;
import com.zxin.marry.mvp.view.ProductContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/26.
 */

public class ProductFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,ProductContract.ProductListView {
    private TitleBean titleBean;

    @InjectPresenter
    ProductPresenter presenter;

    public static ProductFragment newInstance(TitleBean titleBean) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setLazyLoadingListener(this);
        presenter.initProductListDatas(this,titleBean);
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
        presenter.getProductList(titleBean.id2,1,"");
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_mine_commonlayout);
    }
}
