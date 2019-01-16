package com.zxin.jiuxian.bean;

import android.text.TextUtils;

public class PayResult {
    private String memo;
    private String result;
    private String resultStatus;

    public PayResult(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        for (String param:paramString.split(";")){
            if (param.startsWith("resultStatus")) {
                this.resultStatus = gatValue(param, "resultStatus");
            }
            if (param.startsWith("result")) {
                this.result = gatValue(param, "result");
            }
            if (param.startsWith("memo")) {
                this.memo = gatValue(param, "memo");
            }
        }
    }

    private String gatValue(String paramString1, String paramString2) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("={");
        paramString2 = localStringBuilder.toString();
        return paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.lastIndexOf("}"));
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
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

