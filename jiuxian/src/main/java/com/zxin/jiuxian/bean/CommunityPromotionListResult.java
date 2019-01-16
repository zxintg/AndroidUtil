package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityPromotionListResult {
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "dataList")
    public List<PromotionResult> mPromotionResultList;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class PromotionResult {
        @JSONField(name = "bannerImage")
        public String mBannerImage;
        @JSONField(name = "hasAlreadyExpire")
        public boolean mHasAlreadyExpire;
        @JSONField(name = "hasAlreadyOffline")
        public Boolean mHasAlreadyOffline;
        @JSONField(name = "id")
        public int mPromotionId;
        @JSONField(name = "new")
        public boolean mPromotionNew;
        @JSONField(name = "popularity")
        public int mPromotionPopular;
        @JSONField(name = "title")
        public String mPromotionTitle;
    }
}

