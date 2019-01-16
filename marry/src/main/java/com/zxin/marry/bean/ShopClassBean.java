package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ShopClassBean {
    private String code;
    private List<EcshopBean> ecshop;
    private String feastid;
    private String message;
    private ArrayList<Posts> posts;
    private List<RecommendForm.RecommendAdv> recommend_adv;
    private List<RecommendGoodsBean> recommend_goods;
    private String store_count;
    private List<TaoBaoProduct> taobaoke_goods;

    public String getCode() {
        return this.code;
    }

    public List<EcshopBean> getEcshop() {
        if (this.ecshop == null) {
            return new ArrayList();
        }
        return this.ecshop;
    }

    public List<EcshopBean> getValidEcshopList() {
        List<EcshopBean> list = new ArrayList<>();
        if (this.ecshop == null) {
            return list;
        }
        for (EcshopBean ecshopBean :ecshop){
            if (ecshopBean.getGoods_commend()==null||ecshopBean.getGoods_commend().isEmpty())
                continue;
            list.add(ecshopBean);
        }
        return list;
    }

    public String getFeastid() {
        return this.feastid;
    }

    public String getMessage() {
        return this.message;
    }

    public ArrayList<Posts> getPosts() {
        return this.posts;
    }

    public List<RecommendForm.RecommendAdv> getRecommend_adv() {
        if (this.recommend_adv == null) {
            return new ArrayList();
        }
        return this.recommend_adv;
    }

    public List<RecommendGoodsBean> getRecommend_goods() {
        if (this.recommend_goods == null) {
            return new ArrayList();
        }
        return this.recommend_goods;
    }

    public String getStore_count() {
        if (this.store_count == null) {
            return "";
        }
        return this.store_count;
    }

    public List<TaoBaoProduct> getTaobaoke_goods() {
        if (this.taobaoke_goods == null) {
            return new ArrayList();
        }
        return this.taobaoke_goods;
    }


    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class Posts  implements Parcelable {
        private String id;
        private String post_title;

        protected Posts(Parcel in) {
            id = in.readString();
            post_title = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(post_title);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Posts> CREATOR = new Creator<Posts>() {
            @Override
            public Posts createFromParcel(Parcel in) {
                return new Posts(in);
            }

            @Override
            public Posts[] newArray(int size) {
                return new Posts[size];
            }
        };

        public String getId() {
            return this.id;
        }

        public String getPost_title() {
            return this.post_title;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setPost_title(String paramString) {
            this.post_title = paramString;
        }
    }

    public static class RecommendGoodsBean {
        private String goods_commonid;
        private String goods_id;
        private String goods_image;
        private String goods_jingle;
        private String goods_marketprice;
        private String goods_name;
        private String goods_price;
        private String goods_promotion_price;
        private String store_avatar;
        private String store_banner;
        private String store_id;
        private String store_label;
        private String store_name;
        private String store_sc_name;

        public String getGoods_commonid() {
            return this.goods_commonid;
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

        public String getStore_avatar() {
            return this.store_avatar;
        }

        public String getStore_banner() {
            return this.store_banner;
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

        public String getStore_sc_name() {
            return this.store_sc_name;
        }

        public void setGoods_commonid(String paramString) {
            this.goods_commonid = paramString;
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

        public void setStore_avatar(String paramString) {
            this.store_avatar = paramString;
        }

        public void setStore_banner(String paramString) {
            this.store_banner = paramString;
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

        public void setStore_sc_name(String paramString) {
            this.store_sc_name = paramString;
        }
    }

    public static class TaoBaoProduct
            implements Parcelable {
        public static final Parcelable.Creator<TaoBaoProduct> CREATOR = new Parcelable.Creator() {
            public ShopClassBean.TaoBaoProduct createFromParcel(Parcel paramAnonymousParcel) {
                return new ShopClassBean.TaoBaoProduct(paramAnonymousParcel);
            }

            public ShopClassBean.TaoBaoProduct[] newArray(int paramAnonymousInt) {
                return new ShopClassBean.TaoBaoProduct[paramAnonymousInt];
            }
        };
        String content;
        String freight_payer;
        String id;
        String nick;
        String open_iid;
        String pic_url;
        String price;
        String promotion_price;
        String shop_type;
        String title;

        public TaoBaoProduct() {
        }

        protected TaoBaoProduct(Parcel paramParcel) {
            this.id = paramParcel.readString();
            this.open_iid = paramParcel.readString();
            this.title = paramParcel.readString();
            this.price = paramParcel.readString();
            this.promotion_price = paramParcel.readString();
            this.nick = paramParcel.readString();
            this.pic_url = paramParcel.readString();
            this.freight_payer = paramParcel.readString();
            this.shop_type = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getContent() {
            return this.content;
        }

        public String getFreight_payer() {
            return this.freight_payer;
        }

        public String getId() {
            return this.id;
        }

        public String getNick() {
            return this.nick;
        }

        public String getOpen_iid() {
            return this.open_iid;
        }

        public String getPic_url() {
            return this.pic_url;
        }

        public String getPrice() {
            return this.price;
        }

        public String getPromotion_price() {
            return this.promotion_price;
        }

        public String getShop_type() {
            return this.shop_type;
        }

        public String getTitle() {
            return this.title;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.id);
            paramParcel.writeString(this.open_iid);
            paramParcel.writeString(this.title);
            paramParcel.writeString(this.price);
            paramParcel.writeString(this.promotion_price);
            paramParcel.writeString(this.nick);
            paramParcel.writeString(this.pic_url);
            paramParcel.writeString(this.freight_payer);
            paramParcel.writeString(this.shop_type);
        }
    }
}
