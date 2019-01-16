package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommentDetailResult {
    @JSONField(name = "firstComment")
    public CommentInfo mFirstComment;
    @JSONField(name = "anonymity")
    public int mIsAnonymity;
    @JSONField(name = "labelList")
    public List<CommentLabel> mLabels;
    @JSONField(name = "onceComment")
    public CommentInfo mOnceComment;
    @JSONField(name = "productId")
    public int mProductId;
    @JSONField(name = "productImg")
    public String mProductImage;
    @JSONField(name = "productName")
    public String mProductName;
    @JSONField(name = "auditInfo")
    public String mStatusInfo;
}
