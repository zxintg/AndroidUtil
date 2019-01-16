package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class WineActiveTabIconResult {
    @JSONField(name = "flag")
    public String mFlag;
    @JSONField(name = "navList")
    public List<WineIconInfo> mTabLists;

    public static class WineIconInfo {
        public static final String TYPE_ORIGIN_WINE = "1";
        public static final String TYPE_WATERFALL_WINE = "2";
        @JSONField(name = "drakImg")
        public String mDefaultIcon;
        @JSONField(name = "lightImg")
        public String mSelectedIcon;
        @JSONField(name = "style")
        public String mStyle;
        @JSONField(name = "styleTitle")
        public String mStyleTitle;
        @JSONField(name = "title")
        public String mTabName;
        @JSONField(name = "urlLink")
        public String mTabUrl;
    }
}
