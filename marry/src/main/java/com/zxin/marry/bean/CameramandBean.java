package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/6/21.
 */

public class CameramandBean {
    private int bookbtn;
    private String camer_dresser_explain;
    private String cameramand;
    private String cameramand_number;
    private String cameramandid;
    private String code;
    private DaTang datang;
    private String dresser;
    private String dresser_number;
    private int isdiycamer;
    private int lookbtn;
    private String message;
    private Camera online_camer;
    private String photodate;
    private String servicelevel;

    public int getBookbtn() {
        return this.bookbtn;
    }

    public String getCamer_dresser_explain() {
        return this.camer_dresser_explain;
    }

    public String getCameramand() {
        return this.cameramand;
    }

    public String getCameramand_number() {
        return this.cameramand_number;
    }

    public String getCameramandid() {
        return this.cameramandid;
    }

    public String getCode() {
        return this.code;
    }

    public DaTang getDatang() {
        return this.datang;
    }

    public String getDresser() {
        return this.dresser;
    }

    public String getDresser_number() {
        return this.dresser_number;
    }

    public int getIsdiycamer() {
        return this.isdiycamer;
    }

    public int getLookbtn() {
        return this.lookbtn;
    }

    public String getMessage() {
        return this.message;
    }

    public Camera getOnline_camer() {
        return this.online_camer;
    }

    public String getPhotodate() {
        return this.photodate;
    }

    public String getServicelevel() {
        return this.servicelevel;
    }

    public void setCamer_dresser_explain(String paramString) {
        this.camer_dresser_explain = paramString;
    }

    public void setCameramand(String paramString) {
        this.cameramand = paramString;
    }

    public void setCameramand_number(String paramString) {
        this.cameramand_number = paramString;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setDresser(String paramString) {
        this.dresser = paramString;
    }

    public void setDresser_number(String paramString) {
        this.dresser_number = paramString;
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
}

