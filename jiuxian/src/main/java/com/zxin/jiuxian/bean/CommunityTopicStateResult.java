package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityTopicStateResult {
    @JSONField(name = "hasReport")
    public boolean mHasReport;
    @JSONField(name = "state")
    public String mState;
    @JSONField(name = "tid")
    public int mTid;
}
