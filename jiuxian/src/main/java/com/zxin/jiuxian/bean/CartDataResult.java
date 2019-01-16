package com.zxin.jiuxian.bean;


import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.zxin.jiuxian.R;
import com.zxin.zxinlib.util.UiUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartDataResult implements Serializable {
    public static final String CHECKED_FALSE = "0";
    public static final String CHECKED_TRUE = "1";
    public static final String PRODUCT_GROUP_PREFIX = "group";
    public static final String RECOMMOND_TYPE_COU_DAN = "COU_DAN";
    public static final String RECOMMOND_TYPE_DEFAULT = "DEFAULT";
    private static final long serialVersionUID = 123234511661L;
    @JSONField(name = "checkAll")
    public boolean mCheckAll;
    @JSONField(name = "checkNum")
    public int mCheckNum;
    @JSONField(name = "discountPrice")
    public double mDiscountPrice;
    @JSONField(name = "realPrice")
    public double mRealPrice;
    @JSONField(name = "recommendType")
    public String mRecommendType;
    @JSONField(name = "shopItems")
    public List<ShopItemsBean> mShopItems;
    @JSONField(name = "stopExpressTitle")
    public String mStopExpressTitle;
    @JSONField(name = "title")
    public String mTitle;
    @JSONField(name = "totalNum")
    public int mTotalNum;
    @JSONField(name = "totalPrice")
    public double mTotalPrice;

    public static class BaseItem implements Serializable {
        public static final String EXCHANGE_GOODS_TYPE = "exchange_goods_type";
        public static final String MARKUP_PURCHASE_TYPE = "markup_purchase";
        public static final String NORMAL_TYPE = "normal";
        public static final String SECKILL_GOODS_TYPE = "seckill_goods_type";
        public static final String SHOP_INFO_TYPE = "shopInfo";
        public static final String TAOZHUANG_TYPE = "taozhuang";
        @JSONField(name = "check")
        public String mCheck;
        public boolean mEditCheckedStatus;
        public int mLineState;
        @JSONField(name = "checkAll")
        public boolean mShopCheckAll;
        @JSONField(name = "shopId")
        public String mShopId;
        public String mType;
    }

    public static class Product implements Serializable {
        private static final long serialVersionUID = -1536743384005179583L;
        @JSONField(name = "alert")
        public CartDataResult.ShopItemsBean.AlertBean mAlert;
        @JSONField(name = "forbidCoupon")
        public boolean mForbidCoupon;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "originalPrice")
        public double mOriginalPrice;
        @JSONField(name = "pack")
        public String mPack;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "selection")
        public boolean mSelection;

        public static String getGiftAlertTitle(List<Product> paramList) {
            if ((paramList != null) && (!paramList.isEmpty())) {
                List<String> list = new ArrayList();
                for (Product product : paramList){
                    if ((product != null) && (!product.isAlertEmpty()) && (!list.contains((product).mAlert.mAlertInfo))) {
                        list.add((product).mAlert.mAlertInfo);
                    }
                }
                StringBuffer buffer = new StringBuffer();
                for (int i=0;i<list.size();i++){
                    String str = list.get(i);
                    if (i==list.size()-1){
                        buffer.append(str);
                    }else{
                        StringBuilder newBuilder = new StringBuilder();
                        newBuilder.append(str);
                        newBuilder.append(UiUtils.getString(R.string.cart_or_character));
                        buffer.append(newBuilder.toString());
                    }
                }
                return buffer.toString();
            }
            return "";
        }

        public static String getProductIds(List<Product> paramList) {
            if ((paramList != null) && (!paramList.isEmpty())) {
                StringBuffer buffer = new StringBuffer();
                for (int i=0;i<paramList.size();i++){
                    if (i == paramList.size() - 1) {
                        buffer.append(paramList.get(i).mProductId);
                    } else {
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append( paramList.get(i).mProductId);
                        localStringBuilder.append(",");
                        buffer.append(localStringBuilder.toString());
                    }
                }
                return buffer.toString();
            }
            return "";
        }

        public static boolean isEnableCheck(Product paramProduct) {
            return (paramProduct == null) || ((!paramProduct.isOffline()) && (!paramProduct.isNotSell()));
        }

        public String getAlertInfo() {
            if (isAlertEmpty()) {
                return "";
            }
            return this.mAlert.mAlertInfo;
        }

        public boolean isAlertEmpty() {
            return this.mAlert == null;
        }

        public boolean isBuyLimit() {
            return (!isAlertEmpty()) && (this.mAlert.isBuyLimit());
        }

        public boolean isConvertOverdue() {
            return (!isAlertEmpty()) && (this.mAlert.isConvertOverdue());
        }

        public boolean isLimitPurchase() {
            return (!isAlertEmpty()) && (this.mAlert.isLimitPurchase());
        }

        public boolean isNotDelivery() {
            return (!isAlertEmpty()) && (this.mAlert.isNotDelivery());
        }

        public boolean isNotSell() {
            return (!isAlertEmpty()) && (this.mAlert.isNotSell());
        }

        public boolean isOffline() {
            return (!isAlertEmpty()) && (this.mAlert.isOffline());
        }

        public boolean isSellOut() {
            return (!isAlertEmpty()) && (this.mAlert.isSellOut());
        }

        public boolean isSoldOutSoon() {
            return (!isAlertEmpty()) && (this.mAlert.isSoldOutSoon());
        }

        public boolean isStockOut() {
            return (!isAlertEmpty()) && (this.mAlert.isStockOut());
        }

        public boolean isUnderStock() {
            return (!isAlertEmpty()) && (this.mAlert.isUnderStock());
        }
    }

    public static class ProductItemListBean
            extends CartDataResult.Product {
        public boolean isLargess;
    }

    public static class ShopItemsBean extends CartDataResult.BaseItem {
        @JSONField(name = "jiuxianSelf")
        public boolean mJiuxianSelf;
        @JSONField(name = "shopImgUrl")
        public String mShopImgUrl;
        @JSONField(name = "shopName")
        public String mShopName;
        @JSONField(name = "shopUrl")
        public String mShopUrl;
        @JSONField(name = "skus")
        public List<CartDataResult.SkusBean> mSkus;
        @JSONField(name = "pickCoupon")
        public boolean pickCoupon;

        public String getNotForbidCouponProductId() {
            StringBuffer localStringBuffer = new StringBuffer();
            if ((this.mSkus != null) && (!this.mSkus.isEmpty())) {
                for (CartDataResult.SkusBean skusBean : mSkus){
                    if (skusBean != null && !skusBean.mProductItemList.isEmpty()) {
                        for (CartDataResult.ProductItemListBean productItem : skusBean.mGiftList){
                            if ((productItem != null) && (productItem.mProductId > 0) && (!productItem.mForbidCoupon)) {
                                StringBuilder localStringBuilder = new StringBuilder();
                                localStringBuilder.append(productItem.mProductId);
                                localStringBuilder.append(",");
                                localStringBuffer.append(localStringBuilder.toString());
                            }
                        }
                    }
                }
                int i = localStringBuffer.lastIndexOf(",");
                if (i >= 0) {
                    localStringBuffer.deleteCharAt(i);
                }
            }
            return localStringBuffer.toString();
        }

        public static class AlertBean {
            public static final String ALERT_CART_ALERSOLD_OUT_SOON = "SOLD_OUT_SOON";
            public static final String ALERT_CART_EXPRESS_STOP = "EXPRESS_STOP";
            public static final String ALERT_CODE_ACT_SOLD_OUT = "ACT_SOLD_OUT";
            public static final String ALERT_CODE_BEYOND_ACT_INVENTORY = "BEYOND_ACT_INVENTORY";
            public static final String ALERT_CODE_BEYOND_INVENTORY = "BEYOND_INVENTORY";
            public static final String ALERT_CODE_EXCHANGE_TIME_OUT = "EXCHANGE_TIME_OUT";
            public static final String ALERT_CODE_NOT_ON_SALE = "NOT_ON_SALE";
            public static final String ALERT_CODE_NO_SALE = "NO_SALE";
            public static final String ALERT_CODE_OUT_OF_STOCK = "OUT_OF_STOCK";
            @JSONField(name = "alertCode")
            public String mAlertCode;
            @JSONField(name = "alertInfo")
            public String mAlertInfo;
            @JSONField(name = "canBeSubmit")
            public boolean mCanBeSubmit;

            public boolean isBuyLimit() {
                return "BEYOND_ACT_INVENTORY".equals(this.mAlertCode);
            }

            public boolean isConvertOverdue() {
                return "EXCHANGE_TIME_OUT".equals(this.mAlertCode);
            }

            public boolean isLimitPurchase() {
                return "BEYOND_ACT_INVENTORY".equals(this.mAlertCode);
            }

            public boolean isNotDelivery() {
                return "EXPRESS_STOP".equals(this.mAlertCode);
            }

            public boolean isNotSell() {
                return "NO_SALE".equals(this.mAlertCode);
            }

            public boolean isOffline() {
                return "NOT_ON_SALE".equals(this.mAlertCode);
            }

            public boolean isSellOut() {
                return "ACT_SOLD_OUT".equals(this.mAlertCode);
            }

            public boolean isSoldOutSoon() {
                return "SOLD_OUT_SOON".equals(this.mAlertCode);
            }

            public boolean isStockOut() {
                return "OUT_OF_STOCK".equals(this.mAlertCode);
            }

            public boolean isUnderStock() {
                return "BEYOND_INVENTORY".equals(this.mAlertCode);
            }
        }

        public static class LabelsBean implements Serializable {
            public static final String LABEL_CHEAPER_THAN_JOIN = "CHEAPER_THAN_JOIN";
            public static final String LABEL_COUNP = "COUNP";
            public static final String LABEL_EXCHANGE = "EXCHANGE";
            public static final String LABEL_GOLD_COIN = "GOLD_COIN";
            public static final String LABEL_JIAJIAGOU = "CHANGE_BUY";
            public static final String LABEL_MANJIAN = "REDUCE_PRICE";
            public static final String LABEL_MANZENG = "GIFT";
            public static final String LABEL_PACK_BUY = "PACK_BUY";
            public static final String LABEL_YOU_PICK = "YOU_PICK";
            public static final String LABEL_ZHIJIANG = "DRICE_PRICE";
            public static final String LOCATION_BODY = "BODY";
            public static final String LOCATION_HEAD = "HEAD";
            public static final String LOCATION_ROOT = "FOOT";
            private static final long serialVersionUID = 30276543239566L;
            @JSONField(name = "color")
            public String mColor;
            @JSONField(name = "join")
            public boolean mJoin;
            @JSONField(name = "location")
            public String mLocation;
            @JSONField(name = "name")
            public String mName;
            @JSONField(name = "nameHidden")
            public boolean mNameHidden;
            @JSONField(name = "promoId")
            public int mPromoId;
            @JSONField(name = "satisfy")
            public boolean mSatisfy;
            @JSONField(name = "title")
            public String mTitle;
            @JSONField(name = "titleHidden")
            public boolean mTitleHidden;
            @JSONField(name = "type")
            public String mType;

            public boolean isDownPriceType() {
                return "CHEAPER_THAN_JOIN".equals(this.mType);
            }

            public boolean isValidName() {
                return (!this.mNameHidden) && (!TextUtils.isEmpty(this.mName));
            }

            public boolean isValidTitle() {
                return (!this.mTitleHidden) && (!TextUtils.isEmpty(this.mTitle));
            }
        }
    }

    public static class SkusBean extends CartDataResult.BaseItem {
        public static final String CHECKBOX_STATE_CHECK = "CHECK";
        public static final String CHECKBOX_STATE_HIDDEN = "HIDDEN";
        public static final String CHECKBOX_STATE_LOSE_EFFICACY = "LOSE_EFFICACY";
        public static final String CHECKBOX_STATE_UN_CHECK = "UN_CHECK";
        public String mBtnName;
        public String mBtnType;
        @JSONField(name = "club")
        public boolean mClub;
        @JSONField(name = "discountPrice")
        public double mDiscountPrice;
        @JSONField(name = "exchangeSKU")
        public boolean mExchangeSKU;
        @JSONField(name = "fatherId")
        public String mFatherId;
        @JSONField(name = "giftList")
        public List<CartDataResult.ProductItemListBean> mGiftList;
        @JSONField(name = "id")
        public String mId;
        @JSONField(name = "labels")
        public List<CartDataResult.ShopItemsBean.LabelsBean> mLabels;
        @JSONField(name = "miaosha")
        public boolean mMiaosha;
        @JSONField(name = "num")
        public int mNum;
        @JSONField(name = "price")
        public double mPrice;
        @JSONField(name = "productItemList")
        public List<CartDataResult.ProductItemListBean> mProductItemList;

        public boolean equalsPromotId(SkusBean paramSkusBean) {
            boolean bool2 = false;
            if (paramSkusBean == null) {
                return false;
            }
            int i = getPromotId();
            boolean bool1 = bool2;
            if (i > 0) {
                bool1 = bool2;
                if (i == paramSkusBean.getPromotId()) {
                    bool1 = true;
                }
            }
            return bool1;
        }

        public int getLimitNumber() {
            int m = this.mNum;
            Object localObject = this.mProductItemList;
            int i = -1;
            int k = i;
            if (localObject != null) {
                k = i;
                if (!this.mProductItemList.isEmpty()) {
                    int j = 0;
                    for (; ; ) {
                        k = i;
                        if (j >= this.mProductItemList.size()) {
                            break;
                        }
                        localObject = ((CartDataResult.ProductItemListBean) this.mProductItemList.get(j)).mAlert;
                        k = i;
                        if (localObject != null) {
                            if (!((CartDataResult.ShopItemsBean.AlertBean) localObject).isLimitPurchase()) {
                                k = i;
                                if (!((CartDataResult.ShopItemsBean.AlertBean) localObject).isUnderStock()) {
                                }
                            } else {
                                k = m;
                            }
                        }
                        j += 1;
                        i = k;
                    }
                }
            }
            return k;
        }

        public String getProductId() {
            StringBuffer localStringBuffer = new StringBuffer();
            if ((this.mProductItemList != null) && (!this.mProductItemList.isEmpty())) {
                Iterator localIterator = this.mProductItemList.iterator();
                for (CartDataResult.ProductItemListBean mProduct:mProductItemList){
                    if ((mProduct != null) && (mProduct.mProductId > 0)) {
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append(mProduct.mProductId);
                        localStringBuilder.append(",");
                        localStringBuffer.append(localStringBuilder.toString());
                    }
                }
                int i = localStringBuffer.lastIndexOf(",");
                if (i >= 0) {
                    localStringBuffer.deleteCharAt(i);
                }
            }
            return localStringBuffer.toString();
        }

        public int getPromotId() {
            if ((this.mLabels != null) && (!this.mLabels.isEmpty())) {
                for (CartDataResult.ShopItemsBean.LabelsBean label : this.mLabels){
                    if (("HEAD".equals(label.mLocation)) && (label.mPromoId > 0)) {
                        return label.mPromoId;
                    }
                }
            }
            return -1;
        }

        public void handleTaoZhuangData() {
            if ((this.mLabels != null) && (!this.mLabels.isEmpty())) {
                for (CartDataResult.ShopItemsBean.LabelsBean localLabelsBean :mLabels){
                    if ((!TextUtils.isEmpty(localLabelsBean.mType)) && (localLabelsBean.mType.equals("YOU_PICK"))) {
                        this.mBtnName = UiUtils.getString(R.string.cart_btn_dabaojia_name);
                        this.mBtnType = "YOU_PICK";
                    } else if ((!TextUtils.isEmpty(localLabelsBean.mType)) && (localLabelsBean.mType.equals("PACK_BUY"))) {
                        this.mBtnName = UiUtils.getString(R.string.cart_btn_taozhuangjia_name);
                        this.mBtnType = "PACK_BUY";
                    }
                }
                if (TextUtils.isEmpty(this.mBtnName)) {
                    this.mBtnName = UiUtils.getString(R.string.cart_btn_jiage_name);
                }
            }
        }

        public boolean isCanRemoveCollection() {
            return (!"LOSE_EFFICACY".equals(this.mCheck)) && (!"taozhuang".equals(this.mType)) && (!"markup_purchase".equals(this.mType));
        }

        public boolean isLoseEfficacyState() {
            return "LOSE_EFFICACY".equals(this.mCheck);
        }

        public boolean isTaoZhuangType() {
            return "taozhuang".equals(this.mType);
        }
    }
}
