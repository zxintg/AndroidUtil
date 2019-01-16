package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityExperenceRuleListResult {
    @JSONField(name = "dataList")
    public List<ExperenceRuleList> mData;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class ExperenceRule {
        @JSONField(name = "actionCode")
        public int mActionCode;
        @JSONField(name = "actionName")
        public String mActionName;
        @JSONField(name = "limitScore")
        public String mLimitScore;
        @JSONField(name = "rid")
        public int mRid;
        @JSONField(name = "score")
        public int mScore;
        @JSONField(name = "scoreText")
        public String mScoreText;
    }

    public static class ExperenceRuleList {
        @JSONField(name = "datelineText")
        public String mDateLineText;
        @JSONField(name = "dateline")
        public long mDateline;
        @JSONField(name = "nameCode")
        public int mNameCode;
        @JSONField(name = "nameText")
        public String mNameText;
        @JSONField(name = "actions")
        public List<CommunityExperenceRuleListResult.ExperenceRule> mRuleList;
    }
}