package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/30.
 */

public class CaseBean implements Parcelable {
    private String case_collect;
    private List<?> case_comment;
    private String case_descr;
    private String case_evaluation_count;
    private String case_id;
    private String case_image;
    private String case_images;
    private List<CaseListBean> case_list;
    private String case_status;
    private String case_title;
    private int height;
    private int iscancel;
    private String store_id;
    private int width;

    protected CaseBean(Parcel in) {
        case_collect = in.readString();
        case_descr = in.readString();
        case_evaluation_count = in.readString();
        case_id = in.readString();
        case_image = in.readString();
        case_images = in.readString();
        case_status = in.readString();
        case_title = in.readString();
        height = in.readInt();
        iscancel = in.readInt();
        store_id = in.readString();
        width = in.readInt();
    }

    public static final Creator<CaseBean> CREATOR = new Creator<CaseBean>() {
        @Override
        public CaseBean createFromParcel(Parcel in) {
            return new CaseBean(in);
        }

        @Override
        public CaseBean[] newArray(int size) {
            return new CaseBean[size];
        }
    };

    public String getCase_collect() {
        return this.case_collect;
    }

    public List<?> getCase_comment() {
        return this.case_comment;
    }

    public String getCase_descr() {
        return this.case_descr;
    }

    public String getCase_evaluation_count() {
        return this.case_evaluation_count;
    }

    public String getCase_id() {
        return this.case_id;
    }

    public String getCase_image() {
        return this.case_image;
    }

    public String getCase_images() {
        return this.case_images;
    }

    public List<CaseListBean> getCase_list() {
        return this.case_list;
    }

    public String getCase_status() {
        return this.case_status;
    }

    public String getCase_title() {
        return this.case_title;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIscancel() {
        return this.iscancel;
    }

    public String getStore_id() {
        return this.store_id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCase_collect(String paramString) {
        this.case_collect = paramString;
    }

    public void setCase_comment(List<?> paramList) {
        this.case_comment = paramList;
    }

    public void setCase_descr(String paramString) {
        this.case_descr = paramString;
    }

    public void setCase_evaluation_count(String paramString) {
        this.case_evaluation_count = paramString;
    }

    public void setCase_id(String paramString) {
        this.case_id = paramString;
    }

    public void setCase_image(String paramString) {
        this.case_image = paramString;
    }

    public void setCase_images(String paramString) {
        this.case_images = paramString;
    }

    public void setCase_list(List<CaseListBean> paramList) {
        this.case_list = paramList;
    }

    public void setCase_status(String paramString) {
        this.case_status = paramString;
    }

    public void setCase_title(String paramString) {
        this.case_title = paramString;
    }

    public void setIscancel(int paramInt) {
        this.iscancel = paramInt;
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
        dest.writeString(case_collect);
        dest.writeString(case_descr);
        dest.writeString(case_evaluation_count);
        dest.writeString(case_id);
        dest.writeString(case_image);
        dest.writeString(case_images);
        dest.writeString(case_status);
        dest.writeString(case_title);
        dest.writeInt(height);
        dest.writeInt(iscancel);
        dest.writeString(store_id);
        dest.writeInt(width);
    }

    public static class CaseListBean {
        private String case_image;
        private String content;

        public String getCase_image() {
            return this.case_image;
        }

        public String getContent() {
            return this.content;
        }

        public void setCase_image(String paramString) {
            this.case_image = paramString;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }
    }
}
