package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class MessageCenterQueryResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "totalCount")
    public int mCount;
    @JSONField(name = "logistisCount")
    public int mLogistisCount;
    @JSONField(name = "promotCount")
    public int mPromotCount;
}
