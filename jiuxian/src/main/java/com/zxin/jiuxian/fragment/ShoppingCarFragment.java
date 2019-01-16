package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.zxinlib.bean.TitleBean;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ShoppingCarFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;

    public static ShoppingCarFragment newInstance(TitleBean titleBean) {
        ShoppingCarFragment fragment = new ShoppingCarFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_cart;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {

    }
}
