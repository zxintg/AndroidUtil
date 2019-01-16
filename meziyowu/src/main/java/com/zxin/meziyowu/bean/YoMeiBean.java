package com.zxin.meziyowu.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/9/28.
 */

public class YoMeiBean implements Parcelable{

    private int id;

    public YoMeiBean(long id, String cover, String url) {
        this.id = Integer.parseInt(String.valueOf(id));
        this.cover = cover;
        this.url = url;
    }
    protected YoMeiBean(Parcel in) {
        id = in.readInt();
        cover = in.readString();
        url = in.readString();
    }

    public static final Creator<YoMeiBean> CREATOR = new Creator<YoMeiBean>() {
        @Override
        public YoMeiBean createFromParcel(Parcel in) {
            return new YoMeiBean(in);
        }

        @Override
        public YoMeiBean[] newArray(int size) {
            return new YoMeiBean[size];
        }
    };

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    private String cover;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cover);
        dest.writeString(url);
    }
}
