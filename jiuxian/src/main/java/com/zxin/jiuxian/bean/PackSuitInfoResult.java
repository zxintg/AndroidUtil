package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class PackSuitInfoResult {
    @JSONField(name = "packageBuylist")
    public ArrayList<PackageBuyInfo> mPackageBuylist;
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "pageNum")
    public int mPageNum;
    @JSONField(name = "promotionId")
    public int mPromotionId;
    @JSONField(name = "promotionName")
    public String mPromotionName;
    @JSONField(name = "promotionType")
    public String promotionType;

    public static class PackageBuyInfo {
        public boolean mIsCheck = false;
        @JSONField(name = "packageBuyPrice")
        public double mPackageBuyPrice;
        @JSONField(name = "productList")
        public ArrayList<PackSuitInfoResult.ProductInfo> mProductList;
        @JSONField(name = "title")
        public String mTitle;
    }

    public static class ProductInfo {
        @JSONField(name = "alertCode")
        public String mAlertCode;
        @JSONField(name = "alertInfo")
        public String mAlertInfo;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productName")
        public String mProductName;
    }
}
