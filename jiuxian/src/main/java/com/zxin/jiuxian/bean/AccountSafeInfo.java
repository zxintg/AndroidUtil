package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2018/8/6.
 */
public class AccountSafeInfo {
    @JSONField(name = "isBing")
    public int mIsBing;
    @JSONField(name = "notCompleteAuthorization")
    public boolean mIsRealNameVerified;
    @JSONField(name = "loginWay")
    public int mLoginWay;
    @JSONField(name = "mobile")
    public String mMobile;
    @JSONField(name = "notCompleteMobile")
    public boolean mNotCompleteMobile;
    @JSONField(name = "setupPaymentPassword")
    public boolean mSetupPaymentPassword;
    @JSONField(name = "identityVerifyUrl")
    public String mVerifyUrl;
}