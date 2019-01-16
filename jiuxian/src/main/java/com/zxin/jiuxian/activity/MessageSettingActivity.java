package com.zxin.jiuxian.activity;

import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MessageSettingActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title, R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_message_setting;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }
}
