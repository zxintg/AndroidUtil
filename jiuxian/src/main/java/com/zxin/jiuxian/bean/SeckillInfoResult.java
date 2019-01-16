package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

public class SeckillInfoResult {
    @JSONField(name = "mobileSecondKillPo")
    public SeckillInfo mSeckillInfo;

    public static class BannerInfo implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "adImg")
        public String mImageUrl;
        public String mName;
        @JSONField(name = "adLink")
        public String mTargetUrl;
    }

    public static class SeckillInfo {
        @JSONField(name = "bannerList")
        public List<SeckillInfoResult.BannerInfo> mBannerInfos;
        @JSONField(name = "betweenTime")
        public long mBetweenTime;
        @JSONField(name = "isOngoing")
        public int mHasBegin;
        public int mHour;
        public int mMinute;
        @JSONField(name = "pageCount")
        public int mPageCount;
        @JSONField(name = "killProList")
        public List<SeckillProduct> mSeckillProducts;
        public int mSecond;
        @JSONField(name = "totalCount")
        public int mTotalCount;

        private long getTime(int paramInt1, int paramInt2, int paramInt3) {
            return paramInt1 * 60L * 60L + paramInt2 * 60L + paramInt3;
        }

    }
}

