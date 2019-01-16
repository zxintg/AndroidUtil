package com.zxin.jiuxian.bean;


import java.io.Serializable;
import java.util.List;

public class ReEditMixData implements Serializable {
    public String circleName;
    public List<CommunityTopicDetailResult.MixDataItem> dataItems;
    public String title;

    public ReEditMixData(String paramString1, String paramString2, List<CommunityTopicDetailResult.MixDataItem> paramList) {
        this.circleName = paramString1;
        this.title = paramString2;
        this.dataItems = paramList;
    }
}

