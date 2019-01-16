package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/21.
 */

public class UserMeaagseBean implements Parcelable{
    private String code;
    private InfoEntity info;
    private String message;

    protected UserMeaagseBean(Parcel in) {
        code = in.readString();
        info = in.readParcelable(InfoEntity.class.getClassLoader());
        message = in.readString();
    }

    public static final Creator<UserMeaagseBean> CREATOR = new Creator<UserMeaagseBean>() {
        @Override
        public UserMeaagseBean createFromParcel(Parcel in) {
            return new UserMeaagseBean(in);
        }

        @Override
        public UserMeaagseBean[] newArray(int size) {
            return new UserMeaagseBean[size];
        }
    };

    public String getCode() {
        return this.code;
    }

    public InfoEntity getInfo() {
        return this.info;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setInfo(InfoEntity paramInfoEntity) {
        this.info = paramInfoEntity;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeParcelable(info, flags);
        dest.writeString(message);
    }

    public static class InfoEntity implements Parcelable {
        private String qq_first;
        private String qq_second;
        private String shop_name;
        private String shop_tel_custom;
        private String shop_tel_dangqi;
        private String shop_tel_getphoto;
        private String shop_tel_second;
        private String shop_tel_xuanyang;
        private String weixin_first;

        protected InfoEntity(Parcel in) {
            qq_first = in.readString();
            qq_second = in.readString();
            shop_name = in.readString();
            shop_tel_custom = in.readString();
            shop_tel_dangqi = in.readString();
            shop_tel_getphoto = in.readString();
            shop_tel_second = in.readString();
            shop_tel_xuanyang = in.readString();
            weixin_first = in.readString();
        }

        public static final Creator<InfoEntity> CREATOR = new Creator<InfoEntity>() {
            @Override
            public InfoEntity createFromParcel(Parcel in) {
                return new InfoEntity(in);
            }

            @Override
            public InfoEntity[] newArray(int size) {
                return new InfoEntity[size];
            }
        };

        public String getQq_first() {
            if (this.qq_first == null) {
                return "";
            }
            return this.qq_first;
        }

        public String getQq_second() {
            if (this.qq_second == null) {
                return "";
            }
            return this.qq_second;
        }

        public String getShop_name() {
            if (this.shop_name == null) {
                return "";
            }
            return this.shop_name;
        }

        public String getShop_tel_custom() {
            if (this.shop_tel_custom == null) {
                return "";
            }
            return this.shop_tel_custom;
        }

        public String getShop_tel_dangqi() {
            return this.shop_tel_dangqi;
        }

        public String getShop_tel_getphoto() {
            return this.shop_tel_getphoto;
        }

        public String getShop_tel_second() {
            if (this.shop_tel_second == null) {
                return "";
            }
            return this.shop_tel_second;
        }

        public String getShop_tel_xuanyang() {
            return this.shop_tel_xuanyang;
        }

        public String getWeixin_first() {
            if (this.weixin_first == null) {
                return "";
            }
            return this.weixin_first;
        }

        public void setQq_first(String paramString) {
            this.qq_first = paramString;
        }

        public void setQq_second(String paramString) {
            this.qq_second = paramString;
        }

        public void setShop_name(String paramString) {
            this.shop_name = paramString;
        }

        public void setShop_tel_custom(String paramString) {
            this.shop_tel_custom = paramString;
        }

        public void setShop_tel_dangqi(String paramString) {
            this.shop_tel_dangqi = paramString;
        }

        public void setShop_tel_getphoto(String paramString) {
            this.shop_tel_getphoto = paramString;
        }

        public void setShop_tel_second(String paramString) {
            this.shop_tel_second = paramString;
        }

        public void setShop_tel_xuanyang(String paramString) {
            this.shop_tel_xuanyang = paramString;
        }

        public void setWeixin_first(String paramString) {
            this.weixin_first = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(qq_first);
            dest.writeString(qq_second);
            dest.writeString(shop_name);
            dest.writeString(shop_tel_custom);
            dest.writeString(shop_tel_dangqi);
            dest.writeString(shop_tel_getphoto);
            dest.writeString(shop_tel_second);
            dest.writeString(shop_tel_xuanyang);
            dest.writeString(weixin_first);
        }
    }
}
