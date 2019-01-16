package com.common.camera.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/9/4.
 */

public class PhotoPreviewBean implements Parcelable{

    public String title;
    public String attention;
    public boolean isAttention;
    public int index;
    public int count;
    public String explain;
    public int explainNum;
    public boolean isExplain;
    public int zanNum;
    public boolean isZan;
    public String content;
    public List<PhotoPreview> photoList;

    public static class PhotoPreview implements Parcelable{
        public String imageUrl;


        public PhotoPreview() {

        }
        protected PhotoPreview(Parcel in) {
            imageUrl = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(imageUrl);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<PhotoPreview> CREATOR = new Creator<PhotoPreview>() {
            @Override
            public PhotoPreview createFromParcel(Parcel in) {
                return new PhotoPreview(in);
            }

            @Override
            public PhotoPreview[] newArray(int size) {
                return new PhotoPreview[size];
            }
        };
    }

    public PhotoPreviewBean() {

    }
    protected PhotoPreviewBean(Parcel in) {
        title = in.readString();
        attention = in.readString();
        isAttention = in.readByte() != 0;
        index = in.readInt();
        count = in.readInt();
        explain = in.readString();
        explainNum = in.readInt();
        isExplain = in.readByte() != 0;
        zanNum = in.readInt();
        isZan = in.readByte() != 0;
        content = in.readString();
        photoList = in.createTypedArrayList(PhotoPreview.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(attention);
        dest.writeByte((byte) (isAttention ? 1 : 0));
        dest.writeInt(index);
        dest.writeInt(count);
        dest.writeString(explain);
        dest.writeInt(explainNum);
        dest.writeByte((byte) (isExplain ? 1 : 0));
        dest.writeInt(zanNum);
        dest.writeByte((byte) (isZan ? 1 : 0));
        dest.writeString(content);
        dest.writeTypedList(photoList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoPreviewBean> CREATOR = new Creator<PhotoPreviewBean>() {
        @Override
        public PhotoPreviewBean createFromParcel(Parcel in) {
            return new PhotoPreviewBean(in);
        }

        @Override
        public PhotoPreviewBean[] newArray(int size) {
            return new PhotoPreviewBean[size];
        }
    };
}
