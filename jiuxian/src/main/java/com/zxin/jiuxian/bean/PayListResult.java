package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.zxin.jiuxian.R;

import java.util.List;

public class PayListResult {
    @JSONField(name = "configPayWayList")
    public ConfigPayWayListBean mConfigPayWayList;
    @JSONField(name = "iisPay")
    public int mIisPay;
    @JSONField(name = "orderSN")
    public String mOrderSN;
    @JSONField(name = "payPrice")
    public double mPayPrice;

    public static boolean payPaymentConfigIsValid(PayListResult paramPayListResult) {
        return (paramPayListResult != null) && (paramPayListResult.mConfigPayWayList != null) && (paramPayListResult.mConfigPayWayList.mPayPaymentConfig != null);
    }

    public static class ConfigPayWayListBean {
        @JSONField(name = "payPaymentConfig")
        public PayPaymentConfigBean mPayPaymentConfig;
        @JSONField(name = "payPaymentPayWayList")
        public List<PayPaymentPayWayListBean> mPayPaymentPayWayList;

        public static class PayPaymentConfigBean {
            @JSONField(name = "defaultPaywayId")
            public int mDefaultPaywayId;
            @JSONField(name = "describe1")
            public String mDescribe1;
            @JSONField(name = "describe3")
            public String mDescribe3;
            @JSONField(name = "id")
            public int mId;
            @JSONField(name = "payType")
            public String mPayType;
            @JSONField(name = "reminder")
            public String mReminder;
            @JSONField(name = "systemType")
            public String mSystemType;
        }

        public static class PayPaymentPayWayListBean {
            public static final String ALIPAY = "alipay_android";
            public static final String ALIPAY_HUABEI = "alipay_huabei_android";
            public static final String BESTPAY = "bestpay_android";
            public static final String JINGDONG = "jd_android";
            public static final String SUFFIX = "_android";
            public static final String UNIONPAY = "unionpay_android";
            public static final String WEIXIN = "weixin_android";
            @JSONField(name = "describe")
            public String mDescribe;
            @JSONField(name = "enumName")
            public String mEnumName;
            @JSONField(name = "name")
            public String mName;
            @JSONField(name = "redLabel")
            public String mRedLabel;
            @JSONField(name = "sort")
            public int mSort;

            public int getDrawableId() {
                if ("weixin_android".equals(this.mEnumName)) {
                    return R.drawable.icon_pay_weixin;
                }
                if ("alipay_android".equals(this.mEnumName)) {
                    return R.drawable.icon_pay_alipay;
                }
                if ("unionpay_android".equals(this.mEnumName)) {
                    return R.drawable.icon_pay_unionpay;
                }
                if ("bestpay_android".equals(this.mEnumName)) {
                    return R.drawable.icon_pay_yipay;
                }
                if ("alipay_huabei_android".equals(this.mEnumName)) {
                    return R.drawable.icon_alipay_huabei;
                }
                if ("jd_android".equals(this.mEnumName)) {
                    return R.drawable.icon_pay_jing_dong;
                }
                return 0;
            }
        }
    }
}
