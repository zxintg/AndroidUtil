package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ActivityMessageResult {
    public static final String COIN_SEND_EVAL = "coinSendEval";
    public static final String COIN_SIGN = "signWarn";
    public static final String COLLECTION_DEPRECIATE_INFO = "depreCollect";
    public static final String COUPONTO_ACCOUNT_INFO = "couponSend";
    public static final String COUPON_EXPIRED_INFO = "couponOutOfDate";
    public static final String LOGISTICS_INFO = "logisticsInfo";
    public static final String ORDER_UNPAY_INFO = "orderUnpayInfo";
    public static final String PROMOTION_INFO = "promotionInfo";
    public static final String SHOPPINGCAT_DEPRECIATE_INFO = "depreCart";
    public static final String[] mTestData = {"logisticsInfo", "orderUnpayInfo", "couponSend", "couponOutOfDate", "depreCart", "depreCollect", "logisticsInfo", "coinSendEval", "signWarn"};
    @JSONField(name = "list")
    public List<ActivityMessageBean> mActivityMessageBeanList;
    @JSONField(name = "count")
    public int mPageCount;

    public static class ActivityBean {
        public List<ActivityMessageBean> mActivityList;
        public String mTime;
    }

    public static class ActivityMessageBean {
        @JSONField(name = "couponCount")
        public int mCouponCount;
        @JSONField(name = "createTime")
        public long mCreateTime;
        @JSONField(name = "cunrrent")
        public long mCunrrent;
        @JSONField(name = "description")
        public String mDescription;
        @JSONField(name = "extraField")
        public String mExtraField;
        @JSONField(name = "image")
        public List<String> mImage;
        @JSONField(name = "infoId")
        public int mInfoId;
        @JSONField(name = "infoType")
        public String mInfoType;
        @JSONField(name = "orderState")
        public int mOrderState;
        @JSONField(name = "price")
        public int mPrice;
        @JSONField(name = "proName")
        public String mProName;
        @JSONField(name = "evaluate")
        public int mPstate;
        public boolean mShowTime;
        public String mTime;
        @JSONField(name = "title")
        public String mTitle;
    }

}
