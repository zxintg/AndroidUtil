package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class CommendBigPicturesResult {
    public boolean mExpansion = false;
    @JSONField(name = "imgList")
    public ArrayList<ImgItem> mImgList;
    @JSONField(name = "pager")
    public int mPager;
    @JSONField(name = "totalPager")
    public int mTotalPager;

    public static class FirstComment {
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "commentScore")
        public int mCommentScore;
        @JSONField(name = "responseOfService")
        public String mResponseOfService;
    }

    public static class ImgItem {
        @JSONField(name = "buyTime")
        public long mBuyTime;
        @JSONField(name = "firstComment")
        public CommendBigPicturesResult.FirstComment mFirstComment;
        @JSONField(name = "imgId")
        public int mImgId;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "onceComment")
        public CommendBigPicturesResult.OnceComment mOnceComment;
        @JSONField(name = "pagerAlert")
        public String mPagerAlert;
        @JSONField(name = "userName")
        public String mUserName;
    }

    public static class OnceComment {
        @JSONField(name = "afterDays")
        public int mAfterDays;
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "responseOfService")
        public String mResponseOfService;
    }
}