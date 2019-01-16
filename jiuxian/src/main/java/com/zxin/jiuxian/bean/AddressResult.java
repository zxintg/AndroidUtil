package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */

public class AddressResult {
    @JSONField(name = "provinceList")
    public List<ProvinceItem> mProvinceList;

    public static class CityItem {
        @JSONField(name = "districtList")
        public List<DistrictItem> mDistrictList;
        @JSONField(name = "id")
        public String mId;
    }

    public static class DistrictItem {
        @JSONField(name = "id")
        public String mId;
        @JSONField(name = "name")
        public String mName;
    }

    public static class ProvinceItem {
        @JSONField(name = "cityList")
        public List<AddressResult.CityItem> mCityList;
        @JSONField(name = "id")
        public String mId;
        @JSONField(name = "name")
        public String mName;
    }
}