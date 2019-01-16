package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/4.
 */

public class MinvBaoGaodetail {
    private String address;
    private String des;
    private int hide;
    private List<PicTotalBean> pic_total;
    private String summarize;

    public String getAddress() {
        return this.address;
    }

    public String getDes() {
        return this.des;
    }

    public int getHide() {
        return this.hide;
    }

    public List<PicTotalBean> getPic_total() {
        return this.pic_total;
    }

    public String getSummarize() {
        return this.summarize;
    }

    public void setAddress(String paramString) {
        this.address = paramString;
    }

    public void setDes(String paramString) {
        this.des = paramString;
    }

    public void setHide(int paramInt) {
        this.hide = paramInt;
    }

    public void setPic_total(List<PicTotalBean> paramList) {
        this.pic_total = paramList;
    }

    public void setSummarize(String paramString) {
        this.summarize = paramString;
    }

    public static class PicTotalBean {
        private int height;
        private String pic_name;
        private String pic_url;
        private int width;

        public int getHeight() {
            return this.height;
        }

        public String getPic_name() {
            return this.pic_name;
        }

        public String getPic_url() {
            return this.pic_url;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int paramInt) {
            this.height = paramInt;
        }

        public void setPic_name(String paramString) {
            this.pic_name = paramString;
        }

        public void setPic_url(String paramString) {
            this.pic_url = paramString;
        }

        public void setWidth(int paramInt) {
            this.width = paramInt;
        }
    }
}
