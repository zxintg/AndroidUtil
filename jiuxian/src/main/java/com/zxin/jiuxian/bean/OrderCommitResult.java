package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class OrderCommitResult {
    @JSONField(name = "addTime")
    public long mAddTime;
    @JSONField(name = "extraInfo")
    public String mFailExtraInfo;
    @JSONField(name = "orderId")
    public int mOrderId;
    @JSONField(name = "orderPrice")
    public double mOrderPrice;
    @JSONField(name = "orderSn")
    public String mOrderSN;
    @JSONField(name = "payName")
    public String mPayName;
    @JSONField(name = "payPasswdError")
    public PayPasswdErrer mPayPasswdErrer;
    @JSONField(name = "payPrice")
    public double mPayPrice;
    @JSONField(name = "payType")
    public int mPayType;
    @JSONField(name = "backInfor")
    public String mStatusInfo;
    @JSONField(name = "locationAddressInfor")
    public UserAddressInfo mUserAddressInfo;

    public static class PayPasswdErrer {
        @JSONField(name = "errkey")
        public int mErrkey;
        @JSONField(name = "errmesg")
        public String mErrmesg;
    }

    public static class UserAddressInfo {
        @JSONField(name = "city")
        public String mCity;
        @JSONField(name = "cityId")
        public int mCityId;
        @JSONField(name = "district")
        public String mDistrict;
        @JSONField(name = "districtId")
        public int mDistrictId;
        @JSONField(name = "province")
        public String mProvince;
        @JSONField(name = "provinceId")
        public int mProvinceId;
    }
}