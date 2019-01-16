package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/27.
 */

public class GiftBean implements Parcelable{
    private String descr;
    private String feastid;
    private String hotelid;
    private String id;
    private String ison;
    private String title;
    private String type;

    protected GiftBean(Parcel in) {
        descr = in.readString();
        feastid = in.readString();
        hotelid = in.readString();
        id = in.readString();
        ison = in.readString();
        title = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descr);
        dest.writeString(feastid);
        dest.writeString(hotelid);
        dest.writeString(id);
        dest.writeString(ison);
        dest.writeString(title);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GiftBean> CREATOR = new Creator<GiftBean>() {
        @Override
        public GiftBean createFromParcel(Parcel in) {
            return new GiftBean(in);
        }

        @Override
        public GiftBean[] newArray(int size) {
            return new GiftBean[size];
        }
    };

    public String getDescr() {
        return this.descr;
    }

    public String getFeastid() {
        return this.feastid;
    }

    public String getHotelid() {
        return this.hotelid;
    }

    public String getId() {
        return this.id;
    }

    public String getIson() {
        return this.ison;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setDescr(String paramString) {
        this.descr = paramString;
    }

    public void setFeastid(String paramString) {
        this.feastid = paramString;
    }

    public void setHotelid(String paramString) {
        this.hotelid = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setIson(String paramString) {
        this.ison = paramString;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setType(String paramString) {
        this.type = paramString;
    }
}
