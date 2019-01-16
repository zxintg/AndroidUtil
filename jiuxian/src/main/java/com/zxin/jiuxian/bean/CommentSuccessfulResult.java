package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CommentSuccessfulResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "commentId")
    public int mCommentId;
    public int mState;
}

