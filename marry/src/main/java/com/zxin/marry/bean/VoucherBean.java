package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/29.
 */

public class VoucherBean implements Parcelable{
    private boolean isCheck;
    private String voucher_active_date;
    private String voucher_code;
    private String voucher_desc;
    private String voucher_end_date;
    private String voucher_id;
    private String voucher_limit;
    private String voucher_order_id;
    private String voucher_owner_id;
    private String voucher_owner_name;
    private String voucher_price;
    private String voucher_start_date;
    private String voucher_state;
    private String voucher_state1;
    private String voucher_store_id;
    private String voucher_t_customimg;
    private String voucher_t_id;
    private String voucher_t_store_id;
    private String voucher_t_storename;
    private String voucher_title;
    private String voucher_type;

    protected VoucherBean(Parcel in) {
        isCheck = in.readByte() != 0;
        voucher_active_date = in.readString();
        voucher_code = in.readString();
        voucher_desc = in.readString();
        voucher_end_date = in.readString();
        voucher_id = in.readString();
        voucher_limit = in.readString();
        voucher_order_id = in.readString();
        voucher_owner_id = in.readString();
        voucher_owner_name = in.readString();
        voucher_price = in.readString();
        voucher_start_date = in.readString();
        voucher_state = in.readString();
        voucher_state1 = in.readString();
        voucher_store_id = in.readString();
        voucher_t_customimg = in.readString();
        voucher_t_id = in.readString();
        voucher_t_store_id = in.readString();
        voucher_t_storename = in.readString();
        voucher_title = in.readString();
        voucher_type = in.readString();
    }

    public static final Creator<VoucherBean> CREATOR = new Creator<VoucherBean>() {
        @Override
        public VoucherBean createFromParcel(Parcel in) {
            return new VoucherBean(in);
        }

        @Override
        public VoucherBean[] newArray(int size) {
            return new VoucherBean[size];
        }
    };

    public String getVoucher_active_date() {
        return this.voucher_active_date;
    }

    public String getVoucher_code() {
        return this.voucher_code;
    }

    public String getVoucher_desc() {
        return this.voucher_desc;
    }

    public String getVoucher_end_date() {
        return this.voucher_end_date;
    }

    public String getVoucher_id() {
        return this.voucher_id;
    }

    public String getVoucher_limit() {
        return this.voucher_limit;
    }

    public String getVoucher_order_id() {
        return this.voucher_order_id;
    }

    public String getVoucher_owner_id() {
        return this.voucher_owner_id;
    }

    public String getVoucher_owner_name() {
        return this.voucher_owner_name;
    }

    public String getVoucher_price() {
        return this.voucher_price;
    }

    public String getVoucher_start_date() {
        return this.voucher_start_date;
    }

    public String getVoucher_state() {
        return this.voucher_state;
    }

    public String getVoucher_state1() {
        return this.voucher_state1;
    }

    public String getVoucher_store_id() {
        return this.voucher_store_id;
    }

    public String getVoucher_t_customimg() {
        return this.voucher_t_customimg;
    }

    public String getVoucher_t_id() {
        return this.voucher_t_id;
    }

    public String getVoucher_t_store_id() {
        return this.voucher_t_store_id;
    }

    public String getVoucher_t_storename() {
        return this.voucher_t_storename;
    }

    public String getVoucher_title() {
        return this.voucher_title;
    }

    public String getVoucher_type() {
        return this.voucher_type;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean paramBoolean) {
        this.isCheck = paramBoolean;
    }

    public void setVoucher_active_date(String paramString) {
        this.voucher_active_date = paramString;
    }

    public void setVoucher_code(String paramString) {
        this.voucher_code = paramString;
    }

    public void setVoucher_desc(String paramString) {
        this.voucher_desc = paramString;
    }

    public void setVoucher_end_date(String paramString) {
        this.voucher_end_date = paramString;
    }

    public void setVoucher_id(String paramString) {
        this.voucher_id = paramString;
    }

    public void setVoucher_limit(String paramString) {
        this.voucher_limit = paramString;
    }

    public void setVoucher_order_id(String paramString) {
        this.voucher_order_id = paramString;
    }

    public void setVoucher_owner_id(String paramString) {
        this.voucher_owner_id = paramString;
    }

    public void setVoucher_owner_name(String paramString) {
        this.voucher_owner_name = paramString;
    }

    public void setVoucher_price(String paramString) {
        this.voucher_price = paramString;
    }

    public void setVoucher_start_date(String paramString) {
        this.voucher_start_date = paramString;
    }

    public void setVoucher_state(String paramString) {
        this.voucher_state = paramString;
    }

    public void setVoucher_state1(String paramString) {
        this.voucher_state1 = paramString;
    }

    public void setVoucher_store_id(String paramString) {
        this.voucher_store_id = paramString;
    }

    public void setVoucher_t_customimg(String paramString) {
        this.voucher_t_customimg = paramString;
    }

    public void setVoucher_t_id(String paramString) {
        this.voucher_t_id = paramString;
    }

    public void setVoucher_t_store_id(String paramString) {
        this.voucher_t_store_id = paramString;
    }

    public void setVoucher_t_storename(String paramString) {
        this.voucher_t_storename = paramString;
    }

    public void setVoucher_title(String paramString) {
        this.voucher_title = paramString;
    }

    public void setVoucher_type(String paramString) {
        this.voucher_type = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isCheck ? 1 : 0));
        dest.writeString(voucher_active_date);
        dest.writeString(voucher_code);
        dest.writeString(voucher_desc);
        dest.writeString(voucher_end_date);
        dest.writeString(voucher_id);
        dest.writeString(voucher_limit);
        dest.writeString(voucher_order_id);
        dest.writeString(voucher_owner_id);
        dest.writeString(voucher_owner_name);
        dest.writeString(voucher_price);
        dest.writeString(voucher_start_date);
        dest.writeString(voucher_state);
        dest.writeString(voucher_state1);
        dest.writeString(voucher_store_id);
        dest.writeString(voucher_t_customimg);
        dest.writeString(voucher_t_id);
        dest.writeString(voucher_t_store_id);
        dest.writeString(voucher_t_storename);
        dest.writeString(voucher_title);
        dest.writeString(voucher_type);
    }
}
