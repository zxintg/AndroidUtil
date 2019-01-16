package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class UserWalletResult {
    @JSONField(name = "accountInfo")
    public AccountInfo mAccountInfo;

    public static class AccountInfo {
        @JSONField(name = "cashMoney")
        public String mBalanceMoney;
        @JSONField(name = "backMoney")
        public String mCashbackMoney;
        @JSONField(name = "couponCount")
        public int mCouponCount;
        @JSONField(name = "goldMoney")
        public double mGoldMoney;
    }
}
