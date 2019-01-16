package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class WineStorehouseResult {
    @JSONField(name = "areaId")
    public int mAreaId;
    @JSONField(name = "compartmentId")
    public int mCompartmentId;
    @JSONField(name = "compartmentName")
    public String mCompartmentName;
}
