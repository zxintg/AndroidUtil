package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommentInfo {
    @JSONField(name = "coment")
    public String mComment;
    @JSONField(name = "imgList")
    public List<String> mImageUrls;
    @JSONField(name = "commentScore")
    public int mStars;
    @JSONField(name = "deliverySpeedScore")
    public int mStarsDelivery;
    @JSONField(name = "packageScore")
    public int mStarsPackage;
    @JSONField(name = "serviceAttitudeScore")
    public int mStarsService;
}
