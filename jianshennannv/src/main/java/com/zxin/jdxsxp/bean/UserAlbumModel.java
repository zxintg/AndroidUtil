package com.zxin.jdxsxp.bean;

/**
 * Created by Administrator on 2018/9/5.
 */

public class UserAlbumModel {
    private long birth;
    private int browseCount;
    private boolean buy;
    private int commentCount;
    private String dsc;
    private String face;
    private boolean focus;
    private int gold;
    private boolean hasCertification;
    private boolean hasOther;
    private int id;
    private boolean isCollect;
    private boolean isThumb;
    private int isVr;
    private String mpUrl;
    private String nick;
    private byte sex;
    private String size;
    private int thumbCount;
    private String title;
    private byte type;
    private long updateTime;
    private String[] urls;
    private int userId;

    public long getBirth() {
        return this.birth;
    }

    public int getBrowseCount() {
        return this.browseCount;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getDsc() {
        return this.dsc;
    }

    public String getFace() {
        return this.face;
    }

    public int getGold() {
        return this.gold;
    }

    public int getId() {
        return this.id;
    }

    public int getIsVr() {
        return this.isVr;
    }

    public String getMpUrl() {
        return this.mpUrl;
    }

    public String getNick() {
        return this.nick;
    }

    public byte getSex() {
        return this.sex;
    }

    public String getSize() {
        return this.size;
    }

    public int getThumbCount() {
        return this.thumbCount;
    }

    public String getTitle() {
        return this.title;
    }

    public byte getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String[] getUrls() {
        return this.urls;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean isBuy() {
        return this.buy;
    }

    public boolean isCollect() {
        return this.isCollect;
    }

    public boolean isFocus() {
        return this.focus;
    }

    public boolean isHasCertification() {
        return this.hasCertification;
    }

    public boolean isHasOther() {
        return this.hasOther;
    }

    public boolean isThumb() {
        return this.isThumb;
    }

    public void setBirth(long paramLong) {
        this.birth = paramLong;
    }

    public void setBrowseCount(int paramInt) {
        this.browseCount = paramInt;
    }

    public void setBuy(boolean paramBoolean) {
        this.buy = paramBoolean;
    }

    public void setCollect(boolean paramBoolean) {
        this.isCollect = paramBoolean;
    }

    public void setCommentCount(int paramInt) {
        this.commentCount = paramInt;
    }

    public void setDsc(String paramString) {
        this.dsc = paramString;
    }

    public void setFace(String paramString) {
        this.face = paramString;
    }

    public void setFocus(boolean paramBoolean) {
        this.focus = paramBoolean;
    }

    public void setGold(int paramInt) {
        this.gold = paramInt;
    }

    public void setHasCertification(boolean paramBoolean) {
        this.hasCertification = paramBoolean;
    }

    public void setHasOther(boolean paramBoolean) {
        this.hasOther = paramBoolean;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setIsVr(int paramInt) {
        this.isVr = paramInt;
    }

    public void setMpUrl(String paramString) {
        this.mpUrl = paramString;
    }

    public void setNick(String paramString) {
        this.nick = paramString;
    }

    public void setSex(byte paramByte) {
        this.sex = paramByte;
    }

    public void setSize(String paramString) {
        this.size = paramString;
    }

    public void setThumb(boolean paramBoolean) {
        this.isThumb = paramBoolean;
    }

    public void setThumbCount(int paramInt) {
        this.thumbCount = paramInt;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setType(byte paramByte) {
        this.type = paramByte;
    }

    public void setUpdateTime(long paramLong) {
        this.updateTime = paramLong;
    }

    public void setUrls(String[] paramArrayOfString) {
        this.urls = paramArrayOfString;
    }

    public void setUserId(int paramInt) {
        this.userId = paramInt;
    }
}
