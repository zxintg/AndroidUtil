package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

public class WineWikiResult {
    @JSONField(name = "basicAttribute")
    public List<WikiBasicAttribute> basicAttribute;
    @JSONField(name = "grapeVariety")
    public List<WikiGrapeVariety> grapeVariety;
    @JSONField(name = "imageUrl")
    public String imageUrl;
    @JSONField(name = "jiujingdu")
    public String jiujingdu;
    @JSONField(name = "jxPrice")
    public BigDecimal jxPrice;
    @JSONField(name = "jxProId")
    public String jxProId;
    @JSONField(name = "marketPrice")
    public String marketPrice;
    @JSONField(name = "occasion")
    public List<WikiKeyValue> occasion;
    @JSONField(name = "other")
    public List<WikiKeyValue> other;
    @JSONField(name = "proEnglishName")
    public String proEnglishName;
    @JSONField(name = "proName")
    public String proName;
    @JSONField(name = "rongliang")
    public String rongliang;
    @JSONField(name = "taste_temp")
    public String taste_temp;
    @JSONField(name = "wineDesc")
    public String wineDesc;
    @JSONField(name = "wineType")
    public List<WikiGrapeVariety> wineType;
    @JSONField(name = "xingjiuTime")
    public String xingjiuTime;
    @JSONField(name = "year")
    public String year;

    public static class WikiBasicAttribute {
        @JSONField(name = "basicAttUrl")
        public String basicAttUrl;
        @JSONField(name = "englishName")
        public String englishName;
        @JSONField(name = "name")
        public String name;
        @JSONField(name = "title")
        public String title;
    }

    public static class WikiGrapeVariety {
        @JSONField(name = "name_ch")
        public String name_ch;
        @JSONField(name = "name_en")
        public String name_en;
        @JSONField(name = "web_url_ch")
        public String web_url_ch;
    }

    public static class WikiKeyValue {
        @JSONField(name = "attrValue")
        public String attrValue;
        @JSONField(name = "title")
        public String title;
    }
}

