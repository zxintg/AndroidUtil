package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CommunityPushCreditRuleResult {
    @JSONField(name = "success")
    public boolean mSuccess;
    @JSONField(name = "toast")
    public String mToast;
}
