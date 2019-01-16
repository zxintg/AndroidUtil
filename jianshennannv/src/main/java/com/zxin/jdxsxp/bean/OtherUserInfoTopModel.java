package com.zxin.jdxsxp.bean;

/**
 * Created by Administrator on 2018/9/5.
 */

public class OtherUserInfoTopModel {
    private static final long serialVersionUID = 1L;
    private long birth;
    private String bwh;
    private String city;
    private String face;
    private int focus;
    private boolean hasCertification;
    private boolean hasFocus;
    private int height;
    private String nick;
    private int sex;
    private int userId;
    private boolean vip;
    private int vipEndTime;

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

    public int getHeight() {
        return this.height;
    }

    public String getNick() {
        return this.nick;
    }

    public int getSex() {
        return this.sex;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getVipEndTime() {
        return this.vipEndTime;
    }

    public boolean isHasCertification() {
        return this.hasCertification;
    }

    public boolean isHasFocus() {
        return this.hasFocus;
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

    public void setHasCertification(boolean paramBoolean) {
        this.hasCertification = paramBoolean;
    }

    public void setHasFocus(boolean paramBoolean) {
        this.hasFocus = paramBoolean;
    }

    public void setHeight(int paramInt) {
        this.height = paramInt;
    }

    public void setNick(String paramString) {
        this.nick = paramString;
    }

    public void setSex(int paramInt) {
        this.sex = paramInt;
    }

    public void setUserId(int paramInt) {
        this.userId = paramInt;
    }

    public void setVip(boolean paramBoolean) {
        this.vip = paramBoolean;
    }

    public void setVipEndTime(int paramInt) {
        this.vipEndTime = paramInt;
    }
}
