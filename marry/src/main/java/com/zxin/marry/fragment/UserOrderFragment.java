package com.zxin.marry.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.activity.MessageActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.OrderBean;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.view.PagerSlidingVerTabStrip;
import com.zxin.root.view.MyViewPager;

/**
 * Created by Administrator on 2018/6/5.
 */

public class UserOrderFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,OrderContract.MarryOrderView {
    private TitleBean titleBean;
    @InjectPresenter
    OrderPresenter presenter;

    public static UserOrderFragment newInstance(TitleBean titleBean) {
        UserOrderFragment fragment = new UserOrderFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, titleBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        titleBean = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        setView();
    }

    private void setView() {
        presenter.initMainDatas(this,titleBean,getChildFragmentManager());
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_rightBtn);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_order;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_rightBtn){
            mContext.startActivity(new Intent(mContext, MessageActivity.class));
            return;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private boolean isFirstLoad = true;
    @Override
    public void loadLazyDatas(boolean bool) {
        if (isFirstLoad)
            presenter.getOrderByType("2");
        isFirstLoad = false;
    }

    //接受event事件
    @Override
    public void onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11004:
                //订单详情
                if (isFirstLoad)
                    return;
                OrderBean orderBean = bundle.getParcelable(StringUtils.EVENT_DATA);
                presenter.getOrderProgress(orderBean.getOrderid(),orderBean.getShopid());
                break;
        }
    }

    @Override
    public PagerSlidingVerTabStrip pstTitleView() {
        return getViewById(R.id.pst_order_title);
    }

    @Override
    public MyViewPager mOrderPagerView() {
        return getViewById(R.id.vvp_order_fragment);
    }
}
