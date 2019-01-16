package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommentListResult {
    @JSONField(name = "productList")
    public List<CommentListItem> mCommentItems;
    @JSONField(name = "pager")
    public int mPageCount;
    @JSONField(name = "totalPager")
    public int mTotalCount;

    public static class CommentListItem {
        @JSONField(name = "alertAuditInfo")
        public String mAlertAuditInfo;
        @JSONField(name = "alertGoldCoinInfo")
        public String mAlertGoldCoinInfo;
        @JSONField(name = "commentId")
        public int mCommentId;
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
        @JSONField(name = "productState")
        public int mProductState;
        @JSONField(name = "showButton")
        public int mShowButton;
    }
}

