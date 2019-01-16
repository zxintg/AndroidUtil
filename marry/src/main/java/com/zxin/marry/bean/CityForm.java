package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */

public class CityForm {
    private List<Area> area_res;
    private List<City> citys;
    private int code;
    private List<City> hotCitys;
    private List<Area> info;
    private String message;

    public List<Area> getArea_res() {
        if (this.area_res == null) {
            return new ArrayList();
        }
        return this.area_res;
    }

    public List<City> getCities() {
        if (this.citys == null) {
            return new ArrayList();
        }
        return this.citys;
    }

    public int getCode() {
        return this.code;
    }

    public List<City> getHotCitys() {
        if (this.hotCitys == null) {
            return new ArrayList();
        }
        return this.hotCitys;
    }

    public List<Area> getInfo() {
        if (this.info == null) {
            return new ArrayList();
        }
        return this.info;
    }

    public String getMessage() {
        return this.message;
    }

    public static class Area {
        String area_id;
        String area_name;
        String city;
        String id;

        public String getArea_id() {
            return this.area_id;
        }

        public String getArea_name() {
            if (this.city == null) {
                return this.area_name;
            }
            return this.city;
        }

        public String getCity() {
            return this.city;
        }

        public String getId() {
            return this.id;
        }
    }

    public static class City implements Parcelable {
        public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator() {
            public CityForm.City createFromParcel(Parcel paramAnonymousParcel) {
                return new CityForm.City(paramAnonymousParcel);
            }

            public CityForm.City[] newArray(int paramAnonymousInt) {
                return new CityForm.City[paramAnonymousInt];
            }
        };
        private String city;
        private String cityid;
        private String feastid;
        private String id;
        private String sortLetters;

        public City() {

        }
        protected City(Parcel paramParcel) {
            this.city = paramParcel.readString();
            this.sortLetters = paramParcel.readString();
            this.feastid = paramParcel.readString();
            this.cityid = paramParcel.readString();
            this.id = paramParcel.readString();
        }

        public City(String paramString) {
            this.city = paramString;
        }

        public City(String paramString1, String paramString2) {
            this.city = paramString1;
            this.cityid = paramString2;
        }

        public City(String paramString1, String paramString2, String paramString3) {
            this.city = paramString1;
            this.feastid = paramString2;
            this.cityid = paramString3;
        }

        public int describeContents() {
            return 0;
        }

        public String getCity() {
            return this.city;
        }

        public String getCityid() {
            if (this.cityid == null) {
                return "";
            }
            return this.cityid;
        }

        public String getFeastid() {
            return this.feastid;
        }

        public String getId() {
            return this.id;
        }

        public String getSortLetters() {
            return this.sortLetters;
        }

        public void setFeastid(String paramString) {
            this.feastid = paramString;
        }

        public void setSortLetters(String paramString) {
            this.sortLetters = paramString;
        }

        public String toString() {
            return "City{city='" + this.city + '\'' + ", sortLetters='" + this.sortLetters + '\'' + ", feastid='" + this.feastid + '\'' + ", cityid='" + this.cityid + '\'' + ", id='" + this.id + '\'' + '}';
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.city);
            paramParcel.writeString(this.sortLetters);
            paramParcel.writeString(this.feastid);
            paramParcel.writeString(this.cityid);
            paramParcel.writeString(this.id);
        }
    }

    public static class Province {
        List<CityForm.City> cities;
        private String city;

        public List<CityForm.City> getCities() {
            if (this.cities == null) {
                return new ArrayList();
            }
            return this.cities;
        }

        public String getCity() {
            return this.city;
        }
    }
}
