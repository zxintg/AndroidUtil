package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/12/2.
 */

public class Address implements Parcelable{
    public int provinceId = 0;
    public String province = "";
    public int cityId = 0;
    public String city = "";
    public int districtId =0;
    public String district = "";
    public String address ="";

    public Address() {

    }

    protected Address(Parcel in) {
        provinceId = in.readInt();
        province = in.readString();
        cityId = in.readInt();
        city = in.readString();
        districtId = in.readInt();
        district = in.readString();
        address = in.readString();
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(provinceId);
        dest.writeString(province);
        dest.writeInt(cityId);
        dest.writeString(city);
        dest.writeInt(districtId);
        dest.writeString(district);
        dest.writeString(address);
    }
}
