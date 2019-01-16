package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */

public class CameraProduct implements Parcelable {
    public static final Parcelable.Creator<CameraProduct> CREATOR = new Parcelable.Creator() {
        public CameraProduct createFromParcel(Parcel paramAnonymousParcel) {
            return new CameraProduct(paramAnonymousParcel);
        }

        public CameraProduct[] newArray(int paramAnonymousInt) {
            return new CameraProduct[paramAnonymousInt];
        }
    };
    private String cid;
    private String createtime;
    private String customercase;
    private String edittime;
    private String id;
    private String imagemessage;
    private String imagenamemessage;
    private List<Image> images;
    private String name;
    private String read;
    private String summary;
    private String surface;
    private String title;
    private String type;

    public CameraProduct() {
    }

    protected CameraProduct(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.cid = paramParcel.readString();
        this.name = paramParcel.readString();
        this.title = paramParcel.readString();
        this.surface = paramParcel.readString();
        this.summary = paramParcel.readString();
        this.read = paramParcel.readString();
        this.createtime = paramParcel.readString();
        this.edittime = paramParcel.readString();
        this.type = paramParcel.readString();
        this.imagemessage = paramParcel.readString();
        this.imagenamemessage = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getCustomercase() {
        return this.customercase;
    }

    public String getEdittime() {
        return this.edittime;
    }

    public String getId() {
        return this.id;
    }

    public String getImagemessage() {
        return this.imagemessage;
    }

    public String getImagenamemessage() {
        return this.imagenamemessage;
    }

    public List<Image> getImages() {
        if (this.images == null) {
            return new ArrayList();
        }
        return this.images;
    }

    public String getName() {
        return this.name;
    }

    public String getRead() {
        return this.read;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getSurface() {
        return this.surface;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.cid);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.title);
        paramParcel.writeString(this.surface);
        paramParcel.writeString(this.summary);
        paramParcel.writeString(this.read);
        paramParcel.writeString(this.createtime);
        paramParcel.writeString(this.edittime);
        paramParcel.writeString(this.type);
        paramParcel.writeString(this.imagemessage);
        paramParcel.writeString(this.imagenamemessage);
    }

    public static class Image {
        int height;
        String url;
        int width;

        public int getHeight() {
            return this.height;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }
    }
}
