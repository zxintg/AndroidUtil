package com.zxin.marry.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/9.
 */

public class HotelCaseBean {
    private ArrayList<HotelDetails.JhxmsCase> caselist;
    private int code;
    private String message;

    public ArrayList<HotelDetails.JhxmsCase> getCaselist() {
        return this.caselist;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCaselist(ArrayList<HotelDetails.JhxmsCase> paramArrayList) {
        this.caselist = paramArrayList;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
