package com.zxin.zxinlib.util;

/**
 * Created by 系统实数常量 on 2017/11/22.
 *
 * 基础 以 1 开头
 *
 */

public class IntegerUtil {

    public static final int ABS_UNAUTHORIZED = 401;//请求授权失败
    public static final int ABS_FORBIDDEN = 403;//请求不允许
    public static final int ABS_NOT_FOUND = 404;//没有发现文件、查询或URl
    public static final int ABS_REQUEST_TIMEOUT = 408;//客户端没有在用户指定的饿时间内完成请求
    public static final int ABS_INTERNAL_SERVER_ERROR = 500;//服务器产生内部错误
    public static final int ABS_BAD_GATEWAY = 502;//服务器暂时不可用，有时是为了防止发生系统过载
    public static final int ABS_SERVICE_UNAVAILABLE = 503;//服务器过载或暂停维修
    public static final int ABS_GATEWAY_TIMEOUT = 504;//关口过载，服务器使用另一个关口或服务来响应用户，等待时间设定值较长
    public static final int ABS_TOKEN_FAIL=000004;//token验证失败
    public static final int ABS_TOKEN_EXPIRE=000005;//	token过期
    public static final int ABS_SYSTEM_EXPIRE=000006;//	验证码超时，请重新获取
    public static final int ABS_TOKEN_POST_NULL=000003;//	请求token不能为空
    public static final int ABS_USER_VERIFICATION=000006;//验证码超时，请重新获取
    public static final int ABS_USER_GETMOBILE=000007;//获取手机验证码失败
    public static final int ABS_USER_PARAMETER=8;//参数验证失败
    public static final int ABS_USER_VERIFIAGAIN=9;//验证码有误，请重新获取
    public static final int PERMISSION_REQUEST_FILE = 1002;
    public static final int PERMISSION_REQUEST_LOCATION = 1003;
    public static final int PERMISSION_REQUEST_CAMERA = 1004;
    public static final int PERMISSION_REQUEST_ALBUM = 1005;
    public static final int PERMISSION_REQUEST_SETTING = 1006;
    public static final int PERMISSION_SYSEX_SETTING = 111111;

    //打开筛选框
    public final static int CONDITION_POPUP_OPEN = 11001;
    //关闭筛选框
    public final static int CONDITION_POPUP_ClOSE = 11002;

    //evenbus标识
    public static final int EVENT_ID_11001 = 12001;
    //课程表修改
    public static final int EVENT_ID_11002 = 12002;
    public static final int EVENT_ID_11006 = 12003;
    //刷新我的
    public static final int EVENT_ID_11013 = 12004;
    //订单删除
    public static final int EVENT_ID_11014 = 12005;
    //订单刷新
    public static final int EVENT_ID_11015 = 12006;
    //生成课程表
    public static final int MESSAGE_ID_60001 = 13001;

    //修改性别
    public static final int EVENT_ID_11003 = 21001;
    //点单详情
    public static final int EVENT_ID_11004 = 21002;
    //收藏
    public static final int EVENT_ID_11005 = 21003;
    //直播课课程详情
    public static final int EVENT_ID_11008 = 21004;
    //线下一对一课程详情
    public static final int EVENT_ID_11009 = 21005;
    //视频课课程详情
    public static final int EVENT_ID_11010 = 21006;
    //地址添加修改
    public static final int EVENT_ID_11011 = 21007;
    //地址选择
    public static final int EVENT_ID_11012 = 21008;
    // 线下一对一申请试听、立即购买返回处理
    public static final int EVENT_ID_11016 = 21009;

    //微信支付成功
    public final static int EVENT_ID_7001 = 21010;
    //支付宝支付成功
    public final static int EVENT_ID_7002 = 21011;
    //余额 支付成功
    public final static int EVENT_ID_7003 = 21012;
    //免费 支付成功
    public final static int EVENT_ID_7004 = 21013;
    //支付取消
    public final static int EVENT_ID_7005 = 21014;
    //支付失败
    public final static int EVENT_ID_7006 = 21015;

    // 线下一对一申请试听
    public static final int EVENT_ID_11017 = 21016;
    //跳转到品牌课
    public static final int EVENT_ID_11018 = 21017;
    //跳转到直播课
    public static final int EVENT_ID_11019 = 21018;
    //推荐班课更多
    public static final int EVENT_ID_11020 = 21019;
    //搜索
    public static final int EVENT_ID_11021 = 21020;

    //待支付订单
    public final static int ORDER_STATUS_WAITPAY = 1;
    //已支付订单
    public final static int ORDER_STATUS_PAYED = 2;
    //已完成订单
    public final static int ORDER_STATUS_FINISH = 8;
    //已关闭订单
    public final static int ORDER_STATUS_ClOSE = 9;

    public static final int Activity_Modify = 22001;

    //提醒助教
    public final static int TEA__BINDING_32011= 32011;
    //绑定银行提醒
    public final static int TEA__BINDING_32012= 32012;

    //通知在线直播课是否关闭筛选框
    public final static int CONDITION_VIDEOPOPUP_ClOSE = 23001;
    //回调钱包页面
    public final static int TEA__BINDING_32014= 32014;

    public final static int WEB_API_TestMeiZiJson  = 24001;
    public final static int WEB_API_TestMeiZiHtml  = 24002;
    public final static int WEB_API_CodeKK  = 24003;
    public final static int WEB_API_YunShang  = 24004;
    public final static int WEB_API_AndroidBus  = 24005;
}
