package com.zxin.jiuxian.api;

import com.zxin.jiuxian.util.StringUtils;

public class RootResult<T> {
    private T result;
    private String errCode;
    private String errMsg;
    private String success;
    private String etag;

    public boolean isBusinessOk() {
        return getSuccess().equals("1") && getResult() != null;
    }

    public boolean isTokenDated() {
        return "1200018".equals(errCode);
    }


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrCode() {
        if (StringUtils.textIsEmpty(errCode)) {
            return errCode;
        }
        return "-1";
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return StringUtils.textIsEmpty(errMsg) ? "网络异常，请重试" : errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

}

