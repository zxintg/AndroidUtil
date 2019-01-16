package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/7.
 */

public class CommentToalModel {
    private List<CommentModel> comments;
    private int count;

    public List<CommentModel> getComments() {
        return this.comments;
    }

    public int getCount() {
        return this.count;
    }

    public void setComments(List<CommentModel> paramList) {
        this.comments = paramList;
    }

    public void setCount(int paramInt) {
        this.count = paramInt;
    }
}
