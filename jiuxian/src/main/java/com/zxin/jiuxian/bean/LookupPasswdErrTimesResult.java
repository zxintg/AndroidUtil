package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class LookupPasswdErrTimesResult {
    @JSONField(name = "errtimesnum")
    public int mErrtimesnum;
    @JSONField(name = "returnMessage")
    public String mReturnMessage;
}
