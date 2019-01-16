package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ActivityCouponIdResult {
    public ActivityCouponIdBean mActivityCouponIdBean;

    public static class ActivityCouponIdBean {
        @JSONField(name = "actId")
        public String mActId;
    }

}
