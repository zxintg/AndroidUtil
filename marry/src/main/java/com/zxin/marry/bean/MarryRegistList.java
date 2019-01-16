package com.zxin.marry.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */

public class MarryRegistList {
    private int status;
    private int total;
    private int size;
    private List<MarryRegist> contents;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<MarryRegist> getContents() {
        return contents;
    }

    public void setContents(List<MarryRegist> contents) {
        this.contents = contents;
    }

    public class MarryRegist{
        private String address;
        private String city;
        private String create_time;
        private String district;
        private String geotable_id;
        private String[] location;
        private String modify_time;
        private String price;
        private String province;
        private String tags;
        private String title;
        private String uid;
        private String coord_type;
        private String type;
        private String distance;
        private String weight;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getGeotable_id() {
            return geotable_id;
        }

        public void setGeotable_id(String geotable_id) {
            this.geotable_id = geotable_id;
        }

        public String[] getLocation() {
            return location;
        }

        public void setLocation(String[] location) {
            this.location = location;
        }

        public String getModify_time() {
            return modify_time;
        }

        public void setModify_time(String modify_time) {
            this.modify_time = modify_time;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getCoord_type() {
            return coord_type;
        }

        public void setCoord_type(String coord_type) {
            this.coord_type = coord_type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }
    }
}
