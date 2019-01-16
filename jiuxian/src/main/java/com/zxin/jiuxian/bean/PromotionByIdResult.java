package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class PromotionByIdResult {
    @JSONField(name = "limitNum")
    public int mLimitNum;
    @JSONField(name = "pageNum")
    public int mPageNum;
    @JSONField(name = "productList")
    public ArrayList<ProductListInfo> mProductList;
    @JSONField(name = "promotionName")
    public String mPromotionName;
    @JSONField(name = "totalPage")
    public int mTotalPage;

    public static class ProductListInfo {
        @JSONField(name = "evaluateGoodNum")
        public int mEvaluateGoodNum;
        @JSONField(name = "evaluateNum")
        public int mEvaluateNum;
        @JSONField(name = "evaluateRatio")
        public int mEvaluateRatio;
        public boolean mIsCheck = false;
        @JSONField(name = "isHave")
        public int mIsHave;
        @JSONField(name = "isPromotion")
        public int mIsPromotion;
        @JSONField(name = "productId")
        public String mProductId;
        @JSONField(name = "productImage")
        public String mProductImage;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "promotionList")
        public ArrayList<PromotionByIdResult.PromotionInfo> mPromotionList;
        @JSONField(name = "promotionPrice")
        public double mPromotionPrice;
    }

    public static class PromotionInfo {
        @JSONField(name = "promotionId")
        public String mPromotionId;
        @JSONField(name = "promotionName")
        public String mPromotionName;
    }
}