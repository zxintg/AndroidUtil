package com.zxin.activity;

import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.dialog.ConfirmDialog;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/11.
 */

public class SettingActivity extends BaseActivity {
    private ConfirmDialog backDialog;

    private void colseDialog() {
        if (backDialog != null && backDialog.isVisible()) {
            backDialog.dismiss();
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_setting;
    }

    @OnClick({R.id.common_bar_leftBtn,R.id.tv_setting_exit})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.tv_setting_exit:
                //退出
                if(backDialog==null) {
                    backDialog = ConfirmDialog.newInstance("", "您确定要退出吗？", "取消", "确定");
                }
                backDialog.setMargin(60)
                        .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                        .setOutCancel(false)
                        .show();
                backDialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){

                    @Override
                    public void dialogStatusYes() {
                        colseDialog();
                        AppManager.getAppManager().finishAllActivity();
                    }

                    @Override
                    public void dialogStatusNo() {

                    }
                });
                break;
        }
    }
}
