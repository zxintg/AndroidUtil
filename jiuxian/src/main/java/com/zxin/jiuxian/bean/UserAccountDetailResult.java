package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class UserAccountDetailResult {
    @JSONField(name = "accountInfo")
    public AccountInfo mAccountInfo;

    public static class AccountInfo {
        @JSONField(name = "accountList")
        public List<UserAccountDetailResult.AccountListItem> mAccountList;
        @JSONField(name = "pageCount")
        public int mPageCount;
        @JSONField(name = "usableAccount")
        public String mUsableAccount;
    }

    public static class AccountListItem {
        @JSONField(name = "changeAccount")
        public String mChangeAccount;
        @JSONField(name = "createTime")
        public long mCreateTime;
        @JSONField(name = "desc")
        public String mDesc;
        @JSONField(name = "type")
        public int mType;
        @JSONField(name = "typeName")
        public String mTypeName;
    }
}