package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class YunShangBean implements Parcelable {

    public String id;
    public String imageUrl;
    public String name;
    public String content;
    public String time;
    public String address;
    public String product;
    public String linkUrl;
    public String call;

    public YunShangBean() {

    }

    protected YunShangBean(Parcel in) {
        id = in.readString();
        imageUrl = in.readString();
        name = in.readString();
        content = in.readString();
        time = in.readString();
        address = in.readString();
        product = in.readString();
        linkUrl = in.readString();
        call = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(imageUrl);
        dest.writeString(name);
        dest.writeString(content);
        dest.writeString(time);
        dest.writeString(address);
        dest.writeString(product);
        dest.writeString(linkUrl);
        dest.writeString(call);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<YunShangBean> CREATOR = new Creator<YunShangBean>() {
        @Override
        public YunShangBean createFromParcel(Parcel in) {
            return new YunShangBean(in);
        }

        @Override
        public YunShangBean[] newArray(int size) {
            return new YunShangBean[size];
        }
    };
}
