package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityTopicZanResult {
    @JSONField(name = "alreadyPraise")
    public boolean mAlreadyPraise;
    @JSONField(name = "success")
    public boolean mSuccess;
    @JSONField(name = "id")
    public int mTid;
}
