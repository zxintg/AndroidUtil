package com.zxin.jdxsxp.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.util.MeiNvPicturePreferences;
import com.zxin.router.annotation.Route;

/**
 * Created by Administrator on 2018/8/29.
 */
@Route("jdxsxp/JdxsxpSplashActivity")
public class JdxsxpSplashActivity extends BaseActivity {
    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MeiNvPicturePreferences.getUserInfos()==null){
                    startActivity(new Intent(mContext, UserLoginActivity.class));
                    onBackPressed();
                    return;
                }
                startActivity(new Intent(mContext, MainActivity.class));
                onBackPressed();
            }
        }, 500);
    }

    @Override
    public int setLayout() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }
}
