package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class UserCouponResult {
    @JSONField(name = "couponInfo")
    public UserCoupon mCouponInfo;

    public static class UserCoupon {
        @JSONField(name = "pageCount")
        public int mPageCount;
        @JSONField(name = "couponList")
        public List<UserCouponResult.UserCouponItem> mUserCouponList;
    }

    public static class UserCouponItem implements Serializable {
        private static final long serialVersionUID = 2616367468701773555L;
        @JSONField(name = "account")
        public String mAccount;
        @JSONField(name = "consumLowerPrice")
        public String mConsumLowerPrice;
        @JSONField(name = "couponId")
        public int mCouponId;
        @JSONField(name = "couponName")
        public String mCouponName;
        @JSONField(name = "couponPrice")
        public String mCouponPrice;
        @JSONField(name = "couponType")
        public int mCouponType;
        @JSONField(name = "csort")
        public int mCsort;
        @JSONField(name = "endTime")
        public long mEndTime;
        @JSONField(name = "scope")
        public int mScope;
        @JSONField(name = "shopUrl")
        public String mShopuRL;
        @JSONField(name = "startTime")
        public long mStartTime;
        @JSONField(name = "timeTip")
        public String mTimeTip;
        @JSONField(name = "useCondition")
        public String mUseCondition;
    }
}
