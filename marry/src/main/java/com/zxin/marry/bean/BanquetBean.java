package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/7/5.
 */

public class BanquetBean implements Parcelable{
    private String banquet_area;
    private String banquet_height;
    private String banquet_logo;
    private String banquet_shape;
    private String column_sum;
    private String createtime;
    private String feastid;
    private String hotel_desc;
    private String hotelid;
    private String id;
    private String isdelete;
    private String listorder;
    private String name;
    private String optionfeatureid;
    private String optiontableid;
    private String price;
    private String stage_long;
    private String stage_wide;

    protected BanquetBean(Parcel in) {
        banquet_area = in.readString();
        banquet_height = in.readString();
        banquet_logo = in.readString();
        banquet_shape = in.readString();
        column_sum = in.readString();
        createtime = in.readString();
        feastid = in.readString();
        hotel_desc = in.readString();
        hotelid = in.readString();
        id = in.readString();
        isdelete = in.readString();
        listorder = in.readString();
        name = in.readString();
        optionfeatureid = in.readString();
        optiontableid = in.readString();
        price = in.readString();
        stage_long = in.readString();
        stage_wide = in.readString();
    }

    public static final Creator<BanquetBean> CREATOR = new Creator<BanquetBean>() {
        @Override
        public BanquetBean createFromParcel(Parcel in) {
            return new BanquetBean(in);
        }

        @Override
        public BanquetBean[] newArray(int size) {
            return new BanquetBean[size];
        }
    };

    public String getBanquet_area() {
        return this.banquet_area;
    }

    public String getBanquet_height() {
        return this.banquet_height;
    }

    public String getBanquet_logo() {
        return this.banquet_logo;
    }

    public String getBanquet_shape() {
        return this.banquet_shape;
    }

    public String getColumn_sum() {
        if (this.column_sum.equals("0")) {
            this.column_sum = "无";
        }
        return this.column_sum;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getFeastid() {
        return this.feastid;
    }

    public String getHotel_desc() {
        return this.hotel_desc;
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

    public String getListorder() {
        return this.listorder;
    }

    public String getName() {
        return this.name;
    }

    public String getOptionfeatureid() {
        return this.optionfeatureid;
    }

    public String getOptiontableid() {
        return this.optiontableid;
    }

    public String getPrice() {
        return this.price;
    }

    public String getStage_long() {
        return this.stage_long;
    }

    public String getStage_wide() {
        return this.stage_wide;
    }

    public void setBanquet_area(String paramString) {
        this.banquet_area = paramString;
    }

    public void setBanquet_height(String paramString) {
        this.banquet_height = paramString;
    }

    public void setBanquet_logo(String paramString) {
        this.banquet_logo = paramString;
    }

    public void setBanquet_shape(String paramString) {
        this.banquet_shape = paramString;
    }

    public void setColumn_sum(String paramString) {
        this.column_sum = paramString;
    }

    public void setCreatetime(String paramString) {
        this.createtime = paramString;
    }

    public void setFeastid(String paramString) {
        this.feastid = paramString;
    }

    public void setHotel_desc(String paramString) {
        this.hotel_desc = paramString;
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

    public void setListorder(String paramString) {
        this.listorder = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOptionfeatureid(String paramString) {
        this.optionfeatureid = paramString;
    }

    public void setOptiontableid(String paramString) {
        this.optiontableid = paramString;
    }

    public void setPrice(String paramString) {
        this.price = paramString;
    }

    public void setStage_long(String paramString) {
        this.stage_long = paramString;
    }

    public void setStage_wide(String paramString) {
        this.stage_wide = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(banquet_area);
        dest.writeString(banquet_height);
        dest.writeString(banquet_logo);
        dest.writeString(banquet_shape);
        dest.writeString(column_sum);
        dest.writeString(createtime);
        dest.writeString(feastid);
        dest.writeString(hotel_desc);
        dest.writeString(hotelid);
        dest.writeString(id);
        dest.writeString(isdelete);
        dest.writeString(listorder);
        dest.writeString(name);
        dest.writeString(optionfeatureid);
        dest.writeString(optiontableid);
        dest.writeString(price);
        dest.writeString(stage_long);
        dest.writeString(stage_wide);
    }
}
