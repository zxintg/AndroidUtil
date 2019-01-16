package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */

public class AddressListBean {
    private List<AddressBean> address;
    private String code;
    private String message;

    public List<AddressBean> getAddress() {
        if (this.address == null) {
            this.address = new ArrayList();
        }
        return this.address;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setAddress(List<AddressBean> paramList) {
        this.address = paramList;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
