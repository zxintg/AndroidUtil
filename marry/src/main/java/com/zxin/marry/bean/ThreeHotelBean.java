package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class ThreeHotelBean {
    private String appdesc;
    private int code;
    private List<OptionBean> optionprice;
    private List<OptionBean> optionsite;
    private List<OptionBean> optiontable;
    private List<RecommendForm.RecommendAdv> recommend_adv;

    public List<HotelBean> getOptionList(){
        List<HotelBean> list = new ArrayList<>();
        if (getOptionsite()!=null&&!getOptionsite().isEmpty()){
            HotelBean hotelBean = new HotelBean();
            hotelBean.setType("酒店类型");
            hotelBean.setOption(getOptionsite());
            list.add(hotelBean);
        }
        if (getOptiontable()!=null&&!getOptiontable().isEmpty()){
            HotelBean hotelBean = new HotelBean();
            hotelBean.setType("婚宴桌数");
            hotelBean.setOption(getOptiontable());
            list.add(hotelBean);
        }
        if (getOptionprice()!=null&&!getOptionprice().isEmpty()){
            HotelBean hotelBean = new HotelBean();
            hotelBean.setType("每桌预算");
            hotelBean.setOption(getOptionprice());
            list.add(hotelBean);
        }
        return list;
    }

    public String getAppdesc() {
        return this.appdesc;
    }

    public int getCode() {
        return this.code;
    }

    public List<OptionBean> getOptionprice() {
        return this.optionprice;
    }

    public List<OptionBean> getOptionsite() {
        return this.optionsite;
    }

    public List<OptionBean> getOptiontable() {
        return this.optiontable;
    }

    public List<RecommendForm.RecommendAdv> getRecommend_adv() {
        if (this.recommend_adv == null) {
            return new ArrayList();
        }
        return this.recommend_adv;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public static class OptionBean {
        boolean checked;
        private String id;
        private String name;
        int type;

        public OptionBean() {
        }

        public OptionBean(String paramString) {
            this.name = paramString;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public int getType() {
            return this.type;
        }

        public boolean isChecked() {
            return this.checked;
        }

        public void setChecked(boolean paramBoolean) {
            this.checked = paramBoolean;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setType(int paramInt) {
            this.type = paramInt;
        }

        public String toString() {
            return "OptionBean{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", checked=" + this.checked + ", type=" + this.type + '}';
        }
    }

    public static class HotelBean implements Parcelable{
        private String type;
        private List<OptionBean> option;

        protected HotelBean() {

        }

        protected HotelBean(Parcel in) {
            type = in.readString();
        }

        public static final Creator<HotelBean> CREATOR = new Creator<HotelBean>() {
            @Override
            public HotelBean createFromParcel(Parcel in) {
                return new HotelBean(in);
            }

            @Override
            public HotelBean[] newArray(int size) {
                return new HotelBean[size];
            }
        };

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<OptionBean> getOption() {
            return option;
        }

        public void setOption(List<OptionBean> option) {
            this.option = option;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(type);
        }
    }
}
