package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityIconConfigResult {
    @JSONField(name = "imageUrl")
    public String defaultUrl;
    @JSONField(name = "imageActionUrl")
    public String selectedUrl;
}

