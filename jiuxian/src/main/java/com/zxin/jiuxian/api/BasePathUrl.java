package com.zxin.jiuxian.api;

import com.zxin.jiuxian.util.JiuXianSharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/10.
 */

public class BasePathUrl {
    public static boolean a = false;
    private static boolean isType = true;
    private static int type = 1100;
    private static boolean isUsed = false;

    public static int defaultType() {
        mode_type();
        return 1100;
    }

    public static boolean is1200() {
        mode_type();
        return type == 1200;
    }

    public static boolean is1102() {
        mode_type();
        return type == 1102;
    }

    public static boolean is1201() {
        mode_type();
        return type == 1201;
    }

    public static boolean is1300() {
        mode_type();
        return type == 1300;
    }

    public static boolean is1400() {
        mode_type();
        return type == 1400;
    }

    private static void mode_type() {
        if (isUsed) {
            return;
        }
        int i = JiuXianSharedPreferences.server_mode_type();
        if ((i >= 1000) && (i <= 1400)) {
            type = i;
        }
        if (isType && (!a)) {
            type = 1400;
        }
        isUsed = true;
        return;

    }

    private static final Map<Integer, UrlPath> urlMap = new HashMap();

    public BasePathUrl() {
        UrlPath urlPath = new UrlPath();
        urlPath.urlPatha = "https://devapphome.jiuxian.com";
        urlPath.urlPathb = "https://devappcart.jiuxian.com";
        urlPath.urlPathc = "https://devapporder.jiuxian.com";
        urlPath.urlPathd = "https://devappproduct.jiuxian.com";
        urlPath.urlPathg = "https://devapppay.jiuxian.com";
        urlPath.urlPathe = "https://devappuser.jiuxian.com";
        urlPath.urlPathf = "https://devappuser.jiuxian.com";
        urlPath.urlPathh = "http://192.168.6.204:8020/JXCommunity";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://devapplist.jiuxian.com";
        urlPath.urlPathn = "http://192.168.6.25:8010";
        urlPath.urlPathi = "https://devmiaosha.jiuxian.com";
        urlPath.urlPathj = "https://devcashier.jiuxian.com";
        urlMap.put(1000, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "http://devapphome.jiuxian.com";
        urlPath.urlPathb = "https://devcart.jiuxian.com";
        urlPath.urlPathc = "https://devorder.jiuxian.com";
        urlPath.urlPathd = "http://devappdetail.jiuxian.com";
        urlPath.urlPathg = "http://devappdetail.jiuxian.com";
        urlPath.urlPathe = "http://devappuser.jiuxian.com";
        urlPath.urlPathf = "http://devappuser.jiuxian.com";
        urlPath.urlPathh = "http://192.168.6.204:8020/JXCommunity";
        urlPath.urlPathl = "http://devm.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "http://devapplist.jiuxian.com";
        urlPath.urlPathn = "http://192.168.6.25:8010";
        urlPath.urlPathi = "https://devmiaosha.jiuxian.com";
        urlPath.urlPathj = "https://test34cashier.jiuxian.com";
        urlMap.put(1001, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "https://test34apphome.jiuxian.com";
        urlPath.urlPathb = "https://test34appcart.jiuxian.com";
        urlPath.urlPathc = "https://test34apporder.jiuxian.com";
        urlPath.urlPathd = "https://test34appproduct.jiuxian.com";
        urlPath.urlPathg = "https://test34apppay.jiuxian.com";
        urlPath.urlPathe = "https://test34appuser.jiuxian.com";
        urlPath.urlPathf = "https://test34appuser.jiuxian.com";
        urlPath.urlPathh = "https://test34community.jiuxian.com";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://test34applist.jiuxian.com";
        urlPath.urlPathn = "https://test34uploadimage.jiuxian.com";
        urlPath.urlPathi = "https://test34miaosha.jiuxian.com";
        urlPath.urlPathj = "https://test34cashier.jiuxian.com";
        urlMap.put(1100, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "http://192.168.5.137:8020/JXHome";
        urlPath.urlPathb = "http://192.168.5.138:8010/app-oms";
        urlPath.urlPathc = "http://192.168.5.138:8010/app-oms";
        urlPath.urlPathd = "http://192.168.5.137:8030/JXProduct";
        urlPath.urlPathg = "http://192.168.5.138:8020/app-promotion";
        urlPath.urlPathe = "http://192.168.5.137:8040/JXUser";
        urlPath.urlPathf = "http://192.168.5.144:8040/JXContent";
        urlPath.urlPathh = "http://192.168.5.148:8010/JXCommunity";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "http://192.168.5.137:8050/JXAppSearch";
        urlPath.urlPathn = "http://192.168.6.25:8010";
        urlPath.urlPathi = "https://miaosha.jiuxian.com";
        urlPath.urlPathj = "https://appcashier.jiuxian.com";
        urlMap.put(1101, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "https://apphome133.jiuxian.com";
        urlPath.urlPathb = "https://appoms133.jiuxian.com";
        urlPath.urlPathc = "https://appoms133.jiuxian.com";
        urlPath.urlPathd = "https://appproduct133.jiuxian.com";
        urlPath.urlPathg = "https://apppromotion133.jiuxian.com";
        urlPath.urlPathe = "https://appuser133.jiuxian.com";
        urlPath.urlPathf = "https://appcontent133.jiuxian.com";
        urlPath.urlPathh = "https://appcommunity133.jiuxian.com";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://applist133.jiuxian.com";
        urlPath.urlPathn = "https://uploadimage133.jiuxian.com";
        urlPath.urlPathi = "https://miaosha133.jiuxian.com";
        urlPath.urlPathj = "https://appcashier.jiuxian.com";
        urlMap.put(1102, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "https://test34apphome.jiuxian.com";
        urlPath.urlPathb = "https://test34cart.jiuxian.com";
        urlPath.urlPathc = "https://test34order.jiuxian.com";
        urlPath.urlPathd = "https://test34appdetail.jiuxian.com";
        urlPath.urlPathg = "https://test34pay.jiuxian.com";
        urlPath.urlPathe = "https://test34appuser.jiuxian.com";
        urlPath.urlPathf = "https://appcontent133.jiuxian.com";
        urlPath.urlPathh = "https://appcommunity133.jiuxian.com";
        urlPath.urlPathl = "http://test34m.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://test34applist.jiuxian.com";
        urlPath.urlPathn = "https://test34uploadimage.jiuxian.com";
        urlPath.urlPathi = "https://test34miaosha.jiuxian.com";
        urlPath.urlPathj = "https://test34cashier.jiuxian.com";
        urlMap.put(1103, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "https://preapphome.jiuxian.com";
        urlPath.urlPathb = "https://preappcart.jiuxian.com";
        urlPath.urlPathc = "https://preapporder.jiuxian.com";
        urlPath.urlPathd = "https://preappproduct.jiuxian.com";
        urlPath.urlPathg = "https://preapppay.jiuxian.com";
        urlPath.urlPathe = "https://preappuser.jiuxian.com";
        urlPath.urlPathf = "https://preappuser.jiuxian.com";
        urlPath.urlPathh = "https://precommunity.jiuxian.com";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://preapplist.jiuxian.com";
        urlPath.urlPathn = "https://uploadimage.jiuxian.com";
        urlPath.urlPathi = "https://premiaosha.jiuxian.com";
        urlPath.urlPathj = "https://precashier.jiuxian.com";
        urlMap.put(1200, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "https://apphome.jiuxian.com";
        urlPath.urlPathb = "https://appcart.jiuxian.com";
        urlPath.urlPathc = "https://apporder.jiuxian.com";
        urlPath.urlPathd = "https://appproduct.jiuxian.com";
        urlPath.urlPathg = "https://apppay.jiuxian.com";
        urlPath.urlPathe = "https://appuser.jiuxian.com";
        urlPath.urlPathf = "https://appuser.jiuxian.com";
        urlPath.urlPathh = "https://community.jiuxian.com";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://applist.jiuxian.com";
        urlPath.urlPathn = "https://uploadimage.jiuxian.com";
        urlPath.urlPathi = "https://miaosha.jiuxian.com";
        urlPath.urlPathj = "https://appcashier.jiuxian.com";
        urlMap.put(1201, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "http://testapphome.jiuxian.com";
        urlPath.urlPathb = "http://testappoms.jiuxian.com";
        urlPath.urlPathc = "http://testappoms.jiuxian.com";
        urlPath.urlPathd = "http://testappproduct.jiuxian.com";
        urlPath.urlPathg = "http://testapppromotion.jiuxian.com";
        urlPath.urlPathe = "http://testappuser.jiuxian.com";
        urlPath.urlPathf = "http://content.jiuxian.com";
        urlPath.urlPathh = "http://community.jiuxian.com";
        urlPath.urlPathl = "http://m.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://apptongji.jiuxian.com:8011";
        urlPath.urlPathm = "http://testappsearch.jiuxian.com";
        urlPath.urlPathn = "https://uploadimage.jiuxian.com";
        urlPath.urlPathi = "https://testmiaosha.jiuxian.com";
        urlPath.urlPathj = "https://testcashier.jiuxian.com";
        urlMap.put(1300, urlPath);

        urlPath = new UrlPath();
        urlPath.urlPatha = "https://newapphome.jiuxian.com";
        urlPath.urlPathb = "https://newappcart.jiuxian.com";
        urlPath.urlPathc = "https://newapporder.jiuxian.com";
        urlPath.urlPathd = "https://newappproduct.jiuxian.com";
        urlPath.urlPathg = "https://newapppay.jiuxian.com";
        urlPath.urlPathe = "https://newappuser.jiuxian.com";
        urlPath.urlPathf = "https://newappuser.jiuxian.com";
        urlPath.urlPathh = "https://newcommunity.jiuxian.com";
        urlPath.urlPathl = "http://mtest.jiuxian.com/m_v1/zhibo/list.htm";
        urlPath.urlPathk = "http://192.168.6.240:8011";
        urlPath.urlPathm = "https://newapplist.jiuxian.com";
        urlPath.urlPathn = "https://uploadimage.jiuxian.com";
        urlPath.urlPathi = "https://miaosha.jiuxian.com";
        urlPath.urlPathj = "https://cashier.jiuxian.com";
        urlMap.put(1400, urlPath);
    }

    private static UrlPath urlPath;

    public static void getUrlPath(int param) {
        urlPath = urlMap.get(param);
        if (urlPath == null) {
            urlPath = urlMap.get(1400);
        }
        return;
    }

    public static String getUrlPatha() {
        return urlPath.urlPatha;
    }

    public static String getUrlPathb() {
        return urlPath.urlPathb;
    }

    public static String getUrlPathc() {
        return urlPath.urlPathc;
    }

    public static String getUrlPathd() {
        return urlPath.urlPathd;
    }

    public static String getUrlPathe() {
        return urlPath.urlPathe;
    }

    public static String getUrlPathf() {
        return urlPath.urlPathf;
    }

    public static String getUrlPathg() {
        return urlPath.urlPathg;
    }

    public static String getUrlPathh() {
        return urlPath.urlPathh;
    }

    public static String getUrlPathi() {
        return urlPath.urlPathi;
    }

    public static String getUrlPathj() {
        return urlPath.urlPathj;
    }

    public static String getUrlPathk() {
        return urlPath.urlPathk;
    }

    public static String getUrlPathl() {
        return urlPath.urlPathl;
    }

    public static String getUrlPathm() {
        return urlPath.urlPathm;
    }

    public static String getUrlPathn() {
        return urlPath.urlPathn;
    }

    private static class UrlPath {
        public String urlPatha;
        public String urlPathb;
        public String urlPathc;
        public String urlPathd;
        public String urlPathe;
        public String urlPathf;
        public String urlPathg;
        public String urlPathh;
        public String urlPathi;
        public String urlPathj;
        public String urlPathk;
        public String urlPathl;
        public String urlPathm;
        public String urlPathn;
    }

}
