package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class CommendBigPic {
    @JSONField(name = "commentCount")
    public int mCommentCount;
    @JSONField(name = "commentList")
    public ArrayList<CommentItem> mCommentList;
    @JSONField(name = "labeltList")
    public ArrayList<LabeltItem> mLabeltList;
    @JSONField(name = "pager")
    public int mPager;
    @JSONField(name = "rate")
    public String mRate;
    @JSONField(name = "totalPager")
    public int mTotalPager;

    public static class CommentItem {
        @JSONField(name = "createTime")
        public String mCreateTime;
        @JSONField(name = "firstComment")
        public CommendBigPic.FirstComment mFirstComment;
        @JSONField(name = "onceComment")
        public CommendBigPic.OnceComment mOnceComment;
        @JSONField(name = "responseOfService")
        public String mResponseOfService;
        @JSONField(name = "userImg")
        public String mUserImg;
        @JSONField(name = "userLevelImg")
        public String mUserLevelImg;
        @JSONField(name = "userName")
        public String mUserName;
    }

    public static class FirstComment {
        @JSONField(name = "imgList")
        public ArrayList<String> imgList;
        @JSONField(name = "coment")
        public String mComent;
    }

    public static class LabeltItem {
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "labelId")
        public int mLabelId;
    }

    public static class OnceComment {
        @JSONField(name = "afterDays")
        public String mAfterDays;
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "imgList")
        public ArrayList<String> mImgList;
    }
}
