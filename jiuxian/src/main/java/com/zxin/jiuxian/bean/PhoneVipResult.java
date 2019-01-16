package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class PhoneVipResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "exclusiveInfo")
    public PhoneVipHeader mPhoneVipHeader;

    public static class ActiveInfo implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "topicTypeId")
        public String mActiveId;
        @JSONField(name = "topicTypeName")
        public String mName;
        public int mPosition;

        public boolean equals(Object paramObject) {
            if ((paramObject instanceof ActiveInfo)) {
                return TextUtils.equals(((ActiveInfo) paramObject).mActiveId, this.mActiveId);
            }
            return super.equals(paramObject);
        }

        public int hashCode() {
            if (this.mActiveId != null) {
                return this.mActiveId.hashCode();
            }
            return super.hashCode();
        }
    }

    public static class BannerInfo implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "adImg")
        public String mImageUrl;
        public String mName;
        @JSONField(name = "adLink")
        public String mTargetUrl;
    }

    public static class PhoneVipHeader implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "topicTypeList")
        public List<PhoneVipResult.ActiveInfo> mActiveInfos;
        @JSONField(name = "shufflingImgList")
        public List<PhoneVipResult.BannerInfo> mBannerInfos;
        @JSONField(name = "recommendImgList")
        public List<PhoneVipResult.RecommendItem> mRecommendItems;
    }

    public static class RecommendItem implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "proId")
        public int mId;
        @JSONField(name = "adImg")
        public String mImageUrl;
        @JSONField(name = "adTitle")
        public String mName;
        public int mPosition;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "adLink")
        public String mTargetUrl;
        @JSONField(name = "advertisingName")
        public String mTitle;
    }
}

