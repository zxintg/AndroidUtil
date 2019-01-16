package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class TopicForm {
    int code;
    Data data;
    String message;
    PageDefault pagedefault;

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public PageDefault getPagedefault() {
        return this.pagedefault;
    }

    public static class Data {
        private List<RecommendForm.RecommendAdv> adv;
        CircleForm.Circle circle;
        List<TopicForm.Theme> stick_themes;
        List<LabelForm.Label> thclasses;
        List<TopicForm.Theme> themes;

        public List<RecommendForm.RecommendAdv> getAdv() {
            if (this.adv == null) {
                return new ArrayList();
            }
            return this.adv;
        }

        public CircleForm.Circle getCircle() {
            return this.circle;
        }

        public List<TopicForm.Theme> getStick_themes() {
            if (this.stick_themes == null) {
                return new ArrayList();
            }
            return this.stick_themes;
        }

        public List<LabelForm.Label> getThclasses() {
            if (this.thclasses == null) {
                return new ArrayList();
            }
            return this.thclasses;
        }

        public List<TopicForm.Theme> getThemes() {
            if (this.themes == null) {
                return new ArrayList();
            }
            return this.themes;
        }
    }

    public static class Theme implements Parcelable {
        public static final Parcelable.Creator<Theme> CREATOR = new Parcelable.Creator() {
            public TopicForm.Theme createFromParcel(Parcel paramAnonymousParcel) {
                return new TopicForm.Theme(paramAnonymousParcel);
            }

            public TopicForm.Theme[] newArray(int paramAnonymousInt) {
                return new TopicForm.Theme[paramAnonymousInt];
            }
        };
        private String circle_id;
        private String circle_name;
        private String collecttime;
        private int has_affix;
        private String has_affix_url;
        private int is_digest;
        private String member_avatar;
        private String member_id;
        private String member_name;
        private int position;
        private String thclass_name;
        private String theme_addtime;
        private String theme_commentcount;
        private String theme_content;
        private String theme_id;
        private String theme_likecount;
        private String theme_name;

        public Theme() {

        }

        protected Theme(Parcel paramParcel) {
            this.theme_id = paramParcel.readString();
            this.theme_name = paramParcel.readString();
            this.theme_content = paramParcel.readString();
            this.thclass_name = paramParcel.readString();
            this.member_id = paramParcel.readString();
            this.member_name = paramParcel.readString();
            this.theme_likecount = paramParcel.readString();
            this.theme_commentcount = paramParcel.readString();
            this.is_digest = paramParcel.readInt();
            this.has_affix = paramParcel.readInt();
            this.has_affix_url = paramParcel.readString();
            this.member_avatar = paramParcel.readString();
            this.circle_id = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getCircle_id() {
            return this.circle_id;
        }

        public String getCircle_name() {
            return this.circle_name;
        }

        public String getCollecttime() {
            return this.collecttime;
        }

        public int getHas_affix() {
            return this.has_affix;
        }

        public String getHas_affix_url() {
            if (this.has_affix_url == null) {
                return "";
            }
            return this.has_affix_url;
        }

        public int getIs_digest() {
            return this.is_digest;
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

        public int getPosition() {
            return this.position;
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
            return this.theme_name;
        }

        public void setPosition(int paramInt) {
            this.position = paramInt;
        }

        public void setTheme_id(String paramString) {
            this.theme_id = paramString;
        }

        public String toString() {
            return "Theme{theme_id='" + this.theme_id + '\'' + ", theme_name='" + this.theme_name + '\'' + ", theme_content='" + this.theme_content + '\'' + ", thclass_name='" + this.thclass_name + '\'' + ", member_id='" + this.member_id + '\'' + ", member_name='" + this.member_name + '\'' + ", theme_likecount='" + this.theme_likecount + '\'' + ", theme_commentcount='" + this.theme_commentcount + '\'' + ", is_digest=" + this.is_digest + ", has_affix=" + this.has_affix + ", has_affix_url='" + this.has_affix_url + '\'' + ", member_avatar='" + this.member_avatar + '\'' + ", circle_id='" + this.circle_id + '\'' + ", theme_addtime='" + this.theme_addtime + '\'' + ", collecttime='" + this.collecttime + '\'' + ", circle_name='" + this.circle_name + '\'' + ", position=" + this.position + '}';
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.theme_id);
            paramParcel.writeString(this.theme_name);
            paramParcel.writeString(this.theme_content);
            paramParcel.writeString(this.thclass_name);
            paramParcel.writeString(this.member_id);
            paramParcel.writeString(this.member_name);
            paramParcel.writeString(this.theme_likecount);
            paramParcel.writeString(this.theme_commentcount);
            paramParcel.writeInt(this.is_digest);
            paramParcel.writeInt(this.has_affix);
            paramParcel.writeString(this.has_affix_url);
            paramParcel.writeString(this.member_avatar);
            paramParcel.writeString(this.circle_id);
        }
    }
}
