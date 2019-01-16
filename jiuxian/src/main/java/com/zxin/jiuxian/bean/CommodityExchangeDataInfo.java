package com.zxin.jiuxian.bean;


public class CommodityExchangeDataInfo {
    public static final int TYPE_DELETE = 0;
    public static final int TYPE_EMPTY = 1;
    public static final int TYPE_GRID = 2;
    public static final int TYPE_LIST = 3;
    public static final int TYPE_PACKAGE = 4;
    public static final int TYPE_SUB_PACKAGE = 5;
    public Object mData;
    public int mType;

    public CommodityExchangeDataInfo(int paramInt, Object paramObject) {
        this.mType = paramInt;
        this.mData = paramObject;
    }
}