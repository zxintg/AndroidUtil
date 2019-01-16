package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class SearchReceiveConpon {
    @JSONField(name = "couponActId")
    public int mCouponActId;
    @JSONField(name = "couponInfos")
    public List<CouponInfos> mCouponInfos;
    @JSONField(name = "keyword")
    public String mKeyword;
    @JSONField(name = "relationId")
    public int mRelationId;
    @JSONField(name = "show")
    public boolean mShow;

    public static class CouponInfos {
        @JSONField(name = "couponId")
        public int mCouponId;
        @JSONField(name = "couponPriceString")
        public String mCouponPriceString;
        @JSONField(name = "couponTypeString")
        public String mCouponTypeString;
        @JSONField(name = "qualificationString")
        public String mQualificationString;
        @JSONField(name = "validDateString")
        public String mValidDateString;
    }
}
