package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityCommentListResult {
    @JSONField(name = "dataList")
    public List<CommentResult> mCommentList;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class CommentReplyResult {
        @JSONField(name = "dateline")
        public long mDateLine;
        @JSONField(name = "datelineText")
        public String mDateLineText;
        @JSONField(name = "memberBo")
        public CommunityUserInfoResult mMemberBo;
        @JSONField(name = "message")
        public String mMessage;
        @JSONField(name = "tid")
        public int mTid;
    }

    public static class CommentResult {
        @JSONField(name = "dateline")
        public long mDateLine;
        @JSONField(name = "datelineText")
        public String mDateLineText;
        @JSONField(name = "memberBo")
        public CommunityUserInfoResult mMemberBo;
        @JSONField(name = "message")
        public String mMessage;
        @JSONField(name = "pid")
        public int mPid;
        @JSONField(name = "replyToAnyone")
        public CommunityCommentListResult.CommentReplyResult mReplyToAnyone;
        @JSONField(name = "tid")
        public int mTid;
    }
}