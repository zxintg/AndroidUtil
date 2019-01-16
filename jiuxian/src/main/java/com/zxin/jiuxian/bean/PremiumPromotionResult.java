package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PremiumPromotionResult {
    @JSONField(name = "chooseNum")
    public int mChooseNum;
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "pageNum")
    public int mPageNum;
    @JSONField(name = "productList")
    public List<PromotionProduct> mProductList;
    @JSONField(name = "promotionId")
    public int mPromotionId;
    @JSONField(name = "promotionName")
    public String mPromotionName;
    @JSONField(name = "promotionType")
    public String mPromotionType;
    @JSONField(name = "title")
    public String mTitle;
}
