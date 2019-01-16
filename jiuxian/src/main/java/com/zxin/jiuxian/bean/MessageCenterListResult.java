package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MessageCenterListResult {
    @JSONField(name = "list")
    public List<MessageCenter> mMessageCenterList;

    public class MessageCenter {
        @JSONField(name = "cunrrent")
        public long mCunrrent;
        @JSONField(name = "description")
        public String mDescription;
        @JSONField(name = "informTime")
        public long mInformTime;
        @JSONField(name = "title")
        public String mTitle;
        @JSONField(name = "type")
        public int mType;
        @JSONField(name = "ureadNum")
        public int mUreadNum;
    }
}

