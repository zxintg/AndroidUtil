package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class LoginInfoResult {
    @JSONField(name = "notCompleteAuthorization")
    public boolean mNotCompleteAuthorization;
    @JSONField(name = "userInfo")
    public UserLoginInfo mUserInfo;

    public static class UserLoginInfo implements Serializable {
        @JSONField(name = "isSafe")
        public String mAccountSafe;
        @JSONField(name = "returnCash")
        public String mBackMoney;
        @JSONField(name = "birthday")
        public Long mBirthday;
        @JSONField(name = "cashAccount")
        public String mCashMoney;
        @JSONField(name = "isClubUser")
        public boolean mClubUser;
        @JSONField(name = "email")
        public String mEmail;
        @JSONField(name = "goldCoin")
        public String mGoldMoney;
        @JSONField(name = "needBindMobile")
        public boolean mIsBindMobile;
        @JSONField(name = "isNewUser")
        public boolean mIsNewUser;
        @JSONField(name = "loginIP")
        public String mLoginIP;
        @JSONField(name = "loginTime")
        public long mLoginTime;
        @JSONField(name = "loginUnionFirst")
        public int mLoginUnionFirst;
        @JSONField(name = "mark")
        public String mMark;
        @JSONField(name = "mobile")
        public String mMobile;
        @JSONField(name = "nickName")
        public String mNickName;
        @JSONField(name = "phone")
        public String mPhone;
        @JSONField(name = "rank")
        public int mRank;
        @JSONField(name = "rankName")
        public String mRankName;
        @JSONField(name = "realName")
        public String mRealName;
        @JSONField(name = "referer")
        public String mReferer;
        @JSONField(name = "setupPaymentPassword")
        public boolean mSetupPaymentPassword;
        @JSONField(name = "sex")
        public int mSex;
        @JSONField(name = "specialDiscount")
        public String mSpecialDiscount;
        @JSONField(name = "token")
        public String mToken;
        @JSONField(name = "type")
        public int mType;
        @JSONField(name = "uid")
        public int mUserId;
        @JSONField(name = "userImg")
        public String mUserImage;
        @JSONField(name = "uname")
        public String mUserName;

        public String toString() {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UserLoginInfo [mUserId=");
            localStringBuilder.append(this.mUserId);
            localStringBuilder.append(", mUserName=");
            localStringBuilder.append(this.mUserName);
            localStringBuilder.append(", mBirthday=");
            localStringBuilder.append(this.mBirthday);
            localStringBuilder.append(", mNickName=");
            localStringBuilder.append(this.mNickName);
            localStringBuilder.append(", mRealName=");
            localStringBuilder.append(this.mRealName);
            localStringBuilder.append(", mUserImage=");
            localStringBuilder.append(this.mUserImage);
            localStringBuilder.append(", mType=");
            localStringBuilder.append(this.mType);
            localStringBuilder.append(", mSex=");
            localStringBuilder.append(this.mSex);
            localStringBuilder.append(", mMobile=");
            localStringBuilder.append(this.mMobile);
            localStringBuilder.append(", mEmail=");
            localStringBuilder.append(this.mEmail);
            localStringBuilder.append(", mPhone=");
            localStringBuilder.append(this.mPhone);
            localStringBuilder.append(", mLoginTime=");
            localStringBuilder.append(this.mLoginTime);
            localStringBuilder.append(", mLoginIP=");
            localStringBuilder.append(this.mLoginIP);
            localStringBuilder.append(", mRank=");
            localStringBuilder.append(this.mRank);
            localStringBuilder.append(", mRankName=");
            localStringBuilder.append(this.mRankName);
            localStringBuilder.append(", mGoldMoney=");
            localStringBuilder.append(this.mGoldMoney);
            localStringBuilder.append(", mBackMoney=");
            localStringBuilder.append(this.mBackMoney);
            localStringBuilder.append(", mCashMoney=");
            localStringBuilder.append(this.mCashMoney);
            localStringBuilder.append(", mSpecialDiscount=");
            localStringBuilder.append(this.mSpecialDiscount);
            localStringBuilder.append(", mReferer=");
            localStringBuilder.append(this.mReferer);
            localStringBuilder.append(", mMark=");
            localStringBuilder.append(this.mMark);
            localStringBuilder.append(", mToken=");
            localStringBuilder.append(this.mToken);
            localStringBuilder.append(", mLoginUnionFirst=");
            localStringBuilder.append(this.mLoginUnionFirst);
            localStringBuilder.append("]");
            return localStringBuilder.toString();
        }
    }
}
