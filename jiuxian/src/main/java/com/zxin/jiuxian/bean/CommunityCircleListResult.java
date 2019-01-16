package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityCircleListResult {
    @JSONField(name = "dataList")
    public List<CommunityCircleInfoResult> mCircleListResult;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;
}
