package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/10.
 */

public class SelectPhotoDateBean {
    private int allow_selectphoto;
    private String code;
    private DaTang datang;
    private int default_orderselectphoto_nums;
    private String explain;
    private String max_interval_date;
    private String message;
    private String min_interval_date;
    private int rest_count;
    private String selectphotodate;
    private String shop_tel_dangqi;

    public int getAllow_selectphoto() {
        return this.allow_selectphoto;
    }

    public String getCode() {
        return this.code;
    }

    public DaTang getDatang() {
        return this.datang;
    }

    public int getDefault_orderselectphoto_nums() {
        return this.default_orderselectphoto_nums;
    }

    public String getExplain() {
        return this.explain;
    }

    public String getMax_interval_date() {
        return this.max_interval_date;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMin_interval_date() {
        return this.min_interval_date;
    }

    public int getRest_count() {
        return this.rest_count;
    }

    public String getSelectphotodate() {
        return this.selectphotodate;
    }

    public String getShop_tel_dangqi() {
        return this.shop_tel_dangqi;
    }

    public void setAllow_selectphoto(int paramInt) {
        this.allow_selectphoto = paramInt;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setDefault_orderselectphoto_nums(int paramInt) {
        this.default_orderselectphoto_nums = paramInt;
    }

    public void setExplain(String paramString) {
        this.explain = paramString;
    }

    public void setMax_interval_date(String paramString) {
        this.max_interval_date = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setMin_interval_date(String paramString) {
        this.min_interval_date = paramString;
    }

    public void setRest_count(int paramInt) {
        this.rest_count = paramInt;
    }

    public void setSelectphotodate(String paramString) {
        this.selectphotodate = paramString;
    }

    public void setShop_tel_dangqi(String paramString) {
        this.shop_tel_dangqi = paramString;
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
