package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

public class OrderTrace {
    @JSONField(name = "createTime")
    public long mCreateTime;
    @JSONField(name = "traceInfo")
    public String mTraceInfo;
}

