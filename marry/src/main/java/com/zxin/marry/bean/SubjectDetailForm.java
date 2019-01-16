package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */

public class SubjectDetailForm {

    int code;
    Data data;
    String message;
    Page pagedefault;

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Page getPagedefault() {
        return this.pagedefault;
    }

    public static class Data {
        List<ShopClassBean.TaoBaoProduct> goods;
        SubjectForm.Subject topic;

        public List<ShopClassBean.TaoBaoProduct> getGoods() {
            if (this.goods == null) {
                return new ArrayList();
            }
            return this.goods;
        }

        public SubjectForm.Subject getTopic() {
            return this.topic;
        }
    }
}
