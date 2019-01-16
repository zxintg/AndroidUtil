package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class RecommendForm {
    int code;
    private String message;
    private List<EcShop> ecshop;
    private List<RecommendAdv> recommend_adv;

    public int getCode() {
        return this.code;
    }

    public List<EcShop> getEcshop() {
        if (this.ecshop == null) {
            return new ArrayList();
        }
        return this.ecshop;
    }

    public String getMessage() {
        return this.message;
    }

    public List<RecommendAdv> getRecommend_adv() {
        if (this.recommend_adv == null) {
            return new ArrayList();
        }
        return this.recommend_adv;
    }

    public static class EcShop implements Parcelable {
        public static final Parcelable.Creator<EcShop> CREATOR = new Parcelable.Creator() {
            public RecommendForm.EcShop createFromParcel(Parcel paramAnonymousParcel) {
                return new RecommendForm.EcShop(paramAnonymousParcel);
            }

            public RecommendForm.EcShop[] newArray(int paramAnonymousInt) {
                return new RecommendForm.EcShop[paramAnonymousInt];
            }
        };
        private String store_alias;
        private String store_avatar;
        private String store_id;
        private String store_name;

        public EcShop() {
        }

        protected EcShop(Parcel paramParcel) {
            this.store_id = paramParcel.readString();
            this.store_name = paramParcel.readString();
            this.store_avatar = paramParcel.readString();
            this.store_alias = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getStore_alias() {
            return this.store_alias;
        }

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.store_id);
            paramParcel.writeString(this.store_name);
            paramParcel.writeString(this.store_avatar);
            paramParcel.writeString(this.store_alias);
        }
    }

    public static class RecommendAdv {
        private String adv_title;

        public void setAdv_title(String adv_title) {
            this.adv_title = adv_title;
        }

        public void setObid(String obid) {
            this.obid = obid;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public void setTheme_id(String theme_id) {
            this.theme_id = theme_id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setTypeid(int typeid) {
            this.typeid = typeid;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private String obid;
        private String picurl;
        private String place;
        private String theme_id;
        private String title;
        private String type;
        private int typeid;
        private String url;
        private String value;

        public String getAdv_title() {
            return this.adv_title;
        }

        public String getObid() {
            return this.obid;
        }

        public String getPicurl() {
            if (this.picurl == null) {
                return "";
            }
            return this.picurl;
        }

        public String getPlace() {
            return this.place;
        }

        public String getTheme_id() {
            return this.theme_id;
        }

        public String getTitle() {
            if (this.title == null) {
                return "";
            }
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public int getTypeid() {
            return this.typeid;
        }

        public String getUrl() {
            return this.url;
        }

        public String getValue() {
            return this.value;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }
}
