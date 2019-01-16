package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class LogisticsResult {
    @JSONField(name = "deliveryCompany")
    public int mDeliveryCompany;
    @JSONField(name = "deliveryCompanyName")
    public String mDeliveryCompanyName;
    @JSONField(name = "freightNumber")
    public String mFreightNumber;
    @JSONField(name = "orderSN")
    public String mOrderSN;
    @JSONField(name = "orderTrace")
    public List<OrderTrace> mOrderTrace;
    @JSONField(name = "state")
    public int mState;
    @JSONField(name = "stateName")
    public String mStateName;
}