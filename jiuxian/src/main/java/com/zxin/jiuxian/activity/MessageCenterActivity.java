package com.zxin.jiuxian.activity;

import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MessageCenterActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_message_center;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
        if (v.getId()==R.id.common_bar_rightBtn){
           //消息设置

        }
    }
}
