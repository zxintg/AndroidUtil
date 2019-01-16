package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class StoreInfo implements Parcelable{
    private List<GoodsInfo> cartlist;
    private String finnshed_time;
    private String goods_amount;
    private String id;
    protected boolean isChoosed;
    private boolean isEdtor;
    private String order_amount;
    private String order_id;
    private String order_sn;
    private String order_state;
    private String order_state1;
    private String payment_code;
    private String price_total;
    private String shipping_time;
    private String store_avatar;
    private String store_id;
    private String store_name;
    private VoucherBean voucher;

    protected StoreInfo(Parcel in) {
        cartlist = in.createTypedArrayList(GoodsInfo.CREATOR);
        finnshed_time = in.readString();
        goods_amount = in.readString();
        id = in.readString();
        isChoosed = in.readByte() != 0;
        isEdtor = in.readByte() != 0;
        order_amount = in.readString();
        order_id = in.readString();
        order_sn = in.readString();
        order_state = in.readString();
        order_state1 = in.readString();
        payment_code = in.readString();
        price_total = in.readString();
        shipping_time = in.readString();
        store_avatar = in.readString();
        store_id = in.readString();
        store_name = in.readString();
        voucher = in.readParcelable(VoucherBean.class.getClassLoader());
    }

    public static final Creator<StoreInfo> CREATOR = new Creator<StoreInfo>() {
        @Override
        public StoreInfo createFromParcel(Parcel in) {
            return new StoreInfo(in);
        }

        @Override
        public StoreInfo[] newArray(int size) {
            return new StoreInfo[size];
        }
    };

    public List<GoodsInfo> getCartlist() {
        return this.cartlist;
    }

    public String getFinnshed_time() {
        return this.finnshed_time;
    }

    public String getGoods_amount() {
        return this.goods_amount;
    }

    public String getId() {
        return this.id;
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

    public String getOrder_state() {
        return this.order_state;
    }

    public String getOrder_state1() {
        return this.order_state1;
    }

    public String getPayment_code() {
        return this.payment_code;
    }

    public String getPrice_total() {
        return this.price_total;
    }

    public String getShipping_time() {
        return this.shipping_time;
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

    public VoucherBean getVoucher() {
        return this.voucher;
    }

    public boolean isChoosed() {
        return this.isChoosed;
    }

    public boolean isEdtor() {
        return this.isEdtor;
    }

    public void setCartlist(List<GoodsInfo> paramList) {
        this.cartlist = paramList;
    }

    public void setChoosed(boolean paramBoolean) {
        this.isChoosed = paramBoolean;
    }

    public void setEdtor(boolean paramBoolean) {
        this.isEdtor = paramBoolean;
    }

    public void setFinnshed_time(String paramString) {
        this.finnshed_time = paramString;
    }

    public void setGoods_amount(String paramString) {
        this.goods_amount = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
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

    public void setOrder_state(String paramString) {
        this.order_state = paramString;
    }

    public void setOrder_state1(String paramString) {
        this.order_state1 = paramString;
    }

    public void setPayment_code(String paramString) {
        this.payment_code = paramString;
    }

    public void setPrice_total(String paramString) {
        this.price_total = paramString;
    }

    public void setShipping_time(String paramString) {
        this.shipping_time = paramString;
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

    public void setVoucher(VoucherBean paramVoucherBean) {
        this.voucher = paramVoucherBean;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cartlist);
        dest.writeString(finnshed_time);
        dest.writeString(goods_amount);
        dest.writeString(id);
        dest.writeByte((byte) (isChoosed ? 1 : 0));
        dest.writeByte((byte) (isEdtor ? 1 : 0));
        dest.writeString(order_amount);
        dest.writeString(order_id);
        dest.writeString(order_sn);
        dest.writeString(order_state);
        dest.writeString(order_state1);
        dest.writeString(payment_code);
        dest.writeString(price_total);
        dest.writeString(shipping_time);
        dest.writeString(store_avatar);
        dest.writeString(store_id);
        dest.writeString(store_name);
        dest.writeParcelable(voucher, flags);
    }
}
