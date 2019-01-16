package com.zxin.marry.bean;

import com.zxin.marry.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */

public class BanquetHallBean {
    private BanquetBean banquet;
    private int code;
    private List<GiftBean> gift;
    private String message;
    private List<RecommendAdvBean> recommend_adv;

    public BanquetBean getBanquet() {
        return this.banquet;
    }

    public int getCode() {
        return this.code;
    }

    public List<GiftBean> getGift() {
        if (this.gift == null) {
            this.gift = new ArrayList();
        }
        return this.gift;
    }

    public String getMessage() {
        return this.message;
    }

    public List<RecommendAdvBean> getRecommend_adv() {
        return this.recommend_adv;
    }

    public void setBanquet(BanquetBean paramBanquetBean) {
        this.banquet = paramBanquetBean;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setGift(List<GiftBean> paramList) {
        this.gift = paramList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setRecommend_adv(List<RecommendAdvBean> paramList) {
        this.recommend_adv = paramList;
    }

    public static class BanquetBean {
        private String appintroduce;
        private String banquet_area;
        private String banquet_height;
        private List<BanquetImageBean> banquet_image;
        private String banquet_logo;
        private String banquet_shape;
        private String column_sum;
        private String createtime;
        private String feastid;
        private String hotel_desc;
        private String hotelid;
        private String id;
        private String isdelete;
        private String listorder;
        private String name;
        private String optionfeatureid;
        private String optiontableid;
        private String price;
        private String stage_long;
        private String stage_wide;

        public String getAppintroduce() {
            return this.appintroduce;
        }

        public String getBanquet_area() {
            return StringUtils.textIsEmpty(this.banquet_area)?"0":this.banquet_area;
        }

        public String getBanquet_height() {
            return StringUtils.textIsEmpty(this.banquet_height)?"0":this.banquet_height;
        }

        public List<BanquetImageBean> getBanquet_image() {
            return this.banquet_image;
        }

        public String getBanquet_logo() {
            return this.banquet_logo;
        }

        public String getBanquet_shape() {
            return this.banquet_shape;
        }

        public String getColumn_sum() {
            if (this.column_sum.equals("0")) {
                this.column_sum = "无";
            }
            return this.column_sum;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public String getFeastid() {
            return this.feastid;
        }

        public String getHotel_desc() {
            return this.hotel_desc;
        }

        public String getHotelid() {
            return this.hotelid;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getListorder() {
            return this.listorder;
        }

        public String getName() {
            return this.name;
        }

        public String getOptionfeatureid() {
            return this.optionfeatureid;
        }

        public String getOptiontableid() {
            return this.optiontableid;
        }

        public String getPrice() {
            return this.price;
        }

        public String getStage_long() {
            return this.stage_long;
        }

        public String getStage_wide() {
            return this.stage_wide;
        }

        public void setAppintroduce(String paramString) {
            this.appintroduce = paramString;
        }

        public void setBanquet_area(String paramString) {
            this.banquet_area = paramString;
        }

        public void setBanquet_height(String paramString) {
            this.banquet_height = paramString;
        }

        public void setBanquet_image(List<BanquetImageBean> paramList) {
            this.banquet_image = paramList;
        }

        public void setBanquet_logo(String paramString) {
            this.banquet_logo = paramString;
        }

        public void setBanquet_shape(String paramString) {
            this.banquet_shape = paramString;
        }

        public void setColumn_sum(String paramString) {
            this.column_sum = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setFeastid(String paramString) {
            this.feastid = paramString;
        }

        public void setHotel_desc(String paramString) {
            this.hotel_desc = paramString;
        }

        public void setHotelid(String paramString) {
            this.hotelid = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setListorder(String paramString) {
            this.listorder = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOptionfeatureid(String paramString) {
            this.optionfeatureid = paramString;
        }

        public void setOptiontableid(String paramString) {
            this.optiontableid = paramString;
        }

        public void setPrice(String paramString) {
            this.price = paramString;
        }

        public void setStage_long(String paramString) {
            this.stage_long = paramString;
        }

        public void setStage_wide(String paramString) {
            this.stage_wide = paramString;
        }

        public static class BanquetImageBean {
            private String addtime;
            private String alt;
            private String banquet_id;
            private String feastid;
            private int height;
            private String id;
            private String imgsrc;
            private int width;

            public String getAddtime() {
                return this.addtime;
            }

            public String getAlt() {
                return this.alt;
            }

            public String getBanquet_id() {
                return this.banquet_id;
            }

            public String getFeastid() {
                return this.feastid;
            }

            public int getHeight() {
                return this.height;
            }

            public String getId() {
                return this.id;
            }

            public String getImgsrc() {
                return this.imgsrc;
            }

            public int getWidth() {
                return this.width;
            }

            public void setAddtime(String paramString) {
                this.addtime = paramString;
            }

            public void setAlt(String paramString) {
                this.alt = paramString;
            }

            public void setBanquet_id(String paramString) {
                this.banquet_id = paramString;
            }

            public void setFeastid(String paramString) {
                this.feastid = paramString;
            }

            public void setId(String paramString) {
                this.id = paramString;
            }

            public void setImgsrc(String paramString) {
                this.imgsrc = paramString;
            }
        }
    }

    public static class RecommendAdvBean {
        private String title;
        private String type;
        private String value;

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public String getValue() {
            return this.value;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public void setType(String paramString) {
            this.type = paramString;
        }

        public void setValue(String paramString) {
            this.value = paramString;
        }
    }
}
