package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class SearchConpon {
    @JSONField(name = "errorInfo")
    public String mErrorInfo;
    @JSONField(name = "pick")
    public boolean mPick;
}

