package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/7/5.
 */

public class CookbookBean implements Parcelable{
    private String banquetid;
    private String createtime;
    private String feastid;
    private String hotelid;
    private String id;
    private String isdelete;
    private String isrecommend;
    private String listorder;
    private String name;
    private String operator;
    private String price;

    protected CookbookBean(Parcel in) {
        banquetid = in.readString();
        createtime = in.readString();
        feastid = in.readString();
        hotelid = in.readString();
        id = in.readString();
        isdelete = in.readString();
        isrecommend = in.readString();
        listorder = in.readString();
        name = in.readString();
        operator = in.readString();
        price = in.readString();
    }

    public static final Creator<CookbookBean> CREATOR = new Creator<CookbookBean>() {
        @Override
        public CookbookBean createFromParcel(Parcel in) {
            return new CookbookBean(in);
        }

        @Override
        public CookbookBean[] newArray(int size) {
            return new CookbookBean[size];
        }
    };

    public String getBanquetid() {
        return this.banquetid;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getFeastid() {
        return this.feastid;
    }

    public String getHotelid() {
        return this.hotelid;
    }

    public String getId() {
        return this.id;
    }

    public String getIsdelete() {
        return this.isdelete;
    }

    public String getIsrecommend() {
        return this.isrecommend;
    }

    public String getListorder() {
        return this.listorder;
    }

    public String getName() {
        return this.name;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getPrice() {
        return this.price;
    }

    public void setBanquetid(String paramString) {
        this.banquetid = paramString;
    }

    public void setCreatetime(String paramString) {
        this.createtime = paramString;
    }

    public void setFeastid(String paramString) {
        this.feastid = paramString;
    }

    public void setHotelid(String paramString) {
        this.hotelid = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setIsdelete(String paramString) {
        this.isdelete = paramString;
    }

    public void setIsrecommend(String paramString) {
        this.isrecommend = paramString;
    }

    public void setListorder(String paramString) {
        this.listorder = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOperator(String paramString) {
        this.operator = paramString;
    }

    public void setPrice(String paramString) {
        this.price = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(banquetid);
        dest.writeString(createtime);
        dest.writeString(feastid);
        dest.writeString(hotelid);
        dest.writeString(id);
        dest.writeString(isdelete);
        dest.writeString(isrecommend);
        dest.writeString(listorder);
        dest.writeString(name);
        dest.writeString(operator);
        dest.writeString(price);
    }
}
