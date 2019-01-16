package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/7/4.
 */

public class VerticalBanner implements Parcelable{
    private int id;
    private String title;
    private String desc;
    private String imageUrl;
    private String lineUrl;

    public VerticalBanner() {

    }
    protected VerticalBanner(Parcel in) {
        id = in.readInt();
        title = in.readString();
        desc = in.readString();
        imageUrl = in.readString();
        lineUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(desc);
        dest.writeString(imageUrl);
        dest.writeString(lineUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VerticalBanner> CREATOR = new Creator<VerticalBanner>() {
        @Override
        public VerticalBanner createFromParcel(Parcel in) {
            return new VerticalBanner(in);
        }

        @Override
        public VerticalBanner[] newArray(int size) {
            return new VerticalBanner[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLineUrl() {
        return lineUrl;
    }

    public void setLineUrl(String lineUrl) {
        this.lineUrl = lineUrl;
    }

}
