package com.zxin.basemodel.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2018/5/11.
 */

@Entity
public class HttpUrl {
    @Id(autoincrement = true)
    private Long id;
    private String createTimer;
    private String name;
    private String lable;
    private String url;
    private String lastTime;
    private long times;
    private int orderNum;
    private int isEffective;
    private String modifyTime;
    @Generated(hash = 1289403453)
    public HttpUrl(Long id, String createTimer, String name, String lable,
            String url, String lastTime, long times, int orderNum, int isEffective,
            String modifyTime) {
        this.id = id;
        this.createTimer = createTimer;
        this.name = name;
        this.lable = lable;
        this.url = url;
        this.lastTime = lastTime;
        this.times = times;
        this.orderNum = orderNum;
        this.isEffective = isEffective;
        this.modifyTime = modifyTime;
    }

    @Generated(hash = 257886535)
    public HttpUrl() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateTimer() {
        return createTimer;
    }

    public void setCreateTimer(String createTimer) {
        this.createTimer = createTimer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(int isEffective) {
        this.isEffective = isEffective;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
