package com.zxin.marry.mvp.model;

import android.text.TextUtils;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.AppointmentBean;
import com.zxin.marry.bean.BookdressdateBean;
import com.zxin.marry.bean.CDkeyBean1;
import com.zxin.marry.bean.CircuitViewPagerBean;
import com.zxin.marry.bean.CurrentProcedureBean;
import com.zxin.marry.bean.Entity;
import com.zxin.marry.bean.FInishingBean;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.bean.GetphotodateBean;
import com.zxin.marry.bean.GifListBean;
import com.zxin.marry.bean.MyGoodsOrderBean;
import com.zxin.marry.bean.MyOrderBean;
import com.zxin.marry.bean.OrderListBean;
import com.zxin.marry.bean.PhotoDataBean;
import com.zxin.marry.bean.PickUpBean;
import com.zxin.marry.bean.RemarkListBean;
import com.zxin.marry.bean.RemarkStatusBean;
import com.zxin.marry.bean.SelectPhotoDateBean;
import com.zxin.marry.bean.ShootStategyBean;
import com.zxin.marry.bean.TEmplateBean;
import com.zxin.marry.bean.VoucherBaseBean;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class OrderModel extends BaseModel {

    /******
     * 订单列表
     */
    public void getOrderList(String uid, String type) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getOrderList(uid, type)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<OrderListBean>(getContext(), true) {
                    @Override
                    protected void onDone(OrderListBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getCurrentProcedure(String uid, String orderid, String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getCurrentProcedure(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CurrentProcedureBean>(getContext(), true) {
                    @Override
                    protected void onDone(CurrentProcedureBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getOrderProgress(String uid, String orderid, String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getOrderProgress(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<FirstOrderBean>(getContext(), true) {
                    @Override
                    protected void onDone(FirstOrderBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    /*****
     * 订单详情
     * @param uid
     * @param orderid
     * @param shopid
     */
    public void getOrderInfoDetail(String uid, String orderid, String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getOrderInfoDetail(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MyOrderBean>(getContext(), true) {
                    @Override
                    protected void onDone(MyOrderBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getReservePhotoGraphDetail(String uid, String orderid, String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getReservePhotoGraphDetail(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<PhotoDataBean>(getContext(), true) {
                    @Override
                    protected void onDone(PhotoDataBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }


    public void getReserveChoiceClothes(String uid, String orderid,String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getReserveChoiceClothes(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<BookdressdateBean>(getContext(), true) {
                    @Override
                    protected void onDone(BookdressdateBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getReserveChoicePhoto(String uid, String orderid,String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getReserveChoicePhoto(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<SelectPhotoDateBean>(getContext(), true) {
                    @Override
                    protected void onDone(SelectPhotoDateBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getFinishingDate(String uid, String orderid,String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getFinishingDate(uid, orderid, shopid,"7")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<FInishingBean>(getContext(), true) {
                    @Override
                    protected void onDone(FInishingBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getTemplateDate(String uid, String orderid,String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getTemplateDate(uid, orderid, shopid,"8")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<TEmplateBean>(getContext(), true) {
                    @Override
                    protected void onDone(TEmplateBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getReserveExpressDate(String uid, String orderid,String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getReserveExpressDate(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<GetphotodateBean>(getContext(), true) {
                    @Override
                    protected void onDone(GetphotodateBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getReserveComentDatas(String uid, String orderid,String shopid,String typeid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getReserveComentDatas(uid, orderid, shopid,typeid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RemarkStatusBean>(getContext(), true) {
                    @Override
                    protected void onDone(RemarkStatusBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getReserveRemarkList(String uid, String orderid,String shopid,String typeid,int status) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getReserveRemarkList(uid, orderid, shopid,typeid,status)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RemarkListBean>(getContext(), true) {
                    @Override
                    protected void onDone(RemarkListBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getPickUpDetails(String uid, String orderid,String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getPickUpDetails(uid, orderid, shopid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<PickUpBean>(getContext(), true) {
                    @Override
                    protected void onDone(PickUpBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    /****
     * 获取外景攻略
     * @param uid
     * @param orderid
     * @param shopid
     */
    public void getCameraStrategyDetail(String uid, String orderid, String shopid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getCameraStrategyDetail(uid, shopid, orderid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShootStategyBean>(getContext(), true) {
                    @Override
                    protected void onDone(ShootStategyBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getNewCircuitView(String uid, String orderid, String shopid, String lineId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getNewCircuitView(uid, orderid, shopid, lineId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CircuitViewPagerBean>(getContext(), true) {
                    @Override
                    protected void onDone(CircuitViewPagerBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getNewAllStrategyViewList(String uid, String orderid, String shopid, String lineId) {
        if (StringUtils.textIsEmpty(lineId))
            getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                    .getNewAllStrategyNoLineList(uid, orderid, shopid, "", "2", "0")
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new AbsAPICallback<ShootStategyBean>(getContext(), true) {
                        @Override
                        protected void onDone(ShootStategyBean strData) {
                            getListener().onSuccess(getTag(), strData);
                        }

                        @Override
                        public void onResultError(ResultException ex) {
                            getListener().onFailure(getTag(), "异常");
                        }
                    });
        else
            getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                    .getNewAllStrategyList(uid, orderid, shopid, "", "2", lineId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new AbsAPICallback<ShootStategyBean>(getContext(), true) {
                        @Override
                        protected void onDone(ShootStategyBean strData) {
                            getListener().onSuccess(getTag(), strData);
                        }

                        @Override
                        public void onResultError(ResultException ex) {
                            getListener().onFailure(getTag(), "异常");
                        }
                    });
    }

    public void getVoucherOrderList(String uid, String voucher_state) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getVoucherOrderList(voucher_state,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<VoucherBaseBean>(getContext(), true) {
                    @Override
                    protected void onDone(VoucherBaseBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getCDKeyVoucherOrderList(String uid, String vr_state) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getCDKeyVoucherOrderList(vr_state,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<CDkeyBean1>(getContext(), true) {
                    @Override
                    protected void onDone(CDkeyBean1 strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getSpreeBounsList(String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getSpreeBounsList(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<GifListBean>(getContext(), true) {
                    @Override
                    protected void onDone(GifListBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getAppointmentList(String appointment_isfeed,String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getAppointmentList(appointment_isfeed,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<AppointmentBean>(getContext(), true) {
                    @Override
                    protected void onDone(AppointmentBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getPayOrderList(String order_state,String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getPayOrderList(order_state,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MyGoodsOrderBean>(getContext(), true) {
                    @Override
                    protected void onDone(MyGoodsOrderBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void cancelOrder(String pay_sn,String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .cancelOrder(pay_sn,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<Entity>(getContext(), true) {
                    @Override
                    protected void onDone(Entity strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void confirmOrder(String orderId,String uid) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .confirmOrder(orderId,uid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<MyGoodsOrderBean>(getContext(), true) {
                    @Override
                    protected void onDone(MyGoodsOrderBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getOutdoorSceneList(String uid,String orderId,String shopId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getOutdoorSceneList(uid,orderId,shopId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShootStategyBean>(getContext(), true) {
                    @Override
                    protected void onDone(ShootStategyBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getIndoorSceneList(String uid,String orderId,String shopId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getIndoorSceneList(uid,orderId,shopId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ShootStategyBean>(getContext(), true) {
                    @Override
                    protected void onDone(ShootStategyBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

}
