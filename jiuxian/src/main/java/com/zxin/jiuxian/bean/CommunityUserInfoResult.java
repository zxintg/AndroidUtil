package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CommunityUserInfoResult
        implements Serializable {
    public static final String OPEN_CHAT_ROOM = "0";
    private static final long serialVersionUID = 7337010083552244504L;
    @JSONField(name = "groupId")
    public String groupId;
    @JSONField(name = "experienceValue")
    public int mExperenceValue;
    @JSONField(name = "dateline")
    public long mFirstLoginDateLine;
    @JSONField(name = "groupToast")
    public String mGroupToast;
    @JSONField(name = "headPortrait")
    public String mHeadPortrait;
    @JSONField(name = "isAdmin")
    public boolean mIsAdmin;
    @JSONField(name = "isAttention")
    public boolean mIsAttention;
    @JSONField(name = "isBlacklist")
    public boolean mIsBlackList;
    @JSONField(name = "largeV")
    public String mLargeLevel;
    @JSONField(name = "level")
    public String mLevel;
    @JSONField(name = "memberState")
    public String mMemberState;
    @JSONField(name = "nickname")
    public String mNickName;
    @JSONField(name = "role")
    public String mRole;
    @JSONField(name = "talentDesc")
    public String mTallentDesc;
    @JSONField(name = "uid")
    public int mUid;
    @JSONField(name = "username")
    public String mUserName;
    @JSONField(name = "isAttentioned")
    public boolean misAttentioned;
}