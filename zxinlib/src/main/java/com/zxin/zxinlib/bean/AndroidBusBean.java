package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class AndroidBusBean implements Parcelable {

    public String imageUrl;
    public String title;
    public String headImgUrl;
    public String desc;
    public String time;
    public String userNmae;
    public String userLevelUrl;
    public String linkUrl;

    public AndroidBusBean() {

    }


    protected AndroidBusBean(Parcel in) {
        imageUrl = in.readString();
        title = in.readString();
        headImgUrl = in.readString();
        desc = in.readString();
        time = in.readString();
        userNmae = in.readString();
        userLevelUrl = in.readString();
        linkUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(title);
        dest.writeString(headImgUrl);
        dest.writeString(desc);
        dest.writeString(time);
        dest.writeString(userNmae);
        dest.writeString(userLevelUrl);
        dest.writeString(linkUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AndroidBusBean> CREATOR = new Creator<AndroidBusBean>() {
        @Override
        public AndroidBusBean createFromParcel(Parcel in) {
            return new AndroidBusBean(in);
        }

        @Override
        public AndroidBusBean[] newArray(int size) {
            return new AndroidBusBean[size];
        }
    };
}
