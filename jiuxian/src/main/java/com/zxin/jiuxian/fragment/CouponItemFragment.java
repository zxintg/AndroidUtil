package com.zxin.jiuxian.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseFragment;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.zxinlib.bean.TitleBean;

/**
 * Created by Administrator on 2018/8/8.
 */

public class CouponItemFragment extends BaseFragment implements BaseFragment.LazyLoadingListener{
    private TitleBean titleBean;
    private TextView tv_item;

    public static CouponItemFragment newInstance(TitleBean titleBean) {
        CouponItemFragment fragment = new CouponItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setLazyLoadingListener(this);
        tv_item = getViewById(R.id.tv_item);
    }
    @Override
    public int setLayout() {
        return R.layout.fragment_itemcoupon;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        tv_item.setText(titleBean.label);
    }
}
