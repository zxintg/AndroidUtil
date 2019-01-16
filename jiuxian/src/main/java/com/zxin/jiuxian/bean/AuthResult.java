package com.zxin.jiuxian.bean;

import android.text.TextUtils;

/**
 * Created by Administrator on 2018/8/6.
 */
public class AuthResult {
    private String alipayOpenId;
    private String authCode;
    private String memo;
    private String result;
    private String resultCode;
    private String resultStatus;

    public AuthResult(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        int j = 0;
        for (String param : paramString.split(";")){
            if (param.startsWith("resultStatus")) {
                this.resultStatus = getResultParam(param, "resultStatus");
            }
            if (param.startsWith("result")) {
                this.result = getResultParam(param, "result");
            }
            if (param.startsWith("memo")) {
                this.memo = getResultParam(param, "memo");
            }
        }
        if (TextUtils.isEmpty(this.result)) {
            return;
        }
        for (String param : this.result.split("&")){
            if (param.startsWith("alipay_open_id")) {
                this.alipayOpenId = getValue(param);
            }
            if (param.startsWith("auth_code")) {
                this.authCode = getValue(param);
            }
            if (param.startsWith("result_code")) {
                this.resultCode = getValue(param);
            }
        }
    }

    private String getResultParam(String paramString1, String paramString2) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("={");
        paramString2 = localStringBuilder.toString();
        return paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.lastIndexOf("}"));
    }

    private String getValue(String paramString) {
        paramString = paramString.split("=\"")[1];
        return paramString.substring(0, paramString.lastIndexOf("\""));
    }

    public String getAlipayOpenId() {
        return this.alipayOpenId;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultStatus={");
        localStringBuilder.append(this.resultStatus);
        localStringBuilder.append("};memo={");
        localStringBuilder.append(this.memo);
        localStringBuilder.append("};result={");
        localStringBuilder.append(this.result);
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }
}
