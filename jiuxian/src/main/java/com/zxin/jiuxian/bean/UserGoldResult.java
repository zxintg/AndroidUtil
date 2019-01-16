package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class UserGoldResult {
    @JSONField(name = "accountList")
    public List<UserGold> mGoldList;
    @JSONField(name = "what")
    public String mHelp;
    @JSONField(name = "goldMoney")
    public String mMoney;
    @JSONField(name = "pageCount")
    public int mPageCount;

    public static class UserGold {
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
