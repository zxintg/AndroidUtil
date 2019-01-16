package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/10.
 */

public class FInishingBean {
    private String code;
    private DaTang datang;
    private String desc;
    private String display;
    private String message;
    private String name;
    private SevenEntity seven;

    public String getCode() {
        return this.code;
    }

    public DaTang getDatang() {
        return this.datang;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public SevenEntity getSeven() {
        return this.seven;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setDesc(String paramString) {
        this.desc = paramString;
    }

    public void setDisplay(String paramString) {
        this.display = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setSeven(SevenEntity paramSevenEntity) {
        this.seven = paramSevenEntity;
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

    public static class SevenEntity {
        private String checktruing;
        private String checktruing_explain;

        public String getChecktruing() {
            return this.checktruing;
        }

        public String getChecktruing_explain() {
            return this.checktruing_explain;
        }

        public void setChecktruing(String paramString) {
            this.checktruing = paramString;
        }

        public void setChecktruing_explain(String paramString) {
            this.checktruing_explain = paramString;
        }
    }
}
