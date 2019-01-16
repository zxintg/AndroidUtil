package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MobileOnlyResult {
    @JSONField(name = "proList")
    public List<MobileOnlyWine> mProList;
    @JSONField(name = "switch")
    public String mSwitch;
    @JSONField(name = "text")
    public String mText;
    @JSONField(name = "wapUrl")
    public String mWapUrl;

    public static class MobileOnlyWine {
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "proId")
        public int mProId;
    }
}

