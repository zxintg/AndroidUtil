package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/10.
 */

public class BookdressdateBean {
    private String bookdress_explain;
    private String bookdressdate;
    private String code;
    private String message;

    public String getBookdress_explain() {
        return this.bookdress_explain;
    }

    public String getBookdressdate() {
        if (this.bookdressdate == null) {
            return "";
        }
        return this.bookdressdate;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setBookdress_explain(String paramString) {
        this.bookdress_explain = paramString;
    }

    public void setBookdressdate(String paramString) {
        this.bookdressdate = paramString;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
