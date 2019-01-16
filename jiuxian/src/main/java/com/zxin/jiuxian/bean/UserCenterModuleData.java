package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserCenterModuleData {
    @JSONField(name = "data")
    public List<ModuleData> mListData;

    public static class ModuleData extends UserCenterResult.Club {
        public static final String KEY_FEEDBACK = "FEEDBACK_KEY";
        public static final String TYPE_INNER_LINK = "INNER_LINK";
        public static final String TYPE_LINE = "empty_line";
        public static final String TYPE_NATIVE = "NATIVE";
        public static final String TYPE_OUTER_LINK = "OUTER_LINK";
        public static final String TYPE_TEL = "TEL";
        @JSONField(name = "desc")
        public String mDesc;
        @JSONField(name = "group")
        public int mGroupId;
        @JSONField(name = "imgPath")
        public String mImageUrl;
        @JSONField(name = "key")
        public String mKey;
        @JSONField(name = "name")
        public String mName;
        public boolean mShowLine;
        @JSONField(name = "tel")
        public String mTel;
        @JSONField(name = "type")
        public String mType;
        @JSONField(name = "url")
        public String mUrl;
    }
}