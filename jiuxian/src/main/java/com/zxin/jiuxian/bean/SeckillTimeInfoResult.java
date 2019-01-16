package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class SeckillTimeInfoResult {
    @JSONField(name = "secondKillBeats")
    public SeckillTimeInfo mSeckillTimeInfo;

    public static class SeckillTime {
        @JSONField(name = "isOngoing")
        public int mIsBegin;
        @JSONField(name = "fieldNo")
        public String mSeckillId;
        @JSONField(name = "viewField")
        public String mSeckillInfo;
        @JSONField(name = "viewText")
        public String mSeckillStateInfo;
    }

    public static class SeckillTimeInfo {
        @JSONField(name = "secretLink")
        public String mHelpUrl;
        @JSONField(name = "fieldNoList")
        public List<SeckillTimeInfoResult.SeckillTime> mSeckillTimes;
    }
}
