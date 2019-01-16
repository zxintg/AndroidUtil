package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/3.
 */

public class StoreCommentList {
    private int code;
    private ArrayList<Comment> comments;
    private String message;
    private Page page;
    private String resultcount;

    public int getCode() {
        return this.code;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public String getMessage() {
        return this.message;
    }

    public Page getPage() {
        return this.page;
    }

    public String getResultcount() {
        return this.resultcount;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setComments(ArrayList<Comment> paramArrayList) {
        this.comments = paramArrayList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setPage(Page paramPage) {
        this.page = paramPage;
    }

    public void setResultcount(String paramString) {
        this.resultcount = paramString;
    }

    public static class Comment implements Parcelable {
        private String content;
        private String createtime;
        private String id;
        private ArrayList<String> imgs;
        private String member_avatar;
        private String member_id;
        private String member_truename;
        private String price;
        private int score;
        private String status;
        private String store_id;

        protected Comment(Parcel in) {
            content = in.readString();
            createtime = in.readString();
            id = in.readString();
            imgs = in.createStringArrayList();
            member_avatar = in.readString();
            member_id = in.readString();
            member_truename = in.readString();
            price = in.readString();
            score = in.readInt();
            status = in.readString();
            store_id = in.readString();
        }

        public static final Creator<Comment> CREATOR = new Creator<Comment>() {
            @Override
            public Comment createFromParcel(Parcel in) {
                return new Comment(in);
            }

            @Override
            public Comment[] newArray(int size) {
                return new Comment[size];
            }
        };

        public String getContent() {
            return this.content;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public String getId() {
            return this.id;
        }

        public ArrayList<String> getImgs() {
            return this.imgs;
        }

        public String getMember_avatar() {
            return this.member_avatar;
        }

        public String getMember_id() {
            return this.member_id;
        }

        public String getMember_truename() {
            return this.member_truename;
        }

        public String getPrice() {
            return this.price;
        }

        public int getScore() {
            return this.score;
        }

        public String getStatus() {
            return this.status;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setImgs(ArrayList<String> paramArrayList) {
            this.imgs = paramArrayList;
        }

        public void setMember_avatar(String paramString) {
            this.member_avatar = paramString;
        }

        public void setMember_id(String paramString) {
            this.member_id = paramString;
        }

        public void setMember_truename(String paramString) {
            this.member_truename = paramString;
        }

        public void setPrice(String paramString) {
            this.price = paramString;
        }

        public void setScore(int paramInt) {
            this.score = paramInt;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(content);
            dest.writeString(createtime);
            dest.writeString(id);
            dest.writeStringList(imgs);
            dest.writeString(member_avatar);
            dest.writeString(member_id);
            dest.writeString(member_truename);
            dest.writeString(price);
            dest.writeInt(score);
            dest.writeString(status);
            dest.writeString(store_id);
        }
    }

    public static class Page implements Parcelable {
        private int page;
        private String pagenumber;
        private String pagetime;

        protected Page(Parcel in) {
            page = in.readInt();
            pagenumber = in.readString();
            pagetime = in.readString();
        }

        public static final Creator<Page> CREATOR = new Creator<Page>() {
            @Override
            public Page createFromParcel(Parcel in) {
                return new Page(in);
            }

            @Override
            public Page[] newArray(int size) {
                return new Page[size];
            }
        };

        public int getPage() {
            return this.page;
        }

        public String getPagenumber() {
            return this.pagenumber;
        }

        public String getPagetime() {
            return this.pagetime;
        }

        public void setPage(int paramInt) {
            this.page = paramInt;
        }

        public void setPagenumber(String paramString) {
            this.pagenumber = paramString;
        }

        public void setPagetime(String paramString) {
            this.pagetime = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(page);
            dest.writeString(pagenumber);
            dest.writeString(pagetime);
        }
    }
}
