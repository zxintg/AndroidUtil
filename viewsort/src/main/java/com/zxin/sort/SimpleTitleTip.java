package com.zxin.sort;

public class SimpleTitleTip implements Tip {
    private long id;
    private String tip;
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "tip:"+ tip;
    }
}
