package com.zxin.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.zxin.base.BaseActivity;
import com.zxin.root.app.SystemPersimManage;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SharedPreferencesManager;

/******
 * 闪屏页
 */
public class SplashActivity extends BaseActivity {

    private SystemPersimManage manage = null;

    @Override
    public void initData() {
        //设置别名
        switchLoginAndMain();
    }

    private void switchLoginAndMain(){
        new SystemPersimManage(mContext){
            @Override
            public void resultPerm(boolean isCan, int requestCode) {
                if (isCan){
                    goActivity();
                }
            }
        }.CheckedFile();
    }

    @Override
    public int setLayout() {
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == IntegerUtil.PERMISSION_REQUEST_FILE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                goActivity();
            } else {
                showPremissionDialog("访问设备存储空间");
            }
        }
    }

    long startTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - startTime < 2000) {
                AppManager.getAppManager().AppExit();
            } else {
                startTime = System.currentTimeMillis();
                Toast.makeText(this, "再次点击退出应用程序", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

    private void goActivity(){
        //是否第一次安装
        if(SharedPreferencesManager.getIsFirstEnter())
            startActivity(new Intent(SplashActivity.this, GuideActivity.class) );
        else
            startActivity(new Intent(mContext,MainActivity.class));
        onBackPressed();
    }
}
