package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/20.
 */

public class PhotoDataBean implements Parcelable {
    private String allow_advance;
    private String arrivearea;
    private String code;
    private DaTang datang;
    private String default_orderModify_nums;
    private String explain;
    private int isonlinebookcamer;
    private int israiders;
    private String max_interval_date;
    private String message;
    private String min_interval_date;
    private String photodate;
    public ArrayList<Rephotolist> rephotolist;
    private int rest_count;
    private String servicelevel;
    private String shop_tel_dangqi;

    protected PhotoDataBean(Parcel in) {
        allow_advance = in.readString();
        arrivearea = in.readString();
        code = in.readString();
        default_orderModify_nums = in.readString();
        explain = in.readString();
        isonlinebookcamer = in.readInt();
        israiders = in.readInt();
        max_interval_date = in.readString();
        message = in.readString();
        min_interval_date = in.readString();
        photodate = in.readString();
        rephotolist = in.createTypedArrayList(Rephotolist.CREATOR);
        rest_count = in.readInt();
        servicelevel = in.readString();
        shop_tel_dangqi = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(allow_advance);
        dest.writeString(arrivearea);
        dest.writeString(code);
        dest.writeString(default_orderModify_nums);
        dest.writeString(explain);
        dest.writeInt(isonlinebookcamer);
        dest.writeInt(israiders);
        dest.writeString(max_interval_date);
        dest.writeString(message);
        dest.writeString(min_interval_date);
        dest.writeString(photodate);
        dest.writeTypedList(rephotolist);
        dest.writeInt(rest_count);
        dest.writeString(servicelevel);
        dest.writeString(shop_tel_dangqi);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoDataBean> CREATOR = new Creator<PhotoDataBean>() {
        @Override
        public PhotoDataBean createFromParcel(Parcel in) {
            return new PhotoDataBean(in);
        }

        @Override
        public PhotoDataBean[] newArray(int size) {
            return new PhotoDataBean[size];
        }
    };

    public String getAllow_advance() {
        return this.allow_advance;
    }

    public String getArrivearea() {
        if (this.arrivearea == null) {
            return "";
        }
        return this.arrivearea;
    }

    public String getCode() {
        return this.code;
    }

    public DaTang getDatang() {
        return this.datang;
    }

    public String getDefault_orderModify_nums() {
        return this.default_orderModify_nums;
    }

    public String getExplain() {
        return this.explain;
    }

    public int getIsonlinebookcamer() {
        return this.isonlinebookcamer;
    }

    public int getIsraiders() {
        return this.israiders;
    }

    public String getMax_interval_date() {
        return this.max_interval_date;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMin_interval_date() {
        return this.min_interval_date;
    }

    public String getPhotodate() {
        return this.photodate;
    }

    public ArrayList<Rephotolist> getRephotolist() {
        return this.rephotolist;
    }

    public int getRest_count() {
        return this.rest_count;
    }

    public String getServicelevel() {
        return this.servicelevel;
    }

    public String getShop_tel_dangqi() {
        return this.shop_tel_dangqi;
    }

    public void setAllow_advance(String paramString) {
        this.allow_advance = paramString;
    }

    public void setArrivearea(String paramString) {
        this.arrivearea = paramString;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setDefault_orderModify_nums(String paramString) {
        this.default_orderModify_nums = paramString;
    }

    public void setExplain(String paramString) {
        this.explain = paramString;
    }

    public void setMax_interval_date(String paramString) {
        this.max_interval_date = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setMin_interval_date(String paramString) {
        this.min_interval_date = paramString;
    }

    public void setPhotodate(String paramString) {
        this.photodate = paramString;
    }

    public void setRephotolist(ArrayList<Rephotolist> paramArrayList) {
        this.rephotolist = paramArrayList;
    }

    public void setRest_count(int paramInt) {
        this.rest_count = paramInt;
    }

    public void setShop_tel_dangqi(String paramString) {
        this.shop_tel_dangqi = paramString;
    }

    public class DaTang {
        private String departmentname;
        private String name;
        private String phone;

        public String getDepartmentname() {
            if (this.departmentname == null) {
                return "";
            }
            return this.departmentname;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public String getPhone() {
            if (this.phone == null) {
                return "";
            }
            return this.phone;
        }
    }

    public static class Rephotolist implements Parcelable {
        private String ismark;
        private String photodate;
        private String typeidstr;

        public Rephotolist() {
        }

        protected Rephotolist(Parcel in) {
            ismark = in.readString();
            photodate = in.readString();
            typeidstr = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(ismark);
            dest.writeString(photodate);
            dest.writeString(typeidstr);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Rephotolist> CREATOR = new Creator<Rephotolist>() {
            @Override
            public Rephotolist createFromParcel(Parcel in) {
                return new Rephotolist(in);
            }

            @Override
            public Rephotolist[] newArray(int size) {
                return new Rephotolist[size];
            }
        };

        public String getIsmark() {
            if (this.ismark == null) {
                return "";
            }
            return this.ismark;
        }

        public String getPhotodate() {
            if (this.photodate == null) {
                return "";
            }
            return this.photodate;
        }

        public String getTypeidstr() {
            if (this.typeidstr == null) {
                return "";
            }
            return this.typeidstr;
        }

        public void setIsmark(String paramString) {
            this.ismark = paramString;
        }

        public void setPhotodate(String paramString) {
            this.photodate = paramString;
        }

        public void setTypeidstr(String paramString) {
            this.typeidstr = paramString;
        }
    }
}
