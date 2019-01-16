package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.view.X5WebView;

/**
 * Created by Administrator on 2018/8/17.
 */

public class ProductDetailFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private X5WebView x5WebView;
    private TitleBean titleBean;

    public static ProductDetailFragment newInstance(TitleBean titleBean) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        x5WebView = getViewById(R.id.xwv_product_detail);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_product_detail;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        x5WebView.loadUrl("https://m.jiuxian.com/m_v1/goods/description/"+titleBean.id2+"?flag=andriod");
    }
}
