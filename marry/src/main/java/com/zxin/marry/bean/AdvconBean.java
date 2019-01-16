package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/6/14.
 */

public class AdvconBean implements Parcelable {
    private String code;
    private InfoEntity info;
    private String message;

    protected AdvconBean(Parcel in) {
        code = in.readString();
        info = in.readParcelable(InfoEntity.class.getClassLoader());
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeParcelable(info, flags);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AdvconBean> CREATOR = new Creator<AdvconBean>() {
        @Override
        public AdvconBean createFromParcel(Parcel in) {
            return new AdvconBean(in);
        }

        @Override
        public AdvconBean[] newArray(int size) {
            return new AdvconBean[size];
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

    /**
     * Created by Administrator on 2018/6/14.
     */

    public class InfoEntity implements Parcelable {
        private String ads_id;
        private String createtime;
        private String href;
        private String id;
        private String image;
        private String isdelete;
        private String status;
        private String title;

        protected InfoEntity(Parcel in) {
            ads_id = in.readString();
            createtime = in.readString();
            href = in.readString();
            id = in.readString();
            image = in.readString();
            isdelete = in.readString();
            status = in.readString();
            title = in.readString();
        }

        public final Creator<InfoEntity> CREATOR = new Creator<InfoEntity>() {
            @Override
            public InfoEntity createFromParcel(Parcel in) {
                return new InfoEntity(in);
            }

            @Override
            public InfoEntity[] newArray(int size) {
                return new InfoEntity[size];
            }
        };

        public String getAds_id() {
            return ads_id;
        }

        public void setAds_id(String ads_id) {
            this.ads_id = ads_id;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(String isdelete) {
            this.isdelete = isdelete;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(ads_id);
            dest.writeString(createtime);
            dest.writeString(href);
            dest.writeString(id);
            dest.writeString(image);
            dest.writeString(isdelete);
            dest.writeString(status);
            dest.writeString(title);
        }
    }
}
