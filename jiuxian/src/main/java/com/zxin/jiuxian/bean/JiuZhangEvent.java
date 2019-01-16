package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class JiuZhangEvent {
    @JSONField(name = "attrs")
    public Object mAttrs;
    @JSONField(name = "duration")
    public String mDuration;
    @JSONField(name = "eventId")
    public String mEventId;
    @JSONField(name = "id")
    public String mJiu_Id;
    @JSONField(name = "LatiTid")
    public String mLatiTid;
    @JSONField(name = "LongiTid")
    public String mLongiTid;
    @JSONField(name = "time")
    public String mTime;
    @JSONField(name = "uid")
    public String mUserId;
}
