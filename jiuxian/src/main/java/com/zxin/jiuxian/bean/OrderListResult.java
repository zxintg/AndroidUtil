package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.Random;

public class OrderListResult {
    @JSONField(name = "pageCount")
    public int mPageCount;
    @JSONField(name = "recordList")
    public List<Record> mRecordList;
    @JSONField(name = "totalCount")
    public int mTotalCount;

    public static class Record {
        public static final int SHOWBUTTON_ADD = 1;
        public static final int SHOWBUTTON_APPEND = 2;
        public static final int SHOWBUTTON_DETAIL = 4;
        public static final int SHOWBUTTON_LIST = 3;
        @JSONField(name = "alreadyEvaluate")
        public boolean mAlreadyEvaluate;
        @JSONField(name = "canBuyAgain")
        public boolean mCanBuyAgain;
        @JSONField(name = "canDel")
        public boolean mCanDel;
        @JSONField(name = "channel")
        public int mChannel;
        @JSONField(name = "countdown")
        public long mCountdown;
        @JSONField(name = "createTime")
        public long mCreateTime;
        @JSONField(name = "createType")
        public int mCreateType;
        @JSONField(name = "createTypeName")
        public String mCreateTypeName;
        @JSONField(name = "firstCommentId")
        public int mFirstCommentId;
        @JSONField(name = "isPayed")
        public int mIsPayed;
        @JSONField(name = "isPayedName")
        public String mIsPayedName;
        @JSONField(name = "isShop")
        public boolean mIsShop;
        @JSONField(name = "mobile")
        public String mMobile;
        @JSONField(name = "netPayFee")
        public double mNetPayFee;
        @JSONField(name = "orderId")
        public int mOrderId;
        @JSONField(name = "orderItemId")
        public int mOrderItemId;
        @JSONField(name = "orderSN")
        public String mOrderSN;
        @JSONField(name = "orderState")
        public int mOrderState;
        @JSONField(name = "orderStateName")
        public String mOrderStateName;
        @JSONField(name = "paymentTypeId")
        public int mPaymentTypeId;
        @JSONField(name = "paymentTypeName")
        public String mPaymentTypeName;
        @JSONField(name = "productCount")
        public int mProductCount;
        @JSONField(name = "productList")
        public List<OrderProduct> mProductList;
        public boolean mRandomBoolean = new Random().nextBoolean();
        @JSONField(name = "shopLink")
        public String mShopLink;
        @JSONField(name = "shopName")
        public String mShopName;
        @JSONField(name = "showButton")
        public int mShowButton;
        @JSONField(name = "state")
        public int mState;
        @JSONField(name = "stateName")
        public String mStateName;
        @JSONField(name = "totalAmountFee")
        public double mTotalAmountFee;
        @JSONField(name = "whetherCancel")
        public boolean mWhetherCancel;
        @JSONField(name = "whetherEvaluate")
        public boolean mWhetherEvaluate;
    }
}
