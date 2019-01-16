package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class CDkeyBean1 implements Parcelable{
    private String code;
    private String message;
    private List<MyorderBean> myorder;

    protected CDkeyBean1(Parcel in) {
        code = in.readString();
        message = in.readString();
    }

    public static final Creator<CDkeyBean1> CREATOR = new Creator<CDkeyBean1>() {
        @Override
        public CDkeyBean1 createFromParcel(Parcel in) {
            return new CDkeyBean1(in);
        }

        @Override
        public CDkeyBean1[] newArray(int size) {
            return new CDkeyBean1[size];
        }
    };

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public List<MyorderBean> getMyorder() {
        return this.myorder;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setMyorder(List<MyorderBean> paramList) {
        this.myorder = paramList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(message);
    }

    public static class MyorderBean implements Parcelable{
        private String add_time;
        private String buyer_name;
        private String buyer_phone;
        private String goods_image;
        private String goods_name;
        private String goods_num;
        private String goods_price;
        private String order_amount;
        private String order_id;
        private String order_sn;
        private String pay_price;
        private String payment_time;
        private String rec_id;
        private String store_avatar;
        private String store_id;
        private String store_name;
        private String vr_code;
        private String vr_indate;
        private String vr_state;
        private Object vr_usetime;

        protected MyorderBean(Parcel in) {
            add_time = in.readString();
            buyer_name = in.readString();
            buyer_phone = in.readString();
            goods_image = in.readString();
            goods_name = in.readString();
            goods_num = in.readString();
            goods_price = in.readString();
            order_amount = in.readString();
            order_id = in.readString();
            order_sn = in.readString();
            pay_price = in.readString();
            payment_time = in.readString();
            rec_id = in.readString();
            store_avatar = in.readString();
            store_id = in.readString();
            store_name = in.readString();
            vr_code = in.readString();
            vr_indate = in.readString();
            vr_state = in.readString();
        }

        public static final Creator<MyorderBean> CREATOR = new Creator<MyorderBean>() {
            @Override
            public MyorderBean createFromParcel(Parcel in) {
                return new MyorderBean(in);
            }

            @Override
            public MyorderBean[] newArray(int size) {
                return new MyorderBean[size];
            }
        };

        public String getAdd_time() {
            return this.add_time;
        }

        public String getBuyer_name() {
            return this.buyer_name;
        }

        public String getBuyer_phone() {
            return this.buyer_phone;
        }

        public String getGoods_image() {
            return this.goods_image;
        }

        public String getGoods_name() {
            return this.goods_name;
        }

        public String getGoods_num() {
            return this.goods_num;
        }

        public String getGoods_price() {
            return this.goods_price;
        }

        public String getOrder_amount() {
            return this.order_amount;
        }

        public String getOrder_id() {
            return this.order_id;
        }

        public String getOrder_sn() {
            return this.order_sn;
        }

        public String getPay_price() {
            return this.pay_price;
        }

        public String getPayment_time() {
            return this.payment_time;
        }

        public String getRec_id() {
            return this.rec_id;
        }

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public String getVr_code() {
            return this.vr_code;
        }

        public String getVr_indate() {
            return this.vr_indate;
        }

        public String getVr_state() {
            return this.vr_state;
        }

        public Object getVr_usetime() {
            return this.vr_usetime;
        }

        public void setAdd_time(String paramString) {
            this.add_time = paramString;
        }

        public void setBuyer_name(String paramString) {
            this.buyer_name = paramString;
        }

        public void setBuyer_phone(String paramString) {
            this.buyer_phone = paramString;
        }

        public void setGoods_image(String paramString) {
            this.goods_image = paramString;
        }

        public void setGoods_name(String paramString) {
            this.goods_name = paramString;
        }

        public void setGoods_num(String paramString) {
            this.goods_num = paramString;
        }

        public void setGoods_price(String paramString) {
            this.goods_price = paramString;
        }

        public void setOrder_amount(String paramString) {
            this.order_amount = paramString;
        }

        public void setOrder_id(String paramString) {
            this.order_id = paramString;
        }

        public void setOrder_sn(String paramString) {
            this.order_sn = paramString;
        }

        public void setPay_price(String paramString) {
            this.pay_price = paramString;
        }

        public void setPayment_time(String paramString) {
            this.payment_time = paramString;
        }

        public void setRec_id(String paramString) {
            this.rec_id = paramString;
        }

        public void setStore_avatar(String paramString) {
            this.store_avatar = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        public void setVr_code(String paramString) {
            this.vr_code = paramString;
        }

        public void setVr_indate(String paramString) {
            this.vr_indate = paramString;
        }

        public void setVr_state(String paramString) {
            this.vr_state = paramString;
        }

        public void setVr_usetime(Object paramObject) {
            this.vr_usetime = paramObject;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(add_time);
            dest.writeString(buyer_name);
            dest.writeString(buyer_phone);
            dest.writeString(goods_image);
            dest.writeString(goods_name);
            dest.writeString(goods_num);
            dest.writeString(goods_price);
            dest.writeString(order_amount);
            dest.writeString(order_id);
            dest.writeString(order_sn);
            dest.writeString(pay_price);
            dest.writeString(payment_time);
            dest.writeString(rec_id);
            dest.writeString(store_avatar);
            dest.writeString(store_id);
            dest.writeString(store_name);
            dest.writeString(vr_code);
            dest.writeString(vr_indate);
            dest.writeString(vr_state);
        }
    }
}
