package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */

public class Camera implements Parcelable {
    public static final Parcelable.Creator<Camera> CREATOR = new Parcelable.Creator() {
        public Camera createFromParcel(Parcel paramAnonymousParcel) {
            return new Camera(paramAnonymousParcel);
        }

        public Camera[] newArray(int paramAnonymousInt) {
            return new Camera[paramAnonymousInt];
        }
    };
    private double appointfee;
    private String avatar;
    private String bgpic;
    private String booktime;
    private String camer;
    private String ceratetime;
    private String count;
    private String edittime;
    private String eid;
    private int followers;
    private String honor;
    private String id;
    private int isbooking;
    private String isdelete;
    private int isfollow;
    private String ison;
    private String name;
    private String nickname;
    private String offtime;
    private String ontime;
    private String paytime;
    private String photodate;
    private List<CameraProduct> production;
    private String resume;
    private String satisfaction;
    private int score;
    private boolean selected;
    private String shopid;
    private String sign;
    private String summary;
    private String transactionnumber;

    public Camera() {
    }

    protected Camera(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.eid = paramParcel.readString();
        this.nickname = paramParcel.readString();
        this.avatar = paramParcel.readString();
        this.bgpic = paramParcel.readString();
        this.summary = paramParcel.readString();
        this.honor = paramParcel.readString();
        this.resume = paramParcel.readString();
        this.ison = paramParcel.readString();
        this.appointfee = paramParcel.readDouble();
        this.ceratetime = paramParcel.readString();
        this.edittime = paramParcel.readString();
        this.ontime = paramParcel.readString();
        this.offtime = paramParcel.readString();
        this.shopid = paramParcel.readString();
        this.isdelete = paramParcel.readString();
        this.count = paramParcel.readString();
        this.production = paramParcel.createTypedArrayList(CameraProduct.CREATOR);
        this.satisfaction = paramParcel.readString();
        this.followers = paramParcel.readInt();
        this.score = paramParcel.readInt();
        this.isbooking = paramParcel.readInt();
        this.isfollow = paramParcel.readInt();
        this.name = paramParcel.readString();
        this.photodate = paramParcel.readString();
        this.camer = paramParcel.readString();
        this.booktime = paramParcel.readString();
        this.paytime = paramParcel.readString();
        this.transactionnumber = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAvatar() {
        if (this.avatar == null) {
            return "";
        }
        return this.avatar;
    }

    public String getBgpic() {
        return this.bgpic;
    }

    public String getBooktime() {
        return this.booktime;
    }

    public String getCamer() {
        return this.camer;
    }

    public String getCeratetime() {
        return this.ceratetime;
    }

    public String getCount() {
        return this.count;
    }

    public String getEdittime() {
        return this.edittime;
    }

    public String getEid() {
        return this.eid;
    }

    public int getFollows() {
        return this.followers;
    }

    public String getHonor() {
        if (this.honor == null) {
            return "";
        }
        return this.honor;
    }

    public String getId() {
        return this.id;
    }

    public int getIsbooking() {
        return this.isbooking;
    }

    public String getIsdelete() {
        return this.isdelete;
    }

    public int getIsfollow() {
        return this.isfollow;
    }

    public String getIson() {
        return this.ison;
    }

    public String getName() {
        return this.nickname;
    }

    public String getNickname() {
        return this.name;
    }

    public String getOfftime() {
        return this.offtime;
    }

    public String getOntime() {
        return this.ontime;
    }

    public String getPaytime() {
        return this.paytime;
    }

    public String getPhotodate() {
        return this.photodate;
    }

    public double getPrice() {
        return this.appointfee;
    }

    public List<CameraProduct> getProduction() {
        if (this.production == null) {
            return new ArrayList();
        }
        return this.production;
    }

    public String getResume() {
        if (this.resume == null) {
            return "";
        }
        return this.resume;
    }

    public String getSatisfaction() {
        return this.satisfaction;
    }

    public int getScore() {
        return this.score;
    }

    public String getShopid() {
        return this.shopid;
    }

    public String getSign() {
        if (this.sign == null) {
            return "";
        }
        return this.sign;
    }

    public String getSummary() {
        if (this.summary == null) {
            return "";
        }
        return this.summary;
    }

    public String getTransactionnumber() {
        return this.transactionnumber;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setFollowers(int paramInt) {
        this.followers = paramInt;
    }

    public void setIsfollow(int paramInt) {
        this.isfollow = paramInt;
    }

    public void setSelected(boolean paramBoolean) {
        this.selected = paramBoolean;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.eid);
        paramParcel.writeString(this.nickname);
        paramParcel.writeString(this.avatar);
        paramParcel.writeString(this.bgpic);
        paramParcel.writeString(this.summary);
        paramParcel.writeString(this.honor);
        paramParcel.writeString(this.resume);
        paramParcel.writeString(this.ison);
        paramParcel.writeDouble(this.appointfee);
        paramParcel.writeString(this.ceratetime);
        paramParcel.writeString(this.edittime);
        paramParcel.writeString(this.ontime);
        paramParcel.writeString(this.offtime);
        paramParcel.writeString(this.shopid);
        paramParcel.writeString(this.isdelete);
        paramParcel.writeString(this.count);
        paramParcel.writeTypedList(this.production);
        paramParcel.writeString(this.satisfaction);
        paramParcel.writeInt(this.followers);
        paramParcel.writeInt(this.score);
        paramParcel.writeInt(this.isbooking);
        paramParcel.writeInt(this.isfollow);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.photodate);
        paramParcel.writeString(this.camer);
        paramParcel.writeString(this.booktime);
        paramParcel.writeString(this.paytime);
        paramParcel.writeString(this.transactionnumber);
    }
}

