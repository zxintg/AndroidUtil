package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class CommunityChooseWineListResult implements Serializable {
    private static final long serialVersionUID = -2564576898308028898L;
    @JSONField(name = "dataList")
    public List<CommunityProductInfoResult> mCircleListResult;
    @JSONField(name = "pageIndex")
    public int mPageIndex;
    @JSONField(name = "pageSize")
    public int mPageSize;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;
}
