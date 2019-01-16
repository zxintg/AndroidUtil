package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityPromotionContentResult {
    public static final String PROMOTION_TYPE_AWARD = "AWARD";
    public static final String PROMOTION_TYPE_TRY_OUT = "TRY_OUT";
    @JSONField(name = "id")
    public String mActivityId;
    @JSONField(name = "awardList")
    public List<AwardResult> mAwardResultList;
    @JSONField(name = "bannerImage")
    public String mBannerImage;
    @JSONField(name = "hasAlreadyExpire")
    public Boolean mHasAlreadyExpire;
    @JSONField(name = "hasAlreadyOffline")
    public Boolean mHasAlreadyOffline;
    @JSONField(name = "content")
    public String mPromotionContent;
    @JSONField(name = "new")
    public boolean mPromotionNew;
    @JSONField(name = "popularity")
    public int mPromotionPopular;
    @JSONField(name = "title")
    public String mPromotionTitle;
    @JSONField(name = "activityType")
    public String mPromotionType;
    @JSONField(name = "defaultShareLinkImg")
    public String mShareImage;
    @JSONField(name = "shareLink")
    public String mShareLink;

    public static class AwardResult {
        @JSONField(name = "level")
        public String mLevel;
        @JSONField(name = "levelText")
        public String mLevelText;
        @JSONField(name = "listImagePath")
        public String mListImagePath;
        @JSONField(name = "number")
        public String mNumber;
        @JSONField(name = "price")
        public String mPrice;
        @JSONField(name = "id")
        public int mProductId;
        @JSONField(name = "name")
        public String mProductName;
    }
}