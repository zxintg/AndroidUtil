package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class CommendDetailTabResult {
    @JSONField(name = "commentCount")
    public int mCommentCount;
    @JSONField(name = "commentList")
    public ArrayList<CommentList> mCommentList;
    @JSONField(name = "labelList")
    public ArrayList<CommentLabel> mLabeltList;
    @JSONField(name = "rate")
    public String mRate;

    public static class CommentList {
        @JSONField(name = "createTime")
        public String mCreateTime;
        @JSONField(name = "firstComment")
        public CommendDetailTabResult.FirstComment mFirstComment;
        @JSONField(name = "isClubUser")
        public boolean mIsClubUser;
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
        public ArrayList<CommendDetailTabResult.ImgItem> mImgList;
    }

    public static class ImgItem {
        @JSONField(name = "imgId")
        public int mImgId;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
    }
}