package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class WeddingMainBean {
    private List<AreaBean> area;
    private String code;
    private List<HotelBean> hotel;
    private String message;
    private List<OptionsiteBean> optionsite;
    private List<RecommendForm.RecommendAdv> recommend_adv;

    public List<AreaBean> getArea() {
        if (this.area == null) {
            return new ArrayList();
        }
        return this.area;
    }

    public String getCode() {
        return this.code;
    }

    public List<HotelBean> getHotel() {
        return this.hotel;
    }

    public String getMessage() {
        return this.message;
    }

    public List<OptionsiteBean> getOptionsite() {
        if (this.optionsite == null) {
            return new ArrayList();
        }
        return this.optionsite;
    }

    public List<RecommendForm.RecommendAdv> getRecommend_adv() {
        if (this.recommend_adv == null) {
            return new ArrayList();
        }
        return this.recommend_adv;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setHotel(List<HotelBean> paramList) {
        this.hotel = paramList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class AreaBean {
        private String feastid;
        private String id;
        private String isdelete;
        private String listorder;
        private String name;

        public String getFeastid() {
            return this.feastid;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getListorder() {
            return this.listorder;
        }

        public String getName() {
            return this.name;
        }

        public void setFeastid(String paramString) {
            this.feastid = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setListorder(String paramString) {
            this.listorder = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }

    public static class OptionsiteBean {
        private String feastid;
        private String id;
        private String isdelete;
        private String logo;
        private String name;
        private String sort;

        public String getFeastid() {
            return this.feastid;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getLogo() {
            return this.logo;
        }

        public String getName() {
            return this.name;
        }

        public String getSort() {
            return this.sort;
        }

        public void setFeastid(String paramString) {
            this.feastid = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setLogo(String paramString) {
            this.logo = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setSort(String paramString) {
            this.sort = paramString;
        }
    }
}
