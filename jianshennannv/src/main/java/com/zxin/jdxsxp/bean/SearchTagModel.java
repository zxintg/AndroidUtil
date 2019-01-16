package com.zxin.jdxsxp.bean;

/**
 * Created by Administrator on 2018/9/7.
 */

public class SearchTagModel {
    private int id;
    private byte state;
    private String title;

    public int getId() {
        return this.id;
    }

    public byte getState() {
        return this.state;
    }

    public String getTitle() {
        return this.title;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setState(byte paramByte) {
        this.state = paramByte;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }
}
