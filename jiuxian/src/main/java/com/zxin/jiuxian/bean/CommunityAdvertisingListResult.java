package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityAdvertisingListResult {
    @JSONField(name = "dataList")
    public List<AdvertisingItem> mCommentList;

    public static class AdvertisingItem {
        @JSONField(name = "id")
        public int mAdvertisingId;
        @JSONField(name = "name")
        public String mAdvertisingName;
        @JSONField(name = "fullImagePath")
        public String mBannerFullImgPath;
        @JSONField(name = "bannerImagePath")
        public String mBannerImgPath;
        @JSONField(name = "beginTime")
        public long mBeginTime;
        @JSONField(name = "endTime")
        public long mEndTime;
        @JSONField(name = "type")
        public String mRedirectType;
        @JSONField(name = "typeAppertain")
        public String mRedirectTypeAppertain;
        @JSONField(name = "sort")
        public int mSort;
        @JSONField(name = "state")
        public String mState;
    }
}
