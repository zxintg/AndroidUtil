package com.zxin.marry.activity;

import android.content.Intent;
import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MarryAboutActivity extends BaseActivity {

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ll_service);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_about_company;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.ll_service){
            startActivity(new Intent(mContext,PrivacyProtectionActivity.class));
        }
    }
}
