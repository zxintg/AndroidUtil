package com.zxin.jdxsxp.util;


import com.zxin.basemodel.app.BaseApplication;
import com.zxin.jdxsxp.fragment.SearchItemFragment;
import com.zxin.basemodel.util.BaseStringUtils;
import com.zxin.root.util.DateUtil;
import com.zxin.root.util.SystemInfoUtil;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/12/5.
 */

public class StringUtils extends BaseStringUtils {

    //Activity中需要注册RXBUS事件的类
    public static final String RxBusActivityNames = "";

    //Fragment中需要注册RXBUS事件的类
    public static final String EventBusFragmentNames = SearchItemFragment.class.getName();

    private static String URL = "";
    private static String ADVERT_URL = "";
    private static String XG_V2_ACCESS_ID = "";
    private static String XG_V2_ACCESS_KEY = "";
    private static String TD_APP_ID = "";
    private static String TD_CHANNEL_ID = "";
    private static String TC_SDKAPPID = "";
    private static String TC_ACCOUNT_TYPE = "";
    private static String H5_UU = "";
    private static String H5_UU_REVIEWED = "";

    public static String getUrl() {
        if (textIsEmpty(URL)) {
            URL = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("URL");
        }
        return URL;
    }

    public static String getADVERT_URL() {
        if (textIsEmpty(ADVERT_URL)) {
            ADVERT_URL = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("ADVERT_URL");
        }
        return ADVERT_URL;
    }

    public static String getXG_V2_ACCESS_ID() {
        if (textIsEmpty(XG_V2_ACCESS_ID)) {
            XG_V2_ACCESS_ID = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("XG_V2_ACCESS_ID");
        }
        return XG_V2_ACCESS_ID;
    }

    public static String getXG_V2_ACCESS_KEY() {
        if (textIsEmpty(XG_V2_ACCESS_KEY)) {
            XG_V2_ACCESS_KEY = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("XG_V2_ACCESS_KEY");
        }
        return XG_V2_ACCESS_KEY;
    }

    public static String getTD_APP_ID() {
        if (textIsEmpty(TD_APP_ID)) {
            TD_APP_ID = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("TD_APP_ID");
        }
        return TD_APP_ID;
    }

    public static String getTD_CHANNEL_ID() {
        if (textIsEmpty(TD_CHANNEL_ID)) {
            TD_CHANNEL_ID = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("TD_CHANNEL_ID");
        }
        return TD_CHANNEL_ID;
    }

    public static String getTC_SDKAPPID() {
        if (textIsEmpty(TC_SDKAPPID)) {
            TC_SDKAPPID = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("TC_SDKAPPID");
        }
        return TC_SDKAPPID;
    }

    public static String getTC_ACCOUNT_TYPE() {
        if (textIsEmpty(TC_ACCOUNT_TYPE)) {
            TC_ACCOUNT_TYPE = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("TC_ACCOUNT_TYPE");
        }
        return TC_ACCOUNT_TYPE;
    }

    public static String getH5_UU() {
        if (textIsEmpty(H5_UU)) {
            H5_UU = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("H5_UU");
        }
        return H5_UU;
    }

    public static String getH5_UU_REVIEWED() {
        if (textIsEmpty(H5_UU_REVIEWED)) {
            H5_UU_REVIEWED = SystemInfoUtil.getInstance(BaseApplication.getInstance()).getAppMetaData("H5_UU_REVIEWED");
        }
        return H5_UU_REVIEWED;
    }

    public static String getLookContent(int paramInt) {
        if (paramInt < 10000) {
            return paramInt + "人查看";
        }
        String str = new DecimalFormat(".0").format(paramInt / 1000.0D);
        return subZeroAndDot(str) + "K人查看";
    }

    private static String subZeroAndDot(String paramString) {
        String str = paramString;
        if (paramString.indexOf(".") > 0) {
            str = paramString.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public static String getDateTimer(long timer){
        Calendar now = Calendar.getInstance();
        Calendar calendar = DateUtil.getInstance().timeStamp2Calendar(timer);
        if (calendar.get(Calendar.YEAR) >= now.get(Calendar.YEAR)){
            return DateUtil.getInstance().timeStampDate(timer,"MM-dd HH:mm");
        }else{
            return DateUtil.getInstance().timeStampDate(timer,"yyyy-MM-dd HH:mm");
        }
    }

    public static String getBirthDays(long timer) {
        Calendar now = Calendar.getInstance();
        Calendar calendar = DateUtil.getInstance().timeStamp2Calendar(timer);
        return String.valueOf(now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)+1);
    }
}
