package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/19.
 */

public class OrderBean implements Parcelable {
    private String actid;
    private String bookdressdate;
    private String bookdressdate_status;
    private String camer_status;
    private String cameramandid;
    private String dresserid;
    private String getphotodate;
    private String getphotodate_status;
    private String imgsrc;
    private String isstate;
    private String name;
    private String orderid;
    private String orderkey;
    private String orderstatus;
    private String photodate;
    private String photodate2;
    private String photodate_status;
    private String price;
    private String selectphotodate;
    private String selectphotodate_status;
    private String shopid;
    private String shopname;
    private int tasknum;

    protected OrderBean(Parcel in) {
        actid = in.readString();
        bookdressdate = in.readString();
        bookdressdate_status = in.readString();
        camer_status = in.readString();
        cameramandid = in.readString();
        dresserid = in.readString();
        getphotodate = in.readString();
        getphotodate_status = in.readString();
        imgsrc = in.readString();
        isstate = in.readString();
        name = in.readString();
        orderid = in.readString();
        orderkey = in.readString();
        orderstatus = in.readString();
        photodate = in.readString();
        photodate2 = in.readString();
        photodate_status = in.readString();
        price = in.readString();
        selectphotodate = in.readString();
        selectphotodate_status = in.readString();
        shopid = in.readString();
        shopname = in.readString();
        tasknum = in.readInt();
    }

    public static final Creator<OrderBean> CREATOR = new Creator<OrderBean>() {
        @Override
        public OrderBean createFromParcel(Parcel in) {
            return new OrderBean(in);
        }

        @Override
        public OrderBean[] newArray(int size) {
            return new OrderBean[size];
        }
    };

    public String getActid() {
        return this.actid;
    }

    public String getBookdressdate() {
        return this.bookdressdate;
    }

    public String getBookdressdate_status() {
        return this.bookdressdate_status;
    }

    public String getCamer_status() {
        return this.camer_status;
    }

    public String getCameramandid() {
        return this.cameramandid;
    }

    public String getDresserid() {
        return this.dresserid;
    }

    public String getGetphotodate() {
        return this.getphotodate;
    }

    public String getGetphotodate_status() {
        return this.getphotodate_status;
    }

    public String getImgsrc() {
        return this.imgsrc;
    }

    public String getIsstate() {
        return this.isstate;
    }

    public String getName() {
        return this.name;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public String getOrderkey() {
        return this.orderkey;
    }

    public String getOrderstatus() {
        return this.orderstatus;
    }

    public String getPhotodate() {
        return this.photodate;
    }

    public String getPhotodate2() {
        return this.photodate2;
    }

    public String getPhotodate_status() {
        return this.photodate_status;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSelectphotodate() {
        return this.selectphotodate;
    }

    public String getSelectphotodate_status() {
        return this.selectphotodate_status;
    }

    public String getShopid() {
        return this.shopid;
    }

    public String getShopname() {
        return this.shopname;
    }

    public int getTasknum() {
        return this.tasknum;
    }

    public void setActid(String paramString) {
        this.actid = paramString;
    }

    public void setBookdressdate(String paramString) {
        this.bookdressdate = paramString;
    }

    public void setBookdressdate_status(String paramString) {
        this.bookdressdate_status = paramString;
    }

    public void setCamer_status(String paramString) {
        this.camer_status = paramString;
    }

    public void setCameramandid(String paramString) {
        this.cameramandid = paramString;
    }

    public void setDresserid(String paramString) {
        this.dresserid = paramString;
    }

    public void setGetphotodate(String paramString) {
        this.getphotodate = paramString;
    }

    public void setGetphotodate_status(String paramString) {
        this.getphotodate_status = paramString;
    }

    public void setImgsrc(String paramString) {
        this.imgsrc = paramString;
    }

    public void setIsstate(String paramString) {
        this.isstate = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOrderid(String paramString) {
        this.orderid = paramString;
    }

    public void setOrderkey(String paramString) {
        this.orderkey = paramString;
    }

    public void setOrderstatus(String paramString) {
        this.orderstatus = paramString;
    }

    public void setPhotodate(String paramString) {
        this.photodate = paramString;
    }

    public void setPhotodate2(String paramString) {
        this.photodate2 = paramString;
    }

    public void setPhotodate_status(String paramString) {
        this.photodate_status = paramString;
    }

    public void setPrice(String paramString) {
        this.price = paramString;
    }

    public void setSelectphotodate(String paramString) {
        this.selectphotodate = paramString;
    }

    public void setSelectphotodate_status(String paramString) {
        this.selectphotodate_status = paramString;
    }

    public void setShopid(String paramString) {
        this.shopid = paramString;
    }

    public void setShopname(String paramString) {
        this.shopname = paramString;
    }

    public void setTasknum(int paramInt) {
        this.tasknum = paramInt;
    }

    public String toString() {
        return "OrderBean{orderid='" + this.orderid + '\'' + ", orderstatus='" + this.orderstatus + '\'' + ", shopid='" + this.shopid + '\'' + ", photodate='" + this.photodate + '\'' + ", photodate2='" + this.photodate2 + '\'' + ", cameramandid='" + this.cameramandid + '\'' + ", dresserid='" + this.dresserid + '\'' + ", bookdressdate='" + this.bookdressdate + '\'' + ", selectphotodate='" + this.selectphotodate + '\'' + ", getphotodate='" + this.getphotodate + '\'' + ", actid='" + this.actid + '\'' + ", name='" + this.name + '\'' + ", price='" + this.price + '\'' + ", imgsrc='" + this.imgsrc + '\'' + ", orderkey='" + this.orderkey + '\'' + ", photodate_status='" + this.photodate_status + '\'' + ", camer_status='" + this.camer_status + '\'' + ", bookdressdate_status='" + this.bookdressdate_status + '\'' + ", selectphotodate_status='" + this.selectphotodate_status + '\'' + ", getphotodate_status='" + this.getphotodate_status + '\'' + ", tasknum=" + this.tasknum + '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(actid);
        dest.writeString(bookdressdate);
        dest.writeString(bookdressdate_status);
        dest.writeString(camer_status);
        dest.writeString(cameramandid);
        dest.writeString(dresserid);
        dest.writeString(getphotodate);
        dest.writeString(getphotodate_status);
        dest.writeString(imgsrc);
        dest.writeString(isstate);
        dest.writeString(name);
        dest.writeString(orderid);
        dest.writeString(orderkey);
        dest.writeString(orderstatus);
        dest.writeString(photodate);
        dest.writeString(photodate2);
        dest.writeString(photodate_status);
        dest.writeString(price);
        dest.writeString(selectphotodate);
        dest.writeString(selectphotodate_status);
        dest.writeString(shopid);
        dest.writeString(shopname);
        dest.writeInt(tasknum);
    }
}
