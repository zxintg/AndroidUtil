package com.zxin.basemodel.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2018/5/11.
 */
@Entity
public class GuanJianZi {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String time;
    private String root;
    private String lable;
    public String getLable() {
        return this.lable;
    }
    public void setLable(String lable) {
        this.lable = lable;
    }
    public String getRoot() {
        return this.root;
    }
    public void setRoot(String root) {
        this.root = root;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1314509713)
    public GuanJianZi(Long id, String name, String time, String root, String lable) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.root = root;
        this.lable = lable;
    }
    @Generated(hash = 572006510)
    public GuanJianZi() {
    }

}
