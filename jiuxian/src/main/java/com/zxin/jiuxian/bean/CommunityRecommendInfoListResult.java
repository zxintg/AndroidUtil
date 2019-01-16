package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityRecommendInfoListResult {
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "dataList")
    public List<RecommendInfo> mRecommendResultList;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class RecommendInfo {
        @JSONField(name = "alreadyPraise")
        public boolean mAlreadyPraise;
        @JSONField(name = "alreadyView")
        public boolean mAlreadyView;
        @JSONField(name = "canDel")
        public boolean mCanDel;
        @JSONField(name = "forbiddenPublishComment")
        public boolean mForbiddenPublishComment;
        @JSONField(name = "isBlacklist")
        public boolean mIsBlacklist;
        @JSONField(name = "tid")
        public int mTid;
    }
}
