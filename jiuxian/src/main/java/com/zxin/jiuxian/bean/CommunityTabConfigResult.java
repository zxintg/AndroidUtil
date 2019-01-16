package com.zxin.jiuxian.bean;

import android.content.res.Resources;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CommunityTabConfigResult {
    public static final String CHAT_GROUP = "chatgroup";
    public static final int CHAT_GROUP_ONE = 0;
    public static final int CHAT_GROUP_THREE = 2;
    public static final int CHAT_GROUP_TWO = 1;
    public static final int TAB_ALIVE = 33;
    public static final int TAB_HOME_PAGE = 11;
    public static final int TAB_NEW = 55;
    public static final int TAB_PROMOTION = 22;
    public static final int TAB_WINE_CIRCLE = 44;
    @JSONField(name = "dataList")
    public ArrayList<TabInfoResult> mTabConfigList;

    public static class TabInfoResult{
        @JSONField(name = "code")
        public int mCode;
        @JSONField(name = "defaultAction")
        public boolean mDefaultAction;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "sort")
        public int mSort;
        @JSONField(name = "type")
        public String mType;
    }
}