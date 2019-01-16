package com.zxin.zxinlib.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */

public class DynamicModel {
    private long birth;
    private int browseCount;
    private boolean buy;
    private int buyCount;
    private long buyTotalGold;
    private int commentCount;
    private String desc;
    private List<DynamicResources> dynamicResources;
    private String face;
    private int gold;
    private boolean hasCertification;
    private int id;
    private String nick;
    private int sex;
    private boolean thumb;
    private int thumbCount;
    private int type;
    private long updateTime;
    private int userId;

    public long getBirth() {
        return this.birth;
    }

    public int getBrowseCount() {
        return this.browseCount;
    }

    public int getBuyCount() {
        return this.buyCount;
    }

    public long getBuyTotalGold() {
        return this.buyTotalGold;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<DynamicResources> getDynamicResources() {
        return this.dynamicResources;
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

    public String getNick() {
        return this.nick;
    }

    public int getSex() {
        return this.sex;
    }

    public int getThumbCount() {
        return this.thumbCount;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean isBuy() {
        return this.buy;
    }

    public boolean isHasCertification() {
        return this.hasCertification;
    }

    public boolean isThumb() {
        return this.thumb;
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

    public void setBuyCount(int paramInt) {
        this.buyCount = paramInt;
    }

    public void setBuyTotalGold(long paramLong) {
        this.buyTotalGold = paramLong;
    }

    public void setCommentCount(int paramInt) {
        this.commentCount = paramInt;
    }

    public void setDesc(String paramString) {
        this.desc = paramString;
    }

    public void setDynamicResources(List<DynamicResources> paramList) {
        this.dynamicResources = paramList;
    }

    public void setFace(String paramString) {
        this.face = paramString;
    }

    public void setGold(int paramInt) {
        this.gold = paramInt;
    }

    public void setHasCertification(boolean paramBoolean) {
        this.hasCertification = paramBoolean;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setNick(String paramString) {
        this.nick = paramString;
    }

    public void setSex(int paramByte) {
        this.sex = paramByte;
    }

    public void setThumb(boolean paramBoolean) {
        this.thumb = paramBoolean;
    }

    public void setThumbCount(int paramInt) {
        this.thumbCount = paramInt;
    }

    public void setType(int paramByte) {
        this.type = paramByte;
    }

    public void setUpdateTime(long paramLong) {
        this.updateTime = paramLong;
    }

    public void setUserId(int paramInt) {
        this.userId = paramInt;
    }
}
