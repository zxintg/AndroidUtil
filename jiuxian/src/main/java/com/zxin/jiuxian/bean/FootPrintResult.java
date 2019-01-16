package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class FootPrintResult {
    @JSONField(name = "totalPages")
    public int mPageCount;
    @JSONField(name = "list")
    public List<ProductData> mProductDataList;
    @JSONField(name = "totalRows")
    public int mTotalRows;

    public static class ProductData {
        @JSONField(name = "proImage")
        public String mImgaeUrl;
        public int mIsLess;
        public int mIsOnSale;
        @JSONField(name = "proName")
        public String mName;
        @JSONField(name = "proPrice")
        public double mPrice;
        @JSONField(name = "proId")
        public int mProductId;
    }
}
