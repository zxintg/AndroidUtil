package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class LaunchPageInfoResult {
    public String mLinkurl;
    public LaunchPageInfo imageMap;

    public static class LaunchPageInfo {
        public String gotoUrl;
        public int id;
        public String state;
        public String url;
    }
}