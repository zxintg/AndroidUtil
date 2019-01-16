package com.zxin.marry.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class CartListBean {
    private List<StoreInfo> cart;
    private String code;
    private String message;

    public List<StoreInfo> getCart() {
        return this.cart;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCart(List<StoreInfo> paramList) {
        this.cart = paramList;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
