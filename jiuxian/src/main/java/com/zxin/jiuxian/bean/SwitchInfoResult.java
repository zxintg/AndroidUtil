package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class SwitchInfoResult {
    @JSONField(name = "switchInfo")
    public List<SwitchInfoItem> mSwitchInfos;
    @JSONField(name = "timeQuantum")
    public TimeQuantumItem mTimeQuantum;

    public static class SwitchInfoItem {
        @JSONField(name = "switchName")
        public String mSwitchName;
        @JSONField(name = "switchStatus")
        public String mSwitchStatus;
        @JSONField(name = "switchType")
        public String mSwitchType;
    }

    public static class TimeQuantumItem {
        @JSONField(name = "endHour")
        public int mEndHour;
        @JSONField(name = "startHour")
        public int mStartHour;
    }
}

