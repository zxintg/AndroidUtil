package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */

public class AutoWordResult {
    @JSONField(name = "result")
    public Result mResult;

    public static class AutoComWord {
        @JSONField(name = "count")
        public String mCount;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "searchKeySourceType")
        public String mSearchKeySourceType;
        @JSONField(name = "url")
        public String mUrl;
    }

    public class KeySourceType {
        public static final String HISTORY = "HISTORY";
        public static final String LEXICON = "SearchKey";

        public KeySourceType() {
        }
    }

    public static class Result {
        @JSONField(name = "assKey")
        public String mAssKey;
        @JSONField(name = "assHotPojos")
        public List<AutoComWord> mList;
    }
}

