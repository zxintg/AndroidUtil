package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.activity.OrderDetailActivity;
import com.zxin.root.util.UiUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderDetailResult
        implements Serializable {
    public static final int ALREADY_PAY_STATE = 2;
    public static final int CANCEL = 2;
    public static final int COMPLETE = 11;
    public static final int CONFIRM = 1;
    public static final int HANDLEING = 5;
    public static final int INVALID = 3;
    public static final int LOCK = 4;
    public static final int NOT_CONFIRM = 0;
    public static final int ORDER_COMMIT_SUCCESS = -1;
    public static final int PART_RETURN_GOODS = 9;
    public static final int RECEIPT_CONFIRMATION = 7;
    public static final int RETURN_GOODS = 8;
    public static final int RETURN_GOODS_COMPLETE = 12;
    public static final int SEND_GOODS = 6;
    public static final int TOTAL_RETURN_GOODS = 10;
    public static final int WAIT_FOR_PAYMENT = 1;
    public static final int WAIT_RECEIVE = 8;
    @JSONField(name = "act")
    public List<OrderDetailMoneyItem> mAct;
    @JSONField(name = "balanceFee")
    public double mBalanceFee;
    @JSONField(name = "canBuyAgain")
    public boolean mCanBuyAgain;
    @JSONField(name = "canDel")
    public boolean mCanDel;
    @JSONField(name = "channel")
    public int mChannel;
    @JSONField(name = "consigneeAddress")
    public String mConsigneeAddress;
    @JSONField(name = "consigneeMobile")
    public String mConsigneeMobile;
    @JSONField(name = "consigneeName")
    public String mConsigneeName;
    @JSONField(name = "countdown")
    public long mCountdown;
    @JSONField(name = "couponsFee")
    public double mCouponsFee;
    @JSONField(name = "createTime")
    public long mCreateTime;
    @JSONField(name = "deliveryMode")
    public int mDeliveryMode;
    @JSONField(name = "deliveryModeName")
    public String mDeliveryModeName;
    @JSONField(name = "discountFee")
    public double mDiscountFee;
    @JSONField(name = "freightFee")
    public double mFreightFee;
    @JSONField(name = "giftCardFee")
    public double mGiftCardFee;
    @JSONField(name = "invoiceDetails")
    public List<InvoiceDetailVO> mInvoiceDetails;
    @JSONField(name = "invoiceKind")
    public int mInvoiceKind;
    @JSONField(name = "invoiceName")
    public String mInvoiceName;
    @JSONField(name = "invoiceType")
    public int mInvoiceType;
    @JSONField(name = "invoiceContext")
    public String mInvoiceTypeName;
    @JSONField(name = "isPayed")
    public int mIsPayed;
    @JSONField(name = "isPayedName")
    public String mIsPayedName;
    @JSONField(name = "isPresents")
    public boolean mIsPresents;
    @JSONField(name = "isShop")
    public boolean mIsShop;
    @JSONField(name = "jxPhone")
    public String mJXphone;
    @JSONField(name = "netPayFee")
    public double mNetPayFee;
    @JSONField(name = "desc")
    public String mOrderDesc;
    @JSONField(name = "orderId")
    public int mOrderId;
    @JSONField(name = "orderItemId")
    public int mOrderItemId;
    @JSONField(name = "orderPostscript")
    public String mOrderPostscript;
    @JSONField(name = "orderSN")
    public String mOrderSN;
    @JSONField(name = "orderState")
    public int mOrderState;
    @JSONField(name = "orderStateName")
    public String mOrderStateName;
    @JSONField(name = "title")
    public String mOrderTitle;
    @JSONField(name = "orderTrace")
    public List<OrderTrace> mOrderTrace;
    @JSONField(name = "paymentTypeId")
    public int mPaymentTypeId;
    @JSONField(name = "paymentTypeName")
    public String mPaymentTypeName;
    @JSONField(name = "presents")
    public boolean mPresents;
    @JSONField(name = "presentsPostscript")
    public String mPresentsPostscript;
    @JSONField(name = "productCount")
    public int mProductCount;
    @JSONField(name = "productList")
    public List<OrderProduct> mProductList;
    @JSONField(name = "returnCashFee")
    public double mReturnCashFee;
    @JSONField(name = "receiveGroupId")
    public String mServiceGroupID;
    @JSONField(name = "shopLink")
    public String mShopLink;
    @JSONField(name = "shopName")
    public String mShopName;
    @JSONField(name = "shopPhone")
    public String mShopPhone;
    @JSONField(name = "state")
    public int mState;
    @JSONField(name = "stateName")
    public String mStateName;
    @JSONField(name = "taxpayerId")
    public String mTaxpayerId;
    @JSONField(name = "totalAmountFee")
    public double mTotalAmountFee;
    @JSONField(name = "warnMsg")
    public String mWarnMsg;
    @JSONField(name = "whetherCancel")
    public boolean mWhetherCancel;
    @JSONField(name = "whetherEvaluate")
    public boolean mWhetherEvaluate;

    public static ArrayList<OrderDetailMoneyItem> getTestActData() {
        ArrayList localArrayList = new ArrayList();
        if (OrderDetailActivity.TEST_SWITCH_DATA) {
            OrderDetailMoneyItem localOrderDetailMoneyItem;
            if (new Random().nextBoolean()) {
                localOrderDetailMoneyItem = new OrderDetailMoneyItem();
                localOrderDetailMoneyItem.mName = UiUtils.getString(R.string.order_balance);
                localOrderDetailMoneyItem.mPrice = (new Random().nextDouble() * 300.0D * new Random().nextInt(2));
                localArrayList.add(localOrderDetailMoneyItem);
            }
            if (new Random().nextBoolean()) {
                localOrderDetailMoneyItem = new OrderDetailMoneyItem();
                localOrderDetailMoneyItem.mName = UiUtils.getString(R.string.order_cashback);
                localOrderDetailMoneyItem.mPrice = (new Random().nextDouble() * 300.0D * new Random().nextInt(2));
                localArrayList.add(localOrderDetailMoneyItem);
            }
            if (new Random().nextBoolean()) {
                localOrderDetailMoneyItem = new OrderDetailMoneyItem();
                localOrderDetailMoneyItem.mName = UiUtils.getString(R.string.order_coupon);
                localOrderDetailMoneyItem.mPrice = (new Random().nextDouble() * 300.0D);
                localArrayList.add(localOrderDetailMoneyItem);
            }
            if (new Random().nextBoolean()) {
                localOrderDetailMoneyItem = new OrderDetailMoneyItem();
                localOrderDetailMoneyItem.mName = UiUtils.getString(R.string.order_active_coupon);
                localOrderDetailMoneyItem.mPrice = (new Random().nextDouble() * 300.0D);
                localArrayList.add(localOrderDetailMoneyItem);
            }
            if (new Random().nextBoolean()) {
                localOrderDetailMoneyItem = new OrderDetailMoneyItem();
                localOrderDetailMoneyItem.mName = UiUtils.getString(R.string.order_detail_gift_card);
                localOrderDetailMoneyItem.mPrice = (new Random().nextDouble() * 300.0D);
                localArrayList.add(localOrderDetailMoneyItem);
            }
        }
        return localArrayList;
    }

    public static OrderDetailResult getTestOrderData(OrderDetailResult detailResult) {
        if (detailResult != null) {
            detailResult.mIsShop = new Random().nextBoolean();
            detailResult.mShopName = UiUtils.getString(detailResult.mIsShop?R.string.order_list_other_shop:R.string.order_list_oneself_shop);
            detailResult.mShopLink = UiUtils.getString(R.string.order_list_other_shop_link);
            detailResult.mJXphone = new Random().nextBoolean()?"12345":"";
            detailResult.mShopPhone = new Random().nextBoolean()?"543212345":"";
            detailResult.mAct = getTestActData();
            if (detailResult.mIsShop) {
                detailResult.mOrderState = 8;
                detailResult.mCountdown = System.currentTimeMillis() + (long) Math.random() * 80000;
            }
        }
        return detailResult;
    }

    public static class InvoiceDetailVO implements Serializable {
        @JSONField(name = "amount")
        public String mAmount;
        @JSONField(name = "invoiceCode")
        public String mInvoiceCode;
        @JSONField(name = "invoiceLink")
        public String mInvoiceLink;
        @JSONField(name = "invoiceNO")
        public String mInvoiceNO;
    }

    public static class OrderDetailMoneyItem implements Serializable {
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "price")
        public double mPrice;
    }
}