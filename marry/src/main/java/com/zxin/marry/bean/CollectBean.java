package com.zxin.marry.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/30.
 */

public class CollectBean {

    private List<CaseBean> caselist;
    private List<GoodsBean> goods;
    private String code;
    private String message;
    private List<ShopInformation.EcshopBean> caseRes;
    private List<ShopInformation.EcshopBean> ecshop;
    private List<ShopInformation.EcshopBean> goodsRes;
    private Page page;

    public List<CaseBean> getCaselist() {
        return caselist;
    }

    public void setCaselist(List<CaseBean> caselist) {
        this.caselist = caselist;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ShopInformation.EcshopBean> getCaseRes() {
        return caseRes;
    }

    public void setCaseRes(List<ShopInformation.EcshopBean> caseRes) {
        this.caseRes = caseRes;
    }

    public List<ShopInformation.EcshopBean> getEcshop() {
        return ecshop;
    }

    public void setEcshop(List<ShopInformation.EcshopBean> ecshop) {
        this.ecshop = ecshop;
    }

    public List<ShopInformation.EcshopBean> getGoodsRes() {
        return goodsRes;
    }

    public void setGoodsRes(List<ShopInformation.EcshopBean> goodsRes) {
        this.goodsRes = goodsRes;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}
