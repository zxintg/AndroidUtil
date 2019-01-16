package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/11.
 */

public class RemarkBean {
    private String id;
    private String remarkid;
    private String repeatphotoid;
    private String score;
    private String shopid;
    private String title;
    private String typeid;
    private String username;

    public String getId() {
        return this.id;
    }

    public String getRemarkid() {
        return this.remarkid;
    }

    public String getRepeatphotoid() {
        if (this.repeatphotoid == null) {
            return "";
        }
        return this.repeatphotoid;
    }

    public String getScore() {
        return this.score;
    }

    public String getShopid() {
        return this.shopid;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTypeid() {
        return this.typeid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setRemarkid(String paramString) {
        this.remarkid = paramString;
    }

    public void setRepeatphotoid(String paramString) {
        this.repeatphotoid = paramString;
    }

    public void setScore(String paramString) {
        this.score = paramString;
    }

    public void setShopid(String paramString) {
        this.shopid = paramString;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setTypeid(String paramString) {
        this.typeid = paramString;
    }

    public void setUsername(String paramString) {
        this.username = paramString;
    }
}
