package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

/**
 * Created by Administrator on 2018/8/3.
 */

public class JIuXianSettingActivity extends BaseActivity {
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title, R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ccb_setting_msgpush,R.id.ccb_setting_encouragerela, R.id.ccb_setting_about);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_jiuxian_setting;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
        if (v.getId() == R.id.ccb_setting_msgpush) {
            //消息推送设置
            startActivity(new Intent(mContext, MessageSettingActivity.class));
        }
        if (v.getId() == R.id.ccb_setting_encouragerela) {
            //鼓励一下
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setData(Uri.parse("market://details?id=com.jiuxianapk.ui"));
            localIntent.addFlags(268435456);
            startActivity(localIntent);
        }
        if (v.getId() == R.id.ccb_setting_about) {
            //关于我们
            startActivity(new Intent(mContext, AboutUsActivity.class));
        }
    }
}
