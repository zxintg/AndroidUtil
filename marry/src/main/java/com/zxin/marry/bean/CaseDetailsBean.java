package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */

public class CaseDetailsBean implements Parcelable{
    private CasesBean cases;
    private String code;
    private Hotel h_hotel;
    private String message;
    ShareMessage sharemessage;

    protected CaseDetailsBean(Parcel in) {
        code = in.readString();
        message = in.readString();
        sharemessage = in.readParcelable(ShareMessage.class.getClassLoader());
    }

    public static final Creator<CaseDetailsBean> CREATOR = new Creator<CaseDetailsBean>() {
        @Override
        public CaseDetailsBean createFromParcel(Parcel in) {
            return new CaseDetailsBean(in);
        }

        @Override
        public CaseDetailsBean[] newArray(int size) {
            return new CaseDetailsBean[size];
        }
    };

    public CasesBean getCases() {
        return this.cases;
    }

    public String getCode() {
        return this.code;
    }

    public Hotel getH_hotel() {
        return this.h_hotel;
    }

    public String getMessage() {
        return this.message;
    }

    public ShareMessage getSharemessage() {
        return this.sharemessage;
    }

    public void setCases(CasesBean paramCasesBean) {
        this.cases = paramCasesBean;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setH_hotel(Hotel paramHotel) {
        this.h_hotel = paramHotel;
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
        dest.writeString(code);
        dest.writeString(message);
        dest.writeParcelable(sharemessage, flags);
    }

    public static class CasesBean {
        private String case_collect;
        private List<?> case_comment;
        private String case_descr;
        private String case_evaluation_count;
        private String case_id;
        private String case_images;
        private List<CaseListBean> case_list;
        private String case_status;
        private String case_title;
        private int height;
        private int iscancel;
        private String price;
        private String sc_name;
        private String store_avatar;
        private String store_id;
        private String store_label;
        private String store_name;
        private int width;

        public String getCase_collect() {
            return this.case_collect;
        }

        public List<?> getCase_comment() {
            return this.case_comment;
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

        public List<CaseListBean> getCase_list() {
            return this.case_list;
        }

        public String getCase_status() {
            return this.case_status;
        }

        public String getCase_title() {
            return this.case_title;
        }

        public int getHeight() {
            return this.height;
        }

        public int getIscancel() {
            return this.iscancel;
        }

        public String getPrice() {
            return this.price;
        }

        public String getSc_name() {
            return this.sc_name;
        }

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_label() {
            return this.store_label;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public int getWidth() {
            return this.width;
        }

        public void setCase_collect(String paramString) {
            this.case_collect = paramString;
        }

        public void setCase_comment(List<?> paramList) {
            this.case_comment = paramList;
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

        public void setCase_list(List<CaseListBean> paramList) {
            this.case_list = paramList;
        }

        public void setCase_status(String paramString) {
            this.case_status = paramString;
        }

        public void setCase_title(String paramString) {
            this.case_title = paramString;
        }

        public void setIscancel(int paramInt) {
            this.iscancel = paramInt;
        }

        public void setPrice(String paramString) {
            this.price = paramString;
        }

        public void setSc_name(String paramString) {
            this.sc_name = paramString;
        }

        public void setStore_avatar(String paramString) {
            this.store_avatar = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        public void setStore_label(String paramString) {
            this.store_label = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        public static class CaseListBean implements Parcelable {
            private String case_image;
            private String content;
            private int height;
            private int width;

            protected CaseListBean(Parcel in) {
                case_image = in.readString();
                content = in.readString();
                height = in.readInt();
                width = in.readInt();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(case_image);
                dest.writeString(content);
                dest.writeInt(height);
                dest.writeInt(width);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<CaseListBean> CREATOR = new Creator<CaseListBean>() {
                @Override
                public CaseListBean createFromParcel(Parcel in) {
                    return new CaseListBean(in);
                }

                @Override
                public CaseListBean[] newArray(int size) {
                    return new CaseListBean[size];
                }
            };

            public String getCase_image() {
                return this.case_image;
            }

            public String getContent() {
                if (this.content == null) {
                    return "";
                }
                return this.content;
            }

            public int getHeight() {
                return this.height;
            }

            public int getWidth() {
                return this.width;
            }

            public void setCase_image(String paramString) {
                this.case_image = paramString;
            }

            public void setContent(String paramString) {
                this.content = paramString;
            }
        }
    }

    public static class Hotel {
        private String address;
        private String appintroduce;
        private String areaid;
        private String coord;
        private String corkagefee;
        private String coverimage;
        private String createtime;
        private String feastid;
        private String id;
        private String introduce;
        private String isdelete;
        private String isrecommend;
        private String latitude;
        private String lawn;
        private String listorder;
        private String longitude;
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
    }
}
