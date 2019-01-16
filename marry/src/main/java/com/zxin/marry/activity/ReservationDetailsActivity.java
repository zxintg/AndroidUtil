package com.zxin.marry.activity;

import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;

/**
 * Created by Administrator on 2018/6/29.
 */

public class ReservationDetailsActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_reservation_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }
}
