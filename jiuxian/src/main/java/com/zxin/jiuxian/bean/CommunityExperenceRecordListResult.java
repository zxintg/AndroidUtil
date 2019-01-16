package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityExperenceRecordListResult {
    @JSONField(name = "dataList")
    public List<ExperenceRecordList> mData;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class ExperenceRecord {
        @JSONField(name = "actionCode")
        public int mActionCode;
        @JSONField(name = "actionName")
        public String mActionName;
        @JSONField(name = "rid")
        public int mRid;
        @JSONField(name = "score")
        public int mScore;
        @JSONField(name = "scoreText")
        public String mScoreText;
    }

    public static class ExperenceRecordList {
        @JSONField(name = "datelineText")
        public String mDateLineText;
        @JSONField(name = "dateline")
        public long mDateline;
        @JSONField(name = "actions")
        public List<CommunityExperenceRecordListResult.ExperenceRecord> mRecordList;
    }
}