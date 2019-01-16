package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CartLetYouSelectResult {
    @JSONField(name = "checkNum")
    public int mCheckNum;
    @JSONField(name = "maxNums")
    public int[] mMaxNums;
    @JSONField(name = "data")
    public List<ProductBean> mProductList;
    @JSONField(name = "title")
    public String[] mTitle;
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
        public CartLetYouSelectResult.AlertBean mAlert;
        @JSONField(name = "check")
        public boolean mCheck;
        @JSONField(name = "commentTotal")
        public String mCommentTotal;
        @JSONField(name = "jiuxianSelf")
        public boolean mJiuxianSelf;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productImgUrl")
        public String mProductImgUrl;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "productNum")
        public int mProductNum;
        @JSONField(name = "productPrice")
        public double mProductPrice;
        @JSONField(name = "rate")
        public String mRate;

        public boolean isAlertEmpty() {
            return this.mAlert == null;
        }
    }
}
