package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class XinkeInfoResult {
    @JSONField(name = "adPositionInfo")
    public AdPositionInfo mAdPositionInfo;
    @JSONField(name = "switches")
    public int mSwitches;

    public static class AdPositionInfo {
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
