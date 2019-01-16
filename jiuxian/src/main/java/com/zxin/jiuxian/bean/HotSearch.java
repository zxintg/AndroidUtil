package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class HotSearch {
    @JSONField(name = "list")
    public List<HotSearchItem> mList;

    public static class HotSearchItem {
        @JSONField(name = "keyword")
        public String mKeyword;
        @JSONField(name = "searchType")
        public String mSearchType;
        @JSONField(name = "text")
        public String mText;
    }

    public static class SearchType {
        public static final String ACTIVITY_URL = "ACTIVITY_URL";
        public static final String KEYWORDS = "KEYWORDS";
    }
}
