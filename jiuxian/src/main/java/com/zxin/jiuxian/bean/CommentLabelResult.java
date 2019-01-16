package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommentLabelResult {
    @JSONField(name = "labelList")
    public List<CommentLabel> mLabels;
}

