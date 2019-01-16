package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityMessageListResult {
    @JSONField(name = "dataList")
    public List<CommunityMessage> mCommentList;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class CommunityMessage {
        @JSONField(name = "activityId")
        public int mActivityId;
        @JSONField(name = "datelineText")
        public String mDateLineText;
        @JSONField(name = "dateline")
        public long mDateline;
        @JSONField(name = "fid")
        public int mFid;
        @JSONField(name = "groupToast")
        public String mGroupToast;
        @JSONField(name = "headImage")
        public String mHeadImg;
        @JSONField(name = "message")
        public String mMessage;
        @JSONField(name = "new")
        public boolean mNew;
        @JSONField(name = "nid")
        public int mNid;
        @JSONField(name = "notificationCode")
        public String mNotificationCode;
        @JSONField(name = "notificationType")
        public String mNotificationType;
        @JSONField(name = "tid")
        public int mTid;
        @JSONField(name = "title")
        public String mTitle;
    }
}
