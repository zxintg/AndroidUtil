package com.zxin.jiuxian.bean;

public class ConditionWeb {
    public int attr_dj_id;
    public int attr_lx_id;
    public int attr_price_id;
    public int attr_pz_id;
    public int attr_xx_id;
    public int brand_id;
    public int cat_id;
    public int country_id;
    public String keyWord;
    public boolean mIsNine = false;
    public boolean mIsNineOrTen = false;
    public int ocasion_id;
    public int order_by;
    public int sort;

    public static class CateType {
        public static int BRANDS = 1;
        public static int COUNTRY = 7;
        public static int FLAVOR = 2;
        public static int GRADE = 12;
        public static int HEALTH_WINE_BRAND = 10;
        public static int PLACE_OF_ORIGIN = 3;
        public static int PRICE = 4;
        public static int RICE_WIN_BRAND = 9;
        public static int SPECIFICATIONS = 8;
        public static int THE_OCCASION = 11;
        public static int TYPE = 5;
        public static int VARIETISE = 6;
    }
}
