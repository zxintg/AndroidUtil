package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/29.
 */

public class GoodsInfo implements Parcelable{
    private String bl_id;
    private String buyer_id;
    private String cart_id;
    private String goods_id;
    private String goods_image;
    private String goods_name;
    private int goods_num;
    private boolean goods_pay_price;
    private double goods_price;
    private boolean isCheck;
    private String order_sn;
    private int position;
    private double price_total;
    private String store_id;
    private String store_name;

    protected GoodsInfo(Parcel in) {
        bl_id = in.readString();
        buyer_id = in.readString();
        cart_id = in.readString();
        goods_id = in.readString();
        goods_image = in.readString();
        goods_name = in.readString();
        goods_num = in.readInt();
        goods_pay_price = in.readByte() != 0;
        goods_price = in.readDouble();
        isCheck = in.readByte() != 0;
        order_sn = in.readString();
        position = in.readInt();
        price_total = in.readDouble();
        store_id = in.readString();
        store_name = in.readString();
    }

    public static final Creator<GoodsInfo> CREATOR = new Creator<GoodsInfo>() {
        @Override
        public GoodsInfo createFromParcel(Parcel in) {
            return new GoodsInfo(in);
        }

        @Override
        public GoodsInfo[] newArray(int size) {
            return new GoodsInfo[size];
        }
    };

    public String getBl_id() {
        return this.bl_id;
    }

    public String getBuyer_id() {
        return this.buyer_id;
    }

    public String getCart_id() {
        return this.cart_id;
    }

    public String getGoods_id() {
        return this.goods_id;
    }

    public String getGoods_image() {
        return this.goods_image;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public int getGoods_num() {
        return this.goods_num;
    }

    public double getGoods_price() {
        return this.goods_price;
    }

    public String getOrder_sn() {
        if (this.order_sn == null) {
            this.order_sn = "";
        }
        return this.order_sn;
    }

    public int getPosition() {
        return this.position;
    }

    public double getPrice_total() {
        return this.price_total;
    }

    public String getStore_id() {
        return this.store_id;
    }

    public String getStore_name() {
        return this.store_name;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isGoods_pay_price() {
        return this.goods_pay_price;
    }

    public void setBl_id(String paramString) {
        this.bl_id = paramString;
    }

    public void setBuyer_id(String paramString) {
        this.buyer_id = paramString;
    }

    public void setCart_id(String paramString) {
        this.cart_id = paramString;
    }

    public void setCheck(boolean paramBoolean) {
        this.isCheck = paramBoolean;
    }

    public void setGoods_id(String paramString) {
        this.goods_id = paramString;
    }

    public void setGoods_image(String paramString) {
        this.goods_image = paramString;
    }

    public void setGoods_name(String paramString) {
        this.goods_name = paramString;
    }

    public void setGoods_num(int paramInt) {
        this.goods_num = paramInt;
    }

    public void setGoods_pay_price(boolean paramBoolean) {
        this.goods_pay_price = paramBoolean;
    }

    public void setGoods_price(double paramDouble) {
        this.goods_price = paramDouble;
    }

    public void setOrder_sn(String paramString) {
        this.order_sn = paramString;
    }

    public void setPosition(int paramInt) {
        this.position = paramInt;
    }

    public void setPrice_total(double paramDouble) {
        this.price_total = paramDouble;
    }

    public void setStore_id(String paramString) {
        this.store_id = paramString;
    }

    public void setStore_name(String paramString) {
        this.store_name = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bl_id);
        dest.writeString(buyer_id);
        dest.writeString(cart_id);
        dest.writeString(goods_id);
        dest.writeString(goods_image);
        dest.writeString(goods_name);
        dest.writeInt(goods_num);
        dest.writeByte((byte) (goods_pay_price ? 1 : 0));
        dest.writeDouble(goods_price);
        dest.writeByte((byte) (isCheck ? 1 : 0));
        dest.writeString(order_sn);
        dest.writeInt(position);
        dest.writeDouble(price_total);
        dest.writeString(store_id);
        dest.writeString(store_name);
    }
}
