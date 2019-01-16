package com.zxin.marry.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/19.
 */

public class OrderListBean {
    private int code;
    private ArrayList<OrderBean> data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public ArrayList<OrderBean> getData() {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }
}
