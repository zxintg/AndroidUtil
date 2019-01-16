package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityReportTypeResult {
    public boolean mChecked = false;
    public int mReportType = -1;
    @JSONField(name = "title")
    public String mTitle;
}
