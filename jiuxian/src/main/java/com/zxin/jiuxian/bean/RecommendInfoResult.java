package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RecommendInfoResult {
    public static final String AB_TEST_A = "A";
    public static final String AB_TEST_B = "B";
    @JSONField(name = "ABTestInfo")
    public String mABTestInfo;
    @JSONField(name = "productList")
    public List<RecommendResult> mList;
    @JSONField(name = "switchState")
    public boolean mSwitchState;
    @JSONField(name = "totalPages")
    public int mTotalPages;

    public boolean isABTestA() {
        return "A".equals(this.mABTestInfo);
    }

    public boolean isABTestB() {
        return "B".equals(this.mABTestInfo);
    }

    public static class RecommendResult {
        public boolean isAlign;
        @JSONField(name = "clubPrice")
        public BigDecimal mClubPrice;
        @JSONField(name = "productImgUrl")
        public String mImageUrl;
        @JSONField(name = "isSelection")
        public boolean mIsSelection;
        @JSONField(name = "isSellOut")
        public boolean mIsSellOut;
        @JSONField(name = "productName")
        public String mName;
        public int mPosition;
        @JSONField(name = "productPrice")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "promotionList")
        public List<HomeWineListResult.PromotionLableItem> mPromotionList;
        @JSONField(name = "showVideoIcon")
        public boolean mShowVideoIcon;
    }
}
