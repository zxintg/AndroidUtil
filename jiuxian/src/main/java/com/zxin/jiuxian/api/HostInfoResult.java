package com.zxin.jiuxian.api;

import com.alibaba.fastjson.annotation.JSONField;

public class HostInfoResult {
    @JSONField(name = "homeDomainIp")
    public HostInfo mHomeHostInfo;
    @JSONField(name = "omsDomainIp")
    public HostInfo mOmsHostInfo;
    @JSONField(name = "productDomainIp")
    public HostInfo mProductHostInfo;
    @JSONField(name = "promDomainIp")
    public HostInfo mPromotionHostInfo;
    @JSONField(name = "userDomainIp")
    public HostInfo mUserHostInfo;

    public static class HostInfo {
        public static final String PRIORITY_DOMAIN = "0";
        public static final String PRIORITY_IP = "1";
        @JSONField(name = "serDomain")
        public String mDomain;
        @JSONField(name = "serIp")
        public String mIp;
        @JSONField(name = "priority")
        public String mPriority;
    }
}