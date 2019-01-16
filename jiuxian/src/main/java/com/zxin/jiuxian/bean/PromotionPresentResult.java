package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

public class PromotionPresentResult {
    @JSONField(name = "checkNum")
    public int mCheckNum;
    @JSONField(name = "maxNum")
    public int mMaxNum;
    @JSONField(name = "data")
    public List<ProductBean> mProductList;
    @JSONField(name = "title")
    public String mTitle;
    @JSONField(name = "totalPager")
    public int mTotalPager;

    public static class AlertBean {
        @JSONField(name = "alertCode")
        public String mAlertCode;
        @JSONField(name = "alertInfo")
        public String mAlertInfo;
    }

    public static class ProductBean {
        @JSONField(name = "alert")
        public PromotionPresentResult.AlertBean mAlert;
        @JSONField(name = "check")
        public boolean mCheck;
        @JSONField(name = "clubPrice")
        public BigDecimal mClubPrice;
        @JSONField(name = "commentTotal")
        public String mCommentTotal;
        @JSONField(name = "jiuxianSelf")
        public boolean mJiuxianSelf;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productImgUrl")
        public String mProductImgUrl;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "productPrice")
        public double mProductPrice;
        @JSONField(name = "productTitle")
        public String mProductTitle;
        @JSONField(name = "rate")
        public String mRate;
        @JSONField(name = "step")
        public int mStep;

        public boolean isAlertEmpty() {
            return this.mAlert == null;
        }
    }
}
