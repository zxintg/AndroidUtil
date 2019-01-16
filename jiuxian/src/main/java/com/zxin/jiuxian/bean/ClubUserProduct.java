package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ClubUserProduct {
    @JSONField(name = "clubUserProductList")
    public List<Product> mListData;

    public static class Product {
        @JSONField(name = "clubPrice")
        public double mClubPrice;
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
