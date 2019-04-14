package com.zxin.meziyowu.base;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.View;

import com.zxin.meziyowu.R;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.dialog.ConfirmDialog;

import org.greenrobot.eventbus.EventBus;


/*****
 * 基础
 */
public abstract class BaseFragment extends com.zxin.basemodel.fragment.BaseFragment {

    private View view;

    @Override
    public void initBaseDatas(View view) {
        this.view = view;
        if (StringUtils.EventBusFragmentNames.contains(this.getClass().getName()) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (StringUtils.EventBusFragmentNames.contains(this.getClass().getName())) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void setViewOnclick(int... viewId) {
        for (int id : viewId) {
            this.view.findViewById(id).setOnClickListener(this);
        }
    }

    public void setTitleViewOnclick(int fatherId,int... childId){
        CommonCrosswiseBar father = getViewById(fatherId);
        for (int id:childId){
            father.setOnClickListener(id,this);
        }
    }

    public <T> T getViewById(int viewId) {
        return (T)this.view.findViewById(viewId);
    }


    /****
     * 如果拒绝授予权限,且勾选了再也不提醒
     * @param contentStr
     */
    public void showPremissionDialog(String contentStr) {
        ConfirmDialog dialog =  ConfirmDialog.newInstance("提示","您已禁止了 "+ contentStr + "<br/>设置路径：设置 ->应用管理 ->" + SystemInfoUtil.getApplicationName() + " ->权限", "取消", "设置");
        dialog.setMessageGravity(Gravity.LEFT);
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
