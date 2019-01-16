package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class WineAdvertResult {
    @JSONField(name = "navList")
    public List<ExchangeAdvertResult.ExchangeImgUrlInfo> mNavLists;

    public static class ExchangeImgUrlInfo {
        @JSONField(name = "adImg")
        public String mAdImg;
        @JSONField(name = "adLink")
        public String mAdLink;
        @JSONField(name = "adTitle")
        public String mAdTitle;
        @JSONField(name = "advertisingId")
        public int mAdvertisingId;
        @JSONField(name = "advertisingName")
        public String mAdvertisingName;
    }
}
