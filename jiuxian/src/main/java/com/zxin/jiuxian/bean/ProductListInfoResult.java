package com.zxin.jiuxian.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.util.List;

public class ProductListInfoResult {
    public String category;
    public String filterCacheKey;
    public List<ProductInfo> resultList;
    public int pageCount;
    public ShopInfo shopInfo;

    public static class ActList implements Parcelable {
        public String actColor;
        public String actName;

        protected ActList(Parcel in) {
            actColor = in.readString();
            actName = in.readString();
        }

        public static final Creator<ActList> CREATOR = new Creator<ActList>() {
            @Override
            public ActList createFromParcel(Parcel in) {
                return new ActList(in);
            }

            @Override
            public ActList[] newArray(int size) {
                return new ActList[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(actColor);
            dest.writeString(actName);
        }
    }

    public static class ProductInfo implements Parcelable {
        public List<ProductListInfoResult.ActList> activityList;
        public boolean alreadyCollection;
        public int belongType;
        public int categoryId;
        public boolean checkedState;
        public BigDecimal clubPrice;
        public String commentPercent;
        public int dimensionId;
        public String dimensionName;
        public int evaluationNumber;
        public String isOwn;
        public boolean supportHY;
        public double jxPrice;
        public String bigImage;
        public int proId;
        public String proName;
        public double proPrice;
        public String smallImage;
        public String prodcutType;
        public boolean selection;
        public String shopName;
        public double shopPrice;
        public ProductListInfoResult.StoreDetail storeDetail;
        public boolean supportVideo;
        public boolean whetherHasProduct;

        protected ProductInfo(Parcel in) {
            alreadyCollection = in.readByte() != 0;
            belongType = in.readInt();
            categoryId = in.readInt();
            checkedState = in.readByte() != 0;
            commentPercent = in.readString();
            dimensionId = in.readInt();
            dimensionName = in.readString();
            evaluationNumber = in.readInt();
            isOwn = in.readString();
            supportHY = in.readByte() != 0;
            jxPrice = in.readDouble();
            bigImage = in.readString();
            proId = in.readInt();
            proName = in.readString();
            proPrice = in.readDouble();
            smallImage = in.readString();
            prodcutType = in.readString();
            selection = in.readByte() != 0;
            shopName = in.readString();
            shopPrice = in.readDouble();
            supportVideo = in.readByte() != 0;
            whetherHasProduct = in.readByte() != 0;
        }

        public static final Creator<ProductInfo> CREATOR = new Creator<ProductInfo>() {
            @Override
            public ProductInfo createFromParcel(Parcel in) {
                return new ProductInfo(in);
            }

            @Override
            public ProductInfo[] newArray(int size) {
                return new ProductInfo[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte((byte) (alreadyCollection ? 1 : 0));
            dest.writeInt(belongType);
            dest.writeInt(categoryId);
            dest.writeByte((byte) (checkedState ? 1 : 0));
            dest.writeString(commentPercent);
            dest.writeInt(dimensionId);
            dest.writeString(dimensionName);
            dest.writeInt(evaluationNumber);
            dest.writeString(isOwn);
            dest.writeByte((byte) (supportHY ? 1 : 0));
            dest.writeDouble(jxPrice);
            dest.writeString(bigImage);
            dest.writeInt(proId);
            dest.writeString(proName);
            dest.writeDouble(proPrice);
            dest.writeString(smallImage);
            dest.writeString(prodcutType);
            dest.writeByte((byte) (selection ? 1 : 0));
            dest.writeString(shopName);
            dest.writeDouble(shopPrice);
            dest.writeByte((byte) (supportVideo ? 1 : 0));
            dest.writeByte((byte) (whetherHasProduct ? 1 : 0));
        }
    }

    public static class ShopInfo implements Parcelable{
        public int isOwn;
        public String shopImage_url;
        public String shopIntroduce;
        public String shopName;
        public String shopUrl;

        protected ShopInfo(Parcel in) {
            isOwn = in.readInt();
            shopImage_url = in.readString();
            shopIntroduce = in.readString();
            shopName = in.readString();
            shopUrl = in.readString();
        }

        public static final Creator<ShopInfo> CREATOR = new Creator<ShopInfo>() {
            @Override
            public ShopInfo createFromParcel(Parcel in) {
                return new ShopInfo(in);
            }

            @Override
            public ShopInfo[] newArray(int size) {
                return new ShopInfo[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(isOwn);
            dest.writeString(shopImage_url);
            dest.writeString(shopIntroduce);
            dest.writeString(shopName);
            dest.writeString(shopUrl);
        }
    }

    public static class StoreDetail implements Parcelable {
        public static final int CODE_BUY = 1;
        public static final int CODE_OFFLINE = 2;
        public int code;
        public String text;

        protected StoreDetail(Parcel in) {
            code = in.readInt();
            text = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(code);
            dest.writeString(text);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<StoreDetail> CREATOR = new Creator<StoreDetail>() {
            @Override
            public StoreDetail createFromParcel(Parcel in) {
                return new StoreDetail(in);
            }

            @Override
            public StoreDetail[] newArray(int size) {
                return new StoreDetail[size];
            }
        };
    }
}

