package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/5.
 */

public class KKTagBean implements Parcelable{
    public String userName;
    public String type;
    public String name;

    protected KKTagBean(Parcel in) {
        userName = in.readString();
        type = in.readString();
        name = in.readString();
    }

    public static final Creator<KKTagBean> CREATOR = new Creator<KKTagBean>() {
        @Override
        public KKTagBean createFromParcel(Parcel in) {
            return new KKTagBean(in);
        }

        @Override
        public KKTagBean[] newArray(int size) {
            return new KKTagBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(type);
        dest.writeString(name);
    }
}
