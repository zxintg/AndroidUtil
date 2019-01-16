package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/7/5.
 */

public class HotelBean implements Parcelable{
    private String address;
    private String appintroduce;
    private String areaid;
    private String coord;
    private String corkagefee;
    private String coverimage;
    private String createtime;
    private String feastid;
    private String id;
    private String introduce;
    private String isdelete;
    private String isrecommend;
    private String latitude;
    private String lawn;
    private String listorder;
    private String longitude;
    private String name;
    private String operator;
    private String optionfeatureid;
    private String optionpriceid;
    private String optionsiteid;
    private String optiontableid;
    private String park;
    private Object parkisfree;
    private String price_max;
    private String price_min;
    private String servicecharge;
    private String slottingfee;
    private String status;
    private String table_max;
    private String tel;
    private int typea;
    private int typeb;
    private int typec;
    private String weddingroom;

    protected HotelBean(Parcel in) {
        address = in.readString();
        appintroduce = in.readString();
        areaid = in.readString();
        coord = in.readString();
        corkagefee = in.readString();
        coverimage = in.readString();
        createtime = in.readString();
        feastid = in.readString();
        id = in.readString();
        introduce = in.readString();
        isdelete = in.readString();
        isrecommend = in.readString();
        latitude = in.readString();
        lawn = in.readString();
        listorder = in.readString();
        longitude = in.readString();
        name = in.readString();
        operator = in.readString();
        optionfeatureid = in.readString();
        optionpriceid = in.readString();
        optionsiteid = in.readString();
        optiontableid = in.readString();
        park = in.readString();
        price_max = in.readString();
        price_min = in.readString();
        servicecharge = in.readString();
        slottingfee = in.readString();
        status = in.readString();
        table_max = in.readString();
        tel = in.readString();
        typea = in.readInt();
        typeb = in.readInt();
        typec = in.readInt();
        weddingroom = in.readString();
    }

    public static final Creator<HotelBean> CREATOR = new Creator<HotelBean>() {
        @Override
        public HotelBean createFromParcel(Parcel in) {
            return new HotelBean(in);
        }

        @Override
        public HotelBean[] newArray(int size) {
            return new HotelBean[size];
        }
    };

    public String getAddress() {
        return this.address;
    }

    public String getAppintroduce() {
        return this.appintroduce;
    }

    public String getAreaid() {
        return this.areaid;
    }

    public String getCoord() {
        return this.coord;
    }

    public String getCorkagefee() {
        return this.corkagefee;
    }

    public String getCoverimage() {
        return this.coverimage;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getFeastid() {
        return this.feastid;
    }

    public String getId() {
        return this.id;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public String getIsdelete() {
        return this.isdelete;
    }

    public String getIsrecommend() {
        return this.isrecommend;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLawn() {
        return this.lawn;
    }

    public String getListorder() {
        return this.listorder;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getOptionfeatureid() {
        return this.optionfeatureid;
    }

    public String getOptionpriceid() {
        return this.optionpriceid;
    }

    public String getOptionsiteid() {
        return this.optionsiteid;
    }

    public String getOptiontableid() {
        return this.optiontableid;
    }

    public String getPark() {
        return this.park;
    }

    public Object getParkisfree() {
        return this.parkisfree;
    }

    public String getPrice_max() {
        return this.price_max;
    }

    public String getPrice_min() {
        return this.price_min;
    }

    public String getServicecharge() {
        return this.servicecharge;
    }

    public String getSlottingfee() {
        return this.slottingfee;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTable_max() {
        return this.table_max;
    }

    public String getTel() {
        return this.tel;
    }

    public int getTypea() {
        return this.typea;
    }

    public int getTypeb() {
        return this.typeb;
    }

    public int getTypec() {
        return this.typec;
    }

    public String getWeddingroom() {
        return this.weddingroom;
    }

    public void setAddress(String paramString) {
        this.address = paramString;
    }

    public void setAppintroduce(String paramString) {
        this.appintroduce = paramString;
    }

    public void setAreaid(String paramString) {
        this.areaid = paramString;
    }

    public void setCoord(String paramString) {
        this.coord = paramString;
    }

    public void setCorkagefee(String paramString) {
        this.corkagefee = paramString;
    }

    public void setCoverimage(String paramString) {
        this.coverimage = paramString;
    }

    public void setCreatetime(String paramString) {
        this.createtime = paramString;
    }

    public void setFeastid(String paramString) {
        this.feastid = paramString;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setIntroduce(String paramString) {
        this.introduce = paramString;
    }

    public void setIsdelete(String paramString) {
        this.isdelete = paramString;
    }

    public void setIsrecommend(String paramString) {
        this.isrecommend = paramString;
    }

    public void setLatitude(String paramString) {
        this.latitude = paramString;
    }

    public void setLawn(String paramString) {
        this.lawn = paramString;
    }

    public void setListorder(String paramString) {
        this.listorder = paramString;
    }

    public void setLongitude(String paramString) {
        this.longitude = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOperator(String paramString) {
        this.operator = paramString;
    }

    public void setOptionfeatureid(String paramString) {
        this.optionfeatureid = paramString;
    }

    public void setOptionpriceid(String paramString) {
        this.optionpriceid = paramString;
    }

    public void setOptionsiteid(String paramString) {
        this.optionsiteid = paramString;
    }

    public void setOptiontableid(String paramString) {
        this.optiontableid = paramString;
    }

    public void setPark(String paramString) {
        this.park = paramString;
    }

    public void setParkisfree(Object paramObject) {
        this.parkisfree = paramObject;
    }

    public void setPrice_max(String paramString) {
        this.price_max = paramString;
    }

    public void setPrice_min(String paramString) {
        this.price_min = paramString;
    }

    public void setServicecharge(String paramString) {
        this.servicecharge = paramString;
    }

    public void setSlottingfee(String paramString) {
        this.slottingfee = paramString;
    }

    public void setStatus(String paramString) {
        this.status = paramString;
    }

    public void setTable_max(String paramString) {
        this.table_max = paramString;
    }

    public void setTel(String paramString) {
        this.tel = paramString;
    }

    public void setTypea(int paramInt) {
        this.typea = paramInt;
    }

    public void setTypeb(int paramInt) {
        this.typeb = paramInt;
    }

    public void setTypec(int paramInt) {
        this.typec = paramInt;
    }

    public void setWeddingroom(String paramString) {
        this.weddingroom = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(appintroduce);
        dest.writeString(areaid);
        dest.writeString(coord);
        dest.writeString(corkagefee);
        dest.writeString(coverimage);
        dest.writeString(createtime);
        dest.writeString(feastid);
        dest.writeString(id);
        dest.writeString(introduce);
        dest.writeString(isdelete);
        dest.writeString(isrecommend);
        dest.writeString(latitude);
        dest.writeString(lawn);
        dest.writeString(listorder);
        dest.writeString(longitude);
        dest.writeString(name);
        dest.writeString(operator);
        dest.writeString(optionfeatureid);
        dest.writeString(optionpriceid);
        dest.writeString(optionsiteid);
        dest.writeString(optiontableid);
        dest.writeString(park);
        dest.writeString(price_max);
        dest.writeString(price_min);
        dest.writeString(servicecharge);
        dest.writeString(slottingfee);
        dest.writeString(status);
        dest.writeString(table_max);
        dest.writeString(tel);
        dest.writeInt(typea);
        dest.writeInt(typeb);
        dest.writeInt(typec);
        dest.writeString(weddingroom);
    }
}
