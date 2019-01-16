package com.zxin.jiuxian.bean;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class JoinedGroupDataResult {
    @JSONField(name = "dataList")
    public List<ChatGroup> mDataList;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class ChatGroup {
        @JSONField(name = "groupId")
        public String mGroupId;
        @JSONField(name = "groupName")
        public String mGroupName;
        @JSONField(name = "groupToast")
        public String mGroupToast;
        @JSONField(name = "isAdmin")
        public boolean mIsAdmin;
        @JSONField(name = "isOwner")
        public boolean mIsOwner;
        @JSONField(name = "level")
        public String mLevel;
        @JSONField(name = "memberCount")
        public int mMemberCount;
        @JSONField(name = "nickName")
        public String mNickName;
        @JSONField(name = "ownerAccount")
        public String mOwnerAccount;
        @JSONField(name = "remark")
        public String mRemark;
        public boolean mShowNickName;
        @JSONField(name = "unreadMsgNum")
        public int mUnreadMsgNum;
        @JSONField(name = "isTalent")
        public boolean misTalent;
        @JSONField(name = "userName")
        public String userName;
    }
}

