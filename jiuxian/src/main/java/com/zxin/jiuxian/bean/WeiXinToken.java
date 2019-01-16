package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class WeiXinToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "access_token")
    public String mAccessToken;
    @JSONField(name = "errcode")
    public String mErrcode;
    @JSONField(name = "errmsg")
    public String mErrmsg;
    @JSONField(name = "expires_in")
    public String mExpiresIn;
    @JSONField(name = "openid")
    public String mOpenId;
    @JSONField(name = "refresh_token")
    public String mRefreshToken;
    @JSONField(name = "scope")
    public String mScope;
}
