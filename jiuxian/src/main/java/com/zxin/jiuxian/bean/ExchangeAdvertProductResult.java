package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class ExchangeAdvertProductResult {
    @JSONField(name = "productList")
    public List<Product> mExchangeProduct;
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "subTitle")
    public String mSubTitle;
    @JSONField(name = "topicName")
    public String mTopicName;

    public static class Product {
        @JSONField(name = "curPrice")
        public double mCurPrice;
        @JSONField(name = "imgPath")
        public String mImgPath;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
    }
}