package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

public class DeliveryTimeResult {
    @JSONField(name = "jumpProId")
    public int jumpProId;
    @JSONField(name = "arriveTime")
    public String mArriveTime;
    @JSONField(name = "miaoshaDeliveryFeeInfo")
    public MiaoshaDeliveryFeeInfo mMiaoshaDeliveryFeeInfo;
    @JSONField(name = "shopDeliveryFeeInfo")
    public String mShopDevilieryFeeInfo;
    @JSONField(name = "storeDetail")
    public ProductDetailResult.StoreDetail mStoreDetail;
    @JSONField(name = "zqInfoBo")
    public ZqInfoBo zqInfoBo;

    public static class MiaoshaDeliveryFeeInfo {
        @JSONField(name = "arriveTime")
        public String mArriveTime;
        @JSONField(name = "storeDetail")
        public ProductDetailResult.StoreDetail mStoreDetail;
    }

    public static class ZqInfoBo {
        @JSONField(name = "zqInfo")
        public String zqInfo;
        @JSONField(name = "zqLink")
        public String zqLink;
    }
}
