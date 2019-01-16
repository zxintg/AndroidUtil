package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class PersonalCenterTabResult implements Serializable {
    @JSONField(name = "attentionCount")
    public int mAttentionCount;
    @JSONField(name = "fansCount")
    public int mFansCount;
    @JSONField(name = "favoriteTopicCount")
    public int mFavoriteTopicCount;
    @JSONField(name = "groupCount")
    public int mGroupCount;
    @JSONField(name = "publishTopicCount")
    public int mPublishTopicCount;
}
