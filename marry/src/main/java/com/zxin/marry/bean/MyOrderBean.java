package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/20.
 */

public class MyOrderBean implements Parcelable {
    private int code;
    private Data data;
    private DaTang datang;
    private String message;

    protected MyOrderBean(Parcel in) {
        code = in.readInt();
        message = in.readString();
    }

    public Creator<MyOrderBean> CREATOR = new Creator<MyOrderBean>() {
        @Override
        public MyOrderBean createFromParcel(Parcel in) {
            return new MyOrderBean(in);
        }

        @Override
        public MyOrderBean[] newArray(int size) {
            return new MyOrderBean[size];
        }
    };

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public DaTang getDatang() {
        return this.datang;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setData(Data paramData) {
        this.data = paramData;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(message);
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

    public class Data implements Parcelable {
        private String authorizedescr;
        private String balance;
        private String marrydate;
        private String mname;
        private String mphone;
        private String order_price;
        @SerializedName("package")
        private MyOrderBean.Package packageX;
        private ArrayList<Packagegoods> packagegoods;
        private String photolevelname;
        private String placein;
        private String placeout;
        private String wname;
        private String wphone;

        protected Data(Parcel in) {
            authorizedescr = in.readString();
            balance = in.readString();
            marrydate = in.readString();
            mname = in.readString();
            mphone = in.readString();
            order_price = in.readString();
            photolevelname = in.readString();
            placein = in.readString();
            placeout = in.readString();
            wname = in.readString();
            wphone = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(authorizedescr);
            dest.writeString(balance);
            dest.writeString(marrydate);
            dest.writeString(mname);
            dest.writeString(mphone);
            dest.writeString(order_price);
            dest.writeString(photolevelname);
            dest.writeString(placein);
            dest.writeString(placeout);
            dest.writeString(wname);
            dest.writeString(wphone);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
            }
        };

        public String getAuthorizedescr() {
            return this.authorizedescr;
        }

        public String getBalance() {
            return this.balance;
        }

        public String getMarrydate() {
            return this.marrydate;
        }

        public String getMname() {
            return this.mname;
        }

        public String getMphone() {
            return this.mphone;
        }

        public String getOrder_price() {
            return this.order_price;
        }

        public MyOrderBean.Package getPackageX() {
            return this.packageX;
        }

        public ArrayList<MyOrderBean.Packagegoods> getPackagegoods() {
            return this.packagegoods;
        }

        public String getPhotolevelname() {
            return this.photolevelname;
        }

        public String getPlacein() {
            return this.placein;
        }

        public String getPlaceout() {
            return this.placeout;
        }

        public String getWname() {
            return this.wname;
        }

        public String getWphone() {
            return this.wphone;
        }

        public void setAuthorizedescr(String paramString) {
            this.authorizedescr = paramString;
        }

        public void setBalance(String paramString) {
            this.balance = paramString;
        }

        public void setMarrydate(String paramString) {
            this.marrydate = paramString;
        }

        public void setMname(String paramString) {
            this.mname = paramString;
        }

        public void setMphone(String paramString) {
            this.mphone = paramString;
        }

        public void setOrder_price(String paramString) {
            this.order_price = paramString;
        }

        public void setPackageX(MyOrderBean.Package paramPackage) {
            this.packageX = paramPackage;
        }

        public void setPackagegoods(ArrayList<MyOrderBean.Packagegoods> paramArrayList) {
            this.packagegoods = paramArrayList;
        }

        public void setPhotolevelname(String paramString) {
            this.photolevelname = paramString;
        }

        public void setPlacein(String paramString) {
            this.placein = paramString;
        }

        public void setPlaceout(String paramString) {
            this.placeout = paramString;
        }

        public void setWname(String paramString) {
            this.wname = paramString;
        }

        public void setWphone(String paramString) {
            this.wphone = paramString;
        }
    }

    public class Package implements Parcelable {
        private String man;
        private String photonumber;
        private String vipphotonumber;
        private String woman;

        protected Package(Parcel in) {
            man = in.readString();
            photonumber = in.readString();
            vipphotonumber = in.readString();
            woman = in.readString();
        }

        public Creator<Package> CREATOR = new Creator<Package>() {
            @Override
            public Package createFromParcel(Parcel in) {
                return new Package(in);
            }

            @Override
            public Package[] newArray(int size) {
                return new Package[size];
            }
        };

        public String getMan() {
            return this.man;
        }

        public String getPhotonumber() {
            return this.photonumber;
        }

        public String getVipphotonumber() {
            return this.vipphotonumber;
        }

        public String getWoman() {
            return this.woman;
        }

        public void setMan(String paramString) {
            this.man = paramString;
        }

        public void setPhotonumber(String paramString) {
            this.photonumber = paramString;
        }

        public void setVipphotonumber(String paramString) {
            this.vipphotonumber = paramString;
        }

        public void setWoman(String paramString) {
            this.woman = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(man);
            dest.writeString(photonumber);
            dest.writeString(vipphotonumber);
            dest.writeString(woman);
        }
    }

    public class Packagegoods implements Parcelable {
        private String goodname;
        private String goodsizename;
        private String goodtype;
        private String number;
        private String page;
        private String pnumber;

        protected Packagegoods(Parcel in) {
            goodname = in.readString();
            goodsizename = in.readString();
            goodtype = in.readString();
            number = in.readString();
            page = in.readString();
            pnumber = in.readString();
        }

        public Creator<Packagegoods> CREATOR = new Creator<Packagegoods>() {
            @Override
            public Packagegoods createFromParcel(Parcel in) {
                return new Packagegoods(in);
            }

            @Override
            public Packagegoods[] newArray(int size) {
                return new Packagegoods[size];
            }
        };

        public String getGoodname() {
            return this.goodname;
        }

        public String getGoodsizename() {
            return this.goodsizename;
        }

        public String getGoodtype() {
            return this.goodtype;
        }

        public String getNumber() {
            return this.number;
        }

        public String getPage() {
            return this.page;
        }

        public String getPnumber() {
            return this.pnumber;
        }

        public void setGoodname(String paramString) {
            this.goodname = paramString;
        }

        public void setGoodsizename(String paramString) {
            this.goodsizename = paramString;
        }

        public void setGoodtype(String paramString) {
            this.goodtype = paramString;
        }

        public void setNumber(String paramString) {
            this.number = paramString;
        }

        public void setPage(String paramString) {
            this.page = paramString;
        }

        public void setPnumber(String paramString) {
            this.pnumber = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(goodname);
            dest.writeString(goodsizename);
            dest.writeString(goodtype);
            dest.writeString(number);
            dest.writeString(page);
            dest.writeString(pnumber);
        }
    }
}

