package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class PackSuitResult {
    @JSONField(name = "promoProduct")
    public ArrayList<PromoProInfo> mPromoProduct;

    public static class ProInfo {
        @JSONField(name = "alertCode")
        public String mAlertCode;
        @JSONField(name = "alertInfo")
        public String mAlertInfo;
        @JSONField(name = "commentCount")
        public int mCommentCount;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        public boolean mIsCheck;
        @JSONField(name = "nicePercent")
        public String mNicePercent;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "self")
        public boolean mSelf;
    }

    public static class PromoProInfo {
        @JSONField(name = "canAddShopingCart")
        public boolean mCanAddShopingCart;
        @JSONField(name = "groupPrice")
        public double mGroupPrice;
        public boolean mIsCheck = false;
        @JSONField(name = "productList")
        public ArrayList<PackSuitResult.ProInfo> mProductList;
        @JSONField(name = "groupTitle")
        public String mProupTitle;
    }
}