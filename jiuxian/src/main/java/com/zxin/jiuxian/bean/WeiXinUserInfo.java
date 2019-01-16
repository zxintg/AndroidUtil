package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class WeiXinUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "city")
    public String mCity;
    @JSONField(name = "country")
    public String mCountry;
    @JSONField(name = "headimgurl")
    public String mHeadimgurl;
    @JSONField(name = "nickname")
    public String mNickname;
    @JSONField(name = "openid")
    public String mOpenid;
    @JSONField(name = "province")
    public String mProvince;
    @JSONField(name = "sex")
    public String mSex;
    @JSONField(name = "unionid")
    public String mUnionid;
}
