package com.zxin.marry.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */

public class BanquetListBean {
    private List<BanquetBean> banquet;
    private String code;
    private String message;
    private PageBean page;

    public List<BanquetBean> getBanquet() {
        return this.banquet;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public PageBean getPage() {
        return this.page;
    }

    public void setBanquet(List<BanquetBean> paramList) {
        this.banquet = paramList;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setPage(PageBean paramPageBean) {
        this.page = paramPageBean;
    }

    public static class PageBean {
        private String page;
        private int pagenumber;
        private String pagetime;

        public String getPage() {
            return this.page;
        }

        public int getPagenumber() {
            return this.pagenumber;
        }

        public String getPagetime() {
            return this.pagetime;
        }

        public void setPage(String paramString) {
            this.page = paramString;
        }

        public void setPagenumber(int paramInt) {
            this.pagenumber = paramInt;
        }

        public void setPagetime(String paramString) {
            this.pagetime = paramString;
        }
    }
}
