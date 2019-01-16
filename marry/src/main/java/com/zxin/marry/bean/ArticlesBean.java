package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/3.
 */

public class ArticlesBean {
    private String code;
    private String message;
    private Page page;
    private ArrayList<Posts> posts;
    private ArrayList<PostsIsTopRes> postsIsTopRes;
    private int recommendedCount;
    private String resultcount;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Page getPage() {
        return this.page;
    }

    public ArrayList<Posts> getPosts() {
        return this.posts;
    }

    public ArrayList<PostsIsTopRes> getPostsIsTopRes() {
        return this.postsIsTopRes;
    }

    public int getRecommendedCount() {
        return this.recommendedCount;
    }

    public String getResultcount() {
        return this.resultcount;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setPage(Page paramPage) {
        this.page = paramPage;
    }

    public void setPosts(ArrayList<Posts> paramArrayList) {
        this.posts = paramArrayList;
    }

    public void setPostsIsTopRes(ArrayList<PostsIsTopRes> paramArrayList) {
        this.postsIsTopRes = paramArrayList;
    }

    public void setRecommendedCount(int paramInt) {
        this.recommendedCount = paramInt;
    }

    public void setResultcount(String paramString) {
        this.resultcount = paramString;
    }

    public static class Page implements Parcelable {
        private int page;
        private int pagenumber;
        private String pagetime;

        protected Page(Parcel in) {
            page = in.readInt();
            pagenumber = in.readInt();
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

        public int getPagenumber() {
            return this.pagenumber;
        }

        public String getPagetime() {
            return this.pagetime;
        }

        public void setPage(int paramInt) {
            this.page = paramInt;
        }

        public void setPagenumber(int paramInt) {
            this.pagenumber = paramInt;
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
            dest.writeInt(pagenumber);
            dest.writeString(pagetime);
        }
    }

    public static class Posts implements Parcelable {
        private int comment_count;
        private String id;
        private int imgCount;
        private ArrayList<String> newSmeta;
        private String post_like;
        private String post_title;
        private String recommended;
        private ArticlesBean.Store store;
        private String storeids;
        private String tid;
        private String url;

        protected Posts(Parcel in) {
            comment_count = in.readInt();
            id = in.readString();
            imgCount = in.readInt();
            newSmeta = in.createStringArrayList();
            post_like = in.readString();
            post_title = in.readString();
            recommended = in.readString();
            store = in.readParcelable(Store.class.getClassLoader());
            storeids = in.readString();
            tid = in.readString();
            url = in.readString();
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

        public int getComment_count() {
            return this.comment_count;
        }

        public String getId() {
            return this.id;
        }

        public int getImgCount() {
            return this.imgCount;
        }

        public ArrayList<String> getNewSmeta() {
            return this.newSmeta;
        }

        public String getPost_like() {
            return this.post_like;
        }

        public String getPost_title() {
            return this.post_title;
        }

        public String getRecommended() {
            return this.recommended;
        }

        public ArticlesBean.Store getStore() {
            return this.store;
        }

        public String getStoreids() {
            return this.storeids;
        }

        public String getTid() {
            return this.tid;
        }

        public String getUrl() {
            return this.url;
        }

        public void setComment_count(int paramInt) {
            this.comment_count = paramInt;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setImgCount(int paramInt) {
            this.imgCount = paramInt;
        }

        public void setNewSmeta(ArrayList<String> paramArrayList) {
            this.newSmeta = paramArrayList;
        }

        public void setPost_like(String paramString) {
            this.post_like = paramString;
        }

        public void setPost_title(String paramString) {
            this.post_title = paramString;
        }

        public void setRecommended(String paramString) {
            this.recommended = paramString;
        }

        public void setStore(ArticlesBean.Store paramStore) {
            this.store = paramStore;
        }

        public void setStoreids(String paramString) {
            this.storeids = paramString;
        }

        public void setTid(String paramString) {
            this.tid = paramString;
        }

        public void setUrl(String paramString) {
            this.url = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(comment_count);
            dest.writeString(id);
            dest.writeInt(imgCount);
            dest.writeStringList(newSmeta);
            dest.writeString(post_like);
            dest.writeString(post_title);
            dest.writeString(recommended);
            dest.writeParcelable(store, flags);
            dest.writeString(storeids);
            dest.writeString(tid);
            dest.writeString(url);
        }
    }

    public static class PostsIsTopRes implements Parcelable {
        private String id;
        private String img;
        private String title;
        private String url;

        protected PostsIsTopRes(Parcel in) {
            id = in.readString();
            img = in.readString();
            title = in.readString();
            url = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(img);
            dest.writeString(title);
            dest.writeString(url);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<PostsIsTopRes> CREATOR = new Creator<PostsIsTopRes>() {
            @Override
            public PostsIsTopRes createFromParcel(Parcel in) {
                return new PostsIsTopRes(in);
            }

            @Override
            public PostsIsTopRes[] newArray(int size) {
                return new PostsIsTopRes[size];
            }
        };

        public String getId() {
            return this.id;
        }

        public String getImg() {
            return this.img;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setImg(String paramString) {
            this.img = paramString;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public void setUrl(String paramString) {
            this.url = paramString;
        }
    }

    public static class Store implements Parcelable {
        private String store_avatar;
        private String store_id;
        private String store_name;

        protected Store(Parcel in) {
            store_avatar = in.readString();
            store_id = in.readString();
            store_name = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(store_avatar);
            dest.writeString(store_id);
            dest.writeString(store_name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Store> CREATOR = new Creator<Store>() {
            @Override
            public Store createFromParcel(Parcel in) {
                return new Store(in);
            }

            @Override
            public Store[] newArray(int size) {
                return new Store[size];
            }
        };

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public void setStore_avatar(String paramString) {
            this.store_avatar = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }
    }
}
