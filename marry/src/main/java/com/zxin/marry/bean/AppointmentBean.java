package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class AppointmentBean {

    private List<AppointmentlistBean> appointmentlist;
    private String code;
    private String message;

    public List<AppointmentlistBean> getAppointmentlist() {
        return this.appointmentlist;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setAppointmentlist(List<AppointmentlistBean> paramList) {
        this.appointmentlist = paramList;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class AppointmentlistBean implements Parcelable {
        private String appointment_code;
        private String appointment_feedtime;
        private String appointment_goodsid;
        private String appointment_id;
        private String appointment_isfeed;
        private String appointment_name;
        private String appointment_stauts;
        private String appointment_storeid;
        private String appointment_tel;
        private String appointment_time;
        private String appointment_userid;
        private String appointment_wx;
        private String goods_image;
        private String goods_jingle;
        private String goods_name;
        private String member_name;
        private String store_avatar;
        private String store_company_name;
        private String store_name;

        protected AppointmentlistBean(Parcel in) {
            appointment_code = in.readString();
            appointment_feedtime = in.readString();
            appointment_goodsid = in.readString();
            appointment_id = in.readString();
            appointment_isfeed = in.readString();
            appointment_name = in.readString();
            appointment_stauts = in.readString();
            appointment_storeid = in.readString();
            appointment_tel = in.readString();
            appointment_time = in.readString();
            appointment_userid = in.readString();
            appointment_wx = in.readString();
            goods_image = in.readString();
            goods_jingle = in.readString();
            goods_name = in.readString();
            member_name = in.readString();
            store_avatar = in.readString();
            store_company_name = in.readString();
            store_name = in.readString();
        }

        public static final Creator<AppointmentlistBean> CREATOR = new Creator<AppointmentlistBean>() {
            @Override
            public AppointmentlistBean createFromParcel(Parcel in) {
                return new AppointmentlistBean(in);
            }

            @Override
            public AppointmentlistBean[] newArray(int size) {
                return new AppointmentlistBean[size];
            }
        };

        public String getAppointment_code() {
            return this.appointment_code;
        }

        public String getAppointment_feedtime() {
            return this.appointment_feedtime;
        }

        public String getAppointment_goodsid() {
            return this.appointment_goodsid;
        }

        public String getAppointment_id() {
            return this.appointment_id;
        }

        public String getAppointment_isfeed() {
            return this.appointment_isfeed;
        }

        public String getAppointment_name() {
            return this.appointment_name;
        }

        public String getAppointment_stauts() {
            return this.appointment_stauts;
        }

        public String getAppointment_storeid() {
            return this.appointment_storeid;
        }

        public String getAppointment_tel() {
            return this.appointment_tel;
        }

        public String getAppointment_time() {
            return this.appointment_time;
        }

        public String getAppointment_userid() {
            return this.appointment_userid;
        }

        public String getAppointment_wx() {
            return this.appointment_wx;
        }

        public String getGoods_image() {
            return this.goods_image;
        }

        public String getGoods_jingle() {
            return this.goods_jingle;
        }

        public String getGoods_name() {
            return this.goods_name;
        }

        public String getMember_name() {
            return this.member_name;
        }

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_company_name() {
            return this.store_company_name;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public void setAppointment_code(String paramString) {
            this.appointment_code = paramString;
        }

        public void setAppointment_feedtime(String paramString) {
            this.appointment_feedtime = paramString;
        }

        public void setAppointment_goodsid(String paramString) {
            this.appointment_goodsid = paramString;
        }

        public void setAppointment_id(String paramString) {
            this.appointment_id = paramString;
        }

        public void setAppointment_isfeed(String paramString) {
            this.appointment_isfeed = paramString;
        }

        public void setAppointment_name(String paramString) {
            this.appointment_name = paramString;
        }

        public void setAppointment_stauts(String paramString) {
            this.appointment_stauts = paramString;
        }

        public void setAppointment_storeid(String paramString) {
            this.appointment_storeid = paramString;
        }

        public void setAppointment_tel(String paramString) {
            this.appointment_tel = paramString;
        }

        public void setAppointment_time(String paramString) {
            this.appointment_time = paramString;
        }

        public void setAppointment_userid(String paramString) {
            this.appointment_userid = paramString;
        }

        public void setAppointment_wx(String paramString) {
            this.appointment_wx = paramString;
        }

        public void setGoods_image(String paramString) {
            this.goods_image = paramString;
        }

        public void setGoods_jingle(String paramString) {
            this.goods_jingle = paramString;
        }

        public void setGoods_name(String paramString) {
            this.goods_name = paramString;
        }

        public void setMember_name(String paramString) {
            this.member_name = paramString;
        }

        public void setStore_avatar(String paramString) {
            this.store_avatar = paramString;
        }

        public void setStore_company_name(String paramString) {
            this.store_company_name = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(appointment_code);
            dest.writeString(appointment_feedtime);
            dest.writeString(appointment_goodsid);
            dest.writeString(appointment_id);
            dest.writeString(appointment_isfeed);
            dest.writeString(appointment_name);
            dest.writeString(appointment_stauts);
            dest.writeString(appointment_storeid);
            dest.writeString(appointment_tel);
            dest.writeString(appointment_time);
            dest.writeString(appointment_userid);
            dest.writeString(appointment_wx);
            dest.writeString(goods_image);
            dest.writeString(goods_jingle);
            dest.writeString(goods_name);
            dest.writeString(member_name);
            dest.writeString(store_avatar);
            dest.writeString(store_company_name);
            dest.writeString(store_name);
        }
    }
}
