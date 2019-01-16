package com.zxin.jiuxian.bean;

import java.util.List;

public class HotWord {
    private List<String> list;

    public List<String> getList() {
        return this.list;
    }

    public void setList(List<String> paramList) {
        this.list = paramList;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HotWord [list=");
        localStringBuilder.append(this.list);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }
}
