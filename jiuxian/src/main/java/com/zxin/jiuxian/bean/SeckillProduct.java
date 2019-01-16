package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class SeckillProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(name = "actId")
    public String mActiveId;
    @JSONField(name = "slogan")
    public String mDescription;
    @JSONField(name = "isSetRemind")
    public int mHasSetNotice;
    @JSONField(name = "isRob")
    public int mHasSoldOut;
    @JSONField(name = "proImg")
    public String mImageUrl;
    @JSONField(name = "isOngoing")
    public int mIsGoing;
    public boolean mIsHeader;
    @JSONField(name = "isSelection")
    public boolean mIsSelection;
    @JSONField(name = "proName")
    public String mName;
    @JSONField(name = "setRemindNo")
    public int mNoticeCount;
    @JSONField(name = "jxPrice")
    public double mOriginalPrice;
    @JSONField(name = "sellPercent")
    public int mPercent;
    public int mPosition;
    @JSONField(name = "proPrice")
    public double mPrice;
    @JSONField(name = "proId")
    public int mProductId;
    @JSONField(name = "robText")
    public String mSeckillTimeInfo;
    @JSONField(name = "showVideoIcon")
    public boolean mShowVideoIcon;
    @JSONField(name = "startTime")
    public long mStartTime;
    public String mTimeInfo;
}

