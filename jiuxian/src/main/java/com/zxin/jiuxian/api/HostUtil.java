package com.zxin.jiuxian.api;

import com.google.gson.Gson;
import com.zxin.jiuxian.util.JiuXianSharedPreferences;
import com.zxin.jiuxian.util.StringUtils;

/**
 * Created by Administrator on 2018/8/14.
 */

public class HostUtil {

    private static HostUtil hostUtil;
    private static HostInfoResult hostInfo;

    public String getHomeHostInfo() {
        if (hostInfo == null)
            return null;
        HostInfoResult.HostInfo localHostInfo = hostInfo.mHomeHostInfo;
        if ((localHostInfo != null) && (localHostInfo.mPriority != null)) {
            if (localHostInfo.mPriority.equals("0")) {
                return localHostInfo.mDomain;
            }
            return localHostInfo.mIp;
        }
        return null;
    }

    public String getOmsHostInfo() {
        if (hostInfo == null)
            return null;
        HostInfoResult.HostInfo localHostInfo = hostInfo.mOmsHostInfo;
        if ((localHostInfo != null) && (localHostInfo.mPriority != null)) {
            if (localHostInfo.mPriority.equals("0")) {
                return localHostInfo.mDomain;
            }
            return localHostInfo.mIp;
        }
        return null;
    }

    public String getProductHostInfo() {
        if (hostInfo == null)
            return null;
        HostInfoResult.HostInfo localHostInfo = hostInfo.mProductHostInfo;
        if (localHostInfo != null && localHostInfo.mPriority != null) {
            if (localHostInfo.mPriority.equals("0")) {
                return localHostInfo.mDomain;
            }
            return localHostInfo.mIp;
        }
        return null;
    }

    public String getUserHostInfo() {
        if (hostInfo == null)
            return null;
        HostInfoResult.HostInfo localHostInfo = hostInfo.mUserHostInfo;
        if (localHostInfo != null && localHostInfo.mPriority != null) {
            if (localHostInfo.mPriority.equals("0")) {
                return localHostInfo.mDomain;
            }
            return localHostInfo.mIp;
        }
        return null;
    }

    public static HostUtil initDatas() {
        if (hostUtil==null)
            hostUtil = new HostUtil();
        if (hostInfo == null) {
            String str = JiuXianSharedPreferences.host_info_data();
            if (StringUtils.textIsEmpty(str)){
                hostInfo = new HostInfoResult();
                return hostUtil;
            }
            hostInfo = new Gson().fromJson(str, HostInfoResult.class);
        }
        return hostUtil;
    }
}
