package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class TopicDetailForm {
    private int code;
    private Data data;
    private String message;
    private PageDefault pagedefault;

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
        private String avatar;
        private List<TopicDetailForm.Reply> reply;
        private ShareMessage sharemessage;
        private CircleForm.Circle theme;

        public String getAvatar() {
            return this.avatar;
        }

        public List<TopicDetailForm.Reply> getReply() {
            if (this.reply == null) {
                return new ArrayList();
            }
            return this.reply;
        }

        public ShareMessage getSharemessage() {
            return this.sharemessage;
        }

        public CircleForm.Circle getTheme() {
            return this.theme;
        }
    }

    public static class Parent implements Parcelable {
        public static final Parcelable.Creator<Parent> CREATOR = new Parcelable.Creator() {
            public TopicDetailForm.Parent createFromParcel(Parcel paramAnonymousParcel) {
                return new TopicDetailForm.Parent(paramAnonymousParcel);
            }

            public TopicDetailForm.Parent[] newArray(int paramAnonymousInt) {
                return new TopicDetailForm.Parent[paramAnonymousInt];
            }
        };
        String member_name;
        String reply_content;

        public Parent() {
        }

        protected Parent(Parcel paramParcel) {
            this.member_name = paramParcel.readString();
            this.reply_content = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getMember_name() {
            return this.member_name;
        }

        public String getReply_content() {
            return this.reply_content;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.member_name);
            paramParcel.writeString(this.reply_content);
        }
    }

    public static class Reply implements Parcelable {
        public static final Parcelable.Creator<Reply> CREATOR = new Parcelable.Creator() {
            public TopicDetailForm.Reply createFromParcel(Parcel paramAnonymousParcel) {
                return new TopicDetailForm.Reply(paramAnonymousParcel);
            }

            public TopicDetailForm.Reply[] newArray(int paramAnonymousInt) {
                return new TopicDetailForm.Reply[paramAnonymousInt];
            }
        };
        private List<CircleForm.Affix> affix;
        private String circle_id;
        private int floor_number;
        private int has_affix;
        private int have_replylike;
        private int ishaveparent;
        private String member_avatar;
        private String member_id;
        private String member_name;
        private TopicDetailForm.Parent parent;
        private String reply_addtime;
        private String reply_content;
        private String reply_id;
        private String reply_likecount;
        private String reply_number;
        private String theme_id;

        public Reply() {
        }

        protected Reply(Parcel paramParcel) {
            this.theme_id = paramParcel.readString();
            this.reply_id = paramParcel.readString();
            this.circle_id = paramParcel.readString();
            this.member_id = paramParcel.readString();
            this.member_name = paramParcel.readString();
            this.reply_content = paramParcel.readString();
            this.reply_addtime = paramParcel.readString();
            this.member_avatar = paramParcel.readString();
            this.has_affix = paramParcel.readInt();
            this.ishaveparent = paramParcel.readInt();
            this.floor_number = paramParcel.readInt();
            this.reply_number = paramParcel.readString();
            this.reply_likecount = paramParcel.readString();
            this.parent = ((TopicDetailForm.Parent) paramParcel.readParcelable(TopicDetailForm.Parent.class.getClassLoader()));
            this.affix = paramParcel.createTypedArrayList(CircleForm.Affix.CREATOR);
            this.have_replylike = paramParcel.readInt();
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

        public String getCircle_id() {
            return this.circle_id;
        }

        public int getFloor_number() {
            return this.floor_number;
        }

        public int getHas_affix() {
            return this.has_affix;
        }

        public int getHave_like() {
            return this.have_replylike;
        }

        public int getIshaveparent() {
            return this.ishaveparent;
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

        public TopicDetailForm.Parent getParent() {
            return this.parent;
        }

        public String getReply_addtime() {
            return this.reply_addtime;
        }

        public String getReply_content() {
            return this.reply_content;
        }

        public String getReply_id() {
            return this.reply_id;
        }

        public String getReply_likecount() {
            return this.reply_likecount;
        }

        public String getReply_number() {
            return this.reply_number;
        }

        public String getTheme_id() {
            return this.theme_id;
        }

        public void setHave_replylike(int paramInt) {
            this.have_replylike = paramInt;
        }

        public void setReply_likecount(String paramString) {
            this.reply_likecount = paramString;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.theme_id);
            paramParcel.writeString(this.reply_id);
            paramParcel.writeString(this.circle_id);
            paramParcel.writeString(this.member_id);
            paramParcel.writeString(this.member_name);
            paramParcel.writeString(this.reply_content);
            paramParcel.writeString(this.reply_addtime);
            paramParcel.writeString(this.member_avatar);
            paramParcel.writeInt(this.has_affix);
            paramParcel.writeInt(this.ishaveparent);
            paramParcel.writeInt(this.floor_number);
            paramParcel.writeString(this.reply_number);
            paramParcel.writeString(this.reply_likecount);
            paramParcel.writeParcelable(this.parent, paramInt);
            paramParcel.writeTypedList(this.affix);
            paramParcel.writeInt(this.have_replylike);
        }
    }
}
