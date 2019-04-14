package com.zxin.marry.activity;

import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.PhotoGrapherPresenter;
import com.zxin.marry.mvp.view.PhotoGrapherContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/21.
 */

public class ReserveRecordActivity extends BaseActivity implements PhotoGrapherContract.ReserveRecordView  {
    @InjectPresenter
    PhotoGrapherPresenter presenter;

    private String orderId;
    @Override
    public void initData() {
        orderId = getIntent().getStringExtra("orderId");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initReserveRecordDatas(this,orderId);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_payment_record;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_record_commonlayout);
    }

}
