package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderPrepareResult {
    @JSONField(name = "promotionCutPrice")
    public double mActiveCouponMoney;
    @JSONField(name = "usedAddress")
    public AddressInfo mAddressInfo;
    @JSONField(name = "JXAccountMoney")
    public double mAllBalanceMoney;
    @JSONField(name = "cashBackMoney")
    public double mAllCashbackMoney;
    @JSONField(name = "allProductJiuxian")
    public boolean mAllProductJiuxian;
    @JSONField(name = "availableCouponCount")
    public int mAvailableCouponCount;
    @JSONField(name = "bindMobil")
    public String mBindMobil;
    @JSONField(name = "bonusCutPrice")
    public double mCouponMoney;
    @JSONField(name = "bonusDisable")
    public int mCouponsEnable;
    @JSONField(name = "usedBouns")
    public OrderCoupon mDefaultCoupon;
    @JSONField(name = "regionForbidenInfo")
    public String mDeliveryInfo;
    @JSONField(name = "disabledCoupons")
    public ArrayList<OrderCoupon> mDisableCouponList;
    @JSONField(name = "useableCoupons")
    public ArrayList<OrderCoupon> mEnableCouponList;
    @JSONField(name = "expensesPriceDetailList")
    public ArrayList<ExpensesPriceDetail> mExpensesPriceDetailList;
    @JSONField(name = "giftOrderUsable")
    public boolean mGiftOrderUsable;
    @JSONField(name = "hasSetPayPwd")
    public boolean mHasSetPayPwd;
    @JSONField(name = "invKind")
    public int mInvKind = -1;
    @JSONField(name = "invMobile")
    public String mInvMobile;
    @JSONField(name = "invType")
    public int mInvType;
    @JSONField(name = "invTitle")
    public String mInvoiceTitle;
    @JSONField(name = "invContent")
    public String mInvoiceType;
    @JSONField(name = "isBuyImmediately")
    public int mIsBuyImmediately;
    @JSONField(name = "isGiftOrder")
    public int mIsGiftOrder;
    @JSONField(name = "isSupportElecInv")
    public boolean mIsSupportElecInv;
    @JSONField(name = "needInv")
    public int mNeedInvoice;
    @JSONField(name = "payAftreDelivery")
    public int mPayAftreDelivery;
    @JSONField(name = "payAftreDeliveryShow")
    public int mPayAftreDeliveryShow;
    @JSONField(name = "payOnline")
    public int mPayOnline;
    @JSONField(name = "payPaswdErrTimesOutInfo")
    public String mPayPaswdErrTimesOutInfo;
    @JSONField(name = "payPrice")
    public double mPayPrice;
    @JSONField(name = "payType")
    public int mPayType;
    @JSONField(name = "priceList")
    public ArrayList<PriceInfo> mPriceInfoList;
    @JSONField(name = "productsList")
    public OrderProductsGroup mProductsList;
    @JSONField(name = "taxpayerId")
    public String mTaxpayerId;
    @JSONField(name = "toUseJXAccount")
    public int mToUseBalanceMoney;
    @JSONField(name = "toUseCashBack")
    public int mToUseCashbackMoney;
    @JSONField(name = "toUseCoupon")
    public int mToUseCoupon = -1;
    @JSONField(name = "totalCouponCount")
    public int mTotalCouponCount;
    @JSONField(name = "totalPrice")
    public double mTotalPrice;
    @JSONField(name = "transportTypes")
    public List<TransportType> mTransportTypes;
    @JSONField(name = "useCouponCount")
    public int mUseCouponCount;
    @JSONField(name = "useCouponIds")
    public String mUseCouponIds;
    @JSONField(name = "useCouponTotalPrice")
    public String mUseCouponTotalPrice;

    public static ExchangeProductDeliveryIncludeTitle getExchangeProductDeliveryIncludeTitle(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (paramOrderPrepareResult.mProductsList.mExchangeProductDeliveryIncludeTitle != null)) {
            return paramOrderPrepareResult.mProductsList.mExchangeProductDeliveryIncludeTitle;
        }
        return null;
    }

    public static String getFreePostTitle(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (!TextUtils.isEmpty(paramOrderPrepareResult.mProductsList.mExchangeProductDeliveryIncludeTitle.mFreePostTitleInfo))) {
            return paramOrderPrepareResult.mProductsList.mExchangeProductDeliveryIncludeTitle.mFreePostTitleInfo;
        }
        return "";
    }

    public static ArrayList<OrderProduct> getNoStockGiftsProducts(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (paramOrderPrepareResult.mProductsList.mNoStockGifts != null)) {
            return paramOrderPrepareResult.mProductsList.mNoStockGifts;
        }
        return null;
    }

    public static String getNoStockGiftsTitle(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (!TextUtils.isEmpty(paramOrderPrepareResult.mProductsList.mNoStockGiftsTitle))) {
            return paramOrderPrepareResult.mProductsList.mNoStockGiftsTitle;
        }
        return "";
    }

    public static ArrayList<OrderProduct> getStopTypeDeliveryProducts(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (paramOrderPrepareResult.mProductsList.mStopTypeDeliveryProducts != null)) {
            return paramOrderPrepareResult.mProductsList.mStopTypeDeliveryProducts;
        }
        return null;
    }

    public static String getStopTypeDeliveryTitle(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (!TextUtils.isEmpty(paramOrderPrepareResult.mProductsList.mStopTypeDeliveryTitle))) {
            return paramOrderPrepareResult.mProductsList.mStopTypeDeliveryTitle;
        }
        return "";
    }

    public static ArrayList<OrderProduct> getStopTypeWeatherProducts(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (paramOrderPrepareResult.mProductsList.mStopTypeWeatherProducts != null)) {
            return paramOrderPrepareResult.mProductsList.mStopTypeWeatherProducts;
        }
        return null;
    }

    public static String getStopTypeWeatherTitle(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (!TextUtils.isEmpty(paramOrderPrepareResult.mProductsList.mStopTypeWeatherTitle))) {
            return paramOrderPrepareResult.mProductsList.mStopTypeWeatherTitle;
        }
        return "";
    }

    public static ArrayList<OrderProduct> getUnableProducts(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (paramOrderPrepareResult.mProductsList.mUnableProducts != null)) {
            return paramOrderPrepareResult.mProductsList.mUnableProducts;
        }
        return null;
    }

    public static String getUnableProductsTitle(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (!TextUtils.isEmpty(paramOrderPrepareResult.mProductsList.mUnableTitle))) {
            return paramOrderPrepareResult.mProductsList.mUnableTitle;
        }
        return "";
    }

    public static String getmFreePostUrl(OrderPrepareResult paramOrderPrepareResult) {
        if ((paramOrderPrepareResult != null) && (paramOrderPrepareResult.mProductsList != null) && (!TextUtils.isEmpty(paramOrderPrepareResult.mProductsList.mExchangeProductDeliveryIncludeTitle.mFreePostUrl))) {
            return paramOrderPrepareResult.mProductsList.mExchangeProductDeliveryIncludeTitle.mFreePostUrl;
        }
        return "";
    }

    public static class AddressInfo implements Serializable {
        private static final long serialVersionUID = -1123281639229847262L;
        @JSONField(name = "fullAddress")
        public String mAddress;
        @JSONField(name = "alertNewAddress")
        public boolean mAlertNewAddress;
        @JSONField(name = "addressId")
        public int mId;
        @JSONField(name = "isDefault")
        public int mIsDefault;
        @JSONField(name = "consignee")
        public String mName;
        @JSONField(name = "mobile")
        public String mPhoneNumber;
        @JSONField(name = "userAddressList")
        public ArrayList<AddressListResultInfo.AddrListItem> mUserAddressList;
    }

    public static class BaseProduct implements Serializable {
        @JSONField(name = "proImg")
        public String mImgUrl;
        @JSONField(name = "proName")
        public String mName;
        @JSONField(name = "productId")
        public int mProductId;
    }

    public static class ExchangeProductDeliveryIncludeTitle implements Serializable {
        @JSONField(name = "title")
        public String mFreePostTitleInfo;
        @JSONField(name = "url")
        public String mFreePostUrl;
    }

    public static class ExpensesPriceDetail implements Serializable {
        @JSONField(name = "jiuxianSelf")
        public boolean mJiuxianSelf;
        @JSONField(name = "productList")
        public ArrayList<String> mProductIconList;
        @JSONField(name = "shopName")
        public String mShopName;
        @JSONField(name = "shopPrice")
        public double mShopPrice;
    }

    public static class Label implements Serializable {
        public static final String LABEL_DABAOGOU = "packageBuy";
        public static final String LABEL_JIAJIAGOU = "changeBuy";
        public static final String LABEL_MANJIAN = "fullSubtract";
        public static final String LABEL_MANZENG = "fullGive";
        public static final String LABEL_RENNITIAO = "youPick";
        private static final long serialVersionUID = 3028873626767639566L;
        @JSONField(name = "activityId")
        public int mActivityId;
        @JSONField(name = "label")
        public String mLabel;
        @JSONField(name = "labelColor")
        public String mLabelColor;
        @JSONField(name = "labelType")
        public String mLabelType;
    }

    public static class OrderChangeBuyInfo implements Serializable {
        private static final long serialVersionUID = -7797528192132088323L;
        @JSONField(name = "packageId")
        public String mId;
        @JSONField(name = "packageNum")
        public int mNum;
        @JSONField(name = "packPrice")
        public double mPrice;
        @JSONField(name = "productList")
        public ArrayList<OrderPrepareResult.OrderProduct> mProductList;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }

    public static class OrderChangeBuyList implements Serializable {
        private static final long serialVersionUID = -4217019111595362546L;
        @JSONField(name = "packageId")
        public String mId;
        @JSONField(name = "productList")
        public ArrayList<OrderPrepareResult.OrderProduct> mProductList;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }

    public static class OrderCoupon implements Serializable {
        private static final long serialVersionUID = -98437244454118072L;
        public boolean mChecked;
        @JSONField(name = "couponType")
        public int mCouponType;
        @JSONField(name = "endTime")
        public long mEndTime;
        @JSONField(name = "bonusId")
        public int mId;
        @JSONField(name = "money")
        public double mMoney;
        @JSONField(name = "bonusName")
        public String mName;
        @JSONField(name = "scope")
        public int mScope;
        @JSONField(name = "beginTime")
        public long mStartTime;
    }

    public static class OrderExchangeInfo implements Serializable {
        private static final long serialVersionUID = -7797528192132088323L;
        @JSONField(name = "exchangeCode")
        public String mExchangeCode;
        @JSONField(name = "productList")
        public ArrayList<OrderPrepareResult.OrderProduct> mProductList;
    }

    public static class OrderGiftsInfo implements Serializable {
        private static final long serialVersionUID = -7797528192132088323L;
        @JSONField(name = "productList")
        public ArrayList<OrderPrepareResult.OrderProduct> mProductList;
        @JSONField(name = "promotionId")
        public int mPromotionId;
        @JSONField(name = "promotionType")
        public String mPromotionType;
    }

    public static class OrderPackageBuyInfo implements Serializable {
        private static final long serialVersionUID = 714584549904310437L;
        @JSONField(name = "packageId")
        public String mId;
        @JSONField(name = "packageNum")
        public int mNum;
        @JSONField(name = "packPrice")
        public double mPrice;
        @JSONField(name = "productList")
        public ArrayList<OrderPrepareResult.OrderProduct> mProductList;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }

    public static class OrderProduct implements Serializable {
        public static final int CHECKED_FALSE = 0;
        public static final int CHECKED_TRUE = 1;
        public static final int CONSTANT_ISDISABLECOUPON = 1;
        public static final String CONSTANT_ORDER_ALERT_BUY_LIMIT = "0006";
        public static final String CONSTANT_ORDER_ALERT_DELETED = "0001";
        public static final String CONSTANT_ORDER_ALERT_NOTDELIVERY = "0004";
        public static final String CONSTANT_ORDER_ALERT_NOTENOUGH = "0005";
        public static final String CONSTANT_ORDER_ALERT_NOTSALE = "0003";
        public static final String CONSTANT_ORDER_ALERT_NOT_DELIVERY = "0008";
        public static final String CONSTANT_ORDER_ALERT_NOT_DELIVERY_EXPRESS = "0009";
        public static final String CONSTANT_ORDER_ALERT_NO_GOODS = "0007";
        public static final String CONSTANT_ORDER_ALERT_OFFSALE = "0002";
        private static final long serialVersionUID = -1536743384005179583L;
        @JSONField(name = "proImg")
        public String mImgUrl;
        @JSONField(name = "isDisableCoupon")
        public int mIsDisableCoupon;
        @JSONField(name = "jxLabels")
        public ArrayList<String> mJxLabels;
        @JSONField(name = "proName")
        public String mName;
        @JSONField(name = "buyNum")
        public int mNum;
        @JSONField(name = "proPrice")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "promoLabel")
        public String mPromoLabel;
        @JSONField(name = "stateLabel")
        public String mStateLabel;
        @JSONField(name = "titleLabel")
        public String mTitleLabel;
    }

    public static class OrderProductsGroup {
        @JSONField(name = "exchangeProductDeliveryIncludeTitle")
        public OrderPrepareResult.ExchangeProductDeliveryIncludeTitle mExchangeProductDeliveryIncludeTitle;
        @JSONField(name = "giftsList")
        public ArrayList<OrderPrepareResult.OrderProduct> mGiftsList;
        @JSONField(name = "noStockGifts")
        public ArrayList<OrderPrepareResult.OrderProduct> mNoStockGifts;
        @JSONField(name = "noStockGiftsTitle")
        public String mNoStockGiftsTitle;
        @JSONField(name = "normalList")
        public ArrayList<OrderPrepareResult.OrderProduct> mNormalList;
        @JSONField(name = "stopTypeDeliveryProducts")
        public ArrayList<OrderPrepareResult.OrderProduct> mStopTypeDeliveryProducts;
        @JSONField(name = "stopTypeDeliveryTitle")
        public String mStopTypeDeliveryTitle;
        @JSONField(name = "stopTypeWeatherProducts")
        public ArrayList<OrderPrepareResult.OrderProduct> mStopTypeWeatherProducts;
        @JSONField(name = "stopTypeWeatherTitle")
        public String mStopTypeWeatherTitle;
        @JSONField(name = "unableProducts")
        public ArrayList<OrderPrepareResult.OrderProduct> mUnableProducts;
        @JSONField(name = "unableTitle")
        public String mUnableTitle;
    }

    public static class OrderYouPickInfo implements Serializable {
        private static final long serialVersionUID = -7797528192132088323L;
        @JSONField(name = "packageId")
        public String mId;
        @JSONField(name = "packageNum")
        public int mNum;
        @JSONField(name = "packPrice")
        public double mPrice;
        @JSONField(name = "productList")
        public ArrayList<OrderPrepareResult.OrderProduct> mProductList;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }

    public static class PriceInfo {
        public static String TYPE_BACKCASH = "backCash";
        public static String TYPE_COUPON = "coupon";
        public static String TYPE_EXPENSES = "expenses";
        public static String TYPE_POMITION = "pomition";
        public static String type_JXAccount = "JXAccount";
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "type")
        public String mType;
    }

    public static class TransportType {
        @JSONField(name = "id")
        public int mId;
        @JSONField(name = "name")
        public String mName;
    }
}