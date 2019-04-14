package com.zxin.jdxsxp.base;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.View;

import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.dialog.ConfirmDialog;
import org.greenrobot.eventbus.EventBus;

/**
 * Activity 基类
 * Created by hy
 * 2017/10/24 18:48
 * Note :
 */
public abstract class BaseActivity extends com.zxin.basemodel.activity.BaseActivity {

    private View view;
    @Override
    public void initBaseDatas(View view) {
        this.view = view;
        //  注册时会自动从当前类里面拿取注释为@Produce 和 @Subscribe，解析处理，会发送出来消息
        if (StringUtils.RxBusActivityNames.contains(this.getClass().getName()) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void setTitleViewOnclick(int fatherId, int... childId) {
        CommonCrosswiseBar father = getViewById(fatherId);
        for (int id : childId) {
            father.setOnClickListener(id, this);
        }
    }

    public void setTitleText(int fatherId, String title) {
        CommonCrosswiseBar father = getViewById(fatherId);
        father.setTitleText(title);
    }

    public void setViewOnclick(int... viewId) {
        for (int id : viewId) {
            findViewById(id).setOnClickListener(this);
        }
    }

    public <T> T getViewById(int viewId) {
        return (T) findViewById(viewId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (StringUtils.RxBusActivityNames.contains(this.getClass().getName())) {
            //销毁
            EventBus.getDefault().unregister(this);
        }
    }

    /****
     * 如果拒绝授予权限,且勾选了再也不提醒
     * @param contentStr
     */
    public void showPremissionDialog(String contentStr) {
        ConfirmDialog dialog = ConfirmDialog.newInstance("提示", "您已禁止了 " + contentStr + "<br/>设置路径：设置 ->应用管理 ->" + SystemInfoUtil.getApplicationName() + " ->权限", "取消", "设置");
        dialog.setMessageGravity(Gravity.LEFT);
        dialog.setMargin(60)
                .setWidth(SystemInfoUtil.getScreenWidth() * 2 / 3)
                .setOutCancel(false)
                .show();
        dialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener() {

            @Override
            public void dialogStatusYes() {
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                ActivityCompat.startActivityForResult((Activity) mContext, intent, IntegerUtil.PERMISSION_REQUEST_SETTING, null);
            }

            @Override
            public void dialogStatusNo() {

            }
        });
    }

    public View getCurrentView(){
        return view;
    }

}
