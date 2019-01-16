package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/15.
 */

public class ToolsBean implements Parcelable{
    private int id;
    private int imgRes;
    private String name;

    public ToolsBean() {

    }

    protected ToolsBean(Parcel in) {
        id = in.readInt();
        imgRes = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imgRes);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ToolsBean> CREATOR = new Creator<ToolsBean>() {
        @Override
        public ToolsBean createFromParcel(Parcel in) {
            return new ToolsBean(in);
        }

        @Override
        public ToolsBean[] newArray(int size) {
            return new ToolsBean[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
