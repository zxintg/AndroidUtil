package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityMsgReadOrDelResult {
    @JSONField(name = "success")
    public boolean mSuccess;
    @JSONField(name = "id")
    public int mTid;
}