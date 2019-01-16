package com.zxin.zxinlib.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.LogUtils;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.UiUtils;

/*****
 *  * 1：带Progress的WebView
 * 2：加载时间超过15s，提示
 * 3：内部多级url历史处理
 * 4：滑动监听（webview.setOnCustomScroolChangeListener）
 * 5：腾讯WX5浏览服务
 * liukui
 */
public class X5WebView extends WebView implements View.OnKeyListener {
	private ProgressBar mProgressbar;
	private WebSettings webSetting;
	public X5WebView(Context arg0) {
		super(arg0);
		setBackgroundColor(UiUtils.getColor(R.color.color_ffffff));
	}

	@SuppressLint("SetJavaScriptEnabled")
	public X5WebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		//加载进度条
		mProgressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, SystemInfoUtil.dip2px(2));
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		mProgressbar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bg_webview));
		addView(mProgressbar,layoutParams);
		initWebViewSettings();
	}

	private void initWebViewSettings() {
		webSetting = this.getSettings();
		//启用JavaScript
		webSetting.setJavaScriptEnabled(true);
		webSetting.setSupportZoom(false);
		//屏幕自适应
		webSetting.setUseWideViewPort(true);
		webSetting.setSupportMultipleWindows(true);
		webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
		//UserAgent添加appName,appVersion,channel,device_token
		/*StringBuilder stringBuilder = new StringBuilder(webSetting.getUserAgentString());
		stringBuilder.append(" 3rdedu/Android").append(" token/122000");*/
		//webSetting.setUserAgentString(stringBuilder.toString());
		setOnKeyListener(this);
		setWebViewClient(new MyWebViewClient());
		setWebChromeClient(new MyWebChromeClient());
	}

	private class MyWebViewClient extends WebViewClient {
		//防止加载网页时调起系统浏览器
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if(url.contains("bytedance://dispatch_message/"))
				return false;
			view.loadUrl(url);
			return false;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			X5WebView.this.setEnabled(false);
		}

		//加载完成
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			//页面finish后再发起图片加载
			if (!webSetting.getLoadsImagesAutomatically()) {
				webSetting.setLoadsImagesAutomatically(true);
			}
			X5WebView.this.setEnabled(true);
		}
	}

	public class MyWebChromeClient extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			if (newProgress == 100) {
				mProgressbar.setVisibility(View.GONE);
			} else {
				if (mProgressbar.getVisibility() == View.GONE) {
					mProgressbar.setVisibility(View.VISIBLE);
				}
				LogUtils.d("newProgress = " + newProgress);
				mProgressbar.setProgress(newProgress);
			}
			super.onProgressChanged(view, newProgress);
		}

	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_UP) {
			// 表示按返回键，返回历史
			if (keyCode == KeyEvent.KEYCODE_BACK && this.canGoBack()) {
				this.goBack();
				return true;
			}
		}
		return false;
	}
}
