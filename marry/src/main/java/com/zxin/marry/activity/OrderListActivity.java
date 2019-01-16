package com.zxin.marry.activity;

import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class OrderListActivity extends BaseActivity implements OrderContract.MyMarryOrderView{

    @InjectPresenter
    OrderPresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initDatas(this,"2");
    }

    @Override
    public int setLayout() {
        return R.layout.activity_order_list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRecyclerView() {
        return getViewById(R.id.rcv_oeder_commonlayout);
    }
}
