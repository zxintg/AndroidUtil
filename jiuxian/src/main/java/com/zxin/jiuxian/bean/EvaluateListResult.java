package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class EvaluateListResult {
    @JSONField(name = "allCount")
    public int mAllCount;
    @JSONField(name = "evaList")
    public List<EvaList> mEvaList;
    @JSONField(name = "highCount")
    public int mHighCount;
    @JSONField(name = "imageCount")
    public int mImageCount;
    @JSONField(name = "lowCount")
    public int mLowCount;
    @JSONField(name = "midCount")
    public int mMidCount;
    @JSONField(name = "pageCount")
    public int mPageCount;

    public static class EvaList {
        @JSONField(name = "content")
        public String mContent;
        @JSONField(name = "createTime")
        public String mCreateTime;
        @JSONField(name = "imageList")
        public List<EvaluateListResult.ImageList> mImageList;
        @JSONField(name = "star")
        public int mStar;
        @JSONField(name = "userImage")
        public String mUserImage;
        @JSONField(name = "userLevel")
        public String mUserLevel;
        @JSONField(name = "userName")
        public String mUserName;
    }

    public static class ImageList {
        @JSONField(name = "bigImage")
        public String mBigImage;
        @JSONField(name = "smallImage")
        public String mSmallImage;
    }
}
