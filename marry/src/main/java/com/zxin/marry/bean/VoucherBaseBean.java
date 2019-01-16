package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class VoucherBaseBean implements Parcelable{
    private String code;
    private String message;
    private List<VoucherBean> voucher;

    protected VoucherBaseBean(Parcel in) {
        code = in.readString();
        message = in.readString();
        voucher = in.createTypedArrayList(VoucherBean.CREATOR);
    }

    public static final Creator<VoucherBaseBean> CREATOR = new Creator<VoucherBaseBean>() {
        @Override
        public VoucherBaseBean createFromParcel(Parcel in) {
            return new VoucherBaseBean(in);
        }

        @Override
        public VoucherBaseBean[] newArray(int size) {
            return new VoucherBaseBean[size];
        }
    };

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public List<VoucherBean> getVoucher() {
        if (this.voucher == null) {
            this.voucher = new ArrayList();
        }
        return this.voucher;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setVoucher(List<VoucherBean> paramList) {
        this.voucher = paramList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(message);
        dest.writeTypedList(voucher);
    }
}
