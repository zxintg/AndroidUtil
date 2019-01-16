package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class HomePageInfoResult {
    @JSONField(name = "bannerList")
    public List<HomeBannerItem> mBannerList;
    @JSONField(name = "categoryList")
    public List<HomeQuickEnterItem> mCategoryList;
    @JSONField(name = "homeAdList")
    public List<HomeAdItem> mHomeAdList;
    @JSONField(name = "topicList")
    public List<HomeTopicItem> mTopicList;

    public class HomeAdItem {
        @JSONField(name = "adHtmlContent")
        public String mAdHtmlContent;
        @JSONField(name = "adImg")
        public String mAdImg;
        @JSONField(name = "adLink")
        public String mAdLink;
        @JSONField(name = "adTitle")
        public String mAdTitle;
        @JSONField(name = "hour")
        public int mHour;
        @JSONField(name = "minute")
        public int mMinute;
        @JSONField(name = "second")
        public int mSecond;
        @JSONField(name = "text")
        public String mText;
        @JSONField(name = "type")
        public String mType;

        public HomeAdItem() {
        }
    }

    public class HomeBannerItem {
        @JSONField(name = "adHtmlContent")
        public String mAdHtmlContent;
        @JSONField(name = "adImg")
        public String mAdImg;
        @JSONField(name = "adLink")
        public String mAdLink;
        @JSONField(name = "adTitle")
        public String mAdTitle;

        public HomeBannerItem() {
        }
    }

    public class HomeQuickEnterItem {
        @JSONField(name = "adHtmlContent")
        public String mAdHtmlContent;
        @JSONField(name = "adImg")
        public String mAdImg;
        @JSONField(name = "adLink")
        public String mAdLink;
        @JSONField(name = "adTitle")
        public String mAdTitle;

        public HomeQuickEnterItem() {
        }
    }

    public class HomeTopicItem {
        @JSONField(name = "adHtmlContent")
        public String mAdHtmlContent;
        @JSONField(name = "adImg")
        public String mAdImg;
        @JSONField(name = "adLink")
        public String mAdLink;
        @JSONField(name = "adTitle")
        public String mAdTitle;

        public HomeTopicItem() {
        }
    }
}
