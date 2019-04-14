package com.zxin.marry.activity;

import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.SharedPreferencesManager;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MarrySettingActivity extends BaseActivity {

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ll_updatepassword,R.id.ll_cache,R.id.tv_unloging);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_marraysetting;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.ll_updatepassword){
            //修改密码

        }else if (v.getId()==R.id.ll_cache){
            //缓存

        }else if (v.getId()==R.id.tv_unloging){
            SharedPreferencesManager.clearMarryDatas();
            AppManager.getAppManager().goToActivityForName("com.zxin.activity.MainActivity");
        }
    }
}
