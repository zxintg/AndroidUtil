package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class HotKeyword {
    @JSONField(name = "hotKeywords")
    public List<HotKeywords> mHotKeywords;

    public static class HotKeywords {
        @JSONField(name = "activityUrl")
        public String mActivityUrl;
        @JSONField(name = "color")
        public String mColor;
        @JSONField(name = "keyword")
        public String mKeyword;
    }
}
