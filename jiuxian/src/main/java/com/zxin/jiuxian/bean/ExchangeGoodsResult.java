package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class ExchangeGoodsResult {
    @JSONField(name = "promoProduct")
    public ArrayList<PromotionProduct> mProductList;
    @JSONField(name = "title")
    public String mTitle;
}
