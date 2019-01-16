package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class ConfigResult {
    @JSONField(name = "jxProductVideo")
    public JXConfigInfo jxProductVideo;
    @JSONField(name = "baifendian")
    public JXConfigInfo mBaifendian;
    @JSONField(name = "bugly")
    public JXConfigInfo mBugly;
    @JSONField(name = "buynow")
    public JXConfigInfo mBuynow;
    @JSONField(name = "clasbj")
    public JXConfigInfo mClasbj;
    @JSONField(name = "clashbp")
    public JXConfigInfo mClashbp;
    @JSONField(name = "clasjjzb")
    public JXConfigInfo mClasjjzb;
    @JSONField(name = "clasjxss")
    public JXConfigInfo mClasjxss;
    @JSONField(name = "clasptj")
    public JXConfigInfo mClasptj;
    @JSONField(name = "clasyj")
    public JXConfigInfo mClasyj;
    @JSONField(name = "clasyjxj")
    public JXConfigInfo mClasyjxj;
    @JSONField(name = "gtui")
    public JXConfigInfo mGTui;
    @JSONField(name = "global")
    public JXConfigInfo mGlobal;
    @JSONField(name = "goldstore")
    public JXConfigInfo mGoldstore;
    @JSONField(name = "homeModSwitch")
    public List<JXConfigInfo> mHomeModSwitch;
    @JSONField(name = "homebottj")
    public JXConfigInfo mHomebottj;
    @JSONField(name = "homeseckill")
    public JXConfigInfo mHomeseckill;
    @JSONField(name = "homeyoulike")
    public JXConfigInfo mHomeyoulike;
    @JSONField(name = "jiuzhang")
    public JXConfigInfo mJiuZhang;
    @JSONField(name = "loginqq")
    public JXConfigInfo mLoginqq;
    @JSONField(name = "loginwx")
    public JXConfigInfo mLoginwx;
    @JSONField(name = "loginxlwb")
    public JXConfigInfo mLoginxlwb;
    @JSONField(name = "loginzfb")
    public JXConfigInfo mLoginzfb;
    @JSONField(name = "luntan")
    public JXConfigInfo mLuntan;
    @JSONField(name = "mmiao")
    public JXConfigInfo mMmiao;
    @JSONField(name = "mochuang")
    public JXConfigInfo mMoChuang;
    @JSONField(name = "jiuzrizhi")
    public JXConfigInfo mMonitor;
    @JSONField(name = "ninenineclick")
    public JXConfigInfo mNinenineclick;
    @JSONField(name = "huajiaoplay")
    public JXConfigInfo mOnlineVideo;
    @JSONField(name = "paywx")
    public JXConfigInfo mPaywx;
    @JSONField(name = "payyizf")
    public JXConfigInfo mPayyizf;
    @JSONField(name = "payyl")
    public JXConfigInfo mPayyl;
    @JSONField(name = "payzfb")
    public JXConfigInfo mPayzfb;
    @JSONField(name = "selfupdate")
    public JXConfigInfo mSelfupdate;
    @JSONField(name = "supportWebp")
    public JXConfigInfo mSupportWebp;
    @JSONField(name = "talkingdata")
    public JXConfigInfo mTalkingData;
    @JSONField(name = "tjcart")
    public JXConfigInfo mTjcart;
    @JSONField(name = "tjcollepro")
    public JXConfigInfo mTjcollepro;
    @JSONField(name = "tjprodetail")
    public JXConfigInfo mTjprodetail;
    @JSONField(name = "tjseckill")
    public JXConfigInfo mTjseckill;
    @JSONField(name = "tjshlack")
    public JXConfigInfo mTjshlack;
    @JSONField(name = "tjshnull")
    public JXConfigInfo mTjshnull;
    @JSONField(name = "tongdun")
    public JXConfigInfo mTongdun;
    @JSONField(name = "xiaoneng")
    public JXConfigInfo mXiaoNeng;
    @JSONField(name = "xqcomment")
    public JXConfigInfo mXqcomment;
    @JSONField(name = "xqdetails")
    public JXConfigInfo mXqdetails;
    @JSONField(name = "ymfenxiang")
    public JXConfigInfo mYmFenXiang;
    @JSONField(name = "ymshengji")
    public JXConfigInfo mYmShengJi;
    @JSONField(name = "ymtongji")
    public JXConfigInfo mYmTongJi;
    @JSONField(name = "ymtuijian")
    public JXConfigInfo mYmTuiJian;

    public static class JXConfigInfo {
        public static int STATE_FULL_CLOSE = 2;
        public static int STATE_PART_CLOSE = 1;
        @JSONField(name = "advId")
        public String mId;
        @JSONField(name = "funcState")
        public int mState;
        @JSONField(name = "stateInfo")
        public String mStateInfo;

        public boolean equals(Object paramObject) {
            if ((paramObject instanceof JXConfigInfo)) {
                paramObject = (JXConfigInfo) paramObject;
                return TextUtils.equals(this.mId, ((JXConfigInfo) paramObject).mId);
            }
            return super.equals(paramObject);
        }

        public int hashCode() {
            if (this.mId != null) {
                return this.mId.hashCode();
            }
            return super.hashCode();
        }

        public boolean isEnable() {
            return (this.mState != STATE_PART_CLOSE) && (this.mState != STATE_FULL_CLOSE);
        }

        public boolean isFullClose() {
            return this.mState == STATE_FULL_CLOSE;
        }

        public boolean isPartClose() {
            return this.mState == STATE_PART_CLOSE;
        }
    }

    public static class JXConfigInfoMonitorLimitInfo {
        @JSONField(name = "httptimeout")
        public long mApiTimeLimit;
        @JSONField(name = "viewtimeout")
        public long mWebViewTimeLimit;
    }
}

