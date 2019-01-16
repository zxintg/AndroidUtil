package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class HotelListBean {
    private String code;
    private List<HotelBean> hotel;
    private String message;
    private PageBean page;

    public String getCode() {
        return this.code;
    }

    public List<HotelBean> getHotel() {
        return this.hotel;
    }

    public String getMessage() {
        return this.message;
    }

    public PageBean getPage() {
        return this.page;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setHotel(List<HotelBean> paramList) {
        Object localObject = paramList;
        if (paramList == null) {
            localObject = new ArrayList();
        }
        this.hotel = ((List) localObject);
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setPage(PageBean paramPageBean) {
        this.page = paramPageBean;
    }

    public static class PageBean {
        private int page;
        private int pagenumber;
        private String pagetime;

        public int getPage() {
            return this.page;
        }

        public int getPagenumber() {
            return this.pagenumber;
        }

        public String getPagetime() {
            return this.pagetime;
        }

        public void setPage(int paramInt) {
            this.page = paramInt;
        }

        public void setPagenumber(int paramInt) {
            this.pagenumber = paramInt;
        }

        public void setPagetime(String paramString) {
            this.pagetime = paramString;
        }
    }
}
