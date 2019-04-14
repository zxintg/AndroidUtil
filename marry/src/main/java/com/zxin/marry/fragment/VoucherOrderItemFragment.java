package com.zxin.marry.fragment;

import android.os.Bundle;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.util.StringUtils;
import com.zxin.root.bean.TitleBean;

/**
 * Created by Administrator on 2018/6/13.
 */

public class VoucherOrderItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener {
    private TitleBean titleBean;

    public static VoucherOrderItemFragment newInstance(TitleBean titleBean) {
        VoucherOrderItemFragment fragment = new VoucherOrderItemFragment();
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
        return R.layout.common_refresh_notitle;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {

    }
}