package com.zxin.jiuxian.activity;

import android.app.Activity;
import android.view.View;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class FootPrintActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title, R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_foot_print;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }
}
