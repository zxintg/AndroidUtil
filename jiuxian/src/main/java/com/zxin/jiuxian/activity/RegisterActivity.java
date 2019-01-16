package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.view.View;

import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class RegisterActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.register_user_agreement,R.id.register_next_btn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
        if (v.getId()==R.id.register_user_agreement){
            HtmlJumpUtil.toWebForUrlActivity("用户注册协议","http://special.jiuxian.com/mobile/Agreement/?deeplink=1&suptwebp=1");
        }
        if (v.getId()==R.id.register_next_btn){
            startActivity(new Intent(mContext, RegisterFindPWNextActivity.class));
        }
    }
}
