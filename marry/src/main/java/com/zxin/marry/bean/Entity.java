package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/15.
 */

public class Entity {

    private int buttontype;
    private String city;
    private String cityid;
    private int code;
    private Data data;
    private String feastid;
    private int height;
    private String message;
    private String name;
    private Parameter parameter;
    private String phone;
    private String savepath;
    private long size;

    public ArrayList<WangPanUrl> wangpan;
    private int width;

    public Entity() {
    }

    public Entity(int paramInt, String paramString) {
        this.code = paramInt;
        this.message = paramString;
    }

    public int getButtontype() {
        return this.buttontype;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityid() {
        if (this.cityid == null) {
            return "";
        }
        return this.cityid;
    }

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getFeastid() {
        return this.feastid;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public Parameter getParameter() {
        return this.parameter;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getSavepath() {
        return this.savepath;
    }

    public long getSize() {
        return this.size;
    }

    public ArrayList<WangPanUrl> getWangpan() {
        return this.wangpan;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setSavepath(String paramString) {
        this.savepath = paramString;
    }

    public void setSize(long paramLong) {
        this.size = paramLong;
    }

    public String toString() {
        return "Entity{code=" + this.code + ", message='" + this.message + '\'' + ", savepath='" + this.savepath + '\'' + ", cityid='" + this.cityid + '\'' + ", feastid='" + this.feastid + '\'' + ", city='" + this.city + '\'' + ", width=" + this.width + ", height=" + this.height + ", data=" + this.data + '}';
    }

    public static class Data {
        String reply_id;
        String theme_id;

        public String getReply_id() {
            return this.reply_id;
        }

        public String getTheme_id() {
            return this.theme_id;
        }
    }

    public static class Parameter implements Parcelable {
        public static final Parcelable.Creator<Parameter> CREATOR = new Parcelable.Creator() {
            public Entity.Parameter createFromParcel(Parcel paramAnonymousParcel) {
                return new Entity.Parameter(paramAnonymousParcel);
            }

            public Entity.Parameter[] newArray(int paramAnonymousInt) {
                return new Entity.Parameter[paramAnonymousInt];
            }
        };
        private String appid;
        private String noncestr;
        private String out_trade_no;
        private String packageValue;
        private String partnerid;
        private String prepayid;
        private String sign;
        private String timestamp;

        public Parameter() {
        }

        protected Parameter(Parcel paramParcel) {
            this.appid = paramParcel.readString();
            this.partnerid = paramParcel.readString();
            this.prepayid = paramParcel.readString();
            this.packageValue = paramParcel.readString();
            this.noncestr = paramParcel.readString();
            this.timestamp = paramParcel.readString();
            this.sign = paramParcel.readString();
            this.out_trade_no = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getAppid() {
            return this.appid;
        }

        public String getNoncestr() {
            return this.noncestr;
        }

        public String getOut_trade_no() {
            return this.out_trade_no;
        }

        public String getPackageValue() {
            return this.packageValue;
        }

        public String getPartnerid() {
            return this.partnerid;
        }

        public String getPrepayid() {
            return this.prepayid;
        }

        public String getSign() {
            return this.sign;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.appid);
            paramParcel.writeString(this.partnerid);
            paramParcel.writeString(this.prepayid);
            paramParcel.writeString(this.packageValue);
            paramParcel.writeString(this.noncestr);
            paramParcel.writeString(this.timestamp);
            paramParcel.writeString(this.sign);
            paramParcel.writeString(this.out_trade_no);
        }
    }
}
