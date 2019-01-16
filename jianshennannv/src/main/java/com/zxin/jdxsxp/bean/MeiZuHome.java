package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */

public class MeiZuHome {
    private int code;
    private String message;
    private String redirect;
    private ValueBean value;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public ValueBean getValue() {
        return this.value;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setRedirect(String paramString) {
        this.redirect = paramString;
    }

    public void setValue(ValueBean paramValueBean) {
        this.value = paramValueBean;
    }

    public static class ValueBean {
        private List<BlocksBean> blocks;
        private boolean more;
        private List<NavBean> nav;

        public List<BlocksBean> getBlocks() {
            return this.blocks;
        }

        public List<NavBean> getNav() {
            return this.nav;
        }

        public boolean isMore() {
            return this.more;
        }

        public void setBlocks(List<BlocksBean> paramList) {
            this.blocks = paramList;
        }

        public void setMore(boolean paramBoolean) {
            this.more = paramBoolean;
        }

        public void setNav(List<NavBean> paramList) {
            this.nav = paramList;
        }

        public static class BlocksBean {
            private String bg_img;
            private ContentConfigBean content_config;
            private List<DataBean> data;
            private int id;
            private boolean more;
            private String name;
            private int recomType;
            private String recomVer;
            private boolean show_name;
            private int support_max_vc;
            private int support_min_vc;
            private boolean support_recommend;
            private String type;
            private String url;

            public String getBg_img() {
                return this.bg_img;
            }

            public ContentConfigBean getContent_config() {
                return this.content_config;
            }

            public List<DataBean> getData() {
                return this.data;
            }

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public int getRecomType() {
                return this.recomType;
            }

            public String getRecomVer() {
                return this.recomVer;
            }

            public int getSupport_max_vc() {
                return this.support_max_vc;
            }

            public int getSupport_min_vc() {
                return this.support_min_vc;
            }

            public String getType() {
                return this.type;
            }

            public String getUrl() {
                return this.url;
            }

            public boolean isMore() {
                return this.more;
            }

            public boolean isShow_name() {
                return this.show_name;
            }

            public boolean isSupport_recommend() {
                return this.support_recommend;
            }

            public void setBg_img(String paramString) {
                this.bg_img = paramString;
            }

            public void setContent_config(ContentConfigBean paramContentConfigBean) {
                this.content_config = paramContentConfigBean;
            }

            public void setData(List<DataBean> paramList) {
                this.data = paramList;
            }

            public void setId(int paramInt) {
                this.id = paramInt;
            }

            public void setMore(boolean paramBoolean) {
                this.more = paramBoolean;
            }

            public void setName(String paramString) {
                this.name = paramString;
            }

            public void setRecomType(int paramInt) {
                this.recomType = paramInt;
            }

            public void setRecomVer(String paramString) {
                this.recomVer = paramString;
            }

            public void setShow_name(boolean paramBoolean) {
                this.show_name = paramBoolean;
            }

            public void setSupport_max_vc(int paramInt) {
                this.support_max_vc = paramInt;
            }

            public void setSupport_min_vc(int paramInt) {
                this.support_min_vc = paramInt;
            }

            public void setSupport_recommend(boolean paramBoolean) {
                this.support_recommend = paramBoolean;
            }

            public void setType(String paramString) {
                this.type = paramString;
            }

            public void setUrl(String paramString) {
                this.url = paramString;
            }

            public static class ContentConfigBean {
                private String bg_color;
                private String btn_end_color;
                private String btn_front_color;
                private String promotion_price_color;
                private String text_color;
                private String timing;
                private String title_bg_color;
                private String top_icon;

                public String getBg_color() {
                    return this.bg_color;
                }

                public String getBtn_end_color() {
                    return this.btn_end_color;
                }

                public String getBtn_front_color() {
                    return this.btn_front_color;
                }

                public String getPromotion_price_color() {
                    return this.promotion_price_color;
                }

                public String getText_color() {
                    return this.text_color;
                }

                public String getTiming() {
                    return this.timing;
                }

                public String getTitle_bg_color() {
                    return this.title_bg_color;
                }

                public String getTop_icon() {
                    return this.top_icon;
                }

                public void setBg_color(String paramString) {
                    this.bg_color = paramString;
                }

                public void setBtn_end_color(String paramString) {
                    this.btn_end_color = paramString;
                }

                public void setBtn_front_color(String paramString) {
                    this.btn_front_color = paramString;
                }

                public void setPromotion_price_color(String paramString) {
                    this.promotion_price_color = paramString;
                }

                public void setText_color(String paramString) {
                    this.text_color = paramString;
                }

                public void setTiming(String paramString) {
                    this.timing = paramString;
                }

                public void setTitle_bg_color(String paramString) {
                    this.title_bg_color = paramString;
                }

                public void setTop_icon(String paramString) {
                    this.top_icon = paramString;
                }
            }

            public static class DataBean {
                private String img_url;
                private int img_size;
                private String activeview_url;
                private int content_id;
                private String dynamicImg_url;
                private String name;
                private int page_id;
                private int img_height;
                private int aid;
                private String type;
                private int id;
                private int cp_id;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getCp_id() {
                    return cp_id;
                }

                public void setCp_id(int cp_id) {
                    this.cp_id = cp_id;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getCp_name() {
                    return cp_name;
                }

                public void setCp_name(String cp_name) {
                    this.cp_name = cp_name;
                }

                public String getSmall_pap_address() {
                    return small_pap_address;
                }

                public void setSmall_pap_address(String small_pap_address) {
                    this.small_pap_address = small_pap_address;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getBig_pap_address() {
                    return big_pap_address;
                }

                public void setBig_pap_address(String big_pap_address) {
                    this.big_pap_address = big_pap_address;
                }

                public boolean isParticle_effect() {
                    return particle_effect;
                }

                public void setParticle_effect(boolean particle_effect) {
                    this.particle_effect = particle_effect;
                }

                private int height;
                private String cp_name;
                private String small_pap_address;
                private int width;
                private String big_pap_address;
                private boolean particle_effect;

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public int getImg_size() {
                    return img_size;
                }

                public void setImg_size(int img_size) {
                    this.img_size = img_size;
                }

                public String getActiveview_url() {
                    return activeview_url;
                }

                public void setActiveview_url(String activeview_url) {
                    this.activeview_url = activeview_url;
                }

                public int getContent_id() {
                    return content_id;
                }

                public void setContent_id(int content_id) {
                    this.content_id = content_id;
                }

                public String getDynamicImg_url() {
                    return dynamicImg_url;
                }

                public void setDynamicImg_url(String dynamicImg_url) {
                    this.dynamicImg_url = dynamicImg_url;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPage_id() {
                    return page_id;
                }

                public void setPage_id(int page_id) {
                    this.page_id = page_id;
                }

                public int getImg_height() {
                    return img_height;
                }

                public void setImg_height(int img_height) {
                    this.img_height = img_height;
                }

                public int getAid() {
                    return aid;
                }

                public void setAid(int aid) {
                    this.aid = aid;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getImg_width() {
                    return img_width;
                }

                public void setImg_width(int img_width) {
                    this.img_width = img_width;
                }

                public int getSupport_min_vc() {
                    return support_min_vc;
                }

                public void setSupport_min_vc(int support_min_vc) {
                    this.support_min_vc = support_min_vc;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public long getSupport_max_vc() {
                    return support_max_vc;
                }

                public void setSupport_max_vc(long support_max_vc) {
                    this.support_max_vc = support_max_vc;
                }

                private int img_width;
                private int support_min_vc;
                private String url;
                private long support_max_vc;

            }
        }

        public static class NavBean {
            private String name;
            private String product;
            private String type;
            private String url;

            public String getName() {
                return this.name;
            }

            public String getProduct() {
                return this.product;
            }

            public String getType() {
                return this.type;
            }

            public String getUrl() {
                return this.url;
            }

            public void setName(String paramString) {
                this.name = paramString;
            }

            public void setProduct(String paramString) {
                this.product = paramString;
            }

            public void setType(String paramString) {
                this.type = paramString;
            }

            public void setUrl(String paramString) {
                this.url = paramString;
            }
        }
    }
}
