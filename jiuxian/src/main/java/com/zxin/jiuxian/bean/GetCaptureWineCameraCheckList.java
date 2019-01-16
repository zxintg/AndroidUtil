package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class GetCaptureWineCameraCheckList {
    @JSONField(name = "scanList")
    public ArrayList<ScanList> mScanList;
    @JSONField(name = "securityRaidersUrl")
    public String mSecurityRaidersUrl;

    public static class ScanList {
        @JSONField(name = "describe")
        public String mDescribe;
        @JSONField(name = "img")
        public String mImg;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "scanId")
        public int mScanId;
        @JSONField(name = "validType")
        public int mValidType;
    }
}