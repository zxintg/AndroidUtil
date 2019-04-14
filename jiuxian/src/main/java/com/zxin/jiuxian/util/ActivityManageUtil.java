package com.zxin.jiuxian.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.alibaba.fastjson.JSONArray;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.activity.AccountSafeActivity;
import com.zxin.jiuxian.activity.ActiveAddPriceActivity;
import com.zxin.jiuxian.activity.ActiveLetYouChooseActivity;
import com.zxin.jiuxian.activity.ActiveManActivity;
import com.zxin.jiuxian.activity.ActivePackSuitActivity;
import com.zxin.jiuxian.activity.ActiveSingleAddPriceActivity;
import com.zxin.jiuxian.activity.AddCommentActivity;
import com.zxin.jiuxian.activity.AddCommentListActivity;
import com.zxin.jiuxian.activity.AddressManagerActivity;
import com.zxin.jiuxian.activity.AppendCommentActivity;
import com.zxin.jiuxian.activity.AuthByQRCodeActivity;
import com.zxin.jiuxian.activity.BaiKeCountryActivity;
import com.zxin.jiuxian.activity.BaiKeWineTypeActivity;
import com.zxin.jiuxian.activity.BindPhoneCheckActivity;
import com.zxin.jiuxian.activity.BrowserCommendInterPicActivity;
import com.zxin.jiuxian.activity.BrowserInterPicActivity;
import com.zxin.jiuxian.activity.CartActivity;
import com.zxin.jiuxian.activity.ChatRoomActivity;
import com.zxin.jiuxian.activity.CollectActivity;
import com.zxin.jiuxian.activity.CommentCenterActivity;
import com.zxin.jiuxian.activity.CommentDetailActivity;
import com.zxin.jiuxian.activity.CommentGuideActivity;
import com.zxin.jiuxian.activity.CommentListActivity;
import com.zxin.jiuxian.activity.CommentSuccessfulActivity;
import com.zxin.jiuxian.activity.CommodityExchangeActivity;
import com.zxin.jiuxian.activity.CommunityCircleDetailActivity;
import com.zxin.jiuxian.activity.CommunityContentDetailActivity;
import com.zxin.jiuxian.activity.CommunityCreateTopicActivity;
import com.zxin.jiuxian.activity.CommunityMessageActivity;
import com.zxin.jiuxian.activity.CommunityPersonCenterActivity;
import com.zxin.jiuxian.activity.CommunityPersonCenterTopicListActivity;
import com.zxin.jiuxian.activity.CommunityPhotoSelectorActivity;
import com.zxin.jiuxian.activity.CommunityPromotionDetailActivity;
import com.zxin.jiuxian.activity.CommunitySearchActivity;
import com.zxin.jiuxian.activity.ConfigTestActivity;
import com.zxin.jiuxian.activity.CreditActivity;
import com.zxin.jiuxian.activity.ExchangeDetailActivity;
import com.zxin.jiuxian.activity.ExchangeRecordActivity;
import com.zxin.jiuxian.activity.FootPrintActivity;
import com.zxin.jiuxian.activity.GlobalAlertActivity;
import com.zxin.jiuxian.activity.GuideActivity;
import com.zxin.jiuxian.activity.JiuXianWebActivity;
import com.zxin.jiuxian.activity.LogisticsActivity;
import com.zxin.jiuxian.activity.MainActivity;
import com.zxin.jiuxian.activity.MemberChannelActivity;
import com.zxin.jiuxian.activity.MessageSettingActivity;
import com.zxin.jiuxian.activity.MiaoChateauActivity;
import com.zxin.jiuxian.activity.MiaoProductingAreaActivity;
import com.zxin.jiuxian.activity.NewAddressActivity;
import com.zxin.jiuxian.activity.OrderCommitActivity;
import com.zxin.jiuxian.activity.OrderDetailActivity;
import com.zxin.jiuxian.activity.OrderListTabActivity;
import com.zxin.jiuxian.activity.OrderLookInviceActivity;
import com.zxin.jiuxian.activity.PaymentCenterActivity;
import com.zxin.jiuxian.activity.PaymentFailActivity;
import com.zxin.jiuxian.activity.PaymentSuccessfulActivity;
import com.zxin.jiuxian.activity.PaymentSuccessfulForWapActivity;
import com.zxin.jiuxian.activity.PhoneVipActivity;
import com.zxin.jiuxian.activity.PhotoSelectorActivity;
import com.zxin.jiuxian.activity.ProductDetailActivity;
import com.zxin.jiuxian.activity.ProductListActivity;
import com.zxin.jiuxian.activity.PromotionPresentActivity;
import com.zxin.jiuxian.activity.PromotionRenNiTiaoActivity;
import com.zxin.jiuxian.activity.RegisterActivity;
import com.zxin.jiuxian.activity.RegisterFindPWNextActivity;
import com.zxin.jiuxian.activity.SearchOrderListActivity;
import com.zxin.jiuxian.activity.SeckillActivity;
import com.zxin.jiuxian.activity.SeckillNoticeActivity;
import com.zxin.jiuxian.activity.SeckillRecommendActivity;
import com.zxin.jiuxian.activity.TextActivity;
import com.zxin.jiuxian.activity.ThirdSquareBindingActivity;
import com.zxin.jiuxian.activity.UserAddCouponActivity;
import com.zxin.jiuxian.activity.UserMoreCouponActivity;
import com.zxin.jiuxian.activity.WebSecKillingActivity;
import com.zxin.jiuxian.activity.WelcomeActivity;
import com.zxin.jiuxian.activity.WineActiveActivity;
import com.zxin.jiuxian.activity.WineActiveSearchActivity;
import com.zxin.jiuxian.bean.AddressListResultInfo;
import com.zxin.jiuxian.bean.CartResult;
import com.zxin.jiuxian.bean.CatePageResult;
import com.zxin.jiuxian.bean.CommentSuccessfulResult;
import com.zxin.jiuxian.bean.CommunityCircleInfoResult;
import com.zxin.jiuxian.bean.ConditionWeb;
import com.zxin.jiuxian.bean.Image;
import com.zxin.jiuxian.bean.JiuZhangSource;
import com.zxin.jiuxian.bean.ReEditMixData;
import com.zxin.jiuxian.bean.SeckillProduct;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.UiUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/8/13.
 */

public class ActivityManageUtil {

    public static void goToAddManager() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AddressManagerActivity.class);
        intent.putExtra("choiceAddress", false);
        activity.startActivity(intent);
    }

    public static void goToAddManager(int addressId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AddressManagerActivity.class);
        intent.putExtra("choiceAddress", true);
        intent.putExtra("addressId", addressId);
        activity.startActivity(intent);
    }

    public static void goToAppendComment(int orderId, int productId, int commentId, int orderItemId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AppendCommentActivity.class);
        intent.putExtra("commentId", commentId);
        intent.putExtra("orderId", orderId);
        intent.putExtra("productId", productId);
        intent.putExtra("orderItemId", orderItemId);
        activity.startActivity(intent);
    }

    public static void goToCommunityCreateTopic(int aid, int fid, String circleName, String title, JSONArray content, ArrayList<String> illegallyList, ArrayList<String> sensitivityList) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityCreateTopicActivity.class);
        intent.putExtra("aid", aid);
        intent.putExtra("fid", fid);
        intent.putExtra("circleName", circleName);
        intent.putExtra("title", title);
        intent.putExtra("content", content.toString());
        intent.putExtra("illegallyList", illegallyList);
        intent.putExtra("sensitivityList", sensitivityList);
        activity.startActivity(intent);
    }

    public static void goToRegister(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, RegisterActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToCommunityCreateTopic(CommunityCircleInfoResult infoResult) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityCreateTopicActivity.class);
        if (infoResult != null) {
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("circleInfo", infoResult);
            intent.putExtras(localBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToCommunityCreateTopic(CommunityCircleInfoResult infoResult, ReEditMixData mixedData, boolean reEdit, int tid) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityCreateTopicActivity.class);
        if (infoResult != null) {
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("circleInfo", infoResult);
            localBundle.putSerializable("mixedData", mixedData);
            localBundle.putBoolean("reEdit", reEdit);
            localBundle.putInt("tid", tid);
            intent.putExtras(localBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToWineActiveSearch(int shopType, WineActiveSearchActivity.SearchSourceInfo sourceInfo, String shopName) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, WineActiveSearchActivity.class);
        intent.putExtra("shopType", shopType);
        intent.putExtra("sourceInfo", sourceInfo);
        intent.putExtra("shopName", shopName);
        activity.startActivity(intent);
    }

    public static void goToSeckill(int productId, JiuZhangSource jiuZhangSource) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, SeckillActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("jiuZhangSource", jiuZhangSource);
        activity.startActivity(intent);
    }

    public static void goToAddCommentList(int orderId, String orderSN) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AddCommentListActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderSN", orderSN);
        activity.startActivity(intent);
    }

    public static void goToAddComment(int orderId, String orderSN, int productId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AddCommentActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderSN", orderSN);
        activity.startActivity(intent);
    }

    public static void goToAddComment(int orderId, String orderSN, int productId, int orderItemId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AddCommentActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderItemId", orderItemId);
        activity.startActivity(intent);
    }

    public static void goToBrowserInterPic(int num, ArrayList<String> picurls) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, BrowserInterPicActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putInt("defimage_id", R.drawable.icon_jiuxian_default);
        localBundle.putInt("num", num);
        localBundle.putStringArrayList("picurls", picurls);
        intent.putExtras(localBundle);
        activity.startActivity(intent);
    }

    public static void goToCommunityContentDetail(int mTid, boolean scrollToBottom) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityContentDetailActivity.class);
        intent.putExtra("mTid", mTid);
        intent.putExtra("scrollToBottom", scrollToBottom);
        activity.startActivity(intent);
    }

    public static void goToOrderLookInvice(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, OrderLookInviceActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToNewAddress(AddressListResultInfo.AddrListItem addrListItem, boolean choiceAddress) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, NewAddressActivity.class);
        intent.putExtra("title", UiUtils.getString(R.string.edit_receive_address));
        intent.putExtra("isEdit", true);
        intent.putExtra("addrListItem", addrListItem);
        intent.putExtra("choiceAddress", choiceAddress);
        activity.startActivity(intent);
    }

    public static void goToCommentSuccessful(CommentSuccessfulResult data) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommentSuccessfulActivity.class);
        intent.putExtra("data", data);
        activity.startActivity(intent);
    }

    public static void goToSeckillRecommend(SeckillProduct seckillProduct) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, SeckillRecommendActivity.class);
        intent.putExtra("seckillProduct", seckillProduct);
        activity.startActivity(intent);
    }

    public static void goToOrderDetail(String orderSn, int orderId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, OrderDetailActivity.class);
        intent.putExtra("orderSn", orderSn);
        intent.putExtra("orderId", orderId);
        activity.startActivity(intent);
    }

    public static void goToPaymentCenter(String orderSN, int orderId, double payPrice, ArrayList<JiuZhangSource> jiuZhangSource) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentCenterActivity.class);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderId", orderId);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("paySource", PaymentCenterActivity.PAY_SOURCE.NORMAL);
        intent.putExtra("jiuZhangSource", jiuZhangSource);
        activity.startActivity(intent);
    }

    public static void goToPaymentCenter(String orderSN, int orderId, double payPrice, ArrayList<JiuZhangSource> jiuZhangSource, boolean rePay, String isFrom) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentCenterActivity.class);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderId", orderId);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("paySource", PaymentCenterActivity.PAY_SOURCE.NORMAL);
        intent.putExtra("jiuZhangSource", jiuZhangSource);
        intent.putExtra("rePay", rePay);
        intent.putExtra("isFrom", isFrom);
        activity.startActivity(intent);
    }

    public static void goToOrderDetail(String orderSn, int orderId, int orderItemId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, OrderDetailActivity.class);
        intent.putExtra("orderSn", orderSn);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderItemId", orderItemId);
        activity.startActivity(intent);
    }

    public static void goToOrderDetail(String userId, String orderSn) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, OrderDetailActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("orderSn", orderSn);
        activity.startActivity(intent);
    }

    public static void goToRegisterFindPWNext(String mPhoneNum, String mSecurityCode, String type) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, RegisterFindPWNextActivity.class);
        intent.putExtra("mPhoneNum", mPhoneNum);
        intent.putExtra("mSecurityCode", mSecurityCode);
        intent.putExtra("type", type);
        activity.startActivity(intent);
    }

    public static void goToThirdSquare(String userName, String userUrl, boolean isNewUser, String openId, String referer, String userNameOrEmail, int bindType) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ThirdSquareBindingActivity.class);
        intent.putExtra("userName", userName);
        intent.putExtra("userUrl", userUrl);
        intent.putExtra("isNewUser", isNewUser);
        intent.putExtra("openId", openId);
        intent.putExtra("referer", referer);
        intent.putExtra("userNameOrEmail", userNameOrEmail);
        intent.putExtra("bindType", bindType);
        activity.startActivity(intent);
    }

    public static void goToWebView(String url, String title, boolean noTitle, boolean noHandUrl, boolean showShareBtn, Bundle bundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity,JiuXianWebActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        intent.putExtra("noTitle", noTitle);
        intent.putExtra("noHandUrl", noHandUrl);
        intent.putExtra("showShareBtn", showShareBtn);
        activity.startActivity(intent);
    }

    public static void goToPhoneCheck(String tip, boolean isSeckill) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, BindPhoneCheckActivity.class);
        intent.putExtra("tip", tip);
        intent.putExtra("isSeckill", isSeckill);
        activity.startActivity(intent);
    }

    public static void goToPhotoSelector(ArrayList<Image> images, int count) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PhotoSelectorActivity.class);
        intent.putExtra("count", count);
        intent.putExtra("images", images);
        activity.startActivity(intent);
    }

    public static void goToNewAddress(boolean choiceAddress) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, NewAddressActivity.class);
        intent.putExtra("title", UiUtils.getString(R.string.add_receive_address));
        intent.putExtra("isEdit", false);
        intent.putExtra("choiceAddress", choiceAddress);
        activity.startActivity(intent);
    }

    public static void goToCommentCenter() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommentCenterActivity.class);
        intent.setFlags(67108864);
        activity.startActivity(intent);
    }

    public static void goToPackSuit(int promotionId, int productId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ActivePackSuitActivity.class);
        intent.putExtra("promotionId", promotionId);
        intent.putExtra("productId", productId);
        activity.startActivity(intent);
    }

    public static void goToBrowserCommend(int productId, int commentId, int pictureId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, BrowserCommendInterPicActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("commentId", commentId);
        intent.putExtra("pictureId", pictureId);
        activity.startActivity(intent);
    }

    public static void goToProductList(int categoryId, int paramInt2) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent  = new Intent(activity, ProductListActivity.class);
        intent.putExtra("from", 4);
        intent.putExtra("isTopTopic", false);
        intent.putExtra("categoryId", categoryId);
        StringBuilder builder = new StringBuilder();
        builder.append("1:");
        builder.append(paramInt2);
        intent.putExtra("cateAttrId", builder.toString());
        activity.startActivity(intent);
    }

    public static void goToCommunityContentDetail(int mTid, int pid, boolean scrollToBottom, boolean link) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityContentDetailActivity.class);
        intent.putExtra("mTid", mTid);
        intent.putExtra("pid", pid);
        intent.putExtra("scrollToBottom", scrollToBottom);
        intent.putExtra("FROM_MLINK", link);
        activity.startActivity(intent);
    }

    public static void goToOrderListTab(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, OrderListTabActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToProductDetail(int productId, Bundle paramBundle, String name, String imageUrl) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ProductDetailActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        intent.putExtra("productId", productId);
        intent.putExtra("name", name);
        intent.putExtra("imageUrl", imageUrl);
        activity.startActivity(intent);
    }

    public static void goToProductList(String categoryId, CatePageResult.CateListItem cateList) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ProductListActivity.class);
        intent.putExtra("from", 1);
        intent.putExtra("isTopTopic", false);
        intent.putExtra("categoryId", categoryId);
        if (cateList != null) {
            intent.putExtra("cateListItem", cateList);
            if (4 == cateList.mParentId) {
                if (cateList.name.contains("-")) {
                    String[] name = cateList.name.split("-");
                    intent.putExtra("startPrice", name[0]);
                    intent.putExtra("endPrice", name[1]);
                } else {
                    intent.putExtra("startPrice", cateList.name);
                }
            } else {
                StringBuffer buffer = new StringBuffer();
                buffer.append(cateList.mParentId);
                buffer.append(":");
                buffer.append(cateList.id);
                intent.putExtra("cateAttrId", buffer.toString());
            }
            if (1 == cateList.id) {
                intent.putExtra("brand", cateList.name);
            }
        }
        activity.startActivity(intent);
    }

    public static void goToLogistics(int orderId, String orderSN) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, LogisticsActivity.class);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderId", orderId);
        activity.startActivity(intent);
    }

    public static void goToPromotionDetail(int id, boolean line) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityPromotionDetailActivity.class);
        intent.putExtra("PROMOTION_ID", id);
        intent.putExtra("FROM_MLINK", line);
        activity.startActivity(intent);
    }

    public static void goToCommunityContentDetail(int mTid, boolean scrollToBottom, boolean link) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityContentDetailActivity.class);
        intent.putExtra("mTid", mTid);
        intent.putExtra("scrollToBottom", scrollToBottom);
        intent.putExtra("FROM_MLINK", link);
        activity.startActivity(intent);
    }

    public static void goToService(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(270532608);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToOrderCommit(CartResult data, int isBuy, ArrayList<JiuZhangSource> jiuZhangSources, String isFrom, String giftIds) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, OrderCommitActivity.class);
        intent.putExtra("data", data);
        intent.putExtra("isBuy", isBuy);
        intent.putExtra("isFrom", isFrom);
        intent.putExtra("giftIds", giftIds);
        intent.putExtra("jiuZhangSources", jiuZhangSources);
        activity.startActivity(intent);
    }

    public static void goToCommunityCircleDetail(CommunityCircleInfoResult circleInfo) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityCircleDetailActivity.class);
        if (circleInfo != null) {
            Bundle localBundle = new Bundle();
            localBundle.putSerializable("circleInfo", circleInfo);
            intent.putExtras(localBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToProductList(ConditionWeb paramConditionWeb, Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ProductListActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        intent.putExtra("from", 3);
        intent.putExtra("isTopTopic", true);
        if (paramConditionWeb != null) {
            intent.putExtra("categoryId", paramConditionWeb.cat_id);
            intent.putExtra("keyword", paramConditionWeb.keyWord);
            StringBuffer bundle = new StringBuffer();
            if (paramConditionWeb.mIsNineOrTen) {
                if (paramConditionWeb.mIsNine) {
                    bundle.append(ConditionWeb.CateType.RICE_WIN_BRAND);
                    bundle.append(":");
                    bundle.append(paramConditionWeb.attr_lx_id);
                } else {
                    bundle.append(ConditionWeb.CateType.HEALTH_WINE_BRAND);
                    bundle.append(":");
                    bundle.append(paramConditionWeb.attr_lx_id);
                }
            } else {
                bundle.append(ConditionWeb.CateType.BRANDS);
                bundle.append(":");
                bundle.append(paramConditionWeb.brand_id);
                bundle.append(",");
                bundle.append(ConditionWeb.CateType.FLAVOR);
                bundle.append(":");
                bundle.append(paramConditionWeb.attr_xx_id);
                bundle.append(",");
                bundle.append(ConditionWeb.CateType.PRICE);
                bundle.append(":");
                bundle.append(paramConditionWeb.attr_price_id);
                bundle.append(",");
                bundle.append(ConditionWeb.CateType.TYPE);
                bundle.append(":");
                bundle.append(paramConditionWeb.attr_lx_id);
                bundle.append(",");
                bundle.append(ConditionWeb.CateType.VARIETISE);
                bundle.append(":");
                bundle.append(paramConditionWeb.attr_pz_id);
                bundle.append(",");
                bundle.append(ConditionWeb.CateType.COUNTRY);
                bundle.append(":");
                bundle.append(paramConditionWeb.country_id);
                bundle.append(",");
                bundle.append(ConditionWeb.CateType.THE_OCCASION);
                bundle.append(":");
                bundle.append(paramConditionWeb.ocasion_id);
            }
            intent.putExtra("cateAttrId", bundle.toString());
            bundle = new StringBuffer();
            bundle.append(paramConditionWeb.order_by);
            bundle.append(":");
            bundle.append(paramConditionWeb.sort);
            intent.putExtra("orderBy", paramBundle.toString());
        }
        activity.startActivity(intent);
    }

    public static void goToSearchOrderList(String orderName) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, SearchOrderListActivity.class);
        intent.putExtra("orderName", orderName);
        activity.startActivity(intent);
    }

    public static void goToPaymentFail(String orderSN, int orderId, double payPrice) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentFailActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("payPrice", payPrice);
        activity.startActivity(intent);
    }

    public static void goToPaymentSuccessfulForWap(String orderSN, int orderId, String isFrom, double payPrice, String payType) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentSuccessfulForWapActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("payType", payType);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("isFrom", isFrom);
        activity.startActivity(intent);
    }

    public static void goToPaymentSuccessful(String orderSN, int orderId, ArrayList<JiuZhangSource> jiuZhangSources, String isFrom, String payType, double payPrice, String pay_platform) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentSuccessfulActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("jiuZhangSources", jiuZhangSources);
        intent.putExtra("payType", payType);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("isFrom", isFrom);
        intent.putExtra("pay_platform", pay_platform);
        activity.startActivity(intent);
    }

    public static void goToProductList(String keyword, Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ProductListActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        intent.putExtra("from", 2);
        intent.putExtra("isTopTopic", false);
        intent.putExtra("keyword", keyword);
        activity.startActivity(intent);
    }

    public static void goToChatRoom(String identify, boolean isAlreadyMumber) {
            AppCompatActivity activity = AppManager.getAppManager().currentActivity();
            Intent intent = new Intent(activity, ChatRoomActivity.class);
            intent.addFlags(67108864);
            intent.putExtra("identify", identify);
            //intent.putExtra("type", TIMConversationType.Group);
            intent.putExtra("isAlreadyMumber", isAlreadyMumber);
            activity.startActivity(intent);
    }

    public static void goToCommunityPersonCenterTopicList(boolean isSelf, int uid, boolean isMyPublish) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityPersonCenterTopicListActivity.class);
        intent.putExtra("uid", uid);
        intent.putExtra("Self", isSelf);
        intent.putExtra("isMyPublish", isMyPublish);
        activity.startActivity(intent);
    }

    public static void goToPaymentCenter(String orderSN, int orderId, double payPrice) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentCenterActivity.class);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderId", orderId);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("paySource", PaymentCenterActivity.PAY_SOURCE.NORMAL);
        activity.startActivity(intent);
    }

    public static void goToPaymentCenter(PaymentCenterActivity.PAY_SOURCE paramPAY_SOURCE, String orderSN, int orderId, double payPrice) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentCenterActivity.class);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderId", orderId);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("paySource", paramPAY_SOURCE);
        activity.startActivity(intent);
    }

    public static void goToPaymentCenter(PaymentCenterActivity.PAY_SOURCE paramPAY_SOURCE, String orderSN, int orderId, double payPrice, String pintuanUrl) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PaymentCenterActivity.class);
        intent.putExtra("orderSN", orderSN);
        intent.putExtra("orderId", orderId);
        intent.putExtra("payPrice", payPrice);
        intent.putExtra("pintuanUrl", pintuanUrl);
        intent.putExtra("paySource", paramPAY_SOURCE);
        activity.startActivity(intent);
    }

    public static void goToGlobalAlert(String message) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, GlobalAlertActivity.class);
        intent.putExtra("message", message);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    public static void goToNewAddress() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, NewAddressActivity.class);
        intent.putExtra("title", UiUtils.getString(R.string.add_receive_address));
        intent.putExtra("isEdit", false);
        intent.putExtra("choiceAddress", true);
        activity.startActivity(intent);
    }

    public static void goToCommentList(int orderId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommentListActivity.class);
        intent.putExtra("orderId", orderId);
        activity.startActivity(intent);
    }

    public static void goToCredit(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CreditActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        intent.putExtra("navColor", "#f4f4f4");
        intent.putExtra("titleColor", "#252525");
        intent.putExtra("ismain", true);
        activity.startActivity(intent);
    }

    public static void goToMiaoChateau(String productId, String name) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, MiaoChateauActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("name", name);
        activity.startActivity(intent);
    }

    public static void goToCommunityPhotoSelector(ArrayList<Image> images, int count) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityPhotoSelectorActivity.class);
        intent.putExtra("count", count);
        intent.putExtra("images", images);
        activity.startActivity(intent);
    }

    public static void goToActiveLetYouChoose(int promotionId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ActiveLetYouChooseActivity.class);
        intent.putExtra("promotionId", promotionId);
        activity.startActivity(intent);
    }

    public static void goToUserMoreCoupon(int activeId, Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, UserMoreCouponActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        intent.putExtra("activeId", activeId);
        activity.startActivity(intent);
    }

    public static void goToWebSecKilling(int productId, String promoId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, WebSecKillingActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("promoId", promoId);
        activity.startActivity(intent);
    }

    public static void goToUserAddCoupon(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, UserAddCouponActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToCart() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, CartActivity.class));
    }

    public static void goToGuide() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, GuideActivity.class));
    }

    public static void goToPhoneVip(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PhoneVipActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToMiaoProductingArea(String productId, String name) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, MiaoProductingAreaActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("name", name);
        activity.startActivity(intent);
    }

    public static void goToMemberChannel() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, MemberChannelActivity.class));
    }

    public static void goToActiveMan(int promotionId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ActiveManActivity.class);
        intent.putExtra("promotionId", promotionId);
        activity.startActivity(intent);
    }

    public static void goToProductList(int categoryId, String paramString) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ProductListActivity.class);
        intent.putExtra("from", 1);
        intent.putExtra("isTopTopic", false);
        intent.putExtra("categoryId", categoryId);
        intent.putExtra("isall", true);
        if (!StringUtils.textIsEmpty(paramString) && categoryId == 6) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(paramString);
            buffer.append(":");
            buffer.append("0");
            intent.putExtra("cateAttrId", buffer.toString());
        }
        activity.startActivity(intent);
    }

    public static void goToFootPrint() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, FootPrintActivity.class));
    }

    public static void goToWelcome() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, WelcomeActivity.class));
    }

    public static void goToAuthByQRCode(String paramString) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, AuthByQRCodeActivity.class);
        intent.putExtra("data", paramString);
        activity.startActivity(intent);
    }

    public static void goToBaiKeCountry(String productId, String name) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, BaiKeCountryActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("name", name);
        activity.startActivity(intent);
    }

    public static void goToExchangeRecord() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, ExchangeRecordActivity.class));
    }

    public static void goToActiveAddPrice(int promotionId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ActiveAddPriceActivity.class);
        intent.putExtra("promotionId", promotionId);
        activity.startActivity(intent);
    }

    public static void goToSeckillNotice() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, SeckillNoticeActivity.class));
    }

    public static void goToBaiKeWineType(String productId, String name) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, BaiKeWineTypeActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("name", name);
        activity.startActivity(intent);
    }

    public static void goToCommodityExchange() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, CommodityExchangeActivity.class));
    }

    public static void goToActiveSingleAddPrice(int promotionId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ActiveSingleAddPriceActivity.class);
        intent.putExtra("promotionId", promotionId);
        activity.startActivity(intent);
    }

    public static void goToCollect(Bundle paramBundle) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CollectActivity.class);
        if (paramBundle != null) {
            intent.putExtras(paramBundle);
        }
        activity.startActivity(intent);
    }

    public static void goToMessageSetting() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, MessageSettingActivity.class));
    }

    public static void goToAccountSafe() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, AccountSafeActivity.class));
    }

    public static void goToPromotionRenNiTiao(String skuId, String promotionId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PromotionRenNiTiaoActivity.class);
        intent.putExtra("skuId", skuId);
        intent.putExtra("promotionId", promotionId);
        activity.startActivity(intent);
    }

    public static void goToCommunitySearch() {
            AppCompatActivity activity = AppManager.getAppManager().currentActivity();
            activity.startActivity(new Intent(activity, CommunitySearchActivity.class));
    }

    public static void goToCommunityCircleDetail(int fid) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityCircleDetailActivity.class);
        intent.putExtra("fid", fid);
        activity.startActivity(intent);
    }

    public static void goToCommunityMessage() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, CommunityMessageActivity.class));
    }

    public static void goToCommunityCreateTopic() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, CommunityCreateTopicActivity.class));
    }

    public static void goToExchangeDetail(int gid) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, ExchangeDetailActivity.class);
        intent.putExtra("gid", gid);
        activity.startActivity(intent);
    }

    public static void goToConfigTest() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, ConfigTestActivity.class));
    }

    public static void goToCommunityPersonCenter(int uid) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommunityPersonCenterActivity.class);
        intent.putExtra("uid", uid);
        String str = JiuXianSharedPreferences.key_uid();
        if (!StringUtils.textIsEmpty(str) && String.valueOf(uid).equals(str)) {
            intent.putExtra("Self", true);
        } else {
            intent.putExtra("Self", false);
        }
        activity.startActivity(intent);
    }

    public static void goToCommentDetail(int commentId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, CommentDetailActivity.class);
        intent.putExtra("commentId", commentId);
        activity.startActivity(intent);
    }

    public static void goToCommentGuide() {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(activity, CommentGuideActivity.class));
    }

    public static void goToWineActive(int shopType) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, WineActiveActivity.class);
        intent.putExtra("shopType", shopType);
        activity.startActivity(intent);
    }

    public static void goToPromotionPresent(int promoId) {
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        Intent intent = new Intent(activity, PromotionPresentActivity.class);
        intent.putExtra("promoId", promoId);
        activity.startActivity(intent);
    }
}
