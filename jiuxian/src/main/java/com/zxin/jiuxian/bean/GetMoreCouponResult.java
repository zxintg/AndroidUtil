package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class GetMoreCouponResult {
    @JSONField(name = "couponInfo")
    public CouponInfo mCouponInfo;

    public class CouponInfo {
        @JSONField(name = "couponList")
        public List<GetMoreCouponResult.CouponListItem> mCouponList;
        @JSONField(name = "pageCount")
        public int mPageCount;
        @JSONField(name = "tabList")
        public List<GetMoreCouponResult.CouponTabItem> mTabList;

        public CouponInfo() {
        }
    }

    public static class CouponListItem {
        @JSONField(name = "activityId")
        public String mActId;
        @JSONField(name = "couponId")
        public String mCouponId;
        @JSONField(name = "couponName")
        public String mCouponName;
        @JSONField(name = "couponPrice")
        public String mCouponPrice;
        @JSONField(name = "couponType")
        public int mCouponType;
        @JSONField(name = "endTime")
        public long mEndTime;
        @JSONField(name = "scope")
        public int mScope;
        @JSONField(name = "startTime")
        public long mStartTime;
        @JSONField(name = "timeTip")
        public String mTimeTip;
        @JSONField(name = "useCondition")
        public String mUseCondition;
    }

    public static class CouponTabItem {
        @JSONField(name = "tabName")
        public String mTabName;
        @JSONField(name = "tabType")
        public int mTabType;
    }
}