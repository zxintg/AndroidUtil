package com.zxin.jiuxian.bean;

import android.content.Context;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConditionResultInfo {
    private static final String PRICE_ATTRID = "4";
    @JSONField(name = "attrList")
    public List<AttrListItem> mAttrList;

    public static class AttrListItem implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "brandList")
        public ArrayList<ConditionResultInfo.BrandListItem> mBrandLists;
        @JSONField(name = "checkItem")
        public ConditionResultInfo.ListItem mCheckItem;
        @JSONField(name = "id")
        public String mId;
        @JSONField(name = "isAttrItemCheck")
        public boolean mIsAttrItemCheck = false;
        @JSONField(name = "isBrandLetter")
        public boolean mIsBrandLetter = false;
        @JSONField(name = "list")
        public ArrayList<ConditionResultInfo.ListItem> mListItems;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "textList")
        public ArrayList<ConditionResultInfo.ListItem> mTextListItems;
    }

    public static class BrandListItem implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "isAll")
        public boolean mIsAll = false;
        @JSONField(name = "letterList")
        public List<ConditionResultInfo.ListItem> mLetterLists;
        @JSONField(name = "letterName")
        public String mLetterName;
    }

    public static class ListItem implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "attrId")
        public String mAttrId;
        @JSONField(name = "id")
        public String mId;
        @JSONField(name = "index")
        public int mIndex;
        @JSONField(name = "inputPrice")
        public String mInputPrice;
        @JSONField(name = "isAll")
        public boolean mIsAll = false;
        @JSONField(name = "isInput")
        public boolean mIsInput = false;
        @JSONField(name = "isItemCheck")
        public boolean mIsItemCheck = false;
        @JSONField(name = "isPrice")
        public boolean mIsPrice = false;
        @JSONField(name = "isTextList")
        public boolean mIsTextList = false;
        @JSONField(name = "maxPrice")
        public ItemPrice mMaxPrice;
        @JSONField(name = "mixPrice")
        public ItemPrice mMixPrice;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "parentIndex")
        public int mParentIndex;
        @JSONField(name = "price")
        public String mPrice;
    }
}

