package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/5/11.
 */

public class GuanJianZiBean implements Parcelable {
    public long id;
    public String name;
    public String time;
    public String root;
    public String lable;

    public GuanJianZiBean() {

    }

    protected GuanJianZiBean(Parcel in) {
        id = in.readLong();
        name = in.readString();
        time = in.readString();
        root = in.readString();
        lable = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(time);
        dest.writeString(root);
        dest.writeString(lable);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GuanJianZiBean> CREATOR = new Creator<GuanJianZiBean>() {
        @Override
        public GuanJianZiBean createFromParcel(Parcel in) {
            return new GuanJianZiBean(in);
        }

        @Override
        public GuanJianZiBean[] newArray(int size) {
            return new GuanJianZiBean[size];
        }
    };
}
