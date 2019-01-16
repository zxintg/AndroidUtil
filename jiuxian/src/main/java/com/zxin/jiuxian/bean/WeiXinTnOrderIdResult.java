package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WeiXinTnOrderIdResult {
    @JSONField(name = "noncestr")
    public String mNonce;
    @JSONField(name = "package")
    public String mPackage;
    @JSONField(name = "prepay_id")
    public String mPrepayId;
    @JSONField(name = "sign")
    public String mSign;
    @JSONField(name = "timestamp")
    public String mTimestamp;
}
