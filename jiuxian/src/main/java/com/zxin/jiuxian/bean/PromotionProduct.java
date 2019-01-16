package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class PromotionProduct {
    public static final String ALERTINFO_INSTOCK = "in_stock";
    private static final String ALERT_CODE_STOCK_OUT = "1";
    @JSONField(name = "addPrice")
    public double mAddPrice;
    @JSONField(name = "alertCode")
    public String mAlertCode;
    @JSONField(name = "alertInfo")
    public String mAlertInfo;
    public boolean mChecked;
    @JSONField(name = "clubPrice")
    public BigDecimal mClubPrice;
    @JSONField(name = "commentCount")
    public int mCommentCount;
    @JSONField(name = "condition")
    public String mCondition;
    @JSONField(name = "imgUrl")
    public String mImgUrl;
    @JSONField(name = "nicePercent")
    public String mNicePercent;
    public int mPCount = 1;
    @JSONField(name = "price")
    public double mPrice;
    @JSONField(name = "productId")
    public int mProductId;
    @JSONField(name = "productName")
    public String mProductName;
    @JSONField(name = "self")
    public boolean mSelf;

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof PromotionProduct)) {
            paramObject = (PromotionProduct) paramObject;
            return this.mProductId == ((PromotionProduct) paramObject).mProductId;
        }
        return super.equals(paramObject);
    }

    public int hashCode() {
        return this.mProductId;
    }

    public boolean isStockOut() {
        return "1".equals(this.mAlertCode);
    }
}

