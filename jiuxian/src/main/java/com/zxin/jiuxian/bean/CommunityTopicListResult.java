package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityTopicListResult {
    @JSONField(name = "dataList")
    public List<TopicResult> mArticleResultList;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class Image {
        @JSONField(name = "bigImageUrl")
        public String mBigImageUrl;
        @JSONField(name = "smallImageUrl")
        public String mSmallImageUrl;
    }

    public static class TopicResult {
        @JSONField(name = "isActivityTop")
        public boolean isActivityTop;
        @JSONField(name = "isCircleTop")
        public boolean isCircleTop;
        @JSONField(name = "isHomePageTop")
        public boolean isHomePageTop;
        @JSONField(name = "alreadyPraise")
        public boolean mAlreadyPraise;
        @JSONField(name = "alreadyView")
        public boolean mAlreadyView;
        @JSONField(name = "canDel")
        public boolean mCanDel;
        @JSONField(name = "circleBo")
        public CommunityCircleInfoResult mCircleInfo;
        @JSONField(name = "dateline")
        public long mDateLine;
        @JSONField(name = "datelineText")
        public String mDatelineText;
        @JSONField(name = "forbiddenPublishComment")
        public boolean mForbiddenPublishComment;
        @JSONField(name = "images")
        public List<CommunityTopicListResult.Image> mImages;
        @JSONField(name = "isBlacklist")
        public boolean mIsBlacklist;
        @JSONField(name = "memberBo")
        public CommunityUserInfoResult mMemberBo;
        @JSONField(name = "message")
        public String mMessage;
        @JSONField(name = "praise")
        public int mPraise;
        @JSONField(name = "products")
        public List<CommunityProductInfoResult> mProInfo;
        @JSONField(name = "replies")
        public int mReplies;
        public boolean mShowChatTop;
        @JSONField(name = "showTasteText")
        public String mShowTasteText;
        @JSONField(name = "subject")
        public String mSubject;
        @JSONField(name = "tid")
        public int mTid;
        @JSONField(name = "topicType")
        public String mTopicType;
        @JSONField(name = "views")
        public int mViewNum;
        @JSONField(name = "viewsText")
        public String mViewsTextNum;
    }
}

