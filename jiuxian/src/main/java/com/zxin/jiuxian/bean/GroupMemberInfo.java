package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class GroupMemberInfo {
    @JSONField(name = "dataList")
    public List<GroupMember> mGroupMembers;
    @JSONField(name = "dataList")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;

    public static class GroupMember {
        @JSONField(name = "imgPath")
        public String mImgPath;
        @JSONField(name = "isTallent")
        public boolean mIsTallent;
        @JSONField(name = "level")
        public String mLevel;
        @JSONField(name = "nickName")
        public String mNickName;
        @JSONField(name = "userId")
        public int mUserId;
        @JSONField(name = "userName")
        public String mUserName;

        public static String limitNickNameLength(String paramString) {
            if ((!TextUtils.isEmpty(paramString)) && (paramString.length() > 5)) {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(paramString.substring(0, 4));
                localStringBuilder.append("...");
                return localStringBuilder.toString();
            }
            return paramString;
        }

        public String getNickName() {
            if (!TextUtils.isEmpty(this.mNickName)) {
                return limitNickNameLength(this.mNickName);
            }
            if (!TextUtils.isEmpty(this.mUserName)) {
                return limitNickNameLength(this.mUserName);
            }
            return null;
        }
    }
}