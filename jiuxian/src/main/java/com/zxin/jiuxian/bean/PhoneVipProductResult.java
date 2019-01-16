package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

public class PhoneVipProductResult {
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "typeProList")
    public List<PhoneVipProduct> mProductList;
    @JSONField(name = "totalCount")
    public int mTotalCount;

    public static class PhoneVipProduct {
        @JSONField(name = "clubPrice")
        public BigDecimal mClubPrice;
        @JSONField(name = "slogan")
        public String mDescription;
        @JSONField(name = "lowPrice")
        public double mDiscount;
        @JSONField(name = "proImg")
        public String mImageUrl;
        @JSONField(name = "isSelection")
        public Boolean mIsSelection;
        public boolean mIsTab;
        @JSONField(name = "label")
        public String mLable;
        @JSONField(name = "proName")
        public String mName;
        public int mPosition;
        @JSONField(name = "proPrice")
        public double mPrice;
        @JSONField(name = "proId")
        public int mProductId;
        @JSONField(name = "showVideoIcon")
        public boolean mShowVideoIcon;
    }
}

