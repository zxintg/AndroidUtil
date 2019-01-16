package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class PromotionInfoListResult {
    @JSONField(name = "location")
    public int mLocation;
    @JSONField(name = "content")
    public String mPromotionContent;
}

