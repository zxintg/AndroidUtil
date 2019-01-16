package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CouponNoticeResult {
    @JSONField(name = "titels")
    public List<String> mTitles;
}
