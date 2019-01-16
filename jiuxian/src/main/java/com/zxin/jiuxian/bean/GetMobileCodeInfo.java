package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class GetMobileCodeInfo {
    @JSONField(name = "MOBILE_EXIST")
    public boolean mMOBILE_EXIST;
    @JSONField(name = "SMS_SUCCESS")
    public boolean mSMS_SUCCESS;
    @JSONField(name = "userHeadImg")
    public String mUserHeadImg;
    @JSONField(name = "userName")
    public String mUserName;
}
