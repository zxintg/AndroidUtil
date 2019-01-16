package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class SearchBaiduPic {
    private String bdFmtDispNum;
    private String bdIsClustered;
    private String bdSearchTime;
    private List<DataBean> data;
    private int displayNum;
    private String gsm;
    private int isNeedAsyncRequest;
    private int listNum;
    private String queryEnc;
    private String queryExt;

    public String getBdFmtDispNum() {
        return this.bdFmtDispNum;
    }

    public String getBdIsClustered() {
        return this.bdIsClustered;
    }

    public String getBdSearchTime() {
        return this.bdSearchTime;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public int getDisplayNum() {
        return this.displayNum;
    }

    public String getGsm() {
        return this.gsm;
    }

    public int getIsNeedAsyncRequest() {
        return this.isNeedAsyncRequest;
    }

    public int getListNum() {
        return this.listNum;
    }

    public String getQueryEnc() {
        return this.queryEnc;
    }

    public String getQueryExt() {
        return this.queryExt;
    }

    public void setBdFmtDispNum(String paramString) {
        this.bdFmtDispNum = paramString;
    }

    public void setBdIsClustered(String paramString) {
        this.bdIsClustered = paramString;
    }

    public void setBdSearchTime(String paramString) {
        this.bdSearchTime = paramString;
    }

    public void setData(List<DataBean> paramList) {
        this.data = paramList;
    }

    public void setDisplayNum(int paramInt) {
        this.displayNum = paramInt;
    }

    public void setGsm(String paramString) {
        this.gsm = paramString;
    }

    public void setIsNeedAsyncRequest(int paramInt) {
        this.isNeedAsyncRequest = paramInt;
    }

    public void setListNum(int paramInt) {
        this.listNum = paramInt;
    }

    public void setQueryEnc(String paramString) {
        this.queryEnc = paramString;
    }

    public void setQueryExt(String paramString) {
        this.queryExt = paramString;
    }

    public static class DataBean {
        private String adPicId;
        private String adid;
        private String bdFromPageTitlePrefix;
        private String bdImgnewsDate;
        private int bdSetImgNum;
        private String bdSourceName;
        private String bdSrcType;
        private String currentIndex;
        private String di;
        private Object face_info;
        private String filesize;
        private String fromPageTitle;
        private String fromPageTitleEnc;
        private String fromURL;
        private String fromURLHost;
        private int hasLarge;
        private int height;
        private String hoverURL;
        private String is;
        private String largeTnImageUrl;
        private String middleURL;
        private String objURL;
        private int pageNum;
        private int partnerId;
        private String pi;
        private Object simid_info;
        private String thumbURL;
        private String token;
        private String type;
        private int width;
        private Object xiangshi_info;

        public String getAdPicId() {
            return this.adPicId;
        }

        public String getAdid() {
            return this.adid;
        }

        public String getBdFromPageTitlePrefix() {
            return this.bdFromPageTitlePrefix;
        }

        public String getBdImgnewsDate() {
            return this.bdImgnewsDate;
        }

        public int getBdSetImgNum() {
            return this.bdSetImgNum;
        }

        public String getBdSourceName() {
            return this.bdSourceName;
        }

        public String getBdSrcType() {
            return this.bdSrcType;
        }

        public String getCurrentIndex() {
            return this.currentIndex;
        }

        public String getDi() {
            return this.di;
        }

        public Object getFace_info() {
            return this.face_info;
        }

        public String getFilesize() {
            return this.filesize;
        }

        public String getFromPageTitle() {
            return this.fromPageTitle;
        }

        public String getFromPageTitleEnc() {
            return this.fromPageTitleEnc;
        }

        public String getFromURL() {
            return this.fromURL;
        }

        public String getFromURLHost() {
            return this.fromURLHost;
        }

        public int getHasLarge() {
            return this.hasLarge;
        }

        public int getHeight() {
            return this.height;
        }

        public String getHoverURL() {
            return this.hoverURL;
        }

        public String getIs() {
            return this.is;
        }

        public String getLargeTnImageUrl() {
            return this.largeTnImageUrl;
        }

        public String getMiddleURL() {
            return this.middleURL;
        }

        public String getObjURL() {
            return this.objURL;
        }

        public int getPageNum() {
            return this.pageNum;
        }

        public int getPartnerId() {
            return this.partnerId;
        }

        public String getPi() {
            return this.pi;
        }

        public Object getSimid_info() {
            return this.simid_info;
        }

        public String getThumbURL() {
            return this.thumbURL;
        }

        public String getToken() {
            return this.token;
        }

        public String getType() {
            return this.type;
        }

        public int getWidth() {
            return this.width;
        }

        public Object getXiangshi_info() {
            return this.xiangshi_info;
        }

        public void setAdPicId(String paramString) {
            this.adPicId = paramString;
        }

        public void setAdid(String paramString) {
            this.adid = paramString;
        }

        public void setBdFromPageTitlePrefix(String paramString) {
            this.bdFromPageTitlePrefix = paramString;
        }

        public void setBdImgnewsDate(String paramString) {
            this.bdImgnewsDate = paramString;
        }

        public void setBdSetImgNum(int paramInt) {
            this.bdSetImgNum = paramInt;
        }

        public void setBdSourceName(String paramString) {
            this.bdSourceName = paramString;
        }

        public void setBdSrcType(String paramString) {
            this.bdSrcType = paramString;
        }

        public void setCurrentIndex(String paramString) {
            this.currentIndex = paramString;
        }

        public void setDi(String paramString) {
            this.di = paramString;
        }

        public void setFace_info(Object paramObject) {
            this.face_info = paramObject;
        }

        public void setFilesize(String paramString) {
            this.filesize = paramString;
        }

        public void setFromPageTitle(String paramString) {
            this.fromPageTitle = paramString;
        }

        public void setFromPageTitleEnc(String paramString) {
            this.fromPageTitleEnc = paramString;
        }

        public void setFromURL(String paramString) {
            this.fromURL = paramString;
        }

        public void setFromURLHost(String paramString) {
            this.fromURLHost = paramString;
        }

        public void setHasLarge(int paramInt) {
            this.hasLarge = paramInt;
        }

        public void setHeight(int paramInt) {
            this.height = paramInt;
        }

        public void setHoverURL(String paramString) {
            this.hoverURL = paramString;
        }

        public void setIs(String paramString) {
            this.is = paramString;
        }

        public void setLargeTnImageUrl(String paramString) {
            this.largeTnImageUrl = paramString;
        }

        public void setMiddleURL(String paramString) {
            this.middleURL = paramString;
        }

        public void setObjURL(String paramString) {
            this.objURL = paramString;
        }

        public void setPageNum(int paramInt) {
            this.pageNum = paramInt;
        }

        public void setPartnerId(int paramInt) {
            this.partnerId = paramInt;
        }

        public void setPi(String paramString) {
            this.pi = paramString;
        }

        public void setSimid_info(Object paramObject) {
            this.simid_info = paramObject;
        }

        public void setThumbURL(String paramString) {
            this.thumbURL = paramString;
        }

        public void setToken(String paramString) {
            this.token = paramString;
        }

        public void setType(String paramString) {
            this.type = paramString;
        }

        public void setWidth(int paramInt) {
            this.width = paramInt;
        }

        public void setXiangshi_info(Object paramObject) {
            this.xiangshi_info = paramObject;
        }
    }
}
