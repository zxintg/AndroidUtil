package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/6/22.
 */

public class BaseBean {
    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        if (this.message == null) {
            return "";
        }
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
