package com.zxin.marry.activity;

import android.view.View;
import android.widget.TextView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/20.
 */

public class NewAllStrategyActivity extends BaseActivity implements OrderContract.NewAllStrategyView {
    private String orderid;
    private String shopid;
    private String lineid;

    @InjectPresenter
    OrderPresenter presenter;

    @Override
    public void initData() {
        orderid = getIntent().getStringExtra("orderid");
        shopid = getIntent().getStringExtra("shopid");
        lineid = getIntent().getStringExtra("lineid");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initNewAllStrategyDatas(this,orderid,shopid,lineid);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_all_strategy;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public CommonCrosswiseBar getTitleView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_strategy_commonlayout);
    }

    @Override
    public TextView getTVBottomView() {
        return getViewById(R.id.tv_bottom_btn);
    }
}
