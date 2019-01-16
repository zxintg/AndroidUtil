package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class ExchangeProductResult {
    public static final String ALREADY_IN_CART = "1100106";
    public static final String USER_NOT_REAL_NAME = "1100105";
    @JSONField(name = "msg")
    public String mMsg;
    @JSONField(name = "identityVerifyUrl")
    public String mUrl;
}
