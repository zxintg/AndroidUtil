package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class GifListBean {
    private String code;
    private List<GiftuserBean> giftuser;
    private String message;

    public String getCode() {
        return this.code;
    }

    public List<GiftuserBean> getGiftuser() {
        return this.giftuser;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setGiftuser(List<GiftuserBean> paramList) {
        this.giftuser = paramList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class GiftuserBean implements Parcelable {
        private String city_id;
        private String createtime;
        private String exchange_day;
        private String gift_image;
        private String gift_name;
        private String giftid;
        private String id;
        private String isread;
        private String qrcode;
        private String sc_id;
        private String sc_name;
        private String store_id;
        private String store_name;
        private String uid;
        private String usetime;

        protected GiftuserBean(Parcel in) {
            city_id = in.readString();
            createtime = in.readString();
            exchange_day = in.readString();
            gift_image = in.readString();
            gift_name = in.readString();
            giftid = in.readString();
            id = in.readString();
            isread = in.readString();
            qrcode = in.readString();
            sc_id = in.readString();
            sc_name = in.readString();
            store_id = in.readString();
            store_name = in.readString();
            uid = in.readString();
            usetime = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(city_id);
            dest.writeString(createtime);
            dest.writeString(exchange_day);
            dest.writeString(gift_image);
            dest.writeString(gift_name);
            dest.writeString(giftid);
            dest.writeString(id);
            dest.writeString(isread);
            dest.writeString(qrcode);
            dest.writeString(sc_id);
            dest.writeString(sc_name);
            dest.writeString(store_id);
            dest.writeString(store_name);
            dest.writeString(uid);
            dest.writeString(usetime);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<GiftuserBean> CREATOR = new Creator<GiftuserBean>() {
            @Override
            public GiftuserBean createFromParcel(Parcel in) {
                return new GiftuserBean(in);
            }

            @Override
            public GiftuserBean[] newArray(int size) {
                return new GiftuserBean[size];
            }
        };

        public String getCity_id() {
            return this.city_id;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public String getExchange_day() {
            return this.exchange_day;
        }

        public String getGift_image() {
            return this.gift_image;
        }

        public String getGift_name() {
            return this.gift_name;
        }

        public String getGiftid() {
            return this.giftid;
        }

        public String getId() {
            return this.id;
        }

        public String getIsread() {
            return this.isread;
        }

        public String getQrcode() {
            return this.qrcode;
        }

        public String getSc_id() {
            return this.sc_id;
        }

        public String getSc_name() {
            return this.sc_name;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public String getUid() {
            return this.uid;
        }

        public String getUsetime() {
            return this.usetime;
        }

        public void setCity_id(String paramString) {
            this.city_id = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setExchange_day(String paramString) {
            this.exchange_day = paramString;
        }

        public void setGift_image(String paramString) {
            this.gift_image = paramString;
        }

        public void setGift_name(String paramString) {
            this.gift_name = paramString;
        }

        public void setGiftid(String paramString) {
            this.giftid = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsread(String paramString) {
            this.isread = paramString;
        }

        public void setQrcode(String paramString) {
            this.qrcode = paramString;
        }

        public void setSc_id(String paramString) {
            this.sc_id = paramString;
        }

        public void setSc_name(String paramString) {
            this.sc_name = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        public void setUid(String paramString) {
            this.uid = paramString;
        }

        public void setUsetime(String paramString) {
            this.usetime = paramString;
        }
    }
}
