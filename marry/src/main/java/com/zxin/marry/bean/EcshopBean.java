package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */

public class EcshopBean {
    List<ShenMeGui> goods_commend;
    private String logo;
    private String sc_bail;
    private String sc_id;
    private String sc_name;
    private String sc_sort;

    public List<ShenMeGui> getGoods_commend() {
        if (this.goods_commend == null) {
            return new ArrayList();
        }
        return this.goods_commend;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getSc_bail() {
        return this.sc_bail;
    }

    public String getSc_id() {
        return this.sc_id;
    }

    public String getSc_name() {
        return this.sc_name;
    }

    public String getSc_sort() {
        return this.sc_sort;
    }

    /*public void setCardAdapter(MonsterFragment.CardAdapter paramCardAdapter) {
        this.cardAdapter = paramCardAdapter;
    }*/

    public void setLogo(String paramString) {
        this.logo = paramString;
    }

    public void setSc_bail(String paramString) {
        this.sc_bail = paramString;
    }

    public void setSc_id(String paramString) {
        this.sc_id = paramString;
    }

    public void setSc_name(String paramString) {
        this.sc_name = paramString;
    }

    public void setSc_sort(String paramString) {
        this.sc_sort = paramString;
    }

    public static class ShenMeGui {
        String goodid;
        String goodsmarketprice;
        String goodsname;
        String goodsprice;
        String picurl;
        String storename;
        String storepicurl;

        public String getGoodid() {
            return this.goodid;
        }

        public String getGoodsmarketprice() {
            return this.goodsmarketprice;
        }

        public String getGoodsname() {
            return this.goodsname;
        }

        public String getGoodsprice() {
            return this.goodsprice;
        }

        public String getPicurl() {
            return this.picurl;
        }

        public String getStorename() {
            return this.storename;
        }

        public String getStorepicurl() {
            return this.storepicurl;
        }
    }
}
