package com.zxin.marry.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class ShopCaseBean {
    private List<CaseBean> caselist;
    private String code;
    private String message;

    public List<CaseBean> getCaselist() {
        return this.caselist;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCaselist(List<CaseBean> paramList) {
        this.caselist = paramList;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
