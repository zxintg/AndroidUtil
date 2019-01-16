package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OrderCouponInfo {
    @JSONField(name = "availableList")
    public List<CouponItem> mAvailableList;
    @JSONField(name = "disAvailableList")
    public List<CouponItem> mDisAvailableList;
    @JSONField(name = "useCouponIds")
    public String mId;

    public static class CouponItem {
        @JSONField(name = "effectTime")
        public String mBeginTime;
        @JSONField(name = "bonusId")
        public int mBonusId;
        @JSONField(name = "bonusName")
        public String mBonusName;
        @JSONField(name = "couponType")
        public int mCouponType;
        @JSONField(name = "details")
        public String mDetails;
        @JSONField(name = "outTime")
        public String mEndTime;
        @JSONField(name = "headName")
        public String mHeadName;
        @JSONField(name = "isCheck")
        public int mIsCheck;
        @JSONField(name = "isSelect")
        public int mIsSelect;
        @JSONField(name = "money")
        public String mMoney;
        @JSONField(name = "time")
        public String mTime;
        @JSONField(name = "title")
        public String mTitle;
    }
}