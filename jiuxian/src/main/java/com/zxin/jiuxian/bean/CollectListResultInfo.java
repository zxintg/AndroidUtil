package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CollectListResultInfo {
    @JSONField(name = "collList")
    public List<CollectListItem> mItems;
    @JSONField(name = "pageCount")
    public int mPageCount;

    public static class CollectListItem {
        @JSONField(name = "clubPrice")
        public double mClubPrice;
        @JSONField(name = "collId")
        public int mCollId;
        @JSONField(name = "createTime")
        public long mCreateTime;
        public boolean mIsCheck = false;
        @JSONField(name = "isLess")
        public String mIsLess;
        @JSONField(name = "isOnSale")
        public String mIsOnSale;
        @JSONField(name = "pageCount")
        public int mPageCount;
        public int mPosition;
        @JSONField(name = "proId")
        public int mProId;
        @JSONField(name = "proName")
        public String mProName;
        @JSONField(name = "proPrice")
        public double mProPrice;
        @JSONField(name = "proSmallImg")
        public String mProSmallImg;
    }
}