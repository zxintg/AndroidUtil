package com.zxin.jdxsxp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/9/5.
 */

public class UserModel implements Parcelable{
    private long birth;
    private String bwh;
    private String city;
    private String face;
    private int focus;
    private int gold;
    private boolean hasCertification;
    private int height;
    boolean isMe;
    private String nick;
    private String province;
    private int sex;
    private String syncVersion;
    private String token;
    private long userId;
    private String usersig;
    private boolean vip;
    private long vipEndTime;

    public UserModel() {

    }

    protected UserModel(Parcel in) {
        birth = in.readLong();
        bwh = in.readString();
        city = in.readString();
        face = in.readString();
        focus = in.readInt();
        gold = in.readInt();
        hasCertification = in.readByte() != 0;
        height = in.readInt();
        isMe = in.readByte() != 0;
        nick = in.readString();
        province = in.readString();
        sex = in.readInt();
        syncVersion = in.readString();
        token = in.readString();
        userId = in.readLong();
        usersig = in.readString();
        vip = in.readByte() != 0;
        vipEndTime = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(birth);
        dest.writeString(bwh);
        dest.writeString(city);
        dest.writeString(face);
        dest.writeInt(focus);
        dest.writeInt(gold);
        dest.writeByte((byte) (hasCertification ? 1 : 0));
        dest.writeInt(height);
        dest.writeByte((byte) (isMe ? 1 : 0));
        dest.writeString(nick);
        dest.writeString(province);
        dest.writeInt(sex);
        dest.writeString(syncVersion);
        dest.writeString(token);
        dest.writeLong(userId);
        dest.writeString(usersig);
        dest.writeByte((byte) (vip ? 1 : 0));
        dest.writeLong(vipEndTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public long getBirth() {
        return this.birth;
    }

    public String getBwh() {
        return this.bwh;
    }

    public String getCity() {
        return this.city;
    }

    public String getFace() {
        return this.face;
    }

    public int getFocus() {
        return this.focus;
    }

    public int getGold() {
        return this.gold;
    }

    public int getHeight() {
        return this.height;
    }

    public String getNick() {
        return this.nick;
    }

    public String getProvince() {
        return this.province;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSyncVersion() {
        return this.syncVersion;
    }

    public String getToken() {
        return this.token;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUsersig() {
        return this.usersig;
    }

    public long getVipEndTime() {
        return this.vipEndTime;
    }

    public boolean isHasCertification() {
        return this.hasCertification;
    }

    public boolean isMe() {
        return this.isMe;
    }

    public boolean isVip() {
        return this.vip;
    }

    public void setBirth(long paramLong) {
        this.birth = paramLong;
    }

    public void setBwh(String paramString) {
        this.bwh = paramString;
    }

    public void setCity(String paramString) {
        this.city = paramString;
    }

    public void setFace(String paramString) {
        this.face = paramString;
    }

    public void setFocus(int paramInt) {
        this.focus = paramInt;
    }

    public void setGold(int paramInt) {
        this.gold = paramInt;
    }

    public void setHasCertification(boolean paramBoolean) {
        this.hasCertification = paramBoolean;
    }

    public void setHeight(int paramInt) {
        this.height = paramInt;
    }

    public void setIsMe(boolean paramBoolean) {
        this.isMe = paramBoolean;
    }

    public void setNick(String paramString) {
        this.nick = paramString;
    }

    public void setProvince(String paramString) {
        this.province = paramString;
    }

    public void setSex(int paramInt) {
        this.sex = paramInt;
    }

    public void setSyncVersion(String paramString) {
        this.syncVersion = paramString;
    }

    public void setToken(String paramString) {
        this.token = paramString;
    }

    public void setUserId(long paramLong) {
        this.userId = paramLong;
    }

    public void setUsersig(String paramString) {
        this.usersig = paramString;
    }

    public void setVip(boolean paramBoolean) {
        this.vip = paramBoolean;
    }

    public void setVipEndTime(long paramLong) {
        this.vipEndTime = paramLong;
    }
}
