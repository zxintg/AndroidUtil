package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.zxin.jiuxian.util.StringUtils;

public class RootResult<T> {
    public T mData;
    @JSONField(name = "etag")
    public String mETag;
    @JSONField(name = "errCode")
    public String mErrorCode;
    @JSONField(name = "errMsg")
    public String mErrorMsg;
    @JSONField(name = "toast")
    public String mErrorToast;
    public boolean mIsCache;
    @JSONField(name = "result")
    public String mResult;
    @JSONField(name = "success")
    public int mSuccess;

    public static String getErrorCode(RootResult paramRootResult) {
        return StringUtils.textIsEmpty(paramRootResult.mErrorCode)?paramRootResult.mErrorCode:"-1";
    }

    public static String getErrorMessage(RootResult paramRootResult) {
        return StringUtils.textIsEmpty(paramRootResult.mErrorMsg)?paramRootResult.mErrorMsg:"网路异常，请重试";
    }

    public static boolean isBusinessOk(RootResult paramRootResult) {
        return (isCommunicationOk(paramRootResult)) && (paramRootResult.mData != null);
    }

    public static boolean isCommunicationOk(RootResult paramRootResult) {
        return (paramRootResult != null) && (paramRootResult.mSuccess == 1);
    }

    public static boolean isTokenDated(RootResult paramRootResult) {
        return "1200018".equals(getErrorCode(paramRootResult));
    }
}

