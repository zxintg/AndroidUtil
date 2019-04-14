package com.zxin.marry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/13.
 */

public class ShippingAddressActivity extends BaseActivity implements CommonContract.MineAddressView {
    @InjectPresenter
    CommonPresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        presenter.initShippingAddressDatas(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_address;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext,AddShippingAddressActivity.class));
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_address_commonlayout);
    }

    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11011:
                getRefreshCommonView().notifyData();
                break;
        }
        return false;
    }

}
