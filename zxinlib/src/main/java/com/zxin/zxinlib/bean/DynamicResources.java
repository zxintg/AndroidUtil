package com.zxin.zxinlib.bean;

/**
 * Created by Administrator on 2018/9/5.
 */

public class DynamicResources {
    private boolean fuzzy;
    private String thumbnailUrl;
    private String url;

    public DynamicResources(){

    }

    public DynamicResources(String thumbnailUrl,String url,String desc){
        this.thumbnailUrl = thumbnailUrl;
        this.url = url;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isFuzzy() {
        return this.fuzzy;
    }

    public void setFuzzy(boolean paramBoolean) {
        this.fuzzy = paramBoolean;
    }

    public void setThumbnailUrl(String paramString) {
        this.thumbnailUrl = paramString;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}
