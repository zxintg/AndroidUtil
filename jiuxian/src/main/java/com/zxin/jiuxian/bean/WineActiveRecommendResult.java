package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class WineActiveRecommendResult {
    @JSONField(name = "lableList")
    public List<LableInfo> mLableInfoList;
    public LableInfo mSelected;
    public LableInfoDetail mSelectedDetail;

    public static class AttrInfo {
        @JSONField(name = "attrsId")
        public String mAttrsId;
        @JSONField(name = "categoryId")
        public int mCategoryId;
        @JSONField(name = "endPrice")
        public double mEndPrice;
        @JSONField(name = "isTopTopic")
        public boolean mIsTopTopic;
        @JSONField(name = "keyword")
        public String mKeyword;
        @JSONField(name = "orderBy")
        public String mOrderBy;
        @JSONField(name = "pageIndex")
        public int mPageIndex;
        @JSONField(name = "pageSize")
        public int mPageSize;
        @JSONField(name = "startPrice")
        public double mStartPrice;
    }

    public static class LableInfo {
        @JSONField(name = "value")
        public WineActiveRecommendResult.AttrInfo mAttrInfo;
        @JSONField(name = "proSourceId")
        public int mJzProductSourceId;
        @JSONField(name = "tagSourceId")
        public int mJzSourceId;
        @JSONField(name = "lableList")
        public List<WineActiveRecommendResult.LableInfoDetail> mLableInfoList;
        @JSONField(name = "name")
        public String mName;
        public boolean mNeedAutoStatistic;
        @JSONField(name = "nineClickName")
        public String mNineClickName;
    }

    public static class LableInfoDetail {
        @JSONField(name = "value")
        public WineActiveRecommendResult.AttrInfo mAttrInfo;
        @JSONField(name = "proSourceId")
        public int mJzProductSourceId;
        @JSONField(name = "tagSourceId")
        public int mJzSourceId;
        @JSONField(name = "name")
        public String mName;
        public boolean mNeedAutoStatistic;
        @JSONField(name = "nineClickName")
        public String mNineClickName;
    }
}
