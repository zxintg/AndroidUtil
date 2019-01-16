package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Set;

/**
 * Created by Administrator on 2018/6/13.
 */

public class UserCommon implements Parcelable {
    private int code;
    private User data;
    private String ecshop;
    private String message;
    private Set<String> shops;
    private String uid;

    public UserCommon() {

    }
    protected UserCommon(Parcel in) {
        code = in.readInt();
        data = in.readParcelable(User.class.getClassLoader());
        ecshop = in.readString();
        message = in.readString();
        uid = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeParcelable(data, flags);
        dest.writeString(ecshop);
        dest.writeString(message);
        dest.writeString(uid);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserCommon> CREATOR = new Creator<UserCommon>() {
        @Override
        public UserCommon createFromParcel(Parcel in) {
            return new UserCommon(in);
        }

        @Override
        public UserCommon[] newArray(int size) {
            return new UserCommon[size];
        }
    };

    public int getCode() {
        return this.code;
    }

    public User getData() {
        if (this.data == null) {
            this.data = new User();
        }
        return this.data;
    }

    public String getEcshop() {
        return this.ecshop;
    }

    public String getMessage() {
        return this.message;
    }

    public Set<String> getShops() {
        return this.shops;
    }

    public String getUid() {
        if (this.uid == null) {
            this.uid = getData().getId();
        }
        return this.uid;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setData(User paramUser) {
        this.data = paramUser;
    }

    public void setEcshop(String paramString) {
        this.ecshop = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setShops(Set<String> paramSet) {
        this.shops = paramSet;
    }

    public void setUid(String paramString) {
        this.uid = paramString;
    }

    public String toString() {
        return "UserCommon{code=" + this.code + ", message='" + this.message + '\'' + ", uid='" + this.uid + '\'' + ", data=" + this.data + '}';
    }

    public static class User implements Parcelable {
        private String avatar;
        private String birthday;
        private String countcoupon;
        private String create_time;
        private String id;
        private String last_login_ip;
        private String last_login_time;
        private String marrydate;
        private String ordercount;
        private String role_id;
        private String score;
        private String sex;
        private String signature;
        private String user_activation_key;
        private String user_email;
        private String user_login;
        private String user_nicename;
        private String user_pass;
        private String user_status;
        private String user_type;
        private String user_url;

        public User() {

        }

        protected User(Parcel in) {
            avatar = in.readString();
            birthday = in.readString();
            countcoupon = in.readString();
            create_time = in.readString();
            id = in.readString();
            last_login_ip = in.readString();
            last_login_time = in.readString();
            marrydate = in.readString();
            ordercount = in.readString();
            role_id = in.readString();
            score = in.readString();
            sex = in.readString();
            signature = in.readString();
            user_activation_key = in.readString();
            user_email = in.readString();
            user_login = in.readString();
            user_nicename = in.readString();
            user_pass = in.readString();
            user_status = in.readString();
            user_type = in.readString();
            user_url = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(avatar);
            dest.writeString(birthday);
            dest.writeString(countcoupon);
            dest.writeString(create_time);
            dest.writeString(id);
            dest.writeString(last_login_ip);
            dest.writeString(last_login_time);
            dest.writeString(marrydate);
            dest.writeString(ordercount);
            dest.writeString(role_id);
            dest.writeString(score);
            dest.writeString(sex);
            dest.writeString(signature);
            dest.writeString(user_activation_key);
            dest.writeString(user_email);
            dest.writeString(user_login);
            dest.writeString(user_nicename);
            dest.writeString(user_pass);
            dest.writeString(user_status);
            dest.writeString(user_type);
            dest.writeString(user_url);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<User> CREATOR = new Creator<User>() {
            @Override
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };

        public String getAvatar() {
            return this.avatar;
        }

        public String getBirthday() {
            return this.birthday;
        }

        public String getCountcoupon() {
            return this.countcoupon;
        }

        public String getCreate_time() {
            return this.create_time;
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getLast_login_ip() {
            return this.last_login_ip;
        }

        public String getLast_login_time() {
            return this.last_login_time;
        }

        public String getMarrydate() {
            if (this.marrydate == null) {
                return "";
            }
            return this.marrydate;
        }

        public String getOrdercount() {
            return this.ordercount;
        }

        public String getRole_id() {
            return this.role_id;
        }

        public String getScore() {
            return this.score;
        }

        public String getSex() {
            if (this.sex == null) {
                return "未设置";
            }
            switch (this.sex){
                case "0":
                    return "保密";
                case "1":
                    return "男";
                case "2":
                    return "女";
            }
            return this.sex;
        }

        public String getSignature() {
            return this.signature;
        }

        public String getUser_activation_key() {
            return this.user_activation_key;
        }

        public String getUser_email() {
            return this.user_email;
        }

        public String getUser_login() {
            return this.user_login;
        }

        public String getUser_nicename() {
            return this.user_nicename;
        }

        public String getUser_pass() {
            return this.user_pass;
        }

        public String getUser_status() {
            return this.user_status;
        }

        public String getUser_type() {
            return this.user_type;
        }

        public String getUser_url() {
            return this.user_url;
        }

        public void setAvatar(String paramString) {
            this.avatar = paramString;
        }

        public void setBirthday(String paramString) {
            this.birthday = paramString;
        }

        public void setCountcoupon(String paramString) {
            this.countcoupon = paramString;
        }

        public void setCreate_time(String paramString) {
            this.create_time = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setLast_login_ip(String paramString) {
            this.last_login_ip = paramString;
        }

        public void setLast_login_time(String paramString) {
            this.last_login_time = paramString;
        }

        public void setMarrydate(String paramString) {
            this.marrydate = paramString;
        }

        public void setOrdercount(String paramString) {
            this.ordercount = paramString;
        }

        public void setRole_id(String paramString) {
            this.role_id = paramString;
        }

        public void setScore(String paramString) {
            this.score = paramString;
        }

        public void setSex(String paramString) {
            this.sex = paramString;
        }

        public void setSignature(String paramString) {
            this.signature = paramString;
        }

        public void setUser_activation_key(String paramString) {
            this.user_activation_key = paramString;
        }

        public void setUser_email(String paramString) {
            this.user_email = paramString;
        }

        public void setUser_login(String paramString) {
            this.user_login = paramString;
        }

        public void setUser_nicename(String paramString) {
            this.user_nicename = paramString;
        }

        public void setUser_pass(String paramString) {
            this.user_pass = paramString;
        }

        public void setUser_status(String paramString) {
            this.user_status = paramString;
        }

        public void setUser_type(String paramString) {
            this.user_type = paramString;
        }

        public void setUser_url(String paramString) {
            this.user_url = paramString;
        }

        public String toString() {
            return "User{id=" + this.id + ", user_login='" + this.user_login + '\'' + ", user_pass='" + this.user_pass + '\'' + ", user_nicename='" + this.user_nicename + '\'' + ", marrydate='" + this.marrydate + '\'' + ", user_email='" + this.user_email + '\'' + ", user_url='" + this.user_url + '\'' + ", avatar='" + this.avatar + '\'' + ", sex='" + this.sex + '\'' + ", birthday='" + this.birthday + '\'' + ", signature='" + this.signature + '\'' + ", last_login_ip='" + this.last_login_ip + '\'' + ", last_login_time='" + this.last_login_time + '\'' + ", create_time='" + this.create_time + '\'' + ", user_activation_key='" + this.user_activation_key + '\'' + ", user_status='" + this.user_status + '\'' + ", role_id='" + this.role_id + '\'' + ", score='" + this.score + '\'' + ", user_type='" + this.user_type + '\'' + ", countcoupon='" + this.countcoupon + '\'' + '}';
        }
    }
}

