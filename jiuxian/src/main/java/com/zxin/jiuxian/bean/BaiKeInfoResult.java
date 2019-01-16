package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.zxin.jiuxian.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */

public class BaiKeInfoResult {
    @JSONField(name = "productBaseInfo")
    public BaseInfo mBaseInfo;
    @JSONField(name = "grapeNames")
    public List<String> mBreedInfoList;
    @JSONField(name = "summary")
    public String mDescription;
    @JSONField(name = "productExtInfo")
    public ExpandInfo mExpandInfo;

    public boolean isExpandInfoEmpty() {
        if (this.mExpandInfo == null) {
            return true;
        }
        return (StringUtils.textIsEmpty(this.mExpandInfo.mAddress)) && (StringUtils.textIsEmpty(this.mExpandInfo.mChateau)) && (StringUtils.textIsEmpty(this.mExpandInfo.mCountry)) && (StringUtils.textIsEmpty(this.mExpandInfo.mFeel)) && (StringUtils.textIsEmpty(this.mExpandInfo.mType));
    }

    public static class BaseInfo {
        @JSONField(name = "englishName")
        public String mENName;
        @JSONField(name = "productImage")
        public String mImageUrl;
        @JSONField(name = "productName")
        public String mName;
        @JSONField(name = "productPrice")
        public String mPrice;
        @JSONField(name = "productId")
        public String mProductId;
        @JSONField(name = "years")
        public List<String> mYears;
    }

    public static class ExpandInfo {
        @JSONField(name = "area")
        public String mAddress;
        @JSONField(name = "winery")
        public String mChateau;
        @JSONField(name = "country")
        public String mCountry;
        @JSONField(name = "taste")
        public String mFeel;
        @JSONField(name = "productPrice")
        public String mPrice;
        @JSONField(name = "wineType")
        public String mType;
    }
}

