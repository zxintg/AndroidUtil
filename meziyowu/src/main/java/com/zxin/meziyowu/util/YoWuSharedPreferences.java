package com.zxin.meziyowu.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.zxin.root.app.BaseApplication;
import com.zxin.root.util.BaseStringUtils;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.SystemInfoUtil;

/**
 * Created by Administrator on 2018/7/23.
 */

public class YoWuSharedPreferences extends SharedPreferencesManager {
    private static SharedPreferences sp;

    static {
        sp = BaseApplication.getInstance().getContext().getSharedPreferences(BaseStringUtils.YoWu_Datas, Context.MODE_PRIVATE);
    }

    /*****
     * 保存是否第一次使用
     * @param isEnter
     */
    public static void setIsFirstEnter(boolean isEnter) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isEnter", isEnter);
        editor.commit();
    }

    /****
     * 获取是否第一次装APP
     * @return
     */
    public static boolean getIsFirstEnter() {
        return sp.getBoolean("isEnter", true);
    }

    public static boolean comment_photo_guide() {
        return sp.getBoolean("comment_photo_guide", false);
    }

    public static boolean cart_promotion_hint_flag() {
        return sp.getBoolean("cart_promotion_hint_flag", true);
    }

    public static boolean order_promotion_hint_flag() {
        return sp.getBoolean("order_promotion_hint_flag", true);
    }

    public static boolean monitor_user_action() {
        return sp.getBoolean("monitor_user_action", false);
    }

    public static boolean key_start_crash() {
        return sp.getBoolean("key_start_crash", false);
    }

    public static boolean applink_handled_from_wap() {
        return sp.getBoolean("applink_handled_from_wap", false);
    }

    public static boolean community_login() {
        return sp.getBoolean("community_login", false);
    }

    public static boolean community_regist() {
        return sp.getBoolean("community_regist", false);
    }

    public static boolean community_content_share_success() {
        return sp.getBoolean("community_content_share_success", false);
    }

    public static boolean join_chat_tip() {
        return sp.getBoolean("join_chat_tip", false);
    }

    public static boolean community_person_center_self() {
        return sp.getBoolean("community_person_center_self", false);
    }

    public static boolean fristin_productdetail() {
        return sp.getBoolean("fristin_productdetail", true);
    }

    public static boolean join_chat_room_tip() {
        return sp.getBoolean("join_chat_room_tip", true);
    }

    public static boolean join_topic_chat_room_tip() {
        return sp.getBoolean("join_topic_chat_room_tip", true);
    }

    public static boolean content_detail_join_chat_room_tip() {
        return sp.getBoolean("content_detail_join_chat_room_tip", true);
    }

    public static boolean launch_save_status() {
        return sp.getBoolean("launch_save_status", true);
    }

    public static boolean xg_push_state() {
        return sp.getBoolean("xg_push_state", true);
    }

    public static boolean is_letter() {
        return sp.getBoolean("is_letter", false);
    }

    public static boolean isShowCaptureTipFlag() {
        return sp.getBoolean("isShowCaptureTipFlag", false);
    }

    public static boolean order_list_safe_show() {
        return sp.getBoolean("order_list_safe_show", false);
    }

    public static boolean SHOW_DOWN_PRICE_REMIND_GUIDE() {
        return sp.getBoolean("SHOW_DOWN_PRICE_REMIND_GUIDE", false);
    }

    public static boolean MemberChannelFirstFlag() {
        StringBuilder builder = new StringBuilder();
        builder.append("MemberChannelFirstFlag");
        builder.append(SystemInfoUtil.getVersionCode());
        return sp.getBoolean(builder.toString(), true);
    }

    public static String update_cancel_info() {
        return sp.getString("update_cancel_info", "");
    }

    public static String key_start_crash_version() {
        return sp.getString("key_start_crash_version", "");
    }

    public static String HOME_TAB_ICON_ID() {
        return sp.getString("HOME_TAB_ICON_ID", "");
    }

    public static String applink_url() {
        return sp.getString("applink_url", "");
    }

    public static String key_y_y_d_b_url() {
        return sp.getString("key_y_y_d_b_url", "");
    }

    public static String browser_goods() {
        StringBuilder builder = new StringBuilder();
        builder.append("browser_goods");
        builder.append(key_uid());
        return sp.getString(builder.toString(), "");
    }

    public static String token() {
        return sp.getString("token", "");
    }

    public static String key_uid() {
        return sp.getString("key_uid", "");
    }

    public static String imsign() {
        return sp.getString("imsign", "");
    }

    public static String usrname() {
        return sp.getString("usrname", "");
    }

    public static String nickname() {
        return sp.getString("nickname", "");
    }

    public static String userImg() {
        return sp.getString("userImg", "");
    }

    public static String BaseJXHomeApi_BASE_URL() {
        return sp.getString("BaseJXHomeApi_BASE_URL", "");
    }

    public static String BaseJXOmsApi_BASE_URL() {
        return sp.getString("BaseJXOmsApi_BASE_URL", "");
    }

    public static String BaseJXProductApi_BASE_URL() {
        return sp.getString("BaseJXProductApi_BASE_URL", "");
    }

    public static String BaseJXPromotionApi_BASE_URL() {
        return sp.getString("BaseJXPromotionApi_BASE_URL", "");
    }

    public static String BaseJXUserApi_BASE_URL() {
        return sp.getString("BaseJXUserApi_BASE_URL", "");
    }

    public static String launch_pictrue_url() {
        return sp.getString("launch_pictrue_url", "");
    }

    public static String launch_target_url() {
        return sp.getString("launch_target_url", "");
    }

    public static String tab_icon_version() {
        return sp.getString("tab_icon_version", "");
    }

    public static String user_login_name() {
        return sp.getString("user_login_name", "");
    }

    public static String user_login_phone() {
        return sp.getString("user_login_phone", "");
    }

    public static String ClubUserWapUrl() {
        return sp.getString("ClubUserWapUrl", "");
    }

    public static String KEY_REGION() {
        return sp.getString("KEY_REGION", "");
    }

    public static String user_phoneNum() {
        return sp.getString("user_phoneNum", "");
    }

    public static String config_result_data() {
        return sp.getString("config_result_data", "");
    }

    public static String host_info_data() {
        return sp.getString("host_info_data", "");
    }

    public static String device_type() {
        return sp.getString("device_type", "");
    }

    public static int capture_bubble() {
        return sp.getInt("capture_bubble", 0);
    }

    public static int store_version() {
        return sp.getInt("store_version", 0);
    }

    public static int server_mode_type() {
        return sp.getInt("server_mode_type", 0);
    }

    public static long user_login_time() {
        return sp.getInt("user_login_time", 0);
    }

    public static long community_publish_time() {
        return sp.getInt("community_publish_time", 0);
    }

    public static long key_wine_storehouse_id() {
        return sp.getInt("key_wine_storehouse_id", 25);
    }

    public static void community_person_center_self(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("community_person_center_self", param);
        editor.commit();
    }

    public static void token(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token", param);
        editor.commit();
    }

    public static void community_person_center_self(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("community_person_center_self", param);
        editor.commit();
    }

    public static void community_login(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("community_login", param);
        editor.commit();
    }

    public static void community_regist(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("community_regist", param);
        editor.commit();
    }

    public static void imsign(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("imsign", param);
        editor.commit();
    }

    public static void community_content_share_start(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("community_content_share_start", param);
        editor.commit();
    }

    public static void usrname(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("usrname", param);
        editor.commit();
    }

    public static void community_content_share_success(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("community_content_share_success", param);
        editor.commit();
    }

    public static void user_login_phone(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user_login_phone", param);
        editor.commit();
    }

    public static void nickname(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nickname", param);
        editor.commit();
    }

    public static void launch_pictrue_url(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("launch_pictrue_url", param);
        editor.commit();
    }

    public static void join_chat_tip(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("join_chat_tip", param);
        editor.commit();
    }

    public static void userImg(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userImg", param);
        editor.commit();
    }

    public static void BaseJXHomeApi_BASE_URL(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("BaseJXHomeApi_BASE_URL", param);
        editor.commit();
    }

    public static String WINE_TAB_ICON_ID(int paramInt) {
        StringBuilder builder = new StringBuilder();
        builder.append("WINE_TAB_ICON_ID");
        builder.append(paramInt);
        return sp.getString(builder.toString(), "");
    }

    public static void store_version(int param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("store_version", param);
        editor.commit();
    }

    public static void server_mode_type(int param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("server_mode_type", param);
        editor.commit();
    }

    public static void key_wine_storehouse_id(int param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("key_wine_storehouse_id", param);
        editor.commit();
    }

    public static void capture_bubble(int param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("capture_bubble", param);
        editor.commit();
    }

    public static void BaseJXOmsApi_BASE_URL(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("BaseJXOmsApi_BASE_URL", param);
        editor.commit();
    }

    public static void BaseJXUserApi_BASE_URL(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("BaseJXUserApi_BASE_URL", param);
        editor.commit();
    }

    public static void BaseJXProductApi_BASE_URL(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("BaseJXProductApi_BASE_URL", param);
        editor.commit();
    }

    public static void BaseJXPromotionApi_BASE_URL(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("BaseJXPromotionApi_BASE_URL", param);
        editor.commit();
    }

    public static void user_login_name(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user_login_name", param);
        editor.commit();
    }

    public static void launch_target_url(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("launch_target_url", param);
        editor.commit();
    }

    public static void KEY_REGION(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("KEY_REGION", param);
        editor.commit();
    }

    public static void user_phoneNum(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user_phoneNum", param);
        editor.commit();
    }

    public static void config_result_data(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("config_result_data", param);
        editor.commit();
    }

    public static void key_start_crash_version(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("key_start_crash_version", param);
        editor.commit();
    }

    public static void HOME_TAB_ICON_ID(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("HOME_TAB_ICON_ID", param);
        editor.commit();
    }

    public static void applink_url(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("applink_url", param);
        editor.commit();
    }

    public static void ClubUserWapUrl(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("ClubUserWapUrl", param);
        editor.commit();
    }

    public static void device_type(String param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("device_type", param);
        editor.commit();
    }

    public static void browser_goods(String paramString) {
        StringBuilder builder = new StringBuilder();
        builder.append("browser_goods");
        builder.append(key_uid());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(builder.toString(), paramString);
        editor.commit();
    }

    public static void MemberChannelFirstFlag(boolean param) {
        StringBuilder builder = new StringBuilder();
        builder.append("MemberChannelFirstFlag");
        builder.append(SystemInfoUtil.getVersionCode());
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(builder.toString(), param);
        editor.commit();
    }

    public static void user_login_time(long param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("user_login_time", param);
        editor.commit();
    }

    public static void launch_save_status(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("launch_save_status", param);
        editor.commit();
    }

    public static void update_cancel_info(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("update_cancel_info", param);
        editor.commit();
    }

    public static void xg_push_state(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("xg_push_state", param);
        editor.commit();
    }

    public static void is_letter(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("is_letter", param);
        editor.commit();
    }

    public static void isShowCaptureTipFlag(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isShowCaptureTipFlag", param);
        editor.commit();
    }

    public static void KEY_SHOW_CAPTURE_WINE_FLAG(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("KEY_SHOW_CAPTURE_WINE_FLAG", param);
        editor.commit();
    }

    public static void cart_promotion_hint_flag(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("cart_promotion_hint_flag", param);
        editor.commit();
    }

    public static void order_list_safe_show(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("order_list_safe_show", param);
        editor.commit();
    }

    public static void SHOW_DOWN_PRICE_REMIND_GUIDE(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("SHOW_DOWN_PRICE_REMIND_GUIDE", param);
        editor.commit();
    }

    public static void comment_photo_guide(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("comment_photo_guide", param);
        editor.commit();
    }

    public static void order_promotion_hint_flag(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("order_promotion_hint_flag", param);
        editor.commit();
    }

    public static void monitor_user_action(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("monitor_user_action", param);
        editor.commit();
    }

    public static void key_start_crash(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("key_start_crash", param);
        editor.commit();
    }

    public static void applink_handled_from_wap(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("applink_handled_from_wap", param);
        editor.commit();
    }

    public static void fristin_productdetail(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("fristin_productdetail", param);
        editor.commit();
    }

    public static void join_chat_room_tip(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("join_chat_room_tip", param);
        editor.commit();
    }

    public static void join_topic_chat_room_tip(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("join_topic_chat_room_tip", param);
        editor.commit();
    }

    public static void content_detail_join_chat_room_tip(boolean param) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("content_detail_join_chat_room_tip", param);
        editor.commit();
    }

    public static void WINE_TAB_ICON_ID(String paramString, int paramInt) {
        StringBuilder builder = new StringBuilder();
        builder.append("WINE_TAB_ICON_ID");
        builder.append(paramInt);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(builder.toString(), paramString);
        editor.commit();
    }

    public static void clear_user_info() {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }


}
