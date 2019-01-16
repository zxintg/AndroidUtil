package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/21.
 */

public class OnLineCameraForm {
    int code;
    List<Camera> info;
    String message;
    PageDefault pagedefault;

    public int getCode() {
        return this.code;
    }

    public List<Camera> getInfo() {
        if (this.info == null) {
            return new ArrayList();
        }
        return this.info;
    }

    public String getMessage() {
        return this.message;
    }

    public PageDefault getPagedefault() {
        return this.pagedefault;
    }
}
