package com.zxin.marry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/20.
 */

public class ShootStrategyActivity extends BaseActivity implements OrderContract.CameraStrategyView {
    private String orderid;
    private String shopId;

    @InjectPresenter
    OrderPresenter presenter;

    @Override
    public void initData() {
        orderid = getIntent().getStringExtra("orderid");
        shopId = getIntent().getStringExtra("shopId");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.iv_left_interior,R.id.iv_right_exterior,R.id.tv_bottom_btn);
        presenter.initShootStrategyDatas(this,orderid,shopId);
        presenter.getCameraStrategyDetail(orderid,shopId);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_shoot_strategy;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }
        presenter.OnClick(v);
    }

    @Override
    public ImageView mImageBgView() {
        return getViewById(R.id.iv_bg);
    }
}
