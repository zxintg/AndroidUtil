package com.zxin.basemodel.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2018/5/11.
 */
@Entity
public class MeiZiCollect {
    @Id(autoincrement = true)
    private Long id;
    private String cover;
    private String url;
    private String name;
    private Long createTime;

    @Generated(hash = 185519983)
    public MeiZiCollect(Long id, String cover, String url, String name,
            Long createTime) {
        this.id = id;
        this.cover = cover;
        this.url = url;
        this.name = name;
        this.createTime = createTime;
    }

    @Generated(hash = 1787207617)
    public MeiZiCollect() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
