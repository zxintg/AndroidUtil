package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommodityExchangeUnclaimedListResult {
    @JSONField(name = "unreceivedExchangeCodeList")
    public List<UnclaimedData> mUnclaimedDatas;

    public static class Operate {
        @JSONField(name = "canDelete")
        public boolean canDelete;
        @JSONField(name = "colorOfTip")
        public String colorOfTip;
        @JSONField(name = "exchangeCodeDisable")
        public boolean exchangeCodeDisable;
        @JSONField(name = "exchangeCodeTip")
        public String exchangeCodeTip;
        @JSONField(name = "transparency")
        public float transparency;
        @JSONField(name = "transparencyOfPic")
        public float transparencyOfPic;
        @JSONField(name = "transparencyOfTip")
        public float transparencyOfTip;
    }

    public static class UnclaimedData {
        @JSONField(name = "addCartTip")
        public String addCartTip;
        @JSONField(name = "havePackage")
        public boolean havePackage;
        public boolean isFirstPackage;
        public boolean isLastPackage;
        @JSONField(name = "exchangeCode")
        public String mCode;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "source")
        public String mSource;
        @JSONField(name = "productName")
        public String mTitle;
        @JSONField(name = "productImage")
        public String mURL;
        @JSONField(name = "operate")
        public CommodityExchangeUnclaimedListResult.Operate operate;
        @JSONField(name = "packageTitle")
        public String packageTitle;
        @JSONField(name = "rightTip")
        public String rightTip;
        @JSONField(name = "unreceivedExchangeCodeBOList")
        public List<UnclaimedData> unreceivedExchangeCodeBOList;
    }
}
