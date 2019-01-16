package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.zxin.marry.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class HotelDetails {
    private List<BanquetBean> banquet;
    private int code;
    private List<CookbookBean> cookbook;
    private List<GiftBean> gift;
    private HotelBean hotel;
    private ArrayList<JhxmsCase> jhxms_case;
    private String jhxms_case_count;
    private String message;

    public List<BanquetBean> getBanquet() {
        if (this.banquet == null) {
            this.banquet = new ArrayList();
        }
        return this.banquet;
    }

    public int getCode() {
        return this.code;
    }

    public List<CookbookBean> getCookbook() {
        if (this.cookbook == null) {
            this.cookbook = new ArrayList();
        }
        return this.cookbook;
    }

    public List<GiftBean> getGift() {
        return this.gift==null?new ArrayList<GiftBean>():this.gift;
    }

    public HotelBean getHotel() {
        return this.hotel;
    }

    public ArrayList<JhxmsCase> getJhxms_case() {
        return this.jhxms_case==null?new ArrayList<JhxmsCase>():this.jhxms_case;
    }

    public String getJhxms_case_count() {
        return StringUtils.textIsEmpty(this.jhxms_case_count)?"0":this.jhxms_case_count;
    }

    public String getMessage() {
        return this.message;
    }

    public void setBanquet(List<BanquetBean> paramList) {
        this.banquet = paramList;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setCookbook(List<CookbookBean> paramList) {
        this.cookbook = paramList;
    }

    public void setGift(List<GiftBean> paramList) {
        this.gift = paramList;
    }

    public void setHotel(HotelBean paramHotelBean) {
        this.hotel = paramHotelBean;
    }

    public void setJhxms_case(ArrayList<JhxmsCase> paramArrayList) {
        this.jhxms_case = paramArrayList;
    }

    public void setJhxms_case_count(String paramString) {
        this.jhxms_case_count = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class HotelBean {
        private String address;
        private String appintroduce;
        private String areaid;
        private String banquet_count;
        private String cookbook_count;
        private String coord;
        private String corkagefee;
        private String coverimage;
        private String createtime;
        private String feastid;
        private List<HotelImageBean> hotel_image;
        private String id;
        private String introduce;
        private String isdelete;
        private String isrecommend;
        private String latitude;
        private String lawn;
        private String listorder;
        private String longitude;
        private String map;
        private String name;
        private String operator;
        private String optionfeatureid;
        private String optionpriceid;
        private String optionsiteid;
        private String optiontableid;
        private String park;
        private String parkisfree;
        private String price_max;
        private String price_min;
        private String servicecharge;
        private String slottingfee;
        private String status;
        private String table_max;
        private String tel;
        private String weddingroom;

        public String getAddress() {
            return this.address;
        }

        public String getAppintroduce() {
            return this.appintroduce;
        }

        public String getAreaid() {
            return this.areaid;
        }

        public String getBanquet_count() {
            return StringUtils.textIsEmpty(this.banquet_count)?"0":this.banquet_count;
        }

        public String getCookbook_count() {
            return StringUtils.textIsEmpty(this.cookbook_count)?"0":this.cookbook_count;
        }

        public String getCoord() {
            return this.coord;
        }

        public String getCorkagefee() {
            return this.corkagefee;
        }

        public String getCoverimage() {
            return this.coverimage;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public String getFeastid() {
            return this.feastid;
        }

        public List<HotelImageBean> getHotel_image() {
            if (this.hotel_image == null) {
                this.hotel_image = new ArrayList();
            }
            return this.hotel_image;
        }

        public String getId() {
            return this.id;
        }

        public String getIntroduce() {
            return this.introduce;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getIsrecommend() {
            return this.isrecommend;
        }

        public String getLatitude() {
            return this.latitude;
        }

        public String getLawn() {
            return this.lawn;
        }

        public String getListorder() {
            return this.listorder;
        }

        public String getLongitude() {
            return this.longitude;
        }

        public String getMap() {
            return this.map;
        }

        public String getName() {
            return this.name;
        }

        public String getOperator() {
            return this.operator;
        }

        public String getOptionfeatureid() {
            return this.optionfeatureid;
        }

        public String getOptionpriceid() {
            return this.optionpriceid;
        }

        public String getOptionsiteid() {
            return this.optionsiteid;
        }

        public String getOptiontableid() {
            return this.optiontableid;
        }

        public String getPark() {
            return this.park;
        }

        public String getParkisfree() {
            return this.parkisfree;
        }

        public String getPrice_max() {
            return this.price_max;
        }

        public String getPrice_min() {
            return this.price_min;
        }

        public String getServicecharge() {
            return this.servicecharge;
        }

        public String getSlottingfee() {
            return this.slottingfee;
        }

        public String getStatus() {
            return this.status;
        }

        public String getTable_max() {
            return this.table_max;
        }

        public String getTel() {
            return this.tel;
        }

        public String getWeddingroom() {
            return this.weddingroom;
        }

        public void setAddress(String paramString) {
            this.address = paramString;
        }

        public void setAppintroduce(String paramString) {
            this.appintroduce = paramString;
        }

        public void setAreaid(String paramString) {
            this.areaid = paramString;
        }

        public void setBanquet_count(String paramString) {
            this.banquet_count = paramString;
        }

        public void setCookbook_count(String paramString) {
            this.cookbook_count = paramString;
        }

        public void setCoord(String paramString) {
            this.coord = paramString;
        }

        public void setCorkagefee(String paramString) {
            this.corkagefee = paramString;
        }

        public void setCoverimage(String paramString) {
            this.coverimage = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setFeastid(String paramString) {
            this.feastid = paramString;
        }

        public void setHotel_image(List<HotelImageBean> paramList) {
            this.hotel_image = paramList;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIntroduce(String paramString) {
            this.introduce = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setIsrecommend(String paramString) {
            this.isrecommend = paramString;
        }

        public void setLatitude(String paramString) {
            this.latitude = paramString;
        }

        public void setLawn(String paramString) {
            this.lawn = paramString;
        }

        public void setListorder(String paramString) {
            this.listorder = paramString;
        }

        public void setLongitude(String paramString) {
            this.longitude = paramString;
        }

        public void setMap(String paramString) {
            this.map = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOperator(String paramString) {
            this.operator = paramString;
        }

        public void setOptionfeatureid(String paramString) {
            this.optionfeatureid = paramString;
        }

        public void setOptionpriceid(String paramString) {
            this.optionpriceid = paramString;
        }

        public void setOptionsiteid(String paramString) {
            this.optionsiteid = paramString;
        }

        public void setOptiontableid(String paramString) {
            this.optiontableid = paramString;
        }

        public void setPark(String paramString) {
            this.park = paramString;
        }

        public void setParkisfree(String paramString) {
            this.parkisfree = paramString;
        }

        public void setPrice_max(String paramString) {
            this.price_max = paramString;
        }

        public void setPrice_min(String paramString) {
            this.price_min = paramString;
        }

        public void setServicecharge(String paramString) {
            this.servicecharge = paramString;
        }

        public void setSlottingfee(String paramString) {
            this.slottingfee = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        public void setTable_max(String paramString) {
            this.table_max = paramString;
        }

        public void setTel(String paramString) {
            this.tel = paramString;
        }

        public void setWeddingroom(String paramString) {
            this.weddingroom = paramString;
        }

        public static class HotelImageBean {
            private String addtime;
            private String alt;
            private String feastid;
            private String height;
            private String hotelid;
            private String id;
            private String imgsrc;
            private String width;

            public String getAddtime() {
                return this.addtime;
            }

            public String getAlt() {
                return this.alt;
            }

            public String getFeastid() {
                return this.feastid;
            }

            public String getHeight() {
                return this.height;
            }

            public String getHotelid() {
                return this.hotelid;
            }

            public String getId() {
                return this.id;
            }

            public String getImgsrc() {
                return this.imgsrc;
            }

            public String getWidth() {
                return this.width;
            }

            public void setAddtime(String paramString) {
                this.addtime = paramString;
            }

            public void setAlt(String paramString) {
                this.alt = paramString;
            }

            public void setFeastid(String paramString) {
                this.feastid = paramString;
            }

            public void setHeight(String paramString) {
                this.height = paramString;
            }

            public void setHotelid(String paramString) {
                this.hotelid = paramString;
            }

            public void setId(String paramString) {
                this.id = paramString;
            }

            public void setImgsrc(String paramString) {
                this.imgsrc = paramString;
            }

            public void setWidth(String paramString) {
                this.width = paramString;
            }
        }
    }

    public static class JhxmsCase implements Parcelable {
        private String banquet_id;
        private String case_collect;
        private String case_descr;
        private String case_evaluation_count;
        private String case_id;
        private String case_images;
        private String case_status;
        private String case_title;
        private String feastid;
        private String hotelid;
        private String price;
        private String store_id;
        private String store_name;

        protected JhxmsCase(Parcel in) {
            banquet_id = in.readString();
            case_collect = in.readString();
            case_descr = in.readString();
            case_evaluation_count = in.readString();
            case_id = in.readString();
            case_images = in.readString();
            case_status = in.readString();
            case_title = in.readString();
            feastid = in.readString();
            hotelid = in.readString();
            price = in.readString();
            store_id = in.readString();
            store_name = in.readString();
        }

        public static final Creator<JhxmsCase> CREATOR = new Creator<JhxmsCase>() {
            @Override
            public JhxmsCase createFromParcel(Parcel in) {
                return new JhxmsCase(in);
            }

            @Override
            public JhxmsCase[] newArray(int size) {
                return new JhxmsCase[size];
            }
        };

        public String getBanquet_id() {
            return this.banquet_id;
        }

        public String getCase_collect() {
            return this.case_collect;
        }

        public String getCase_descr() {
            return this.case_descr;
        }

        public String getCase_evaluation_count() {
            return this.case_evaluation_count;
        }

        public String getCase_id() {
            return this.case_id;
        }

        public String getCase_images() {
            return this.case_images;
        }

        public String getCase_status() {
            return this.case_status;
        }

        public String getCase_title() {
            return this.case_title;
        }

        public String getFeastid() {
            return this.feastid;
        }

        public String getHotelid() {
            return this.hotelid;
        }

        public String getPrice() {
            return this.price;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public void setBanquet_id(String paramString) {
            this.banquet_id = paramString;
        }

        public void setCase_collect(String paramString) {
            this.case_collect = paramString;
        }

        public void setCase_descr(String paramString) {
            this.case_descr = paramString;
        }

        public void setCase_evaluation_count(String paramString) {
            this.case_evaluation_count = paramString;
        }

        public void setCase_id(String paramString) {
            this.case_id = paramString;
        }

        public void setCase_images(String paramString) {
            this.case_images = paramString;
        }

        public void setCase_status(String paramString) {
            this.case_status = paramString;
        }

        public void setCase_title(String paramString) {
            this.case_title = paramString;
        }

        public void setFeastid(String paramString) {
            this.feastid = paramString;
        }

        public void setHotelid(String paramString) {
            this.hotelid = paramString;
        }

        public void setPrice(String paramString) {
            this.price = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(banquet_id);
            dest.writeString(case_collect);
            dest.writeString(case_descr);
            dest.writeString(case_evaluation_count);
            dest.writeString(case_id);
            dest.writeString(case_images);
            dest.writeString(case_status);
            dest.writeString(case_title);
            dest.writeString(feastid);
            dest.writeString(hotelid);
            dest.writeString(price);
            dest.writeString(store_id);
            dest.writeString(store_name);
        }
    }
}
