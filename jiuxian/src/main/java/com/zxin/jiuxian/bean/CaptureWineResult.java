package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CaptureWineResult implements Serializable {
    @JSONField(name = "searchResult")
    public ArrayList<CaptureWineBean> mCaptureList;
    @JSONField(name = "imageUrl")
    public String mPicUrl;

    public static class CaptureWineBean
            implements Serializable {
        private static final long serialVersionUID = 1L;
        @JSONField(name = "country")
        public String mCountry;
        @JSONField(name = "goodsId")
        public int mGoodId;
        @JSONField(name = "marketPrice")
        public String mMarketPrice;
        @JSONField(name = "name_ch")
        public String mNameCh;
        @JSONField(name = "name_en")
        public String mNameEn;
        @JSONField(name = "pic_url")
        public String mPicUrl;
        @JSONField(name = "wineId")
        public String mPoductId;
        @JSONField(name = "price")
        public BigDecimal mProductPrice;
        @JSONField(name = "region")
        public String mRegion;
        @JSONField(name = "sign")
        public String mSign;
        @JSONField(name = "winery")
        public String mWinery;
        @JSONField(name = "year")
        public String mYears;
    }
}
