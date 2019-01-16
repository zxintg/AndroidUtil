package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/19.
 */

public class CurrentProcedureBean implements Parcelable {
    private String booksuccessdate;
    private int code;
    int isopen;
    private String message;
    private String orderid;
    private OrderPackage orderpackage;
    private String orderpayforkey;
    private String shopid;
    private String status;

    protected CurrentProcedureBean(Parcel in) {
        booksuccessdate = in.readString();
        code = in.readInt();
        isopen = in.readInt();
        message = in.readString();
        orderid = in.readString();
        orderpackage = in.readParcelable(OrderPackage.class.getClassLoader());
        orderpayforkey = in.readString();
        shopid = in.readString();
        status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(booksuccessdate);
        dest.writeInt(code);
        dest.writeInt(isopen);
        dest.writeString(message);
        dest.writeString(orderid);
        dest.writeParcelable(orderpackage, flags);
        dest.writeString(orderpayforkey);
        dest.writeString(shopid);
        dest.writeString(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CurrentProcedureBean> CREATOR = new Creator<CurrentProcedureBean>() {
        @Override
        public CurrentProcedureBean createFromParcel(Parcel in) {
            return new CurrentProcedureBean(in);
        }

        @Override
        public CurrentProcedureBean[] newArray(int size) {
            return new CurrentProcedureBean[size];
        }
    };

    public String getBooksuccessdate() {
        return this.booksuccessdate;
    }

    public int getCode() {
        return this.code;
    }

    public int getIsopen() {
        return this.isopen;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public OrderPackage getOrderpackage() {
        return this.orderpackage;
    }

    public String getOrderpayforkey() {
        return this.orderpayforkey;
    }

    public String getShopid() {
        return this.shopid;
    }

    public String getStatus() {
        return this.status;
    }

    public void setBooksuccessdate(String paramString) {
        this.booksuccessdate = paramString;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setOrderid(String paramString) {
        this.orderid = paramString;
    }

    public void setOrderpackage(OrderPackage paramOrderPackage) {
        this.orderpackage = paramOrderPackage;
    }

    public void setOrderpayforkey(String paramString) {
        this.orderpayforkey = paramString;
    }

    public void setShopid(String paramString) {
        this.shopid = paramString;
    }

    public void setStatus(String paramString) {
        this.status = paramString;
    }

    public static class OrderPackage implements Parcelable {
        private String imgsrc;
        private String name;
        private String packagetype;
        private String price;

        protected OrderPackage(Parcel in) {
            imgsrc = in.readString();
            name = in.readString();
            packagetype = in.readString();
            price = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(imgsrc);
            dest.writeString(name);
            dest.writeString(packagetype);
            dest.writeString(price);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<OrderPackage> CREATOR = new Creator<OrderPackage>() {
            @Override
            public OrderPackage createFromParcel(Parcel in) {
                return new OrderPackage(in);
            }

            @Override
            public OrderPackage[] newArray(int size) {
                return new OrderPackage[size];
            }
        };

        public String getImgsrc() {
            return this.imgsrc;
        }

        public String getName() {
            return this.name;
        }

        public String getPackagetype() {
            return this.packagetype;
        }

        public String getPrice() {
            return this.price;
        }

        public void setImgsrc(String paramString) {
            this.imgsrc = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setPackagetype(String paramString) {
            this.packagetype = paramString;
        }

        public void setPrice(String paramString) {
            this.price = paramString;
        }
    }
}
