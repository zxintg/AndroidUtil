package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/28.
 */

public class GoodsDetailsBean {
    private String code;
    private GoodsBean goods;
    private String message;
    private ShareMessage sharemessage;

    public String getCode() {
        return this.code;
    }

    public GoodsBean getGoods() {
        return this.goods;
    }

    public String getMessage() {
        return this.message;
    }

    public ShareMessage getSharemessage() {
        return this.sharemessage;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setGoods(GoodsBean paramGoodsBean) {
        this.goods = paramGoodsBean;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class GoodsBean implements Parcelable {
        private String areaid_1;
        private String areaid_2;
        private String brand_id;
        private String color_id;
        private String evaluation_count;
        private String evaluation_good_star;
        private String gc_id;
        private String gc_id1;
        private String gc_id1_1;
        private String gc_id1_2;
        private String gc_id1_3;
        private String gc_id_1;
        private String gc_id_2;
        private String gc_id_3;
        private String gc_name;
        private String goods_addtime;
        private String goods_click;
        private String goods_collect;
        private String goods_commend;
        private String goods_commonid;
        private String goods_edittime;
        private String goods_freight;
        private String goods_id;
        private String goods_image;
        private String goods_jingle;
        private List<GoodsListBean> goods_list;
        private String goods_marketprice;
        private String goods_name;
        private String goods_price;
        private String goods_promotion_price;
        private String goods_promotion_type;
        private String goods_salenum;
        private String goods_serial;
        private String goods_spec;
        private String goods_state;
        private String goods_stcids;
        private String goods_storage;
        private String goods_storage_alarm;
        String goods_uid;
        private String goods_vat;
        private String goods_verify;
        private String have_gift;
        private String is_appoint;
        private String is_appointment;
        private String is_fcode;
        private String is_own_shop;
        private String is_presell;
        private String is_virtual;
        private int iscancel;
        private List<MobileBodyBean> mobile_body;
        private String sc_name;
        private String store_avatar;
        private String store_id;
        private String store_name;
        private String transport_id;
        private String virtual_indate;
        private String virtual_invalid_refund;
        private String virtual_limit;

        protected GoodsBean(Parcel in) {
            areaid_1 = in.readString();
            areaid_2 = in.readString();
            brand_id = in.readString();
            color_id = in.readString();
            evaluation_count = in.readString();
            evaluation_good_star = in.readString();
            gc_id = in.readString();
            gc_id1 = in.readString();
            gc_id1_1 = in.readString();
            gc_id1_2 = in.readString();
            gc_id1_3 = in.readString();
            gc_id_1 = in.readString();
            gc_id_2 = in.readString();
            gc_id_3 = in.readString();
            gc_name = in.readString();
            goods_addtime = in.readString();
            goods_click = in.readString();
            goods_collect = in.readString();
            goods_commend = in.readString();
            goods_commonid = in.readString();
            goods_edittime = in.readString();
            goods_freight = in.readString();
            goods_id = in.readString();
            goods_image = in.readString();
            goods_jingle = in.readString();
            goods_list = in.createTypedArrayList(GoodsListBean.CREATOR);
            goods_marketprice = in.readString();
            goods_name = in.readString();
            goods_price = in.readString();
            goods_promotion_price = in.readString();
            goods_promotion_type = in.readString();
            goods_salenum = in.readString();
            goods_serial = in.readString();
            goods_spec = in.readString();
            goods_state = in.readString();
            goods_stcids = in.readString();
            goods_storage = in.readString();
            goods_storage_alarm = in.readString();
            goods_uid = in.readString();
            goods_vat = in.readString();
            goods_verify = in.readString();
            have_gift = in.readString();
            is_appoint = in.readString();
            is_appointment = in.readString();
            is_fcode = in.readString();
            is_own_shop = in.readString();
            is_presell = in.readString();
            is_virtual = in.readString();
            iscancel = in.readInt();
            mobile_body = in.createTypedArrayList(MobileBodyBean.CREATOR);
            sc_name = in.readString();
            store_avatar = in.readString();
            store_id = in.readString();
            store_name = in.readString();
            transport_id = in.readString();
            virtual_indate = in.readString();
            virtual_invalid_refund = in.readString();
            virtual_limit = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(areaid_1);
            dest.writeString(areaid_2);
            dest.writeString(brand_id);
            dest.writeString(color_id);
            dest.writeString(evaluation_count);
            dest.writeString(evaluation_good_star);
            dest.writeString(gc_id);
            dest.writeString(gc_id1);
            dest.writeString(gc_id1_1);
            dest.writeString(gc_id1_2);
            dest.writeString(gc_id1_3);
            dest.writeString(gc_id_1);
            dest.writeString(gc_id_2);
            dest.writeString(gc_id_3);
            dest.writeString(gc_name);
            dest.writeString(goods_addtime);
            dest.writeString(goods_click);
            dest.writeString(goods_collect);
            dest.writeString(goods_commend);
            dest.writeString(goods_commonid);
            dest.writeString(goods_edittime);
            dest.writeString(goods_freight);
            dest.writeString(goods_id);
            dest.writeString(goods_image);
            dest.writeString(goods_jingle);
            dest.writeTypedList(goods_list);
            dest.writeString(goods_marketprice);
            dest.writeString(goods_name);
            dest.writeString(goods_price);
            dest.writeString(goods_promotion_price);
            dest.writeString(goods_promotion_type);
            dest.writeString(goods_salenum);
            dest.writeString(goods_serial);
            dest.writeString(goods_spec);
            dest.writeString(goods_state);
            dest.writeString(goods_stcids);
            dest.writeString(goods_storage);
            dest.writeString(goods_storage_alarm);
            dest.writeString(goods_uid);
            dest.writeString(goods_vat);
            dest.writeString(goods_verify);
            dest.writeString(have_gift);
            dest.writeString(is_appoint);
            dest.writeString(is_appointment);
            dest.writeString(is_fcode);
            dest.writeString(is_own_shop);
            dest.writeString(is_presell);
            dest.writeString(is_virtual);
            dest.writeInt(iscancel);
            dest.writeTypedList(mobile_body);
            dest.writeString(sc_name);
            dest.writeString(store_avatar);
            dest.writeString(store_id);
            dest.writeString(store_name);
            dest.writeString(transport_id);
            dest.writeString(virtual_indate);
            dest.writeString(virtual_invalid_refund);
            dest.writeString(virtual_limit);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<GoodsBean> CREATOR = new Creator<GoodsBean>() {
            @Override
            public GoodsBean createFromParcel(Parcel in) {
                return new GoodsBean(in);
            }

            @Override
            public GoodsBean[] newArray(int size) {
                return new GoodsBean[size];
            }
        };

        public String getAreaid_1() {
            return this.areaid_1;
        }

        public String getAreaid_2() {
            return this.areaid_2;
        }

        public String getBrand_id() {
            return this.brand_id;
        }

        public String getColor_id() {
            return this.color_id;
        }

        public String getEvaluation_count() {
            return this.evaluation_count;
        }

        public String getEvaluation_good_star() {
            return this.evaluation_good_star;
        }

        public String getGc_id() {
            return this.gc_id;
        }

        public String getGc_id1() {
            return this.gc_id1;
        }

        public String getGc_id1_1() {
            return this.gc_id1_1;
        }

        public String getGc_id1_2() {
            return this.gc_id1_2;
        }

        public String getGc_id1_3() {
            return this.gc_id1_3;
        }

        public String getGc_id_1() {
            return this.gc_id_1;
        }

        public String getGc_id_2() {
            return this.gc_id_2;
        }

        public String getGc_id_3() {
            return this.gc_id_3;
        }

        public String getGc_name() {
            return this.gc_name;
        }

        public String getGoods_addtime() {
            return this.goods_addtime;
        }

        public String getGoods_click() {
            return this.goods_click;
        }

        public String getGoods_collect() {
            return this.goods_collect;
        }

        public String getGoods_commend() {
            return this.goods_commend;
        }

        public String getGoods_commonid() {
            return this.goods_commonid;
        }

        public String getGoods_edittime() {
            return this.goods_edittime;
        }

        public String getGoods_freight() {
            return this.goods_freight;
        }

        public String getGoods_id() {
            return this.goods_id;
        }

        public String getGoods_image() {
            return this.goods_image;
        }

        public String getGoods_jingle() {
            return this.goods_jingle;
        }

        public List<GoodsListBean> getGoods_list() {
            if (this.goods_list == null) {
                return new ArrayList();
            }
            return this.goods_list;
        }

        public String getGoods_marketprice() {
            return this.goods_marketprice;
        }

        public String getGoods_name() {
            return this.goods_name;
        }

        public String getGoods_price() {
            return this.goods_price;
        }

        public String getGoods_promotion_price() {
            return this.goods_promotion_price;
        }

        public String getGoods_promotion_type() {
            return this.goods_promotion_type;
        }

        public String getGoods_salenum() {
            return this.goods_salenum;
        }

        public String getGoods_serial() {
            return this.goods_serial;
        }

        public String getGoods_spec() {
            return this.goods_spec;
        }

        public String getGoods_state() {
            return this.goods_state;
        }

        public String getGoods_stcids() {
            return this.goods_stcids;
        }

        public String getGoods_storage() {
            return this.goods_storage;
        }

        public String getGoods_storage_alarm() {
            return this.goods_storage_alarm;
        }

        public String getGoods_uid() {
            if (this.goods_uid == null) {
                return "";
            }
            return this.goods_uid;
        }

        public String getGoods_vat() {
            return this.goods_vat;
        }

        public String getGoods_verify() {
            return this.goods_verify;
        }

        public String getHave_gift() {
            return this.have_gift;
        }

        public String getIs_appoint() {
            return this.is_appoint;
        }

        public String getIs_appointment() {
            return this.is_appointment;
        }

        public String getIs_fcode() {
            return this.is_fcode;
        }

        public String getIs_own_shop() {
            return this.is_own_shop;
        }

        public String getIs_presell() {
            return this.is_presell;
        }

        public String getIs_virtual() {
            return this.is_virtual;
        }

        public int getIscancel() {
            return this.iscancel;
        }

        public List<MobileBodyBean> getMobile_body() {
            return this.mobile_body;
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

        public String getStore_name() {
            return this.store_name;
        }

        public String getTransport_id() {
            return this.transport_id;
        }

        public String getVirtual_indate() {
            return this.virtual_indate;
        }

        public String getVirtual_invalid_refund() {
            return this.virtual_invalid_refund;
        }

        public String getVirtual_limit() {
            if (this.virtual_limit == null) {
                this.virtual_limit = "0";
            }
            return this.virtual_limit;
        }

        public void setAreaid_1(String paramString) {
            this.areaid_1 = paramString;
        }

        public void setAreaid_2(String paramString) {
            this.areaid_2 = paramString;
        }

        public void setBrand_id(String paramString) {
            this.brand_id = paramString;
        }

        public void setColor_id(String paramString) {
            this.color_id = paramString;
        }

        public void setEvaluation_count(String paramString) {
            this.evaluation_count = paramString;
        }

        public void setEvaluation_good_star(String paramString) {
            this.evaluation_good_star = paramString;
        }

        public void setGc_id(String paramString) {
            this.gc_id = paramString;
        }

        public void setGc_id1(String paramString) {
            this.gc_id1 = paramString;
        }

        public void setGc_id1_1(String paramString) {
            this.gc_id1_1 = paramString;
        }

        public void setGc_id1_2(String paramString) {
            this.gc_id1_2 = paramString;
        }

        public void setGc_id1_3(String paramString) {
            this.gc_id1_3 = paramString;
        }

        public void setGc_id_1(String paramString) {
            this.gc_id_1 = paramString;
        }

        public void setGc_id_2(String paramString) {
            this.gc_id_2 = paramString;
        }

        public void setGc_id_3(String paramString) {
            this.gc_id_3 = paramString;
        }

        public void setGc_name(String paramString) {
            this.gc_name = paramString;
        }

        public void setGoods_addtime(String paramString) {
            this.goods_addtime = paramString;
        }

        public void setGoods_click(String paramString) {
            this.goods_click = paramString;
        }

        public void setGoods_collect(String paramString) {
            this.goods_collect = paramString;
        }

        public void setGoods_commend(String paramString) {
            this.goods_commend = paramString;
        }

        public void setGoods_commonid(String paramString) {
            this.goods_commonid = paramString;
        }

        public void setGoods_edittime(String paramString) {
            this.goods_edittime = paramString;
        }

        public void setGoods_freight(String paramString) {
            this.goods_freight = paramString;
        }

        public void setGoods_id(String paramString) {
            this.goods_id = paramString;
        }

        public void setGoods_image(String paramString) {
            this.goods_image = paramString;
        }

        public void setGoods_jingle(String paramString) {
            this.goods_jingle = paramString;
        }

        public void setGoods_list(List<GoodsListBean> paramList) {
            this.goods_list = paramList;
        }

        public void setGoods_marketprice(String paramString) {
            this.goods_marketprice = paramString;
        }

        public void setGoods_name(String paramString) {
            this.goods_name = paramString;
        }

        public void setGoods_price(String paramString) {
            this.goods_price = paramString;
        }

        public void setGoods_promotion_price(String paramString) {
            this.goods_promotion_price = paramString;
        }

        public void setGoods_promotion_type(String paramString) {
            this.goods_promotion_type = paramString;
        }

        public void setGoods_salenum(String paramString) {
            this.goods_salenum = paramString;
        }

        public void setGoods_serial(String paramString) {
            this.goods_serial = paramString;
        }

        public void setGoods_spec(String paramString) {
            this.goods_spec = paramString;
        }

        public void setGoods_state(String paramString) {
            this.goods_state = paramString;
        }

        public void setGoods_stcids(String paramString) {
            this.goods_stcids = paramString;
        }

        public void setGoods_storage(String paramString) {
            this.goods_storage = paramString;
        }

        public void setGoods_storage_alarm(String paramString) {
            this.goods_storage_alarm = paramString;
        }

        public void setGoods_vat(String paramString) {
            this.goods_vat = paramString;
        }

        public void setGoods_verify(String paramString) {
            this.goods_verify = paramString;
        }

        public void setHave_gift(String paramString) {
            this.have_gift = paramString;
        }

        public void setIs_appoint(String paramString) {
            this.is_appoint = paramString;
        }

        public void setIs_appointment(String paramString) {
            this.is_appointment = paramString;
        }

        public void setIs_fcode(String paramString) {
            this.is_fcode = paramString;
        }

        public void setIs_own_shop(String paramString) {
            this.is_own_shop = paramString;
        }

        public void setIs_presell(String paramString) {
            this.is_presell = paramString;
        }

        public void setIs_virtual(String paramString) {
            this.is_virtual = paramString;
        }

        public void setIscancel(int paramInt) {
            this.iscancel = paramInt;
        }

        public void setMobile_body(List<MobileBodyBean> paramList) {
            this.mobile_body = paramList;
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

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        public void setTransport_id(String paramString) {
            this.transport_id = paramString;
        }

        public void setVirtual_indate(String paramString) {
            this.virtual_indate = paramString;
        }

        public void setVirtual_invalid_refund(String paramString) {
            this.virtual_invalid_refund = paramString;
        }

        public void setVirtual_limit(String paramString) {
            this.virtual_limit = paramString;
        }

        public static class GoodsListBean implements Parcelable {
            private String goods_image;
            int height;
            int width;

            protected GoodsListBean(Parcel in) {
                goods_image = in.readString();
                height = in.readInt();
                width = in.readInt();
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(goods_image);
                dest.writeInt(height);
                dest.writeInt(width);
            }

            @Override
            public int describeContents() {
                return 0;
            }

            public static final Creator<GoodsListBean> CREATOR = new Creator<GoodsListBean>() {
                @Override
                public GoodsListBean createFromParcel(Parcel in) {
                    return new GoodsListBean(in);
                }

                @Override
                public GoodsListBean[] newArray(int size) {
                    return new GoodsListBean[size];
                }
            };

            public String getGoods_image() {
                return this.goods_image;
            }

            public int getHeight() {
                return this.height;
            }

            public int getWidth() {
                return this.width;
            }

            public void setGoods_image(String paramString) {
                this.goods_image = paramString;
            }
        }

        public static class MobileBodyBean implements Parcelable {
            int height;
            private String type;
            private String value;
            int width;

            protected MobileBodyBean(Parcel in) {
                height = in.readInt();
                type = in.readString();
                value = in.readString();
                width = in.readInt();
            }

            public static final Creator<MobileBodyBean> CREATOR = new Creator<MobileBodyBean>() {
                @Override
                public MobileBodyBean createFromParcel(Parcel in) {
                    return new MobileBodyBean(in);
                }

                @Override
                public MobileBodyBean[] newArray(int size) {
                    return new MobileBodyBean[size];
                }
            };

            public int getHeight() {
                return this.height;
            }

            public String getType() {
                return this.type;
            }

            public String getValue() {
                return this.value;
            }

            public int getWidth() {
                return this.width;
            }

            public void setType(String paramString) {
                this.type = paramString;
            }

            public void setValue(String paramString) {
                this.value = paramString;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(height);
                dest.writeString(type);
                dest.writeString(value);
                dest.writeInt(width);
            }
        }
    }
}
