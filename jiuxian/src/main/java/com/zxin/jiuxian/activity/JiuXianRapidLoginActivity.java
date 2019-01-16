package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.view.View;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class JiuXianRapidLoginActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.login_account);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_rapid_login;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
        if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext, RegisterActivity.class));
        }
        if (v.getId()==R.id.login_account){
            startActivity(new Intent(mContext, JiuXianLoginActivity.class));
        }
    }
}
