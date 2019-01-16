package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/11.
 */

public class RemarkStatusBean {
    private int code;
    private String explain;
    private String message;
    private int remarktype;
    private int status;
    private UrlMessage urlmessage;

    public int getCode() {
        return this.code;
    }

    public String getExplain() {
        return this.explain;
    }

    public String getMessage() {
        return this.message;
    }

    public int getRemarktype() {
        return this.remarktype;
    }

    public int getStatus() {
        return this.status;
    }

    public UrlMessage getUrlmessage() {
        return this.urlmessage;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setExplain(String paramString) {
        this.explain = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setRemarktype(int paramInt) {
        this.remarktype = paramInt;
    }

    public void setStatus(int paramInt) {
        this.status = paramInt;
    }

    public static class UrlMessage {
        private String buttontitle;
        private String url;
        private String urltitle;

        public String getButtontitle() {
            if (this.buttontitle == null) {
                return "";
            }
            return this.buttontitle;
        }

        public String getUrl() {
            if (this.url == null) {
                return "";
            }
            return this.url;
        }

        public String getUrltitle() {
            if (this.urltitle == null) {
                return "";
            }
            return this.urltitle;
        }
    }
}
