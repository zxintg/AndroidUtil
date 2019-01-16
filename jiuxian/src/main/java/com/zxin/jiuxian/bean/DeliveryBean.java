package com.zxin.jiuxian.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class DeliveryBean {
    @JSONField(name = "title")
    public String mDeliveryTitle;
    @JSONField(name = "a")
    public List<LinkBean> mLinkLists;

    public static boolean isValidLink(DeliveryBean paramDeliveryBean) {
        return (paramDeliveryBean != null) && (paramDeliveryBean.mLinkLists != null) && (!paramDeliveryBean.mLinkLists.isEmpty());
    }

    public static boolean isValidTitle(DeliveryBean paramDeliveryBean) {
        return (paramDeliveryBean != null) && (!TextUtils.isEmpty(paramDeliveryBean.mDeliveryTitle));
    }

    public static class LinkBean {
        @JSONField(name = "color")
        public String mColor;
        @JSONField(name = "href")
        public String mHref;
        @JSONField(name = "name")
        public String mName;
    }
}