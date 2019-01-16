package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CommentLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "color")
    public String mColor;
    @JSONField(name = "coment")
    public String mContent;
    @JSONField(name = "labelId")
    public int mLabelId;
    public boolean mSelected = false;
    @JSONField(name = "transparency")
    public int mTransparency;
}