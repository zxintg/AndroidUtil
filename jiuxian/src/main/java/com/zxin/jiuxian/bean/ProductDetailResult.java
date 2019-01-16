package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import java.util.List;

public class ProductDetailResult {
    public static final String PROMOTION_BUYMORECONCESSION = "A_BUYMORECONCESSION";
    public static final String PROMOTION_GROUPPURCHASE = "A_GROUPPURCHASE";
    public static final String PROMOTION_MEMBERGRADEPRICE = "A_MEMBERGRADEPRICE";
    public static final String PROMOTION_STRAIGHTDOWN = "A_STRAIGHTDOWN";
    public String imageUrl;
    public boolean clubUser;
    public int jumpProId;
    public boolean alreadyCollection;
    public int belongType;
    public String brandRegionName;
    public int categoryId;
    public int brandId;
    public String brandImage;
    public String brandCulture;
    public String brandName;
    public List<BuyMorePrice> buyMoreExclusivePrice;
    public double cheaperThanPC;
    public String city;
    public String classAPromotionType;
    public String clubURL;
    public BigDecimal clubPrice;
    public String clubTip;
    public int commentCount;
    public String commentPercent;
    public List<String> couponNameList;
    public CurrentPromotion promotionTitle;
    public DeliveryInfo expressOutage;
    public String district;
    public List<EvaItem> evaluateList;
    public String exclusiveTitle;
    public int giftGoldCoinNumber;
    public boolean hasMiaosha;
    public int mHashCode;
    public List<ImageItem> imageList;
    public boolean isJxProprietary = true;
    public boolean isNoSale;
    public int isOnSale;
    public boolean isSelection;
    public JiuZhangSource mJiuZhangSource;
    public List<LargessItem> largesses;
    public int purchaseNubs;
    public double mobileExclusivePrice;
    public String mPageOzprm;
    public int proId;
    public ProMiaoShaInfo proMiaoShaInfo;
    public String proName;
    public double proPrice;
    public String productForgeryDiagramUrl;
    public String productIntroductUrl;
    public String productShareUrl;
    public List<PromotionItem> promotions;
    public String province;
    public String[] reminder;
    public String proSn;
    public String sellerId;
    public String receiveGroupId;
    public List<ServiceItem> serviceDescriptionUrl;
    public String shopDeliveryFeeInfo;
    public String shopIntro;
    public String shopLogo;
    public String shopName;
    public String shopPhoneNumber;
    public String shopUrl;
    public boolean showProPrice;
    public StoreDetail storeDetail;
    public String subTitle;
    public long surplusTime;
    public boolean whetherHasProduct;
    public boolean showVideoIcon;
    public String videoUrl;
    public ZqInfoBo zqInfoBo;

    public static class BuyMorePrice {
        public double signlePrice;
        public int suitNubs;
    }

    public static class CurrentPromotion {
        public static final int MIAO_PAI_TYPE = 1;
        public static final int SJZX_TYPE = 2;
        public static final int TYPE_SECKILL = 3;
        public String promotionTagColor;
        public String promotionTypeName;
        public int promotionType;
    }

    public static class DeliveryInfo {
        public static final int CODE_EXPRESS_PAUSE = 2;
        public static final int CODE_OPERATE_PAUSE = 1;
        public int code;
        public String text;
    }

    public static class EvaItem {
        public String content;
        public String createTime;
        public int evaId;
        public List<ProductDetailResult.ImageItem> imageList;
        public int star;
        public String userName;
    }

    public static class ImageItem {
        public String bigImage;
        public String smallImage;
    }

    public static class LargessItem {
        public int number;
        public int productId;
        public String productImage;
        public String productName;
    }

    public static class ProMiaoShaInfo {
        public String advWords;
        public String linkUrl;
        public String linkWord;
        public Double miaoShaPrice;
        public int promotionId;
        public ProductDetailResult.CurrentPromotion promotionTitle;
        public ProductDetailResult.StoreDetail storeDetail;
        public long surplusTime;
    }

    public static class PromotionItem {
        public int pageType;
        public int promotionId;
        public String promotionName;
        public String promotionTagColor;
        public int promotionType;
        public String promotionTypeName;
    }

    public static class ServiceItem {
        public String adTitle;
        public String adImg;
        public String advertisingName;
    }

    public static class StoreDetail {
        public static final int CODE_BUY = 1;
        public static final int CODE_LOCK = 4;
        public static final int CODE_MIAOSHA = 7;
        public int code;
        public String text;
    }

    public static class ZqInfoBo {
        public String zqInfo;
        public String zqLink;
    }
}
