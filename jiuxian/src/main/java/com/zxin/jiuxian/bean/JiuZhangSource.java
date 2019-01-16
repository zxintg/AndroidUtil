package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

public class JiuZhangSource implements Serializable {
    public String mAdvId;
    public String mBrand;
    public String mCat;
    public String mCategory;
    public String mItemId;
    public String mName;
    public String mOrderId;
    public String mPrice;
    public String mProId;
    public String mQResult;
    public String mQuantity;
    public String mQuery;
    public String mSearchKey;
    public String mSo;
    public String mUrl;

    public class SoType {
        public static final String ACTIVITY_PAGE = "3";
        public static final String LIST_PAGE = "2";
        public static final String SEARCH_PAGE = "1";
    }
}

