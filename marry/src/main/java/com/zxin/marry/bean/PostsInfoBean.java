package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/7/3.
 */

public class PostsInfoBean {
    private String code;
    private String message;
    private Posts posts;
    private ShareMessage sharemessage;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Posts getPosts() {
        return this.posts;
    }

    public ShareMessage getSharemessage() {
        return this.sharemessage;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setPosts(Posts paramPosts) {
        this.posts = paramPosts;
    }

    public static class Posts implements Parcelable {
        private String comment_count;
        private String commented_status;
        private String like_status;
        private String post_hits;
        private String post_like;
        private String post_title;

        protected Posts(Parcel in) {
            comment_count = in.readString();
            commented_status = in.readString();
            like_status = in.readString();
            post_hits = in.readString();
            post_like = in.readString();
            post_title = in.readString();
        }

        public static final Creator<Posts> CREATOR = new Creator<Posts>() {
            @Override
            public Posts createFromParcel(Parcel in) {
                return new Posts(in);
            }

            @Override
            public Posts[] newArray(int size) {
                return new Posts[size];
            }
        };

        public String getComment_count() {
            return this.comment_count;
        }

        public String getCommented_status() {
            return this.commented_status;
        }

        public String getLike_status() {
            return this.like_status;
        }

        public String getPost_hits() {
            return this.post_hits;
        }

        public String getPost_like() {
            return this.post_like;
        }

        public String getPost_title() {
            return this.post_title;
        }

        public void setComment_count(String paramString) {
            this.comment_count = paramString;
        }

        public void setCommented_status(String paramString) {
            this.commented_status = paramString;
        }

        public void setLike_status(String paramString) {
            this.like_status = paramString;
        }

        public void setPost_hits(String paramString) {
            this.post_hits = paramString;
        }

        public void setPost_like(String paramString) {
            this.post_like = paramString;
        }

        public void setPost_title(String paramString) {
            this.post_title = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(comment_count);
            dest.writeString(commented_status);
            dest.writeString(like_status);
            dest.writeString(post_hits);
            dest.writeString(post_like);
            dest.writeString(post_title);
        }
    }
}
