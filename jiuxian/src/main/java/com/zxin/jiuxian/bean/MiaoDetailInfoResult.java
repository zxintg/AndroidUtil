package com.zxin.jiuxian.bean;


import com.alibaba.fastjson.annotation.JSONField;

public class MiaoDetailInfoResult {
    @JSONField(name = "areaDetailInfo")
    public AreaDetailInfo mAreaDetailInfo;
    @JSONField(name = "info")
    public String mInfo;
    @JSONField(name = "name")
    public String mName;
    @JSONField(name = "productId")
    public String mProductId;
    @JSONField(name = "wineryInfo")
    public WineryInfo mWineryInfo;

    public class AreaDetailInfo {
        @JSONField(name = "fragrance")
        public String mFragrance;
        @JSONField(name = "grapeVariety")
        public String mGrapeVariety;
        @JSONField(name = "location")
        public String mLocation;
        @JSONField(name = "recommendYear")
        public String mRecommendYear;
        @JSONField(name = "ripeningTime")
        public String mRipeningTime;
        @JSONField(name = "soil")
        public String mSoil;
        @JSONField(name = "vineyardArea")
        public String mVineyardArea;
        @JSONField(name = "wineCharacter")
        public String mWineCharacter;
        @JSONField(name = "wineProduction")
        public String mWineProduction;

        public AreaDetailInfo() {
        }
    }

    public class WineryInfo {
        @JSONField(name = "averageTreeAge")
        public String mAverageTreeAge;
        @JSONField(name = "grapeArea")
        public String mGrapeArea;
        @JSONField(name = "grapeFieldArea")
        public String mGrapeFieldArea;
        @JSONField(name = "grapeProportion")
        public String mGrapeProportion;
        @JSONField(name = "level")
        public String mLevel;
        @JSONField(name = "mainGrapeSpecies")
        public String mMainGrapeSpecies;
        @JSONField(name = "otherGrapeSpecies")
        public String mOtherGrapeSpecies;
        @JSONField(name = "outputAnnul")
        public String mOutputAnnul;
        @JSONField(name = "owner")
        public String mOwner;
        @JSONField(name = "pickingStyle")
        public String mPickingStyle;
        @JSONField(name = "productArea")
        public String mProductArea;
        @JSONField(name = "soilType")
        public String mSoilType;
    }
}

