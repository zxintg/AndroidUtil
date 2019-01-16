package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class MZPicModle {
    private int code;
    private String message;
    private String redirect;
    private ValueBean value;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public ValueBean getValue() {
        return this.value;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setRedirect(String paramString) {
        this.redirect = paramString;
    }

    public void setValue(ValueBean paramValueBean) {
        this.value = paramValueBean;
    }

    public static class ValueBean {
        private List<DataBean> data;
        private boolean more;

        public List<DataBean> getData() {
            return this.data;
        }

        public boolean isMore() {
            return this.more;
        }

        public void setData(List<DataBean> paramList) {
            this.data = paramList;
        }

        public void setMore(boolean paramBoolean) {
            this.more = paramBoolean;
        }

        public static class DataBean {
            private String big;
            private String big_pap_address;
            private int cp_id;
            private String cp_name;
            private int height;
            private int id;
            private String small;
            private String small_pap_address;
            private int width;

            public String getBig() {
                return this.big;
            }

            public String getBig_pap_address() {
                return this.big_pap_address;
            }

            public int getCp_id() {
                return this.cp_id;
            }

            public String getCp_name() {
                return this.cp_name;
            }

            public int getHeight() {
                return this.height;
            }

            public int getId() {
                return this.id;
            }

            public String getSmall() {
                return this.small;
            }

            public String getSmall_pap_address() {
                return this.small_pap_address;
            }

            public int getWidth() {
                return this.width;
            }

            public void setBig(String paramString) {
                this.big = paramString;
            }

            public void setBig_pap_address(String paramString) {
                this.big_pap_address = paramString;
            }

            public void setCp_id(int paramInt) {
                this.cp_id = paramInt;
            }

            public void setCp_name(String paramString) {
                this.cp_name = paramString;
            }

            public void setHeight(int paramInt) {
                this.height = paramInt;
            }

            public void setId(int paramInt) {
                this.id = paramInt;
            }

            public void setSmall(String paramString) {
                this.small = paramString;
            }

            public void setSmall_pap_address(String paramString) {
                this.small_pap_address = paramString;
            }

            public void setWidth(int paramInt) {
                this.width = paramInt;
            }
        }
    }
}
