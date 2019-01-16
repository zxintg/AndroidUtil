package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.view.View;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class FindPasswordActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.register_next_btn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_findpwd;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
        if (v.getId()==R.id.register_next_btn){
            startActivity(new Intent(mContext, RegisterFindPWNextActivity.class));
        }
    }
}
