package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class ProductActivityPriceListResult {
    @JSONField(name = "activityPriceList")
    public List<Product> mProductList;

    public static class Product implements Serializable {
        @JSONField(name = "activityList")
        public List<ProductListInfoResult.ActList> mActivityList;
        @JSONField(name = "clubPrice")
        public double mClubPrice;
        @JSONField(name = "nowPrice")
        public double mNowPrice;
        @JSONField(name = "proId")
        public int mProId;
    }
}