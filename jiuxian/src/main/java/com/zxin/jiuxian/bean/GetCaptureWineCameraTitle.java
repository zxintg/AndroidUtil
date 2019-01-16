package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class GetCaptureWineCameraTitle {
    @JSONField(name = "scanTabList")
    public ArrayList<ScanTabList> mScanTabList;

    public static class ScanTabList {
        @JSONField(name = "scanName")
        public String mScanName;
        @JSONField(name = "scanType")
        public Integer mScanType;
    }
}
