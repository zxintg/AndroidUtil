package com.zxin.jiuxian.activity;

import android.view.View;
import android.webkit.JavascriptInterface;

import com.zxin.basemodel.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.HfFileUtil;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.X5WebView;

/*****
 * 公共网页加载
 */
public class JiuXianWebActivity extends BaseActivity {
    public static final String DYNAMIC_PAGE_HIDE_FLAG = "flag";
    public static final String DYNAMIC_PAGE_HIDE_KEY = "dynamic/mob01";
    public static final String DYNAMIC_PAGE_HIDE_VALUE = "android";
    public static final String HIDE_NATIVE_TITLE_TAG = "HIDE_NATIVE_TITLE_FLAG";
    public static final String JIUXIAN_PREFIX_URL = "jiuxian.com";
    public static final String KEY_SHOW_SHARE_BTN = "showShareBtn";
    public static final String NO_TITLE_TAG = "noTitle";
    public static final String URL_TAG = "url";


    private CommonCrosswiseBar mTitle;
    private X5WebView x5WebView;
    private String title;
    private String url = BaseStringUtils.WEB_TYPE_url;

    @Override
    public void initData() {
        title = getIntent().getStringExtra(BaseStringUtils.ACTIVITY_title);
        url = getIntent().getStringExtra(BaseStringUtils.url);

        mTitle = getViewById(R.id.ccb_title);
        x5WebView = getViewById(R.id.web_filechooser);

        mTitle.setOnClickListener(R.id.common_bar_leftBtn, this);
        mTitle.setOnClickListener(R.id.common_bar_leftImage, this);

        mTitle.setTitleText(title);
        switch (getIntent().getStringExtra(BaseStringUtils.WEB_TYPE)) {

            case BaseStringUtils.WEB_TYPE_fileHtml5:
                x5WebView.loadDataWithBaseURL("file:///android_asset/", HfFileUtil.readAssetsByName(this, url, "utf-8"), "text/html", "utf-8", "");
                break;

            case BaseStringUtils.WEB_TYPE_url:
                x5WebView.loadUrl(url);
                break;

            case BaseStringUtils.WEB_TYPE_html5:
                x5WebView.loadData(url, "text/html", "utf-8");
                break;
        }
        x5WebView.addJavascriptInterface(this, "cart");
    }

    @Override
    public int setLayout() {
        return R.layout.common_weblay;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (x5WebView != null) {
            x5WebView.destroy();
            x5WebView.removeAllViews();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftImage) {
            finish();
            return;
        }
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        if (x5WebView.canGoBack()) {
            x5WebView.goBack();
            return;
        }
        finish();
    }

    @JavascriptInterface
    public void addToCart(String paramString) {
        ToastUtil.showShort("addToCart");
    }

    @JavascriptInterface
    public void getShareData(final String paramString1, final String paramString2) {
        ToastUtil.showShort("getShareData");
    }

    @JavascriptInterface
    public void getSharePintuanData(final String paramString1, final String paramString2, final String paramString3, final String paramString4) {
        ToastUtil.showShort("getSharePintuanData");
    }

    @JavascriptInterface
    public void jxAddressCreatePage() {
        ToastUtil.showShort("jxAddressCreatePage");
    }

    @JavascriptInterface
    public void jxAddrestListPage(String paramString) {
        ToastUtil.showShort("jxAddrestListPage");
    }

    @JavascriptInterface
    public void jxAlert(String paramString) {
        ToastUtil.showShort("jxAlert");
    }

    @JavascriptInterface
    public void jxCloseWebView(String paramString) {
        ToastUtil.showShort("jxCloseWebView");
    }

    @JavascriptInterface
    public void jxUserInfo() {
        ToastUtil.showShort("jxUserInfo");
    }

    @JavascriptInterface
    public void jxWapCall(String paramString) {
        ToastUtil.showShort("jxWapCall");
    }

    @JavascriptInterface
    public void jxWechatPay(String paramString) {
        ToastUtil.showShort("jxWechatPay");
    }

    @JavascriptInterface
    public void showTipsAlert(String paramString) {
        ToastUtil.showShort("showTipsAlert");
    }

    @JavascriptInterface
    public void startPayCenter(String paramString) {
        ToastUtil.showShort("startPayCenter");
    }

    @JavascriptInterface
    public void startPintuanPayCenter(String paramString) {
        ToastUtil.showShort("startPintuanPayCenter");
    }

}
