package com.common.camera.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by liukui on 2018/1/30.
 */

public class LocalAlbum implements Parcelable{
    public List<ImageFloder> imageList;
    public List<String>  mDirPaths;

    public LocalAlbum() {

    }
    protected LocalAlbum(Parcel in) {
        imageList = in.createTypedArrayList(ImageFloder.CREATOR);
        mDirPaths = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(imageList);
        dest.writeStringList(mDirPaths);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LocalAlbum> CREATOR = new Creator<LocalAlbum>() {
        @Override
        public LocalAlbum createFromParcel(Parcel in) {
            return new LocalAlbum(in);
        }

        @Override
        public LocalAlbum[] newArray(int size) {
            return new LocalAlbum[size];
        }
    };
}
