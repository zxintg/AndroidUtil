package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class SearchSouGou {
    private Object globalQC;
    private List<?> hintWords;
    private boolean isClusterfilter;
    private Object isForbiden;
    private int isPornQuery;
    private String isQcResult;
    private boolean isTinyQcNull;
    private List<ItemsBean> items;
    private int itemsOnPage;
    private int maxEnd;
    private String query;
    private String refineQuery;
    private String refineQueryEncode;
    private boolean showFiltered;
    private int startIndex;
    private String tc;
    private String totalItems;
    private String ts;
    private String uuid;

    public Object getGlobalQC() {
        return this.globalQC;
    }

    public List<?> getHintWords() {
        return this.hintWords;
    }

    public Object getIsForbiden() {
        return this.isForbiden;
    }

    public int getIsPornQuery() {
        return this.isPornQuery;
    }

    public String getIsQcResult() {
        return this.isQcResult;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public int getItemsOnPage() {
        return this.itemsOnPage;
    }

    public int getMaxEnd() {
        return this.maxEnd;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRefineQuery() {
        return this.refineQuery;
    }

    public String getRefineQueryEncode() {
        return this.refineQueryEncode;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public String getTc() {
        return this.tc;
    }

    public String getTotalItems() {
        return this.totalItems;
    }

    public String getTs() {
        return this.ts;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isIsClusterfilter() {
        return this.isClusterfilter;
    }

    public boolean isIsTinyQcNull() {
        return this.isTinyQcNull;
    }

    public boolean isShowFiltered() {
        return this.showFiltered;
    }

    public void setGlobalQC(Object paramObject) {
        this.globalQC = paramObject;
    }

    public void setHintWords(List<?> paramList) {
        this.hintWords = paramList;
    }

    public void setIsClusterfilter(boolean paramBoolean) {
        this.isClusterfilter = paramBoolean;
    }

    public void setIsForbiden(Object paramObject) {
        this.isForbiden = paramObject;
    }

    public void setIsPornQuery(int paramInt) {
        this.isPornQuery = paramInt;
    }

    public void setIsQcResult(String paramString) {
        this.isQcResult = paramString;
    }

    public void setIsTinyQcNull(boolean paramBoolean) {
        this.isTinyQcNull = paramBoolean;
    }

    public void setItems(List<ItemsBean> paramList) {
        this.items = paramList;
    }

    public void setItemsOnPage(int paramInt) {
        this.itemsOnPage = paramInt;
    }

    public void setMaxEnd(int paramInt) {
        this.maxEnd = paramInt;
    }

    public void setQuery(String paramString) {
        this.query = paramString;
    }

    public void setRefineQuery(String paramString) {
        this.refineQuery = paramString;
    }

    public void setRefineQueryEncode(String paramString) {
        this.refineQueryEncode = paramString;
    }

    public void setShowFiltered(boolean paramBoolean) {
        this.showFiltered = paramBoolean;
    }

    public void setStartIndex(int paramInt) {
        this.startIndex = paramInt;
    }

    public void setTc(String paramString) {
        this.tc = paramString;
    }

    public void setTotalItems(String paramString) {
        this.totalItems = paramString;
    }

    public void setTs(String paramString) {
        this.ts = paramString;
    }

    public void setUuid(String paramString) {
        this.uuid = paramString;
    }

    public static class ItemsBean {
        private boolean allSummary;
        private Object alt;
        private Object anchor;
        private Object anchor1;
        private String base_url;
        private int cacheIndex;
        private Object date;
        private Object debugInfo;
        private String docid;
        private Object downloadNum;
        private Object downloadPath;
        private boolean easter;
        private Object easterUrl;
        private Object encoding;
        private boolean fastSummary;
        private Object feeddata;
        private Object gifdata;
        private Object groupid;
        private int groupsize;
        private Object grpdata;
        private Object grpdocs;
        private String height;
        private String hittag;
        private String imgcolor;
        private String imgkey1;
        private String imgkey2;
        private String lastmodified;
        private String ldata;
        private Object markedSummary;
        private String markedTitle;
        private String mf_id;
        private boolean normalSummary;
        private String oriTitle;
        private String page_url;
        private String pic_url;
        private String pic_url_noredirect;
        private Object pptdata;
        private boolean showSnapShot;
        private List<List<String>> simdata;
        private Object similarUrlFirst;
        private Object similarUrlSecond;
        private Object siteName;
        private String size;
        private String smallThumbUrl;
        private String sohu_image;
        private Object speedrank;
        private Object summary;
        private String summarypc;
        private String summarytype;
        private Object surr1;
        private String surr2;
        private String thumbUrl;
        private String thumb_height;
        private String thumb_width;
        private int time;
        private String title;
        private String title1;
        private Object title2;
        private int type;
        private String uri;
        private Object url;
        private String width;

        public Object getAlt() {
            return this.alt;
        }

        public Object getAnchor() {
            return this.anchor;
        }

        public Object getAnchor1() {
            return this.anchor1;
        }

        public String getBase_url() {
            return this.base_url;
        }

        public int getCacheIndex() {
            return this.cacheIndex;
        }

        public Object getDate() {
            return this.date;
        }

        public Object getDebugInfo() {
            return this.debugInfo;
        }

        public String getDocid() {
            return this.docid;
        }

        public Object getDownloadNum() {
            return this.downloadNum;
        }

        public Object getDownloadPath() {
            return this.downloadPath;
        }

        public Object getEasterUrl() {
            return this.easterUrl;
        }

        public Object getEncoding() {
            return this.encoding;
        }

        public Object getFeeddata() {
            return this.feeddata;
        }

        public Object getGifdata() {
            return this.gifdata;
        }

        public Object getGroupid() {
            return this.groupid;
        }

        public int getGroupsize() {
            return this.groupsize;
        }

        public Object getGrpdata() {
            return this.grpdata;
        }

        public Object getGrpdocs() {
            return this.grpdocs;
        }

        public String getHeight() {
            return this.height;
        }

        public String getHittag() {
            return this.hittag;
        }

        public String getImgcolor() {
            return this.imgcolor;
        }

        public String getImgkey1() {
            return this.imgkey1;
        }

        public String getImgkey2() {
            return this.imgkey2;
        }

        public String getLastmodified() {
            return this.lastmodified;
        }

        public String getLdata() {
            return this.ldata;
        }

        public Object getMarkedSummary() {
            return this.markedSummary;
        }

        public String getMarkedTitle() {
            return this.markedTitle;
        }

        public String getMf_id() {
            return this.mf_id;
        }

        public String getOriTitle() {
            return this.oriTitle;
        }

        public String getPage_url() {
            return this.page_url;
        }

        public String getPic_url() {
            return this.pic_url;
        }

        public String getPic_url_noredirect() {
            return this.pic_url_noredirect;
        }

        public Object getPptdata() {
            return this.pptdata;
        }

        public List<List<String>> getSimdata() {
            return this.simdata;
        }

        public Object getSimilarUrlFirst() {
            return this.similarUrlFirst;
        }

        public Object getSimilarUrlSecond() {
            return this.similarUrlSecond;
        }

        public Object getSiteName() {
            return this.siteName;
        }

        public String getSize() {
            return this.size;
        }

        public String getSmallThumbUrl() {
            return this.smallThumbUrl;
        }

        public String getSohu_image() {
            return this.sohu_image;
        }

        public Object getSpeedrank() {
            return this.speedrank;
        }

        public Object getSummary() {
            return this.summary;
        }

        public String getSummarypc() {
            return this.summarypc;
        }

        public String getSummarytype() {
            return this.summarytype;
        }

        public Object getSurr1() {
            return this.surr1;
        }

        public String getSurr2() {
            return this.surr2;
        }

        public String getThumbUrl() {
            return this.thumbUrl;
        }

        public String getThumb_height() {
            return this.thumb_height;
        }

        public String getThumb_width() {
            return this.thumb_width;
        }

        public int getTime() {
            return this.time;
        }

        public String getTitle() {
            return this.title;
        }

        public String getTitle1() {
            return this.title1;
        }

        public Object getTitle2() {
            return this.title2;
        }

        public int getType() {
            return this.type;
        }

        public String getUri() {
            return this.uri;
        }

        public Object getUrl() {
            return this.url;
        }

        public String getWidth() {
            return this.width;
        }

        public boolean isAllSummary() {
            return this.allSummary;
        }

        public boolean isEaster() {
            return this.easter;
        }

        public boolean isFastSummary() {
            return this.fastSummary;
        }

        public boolean isNormalSummary() {
            return this.normalSummary;
        }

        public boolean isShowSnapShot() {
            return this.showSnapShot;
        }

        public void setAllSummary(boolean paramBoolean) {
            this.allSummary = paramBoolean;
        }

        public void setAlt(Object paramObject) {
            this.alt = paramObject;
        }

        public void setAnchor(Object paramObject) {
            this.anchor = paramObject;
        }

        public void setAnchor1(Object paramObject) {
            this.anchor1 = paramObject;
        }

        public void setBase_url(String paramString) {
            this.base_url = paramString;
        }

        public void setCacheIndex(int paramInt) {
            this.cacheIndex = paramInt;
        }

        public void setDate(Object paramObject) {
            this.date = paramObject;
        }

        public void setDebugInfo(Object paramObject) {
            this.debugInfo = paramObject;
        }

        public void setDocid(String paramString) {
            this.docid = paramString;
        }

        public void setDownloadNum(Object paramObject) {
            this.downloadNum = paramObject;
        }

        public void setDownloadPath(Object paramObject) {
            this.downloadPath = paramObject;
        }

        public void setEaster(boolean paramBoolean) {
            this.easter = paramBoolean;
        }

        public void setEasterUrl(Object paramObject) {
            this.easterUrl = paramObject;
        }

        public void setEncoding(Object paramObject) {
            this.encoding = paramObject;
        }

        public void setFastSummary(boolean paramBoolean) {
            this.fastSummary = paramBoolean;
        }

        public void setFeeddata(Object paramObject) {
            this.feeddata = paramObject;
        }

        public void setGifdata(Object paramObject) {
            this.gifdata = paramObject;
        }

        public void setGroupid(Object paramObject) {
            this.groupid = paramObject;
        }

        public void setGroupsize(int paramInt) {
            this.groupsize = paramInt;
        }

        public void setGrpdata(Object paramObject) {
            this.grpdata = paramObject;
        }

        public void setGrpdocs(Object paramObject) {
            this.grpdocs = paramObject;
        }

        public void setHeight(String paramString) {
            this.height = paramString;
        }

        public void setHittag(String paramString) {
            this.hittag = paramString;
        }

        public void setImgcolor(String paramString) {
            this.imgcolor = paramString;
        }

        public void setImgkey1(String paramString) {
            this.imgkey1 = paramString;
        }

        public void setImgkey2(String paramString) {
            this.imgkey2 = paramString;
        }

        public void setLastmodified(String paramString) {
            this.lastmodified = paramString;
        }

        public void setLdata(String paramString) {
            this.ldata = paramString;
        }

        public void setMarkedSummary(Object paramObject) {
            this.markedSummary = paramObject;
        }

        public void setMarkedTitle(String paramString) {
            this.markedTitle = paramString;
        }

        public void setMf_id(String paramString) {
            this.mf_id = paramString;
        }

        public void setNormalSummary(boolean paramBoolean) {
            this.normalSummary = paramBoolean;
        }

        public void setOriTitle(String paramString) {
            this.oriTitle = paramString;
        }

        public void setPage_url(String paramString) {
            this.page_url = paramString;
        }

        public void setPic_url(String paramString) {
            this.pic_url = paramString;
        }

        public void setPic_url_noredirect(String paramString) {
            this.pic_url_noredirect = paramString;
        }

        public void setPptdata(Object paramObject) {
            this.pptdata = paramObject;
        }

        public void setShowSnapShot(boolean paramBoolean) {
            this.showSnapShot = paramBoolean;
        }

        public void setSimdata(List<List<String>> paramList) {
            this.simdata = paramList;
        }

        public void setSimilarUrlFirst(Object paramObject) {
            this.similarUrlFirst = paramObject;
        }

        public void setSimilarUrlSecond(Object paramObject) {
            this.similarUrlSecond = paramObject;
        }

        public void setSiteName(Object paramObject) {
            this.siteName = paramObject;
        }

        public void setSize(String paramString) {
            this.size = paramString;
        }

        public void setSmallThumbUrl(String paramString) {
            this.smallThumbUrl = paramString;
        }

        public void setSohu_image(String paramString) {
            this.sohu_image = paramString;
        }

        public void setSpeedrank(Object paramObject) {
            this.speedrank = paramObject;
        }

        public void setSummary(Object paramObject) {
            this.summary = paramObject;
        }

        public void setSummarypc(String paramString) {
            this.summarypc = paramString;
        }

        public void setSummarytype(String paramString) {
            this.summarytype = paramString;
        }

        public void setSurr1(Object paramObject) {
            this.surr1 = paramObject;
        }

        public void setSurr2(String paramString) {
            this.surr2 = paramString;
        }

        public void setThumbUrl(String paramString) {
            this.thumbUrl = paramString;
        }

        public void setThumb_height(String paramString) {
            this.thumb_height = paramString;
        }

        public void setThumb_width(String paramString) {
            this.thumb_width = paramString;
        }

        public void setTime(int paramInt) {
            this.time = paramInt;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public void setTitle1(String paramString) {
            this.title1 = paramString;
        }

        public void setTitle2(Object paramObject) {
            this.title2 = paramObject;
        }

        public void setType(int paramInt) {
            this.type = paramInt;
        }

        public void setUri(String paramString) {
            this.uri = paramString;
        }

        public void setUrl(Object paramObject) {
            this.url = paramObject;
        }

        public void setWidth(String paramString) {
            this.width = paramString;
        }
    }
}
