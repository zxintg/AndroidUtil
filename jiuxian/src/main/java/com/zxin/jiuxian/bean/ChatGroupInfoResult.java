package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class ChatGroupInfoResult {
    @JSONField(name = "groupRemark")
    public String mGroupRemark;
    @JSONField(name = "MemberNum")
    public int mMemberNum;
    @JSONField(name = "Name")
    public String mMyFirstGroup;
    @JSONField(name = "nickName")
    public String mNickName;
    @JSONField(name = "Owner_Account")
    public String mOwnerAccount;
    public boolean mShowNickName;
}

