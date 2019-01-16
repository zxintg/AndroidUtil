package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class MyGoodsOrderBean {
    private String code;
    private String message;
    private List<MyorderBean> myorder;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public List<MyorderBean> getMyorder() {
        if (this.myorder == null) {
            this.myorder = new ArrayList();
        }
        return this.myorder;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setMyorder(List<MyorderBean> paramList) {
        this.myorder = paramList;
    }

    public static class MyorderBean implements Parcelable {
        private String api_pay_state;
        private String buyer_id;
        private List<OrderBean> order;
        private String pay_id;
        private String pay_sn;
        private String total_price;

        protected MyorderBean(Parcel in) {
            api_pay_state = in.readString();
            buyer_id = in.readString();
            order = in.createTypedArrayList(OrderBean.CREATOR);
            pay_id = in.readString();
            pay_sn = in.readString();
            total_price = in.readString();
        }

        public static final Creator<MyorderBean> CREATOR = new Creator<MyorderBean>() {
            @Override
            public MyorderBean createFromParcel(Parcel in) {
                return new MyorderBean(in);
            }

            @Override
            public MyorderBean[] newArray(int size) {
                return new MyorderBean[size];
            }
        };

        public String getApi_pay_state() {
            return this.api_pay_state;
        }

        public String getBuyer_id() {
            return this.buyer_id;
        }

        public List<OrderBean> getOrder() {
            return this.order;
        }

        public String getPay_id() {
            return this.pay_id;
        }

        public String getPay_sn() {
            return this.pay_sn;
        }

        public String getTotal_price() {
            return this.total_price;
        }

        public void setApi_pay_state(String paramString) {
            this.api_pay_state = paramString;
        }

        public void setBuyer_id(String paramString) {
            this.buyer_id = paramString;
        }

        public void setOrder(List<OrderBean> paramList) {
            this.order = paramList;
        }

        public void setPay_id(String paramString) {
            this.pay_id = paramString;
        }

        public void setPay_sn(String paramString) {
            this.pay_sn = paramString;
        }

        public void setTotal_price(String paramString) {
            this.total_price = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(api_pay_state);
            dest.writeString(buyer_id);
            dest.writeTypedList(order);
            dest.writeString(pay_id);
            dest.writeString(pay_sn);
            dest.writeString(total_price);
        }

        public static class OrderBean implements Parcelable {
            private String add_time;
            private String address_id;
            private String api_pay_state;
            private Object buyer_email;
            private String buyer_id;
            private String buyer_name;
            private List<CartlistBean> cartlist;
            private String delay_time;
            private String delete_state;
            private Object deliver_explain;
            private String evaluation_state;
            private String evaluation_state1;
            private String finnshed_time;
            private String goods_amount;
            private String lock_state;
            private String order_amount;
            private String order_from;
            private String order_id;
            private String order_message;
            private String order_sn;
            private String order_state;
            private String order_state1;
            private Object out_payment_code;
            private String pay_id;
            private String pay_sn;
            private String payment_code;
            private String payment_time;
            private String pd_amount;
            private String rcb_amount;
            private ReciverInfoBean reciver_info;
            private String reciver_name;
            private String refund_amount;
            private String refund_state;
            private String refund_state1;
            private String shipping_code;
            private String shipping_fee;
            private String store_avatar;
            private String store_id;
            private String store_name;

            protected OrderBean(Parcel in) {
                add_time = in.readString();
                address_id = in.readString();
                api_pay_state = in.readString();
                buyer_id = in.readString();
                buyer_name = in.readString();
                delay_time = in.readString();
                delete_state = in.readString();
                evaluation_state = in.readString();
                evaluation_state1 = in.readString();
                finnshed_time = in.readString();
                goods_amount = in.readString();
                lock_state = in.readString();
                order_amount = in.readString();
                order_from = in.readString();
                order_id = in.readString();
                order_message = in.readString();
                order_sn = in.readString();
                order_state = in.readString();
                order_state1 = in.readString();
                pay_id = in.readString();
                pay_sn = in.readString();
                payment_code = in.readString();
                payment_time = in.readString();
                pd_amount = in.readString();
                rcb_amount = in.readString();
                reciver_name = in.readString();
                refund_amount = in.readString();
                refund_state = in.readString();
                refund_state1 = in.readString();
                shipping_code = in.readString();
                shipping_fee = in.readString();
                store_avatar = in.readString();
                store_id = in.readString();
                store_name = in.readString();
            }

            public static final Creator<OrderBean> CREATOR = new Creator<OrderBean>() {
                @Override
                public OrderBean createFromParcel(Parcel in) {
                    return new OrderBean(in);
                }

                @Override
                public OrderBean[] newArray(int size) {
                    return new OrderBean[size];
                }
            };

            public String getAdd_time() {
                return this.add_time;
            }

            public String getAddress_id() {
                return this.address_id;
            }

            public String getApi_pay_state() {
                return this.api_pay_state;
            }

            public Object getBuyer_email() {
                return this.buyer_email;
            }

            public String getBuyer_id() {
                return this.buyer_id;
            }

            public String getBuyer_name() {
                return this.buyer_name;
            }

            public List<CartlistBean> getCartlist() {
                if (this.cartlist == null) {
                    this.cartlist = new ArrayList();
                }
                return this.cartlist;
            }

            public String getDelay_time() {
                return this.delay_time;
            }

            public String getDelete_state() {
                return this.delete_state;
            }

            public Object getDeliver_explain() {
                return this.deliver_explain;
            }

            public String getEvaluation_state() {
                return this.evaluation_state;
            }

            public String getEvaluation_state1() {
                return this.evaluation_state1;
            }

            public String getFinnshed_time() {
                return this.finnshed_time;
            }

            public String getGoods_amount() {
                return this.goods_amount;
            }

            public String getLock_state() {
                return this.lock_state;
            }

            public String getOrder_amount() {
                return this.order_amount;
            }

            public String getOrder_from() {
                return this.order_from;
            }

            public String getOrder_id() {
                return this.order_id;
            }

            public String getOrder_message() {
                return this.order_message;
            }

            public String getOrder_sn() {
                return this.order_sn;
            }

            public String getOrder_state() {
                return this.order_state;
            }

            public String getOrder_state1() {
                return this.order_state1;
            }

            public Object getOut_payment_code() {
                return this.out_payment_code;
            }

            public String getPay_id() {
                return this.pay_id;
            }

            public String getPay_sn() {
                return this.pay_sn;
            }

            public String getPayment_code() {
                return this.payment_code;
            }

            public String getPayment_time() {
                return this.payment_time;
            }

            public String getPd_amount() {
                return this.pd_amount;
            }

            public String getRcb_amount() {
                return this.rcb_amount;
            }

            public ReciverInfoBean getReciver_info() {
                return this.reciver_info;
            }

            public String getReciver_name() {
                return this.reciver_name;
            }

            public String getRefund_amount() {
                return this.refund_amount;
            }

            public String getRefund_state() {
                return this.refund_state;
            }

            public String getRefund_state1() {
                return this.refund_state1;
            }

            public String getShipping_code() {
                return this.shipping_code;
            }

            public String getShipping_fee() {
                return this.shipping_fee;
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

            public void setAdd_time(String paramString) {
                this.add_time = paramString;
            }

            public void setAddress_id(String paramString) {
                this.address_id = paramString;
            }

            public void setApi_pay_state(String paramString) {
                this.api_pay_state = paramString;
            }

            public void setBuyer_email(Object paramObject) {
                this.buyer_email = paramObject;
            }

            public void setBuyer_id(String paramString) {
                this.buyer_id = paramString;
            }

            public void setBuyer_name(String paramString) {
                this.buyer_name = paramString;
            }

            public void setCartlist(List<CartlistBean> paramList) {
                this.cartlist = paramList;
            }

            public void setDelay_time(String paramString) {
                this.delay_time = paramString;
            }

            public void setDelete_state(String paramString) {
                this.delete_state = paramString;
            }

            public void setDeliver_explain(Object paramObject) {
                this.deliver_explain = paramObject;
            }

            public void setEvaluation_state(String paramString) {
                this.evaluation_state = paramString;
            }

            public void setEvaluation_state1(String paramString) {
                this.evaluation_state1 = paramString;
            }

            public void setFinnshed_time(String paramString) {
                this.finnshed_time = paramString;
            }

            public void setGoods_amount(String paramString) {
                this.goods_amount = paramString;
            }

            public void setLock_state(String paramString) {
                this.lock_state = paramString;
            }

            public void setOrder_amount(String paramString) {
                this.order_amount = paramString;
            }

            public void setOrder_from(String paramString) {
                this.order_from = paramString;
            }

            public void setOrder_id(String paramString) {
                this.order_id = paramString;
            }

            public void setOrder_message(String paramString) {
                this.order_message = paramString;
            }

            public void setOrder_sn(String paramString) {
                this.order_sn = paramString;
            }

            public void setOrder_state(String paramString) {
                this.order_state = paramString;
            }

            public void setOrder_state1(String paramString) {
                this.order_state1 = paramString;
            }

            public void setOut_payment_code(Object paramObject) {
                this.out_payment_code = paramObject;
            }

            public void setPay_id(String paramString) {
                this.pay_id = paramString;
            }

            public void setPay_sn(String paramString) {
                this.pay_sn = paramString;
            }

            public void setPayment_code(String paramString) {
                this.payment_code = paramString;
            }

            public void setPayment_time(String paramString) {
                this.payment_time = paramString;
            }

            public void setPd_amount(String paramString) {
                this.pd_amount = paramString;
            }

            public void setRcb_amount(String paramString) {
                this.rcb_amount = paramString;
            }

            public void setReciver_info(ReciverInfoBean paramReciverInfoBean) {
                this.reciver_info = paramReciverInfoBean;
            }

            public void setReciver_name(String paramString) {
                this.reciver_name = paramString;
            }

            public void setRefund_amount(String paramString) {
                this.refund_amount = paramString;
            }

            public void setRefund_state(String paramString) {
                this.refund_state = paramString;
            }

            public void setRefund_state1(String paramString) {
                this.refund_state1 = paramString;
            }

            public void setShipping_code(String paramString) {
                this.shipping_code = paramString;
            }

            public void setShipping_fee(String paramString) {
                this.shipping_fee = paramString;
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(add_time);
                dest.writeString(address_id);
                dest.writeString(api_pay_state);
                dest.writeString(buyer_id);
                dest.writeString(buyer_name);
                dest.writeString(delay_time);
                dest.writeString(delete_state);
                dest.writeString(evaluation_state);
                dest.writeString(evaluation_state1);
                dest.writeString(finnshed_time);
                dest.writeString(goods_amount);
                dest.writeString(lock_state);
                dest.writeString(order_amount);
                dest.writeString(order_from);
                dest.writeString(order_id);
                dest.writeString(order_message);
                dest.writeString(order_sn);
                dest.writeString(order_state);
                dest.writeString(order_state1);
                dest.writeString(pay_id);
                dest.writeString(pay_sn);
                dest.writeString(payment_code);
                dest.writeString(payment_time);
                dest.writeString(pd_amount);
                dest.writeString(rcb_amount);
                dest.writeString(reciver_name);
                dest.writeString(refund_amount);
                dest.writeString(refund_state);
                dest.writeString(refund_state1);
                dest.writeString(shipping_code);
                dest.writeString(shipping_fee);
                dest.writeString(store_avatar);
                dest.writeString(store_id);
                dest.writeString(store_name);
            }

            public static class CartlistBean {
                private String buyer_id;
                private String commis_rate;
                private String gc_id;
                private String goods_id;
                private String goods_image;
                private String goods_name;
                private String goods_num;
                private String goods_pay_price;
                private String goods_price;
                private String goods_type;
                private String order_id;
                private String promotions_id;
                private String rec_id;
                private String store_id;

                public String getBuyer_id() {
                    return this.buyer_id;
                }

                public String getCommis_rate() {
                    return this.commis_rate;
                }

                public String getGc_id() {
                    return this.gc_id;
                }

                public String getGoods_id() {
                    return this.goods_id;
                }

                public String getGoods_image() {
                    return this.goods_image;
                }

                public String getGoods_name() {
                    return this.goods_name;
                }

                public String getGoods_num() {
                    return this.goods_num;
                }

                public String getGoods_pay_price() {
                    return this.goods_pay_price;
                }

                public String getGoods_price() {
                    return this.goods_price;
                }

                public String getGoods_type() {
                    return this.goods_type;
                }

                public String getOrder_id() {
                    return this.order_id;
                }

                public String getPromotions_id() {
                    return this.promotions_id;
                }

                public String getRec_id() {
                    return this.rec_id;
                }

                public String getStore_id() {
                    return this.store_id;
                }

                public void setBuyer_id(String paramString) {
                    this.buyer_id = paramString;
                }

                public void setCommis_rate(String paramString) {
                    this.commis_rate = paramString;
                }

                public void setGc_id(String paramString) {
                    this.gc_id = paramString;
                }

                public void setGoods_id(String paramString) {
                    this.goods_id = paramString;
                }

                public void setGoods_image(String paramString) {
                    this.goods_image = paramString;
                }

                public void setGoods_name(String paramString) {
                    this.goods_name = paramString;
                }

                public void setGoods_num(String paramString) {
                    this.goods_num = paramString;
                }

                public void setGoods_pay_price(String paramString) {
                    this.goods_pay_price = paramString;
                }

                public void setGoods_price(String paramString) {
                    this.goods_price = paramString;
                }

                public void setGoods_type(String paramString) {
                    this.goods_type = paramString;
                }

                public void setOrder_id(String paramString) {
                    this.order_id = paramString;
                }

                public void setPromotions_id(String paramString) {
                    this.promotions_id = paramString;
                }

                public void setRec_id(String paramString) {
                    this.rec_id = paramString;
                }

                public void setStore_id(String paramString) {
                    this.store_id = paramString;
                }
            }

            public static class ReciverInfoBean {
                private String address;
                private String area;
                private String dlyp;
                private String mob_phone;
                private String phone;
                private String street;
                private Object tel_phone;

                public String getAddress() {
                    return this.address;
                }

                public String getArea() {
                    return this.area;
                }

                public String getDlyp() {
                    return this.dlyp;
                }

                public String getMob_phone() {
                    return this.mob_phone;
                }

                public String getPhone() {
                    return this.phone;
                }

                public String getStreet() {
                    return this.street;
                }

                public Object getTel_phone() {
                    return this.tel_phone;
                }

                public void setAddress(String paramString) {
                    this.address = paramString;
                }

                public void setArea(String paramString) {
                    this.area = paramString;
                }

                public void setDlyp(String paramString) {
                    this.dlyp = paramString;
                }

                public void setMob_phone(String paramString) {
                    this.mob_phone = paramString;
                }

                public void setPhone(String paramString) {
                    this.phone = paramString;
                }

                public void setStreet(String paramString) {
                    this.street = paramString;
                }

                public void setTel_phone(Object paramObject) {
                    this.tel_phone = paramObject;
                }
            }
        }
    }
}
