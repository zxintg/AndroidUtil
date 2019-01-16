package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/9/7.
 */

public class VideoPlayBean implements Parcelable{
    private String imageUrl;
    private String resUrl;
    private String title;
    private String balk;

    public VideoPlayBean(DynamicModel localTheme) {
        DynamicResources res = localTheme.getDynamicResources().get(0);
        setTitle(localTheme.getDesc());
        setImageUrl(res.getThumbnailUrl());
        setResUrl(res.getUrl());
        setBalk("返回");
    }

    public VideoPlayBean(DynamicResources res) {
        setTitle(res.getDesc());
        setImageUrl(res.getThumbnailUrl());
        setResUrl(res.getUrl());
        setBalk("返回");
    }

    protected VideoPlayBean(Parcel in) {
        imageUrl = in.readString();
        resUrl = in.readString();
        title = in.readString();
        balk = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(resUrl);
        dest.writeString(title);
        dest.writeString(balk);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VideoPlayBean> CREATOR = new Creator<VideoPlayBean>() {
        @Override
        public VideoPlayBean createFromParcel(Parcel in) {
            return new VideoPlayBean(in);
        }

        @Override
        public VideoPlayBean[] newArray(int size) {
            return new VideoPlayBean[size];
        }
    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBalk() {
        return balk;
    }

    public void setBalk(String balk) {
        this.balk = balk;
    }

}
