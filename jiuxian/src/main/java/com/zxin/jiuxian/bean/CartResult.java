package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;

public class CartResult implements Serializable {
    public static final int CHECKED_FALSE = 0;
    public static final int CHECKED_TRUE = 1;
    private static final long serialVersionUID = 7413029693153360561L;
    public ArrayList<ChangeBuyList> mChangeBuyList;
    @JSONField(name = "checkAll")
    public boolean mCheckAll;
    @JSONField(name = "checkedNum")
    public int mCheckedNum;
    @JSONField(name = "stopExpressTitle")
    public String mDeliveryInfo;
    @JSONField(name = "privilege")
    public double mDiscount;
    public ArrayList<ExchangeProductInfo> mExchangeCodeList;
    @JSONField(name = "title")
    public String mFreightInfo;
    public ArrayList<PackageBuyInfo> mPackageBuyList;
    public ArrayList<ProductInfo> mProductList;
    @JSONField(name = "productNum")
    public int mProductNum;
    @JSONField(name = "shopList")
    public ArrayList<ShopInfo> mShopList;
    public ArrayList<SnapUpProductInfo> mSnapUpProductList;
    @JSONField(name = "gmv")
    public double mTotal;
    @JSONField(name = "total")
    public double mTotalPay;
    public ArrayList<YouPickInfo> mYouPickList;


    public static class BaseItemInfo implements Serializable {
        public static final String TYPE_SHOP_INFO = "shopInfo";
        @JSONField(name = "check")
        public int mCheck;
        @JSONField(name = "createTime")
        public long mCreateTime;
        public boolean mEditCheckedStatus;
        public boolean mHasLine;
        @JSONField(name = "shopCheckAll")
        public boolean mShopCheckAll;
        @JSONField(name = "shopId")
        public String mShopId;
        public String mType;
    }

    public static class BaseProductsInfo extends CartResult.BaseItemInfo  implements Serializable {
        public static final String TYPE_CHANGEBUY = "changeBuy";
        public static final String TYPE_EXCHANGE = "exchangeCode";
        public static final String TYPE_PACKAGEBUY = "packageBuy";
        public static final String TYPE_PRODUCT = "product";
        public static final String TYPE_SNAPUP = "snapup";
        public static final String TYPE_YOUPICK = "youPick";
        private static final long serialVersionUID = 6396880671052670027L;
        @JSONField(name = "id")
        public String mId;
        @JSONField(name = "productList")
        public ArrayList<CartResult.Product> mProductList;

        public static boolean isEnableCheck(BaseProductsInfo paramBaseProductsInfo) {
            if ((paramBaseProductsInfo != null) && (paramBaseProductsInfo.mProductList != null) && (paramBaseProductsInfo.mProductList.size() > 0)) {
                CartResult.Product product = paramBaseProductsInfo.mProductList.get(0);
                if ((product != null) && ((product.isOffline()) || (product.isNotSell()))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isShowSeckillAlertInfo(BaseProductsInfo paramBaseProductsInfo) {
            if ((paramBaseProductsInfo != null) && (paramBaseProductsInfo.mProductList != null) && (paramBaseProductsInfo.mProductList.size() > 0)) {
                CartResult.Product product = paramBaseProductsInfo.mProductList.get(0);
                if ((product != null) && ((product.isOffline()) || (product.isNotSell()) || (product.isStockOut()) || (product.isSellOut()))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isValidSeckillEnableCheck(BaseProductsInfo paramBaseProductsInfo) {
            if ((paramBaseProductsInfo != null) && (paramBaseProductsInfo.mProductList != null) && (paramBaseProductsInfo.mProductList.size() > 0)) {
                CartResult.Product product = paramBaseProductsInfo.mProductList.get(0);
                if ((product != null) && (!product.isOffline()) && (!product.isNotSell()) && (product.mValid)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class ChangeBuyList extends CartResult.BaseProductsInfo implements Serializable {
        private static final long serialVersionUID = -4217019111595362546L;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }

    public static class ExchangeProductInfo extends CartResult.BaseProductsInfo implements Serializable {
        private static final long serialVersionUID = -1669880075278854833L;
        @JSONField(name = "exchangeCode")
        public String mExchangeCode;
    }

    public static class Label implements Serializable {
        public static final String LABEL_CUTPRICE = "cutPrice";
        public static final String LABEL_DABAOGOU = "packageBuy";
        public static final String LABEL_EXCHANGECODE = "exchangeCode";
        public static final String LABEL_GIFT = "gift";
        public static final String LABEL_JIAJIAGOU = "changeBuy";
        public static final String LABEL_LADDER_PRICE = "ladderPrice";
        public static final String LABEL_MAIZENG = "buyGive";
        public static final String LABEL_MANJIAN = "fullSubtract";
        public static final String LABEL_MANZENG = "fullGive";
        public static final String LABEL_MEBER_PRICE = "memberPrice";
        public static final String LABEL_PREMIUM_PRICE = "premiumPrice";
        public static final String LABEL_RENNITIAO = "youPick";
        public static final String LABEL_RETURNCOUPON = "returnCoupon";
        public static final String LABEL_RETURN_COUPON = "returnCoupon";
        public static final String LABEL_SNAPUP = "snapup";
        private static final long serialVersionUID = 3028873626767639566L;
        @JSONField(name = "activityId")
        public int mActivityId;
        @JSONField(name = "label")
        public String mLabel;
        @JSONField(name = "labelColor")
        public String mLabelColor;
        @JSONField(name = "labelLocation")
        public String mLabelLocation;
        @JSONField(name = "labelType")
        public String mLabelType;
    }

    public static class PackageBuyInfo extends CartResult.BaseProductsInfo implements Serializable {
        private static final long serialVersionUID = 714584549904310437L;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }

    public static class Product implements Serializable {
        private static final String ALERT_CART_ALERT_CONVERT_OVERDUE = "cart.alert.exchange_failure";
        private static final String ALERT_CART_ALERT_NOT_DELIVERY = "cart.alert.stopExpress";
        private static final String ALERT_CART_ALERT_NOT_SELL = "cart.alert.not.sell";
        private static final String ALERT_CART_ALERT_ROBBED_OF_LIGHT = "cart.alert.robbed.of.light";
        private static final String ALERT_CART_ALERT_SOLDOUTSOON = "cart.alert.soldOutSoon";
        private static final String ALERT_CODE_EXCHANGE_FAILURE = "cart.alert.exchange_failure";
        private static final String ALERT_CODE_FAILURE = "cart.alert.cat.failure";
        private static final String ALERT_CODE_LIMIT = "cart.alert.restriction";
        private static final String ALERT_CODE_OFFLINE = "cart.alert.soldOut";
        private static final String ALERT_CODE_STOCK_OUT = "cart.alert.stockout";
        private static final String ALERT_CODE_UNDER_STOCK = "cart.alert.understock";
        public static final int CHECKED_FALSE = 0;
        public static final int CHECKED_TRUE = 1;
        public static final String GO_PC_MIAO_SHAO_TAG = "MS";
        private static final long serialVersionUID = -1536743384005179583L;
        @JSONField(name = "alertCode")
        public String mAlertCode;
        @JSONField(name = "alertInfo")
        public String mAlertInfo;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "labelList")
        public ArrayList<CartResult.Label> mLabels;
        @JSONField(name = "name")
        public String mName;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "pack")
        public String mPack;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "ext")
        public CartResult.SeckillBean mSeckillBean;
        @JSONField(name = "valid")
        public boolean mValid;

        public boolean isBuyLimit() {
            return "cart.alert.restriction".equals(this.mAlertCode);
        }

        public boolean isConvertOverdue() {
            return "cart.alert.exchange_failure".equals(this.mAlertCode);
        }

        public boolean isExchangeFail() {
            return "cart.alert.exchange_failure".equals(this.mAlertCode);
        }

        public boolean isGift() {
            ArrayList localArrayList = this.mLabels;
            boolean bool2 = false;
            boolean bool1 = bool2;
            if (localArrayList != null) {
                bool1 = bool2;
                if (this.mLabels.size() > 0) {
                    bool1 = bool2;
                    if ("gift".equals((mLabels.get(0)).mLabelType)) {
                        bool1 = true;
                    }
                }
            }
            return bool1;
        }

        public boolean isLimitPurchase() {
            return "cart.alert.restriction".equals(this.mAlertCode);
        }

        public boolean isNotDelivery() {
            return "cart.alert.stopExpress".equals(this.mAlertCode);
        }

        public boolean isNotSell() {
            return "cart.alert.not.sell".equals(this.mAlertCode);
        }

        public boolean isOffline() {
            return "cart.alert.soldOut".equals(this.mAlertCode);
        }

        public boolean isSellOut() {
            return "cart.alert.robbed.of.light".equals(this.mAlertCode);
        }

        public boolean isSoldOutSoon() {
            return "cart.alert.soldOutSoon".equals(this.mAlertCode);
        }

        public boolean isStockOut() {
            return "cart.alert.stockout".equals(this.mAlertCode);
        }

        public boolean isUnderStock() {
            return "cart.alert.understock".equals(this.mAlertCode);
        }

        public boolean isValidSeckillActivity() {
            if ((!isOffline()) && (!isNotSell())) {
                if (isStockOut()) {
                    return false;
                }
                if (this.mSeckillBean != null) {
                    return this.mSeckillBean.mInsnapup;
                }
                return false;
            }
            return false;
        }
    }

    public static class ProductInfo extends CartResult.BaseProductsInfo implements Serializable {
        private static final long serialVersionUID = -1669880075278854833L;
    }

    public static class SeckillBean implements Serializable {
        private static final long serialVersionUID = 3028873987663566L;
        @JSONField(name = "insnapup")
        public boolean mInsnapup;
        @JSONField(name = "snapupRemainingTime")
        public long mSeckillTime;
        @JSONField(name = "stockRemanningTime")
        public long mSessionTime;
    }

    public static class SeckillTimeBean {
        public long mSeckillTime;
        public int mSeckillType;

        public boolean isValid() {
            return (this.mSeckillType != 0) && (this.mSeckillTime > 0L);
        }
    }

    public static class ShopInfo extends CartResult.BaseItemInfo implements Serializable {
        @JSONField(name = "changeBuyList")
        public ArrayList<CartResult.ChangeBuyList> mChangeBuyList;
        @JSONField(name = "exchangeCodeList")
        public ArrayList<CartResult.ExchangeProductInfo> mExchangeCodeList;
        @JSONField(name = "jiuxianSelf")
        public boolean mJiuxianSelf;
        @JSONField(name = "packageBuyList")
        public ArrayList<CartResult.PackageBuyInfo> mPackageBuyList;
        @JSONField(name = "productList")
        public ArrayList<CartResult.ProductInfo> mProductList;
        @JSONField(name = "sellerId")
        public int mSellerId;
        @JSONField(name = "shopCheckNum")
        public int mShopCheckNum;
        @JSONField(name = "shopName")
        public String mShopName;
        @JSONField(name = "shopProductNum")
        public int mShopProductNum;
        @JSONField(name = "shopUrl")
        public String mShopUrl;
        @JSONField(name = "snapUpProductList")
        public ArrayList<CartResult.SnapUpProductInfo> mSnapUpProductList;
        @JSONField(name = "youPickList")
        public ArrayList<CartResult.YouPickInfo> mYouPickList;
    }

    public static class SnapUpProductInfo extends CartResult.BaseProductsInfo implements Serializable {
        private static final int DELAY_TIME = 1000;
        public static final int SECKILL_TIME_TYPE = 2;
        public static final int SESSION_TIME_TYPE = 1;
        private static final long serialVersionUID = 751484549904310437L;
    }

    public static class YouPickInfo extends CartResult.BaseProductsInfo implements Serializable {
        private static final long serialVersionUID = -7797528192132088323L;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "promotionId")
        public int mPromotionId;
    }
}