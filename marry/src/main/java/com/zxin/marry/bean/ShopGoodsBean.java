package com.zxin.marry.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class ShopGoodsBean {
    private String code;
    private List<GoodsBean> goods;
    private String message;

    public String getCode() {
        return this.code;
    }

    public List<GoodsBean> getGoods() {
        return this.goods;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setGoods(List<GoodsBean> paramList) {
        this.goods = paramList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }
}
