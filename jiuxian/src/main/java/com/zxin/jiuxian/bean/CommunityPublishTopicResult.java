package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class CommunityPublishTopicResult {
    @JSONField(name = "id")
    public int ID;
    @JSONField(name = "illegally")
    public ArrayList<String> mIllegallyList;
    @JSONField(name = "sensitivity")
    public ArrayList<String> mSensitivityList;
    @JSONField(name = "success")
    public boolean mSuccess;
}
