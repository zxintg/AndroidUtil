package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.File;
import java.io.Serializable;

public class CheckUpdateResult implements Serializable {
    public static final int TYPE_CUSTOM = 2;
    public static final int TYPE_FORCE = 1;
    public File mApkFile;
    @JSONField(name = "updateUrl")
    public String mApkUrl;
    @JSONField(name = "updateType")
    public int mForce;
    @JSONField(name = "updateInfo")
    public String mUpdateInfo;
    @JSONField(name = "versionCode")
    public int mVersionCode;
    @JSONField(name = "versionName")
    public String mVersionName;
}

