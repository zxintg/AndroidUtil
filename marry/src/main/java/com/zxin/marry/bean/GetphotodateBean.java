package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/11.
 */

public class GetphotodateBean {
    private int code;
    private DaTang datang;
    private String getphoto_explain;
    private String getphotodate;
    private String message;
    private WangPan wangpan;

    public int getCode() {
        return this.code;
    }

    public DaTang getDatang() {
        return this.datang;
    }

    public String getGetphoto_explain() {
        return this.getphoto_explain;
    }

    public String getGetphotodate() {
        return this.getphotodate;
    }

    public String getMessage() {
        return this.message;
    }

    public WangPan getWangpan() {
        return this.wangpan;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setGetphoto_explain(String paramString) {
        this.getphoto_explain = paramString;
    }

    public void setGetphotodate(String paramString) {
        this.getphotodate = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class DaTang {
        private String departmentname;
        private String name;
        private String phone;

        public String getDepartmentname() {
            if (this.departmentname == null) {
                return "";
            }
            return this.departmentname;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public String getPhone() {
            if (this.phone == null) {
                return "";
            }
            return this.phone;
        }
    }

    public static class WangPan {
        private String content;
        private String url;

        public String getContent() {
            if (this.content == null) {
                return "";
            }
            return this.content;
        }

        public String getUrl() {
            if (this.url == null) {
                return "";
            }
            return this.url;
        }
    }
}
