package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.zxin.jiuxian.api.BasePathUrl;
import com.zxin.jiuxian.api.BaseUrlUtil;
import com.zxin.jiuxian.api.RequestParameter;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.jiuxian.service.WelcomeImageDownloadService;
import com.zxin.jiuxian.util.JiuXianSharedPreferences;
import com.zxin.router.annotation.Route;

/**
 * Created by Administrator on 2018/8/3.
 */
@Route("jiuxian/LogoActivity")
public class LogoActivity extends BaseActivity {
    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initDatas();
                //是否第一次安装
                if (JiuXianSharedPreferences.getIsFirstEnter())
                    startActivity(new Intent(mContext, GuideActivity.class));
                else {
                    startService(new Intent(mContext, WelcomeImageDownloadService.class));
                    startActivity(new Intent(mContext, MainActivity.class));
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

    private void initDatas() {
        if (JiuXianSharedPreferences.key_start_crash() && !TextUtils.equals(JiuXianSharedPreferences.key_start_crash_version(), RequestParameter.VersionName)) {
            JiuXianSharedPreferences.key_start_crash(false);
            JiuXianSharedPreferences.key_start_crash_version(null);
        }
        if (BaseUrlUtil.isLog) {
            //com.jiuxian.a.a.a(BaseUrlUtil.isLog);
        }
        BasePathUrl.getUrlPath(BaseUrlUtil.a());
    }

}
