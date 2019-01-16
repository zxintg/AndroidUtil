package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class OrderProductsResult implements Serializable {
    @JSONField(name = "list")
    public List<OrderProduct> mProductList;

    public class OrderProduct {
        @JSONField(name = "buyNum")
        public int mBuyNum;
        @JSONField(name = "buyPrice")
        public double mBuyPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productSN")
        public String mProductSN;
        @JSONField(name = "totalPrice")
        public double mTotalPrice;

        public OrderProduct() {
        }
    }
}
