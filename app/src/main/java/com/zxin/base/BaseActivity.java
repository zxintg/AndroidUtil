package com.zxin.base;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.bugtags.library.Bugtags;
import com.zxin.camera.activity.AlbumActivity;
import com.zxin.camera.activity.CameraActivity;
import com.zxin.util.StringUtils;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.dialog.ConfirmDialog;
import org.greenrobot.eventbus.EventBus;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity 基类
 * Created by hy
 * 2017/10/24 18:48
 * Note :
 */
public abstract class BaseActivity extends com.zxin.basemodel.activity.BaseActivity{
    public Unbinder unbinder;

    @Override
    public void initBaseDatas(View view) {
        unbinder = ButterKnife.bind(this, view);
        //  注册时会自动从当前类里面拿取注释为@Produce 和 @Subscribe，解析处理，会发送出来消息
        if (StringUtils.RxBusActivityNames.contains(this.getClass().getName()) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (StringUtils.RxBusActivityNames.contains(this.getClass().getName())) {
            //销毁
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //注：回调 2
        Bugtags.onPause(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //注：回调 1
        Bugtags.onResume(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //注：回调 3
        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Bugtags.onDispatchKeyEvent(this, event);
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case IntegerUtil.PERMISSION_REQUEST_CAMERA:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(new Intent(mContext, CameraActivity.class));
                } else if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
                    //如果用户点击了不在提醒, 并拒绝之后
                    showPremissionDialog("系统相机、录制视频权限");
                }
                break;

            case IntegerUtil.PERMISSION_REQUEST_ALBUM:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(new Intent(mContext, AlbumActivity.class));
                } else if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    //如果用户点击了不在提醒, 并拒绝之后
                    showPremissionDialog("文件读取权限");
                }
                break;
        }
    }

    /****
     * 如果拒绝授予权限,且勾选了再也不提醒
     * @param contentStr
     */
    public void showPremissionDialog(String contentStr) {
        ConfirmDialog dialog =  ConfirmDialog.newInstance("提示","您已禁止了 "+ contentStr + "\n设置路径：设置 ->应用管理 ->" + SystemInfoUtil.getApplicationName() + " ->权限", "取消", "设置");
        dialog.setMargin(60)
                .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                .setOutCancel(false)
                .show();
        dialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){

            @Override
            public void dialogStatusYes() {
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                ActivityCompat.startActivityForResult((Activity) mContext,intent, IntegerUtil.PERMISSION_REQUEST_SETTING,null);
            }

            @Override
            public void dialogStatusNo() {

            }
        });
    }

}
