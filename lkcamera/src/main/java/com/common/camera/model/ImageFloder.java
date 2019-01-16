package com.common.camera.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liukui on 2018/1/30.
 *
 * 获取图片信息
 *
 */

public class ImageFloder implements Parcelable{
    private int count;//文件夹下的图片个数
    private String firstImagePath;//第一张图片的路径 传这个给小相册图片显示
    private String dir;//文件夹路径
    private String name;//文件夹的名字

    public ImageFloder() {

    }
    protected ImageFloder(Parcel in) {
        count = in.readInt();
        firstImagePath = in.readString();
        dir = in.readString();
        name = in.readString();
    }

    public static final Creator<ImageFloder> CREATOR = new Creator<ImageFloder>() {
        @Override
        public ImageFloder createFromParcel(Parcel in) {
            return new ImageFloder(in);
        }

        @Override
        public ImageFloder[] newArray(int size) {
            return new ImageFloder[size];
        }
    };

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public void setFirstImagePath(String firstImagePath) {
        this.firstImagePath = firstImagePath;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeString(firstImagePath);
        dest.writeString(dir);
        dest.writeString(name);
    }
}
