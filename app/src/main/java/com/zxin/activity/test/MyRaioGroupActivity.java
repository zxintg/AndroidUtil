package com.zxin.activity.test;

import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.group.MyRadioGroupView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/29.
 */

public class MyRaioGroupActivity extends BaseActivity implements MyRadioGroupView.OnCheckedChangeListener {
    @BindView(R.id.mrg_myradiogroup)
    MyRadioGroupView group;

    @Override
    public void initData() {
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_myraiogroup;
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

    @Override
    public void onCheckedChanged(View v, boolean isChecked, String mesg) {
        ToastUtil.showShort("点击了："+mesg);
    }
}
