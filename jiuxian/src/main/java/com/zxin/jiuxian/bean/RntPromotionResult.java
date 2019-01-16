package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class RntPromotionResult {
    @JSONField(name = "chooseNum")
    public Integer[] mChooseNum;
    @JSONField(name = "objectTypes")
    public int mObjectTypes;
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "pageNum")
    public int mPageNum;
    @JSONField(name = "productList")
    public ArrayList<PromotionProduct> mProductList;
    @JSONField(name = "promotionId")
    public int mPromotionId;
    @JSONField(name = "promotionName")
    public String mPromotionName;
    @JSONField(name = "promotionType")
    public String mPromotionType;
    @JSONField(name = "title")
    public String mTitle;
}