package com.zxin.jiuxian.bean;

import java.util.List;

public class CateLeftPageResult {
    public List<CateListItem> cateList;

    public class CateListItem {
        public int cateIdAlias;
        public int cateHot;
        public String cateName;
    }
}