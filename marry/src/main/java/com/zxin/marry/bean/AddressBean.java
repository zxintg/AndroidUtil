package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/7/2.
 */

public class AddressBean implements Parcelable{
    private String address;
    private String address_id;
    private String area_id;
    private String area_info;
    private String city_id;
    private String dlyp_id;
    private String is_default;
    private String member_id;
    private String mob_phone;
    private String tel_phone;
    private String true_name;

    protected AddressBean(Parcel in) {
        address = in.readString();
        address_id = in.readString();
        area_id = in.readString();
        area_info = in.readString();
        city_id = in.readString();
        dlyp_id = in.readString();
        is_default = in.readString();
        member_id = in.readString();
        mob_phone = in.readString();
        tel_phone = in.readString();
        true_name = in.readString();
    }

    public static final Creator<AddressBean> CREATOR = new Creator<AddressBean>() {
        @Override
        public AddressBean createFromParcel(Parcel in) {
            return new AddressBean(in);
        }

        @Override
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };

    public String getAddress() {
        return this.address;
    }

    public String getAddress_id() {
        return this.address_id;
    }

    public String getArea_id() {
        return this.area_id;
    }

    public String getArea_info() {
        return this.area_info;
    }

    public String getCity_id() {
        return this.city_id;
    }

    public String getDlyp_id() {
        return this.dlyp_id;
    }

    public String getIs_default() {
        return this.is_default;
    }

    public String getMember_id() {
        return this.member_id;
    }

    public String getMob_phone() {
        return this.mob_phone;
    }

    public String getTel_phone() {
        return this.tel_phone;
    }

    public String getTrue_name() {
        return this.true_name;
    }

    public void setAddress(String paramString) {
        this.address = paramString;
    }

    public void setAddress_id(String paramString) {
        this.address_id = paramString;
    }

    public void setArea_id(String paramString) {
        this.area_id = paramString;
    }

    public void setArea_info(String paramString) {
        this.area_info = paramString;
    }

    public void setCity_id(String paramString) {
        this.city_id = paramString;
    }

    public void setDlyp_id(String paramString) {
        this.dlyp_id = paramString;
    }

    public void setIs_default(String paramString) {
        this.is_default = paramString;
    }

    public void setMember_id(String paramString) {
        this.member_id = paramString;
    }

    public void setMob_phone(String paramString) {
        this.mob_phone = paramString;
    }

    public void setTel_phone(String paramString) {
        this.tel_phone = paramString;
    }

    public void setTrue_name(String paramString) {
        this.true_name = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(address_id);
        dest.writeString(area_id);
        dest.writeString(area_info);
        dest.writeString(city_id);
        dest.writeString(dlyp_id);
        dest.writeString(is_default);
        dest.writeString(member_id);
        dest.writeString(mob_phone);
        dest.writeString(tel_phone);
        dest.writeString(true_name);
    }
}
