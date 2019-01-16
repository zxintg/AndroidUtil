package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class SafeResult {
    @JSONField(name = "detailInfo")
    public String mSafeDetail;
    @JSONField(name = "remindInfo")
    public String mSafeInfo;
}

