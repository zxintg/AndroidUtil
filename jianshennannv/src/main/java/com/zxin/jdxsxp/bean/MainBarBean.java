package com.zxin.jdxsxp.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

import com.zxin.root.bean.TitleBean;

/**
 * Created by Administrator on 2018/6/13.
 */

public class MainBarBean<F extends Fragment> extends TitleBean implements Parcelable{
    //资源文件
    public int labSource;
    public int index;
    public String tag;
    public F fragment;

    public MainBarBean() {

    }

    protected MainBarBean(Parcel in) {
        labSource = in.readInt();
        index = in.readInt();
        tag = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(labSource);
        dest.writeInt(index);
        dest.writeString(tag);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MainBarBean> CREATOR = new Creator<MainBarBean>() {
        @Override
        public MainBarBean createFromParcel(Parcel in) {
            return new MainBarBean(in);
        }

        @Override
        public MainBarBean[] newArray(int size) {
            return new MainBarBean[size];
        }
    };
}
