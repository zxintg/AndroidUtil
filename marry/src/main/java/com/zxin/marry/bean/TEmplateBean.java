package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/11.
 */

public class TEmplateBean {
    private String code;
    private String desc;
    private String display;
    private EightEntity eight;
    private String message;
    private String name;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDisplay() {
        return this.display;
    }

    public EightEntity getEight() {
        return this.eight;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
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

    public void setEight(EightEntity paramEightEntity) {
        this.eight = paramEightEntity;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public static class EightEntity {
        private String CompareDate;
        private String CompareDate_explain;

        public String getCompareDate() {
            return this.CompareDate;
        }

        public String getCompareDate_explain() {
            return this.CompareDate_explain;
        }

        public void setCompareDate(String paramString) {
            this.CompareDate = paramString;
        }

        public void setCompareDate_explain(String paramString) {
            this.CompareDate_explain = paramString;
        }
    }
}
