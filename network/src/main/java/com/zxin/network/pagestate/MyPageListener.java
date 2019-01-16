package com.zxin.network.pagestate;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import com.zxin.network.R;
import com.zxin.zxinlib.util.AppManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.dialog.ConfirmDialog;

/**
 * Created by huangshuisheng on 2017/10/12.
 */

public abstract class MyPageListener extends PageListener {
    @Override
    public void onRetry(View retryView) {
        if (!SystemInfoUtil.isNetworkAvailable()) {
            ConfirmDialog dialog =  ConfirmDialog.newInstance("提示","当前网络不可用", "去设置", "知道了");
            dialog.setMessageGravity(Gravity.CENTER);
            dialog.setMargin(60)
                    .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                    .setOutCancel(false)
                    .show();
            dialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){

                @Override
                public void dialogStatusYes() {
                    //设置界面
                    // 跳转到系统的网络设置界面
                    Intent intent = null;
                    // 先判断当前系统版本
                    if(android.os.Build.VERSION.SDK_INT > 10){  // 3.0以上
                        //intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                        intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                    }else{
                        intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                    }
                    AppManager.getAppManager().currentActivity().startActivity(intent);
                }

                @Override
                public void dialogStatusNo() {

                }
            });
        } else {
            onReallyRetry();
        }
    }

    protected abstract void onReallyRetry();

}
