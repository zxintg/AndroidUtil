package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class MessagePollingFrequencyResult {
    @JSONField(name = "polling")
    public LoopCount mLoopCount;

    public class LoopCount {
        @JSONField(name = "pollingFrequency")
        public Integer mPollingFrequency;

        public LoopCount() {
        }
    }
}
