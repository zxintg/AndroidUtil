package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommentCenterHeaderResult {
    @JSONField(name = "alertInfo")
    public String mAlertInfo;
    @JSONField(name = "bannerList")
    public List<CommentCenterBannerList> mCommentCenterBannerList;
    @JSONField(name = "tabList")
    public List<CommentCenterTabList> mCommentCenterTabList;
    @JSONField(name = "goldNum")
    public int mGoldNum;
    @JSONField(name = "ruleLink")
    public String mRuleLink;
    @JSONField(name = "userImg")
    public String mUserImg;
    @JSONField(name = "userName")
    public String mUserName;

    public static class CommentCenterBannerList {
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "linkUrl")
        public String mLinkUrl;
    }

    public static class CommentCenterTabList {
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "productNum")
        public int mProductNum;
        @JSONField(name = "state")
        public int mState;
    }
}