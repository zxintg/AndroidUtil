package com.zxin.marry.bean;

/**
 * Created by Administrator on 2018/7/11.
 */

public class SecondReplyBean {
    String addtime;
    String secondcomment;

    public String getAddtime() {
        return this.addtime;
    }

    public String getSecondcomment() {
        if (this.secondcomment == null) {
            return "";
        }
        return this.secondcomment;
    }

    public void setAddtime(String paramString) {
        this.addtime = paramString;
    }

    public void setSecondcomment(String paramString) {
        this.secondcomment = paramString;
    }
}
