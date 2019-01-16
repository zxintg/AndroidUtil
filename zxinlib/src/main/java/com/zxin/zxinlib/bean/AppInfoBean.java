package com.zxin.zxinlib.bean;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/**
 * Created by 应用实体 on 2018/4/13.
 */

public class AppInfoBean {
    private String appLabel;
    private Drawable appIcon;
    private Intent intent;
    private String pkgName;
    private String appName;

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}
