package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class UserCenterResult {
    @JSONField(name = "clubUserWapUrl")
    public String mClubUserWapUrl;
    @JSONField(name = "userAddressInfo")
    public UserAddressInfo mUserAddressInfo;
    @JSONField(name = "bibberInfo")
    public UserCenterInfo mUserCenterInfo;

    public static class Club {
        public static final int CLUB_HEAD_LOGIN = 1;
        public static final int CLUB_HEAD_NOT_LOGIN = 0;
        public static final int CLUB_MY_COLLECT = 4;
        public static final int CLUB_MY_IDEA = 5;
        public static final int CLUB_MY_ORDER = 2;
        public static final int CLUB_MY_PURSE = 3;
        public static final int CLUB_PRODUCT = 6;
        public static final int TOTLE_COUNT = 7;
        public int mType = -1;
    }

    public static class ClubCollect extends UserCenterResult.Club {
        public int mBrowseCount;
        public int mCollCount;
        public String mExchangeCount;
    }

    public static class ClubHead extends UserCenterResult.Club {
        public String mClubUserWapUrl;
        public boolean mIsClubUser;
        public boolean mIsNotRealNameVerified;
        public String mNickName;
        public String mRankName;
        public String mUserImage;
        public String mUserName;
    }

    public static class ClubModule extends UserCenterResult.Club {
    }

    public static class ClubOrder extends UserCenterResult.Club {
        public int mUnCommentCount;
        public int mUnPayCount;
        public int mUnReceiveCount;
        public int mUnSendCount;
    }

    public static class ClubProduct extends UserCenterResult.Club {
    }

    public static class ClubPurse extends UserCenterResult.Club {
        public double mBalanceMoney;
        public double mCashBackMoney;
        public int mCouponCount;
        public double mGoldMoney;
    }

    public static class UserAddressInfo {
        @JSONField(name = "city")
        public String mCity;
        @JSONField(name = "cityId")
        public int mCityId;
        @JSONField(name = "district")
        public String mDistrict;
        @JSONField(name = "districtId")
        public int mDistrictId;
        @JSONField(name = "province")
        public String mProvince;
        @JSONField(name = "provinceId")
        public int mProvinceId;
    }

    public static class UserCenterInfo {
        @JSONField(name = "notCompleteAuthorization")
        public boolean isNotRealNameVerified;
        @JSONField(name = "cashMoney")
        public double mBalanceMoney;
        @JSONField(name = "browseCount")
        public int mBrowseCount;
        @JSONField(name = "backMoney")
        public double mCashBackMoney;
        @JSONField(name = "proCollCount")
        public int mCollCount;
        @JSONField(name = "couponCount")
        public int mCouponCount;
        @JSONField(name = "goldMoney")
        public double mGoldMoney;
        @JSONField(name = "isClubUser")
        public boolean mIsClubUser;
        @JSONField(name = "rankName")
        public String mRankName;
        @JSONField(name = "preCommCount")
        public int mUnCommentCount;
        @JSONField(name = "prePayCount")
        public int mUnPayCount;
        @JSONField(name = "preReceiveCount")
        public int mUnReceiveCount;
        @JSONField(name = "preSendCount")
        public int mUnSendCount;
        @JSONField(name = "unreceivedExchangeNums")
        public String mUnreceivedExchangeNums;
        @JSONField(name = "userImage")
        public String mUserImage;
        @JSONField(name = "userName")
        public String mUserName;
        @JSONField(name = "nickName")
        public String mnickName;
    }
}
