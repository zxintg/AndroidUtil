package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OrderCommentInfoResult {
    @JSONField(name = "recordList")
    public List<OrderCommentItem> mCommentItems;
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "totalCount")
    public int mTotalCount;

    public static class OrderCommentItem {
        @JSONField(name = "alreadyEvaluation")
        public boolean mAlreadyEvaluation;
        @JSONField(name = "buyNum")
        public int mBuyNum;
        @JSONField(name = "buyPrice")
        public double mBuyPrice;
        @JSONField(name = "imgs")
        public List<Image> mImages;
        @JSONField(name = "isOnSale")
        public int mIsOnSale;
        @JSONField(name = "orderId")
        public int mOrderId;
        @JSONField(name = "orderSN")
        public String mOrderSN;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "whetherEvaluate")
        public boolean mWhetherEvaluate;

        public static class Image {
            @JSONField(name = "bigImage")
            public String mBigImage;
            @JSONField(name = "smallImage")
            public String mSmallImage;
        }
    }
}