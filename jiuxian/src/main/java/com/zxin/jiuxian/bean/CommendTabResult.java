package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class CommendTabResult {
    @JSONField(name = "commentList")
    public ArrayList<CommentItem> mCommentList;
    @JSONField(name = "labelUnifyStyle")
    public String mLabelUnifyStyle;
    @JSONField(name = "labelList")
    public ArrayList<CommentLabel> mLabeltList;
    @JSONField(name = "pager")
    public int mPager;
    @JSONField(name = "totalPager")
    public int mTotalPager;

    public static class CommentItem {
        @JSONField(name = "createTime")
        public long mCreateTime;
        @JSONField(name = "firstComment")
        public CommendTabResult.FirstComment mFirstComment;
        @JSONField(name = "isClubUser")
        public boolean mIsClubUser;
        @JSONField(name = "onceComment")
        public CommendTabResult.OnceComment mOnceComment;
        public CommendTabResult.ImgItem mSelectItem;
        @JSONField(name = "userImg")
        public String mUserImg;
        @JSONField(name = "userLevelImg")
        public String mUserLevelImg;
        @JSONField(name = "userName")
        public String mUserName;
    }

    public static class FirstComment {
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "comentId")
        public int mComentId;
        @JSONField(name = "comentScore")
        public int mComentScore;
        @JSONField(name = "imgList")
        public ArrayList<CommendTabResult.ImgItem> mImgList;
        @JSONField(name = "responseOfService")
        public String mResponseOfService;
    }

    public static class ImgItem {
        @JSONField(name = "imgId")
        public int mImgId;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
    }

    public static class LabeltItem {
        @JSONField(name = "color")
        public String mColor;
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "labelId")
        public int mLabelId;
        public boolean mSelected = false;
        @JSONField(name = "transparency")
        public String mTransparency;
    }

    public static class OnceComment {
        @JSONField(name = "afterDays")
        public int mAfterDays;
        @JSONField(name = "coment")
        public String mComent;
        @JSONField(name = "comentId")
        public String mComentId;
        @JSONField(name = "imgList")
        public ArrayList<CommendTabResult.ImgItem> mImgList;
        @JSONField(name = "responseOfService")
        public String mResponseOfService;
    }
}

