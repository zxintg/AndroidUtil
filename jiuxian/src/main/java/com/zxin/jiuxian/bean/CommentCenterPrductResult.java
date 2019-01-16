package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommentCenterPrductResult {
    @JSONField(name = "productList")
    public List<CommentCenterPrductList> mCommentCenterPrductList;
    @JSONField(name = "count")
    public int mCount;
    @JSONField(name = "pager")
    public int mPager;
    @JSONField(name = "totalPager")
    public int mTotalPager;

    public static class CommentCenterPrductList {
        public static final String HAVE_COMMENT_TRUE = "1";
        @JSONField(name = "alertAuditInfo")
        public String mAlertAuditInfo;
        @JSONField(name = "alertGoldCoinInfo")
        public String mAlertGoldCoinInfo;
        @JSONField(name = "alertInfo")
        public String mAlertInfo;
        @JSONField(name = "auditState")
        public int mAuditState;
        @JSONField(name = "buyTime")
        public String mBuyTime;
        @JSONField(name = "commentId")
        public int mCommentId;
        @JSONField(name = "evaluateType")
        public int mEvaluateType;
        @JSONField(name = "imgUrl")
        public String mImgUrl;
        @JSONField(name = "orderHaveComment")
        public String mOrderHaveComment;
        @JSONField(name = "orderId")
        public int mOrderId;
        @JSONField(name = "orderItemId")
        public int mOrderItemId;
        @JSONField(name = "productId")
        public int mProductId;
        @JSONField(name = "productName")
        public String mProductName;
        @JSONField(name = "showButton")
        public int mShowButton;
    }
}
