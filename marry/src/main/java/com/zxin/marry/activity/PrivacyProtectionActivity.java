package com.zxin.marry.activity;

import android.view.View;
import android.widget.TextView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.root.util.UiUtils;

/**
 * Created by Administrator on 2018/7/1.
 */

public class PrivacyProtectionActivity extends BaseActivity {

    @Override
    public void initData() {
        TextView textView = getViewById(R.id.my_text);
        textView.setText(UiUtils.getFromAssets("text.txt"));
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_privacy_protection;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }
}
