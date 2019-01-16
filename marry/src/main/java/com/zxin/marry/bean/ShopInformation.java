package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/27.
 */

public class ShopInformation implements Parcelable{
    private List<EcshopBean> caseRes;
    private String code;
    private List<EcshopBean> ecshop;
    private List<EcshopBean> goodsRes;
    private String message;
    private Page page;

    protected ShopInformation(Parcel in) {
        caseRes = in.createTypedArrayList(EcshopBean.CREATOR);
        code = in.readString();
        ecshop = in.createTypedArrayList(EcshopBean.CREATOR);
        goodsRes = in.createTypedArrayList(EcshopBean.CREATOR);
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(caseRes);
        dest.writeString(code);
        dest.writeTypedList(ecshop);
        dest.writeTypedList(goodsRes);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ShopInformation> CREATOR = new Creator<ShopInformation>() {
        @Override
        public ShopInformation createFromParcel(Parcel in) {
            return new ShopInformation(in);
        }

        @Override
        public ShopInformation[] newArray(int size) {
            return new ShopInformation[size];
        }
    };

    public List<EcshopBean> getCaseRes() {
        if (this.caseRes == null) {
            return new ArrayList();
        }
        return this.caseRes;
    }

    public String getCode() {
        return this.code;
    }

    public List<EcshopBean> getEcshop() {
        if (this.ecshop == null) {
            return new ArrayList();
        }
        return this.ecshop;
    }

    public List<EcshopBean> getGoodsRes() {
        if (this.goodsRes == null) {
            return new ArrayList();
        }
        return this.goodsRes;
    }

    public String getMessage() {
        return this.message;
    }

    public Page getPage() {
        return this.page;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setEcshop(List<EcshopBean> paramList) {
        this.ecshop = paramList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class EcshopBean implements Parcelable {
        private String area_info;
        private String bind_all_gc;
        private String case_collect;
        private String case_descr;
        String case_id;
        private String case_images;
        private String case_title;
        private String cases_count;
        private List<GiftBean> gift;
        private String goods_count;
        String goods_id;
        private String goods_image;
        private String goods_jingle;
        private List<GoodsListBean> goods_list;
        private String goods_marketprice;
        private String goods_name;
        private String goods_price;
        private String grade_id;
        private String is_own_shop;
        private String live_store_address;
        private String live_store_bus;
        private String live_store_name;
        private String live_store_tel;
        private String member_id;
        private String member_name;
        private String province_id;
        private String sc_id;
        private String sc_name;
        private String seller_name;
        private String store_address;
        private Object store_aftersales;
        private String store_avatar;
        private String store_banner;
        private String store_baozh;
        private String store_baozhopen;
        private String store_baozhrmb;
        private String store_case;
        private String store_close_info;
        private String store_collect;
        private String store_company_name;
        private String store_credit;
        private String store_decoration_image_count;
        private String store_decoration_only;
        private String store_decoration_switch;
        private String store_deliverycredit;
        private String store_desccredit;
        private String store_description;
        private Object store_domain;
        private String store_domain_times;
        private String store_end_time;
        private String store_erxiaoshi;
        private String store_free_price;
        private Object store_free_time;
        private String store_huodaofk;
        private String store_id;
        private String store_keywords;
        private String store_label;
        private String store_name;
        private String store_phone;
        private Object store_presales;
        private Object store_printdesc;
        private String store_qq;
        private String store_qtian;
        private String store_recommend;
        private String store_sales;
        private String store_servicecredit;
        private String store_shiti;
        private String store_shiyong;
        private Object store_slide;
        private Object store_slide_url;
        private String store_sort;
        private Object store_stamp;
        private String store_state;
        private String store_theme;
        private String store_time;
        private String store_tuihuo;
        private String store_vrcode_prefix;
        private Object store_workingtime;
        private String store_ww;
        private String store_xiaoxie;
        private String store_zhping;
        private String store_zip;
        private String store_zy;

        protected EcshopBean(Parcel in) {
            area_info = in.readString();
            bind_all_gc = in.readString();
            case_collect = in.readString();
            case_descr = in.readString();
            case_id = in.readString();
            case_images = in.readString();
            case_title = in.readString();
            cases_count = in.readString();
            gift = in.createTypedArrayList(GiftBean.CREATOR);
            goods_count = in.readString();
            goods_id = in.readString();
            goods_image = in.readString();
            goods_jingle = in.readString();
            goods_marketprice = in.readString();
            goods_name = in.readString();
            goods_price = in.readString();
            grade_id = in.readString();
            is_own_shop = in.readString();
            live_store_address = in.readString();
            live_store_bus = in.readString();
            live_store_name = in.readString();
            live_store_tel = in.readString();
            member_id = in.readString();
            member_name = in.readString();
            province_id = in.readString();
            sc_id = in.readString();
            sc_name = in.readString();
            seller_name = in.readString();
            store_address = in.readString();
            store_avatar = in.readString();
            store_banner = in.readString();
            store_baozh = in.readString();
            store_baozhopen = in.readString();
            store_baozhrmb = in.readString();
            store_case = in.readString();
            store_close_info = in.readString();
            store_collect = in.readString();
            store_company_name = in.readString();
            store_credit = in.readString();
            store_decoration_image_count = in.readString();
            store_decoration_only = in.readString();
            store_decoration_switch = in.readString();
            store_deliverycredit = in.readString();
            store_desccredit = in.readString();
            store_description = in.readString();
            store_domain_times = in.readString();
            store_end_time = in.readString();
            store_erxiaoshi = in.readString();
            store_free_price = in.readString();
            store_huodaofk = in.readString();
            store_id = in.readString();
            store_keywords = in.readString();
            store_label = in.readString();
            store_name = in.readString();
            store_phone = in.readString();
            store_qq = in.readString();
            store_qtian = in.readString();
            store_recommend = in.readString();
            store_sales = in.readString();
            store_servicecredit = in.readString();
            store_shiti = in.readString();
            store_shiyong = in.readString();
            store_sort = in.readString();
            store_state = in.readString();
            store_theme = in.readString();
            store_time = in.readString();
            store_tuihuo = in.readString();
            store_vrcode_prefix = in.readString();
            store_ww = in.readString();
            store_xiaoxie = in.readString();
            store_zhping = in.readString();
            store_zip = in.readString();
            store_zy = in.readString();
        }

        public static final Creator<EcshopBean> CREATOR = new Creator<EcshopBean>() {
            @Override
            public EcshopBean createFromParcel(Parcel in) {
                return new EcshopBean(in);
            }

            @Override
            public EcshopBean[] newArray(int size) {
                return new EcshopBean[size];
            }
        };

        public String getArea_info() {
            return this.area_info;
        }

        public String getBind_all_gc() {
            return this.bind_all_gc;
        }

        public String getCase_collect() {
            return this.case_collect;
        }

        public String getCase_descr() {
            return this.case_descr;
        }

        public String getCase_id() {
            return this.case_id;
        }

        public String getCase_images() {
            return this.case_images;
        }

        public String getCase_title() {
            return this.case_title;
        }

        public String getCases_count() {
            return this.cases_count;
        }

        public List<GiftBean> getGift() {
            if (this.gift == null) {
                return new ArrayList();
            }
            return this.gift;
        }

        public String getGoods_count() {
            return this.goods_count;
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

        public String getGrade_id() {
            if (this.grade_id == null) {
                return "";
            }
            return this.grade_id;
        }

        public String getIs_own_shop() {
            return this.is_own_shop;
        }

        public String getLive_store_address() {
            return this.live_store_address;
        }

        public String getLive_store_bus() {
            return this.live_store_bus;
        }

        public String getLive_store_name() {
            return this.live_store_name;
        }

        public String getLive_store_tel() {
            return this.live_store_tel;
        }

        public String getMember_id() {
            return this.member_id;
        }

        public String getMember_name() {
            return this.member_name;
        }

        public String getProvince_id() {
            return this.province_id;
        }

        public String getSc_id() {
            return this.sc_id;
        }

        public String getSc_name() {
            return this.sc_name;
        }

        public String getSeller_name() {
            return this.seller_name;
        }

        public String getStore_address() {
            return this.store_address;
        }

        public Object getStore_aftersales() {
            return this.store_aftersales;
        }

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_banner() {
            return this.store_banner;
        }

        public String getStore_baozh() {
            return this.store_baozh;
        }

        public String getStore_baozhopen() {
            return this.store_baozhopen;
        }

        public String getStore_baozhrmb() {
            return this.store_baozhrmb;
        }

        public String getStore_case() {
            return this.store_case;
        }

        public String getStore_close_info() {
            return this.store_close_info;
        }

        public String getStore_collect() {
            return this.store_collect;
        }

        public String getStore_company_name() {
            return this.store_company_name;
        }

        public String getStore_credit() {
            return this.store_credit;
        }

        public String getStore_decoration_image_count() {
            return this.store_decoration_image_count;
        }

        public String getStore_decoration_only() {
            return this.store_decoration_only;
        }

        public String getStore_decoration_switch() {
            return this.store_decoration_switch;
        }

        public String getStore_deliverycredit() {
            return this.store_deliverycredit;
        }

        public String getStore_desccredit() {
            return this.store_desccredit;
        }

        public String getStore_description() {
            return this.store_description;
        }

        public Object getStore_domain() {
            return this.store_domain;
        }

        public String getStore_domain_times() {
            return this.store_domain_times;
        }

        public String getStore_end_time() {
            return this.store_end_time;
        }

        public String getStore_erxiaoshi() {
            return this.store_erxiaoshi;
        }

        public String getStore_free_price() {
            return this.store_free_price;
        }

        public Object getStore_free_time() {
            return this.store_free_time;
        }

        public String getStore_huodaofk() {
            return this.store_huodaofk;
        }

        public String getStore_id() {
            return this.store_id;
        }

        public String getStore_keywords() {
            return this.store_keywords;
        }

        public String getStore_label() {
            return this.store_label;
        }

        public String getStore_name() {
            return this.store_name;
        }

        public String getStore_phone() {
            return this.store_phone;
        }

        public Object getStore_presales() {
            return this.store_presales;
        }

        public Object getStore_printdesc() {
            return this.store_printdesc;
        }

        public String getStore_qq() {
            return this.store_qq;
        }

        public String getStore_qtian() {
            return this.store_qtian;
        }

        public String getStore_recommend() {
            return this.store_recommend;
        }

        public String getStore_sales() {
            return this.store_sales;
        }

        public String getStore_servicecredit() {
            return this.store_servicecredit;
        }

        public String getStore_shiti() {
            return this.store_shiti;
        }

        public String getStore_shiyong() {
            return this.store_shiyong;
        }

        public Object getStore_slide() {
            return this.store_slide;
        }

        public Object getStore_slide_url() {
            return this.store_slide_url;
        }

        public String getStore_sort() {
            return this.store_sort;
        }

        public Object getStore_stamp() {
            return this.store_stamp;
        }

        public String getStore_state() {
            return this.store_state;
        }

        public String getStore_theme() {
            return this.store_theme;
        }

        public String getStore_time() {
            return this.store_time;
        }

        public String getStore_tuihuo() {
            return this.store_tuihuo;
        }

        public String getStore_vrcode_prefix() {
            return this.store_vrcode_prefix;
        }

        public Object getStore_workingtime() {
            return this.store_workingtime;
        }

        public String getStore_ww() {
            return this.store_ww;
        }

        public String getStore_xiaoxie() {
            return this.store_xiaoxie;
        }

        public String getStore_zhping() {
            return this.store_zhping;
        }

        public String getStore_zip() {
            return this.store_zip;
        }

        public String getStore_zy() {
            return this.store_zy;
        }

        public void setArea_info(String paramString) {
            this.area_info = paramString;
        }

        public void setBind_all_gc(String paramString) {
            this.bind_all_gc = paramString;
        }

        public void setCases_count(String paramString) {
            this.cases_count = paramString;
        }

        public void setGoods_count(String paramString) {
            this.goods_count = paramString;
        }

        public void setGoods_list(List<GoodsListBean> paramList) {
            this.goods_list = paramList;
        }

        public void setGrade_id(String paramString) {
            this.grade_id = paramString;
        }

        public void setIs_own_shop(String paramString) {
            this.is_own_shop = paramString;
        }

        public void setLive_store_address(String paramString) {
            this.live_store_address = paramString;
        }

        public void setLive_store_bus(String paramString) {
            this.live_store_bus = paramString;
        }

        public void setLive_store_name(String paramString) {
            this.live_store_name = paramString;
        }

        public void setLive_store_tel(String paramString) {
            this.live_store_tel = paramString;
        }

        public void setMember_id(String paramString) {
            this.member_id = paramString;
        }

        public void setMember_name(String paramString) {
            this.member_name = paramString;
        }

        public void setProvince_id(String paramString) {
            this.province_id = paramString;
        }

        public void setSc_id(String paramString) {
            this.sc_id = paramString;
        }

        public void setSc_name(String paramString) {
            this.sc_name = paramString;
        }

        public void setSeller_name(String paramString) {
            this.seller_name = paramString;
        }

        public void setStore_address(String paramString) {
            this.store_address = paramString;
        }

        public void setStore_aftersales(Object paramObject) {
            this.store_aftersales = paramObject;
        }

        public void setStore_avatar(String paramString) {
            this.store_avatar = paramString;
        }

        public void setStore_banner(String paramString) {
            this.store_banner = paramString;
        }

        public void setStore_baozh(String paramString) {
            this.store_baozh = paramString;
        }

        public void setStore_baozhopen(String paramString) {
            this.store_baozhopen = paramString;
        }

        public void setStore_baozhrmb(String paramString) {
            this.store_baozhrmb = paramString;
        }

        public void setStore_case(String paramString) {
            this.store_case = paramString;
        }

        public void setStore_close_info(String paramString) {
            this.store_close_info = paramString;
        }

        public void setStore_collect(String paramString) {
            this.store_collect = paramString;
        }

        public void setStore_company_name(String paramString) {
            this.store_company_name = paramString;
        }

        public void setStore_credit(String paramString) {
            this.store_credit = paramString;
        }

        public void setStore_decoration_image_count(String paramString) {
            this.store_decoration_image_count = paramString;
        }

        public void setStore_decoration_only(String paramString) {
            this.store_decoration_only = paramString;
        }

        public void setStore_decoration_switch(String paramString) {
            this.store_decoration_switch = paramString;
        }

        public void setStore_deliverycredit(String paramString) {
            this.store_deliverycredit = paramString;
        }

        public void setStore_desccredit(String paramString) {
            this.store_desccredit = paramString;
        }

        public void setStore_description(String paramString) {
            this.store_description = paramString;
        }

        public void setStore_domain(Object paramObject) {
            this.store_domain = paramObject;
        }

        public void setStore_domain_times(String paramString) {
            this.store_domain_times = paramString;
        }

        public void setStore_end_time(String paramString) {
            this.store_end_time = paramString;
        }

        public void setStore_erxiaoshi(String paramString) {
            this.store_erxiaoshi = paramString;
        }

        public void setStore_free_price(String paramString) {
            this.store_free_price = paramString;
        }

        public void setStore_free_time(Object paramObject) {
            this.store_free_time = paramObject;
        }

        public void setStore_huodaofk(String paramString) {
            this.store_huodaofk = paramString;
        }

        public void setStore_id(String paramString) {
            this.store_id = paramString;
        }

        public void setStore_keywords(String paramString) {
            this.store_keywords = paramString;
        }

        public void setStore_label(String paramString) {
            this.store_label = paramString;
        }

        public void setStore_name(String paramString) {
            this.store_name = paramString;
        }

        public void setStore_phone(String paramString) {
            this.store_phone = paramString;
        }

        public void setStore_presales(Object paramObject) {
            this.store_presales = paramObject;
        }

        public void setStore_printdesc(Object paramObject) {
            this.store_printdesc = paramObject;
        }

        public void setStore_qq(String paramString) {
            this.store_qq = paramString;
        }

        public void setStore_qtian(String paramString) {
            this.store_qtian = paramString;
        }

        public void setStore_recommend(String paramString) {
            this.store_recommend = paramString;
        }

        public void setStore_sales(String paramString) {
            this.store_sales = paramString;
        }

        public void setStore_servicecredit(String paramString) {
            this.store_servicecredit = paramString;
        }

        public void setStore_shiti(String paramString) {
            this.store_shiti = paramString;
        }

        public void setStore_shiyong(String paramString) {
            this.store_shiyong = paramString;
        }

        public void setStore_slide(Object paramObject) {
            this.store_slide = paramObject;
        }

        public void setStore_slide_url(Object paramObject) {
            this.store_slide_url = paramObject;
        }

        public void setStore_sort(String paramString) {
            this.store_sort = paramString;
        }

        public void setStore_stamp(Object paramObject) {
            this.store_stamp = paramObject;
        }

        public void setStore_state(String paramString) {
            this.store_state = paramString;
        }

        public void setStore_theme(String paramString) {
            this.store_theme = paramString;
        }

        public void setStore_time(String paramString) {
            this.store_time = paramString;
        }

        public void setStore_tuihuo(String paramString) {
            this.store_tuihuo = paramString;
        }

        public void setStore_vrcode_prefix(String paramString) {
            this.store_vrcode_prefix = paramString;
        }

        public void setStore_workingtime(Object paramObject) {
            this.store_workingtime = paramObject;
        }

        public void setStore_ww(String paramString) {
            this.store_ww = paramString;
        }

        public void setStore_xiaoxie(String paramString) {
            this.store_xiaoxie = paramString;
        }

        public void setStore_zhping(String paramString) {
            this.store_zhping = paramString;
        }

        public void setStore_zip(String paramString) {
            this.store_zip = paramString;
        }

        public void setStore_zy(String paramString) {
            this.store_zy = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(area_info);
            dest.writeString(bind_all_gc);
            dest.writeString(case_collect);
            dest.writeString(case_descr);
            dest.writeString(case_id);
            dest.writeString(case_images);
            dest.writeString(case_title);
            dest.writeString(cases_count);
            dest.writeTypedList(gift);
            dest.writeString(goods_count);
            dest.writeString(goods_id);
            dest.writeString(goods_image);
            dest.writeString(goods_jingle);
            dest.writeString(goods_marketprice);
            dest.writeString(goods_name);
            dest.writeString(goods_price);
            dest.writeString(grade_id);
            dest.writeString(is_own_shop);
            dest.writeString(live_store_address);
            dest.writeString(live_store_bus);
            dest.writeString(live_store_name);
            dest.writeString(live_store_tel);
            dest.writeString(member_id);
            dest.writeString(member_name);
            dest.writeString(province_id);
            dest.writeString(sc_id);
            dest.writeString(sc_name);
            dest.writeString(seller_name);
            dest.writeString(store_address);
            dest.writeString(store_avatar);
            dest.writeString(store_banner);
            dest.writeString(store_baozh);
            dest.writeString(store_baozhopen);
            dest.writeString(store_baozhrmb);
            dest.writeString(store_case);
            dest.writeString(store_close_info);
            dest.writeString(store_collect);
            dest.writeString(store_company_name);
            dest.writeString(store_credit);
            dest.writeString(store_decoration_image_count);
            dest.writeString(store_decoration_only);
            dest.writeString(store_decoration_switch);
            dest.writeString(store_deliverycredit);
            dest.writeString(store_desccredit);
            dest.writeString(store_description);
            dest.writeString(store_domain_times);
            dest.writeString(store_end_time);
            dest.writeString(store_erxiaoshi);
            dest.writeString(store_free_price);
            dest.writeString(store_huodaofk);
            dest.writeString(store_id);
            dest.writeString(store_keywords);
            dest.writeString(store_label);
            dest.writeString(store_name);
            dest.writeString(store_phone);
            dest.writeString(store_qq);
            dest.writeString(store_qtian);
            dest.writeString(store_recommend);
            dest.writeString(store_sales);
            dest.writeString(store_servicecredit);
            dest.writeString(store_shiti);
            dest.writeString(store_shiyong);
            dest.writeString(store_sort);
            dest.writeString(store_state);
            dest.writeString(store_theme);
            dest.writeString(store_time);
            dest.writeString(store_tuihuo);
            dest.writeString(store_vrcode_prefix);
            dest.writeString(store_ww);
            dest.writeString(store_xiaoxie);
            dest.writeString(store_zhping);
            dest.writeString(store_zip);
            dest.writeString(store_zy);
        }

        public static class GoodsListBean {
            private String goods_name;

            public String getGoods_name() {
                return this.goods_name;
            }

            public void setGoods_name(String paramString) {
                this.goods_name = paramString;
            }
        }
    }
}
