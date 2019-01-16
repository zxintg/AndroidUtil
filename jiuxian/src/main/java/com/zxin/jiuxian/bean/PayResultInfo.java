package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

public class PayResultInfo {
    @JSONField(name = "alipay")
    public String mAlipay;
    @JSONField(name = "bestpay")
    public String mBestpay;
    @JSONField(name = "jdpay")
    public JdPayBean mJdPayBean;
    @JSONField(name = "unionPay")
    public String mUnionPay;
    @JSONField(name = "wechat")
    public WechatBean mWechat;

    public static boolean isValidData(String paramString) {
        return TextUtils.isEmpty(paramString) ^ true;
    }

    public static class JdPayBean {
        @JSONField(name = "orderId")
        public String mOrderId;
        @JSONField(name = "signData")
        public String mSignData;
    }

    public static class WechatBean {
        @JSONField(name = "appId")
        public String mAppId;
        @JSONField(name = "noncestr")
        public String mNoncestr;
        @JSONField(name = "packageStr")
        public String mPackageStr;
        @JSONField(name = "partner_id")
        public String mPartnerId;
        @JSONField(name = "prepay_id")
        public String mPrepayId;
        @JSONField(name = "sign")
        public String mSign;
        @JSONField(name = "timestamp")
        public String mTimestamp;
    }
}
