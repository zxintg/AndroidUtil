package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ProductCouponResult {
    @JSONField(name = "couponList")
    public List<ProductCouponItem> mCouponList;
    @JSONField(name = "pageCount")
    public int mPageCount;

    public static class ProductCouponItem {
        @JSONField(name = "activiteId")
        public String mActivityId;
        @JSONField(name = "condition")
        public String mCondition;
        @JSONField(name = "couponId")
        public String mCouponId;
        @JSONField(name = "couponName")
        public String mCouponName;
        @JSONField(name = "couponPrice")
        public String mCouponPrice;
        @JSONField(name = "couponType")
        public int mCouponType;
        @JSONField(name = "timeTip")
        public String mTimeTip;
    }
}
