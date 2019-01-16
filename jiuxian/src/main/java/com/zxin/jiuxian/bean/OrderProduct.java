package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OrderProduct {
    @JSONField(name = "buyNum")
    public int mBuyNum;
    @JSONField(name = "buyPrice")
    public double mBuyPrice;
    @JSONField(name = "imgs")
    public List<Image> mImages;
    @JSONField(name = "isOnSale")
    public int mIsOnSale;
    public int mOrderId;
    public String mOrderSN;
    @JSONField(name = "productId")
    public int mProductId;
    @JSONField(name = "productName")
    public String mProductName;
    @JSONField(name = "productSN")
    public String mProductSN;
    @JSONField(name = "whetherEvaluate")
    public boolean mWhetherEvaluate;

    public static class Image {
        @JSONField(name = "bigImage")
        public String mBigImage;
        @JSONField(name = "smallImage")
        public String mSmallImage;
    }
}
