package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class UserInfoResult {
    public UserInfo mUserInfo;

    public static class UserInfo {
        @JSONField(name = "alias")
        public String mAlias;
        @JSONField(name = "birthday")
        public String mBirthday;
        @JSONField(name = "rankName")
        public String mRankName;
        @JSONField(name = "sex")
        public int mSex;
        @JSONField(name = "userImage")
        public String mUserImage;
        @JSONField(name = "userName")
        public String mUserName;
    }
}
