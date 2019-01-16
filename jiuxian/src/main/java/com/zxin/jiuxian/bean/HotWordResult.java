package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class HotWordResult {
    @JSONField(name = "list")
    public List<String> mList;
}

