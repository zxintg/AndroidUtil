package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class SubjectForm {
    private int code;
    private List<Subject> data;
    private String message;
    private Page pagedefault;

    public int getCode() {
        return this.code;
    }

    public List<Subject> getData() {
        if (this.data == null) {
            return new ArrayList();
        }
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Page getPagedefault() {
        return this.pagedefault;
    }

    public static class Subject implements Parcelable {
        public static final Parcelable.Creator<Subject> CREATOR = new Parcelable.Creator() {
            public SubjectForm.Subject createFromParcel(Parcel paramAnonymousParcel) {
                return new SubjectForm.Subject(paramAnonymousParcel);
            }

            public SubjectForm.Subject[] newArray(int paramAnonymousInt) {
                return new SubjectForm.Subject[paramAnonymousInt];
            }
        };
        String content;
        String createtime;
        List<ShopClassBean.TaoBaoProduct> goods;
        String id;
        String pic_url;
        String title;

        public Subject() {
        }

        protected Subject(Parcel paramParcel) {
            this.goods = paramParcel.createTypedArrayList(ShopClassBean.TaoBaoProduct.CREATOR);
            this.pic_url = paramParcel.readString();
            this.title = paramParcel.readString();
            this.content = paramParcel.readString();
            this.id = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getContent() {
            return this.content;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public List<ShopClassBean.TaoBaoProduct> getGoods() {
            if (this.goods == null) {
                return new ArrayList();
            }
            return this.goods;
        }

        public String getId() {
            return this.id;
        }

        public String getPic_url() {
            return this.pic_url;
        }

        public String getTitle() {
            return this.title;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeTypedList(this.goods);
            paramParcel.writeString(this.pic_url);
            paramParcel.writeString(this.title);
            paramParcel.writeString(this.content);
            paramParcel.writeString(this.id);
        }
    }
}
