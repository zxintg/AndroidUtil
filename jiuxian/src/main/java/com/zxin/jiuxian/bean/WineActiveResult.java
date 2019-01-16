package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

public class WineActiveResult {
    @JSONField(name = "jzPageId")
    public String mEventId;
    private List<ExtraData7> mExtraData7List = new ArrayList();
    @JSONField(name = "infoList")
    public List<ItemInfo> mItemInfoList;
    @JSONField(name = "searchEventId")
    public String mSearchEventId;
    @JSONField(name = "searchHotEventId")
    public String mSearchHotEventId;
    @JSONField(name = "searchRecentEventId")
    public String mSearchRecentEventId;
    @JSONField(name = "shopName")
    public String mShopName;

    public static class ActiveInfo {
        @JSONField(name = "advertisingName")
        public String mActiveName;
        @JSONField(name = "advertisingId")
        public String mAdvId;
        @JSONField(name = "adImg")
        public String mImageUrl;
        @JSONField(name = "jzSourceId")
        public int mJZSourceId;
        @JSONField(name = "nineClickName")
        public String mNineClickName;
        @JSONField(name = "adLink")
        public String mTargetUrl;
        @JSONField(name = "adTitle")
        public String mTitle;
    }

    public static class ExtraData17 {
        @JSONField(name = "jzSourceId")
        public String mJzSourceId;
        @JSONField(name = "proList")
        public List<WineActiveResult.ProductItemInfo> mProductList;
        @JSONField(name = "sort")
        public int mSort;
        @JSONField(name = "tabId")
        public int mTabId;
        @JSONField(name = "tabName")
        public String mTabName;
    }

    public static class ExtraData7 {
        public static final int MIN_SECONDS = 3;
        @JSONField(name = "hour")
        public int mHour;
        @JSONField(name = "adImg")
        public String mIconUrl;
        @JSONField(name = "jzSourceId")
        public String mJZSourceId;
        @JSONField(name = "minute")
        public int mMinute;
        @JSONField(name = "text")
        public String mMoreInfo;
        @JSONField(name = "proList")
        public List<WineActiveResult.ProductItemInfo> mProductList;
        @JSONField(name = "second")
        public int mSecond;
        @JSONField(name = "adLink")
        public String mTargetUrl;
        @JSONField(name = "adTitle")
        public String mTitle;

        private long getTime(int paramInt1, int paramInt2, int paramInt3) {
            return paramInt1 * 60L * 60L + paramInt2 * 60L + paramInt3;
        }
    }

    public static class ItemInfo {
        public static final int LINE_ONE_MAX = 4;
        public static final int TYPE_BANNER = 1;
        public static final int TYPE_H_LIST = 7;
        public static final int TYPE_IMAGE_ONE = 3;
        public static final int TYPE_IMAGE_THREE = 5;
        public static final int TYPE_IMAGE_TWO = 16;
        public static final int TYPE_IMAGE_T_THREE = 8;
        public static final int TYPE_SPACE = 15;
        public static final int TYPE_TAB_LIST = 17;
        public static final int TYPE_TITLE = 10;
        @JSONField(name = "itemList")
        public List<WineActiveResult.ActiveInfo> mActiveInfoList;
        @JSONField(name = "advId")
        public int mAdvId;
        @JSONField(name = "indexName")
        public String mDescription;
        @JSONField(name = "marginTopNum")
        public int mHeight;
        @JSONField(name = "laceColor")
        public String mLaceColor;
        @JSONField(name = "modelData17")
        public List<WineActiveResult.ExtraData17> mModelData17List;
        public int mModelData17SelectedTabId;
        @JSONField(name = "modelData7")
        public WineActiveResult.ExtraData7 mModelData7;
        @JSONField(name = "modleId")
        public int mTypeId;
    }

    public static class ProductItemInfo {
        @JSONField(name = "proImg")
        public String mImageUrl;
        @JSONField(name = "jzSourceId")
        public String mJzSourceId;
        @JSONField(name = "proName")
        public String mName;
        @JSONField(name = "nineClickName")
        public String mNineClickName;
        @JSONField(name = "jxPrice")
        public double mOriginalPrice;
        @JSONField(name = "proPrice")
        public double mPrice;
        @JSONField(name = "proId")
        public int mProductId;
        @JSONField(name = "promTitle")
        public String mPromTitle;
        @JSONField(name = "sellOut")
        public boolean mSellOut;

    }
}

