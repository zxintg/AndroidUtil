package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class CommunityTopicDetailResult {
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
    public List<Image> mImages;
    @JSONField(name = "isBlacklist")
    public boolean mIsBlacklist;
    @JSONField(name = "isMixed")
    public boolean mIsMixed;
    @JSONField(name = "memberBo")
    public CommunityUserInfoResult mMemberBo;
    @JSONField(name = "message")
    public String mMessage;
    @JSONField(name = "mixed")
    public List<MixDataItem> mMixedDataList;
    @JSONField(name = "praise")
    public int mPraise;
    @JSONField(name = "products")
    public List<CommunityProductInfoResult> mProInfo;
    @JSONField(name = "replies")
    public int mReplies;
    @JSONField(name = "defaultShareLinkImg")
    public String mShareImage;
    @JSONField(name = "shareLink")
    public String mShareLink;
    @JSONField(name = "shareText")
    public String mShareText;
    @JSONField(name = "showTasteText")
    public String mShowTasteText;
    @JSONField(name = "subject")
    public String mSubject;
    @JSONField(name = "topicType")
    public String mTopicType;
    @JSONField(name = "views")
    public int mViewNum;

    public static class Image {
        @JSONField(name = "bigImageUrl")
        public String mBigImageUrl;
        @JSONField(name = "smallImageUrl")
        public String mSmallImageUrl;
    }

    public static class MixDataItem implements Serializable {
        @JSONField(name = "bigImageUrl")
        public String mBigImageUrl;
        @JSONField(name = "data")
        public String mContent;
        @JSONField(name = "mixedType")
        public String mMixedType;
        @JSONField(name = "id")
        public int mPid;
        @JSONField(name = "listImagePath")
        public String mProImgUrl;
        @JSONField(name = "name")
        public String mProName;
        @JSONField(name = "price")
        public String mProPrice;
        @JSONField(name = "smallImageUrl")
        public String mSmallImageUrl;
    }
}

