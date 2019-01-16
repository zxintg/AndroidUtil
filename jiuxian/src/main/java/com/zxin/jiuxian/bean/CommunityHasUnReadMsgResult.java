package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityHasUnReadMsgResult {
    @JSONField(name = "has")
    public boolean mHasUnRead;
    @JSONField(name = "id")
    public int mTid;
}
