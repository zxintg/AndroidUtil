package com.zxin.marry.activity;

import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.X5WebView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class RecommendADVActivity extends BaseActivity {
    private CommonCrosswiseBar crosswiseBar;
    private WebView webView;

    @Override
    public void initData() {
        crosswiseBar = getViewById(R.id.ccb_marray_title);
        webView = getViewById(R.id.wv_coment);
        crosswiseBar.setTitleText(getIntent().getStringExtra("title"));
        WebSettings localWebSettings = webView.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        localWebSettings.setDisplayZoomControls(false);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowFileAccess(true);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setSupportZoom(true);
        localWebSettings.setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                sslErrorHandler.proceed();
            }
        });
        webView.loadUrl(getIntent().getStringExtra("url"));
        setTitleViewOnclick(R.id.ccb_marray_title, R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_recommend;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }
}
