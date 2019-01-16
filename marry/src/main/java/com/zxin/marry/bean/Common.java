package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/16.
 */

public class Common {
    private int code;
    private String message;

    public Common(int paramInt, String paramString) {
        this.code = paramInt;
        this.message = paramString;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
