package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class CircleForm {
    private int code;
    private List<Circle> data;
    private String message;
    private PageDefault pagedefault;

    public int getCode() {
        return this.code;
    }

    public List<Circle> getData() {
        if (this.data == null) {
            return new ArrayList();
        }
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public PageDefault getPagedefault() {
        return this.pagedefault;
    }

    public static class Affix implements Parcelable {

        private String affix_filename;
        private long affix_filesize;
        private String affix_filethumb;
        private int height;
        private int isindex;
        private int width;

        public Affix() {
        }

        public static final Parcelable.Creator<Affix> CREATOR = new Parcelable.Creator() {
            public CircleForm.Affix createFromParcel(Parcel paramAnonymousParcel) {
                return new CircleForm.Affix(paramAnonymousParcel);
            }

            public CircleForm.Affix[] newArray(int paramAnonymousInt) {
                return new CircleForm.Affix[paramAnonymousInt];
            }
        };

        protected Affix(Parcel paramParcel) {
            this.width = paramParcel.readInt();
            this.height = paramParcel.readInt();
            this.affix_filename = paramParcel.readString();
            this.affix_filethumb = paramParcel.readString();
            this.affix_filesize = paramParcel.readLong();
            this.isindex = paramParcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public String getAffix_filename() {
            return this.affix_filename;
        }

        public long getAffix_filesize() {
            return this.affix_filesize;
        }

        public String getAffix_filethumb() {
            return this.affix_filethumb;
        }

        public int getHeight() {
            return this.height;
        }

        public int getIsindex() {
            return this.isindex;
        }

        public int getWidth() {
            return this.width;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeInt(this.width);
            paramParcel.writeInt(this.height);
            paramParcel.writeString(this.affix_filename);
            paramParcel.writeString(this.affix_filethumb);
            paramParcel.writeLong(this.affix_filesize);
            paramParcel.writeInt(this.isindex);
        }
    }

    public static class Circle implements Parcelable {
        private List<CircleForm.Affix> affix;
        private String circle_bigimg;
        private String circle_desc;
        private String circle_id;
        private String circle_name;
        private String circle_smallimg;
        private String circle_thcount;
        private String has_affix_url;
        private int have_collect;
        private int have_like;
        private int is_digest;
        private int is_recommend;
        private int isower;
        private String member_avatar;
        private String member_id;
        private String member_name;
        private String thclass_id;
        private String thclass_name;
        private String theme_addtime;
        private String theme_commentcount;
        private String theme_content;
        private String theme_id;
        private String theme_likecount;
        private String theme_name;

        public Circle() {
        }

        public static final Parcelable.Creator<Circle> CREATOR = new Parcelable.Creator() {
            public CircleForm.Circle createFromParcel(Parcel paramAnonymousParcel) {
                return new CircleForm.Circle(paramAnonymousParcel);
            }

            public CircleForm.Circle[] newArray(int paramAnonymousInt) {
                return new CircleForm.Circle[paramAnonymousInt];
            }
        };

        protected Circle(Parcel paramParcel) {
            this.circle_desc = paramParcel.readString();
            this.circle_smallimg = paramParcel.readString();
            this.circle_thcount = paramParcel.readString();
            this.circle_bigimg = paramParcel.readString();
            this.theme_id = paramParcel.readString();
            this.theme_name = paramParcel.readString();
            this.theme_content = paramParcel.readString();
            this.circle_id = paramParcel.readString();
            this.circle_name = paramParcel.readString();
            this.thclass_id = paramParcel.readString();
            this.thclass_name = paramParcel.readString();
            this.member_id = paramParcel.readString();
            this.member_name = paramParcel.readString();
            this.theme_likecount = paramParcel.readString();
            this.theme_commentcount = paramParcel.readString();
            this.has_affix_url = paramParcel.readString();
            this.affix = paramParcel.createTypedArrayList(CircleForm.Affix.CREATOR);
            this.isower = paramParcel.readInt();
            this.theme_addtime = paramParcel.readString();
            this.member_avatar = paramParcel.readString();
            this.have_collect = paramParcel.readInt();
            this.have_like = paramParcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public List<CircleForm.Affix> getAffix() {
            if (this.affix == null) {
                return new ArrayList();
            }
            return this.affix;
        }

        public String getCircle_bigimg() {
            return this.circle_bigimg;
        }

        public String getCircle_desc() {
            return this.circle_desc;
        }

        public String getCircle_id() {
            return this.circle_id;
        }

        public String getCircle_name() {
            return this.circle_name;
        }

        public String getCircle_smallimg() {
            if (this.circle_smallimg == null) {
                return "";
            }
            return this.circle_smallimg;
        }

        public String getCircle_thcount() {
            return this.circle_thcount;
        }

        public String getHas_affix_url() {
            return this.has_affix_url;
        }

        public int getHave_collect() {
            return this.have_collect;
        }

        public int getHave_like() {
            return this.have_like;
        }

        public int getIs_digest() {
            return this.is_digest;
        }

        public int getIs_recommend() {
            return this.is_recommend;
        }

        public int getIsower() {
            return this.isower;
        }

        public String getMember_avatar() {
            if (this.member_avatar == null) {
                return "";
            }
            return this.member_avatar;
        }

        public String getMember_id() {
            return this.member_id;
        }

        public String getMember_name() {
            return this.member_name;
        }

        public String getThclass_id() {
            return this.thclass_id;
        }

        public String getThclass_name() {
            return this.thclass_name;
        }

        public String getTheme_addtime() {
            return this.theme_addtime;
        }

        public String getTheme_commentcount() {
            return this.theme_commentcount;
        }

        public String getTheme_content() {
            return this.theme_content;
        }

        public String getTheme_id() {
            return this.theme_id;
        }

        public String getTheme_likecount() {
            return this.theme_likecount;
        }

        public String getTheme_name() {
            if (this.theme_name == null) {
                return "";
            }
            return this.theme_name;
        }

        public String toString() {
            return "Circle{circle_desc='" + this.circle_desc + '\'' + ", circle_smallimg='" + this.circle_smallimg + '\'' + ", circle_thcount='" + this.circle_thcount + '\'' + ", circle_bigimg='" + this.circle_bigimg + '\'' + ", theme_id='" + this.theme_id + '\'' + ", theme_name='" + this.theme_name + '\'' + ", theme_content='" + this.theme_content + '\'' + ", circle_id='" + this.circle_id + '\'' + ", circle_name='" + this.circle_name + '\'' + ", thclass_id='" + this.thclass_id + '\'' + ", thclass_name='" + this.thclass_name + '\'' + ", member_id='" + this.member_id + '\'' + ", member_name='" + this.member_name + '\'' + ", theme_likecount='" + this.theme_likecount + '\'' + ", theme_commentcount='" + this.theme_commentcount + '\'' + ", has_affix_url='" + this.has_affix_url + '\'' + ", affix=" + this.affix + ", isower=" + this.isower + ", theme_addtime='" + this.theme_addtime + '\'' + ", member_avatar='" + this.member_avatar + '\'' + ", have_collect=" + this.have_collect + ", have_like=" + this.have_like + ", is_digest=" + this.is_digest + ", is_recommend=" + this.is_recommend + '}';
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.circle_desc);
            paramParcel.writeString(this.circle_smallimg);
            paramParcel.writeString(this.circle_thcount);
            paramParcel.writeString(this.circle_bigimg);
            paramParcel.writeString(this.theme_id);
            paramParcel.writeString(this.theme_name);
            paramParcel.writeString(this.theme_content);
            paramParcel.writeString(this.circle_id);
            paramParcel.writeString(this.circle_name);
            paramParcel.writeString(this.thclass_id);
            paramParcel.writeString(this.thclass_name);
            paramParcel.writeString(this.member_id);
            paramParcel.writeString(this.member_name);
            paramParcel.writeString(this.theme_likecount);
            paramParcel.writeString(this.theme_commentcount);
            paramParcel.writeString(this.has_affix_url);
            paramParcel.writeTypedList(this.affix);
            paramParcel.writeInt(this.isower);
            paramParcel.writeString(this.theme_addtime);
            paramParcel.writeString(this.member_avatar);
            paramParcel.writeInt(this.have_collect);
            paramParcel.writeInt(this.have_like);
        }
    }
}
