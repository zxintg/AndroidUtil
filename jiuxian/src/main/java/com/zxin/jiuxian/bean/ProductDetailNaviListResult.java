package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class ProductDetailNaviListResult {
    @JSONField(name = "navigationList")
    public ArrayList<ProductDetailNaviItemResult> mProductDetailNaviList;

    public static class ProductDetailNaviItemResult {
        @JSONField(name = "itemEventId")
        public String mItemEventId;
        @JSONField(name = "itemImg")
        public String mItemImg;
        @JSONField(name = "itemName")
        public String mItemName;
        @JSONField(name = "itemUrl")
        public String mItemUrl;
    }
}
