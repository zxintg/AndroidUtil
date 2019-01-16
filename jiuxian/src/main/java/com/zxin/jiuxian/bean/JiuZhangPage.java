package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class JiuZhangPage {
    @JSONField(name = "attrs")
    public Object mAttrs;
    @JSONField(name = "duration")
    public String mDuration;
    @JSONField(name = "id")
    public String mJiu_Id;
    @JSONField(name = "LatiTid")
    public String mLatiTid;
    @JSONField(name = "LongiTid")
    public String mLongiTid;
    @JSONField(name = "pageState")
    public String mPageState;
    @JSONField(name = "pageTag")
    public String mPageTag;
    @JSONField(name = "time")
    public String mTime;
    @JSONField(name = "uid")
    public String mUserId;
}