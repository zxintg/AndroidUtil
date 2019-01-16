package com.zxin.marry.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/7/11.
 */

public class PickUpDetailsActivity extends BaseActivity implements OrderContract.PickUpDetailsView {
    private String shopId,orderId;

    @InjectPresenter
    OrderPresenter presenter;

    @Override
    public void initData() {
        orderId = getIntent().getStringExtra("orderid");
        shopId = getIntent().getStringExtra("shopid");
        presenter.initPickUpDetailsDatas(this,orderId,shopId);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.getPickUpDetails(orderId,shopId);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_pick_up_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getViewById(R.id.lv_pick_up);
    }
}
