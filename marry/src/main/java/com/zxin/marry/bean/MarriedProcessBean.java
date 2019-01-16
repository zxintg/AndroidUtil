package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/3.
 */

public class MarriedProcessBean {
    private String code;
    private InfoEntity info;
    private String message;

    public String getCode() {
        return this.code;
    }

    public InfoEntity getInfo() {
        return this.info;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setInfo(InfoEntity paramInfoEntity) {
        this.info = paramInfoEntity;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class InfoEntity {
        private String content;
        private String title;

        public String getContent() {
            return this.content;
        }

        public String getTitle() {
            return this.title;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }
    }
}
