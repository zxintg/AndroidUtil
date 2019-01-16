package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class UserCashbackResult {
    @JSONField(name = "accountList")
    public List<UserCashback> mCashbackList;
    @JSONField(name = "what")
    public String mHelp;
    @JSONField(name = "cashMoney")
    public String mMoney;
    @JSONField(name = "pageCount")
    public int mPageCount;

    public static class UserCashback {
        @JSONField(name = "createTime")
        public long mCreateTime;
        @JSONField(name = "desc")
        public String mDesc;
        @JSONField(name = "money")
        public String mMoney;
        @JSONField(name = "typeName")
        public String mTypeName;
    }
}
