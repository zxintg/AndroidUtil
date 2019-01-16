package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/14.
 */

public class ShareMessage implements Parcelable {
    String shareImage;
    String shareText;
    String shareTitle;
    String shareURL;

    protected ShareMessage(Parcel in) {
        shareImage = in.readString();
        shareText = in.readString();
        shareTitle = in.readString();
        shareURL = in.readString();
    }

    public static final Creator<ShareMessage> CREATOR = new Creator<ShareMessage>() {
        @Override
        public ShareMessage createFromParcel(Parcel in) {
            return new ShareMessage(in);
        }

        @Override
        public ShareMessage[] newArray(int size) {
            return new ShareMessage[size];
        }
    };

    public String getShareImage() {
        return this.shareImage;
    }

    public String getShareText() {
        return this.shareText;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareURL() {
        return this.shareURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shareImage);
        dest.writeString(shareText);
        dest.writeString(shareTitle);
        dest.writeString(shareURL);
    }
}
