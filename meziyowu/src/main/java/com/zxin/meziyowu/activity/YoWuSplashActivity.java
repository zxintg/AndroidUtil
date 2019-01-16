package com.zxin.meziyowu.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.zxin.meziyowu.base.BaseActivity;
import com.zxin.meziyowu.util.YoWuSharedPreferences;
import com.zxin.router.annotation.Route;

/**
 * Created by Administrator on 2018/9/28.
 */
@Route("meziyowu/YoWuSplashActivity")
public class YoWuSplashActivity extends BaseActivity {
    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //是否第一次安装
                if (YoWuSharedPreferences.getIsFirstEnter())
                    startActivity(new Intent(mContext, YoWuGuideActivity.class));
                else {
                    startActivity(new Intent(mContext, YoWuMainActivity.class));
                }
                onBackPressed();
            }
        }, 100);
    }

    @Override
    public int setLayout() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }
}
