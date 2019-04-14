package com.zxin.marry.mvp.presenter;

import android.view.View;

import com.zxin.marry.bean.CurrentProcedureBean;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.bean.MyOrderBean;
import com.zxin.marry.bean.OrderBean;
import com.zxin.marry.bean.OrderListBean;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.fragment.order.OrderInformationFragment;
import com.zxin.marry.mvp.model.OrderModel;
import com.zxin.marry.mvp.model.TopicModel;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.MarryIntegerUtil;
import com.zxin.network.MvpCallback;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/21.
 */

public class OrderPresenter extends BasePresenter<OrderContract, OrderModel> implements MvpCallback{

    public void initDatas(OrderContract.MyMarryOrderView listener,Object... parameter) {
        getView().setP(this);
        getView().setMyMarryOrderViewListener(listener);
        getView().setParameter(parameter);
        getView().initDatas();
        getModel().setListener(this);
    }

    public void initMainDatas(OrderContract.MarryOrderView listener,Object... parameter) {
        getView().setP(this);
        getView().setMarryOrderViewListener(listener);
        getView().setMainParameter(parameter);
        getModel().setListener(this);
    }

    public void initOrderInfoDatas(OrderContract.OrderInformationView listener, Object... parameter){
        getView().setP(this);
        getView().setOrderInformationViewListener(listener);
        getView().setOrderInfoParameter(parameter);
        getView().initOrderInfoDatas();
        getModel().setListener(this);
    }

    public void initReservePhotoGraphDatas(OrderContract.ReservePhotographView listener, Object... parameter){
        getView().setP(this);
        getView().setReservePhotographListener(listener);
        getView().setReservePhotographParameter(parameter);
        getView().initReservePhotographDatas();
        getModel().setListener(this);
    }

    public void initShootStrategyDatas(OrderContract.CameraStrategyView listener,Object... parameter){
        getView().setP(this);
        getView().setCameraStrategyViewListener(listener);
        getView().setShootStrategyParameter(parameter);
        getModel().setListener(this);
    }

    public void initReserveChoiceClothesDate(OrderContract.ReserveChoiceClothesView listener,Object... parameter){
        getView().setP(this);
        getView().setReserveChoiceClothesViewListener(listener);
        getView().setReserveChoiceClothesViewParameter(parameter);
        getModel().setListener(this);
    }

    public void initReserveChoicePhotoDate(OrderContract.ReserveChoicePhotoView listener,Object... parameter){
        getView().setP(this);
        getView().setReserveChoicePhotoViewListener(listener);
        getView().setReserveChoicePhotoViewParameter(parameter);
        getModel().setListener(this);
    }

    public void initReserveComentsDatas(OrderContract.ReserveRemarkView listener,Object... parameter){
        getView().setP(this);
        getView().setReserveRemarkViewListener(listener);
        getView().setReserveRemarkViewParameter(parameter);
        getView().initReserveRemarkViewDatas();
        getModel().setListener(this);
    }

    public void initFinishingDate(OrderContract.FinishingDateView listener,Object... parameter){
        getView().setP(this);
        getView().setFinishingDateViewListener(listener);
        getView().setFinishingDateViewParameter(parameter);
        getModel().setListener(this);
    }

    public void initTemplateDate(OrderContract.TemplateDateView listener,Object... parameter){
        getView().setP(this);
        getView().setTemplateDateViewListener(listener);
        getView().setTemplateDateViewParameter(parameter);
        getModel().setListener(this);
    }

    public void initReserveExpressDate(OrderContract.ReserveExpressView listener,Object... parameter){
        getView().setP(this);
        getView().setReserveExpressViewListener(listener);
        getView().setReserveExpressViewParameter(parameter);
        getModel().setListener(this);
    }

    public void initReserveComentDatas(OrderContract.ReserveComentView listener,Object... parameter){
        getView().setP(this);
        getView().setReserveComentViewListener(listener);
        getView().setReserveComentViewParameter(parameter);
        getView().initReserveComentViewDatas();
        getModel().setListener(this);
    }

    public void initPickUpDetailsDatas(OrderContract.PickUpDetailsView listener,Object... parameter){
        getView().setP(this);
        getView().setPickUpDetailsViewListener(listener);
        getView().setPickUpDetailsViewParameter(parameter);
        getView().initPickUpDetailsViewDatas();
        getModel().setListener(this);
    }

    public void initNewCircuitDatas(OrderContract.NewCircuitView listener,Object... parameter){
        getView().setP(this);
        getView().setNewCircuitViewListener(listener);
        getView().setNewCircuitViewParameter(parameter);
        getView().initNewCircuitViewDatas();
        getModel().setListener(this);
    }

    public void initNewAllStrategyDatas(OrderContract.NewAllStrategyView listener,Object... parameter){
        getView().setP(this);
        getView().setNewAllStrategyViewListener(listener);
        getView().setNewAllStrategyViewParameter(parameter);
        getView().initNewAllStrategyViewDatas();
        getModel().setListener(this);
    }

    public void initVoucherOrderDatas(OrderContract.VoucherItemView listener,Object... parameter){
        getView().setP(this);
        getView().setVoucherItemViewListener(listener);
        getView().setVoucherItemViewParameter(parameter);
        getView().initVoucherItemViewDatas();
        getModel().setListener(this);
    }

    public void initCDKeyVoucherOrderDatas(OrderContract.CDKeyVoucherItemView listener,Object... parameter){
        getView().setP(this);
        getView().setCDKeyVoucherItemViewListener(listener);
        getView().setCDKeyVoucherItemViewParameter(parameter);
        getView().initCDKeyVoucherItemViewDatas();
        getModel().setListener(this);
    }

    public void initSpreeBounsDatas(OrderContract.SpreeBounsView listener,Object... parameter){
        getView().setP(this);
        getView().setSpreeBounsViewListener(listener);
        getView().initSpreeBounsViewDatas();
        getModel().setListener(this);
    }

    public void initAppointmentItemDatas(OrderContract.AppointmentListView listener,Object... parameter){
        getView().setP(this);
        getView().setAppointmentListViewListener(listener);
        getView().setAppointmentViewParameter(parameter);
        getView().initAppointmentListDatas();
        getModel().setListener(this);
    }

    public void initPayOrderItemDatas(OrderContract.PayOrderItemView listener,Object... parameter){
        getView().setP(this);
        getView().setPayOrderItemViewListener(listener);
        getView().setPayOrderItemViewParameter(parameter);
        getView().initPayOrderItemViewDatas();
        getModel().setListener(this);
    }

    public void initOutdoorSceneDatas(OrderContract.OutdoorSceneView listener,Object... parameter){
        getView().setP(this);
        getView().setOutdoorSceneViewListener(listener);
        getView().setOutdoorSceneViewParameter(parameter);
        getView().initOutdoorSceneViewDatas();
        getModel().setListener(this);
    }

    public void initIndoorSceneDatas(OrderContract.IndoorSceneView listener,Object... parameter){
        getView().setP(this);
        getView().setIndoorSceneViewListener(listener);
        getView().setIndoorSceneViewParameter(parameter);
        getView().initIndoorSceneViewDatas();
        getModel().setListener(this);
    }

    public void getOrderList(String type) {
        getModel().setTag(MarryIntegerUtil.WEB_API_OrderList);
        getModel().getOrderList(SharedPreferencesManager.getMarryUid(),type);
    }

    public void getOrderByType(String type) {
        getModel().setTag(MarryIntegerUtil.WEB_API_OrderByType);
        getModel().getOrderList(SharedPreferencesManager.getMarryUid(),type);
    }

    public void getCurrentProcedure(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_CurrentProcedure);
        getModel().getCurrentProcedure(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getOrderProgress(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_OrderProgress);
        getModel().getOrderProgress(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getOrderInfoDetail(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_OrderInfo);
        getModel().getOrderInfoDetail(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getReservePhotoGraphDetail(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReservePhotoGraphDetail);
        getModel().getReservePhotoGraphDetail(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getReserveChoiceClothes(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveChoiceClothes);
        getModel().getReserveChoiceClothes(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getReserveChoicePhoto(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveChoicePhoto);
        getModel().getReserveChoicePhoto(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getFinishingDate(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveFinishingDate);
        getModel().getFinishingDate(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getTemplateDate(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveTemplateDate);
        getModel().getTemplateDate(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getReserveExpressDate(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveExpressDate);
        getModel().getReserveExpressDate(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getReserveComentDatas(String orderid, String shopid,String typeid){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveComentDatas);
        getModel().getReserveComentDatas(SharedPreferencesManager.getMarryUid(),orderid,shopid,typeid);
    }

    public void getReserveRemarkList(String orderid, String shopid,String typeid,int status){
        getModel().setTag(MarryIntegerUtil.WEB_API_ReserveRemarkList);
        getModel().getReserveRemarkList(SharedPreferencesManager.getMarryUid(),orderid,shopid,typeid,status);
    }

    public void getPickUpDetails(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_PickUpDetails);
        getModel().getPickUpDetails(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void getCameraStrategyDetail(String orderid, String shopid){
        getModel().setTag(MarryIntegerUtil.WEB_API_CameraStrategy);
        getModel().getCameraStrategyDetail(SharedPreferencesManager.getMarryUid(),orderid,shopid);
    }

    public void NewCircuitViewList(String orderid, String shopid,String lineId){
        getModel().setTag(MarryIntegerUtil.WEB_API_NewCircuitView);
        getModel().getNewCircuitView(SharedPreferencesManager.getMarryUid(),orderid,shopid,lineId);
    }

    public void getNewAllStrategyViewList(String orderid, String shopid,String lineId){
        getModel().setTag(MarryIntegerUtil.WEB_API_NewAllStrategyView);
        getModel().getNewAllStrategyViewList(SharedPreferencesManager.getMarryUid(),orderid,shopid,lineId);
    }

    public void getVoucherOrderList(String voucher_state){
        getModel().setTag(MarryIntegerUtil.WEB_API_VoucherOrder);
        getModel().getVoucherOrderList(SharedPreferencesManager.getMarryUid(),voucher_state);
    }

    public void getCDKeyVoucherOrderList(String vr_state){
        getModel().setTag(MarryIntegerUtil.WEB_API_CDKeyVoucherOrder);
        getModel().getCDKeyVoucherOrderList(SharedPreferencesManager.getMarryUid(),vr_state);
    }

    public void getSpreeBounsList(){
        getModel().setTag(MarryIntegerUtil.WEB_API_SpreeBounsList);
        getModel().getSpreeBounsList(SharedPreferencesManager.getMarryUid());
    }

    public void getAppointmentList(String appointment_isfeed){
        getModel().setTag(MarryIntegerUtil.WEB_API_AppointmentList);
        getModel().getAppointmentList(appointment_isfeed,SharedPreferencesManager.getMarryUid());
    }

    public void getPayOrderList(String order_state){
        getModel().setTag(MarryIntegerUtil.WEB_API_PayOrderList);
        getModel().getPayOrderList(order_state,SharedPreferencesManager.getMarryUid());
    }

    public void cancelOrder(String pay_sn){
        getModel().setTag(MarryIntegerUtil.WEB_API_CancelOrder);
        getModel().cancelOrder(pay_sn,SharedPreferencesManager.getMarryUid());
    }

    public void confirmOrder(String orderId){
        getModel().setTag(MarryIntegerUtil.WEB_API_ConfirmOrder);
        getModel().confirmOrder(orderId,SharedPreferencesManager.getMarryUid());
    }

    public void getOutdoorSceneList(String orderId, String shopId){
        getModel().setTag(MarryIntegerUtil.WEB_API_OutdoorScene);
        getModel().getOutdoorSceneList(SharedPreferencesManager.getMarryUid(),orderId,shopId);
    }

    public void getIndoorSceneList(String orderId, String shopId){
        getModel().setTag(MarryIntegerUtil.WEB_API_IndoorScene);
        getModel().getIndoorSceneList(SharedPreferencesManager.getMarryUid(),orderId,shopId);
    }

    @Override
    public void onSuccess(int tage, Object data) {
        switch (tage){

            case MarryIntegerUtil.WEB_API_OrderList:
                getView().onResultSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_OrderByType:
                OrderListBean orderList = (OrderListBean) data;
                if (orderList==null)
                    return;
                ArrayList<OrderBean> list = orderList.getData();
                if (list==null || list.isEmpty())
                    return;
                getView().onResultOrderBeanSuccess(list.get(0));
                break;

            case MarryIntegerUtil.WEB_API_CurrentProcedure:
            case MarryIntegerUtil.WEB_API_OrderProgress:
            case MarryIntegerUtil.WEB_API_OrderInfo:
                if (data instanceof CurrentProcedureBean)
                    getView().onResultMainSuccess(data);
                else if (data instanceof MyOrderBean)
                    getView().onResultOrderInfoDatas(data);
                else if (data instanceof FirstOrderBean)
                    getView().onResultTabSuccess(data);
                break;

            case MarryIntegerUtil.WEB_API_ReservePhotoGraphDetail:
                getView().onResultReservePhotoGraphDetailDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveChoiceClothes:
                getView().onResultReserveChoiceClothesDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveChoicePhoto:
                getView().onResultReserveChoicePhotoDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveFinishingDate:
                getView().onResultReserveFinishingDate(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveTemplateDate:
                getView().onResultReserveTemplateDate(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveExpressDate:
                getView().onResultReserveExpressDate(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveComentDatas:
                getView().onResultReserveComentDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_ReserveRemarkList:
                getView().onResultReserveRemarkDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_PickUpDetails:
                getView().onResultPickUpDetailsDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_CameraStrategy:
                getView().onResultCameraStrategyDetail(data);
                break;

            case MarryIntegerUtil.WEB_API_NewCircuitView:
                getView().onResultNewCircuitView(data);
                break;

            case MarryIntegerUtil.WEB_API_NewAllStrategyView:
                getView().onResultAllStrategyView(data);
                break;

            case MarryIntegerUtil.WEB_API_VoucherOrder:
                getView().onResultVoucherOrder(data);
                break;

            case MarryIntegerUtil.WEB_API_CDKeyVoucherOrder:
                getView().onResultCDKeyVoucherOrder(data);
                break;

            case MarryIntegerUtil.WEB_API_SpreeBounsList:
                getView().onResultSpreeBounsDatas(data);
                break;

            case MarryIntegerUtil.WEB_API_AppointmentList:
                getView().onResultAppointmentList(data);
                break;

            case MarryIntegerUtil.WEB_API_PayOrderList:
                getView().onResultPayOrderList(data);
                break;

            case MarryIntegerUtil.WEB_API_CancelOrder:
                getView().onResultCancelOrder(data);
                break;

            case MarryIntegerUtil.WEB_API_ConfirmOrder:
                getView().onResultConfirmOrder(data);
                break;

            case MarryIntegerUtil.WEB_API_OutdoorScene:
                getView().onResultOutdoorScene(data);
                break;

            case MarryIntegerUtil.WEB_API_IndoorScene:
                getView().onResultIndoorScene(data);
                break;
        }
    }

    @Override
    public void onFailure(int tage, String msg) {
        switch (tage){
            case MarryIntegerUtil.WEB_API_OrderList:
                ToastUtil.showShort(msg);
                break;

            default:
                ToastUtil.showShort(msg);
                break;
        }
    }

    @Override
    public void onComplete(int tager) {
        getView().onComplete();
    }


    @Override
    public void loadDatas() {
        getView().loadDatas();
    }

    @Override
    public void OnClick(View v) {
        getView().OnClick(v);
    }

}
