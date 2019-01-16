package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CommunityCircleInfoResult implements Serializable {
    private static final long serialVersionUID = -5140047712200659119L;
    @JSONField(name = "adminId")
    public int adminId;
    @JSONField(name = "adminName")
    public String adminName;
    @JSONField(name = "alreadyJoin")
    public boolean mAlreadyJoin;
    @JSONField(name = "categoryId")
    public int mCategoryId;
    @JSONField(name = "categoryName")
    public String mCategoryName;
    @JSONField(name = "imageUrl")
    public String mCircleImg;
    @JSONField(name = "name")
    public String mCircleName;
    @JSONField(name = "type")
    public String mCircleType;
    @JSONField(name = "fid")
    public int mFid;
    @JSONField(name = "isTop")
    public boolean mIsTop;
    @JSONField(name = "dateline")
    public long mJoinCircleTime;
    @JSONField(name = "datelineText")
    public String mJoinCircleTimeText;
    @JSONField(name = "popularityNum")
    public int mPopularityNum;
    @JSONField(name = "totalTopicNum")
    public int mTopicNum;
}