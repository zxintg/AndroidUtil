package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/5.
 */

public class RecommendHotelBean {

    private String code;
    private ArrayList<HotelRes> hotelRes;
    private String message;

    public String getCode() {
        return this.code;
    }

    public ArrayList<HotelRes> getHotelRes() {
        return this.hotelRes;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setHotelRes(ArrayList<HotelRes> paramArrayList) {
        this.hotelRes = paramArrayList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class HotelRes implements Parcelable {
        private String coverimage;
        private String id;
        private String name;

        protected HotelRes(Parcel in) {
            coverimage = in.readString();
            id = in.readString();
            name = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(coverimage);
            dest.writeString(id);
            dest.writeString(name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<HotelRes> CREATOR = new Creator<HotelRes>() {
            @Override
            public HotelRes createFromParcel(Parcel in) {
                return new HotelRes(in);
            }

            @Override
            public HotelRes[] newArray(int size) {
                return new HotelRes[size];
            }
        };

        public String getCoverimage() {
            return this.coverimage;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setCoverimage(String paramString) {
            this.coverimage = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }
}
