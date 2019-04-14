package com.zxin.basemodel.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by liukui on 2016/12/12 0012.
 */
@Entity(
        nameInDb = "t_sse_param_area",
        createInDb = false
)

public class City {
    @Id
    public int area_id;
    public int parent_id;
    public String area_name;
    public String short_name;
    public String english_name;
    public String area_level;
    public String create_user;
    public String create_time;
    public String remark;

    @Generated(hash = 247763738)
    public City(int area_id, int parent_id, String area_name, String short_name, String english_name, String area_level, String create_user, String create_time, String remark) {
        this.area_id = area_id;
        this.parent_id = parent_id;
        this.area_name = area_name;
        this.short_name = short_name;
        this.english_name = english_name;
        this.area_level = area_level;
        this.create_user = create_user;
        this.create_time = create_time;
        this.remark = remark;
    }

    @Generated(hash = 750791287)
    public City() {
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getArea_level() {
        return area_level;
    }

    public void setArea_level(String area_level) {
        this.area_level = area_level;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
