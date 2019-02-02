package com.zxin.activity;

import android.view.View;
import com.zxin.R;
import com.zxin.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/12.
 */

public class EditDropDownMenuActivity extends BaseActivity {
    @Override
    public void initData() {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_editdropmenu;
    }

    @OnClick({R.id.common_bar_leftBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;
        }
    }
}
