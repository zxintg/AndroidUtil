package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CommunityProductInfoResult implements Serializable {
    private static final long serialVersionUID = -9022325760313743959L;
    @JSONField(name = "alreadyEvaluate")
    public boolean mAlreadyEvaluate;
    @JSONField(name = "brandId")
    public int mBrandId;
    @JSONField(name = "brandImage")
    public String mBrandImage;
    @JSONField(name = "brandName")
    public String mBrandName;
    @JSONField(name = "checkedState")
    public Boolean mCheckedState;
    @JSONField(name = "images")
    public String mImages;
    @JSONField(name = "listImagePath")
    public String mListImagePath;
    @JSONField(name = "name")
    public String mName;
    @JSONField(name = "orderId")
    public int mOrderId;
    @JSONField(name = "id")
    public int mPid;
    @JSONField(name = "price")
    public String mPrice;
    @JSONField(name = "productState")
    public String mProductState;
    @JSONField(name = "showTasteText")
    public String mShowTasteText;
}
