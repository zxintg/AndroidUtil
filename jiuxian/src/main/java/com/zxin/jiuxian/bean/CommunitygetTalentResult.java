package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunitygetTalentResult {
    @JSONField(name = "dataList")
    public List<TalentItem> mTalentList;

    public static class TalentItem {
        @JSONField(name = "imgPath")
        public String mImgPath;
        @JSONField(name = "isAdmin")
        public boolean mIsAdmin;
        @JSONField(name = "isAttentioned")
        public boolean mIsAttentioned;
        @JSONField(name = "level")
        public String mLevel;
        @JSONField(name = "nickName")
        public String mNickName;
        @JSONField(name = "userId")
        public int mUserId;
        @JSONField(name = "userName")
        public String mUserName;
    }
}
