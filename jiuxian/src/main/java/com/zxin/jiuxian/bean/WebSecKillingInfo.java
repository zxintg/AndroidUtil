package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

public class WebSecKillingInfo {
    public static final int BINDPHONECODE = 3;
    public static final int SUCCESSCODE = 0;
    @JSONField(name = "desc")
    public String mMsg;
    @JSONField(name = "status")
    public int mStatusCode;
}
