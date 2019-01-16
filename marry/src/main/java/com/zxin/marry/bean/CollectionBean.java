package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/28.
 */

public class CollectionBean implements Parcelable{
    private String code;
    private String iscancel;
    private String message;

    protected CollectionBean(Parcel in) {
        code = in.readString();
        iscancel = in.readString();
        message = in.readString();
    }

    public static final Creator<CollectionBean> CREATOR = new Creator<CollectionBean>() {
        @Override
        public CollectionBean createFromParcel(Parcel in) {
            return new CollectionBean(in);
        }

        @Override
        public CollectionBean[] newArray(int size) {
            return new CollectionBean[size];
        }
    };

    public String getCode() {
        return this.code;
    }

    public String getIscancel() {
        return this.iscancel;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setIscancel(String paramString) {
        this.iscancel = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(iscancel);
        dest.writeString(message);
    }
}
