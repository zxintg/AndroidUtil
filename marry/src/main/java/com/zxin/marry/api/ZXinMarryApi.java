package com.zxin.marry.api;

import com.zxin.marry.bean.AddressListBean;
import com.zxin.marry.bean.AdvconBean;
import com.zxin.marry.bean.AppointmentBean;
import com.zxin.marry.bean.ArticlesBean;
import com.zxin.marry.bean.BanquetHallBean;
import com.zxin.marry.bean.BanquetListBean;
import com.zxin.marry.bean.BaseBean;
import com.zxin.marry.bean.BookdressdateBean;
import com.zxin.marry.bean.CDkeyBean1;
import com.zxin.marry.bean.CameramandBean;
import com.zxin.marry.bean.CartListBean;
import com.zxin.marry.bean.CaseDetailsBean;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.CircuitViewPagerBean;
import com.zxin.marry.bean.CityForm;
import com.zxin.marry.bean.CollectBean;
import com.zxin.marry.bean.CollectionBean;
import com.zxin.marry.bean.Common;
import com.zxin.marry.bean.CurrentProcedureBean;
import com.zxin.marry.bean.DishsListBean;
import com.zxin.marry.bean.Entity;
import com.zxin.marry.bean.FInishingBean;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.bean.GetphotodateBean;
import com.zxin.marry.bean.GifListBean;
import com.zxin.marry.bean.GoodsDetailsBean;
import com.zxin.marry.bean.HotelCaseBean;
import com.zxin.marry.bean.HotelDetails;
import com.zxin.marry.bean.HotelListBean;
import com.zxin.marry.bean.HotelSearchBean;
import com.zxin.marry.bean.HybridMessageBean;
import com.zxin.marry.bean.MarriageCircleForm;
import com.zxin.marry.bean.MarriedProcessBean;
import com.zxin.marry.bean.MarryProductForm;
import com.zxin.marry.bean.MarryRegistList;
import com.zxin.marry.bean.MyGoodsOrderBean;
import com.zxin.marry.bean.MyOrderBean;
import com.zxin.marry.bean.OnLineCameraForm;
import com.zxin.marry.bean.OrderListBean;
import com.zxin.marry.bean.PhotoDataBean;
import com.zxin.marry.bean.PickUpBean;
import com.zxin.marry.bean.PostsInfoBean;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.RecommendHotelBean;
import com.zxin.marry.bean.RemarkListBean;
import com.zxin.marry.bean.RemarkStatusBean;
import com.zxin.marry.bean.SelectPhotoDateBean;
import com.zxin.marry.bean.ShootStategyBean;
import com.zxin.marry.bean.ShopCaseBean;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.marry.bean.ShopDetails;
import com.zxin.marry.bean.ShopGoodsBean;
import com.zxin.marry.bean.ShopInformation;
import com.zxin.marry.bean.StoreCommentList;
import com.zxin.marry.bean.SubjectDetailForm;
import com.zxin.marry.bean.SubjectForm;
import com.zxin.marry.bean.TEmplateBean;
import com.zxin.marry.bean.TaskListCommon;
import com.zxin.marry.bean.TermsBean;
import com.zxin.marry.bean.ThreeHotelBean;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.bean.UserMeaagseBean;
import com.zxin.marry.bean.VoucherBaseBean;
import com.zxin.marry.bean.WeddingMainBean;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ZXinMarryApi{

  @GET("index.php?g=Xmsapishopm&m=information&a=advcon&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AdvconBean>  getMarryAdsList();

  @GET("index.php?g=Xmsapishopm&m=login&a=do_login&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<UserCommon>  userLogin(@Query("username") String username,
                                    @Query("password") String password);

  @GET("index.php?g=Xmsapishopm&m=login&a=loginusercode&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<UserCommon>  verifyLogin(@Query("username") String username,
                                    @Query("code") String code);

  @GET("index.php?g=Xmsapishopm&m=login&a=getlogincode&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<Common>  sendVerifyLogin(@Query("phone") String phone);

  @GET("index.php?g=Xmsapishopm&m=thememessage&a=messagenumber&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ResponseBody>  getMessageNumber();

  @GET("index.php?g=Xmsapishopm&m=circle&a=circleindex&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MarriageCircleForm>  getRequestList();

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=theme&a=detail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TopicDetailForm>  getTopicDetail(
                                    @Field("uid") String uid,
                                    @Field("theme_id") String themeId);

  @GET("index.php?g=Xmsapishopm&m=usermessage&a=get_usermessage&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<UserCommon>  getUserInfo(@Query("uid") String uid);

  @GET("index.php?g=Xmsapishopm&m=usermessage&a=change_sex&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<Entity>  updateUserSex(@Query("uid") String uid , @Query("sex") String sex);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=city&a=checkCity&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<Entity> checkCity(@Field("city") String cityId);

  @GET("index.php?g=Xmsapishopm&m=myorders&a=myorderlist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<OrderListBean> getOrderList(@Query("uid") String uid,
                                         @Query("type") String type);

  @GET("index.php?g=Xmsapishopm&m=Userprocedure&a=get_usercurrentprocedure&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CurrentProcedureBean> getCurrentProcedure(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=Userprocedure&m=Userprocedure&a=get_userprocedure&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<FirstOrderBean> getOrderProgress(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=myorders&a=orderdetail2&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MyOrderBean> getOrderInfoDetail(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=OrderManager&a=photodate&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<PhotoDataBean> getReservePhotoGraphDetail(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=myorders&a=bookdressdate&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<BookdressdateBean> getReserveChoiceClothes(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=selectphoto&a=selectphotodate&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<SelectPhotoDateBean> getReserveChoicePhoto(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=Userprocedure&a=get_userproceduredetail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<FInishingBean> getFinishingDate(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid,
                                        @Query("procedureid") String procedureid);

  @GET("index.php?g=Xmsapishopm&m=Userprocedure&a=get_userproceduredetail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TEmplateBean> getTemplateDate(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid,
                                        @Query("procedureid") String procedureid);

  @GET("index.php?g=Xmsapishopm&m=getphoto&a=getphotodate&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<GetphotodateBean> getReserveExpressDate(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=myorders&a=remarkstatus&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<RemarkStatusBean> getReserveComentDatas(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid,
                                        @Query("typeid") String typeid);

  @GET("index.php?g=Xmsapishopm&m=Myorders&a=remark_list&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<RemarkListBean> getReserveRemarkList(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid,
                                        @Query("typeid") String typeid,
                                        @Query("status") int status);

  @GET("index.php?g=Xmsapishopm&m=getphoto&a=orderphotodetail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<PickUpBean> getPickUpDetails(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Raidersnew&a=user_raiders&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShootStategyBean> getIndoorSceneList(
                                        @Field("uid") String uid,
                                        @Field("orderid") String orderid,
                                        @Field("shopid") String shopid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Raidersnew&a=user_raiders_line&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShootStategyBean> getOutdoorSceneList(
                                        @Field("uid") String uid,
                                        @Field("orderid") String orderid,
                                        @Field("shopid") String shopid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=OrderManager&m=Raiders&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShootStategyBean> getCameraStrategyDetail(
                                        @Field("uid") String uid,
                                        @Field("shopid") String shopid,
                                        @Field("orderid") String orderid);

  @GET("index.php?g=Xmsapishopm&m=myorders&a=cameramand&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CameramandBean> getDesignAndCameraDetail(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid,
                                        @Query("shopid") String shopid);

  @GET("index.php?g=Xmsapishopm&m=Cameraman&a=onlineOrder&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<OnLineCameraForm> getReserveRecordList(
                                        @Query("uid") String uid,
                                        @Query("orderid") String orderid);
  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=usermessage&a=customer&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<UserMeaagseBean> getServiceCenterDatas(
                                        @Field("uid") String uid,
                                        @Field("shopid") String shopid);
  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=usermessage&m=Raidersnew&a=linedetail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CircuitViewPagerBean> getNewCircuitView(
                                        @Field("uid") String uid,
                                        @Field("orderid") String orderid,
                                        @Field("shopid") String shopid,
                                        @Field("lineid") String lineId);
  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=usermessage&m=Raidersnew&a=collectscene&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<BaseBean> updatasSeneCollect(
                                        @Field("uid") String uid,
                                        @Field("orderid") String orderid,
                                        @Field("shopid") String shopid,
                                        @Field("lineid") String lineId,
                                        @Field("sceneid") String sceneid,
                                        @Field("typeid") String typeid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=circle&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CircleForm> getCircleList(
                                        @Field("pagenumber") int pagenumber,
                                        @Field("pagetype") String pagetype,
                                        @Field("page") int page);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=theme&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TopicForm> getHomeCircleList(
                                        @Field("page") Integer page,
                                        @Field("pagetype") String pagetype,
                                        @Field("pagetime") String pagetime,
                                        @Field("pagenumber") String pagenumber,
                                        @Field("circle_id") String circle_id,
                                        @Field("thclass_id") String thclass_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=usermessage&a=messagexmslist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<HybridMessageBean> getMessageList(
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Raidersnew&a=raiders&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShootStategyBean> getNewAllStrategyNoLineList(
                                        @Field("uid") String uid,
                                        @Field("orderid") String orderid,
                                        @Field("shopid") String shopid,
                                        @Field("typeid") String typeid,
                                        @Field("sceneid") String sceneid,
                                        @Field("lineid") String lineid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=raidersnew&a=user_raiders_scene&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShootStategyBean> getNewAllStrategyList(
                                        @Field("uid") String uid,
                                        @Field("orderid") String orderid,
                                        @Field("shopid") String shopid,
                                        @Field("typeid") String typeid,
                                        @Field("sceneid") String sceneid,
                                        @Field("lineid") String lineid);

  @GET("index.php?g=Xmsapishopm&m=city&a=getCityList&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CityForm> getCityList();

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=taobaokeindex&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MarryProductForm> getNationwideDatas(
                                        @Field("cityid") String cityId);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shopclass&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopClassBean> getDiscoveryCityDatas(
                                        @Field("cityid") String cityId);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=taobaokeindex&a=goodtypeindex&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MarryProductForm> getProductList(
                                        @Field("goodtypeid") String cityId,
                                        @Field("page") int page,
                                        @Field("pagetime") String pagetime,
                                        @Field("pagenumber") String pagenumber);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=getClassAR&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<RecommendForm> getShopListBanner(
                                        @Field("sc_id") String sc_id,
                                        @Field("cityid") String cityId);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_goods&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopInformation> getShopGoodsList(
                                        @Field("page") int page,
                                        @Field("pagetype") String pagetype,
                                        @Field("pagetime") String pagetime,
                                        @Field("pagenumber") String pagenumber,
                                        @Field("sc_id") String sc_id,
                                        @Field("cityid") String cityid
                                        );

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_case&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopInformation> getShopCaseList(
                                        @Field("page") int page,
                                        @Field("pagetype") String pagetype,
                                        @Field("pagetime") String pagetime,
                                        @Field("pagenumber") String pagenumber,
                                        @Field("sc_id") String sc_id,
                                        @Field("cityid") String cityid
                                        );

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shops&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopInformation> getShopList(
                                        @Field("page") int page,
                                        @Field("pagetype") String pagetype,
                                        @Field("pagetime") String pagetime,
                                        @Field("pagenumber") String pagenumber,
                                        @Field("areaid") String areaid,
                                        @Field("sc_id") String sc_id,
                                         @Field("cityid") String cityid
                                        );

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shopgood&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<GoodsDetailsBean> getGoodsDetails(
                                        @Field("goods_id") String goodsId,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=cartadd&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CollectionBean> inPutCart(
                                        @Field("goods_id") String goodsId,
                                        @Field("quantity") String quantity,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=favorites_user&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CollectionBean> setCollection(
                                        @Field("goods_id") String goodsId,
                                        @Field("iscancel") String iscancel,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shopcase&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CaseDetailsBean> getShopCaseDetails(
                                        @Field("case_id") String case_id,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=store_voucher&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<VoucherBaseBean> getVoucherOrderList(
                                        @Field("voucher_state") String voucher_state,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=myvr_orderlist1&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CDkeyBean1> getCDKeyVoucherOrderList(
                                        @Field("vr_state") String vr_state,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=gift_list&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<GifListBean> getSpreeBounsList(
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=appointment_list&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AppointmentBean> getAppointmentList(
                                        @Field("appointment_isfeed") String appointment_isfeed,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=myorderlist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MyGoodsOrderBean> getPayOrderList(
                                        @Field("order_state") String order_state,
                                        @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=cancel_order&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<Entity> cancelOrder(@Field("pay_sn") String pay_sn,
                                 @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=confirm_order&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MyGoodsOrderBean> confirmOrder(@Field("order_id") String order_id,
                                 @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=cartlist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CartListBean> getCartList(
                                 @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=theme&a=checknickname&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TopicDetailForm> checkNick(
                                 @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=favorites_userlist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<CollectBean> getCollectList(
                                 @Field("fav_type") String fav_type,
                                 @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=mytheme&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TopicForm> getMineTopicList1(
                                 @Field("uid") String uid,
                                 @Field("page") int page,
                                 @Field("pagetype") String pagetype,
                                 @Field("pagetime") String pagetime,
                                 @Field("pagenumber") String pagenumber);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=mytheme&a=mycollectindex&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TopicForm> getMineTopicList2(
                                 @Field("uid") String uid,
                                 @Field("page") int page,
                                 @Field("pagetype") String pagetype,
                                 @Field("pagetime") String pagetime,
                                 @Field("pagenumber") String pagenumber);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=addresslist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AddressListBean> getAddressList(
                                 @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=address_default&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AddressListBean> setAddressDefault(
                                  @Field("uid") String uid,
                                  @Field("address_id") String address_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Cartshop&a=addressdel&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AddressListBean> deleteAddress(
                                 @Field("uid") String uid,
                                 @Field("address_id") String address_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Ecshop&a=address_post&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AddressListBean> modifyAddress(
                                 @Field("uid") String uid,
                                 @Field("true_name") String true_name,
                                 @Field("mob_phone") String mob_phone,
                                 @Field("area_info") String area_info,
                                 @Field("address") String address,
                                 @Field("is_default") String is_default,
                                 @Field("address_id") String address_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Ecshop&a=address_post&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<AddressListBean> addressAddress(
                                 @Field("uid") String uid,
                                 @Field("true_name") String true_name,
                                 @Field("mob_phone") String mob_phone,
                                 @Field("area_info") String area_info,
                                 @Field("address") String address,
                                 @Field("is_default") String is_default);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Ecshop&a=address_post&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<PostsInfoBean> getPostsInfo(
                                 @Field("posts_id") String posts_id);

  @GET("index.php?g=Xmsapishopm&m=Article&a=getTerms&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TermsBean> getHotNewsMenus();

  @GET("index.php?g=Xmsapishopm&m=information&a=marriprocess&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<MarriedProcessBean> getMarriProcess();

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Article&a=getArticles&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ArticlesBean> getHontNewsList(
                                @Field("term_id") String term_id,
                                @Field("page") int page,
                                @Field("pagetype") String pagetype,
                                @Field("pagetime") String pagetime,
                                @Field("pagenumber") String pagenumber);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shop&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopDetails> getShopDetail(
                                @Field("uid") String uid,
                                @Field("store_id") String store_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=usermessage&a=get_usermessage&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<UserCommon> getUserMessage(
                                @Field("uid") String uid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=task&a=get_tasks_date&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TaskListCommon> getTaskList1(
                                @Field("uid") String uid,
                                @Field("userid") String userid,
                                @Field("marrydate") String marrydate);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=task&a=get_tasks&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TaskListCommon> getTaskList2(
                                @Field("uid") String uid,
                                @Field("userid") String userid,
                                @Field("marrydate") String marrydate);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=task&a=get_overtasks_date&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<TaskListCommon> getTaskList3(
                                @Field("uid") String uid,
                                @Field("userid") String userid,
                                @Field("marrydate") String marrydate);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Marrytopic&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<SubjectForm> getSubjectList(
                                @Field("page") int page,
                                @Field("pagetype") String pagetype,
                                @Field("pagetime") String pagetime,
                                @Field("pagenumber") String pagenumber);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Marrytopic&a=topicgoods&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<SubjectDetailForm> getSubjectDetail(
                                @Field("topicid") String topicid);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shopgoods&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopGoodsBean> getStoreGoodsList(
                                @Field("store_id") String store_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=ecshop&a=get_shopcases&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ShopCaseBean> getStoreCaseList(
                                @Field("store_id") String store_id);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Ecshop&a=storeCommentsList&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<StoreCommentList> getStoreCommentList(
                                @Field("store_id") String store_id);

  @GET("index.php?g=Feastb&m=hotel&a=hotel_three&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<ThreeHotelBean> getFindHotleDetail();

  @GET("index.php?g=Feastb&m=Hotel&a=recommendHotel&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<RecommendHotelBean> getRecommendHotelList(
                                @Query("feastid") String feastId);

  @GET("index.php?g=Feastb&m=Index&a=index&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<WeddingMainBean> getWeddingMain(
                                @Query("feastid") String feastId);

  @FormUrlEncoded
  @POST("index.php?g=Feastb&m=hotel&a=hoteldetail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<HotelDetails> getWeddingDetail(
                                @Field("id") String hotelid);

  @FormUrlEncoded
  @POST("index.php?g=Feastb&m=hotel&a=hotellist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<HotelListBean> getHotelList(
                                @Field("feastid") String feastId,
                                @Field("areaid") String areaid,
                                @Field("optionsite_id") String optionsite_id,
                                @Field("price_sort") String price_sort,
                                @Field("optionsiteid") String optionsiteid,
                                @Field("optiontableid") String optiontableid,
                                @Field("optionpriceid") String optionpriceid,
                                @Field("area_id") String area_id,
                                @Field("table_max") String table_max,
                                @Field("page") int page,
                                @Field("pagetype") String pagetype,
                                @Field("pagetime") String pagetime,
                                @Field("pagenumber") String pagenumber);

  @GET("index.php?g=Feastb&m=hotel&a=hotel_search&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<HotelSearchBean> getHoteSearch(
                                @Query("feastid") String feastId);

  @GET("index.php?g=Feastb&m=banquet&a=banquetdetail&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<BanquetHallBean> getBanquetHallDetails(
                                @Query("id") String id);

  @FormUrlEncoded
  @POST("index.php?g=Feastb&m=banquet&a=banquetlist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<BanquetListBean> getBanquetMoreList(
                                @Field("id") String id,
                                @Field("page") int page,
                                @Field("pagetype") String pagetype,
                                @Field("pagetime") String pagetime,
                                @Field("pagenumber") String pagenumber);

  @FormUrlEncoded
  @POST("index.php?g=Xmsapishopm&m=Ecshop&a=get_hotelcases&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<HotelCaseBean> getCaseMoreList(
                                @Field("hotelid") String hotelid);

  @FormUrlEncoded
  @POST("index.php?g=Feastb&m=banquet&a=cookbooklist&token=43378e1b35ae7858e82eba2b27ddefd7")
  Observable<DishsListBean> getDishsMoreList(
                                @Field("id") String id,
                                @Field("page") int page,
                                @Field("pagetype") String pagetype,
                                @Field("pagetime") String pagetime,
                                @Field("pagenumber") String pagenumber);

  @GET("geosearch/v3/local?ak=VOfm0hW58xv3Gy1f9EjdThwZNf9nzPfu&mcode=65:EA:DA:B9:0A:DD:07:08:EA:19:A7:34:CB:64:59:61:DF:8E:7F:1E;com.zxin&geotable_id=191756")
  Observable<MarryRegistList> getMarryRegistList(
                                @Query("region") String region,
                                @Query("tags") String tags,
                                @Query("page_index") int page_index,
                                @Query("page_size") int page_size);

}
