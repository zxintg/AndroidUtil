package com.zxin.jiuxian.api;

import com.zxin.jiuxian.bean.CateLeftPageResult;
import com.zxin.jiuxian.bean.CatePageResult;
import com.zxin.jiuxian.bean.CheckUpdateResult;
import com.zxin.jiuxian.bean.CircleActInfoResult;
import com.zxin.jiuxian.bean.ClubUserProduct;
import com.zxin.jiuxian.bean.CommendDetailTabResult;
import com.zxin.jiuxian.bean.DeliveryTimeResult;
import com.zxin.jiuxian.bean.HomeHeaderResult;
import com.zxin.jiuxian.bean.HomeTabIconResult;
import com.zxin.jiuxian.bean.HomeWineListResult;
import com.zxin.jiuxian.bean.LaunchPageInfoResult;
import com.zxin.jiuxian.bean.LoginInfoResult;
import com.zxin.jiuxian.bean.ProductDetailResult;
import com.zxin.jiuxian.bean.ProductListInfoResult;
import com.zxin.jiuxian.bean.RecommendInfoResult;
import com.zxin.jiuxian.bean.SeckillInfoHomeResult;
import com.zxin.jiuxian.bean.UserCenterModuleData;
import com.zxin.jiuxian.bean.UserCenterResult;
import com.zxin.jiuxian.bean.XinkeInfoResult;
import java.util.Map;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ZXinJiuXianApi {

    @GET("home/getUpdateInfo.htm")
    Observable<RootResult<CheckUpdateResult>> getUpdateInfo(@Query("osLargeVersion") String osLargeVersion,
                                                            @Query("netEnv") String netEnv,
                                                            @Query("cpsId") String cpsId,
                                                            @Query("appVersion") String appVersion);

    @GET("/home/navigation.htm")
    Observable<RootResult<HomeTabIconResult>> getTabMainIcon(@QueryMap Map<String, String> paramMap);

    @GET("home/getXinKeDialog.htm")
        //新人频道-app首页弹窗
    Observable<RootResult<XinkeInfoResult>> getXinKeDialog();

    @GET("home/getCircleActInfo.htm")
        //客户端浮窗广告位
    Observable<RootResult<CircleActInfoResult>> getCircleActInfo(@QueryMap Map<String, String> paramMap);

    @GET("home/getHomePageInfoAmend.htm")
        //首页数据
    Observable<RootResult<HomeHeaderResult>> getHomePageInfoAmend(@QueryMap Map<String, String> paramMap);

    @GET("home/getMiaoPaiProForIndex.htm")
        //秒拍
    Observable<RootResult<SeckillInfoHomeResult>> getMiaoPaiProForIndex(@QueryMap Map<String, String> paramMap);

    @GET("product/categoryList.htm")
    Observable<RootResult<CateLeftPageResult>> getCategoryList(
            @QueryMap Map<String, String> paramMap);

    @GET("home/navigation.htm")
    Observable<RootResult<RecommendInfoResult>> navigation(
            @Query("apiVersion") String apiVersion,
            @Query("height") String height,
            @Query("width") String width,
            @Query("mark") String mark
    );

    @GET("home/getFunctionSwitch.htm")
    Observable<RootResult<RecommendInfoResult>> getFunctionSwitch(
            @Query("osLargeVersion") String osLargeVersion,
            @Query("netEnv") String netEnv,
            @Query("appVersion") String appVersion,
            @Query("equipmentType") String equipmentType,
            @Query("sysVersion") String sysVersion,
            @Query("cpsId") String cpsId
    );

    @GET("home/openImage.htm")
    Observable<RootResult<LaunchPageInfoResult>> openImage(@QueryMap Map<String, String> paramMap);

    @GET("home/recommend.htm")
        //推荐
    Observable<RootResult<HomeWineListResult>> recommend(
            @QueryMap Map<String, String> paramMap
            );


    @GET("home/getSwitchInfo.htm")
    Observable<RootResult<HomeWineListResult>> getSwitchInfo(
            @Query("switchType") String switchType
    );

    @GET("home/getMobileExclusiveProList.htm")
    Observable<RootResult<HomeWineListResult>> getMobileExclusiveProList(
            @Query("topicTypeId") String topicTypeId,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("home/preventCheatRemind.htm")
    Observable<RootResult<HomeWineListResult>> preventCheatRemind(
            @Query("type") String type
    );

    @GET("home/getMobileSecondProList.htm")
    Observable<RootResult<HomeWineListResult>> getMobileSecondProList(
            @Query("fieldNo") String fieldNo,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("home/setSwitchInfo.htm")
    Observable<RootResult<HomeWineListResult>> setSwitchInfo(
            @Query("startHour") String startHour,
            @Query("endHour") String endHour,
            @Query("switchType") String switchType,
            @Query("switchStatus") String switchStatus
    );

    @GET("home/getMobileSecondBeats.htm")
    Observable<RootResult<HomeWineListResult>> getMobileSecondBeats();

    @GET("home/getAreaCompartment.htm")
    Observable<RootResult<HomeWineListResult>> getAreaCompartment();

    @GET("product/proDetailNavigation.htmm")
    Observable<RootResult<HomeWineListResult>> proDetailNavigation();

    @GET("home/getMobileExclusiveInfo.htm")
    Observable<RootResult<HomeWineListResult>> getMobileExclusiveInfo();

    @GET("home/getSettingSwitchInfo.htm")
    Observable<RootResult<HomeWineListResult>> getSettingSwitchInfo();

    @GET("productOfRecommend/getProductOfRecommendInfo.htm")
    Observable<RootResult<RecommendInfoResult>> getProductOfRecommendInfo(
            @QueryMap Map<String, String> paramMap
            );

    @GET("keyword/getSearchHotKeyword.htm")
    Observable<RootResult<HomeWineListResult>> getSearchHotKeyword(
            @Query("boxType") String boxType);

    @GET("community/joinToAlcoholFriendsCircle.htm")
    Observable<RootResult<HomeWineListResult>> joinToAlcoholFriendsCircle(
            @Query("fid") String fid);

    @GET("search/searchBoxHotWords.htm")
    Observable<RootResult<HomeWineListResult>> searchBoxHotWords();

    @GET("jiukacha/getWineInfo.htm")
    Observable<RootResult<HomeWineListResult>> getWineInfo(
            @Query("wineId") String wineId,
            @Query("sign") String sign,
            @Query("jxProId") String jxProId,
            @Query("year") String year
    );

    @GET("coupon/pickable.htm")
    Observable<RootResult<HomeWineListResult>> pickable(
            @Query("productIds") String productIds
    );

    @GET("shoppingcart/delete.htm")
    Observable<RootResult<HomeWineListResult>> cartDelete(
            @Query("skuIds") String skuIds
    );

    @GET("shoppingcart/updateNum.htm")
    Observable<RootResult<HomeWineListResult>> cartUpdateNum(
            @Query("skuId") String skuId,
            @Query("num") String num
    );

    @GET("community/isAttention.htm")
    Observable<RootResult<HomeWineListResult>> isAttention(
            @Query("userName") String userName,
            @Query("attentionedUserName") String attentionedUserName
    );

    @GET("messages/graphValidate.htm")
    Observable<RootResult<HomeWineListResult>> graphValidate(
            @Query("mobile") String mobile,
            @Query("type") String type,
            @Query("code") String code
    );

    @GET("collection/delCollection.htm")
    Observable<RootResult<HomeWineListResult>> delCollection(
            @Query("proIds") String proIds
    );

    @GET("collection/getCollectionList.htm")
    Observable<RootResult<HomeWineListResult>> getCollectionList(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("comment/getBigPictures.htm")
    Observable<RootResult<HomeWineListResult>> getBigPictures(
            @Query("productId") String productId,
            @Query("commentId") String commentId,
            @Query("pager") String pager,
            @Query("pictureId") String pictureId
    );

    @GET("comment/getProductComment.htm")
    Observable<RootResult<CommendDetailTabResult>> getProductComment(
            @QueryMap Map<String, String> paramMap
    );

    @GET("comment/getProductCommentDetail.htm")
    Observable<RootResult<HomeWineListResult>> getProductCommentDetail(
            @Query("productId") String productId,
            @Query("pager") String pager,
            @Query("labelId") String labelId
    );

    @GET("comment/getCommentList.htm")
    Observable<RootResult<HomeWineListResult>> getCommentList(
            @Query("state") String state,
            @Query("pager") String pager
    );

    @GET("comment/getCommentDetail.htm")
    Observable<RootResult<HomeWineListResult>> getCommentDetail(
            @Query("commentId") String commentId
    );

    @GET("community/pushComment.htm")
    Observable<RootResult<HomeWineListResult>> pushComment(
            @Query("tid") String tid,
            @Query("message") String message,
            @Query("replyToAnyonePid") String replyToAnyonePid
    );

    @GET("comment/getLabels.htm")
    Observable<RootResult<HomeWineListResult>> getLabels(
            @Query("productId") String productId
    );

    @GET("comment/getShowOrderList.htm")
    Observable<RootResult<HomeWineListResult>> getShowOrderList(
            @Query("pager") String pager,
            @Query("orderId") String orderId
    );

    @GET("comment/getCommentList.htm")
    Observable<RootResult<HomeWineListResult>> getCommentList(
            @Query("state") String state,
            @Query("isNotAuditing") String isNotAuditing,
            @Query("pager") String pager
    );

    @GET("comment/getOrderHaveComment.htm")
    Observable<RootResult<HomeWineListResult>> getOrderHaveComment(
            @Query("orderId") String orderId
    );

    @GET("community/addBlackList.htm")
    Observable<RootResult<HomeWineListResult>> addBlackList(
            @Query("crimeUid") String crimeUid
    );

    @GET("community/getContentDetail.htm")
    Observable<RootResult<HomeWineListResult>> getContentDetail(
            @Query("tid") String tid,
            @Query("supportMixed") String supportMixed
    );

    @GET("community/getAlcoholFriendsCircleDetail.htm")
    Observable<RootResult<HomeWineListResult>> getAlcoholFriendsCircleDetail(
            @Query("fid") String fid
    );

    @GET("community/getAlcoholFriendsCircleDetailFlow.htm")
    Observable<RootResult<HomeWineListResult>> getAlcoholFriendsCircleDetailFlow(
            @Query("fid") String fid,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getContentDetailCommentList.htm")
    Observable<RootResult<HomeWineListResult>> getContentDetailCommentList(
            @Query("tid") String tid,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/pushClientCreditRule.htm")
    Observable<RootResult<HomeWineListResult>> pushClientCreditRule(
            @Query("type") String type,
            @Query("value") String value
    );

    @GET("community/delComment.htm")
    Observable<RootResult<HomeWineListResult>> delComment(
            @Query("pid") String pid
    );

    @GET("community/reportContentDetail.htm")
    Observable<RootResult<HomeWineListResult>> reportContentDetail(
            @Query("tid") String tid
    );

    @GET("community/signOutAlcoholFriendsCircle.htm")
    Observable<RootResult<HomeWineListResult>> signOutAlcoholFriendsCircle(
            @Query("fid") String fid
    );

    @GET("community/getMyCreditRuleFlow.htm")
    Observable<RootResult<HomeWineListResult>> getMyCreditRuleFlow(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getCreditRule.htm")
    Observable<RootResult<HomeWineListResult>> getCreditRule();

    @GET("community/getMyFavoriteTopicList.htm")
    Observable<RootResult<HomeWineListResult>> getMyFavoriteTopicList(
            @Query("queryForUid") String queryForUid,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getMyWineList.htm")
    Observable<RootResult<HomeWineListResult>> getMyWineList(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getRecommendedInformationFlow.htm")
    Observable<RootResult<HomeWineListResult>> getRecommendedInformationFlow(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/hasNewestMessage.htm")
    Observable<RootResult<HomeWineListResult>> hasNewestMessage(
            @Query("uid") String uid
    );

    @GET("community/delMyMessage.htm")
    Observable<RootResult<HomeWineListResult>> delMyMessage(
            @Query("nid") String nid
    );

    @GET("community/pushMyMessageReadFlag.htm")
    Observable<RootResult<HomeWineListResult>> pushMyMessageReadFlag(
            @Query("nid") String nid
    );

    @GET("community/getMyPublishTopicList.htm")
    Observable<RootResult<HomeWineListResult>> getMyPublishTopicList(
            @Query("queryForUid") String queryForUid,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getActiveList.htm")
    Observable<RootResult<HomeWineListResult>> getActiveList(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getRecommendedAlcoholFriendsCircleList.htm")
    Observable<RootResult<HomeWineListResult>> getRecommendedAlcoholFriendsCircleList(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("community/getActiveDetailThreadList.htm")
    Observable<RootResult<HomeWineListResult>> getActiveDetailThreadList(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize,
            @Query("activityId") String activityId
    );

    @GET("community/getActiveDetail.htm")
    Observable<RootResult<HomeWineListResult>> getActiveDetail(
            @Query("activityId") String activityId
    );

    @GET("community/getMyRecommendedInformationFlow.htm")
    Observable<RootResult<HomeWineListResult>> getMyRecommendedInformationFlow(
            @Query("tids") String tids
    );

    @GET("community/pushContentDetailStatus.htm")
    Observable<RootResult<HomeWineListResult>> pushContentDetailStatus(
            @Query("tid") String tid,
            @Query("activityTop") String activityTop,
            @Query("homePageTop") String homePageTop,
            @Query("circleTop") String circleTop,
            @Query("del") String del
    );

    @GET("community/pushPraise.htm")
    Observable<RootResult<HomeWineListResult>> pushPraise(
            @Query("tid") String tid,
            @Query("type") String type
    );

    @FormUrlEncoded
    @POST("community/pushMixedWineTopic.htm")
    Observable<RootResult<HomeWineListResult>> pushMixedWineTopic(
            @Field("mixed") String mixed,
            @Field("fid") String fid,
            @Field("activityId") String activityId,
            @Field("tid") String tid,
            @Field("subject") String subject
    );

    @GET("community/reportContentDetail.htm")
    Observable<RootResult<HomeWineListResult>> reportContentDetail(
            @Query("tid") String tid,
            @Query("reportType") String reportType
    );

    @GET("community/search.htm")
    Observable<RootResult<HomeWineListResult>> search(
            @Query("keywords") String keywords,
            @Query("tabId") String tabId,
            @Query("pageIndex") String pageIndex
    );

    @GET("community/getContentDetailStatus.htm")
    Observable<RootResult<HomeWineListResult>> getContentDetailStatus(
            @Query("tid") String tid
    );

    @GET("community/getPersonalInformation.htm")
    Observable<RootResult<HomeWineListResult>> getPersonalInformation(
            @Query("queryForUid") String queryForUid
    );

    @GET("community/getPersonalTab.htm")
    Observable<RootResult<HomeWineListResult>> getPersonalTab(
            @Query("queryForUid") String queryForUid
    );

    @GET("search/goodsListFilter.htm")
    Observable<RootResult<HomeWineListResult>> goodsListFilter(
            @Query("filterCacheKey") String filterCacheKey
    );

    @GET("community/getTalentList.htm")
    Observable<RootResult<HomeWineListResult>> getTalentList();

    @GET("community/registerMemberInfoInner.htm")
    Observable<RootResult<HomeWineListResult>> registerMemberInfoInner();

    @GET("community/getDrinkingBuddiesText.htm")
    Observable<RootResult<HomeWineListResult>> getDrinkingBuddiesText();

    @GET("community/getHomepageTabList.htm")
    Observable<RootResult<HomeWineListResult>> getHomepageTabList();

    @GET("activity/couponInstructions.htm")
    Observable<RootResult<HomeWineListResult>> couponInstructions();

    @GET("community/getMyAlcoholFriendsCircleList.htm")
    Observable<RootResult<HomeWineListResult>> getMyAlcoholFriendsCircleList();

    @GET("community/getActivityTabIcon.htm")
    Observable<RootResult<HomeWineListResult>> getActivityTabIcon();

    @GET("community/getAdvertisingList.htm")
    Observable<RootResult<HomeWineListResult>> getAdvertisingList();

    @GET("search/removeHistorySearch.htm")
    Observable<RootResult<HomeWineListResult>> removeHistorySearch(
            @Query("keyword") String keyword
    );

    @GET("product/intendingDeliveryTime.htm")
    Observable<RootResult<DeliveryTimeResult>> intendingDeliveryTime(
            @QueryMap Map<String, String> paramMap
    );

    @GET("product/evaluateList.htm")
    Observable<RootResult<HomeWineListResult>> evaluateList(
            @Query("proId") String proId,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize,
            @Query("type") String type
    );

    @GET("community/getMyMessages.htm")
    Observable<RootResult<HomeWineListResult>> getMyMessages(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("cart/unreceived/exchangeProduct/rm.htm")
    Observable<RootResult<HomeWineListResult>> exchangeProductrm(
            @Query("exchangeCode") String exchangeCode
    );

    @GET("memberChannel/getGoldMallProductInfo.htm")
    Observable<RootResult<HomeWineListResult>> getGoldMallProductInfo(
            @Query("goldmallproductId") String goldmallproductId
    );

    @GET("user/accountboundphone.htm")
    Observable<RootResult<HomeWineListResult>> accountboundphone(
            @Query("phone") String phone,
            @Query("verifyCode") String verifyCode,
            @Query("bindType") String bindType,
            @Query("openId") String openId,
            @Query("referer") String referer,
            @Query("userNameOrEmail") String userNameOrEmail
    );

    @GET("memberChannel/submitOrder.htm")
    Observable<RootResult<HomeWineListResult>> submitOrder(
            @Query("gId") String gId,
            @Query("exchangeNum") String exchangeNum,
            @Query("requireNubs") String requireNubs,
            @Query("payPass") String payPass
    );

    @GET("memberChannel/validStock.htm")
    Observable<RootResult<HomeWineListResult>> validStock(
            @Query("gId") String gId,
            @Query("exchangeNum") String exchangeNum
    );

    @GET("promotion/exchangeGoods.htm")
    Observable<RootResult<HomeWineListResult>> exchangeGoods(
            @Query("promotionId") String promotionId
    );

    @GET("feedBack/addfeedback.htm")
    Observable<RootResult<HomeWineListResult>> addfeedback(
            @Query("content") String content,
            @Query("type") String type,
            @Query("contact") String contact,
            @Query("pictures") String pictures
    );

    @GET("im/addGroupMember.htm")
    Observable<RootResult<HomeWineListResult>> addGroupMember(@Query("groupId") String groupId);

    @GET("im/deleteGroupMember.htm")
    Observable<RootResult<HomeWineListResult>> deleteGroupMember(
            @Query("groupId") String groupId,
            @Query("userName") String userName
    );

    @GET("im/getGroupMemberInfo.htm")
    Observable<RootResult<HomeWineListResult>> getGroupMemberInfo(
            @Query("groupId") String groupId,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("im/getJoinedGroupList.htm")
    Observable<RootResult<HomeWineListResult>> getJoinedGroupList(
            @Query("queryForUid") String queryForUid,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("im/modifyGroup.htm")
    Observable<RootResult<HomeWineListResult>> modifyGroup(
            @Query("groupId") String groupId,
            @Query("name") String name
    );

    @GET("im/setGroupRemark.htm")
    Observable<RootResult<HomeWineListResult>> setGroupRemark(
            @Query("groupId") String groupId,
            @Query("reset") String reset,
            @Query("remark") String remark
    );

    @GET("jiukacha/getSearchResult.htm")
    Observable<RootResult<HomeWineListResult>> getSearchResult(
            @Query("ims_id") String ims_id
    );

    @GET("user/loginOut.htm")
    Observable<RootResult<HomeWineListResult>> loginOut(
            @Query("token") String token
    );

    @GET("memberChannel/goldMallProductIndex.htm")
    Observable<RootResult<HomeWineListResult>> goldMallProductIndex(
            @Query("pageNum") String pageNum,
            @Query("tabId") String tabId
    );

    @GET("coupon/addCoupon.htm")
    Observable<RootResult<HomeWineListResult>> addCoupon(
            @Query("couponAccount") String couponAccount,
            @Query("code") String code
    );

    @GET("infomation/allCount.htm")
    Observable<RootResult<HomeWineListResult>> allCount(
            @Query("type") String type
    );

    @GET("messages/mobileCode.htm")
    Observable<RootResult<HomeWineListResult>> mobileCode(
            @Query("type") String type,
            @Query("mobile") String mobile
    );

    @GET("miaomiao/getMiaoMiaoDetailInfo.htm")
    Observable<RootResult<HomeWineListResult>> getMiaoMiaoDetailInfo(
            @Query("type") String type,
            @Query("productId") String productId,
            @Query("name") String name
    );

    @GET("user/replacementMobile.htm")
    Observable<RootResult<HomeWineListResult>> replacementMobile(
            @Query("verifyCode") String verifyCode
    );

    @GET("order/buyAgain.htm")
    Observable<RootResult<HomeWineListResult>> buyAgain(
            @Query("orderId") String orderId
    );

    @GET("user/updateUserInfo.htm")
    Observable<RootResult<HomeWineListResult>> updateUserInfo(
            @Query("nickName") String nickName,
            @Query("sex") String sex,
            @Query("birthday") String birthday
    );

    @GET("messages/graphCode.htm")
    Observable<RootResult<HomeWineListResult>> graphCode(
            @Query("mobile") String mobile,
            @Query("type") String type
    );

    @GET("rder/confirmReceived.htm")
    Observable<RootResult<HomeWineListResult>> confirmReceived(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId
    );

    @GET("order/cancelOrder.htm")
    Observable<RootResult<HomeWineListResult>> cancelOrder(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId
    );

    @GET("order/deleteDoneOrder.htm")
    Observable<RootResult<HomeWineListResult>> deleteDoneOrder(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId
    );

    @GET("order/getOrderDetails.htm")
    Observable<RootResult<HomeWineListResult>> getOrderDetails(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId
    );

    @GET("order/getOrderLogistics.htm")
    Observable<RootResult<HomeWineListResult>> getOrderLogistics(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId
    );

    @GET("order/adv.htm")
    Observable<RootResult<HomeWineListResult>> orderadv(
            @Query("orderSN") String orderSN
    );

    @GET("order/getOrderList.htm")
    Observable<RootResult<HomeWineListResult>> getOrderList(
            @Query("orderState") String orderState,
            @Query("keywords") String keywords,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("order/getEvaluationList.htm")
    Observable<RootResult<HomeWineListResult>> getEvaluationList(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId,
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("order/orderProducts.htm")
    Observable<RootResult<HomeWineListResult>> orderProducts(
            @Query("orderSN") String orderSN,
            @Query("orderId") String orderId
    );

    @GET("promotion/getGroupPromotionById.htm")
    Observable<RootResult<HomeWineListResult>> getGroupPromotionById(
            @Query("promotionId") String promotionId,
            @Query("productId") String productId
    );

    @GET("cashier/pay.htm")
    Observable<RootResult<HomeWineListResult>> pay(
            @Query("orderSN") String orderSN,
            @Query("platform") String platform,
            @Query("payType") String payType,
            @Query("systemType") String systemType,
            @Query("payWay") String payWay,
            @Query("sign") String sign
    );

    @GET("infomation/promotion.htm")
    Observable<RootResult<HomeWineListResult>> promotion(
            @Query("pageSize") String pageSize,
            @Query("pageIndex") String pageIndex,
            @Query("type") String type,
            @Query("roundRobin") String roundRobin,
            @Query("infoId") String infoId
    );

    @GET("cashier/index.htm")
    Observable<RootResult<HomeWineListResult>> cashierList(
            @Query("orderSN") String orderSN,
            @Query("platform") String platform,
            @Query("payType") String payType,
            @Query("systemType") String systemType,
            @Query("sign") String sign
    );

    @GET("orderset/addorder.htm")
    Observable<RootResult<HomeWineListResult>> addorder(
            @Query("orderAddInfo") String orderAddInfo
    );

    @GET("product/saveArrivalNotice.htm")
    Observable<RootResult<HomeWineListResult>> saveArrivalNotice(
            @Query("productId") String productId
    );

    @GET("product/getCouponList.htm")
    Observable<RootResult<HomeWineListResult>> getCouponList(
            @Query("pageSize") String pageSize,
            @Query("pageNum") String pageNum,
            @Query("productId") String productId
    );

    @GET("product/proDetail.htm")
    Observable<RootResult<ProductDetailResult>> proDetail(
            @QueryMap Map<String, String> paramMap);

    @GET("promo/promoMain.htm")
    Observable<RootResult<HomeWineListResult>> promoMain(
            @Query("promoId") String promoId,
            @Query("pager") String pager
    );

    @GET("promo/promoSlave.htm")
    Observable<RootResult<HomeWineListResult>> promoSlave(
            @Query("skuId") String skuId,
            @Query("pager") String pager,
            @Query("promoId") String promoId
    );

    @GET("promotion/getPromotionById.htm")
    Observable<RootResult<HomeWineListResult>> getPromotionById(
            @Query("promotionId") String promotionId,
            @Query("pageNum") String pageNum,
            @Query("pageSize") String pageSize
    );

    @GET("promotion/getPromotionByIdRnt.htm")
    Observable<RootResult<HomeWineListResult>> getPromotionByIdRnt(
            @Query("promotionId") String promotionId,
            @Query("pageNum") String pageNum,
            @Query("pageSize") String pageSize
    );

    @GET("promotion/getPromotionByIdSKUJJG.htm")
    Observable<RootResult<HomeWineListResult>> getPromotionByIdSKUJJG(
            @Query("promotionId") String promotionId,
            @Query("pageNum") String pageNum,
            @Query("pageSize") String pageSize
    );

    @GET("memberChannel/exchange.htm")
    Observable<RootResult<HomeWineListResult>> exchange(
            @Query("gId") String gId,
            @Query("exchangeNum") String exchangeNum,
            @Query("requireNubs") String requireNubs
    );

    @GET("promo/youPick.htm")
    Observable<RootResult<HomeWineListResult>> youPick(
            @Query("skuId") String skuId,
            @Query("pager") String pager
    );

    @FormUrlEncoded
    @POST("user/registPreVerify.htm")
    Observable<RootResult<HomeWineListResult>> registPreVerify(
            @Field("mobile") String mobile,
            @Field("verifyCode") String verifyCode
    );

    @FormUrlEncoded
    @POST("user/regist.htm")
    Observable<RootResult<HomeWineListResult>> regist(
            @Field("mobile") String mobile,
            @Field("verifyCode") String verifyCode,
            @Field("passWord") String passWord,
            @Field("blackBox") String blackBox,
            @Field("retUrl") String retUrl
    );

    @FormUrlEncoded
    @POST("user/setupPaymentPwd.htm")
    Observable<RootResult<HomeWineListResult>> setupPaymentPwd(
            @Field("password") String password,
            @Field("confirmPassword") String confirmPassword
    );

    @FormUrlEncoded
    @POST("user/setupPwd.htm")
    Observable<RootResult<HomeWineListResult>> setupPwd(
            @Field("newPassword") String password,
            @Field("confirmNewPassword") String confirmPassword
    );

    @FormUrlEncoded
    @POST("user/acc/newpassword.htm")
    Observable<RootResult<HomeWineListResult>> newpassword(
            @Field("mobile") String mobile,
            @Field("retUrl") String retUrl,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user/validateMobileQuickLogin.htm")
    Observable<RootResult<HomeWineListResult>> validateMobileQuickLogin(
            @Field("verifyCode") String verifyCode
    );

    @FormUrlEncoded
    @POST("miaoshaApp.htm")
    Observable<RootResult<HomeWineListResult>> miaoshaApp(
            @Field("productId") String productId,
            @Field("promoId") String promoId
    );

    @FormUrlEncoded
    @POST("comment/addComment.htm")
    Observable<RootResult<HomeWineListResult>> addComment(
            @Field("type") String type,
            @Field("productId") String productId,
            @Field("orderItemId") String orderItemId,
            @Field("orderId") String orderId,
            @Field("commentScore") String commentScore,
            @Field("packageScore") String packageScore,
            @Field("deliverySpeedScore") String deliverySpeedScore,
            @Field("serviceAttitudeScore") String serviceAttitudeScore,
            @Field("content") String content,
            @Field("anonymity") String anonymity,
            @Field("imgUrls") String imgUrls,
            @Field("labels") String labels,
            @Field("retUrl") String retUrl
    );

    @GET("activity/getActivity.htm")
    Observable<RootResult<HomeWineListResult>> getActivity(
            @Query("type") String type
    );

    @GET("address/setCacheAddress.htm")
    Observable<RootResult<HomeWineListResult>> setCacheAddress(
            @Query("addrId") String addrId,
            @Query("areaId") String areaId
    );

    @GET("miaopaipush/setpush.htm")
    Observable<RootResult<HomeWineListResult>> setpush(
            @Query("actId") String actId,
            @Query("bizId") String bizId,
            @Query("bizName") String bizName,
            @Query("pushTime") String pushTime
    );

    @GET("user/loginUnion.htm")
    Observable<RootResult<HomeWineListResult>> loginUnion(
            @Query("openId") String openId,
            @Query("referer") String referer,
            @Query("authCode") String authCode,
            @Query("accessToken") String accessToken
    );

    @GET("act/pickSearchCoupon.htm")
    Observable<RootResult<HomeWineListResult>> pickSearchCoupon(
            @Query("keyword") String keyword,
            @Query("relationId") String relationId,
            @Query("couponActId") String couponActId
    );

    @GET("act/showSearchCoupon.htm")
    Observable<RootResult<HomeWineListResult>> showSearchCoupon(
            @Query("keyword") String keyword
    );

    @GET("shop/getShopBoxHotWords.htm")
    Observable<RootResult<HomeWineListResult>> getShopBoxHotWords(
            @Query("shopType") String shopType
    );

    @GET("shop/getShopPageInfo.htm")
    Observable<RootResult<HomeWineListResult>> getShopPageInfo(
            @Query("shopType") String shopType
    );

    @GET("shop/getRecommendedLabel.htm")
    Observable<RootResult<HomeWineListResult>> getRecommendedLabel(
            @Query("shopType") String shopType
    );

    @GET("shop/getWineHouseNavigation.htm")
    Observable<RootResult<HomeWineListResult>> getWineHouseNavigation(
            @Query("shopType") String shopType
    );

    @GET("miaopaipush/cancelpush.htm")
    Observable<RootResult<HomeWineListResult>> cancelpush(
            @Query("actId") String actId,
            @Query("bizId") String bizId,
            @Query("bizName") String bizName,
            @Query("pushTime") String pushTime
    );

    @GET("miaopaipush/getpushlist.htm")
    Observable<RootResult<HomeWineListResult>> getpushlist(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize
    );

    @GET("user/getAccountDetailList.htm")
    Observable<RootResult<HomeWineListResult>> getAccountDetailList(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize,
            @Query("type") String type
    );

    @GET("community/getAlcoholFriendsCircleDetailFlowByShopType.htm")
    Observable<RootResult<HomeWineListResult>> getAlcoholFriendsCircleDetailFlowByShopType(
            @Query("pageIndex") String pageIndex,
            @Query("pageSize") String pageSize,
            @Query("shopType") String shopType
    );

    @GET("coupon/receiveCoupon.htm")
    Observable<RootResult<HomeWineListResult>> receiveCoupon(
            @Query("couponId") String couponId,
            @Query("actId") String actId,
            @Query("stateAfterReceive") String stateAfterReceive,
            @Query("blackBox") String blackBox
    );

    @GET("collection/addCollection.htm")
    Observable<RootResult<HomeWineListResult>> addCollection(
            @Query("proIds") String proIds,
            @Query("source") String source,
            @Query("skuIds") String skuIds
    );

    @GET("address/addOrUpdateAddr.htm")
    Observable<RootResult<HomeWineListResult>> addOrUpdateAddr(
            @Query("addrId") String addrId,
            @Query("consignee") String consignee,
            @Query("mobile") String mobile,
            @Query("phone") String phone,
            @Query("provinceId") String provinceId,
            @Query("cityId") String cityId,
            @Query("districtId") String districtId,
            @Query("addressMore") String addressMore,
            @Query("isMain") String isMain
    );

    @GET("user/uploadHeadPortrait.htm")
    Observable<RootResult<HomeWineListResult>> uploadHeadPortrait(
            @Query("path") String path
    );

    @GET("address/delAddr.htm")
    Observable<RootResult<HomeWineListResult>> delAddr(
            @Query("addrId") String addrId
    );

    @GET("im/getGroupInfo.htm")
    Observable<RootResult<HomeWineListResult>> getGroupInfo(
            @Query("groupId") String groupId
    );

    @GET("im/getSign.htm")
    Observable<RootResult<HomeWineListResult>> getSign(
            @Query("identifier") String identifier
    );

    @GET("shop/getAdvImageByType.htm")
    Observable<RootResult<HomeWineListResult>> getAdvImageByType(
            @Query("type") String type
    );

    @GET("address/getAddressList.htm")
    Observable<RootResult<HomeWineListResult>> getAddressList();

    @GET("product/regionList.htm")
    Observable<RootResult<HomeWineListResult>> regionList();

    @GET("memberChannel/memberInfo.htm")
    Observable<RootResult<HomeWineListResult>> memberInfo();

    @GET("user/getAccountInfo.htm")
    Observable<RootResult<HomeWineListResult>> getAccountInfo();

    @GET("user/myWinebibber.htm")
    Observable<RootResult<HomeWineListResult>> myWinebibber();

    @GET("user/getUserInfo.htm")
    Observable<RootResult<HomeWineListResult>> getUserInfo();

    @GET("orderset/lookupPasswdErrTimes.htm")
    Observable<RootResult<HomeWineListResult>> lookupPasswdErrTimes();

    @GET("infomation/list.htm")
    Observable<RootResult<HomeWineListResult>> infomation();

    @GET("memberChannel/userSign.htm")
    Observable<RootResult<HomeWineListResult>> userSign();

    @FormUrlEncoded
    @POST("orderset/settlement.htm")
    Observable<RootResult<HomeWineListResult>> settlement(
            @Field("orderSetInfo") String orderSetInfo
    );

    @FormUrlEncoded
    @POST("user/loginUserNamePassWd.htm")
    Observable<RootResult<HomeWineListResult>> loginUserNamePassWd(
            @Field("userName") String userName,
            @Field("passWord") String passWord,
            @Field("blackBox") String blackBox
    );

    @FormUrlEncoded
    @POST("im/report.htm")
    Observable<RootResult<HomeWineListResult>> report(
            @Field("groupId") String groupId,
            @Field("msgId") String msgId,
            @Field("msgContent") String msgContent,
            @Field("msgTime") String msgTime,
            @Field("msgAccount") String msgAccount,
            @Field("reportType") String reportType,
            @Field("msgType") String msgType,
            @Field("locator") String locator
    );

    @GET("feedBack/tips.htm")
    Observable<RootResult<HomeWineListResult>> feedBackTips();

    @GET("cart/exchangeProduct.htm")
    Observable<RootResult<HomeWineListResult>> exchangeProduct(
            @Query("exchangeCode") String exchangeCode,
            @Query("verifyCode") String verifyCode,
            @Query("blackBox") String blackBox
    );

    @FormUrlEncoded
    @POST("user/loginMobileFast.htm")
    Observable<RootResult<HomeWineListResult>> loginMobileFast(
            @Field("mobile") String mobile,
            @Field("verifyCode") String verifyCode,
            @Field("blackBox") String blackBox,
            @Field("retUrl") String retUrl
    );

    @FormUrlEncoded
    @POST("user/backPassWord.htm")
    Observable<RootResult<HomeWineListResult>> backPassWord(
            @Field("mobile") String mobile,
            @Field("verifyCode") String verifyCode
    );

    @FormUrlEncoded
    @POST("user/resetPassWord.htm")
    Observable<RootResult<HomeWineListResult>> resetPassWord(
            @Field("mobile") String mobile,
            @Field("verifyCode") String verifyCode,
            @Field("newPassWord") String newPassWord
    );

    @FormUrlEncoded
    @POST("orderset/couponList.htm")
    Observable<RootResult<HomeWineListResult>> couponList(
            @Field("useCouponIds") String useCouponIds,
            @Field("couponId") String couponId,
            @Field("isCheck") String isCheck
    );

    @GET("memberChannel/exchangeRecord.htm")
    Observable<RootResult<HomeWineListResult>> exchangeRecord(
            @Query("pageNum") String pageNum
    );

    @GET("product/getProductBrowseHistory.htm")
    Observable<RootResult<HomeWineListResult>> getProductBrowseHistory(
            @Query("productIds") String productIds
    );

    @GET("act/getActivityAndPriceByProIds.htm")
    Observable<RootResult<HomeWineListResult>> getActivityAndPriceByProIds(
            @Query("proIds") String proIds
    );

    @GET("community/getFansList.htm")
    Observable<RootResult<HomeWineListResult>> getFansList(
            @Query("pageIndex") String userName,
            @Query("pageSize") String passWord,
            @Query("queryForUid") String queryForUid
    );

    @GET("community/getAttentionList.htm")
    Observable<RootResult<HomeWineListResult>> getAttentionList(
            @Query("pageIndex") String userName,
            @Query("pageSize") String passWord,
            @Query("queryForUid") String queryForUid
    );

    @GET("community/getNewInformationFlow.htm")
    Observable<RootResult<HomeWineListResult>> getNewInformationFlow(
            @Query("pageIndex") String userName,
            @Query("pageSize") String passWord
    );

    @GET("community/removeFans.htm")
    Observable<RootResult<HomeWineListResult>> removeFans(
            @Query("fansUid") String fansUid
    );

    @GET("messages/mobileCode.htm")
    Observable<RootResult<HomeWineListResult>> mobileCode(
            @Query("mobile") String mobile,
            @Query("type") String type,
            @Query("token") String token,
            @Query("code") String code
    );

    @GET("coupon/getMoreCouponlist.htm")
    Observable<RootResult<HomeWineListResult>> getMoreCouponlist(
            @Query("pageIndex") String userName,
            @Query("pageSize") String passWord,
            @Query("tabType") String tabType,
            @Query("actId") String actId
    );

    @GET("user/verify/mobile.htm")
    Observable<RootResult<HomeWineListResult>> getVerifyCode(
            @Query("mobile") String mobile,
            @Query("code") String code
    );

    @GET("search/searchProduct.htm")
    Observable<RootResult<ProductListInfoResult>> searchProduct(@QueryMap Map<String, String> paramMap);

    @GET("community/getUserIdByName.htm")
    Observable<RootResult<HomeWineListResult>> getUserIdByName(
            @Query("userName") String userName
    );

    @GET("messages/graphCode.htm")
    Observable<RootResult<HomeWineListResult>> graphCode(
            @Query("mobile") String mobile,
            @Query("type") String type,
            @Query("token") String token
    );

    @GET("user/loginUserScanCancel.htm")
    Observable<RootResult<HomeWineListResult>> loginUserScanCancel(
            @Query("code") String code
    );

    @GET("user/loginUserScanConfirm.htm")
    Observable<RootResult<HomeWineListResult>> loginUserScanConfirm(
            @Query("code") String code
    );

    @GET("user/loginUserScan.htm")
    Observable<RootResult<HomeWineListResult>> loginUserScan(
            @Query("code") String code
    );

    @GET("search/associateHistorySearch.htm")
    Observable<RootResult<HomeWineListResult>> associateHistorySearch(
            @Query("keyword") String keyword
    );

    @GET("miaomiao/getMiaoMiaoProductInfo.htm")
    Observable<RootResult<HomeWineListResult>> getMiaoMiaoProductInfo(
            @Query("productId") String productId
    );

    @GET("user/bindingMobile.htm")
    Observable<RootResult<HomeWineListResult>> bindingMobile(
            @Query("mobile") String mobile,
            @Query("verifyCode") String verifyCode,
            @Query("token") String token
    );

    @GET("richscan/getProductID.htm")
    Observable<RootResult<HomeWineListResult>> getProductID(
            @Query("barCode") String barCode
    );

    @GET("im/applyGroup.htm")
    Observable<RootResult<HomeWineListResult>> applyGroup();

    @GET("user/alipayLoginSign.htm")
    Observable<RootResult<HomeWineListResult>> alipayLoginSign();

    @GET("duiba/referURL.htm")
    Observable<RootResult<HomeWineListResult>> referURL();

    @GET("user/getAccountSecurity.htm")
    Observable<RootResult<HomeWineListResult>> getAccountSecurity();

    @GET("im/getUnreadMsgNum.htm")
    Observable<RootResult<HomeWineListResult>> getUnreadMsgNum();

    @GET("address/getCacheAddress.htm")
    Observable<RootResult<HomeWineListResult>> getCacheAddress();

    @GET("product/authenticityTajbleInfo.htm")
    Observable<RootResult<HomeWineListResult>> authenticityTajbleInfo();

    @GET("product/scanTabList.htm")
    Observable<RootResult<HomeWineListResult>> scanTabList();

    @GET("cart/unreceived/exchangeProduct.htm")
    Observable<RootResult<HomeWineListResult>> exchangeProduct();

    @GET("product/showProductExchangeIntroduct.htm")
    Observable<RootResult<HomeWineListResult>> showProductExchangeIntroduct();

    @GET("comment/getHomeData.htm")
    Observable<RootResult<HomeWineListResult>> getHomeData();

    @FormUrlEncoded
    @POST("user/setupPaymentPwdValidate.htm")
    Observable<RootResult<HomeWineListResult>> setupPaymentPwdValidate(
            @Field("verifyCode") String verifyCode
    );

    @FormUrlEncoded
    @POST("user/validateOrignalPwd.htm")
    Observable<RootResult<HomeWineListResult>> validateOrignalPwd(
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("shoppingcart/updateCheck.htm")
    Observable<RootResult<HomeWineListResult>> cartUpdateCheck(
            @Field("skuId") String skuId,
            @Field("checked") String checked
    );

    @GET("shoppingcart/get.htm")
    Observable<RootResult<HomeWineListResult>> cartGet();

    @GET("product/categoryDetail.htm")
    Observable<RootResult<CatePageResult>> getCategoryDetail(
            @QueryMap Map<String, String> paramMap);

    @FormUrlEncoded
    @POST("user/loginUserNamePassWd.htm")
    Observable<RootResult<LoginInfoResult>> passwordLogin(
            @FieldMap Map<String, String> paramMap);

    @FormUrlEncoded
    @POST("user/getModuleData.htm")
    Observable<RootResult<UserCenterModuleData>> getModuleData(@FieldMap Map<String, String> paramMap);

    @FormUrlEncoded
    @POST("clubUser/getClubUserProduct.htm")
    Observable<RootResult<ClubUserProduct>> getClubUserProduct(
            @FieldMap Map<String, String> paramMap);

    @FormUrlEncoded
    @POST("user/getExchangeCodeRcommendProduct.htm")
    Observable<RootResult<ClubUserProduct>> getExchangeCodeRcommendProduct(
            @Field("pageIndex") String userName,
            @Field("pageSize") String passWord);

    @GET("user/myWinebibber.htm")
    Observable<RootResult<UserCenterResult>> getWinebibber(@QueryMap Map<String, String> paramMap);


}
