package com.zxin.jiuxian.bean;

import java.io.Serializable;
import java.util.List;

public class CatePageResult {
    public List<CateAttrListItem> attrList;
    public List<CateBannerItem> moduleList;

    public static class CateAttrListItem implements Serializable {
        private static final long serialVersionUID = 1L;
        public int id;
        public int isAll;
        public List<CatePageResult.CateListItem> list;
        public String name;
    }

    public static class CateBannerItem {
        public String adHtmlContent;
        public String adImg;
        public String adLink;
        public String adTitle;
    }

    public static class CateListItem implements Serializable {
        private static final long serialVersionUID = 1L;
        public int id;
        public String image;
        public int mIndex;
        public int mIsAll;
        public int isRed;
        public String name;
        public int mParentId;
        public String mParentName;
    }
}

