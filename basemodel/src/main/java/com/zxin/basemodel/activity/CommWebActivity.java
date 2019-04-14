package com.zxin.basemodel.activity;

import android.view.View;
import com.zxin.basemodel.R;
import com.zxin.root.util.BaseStringUtils;
import com.zxin.root.util.HfFileUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.X5WebView;

/*****
 * 公共网页加载
 */
public class CommWebActivity extends BaseActivity {
    private CommonCrosswiseBar mTitle;
    private X5WebView x5WebView;
    private String title;
    private String url = BaseStringUtils.WEB_TYPE_url;

    @Override
    public void initData() {
        title = getIntent().getStringExtra(BaseStringUtils.ACTIVITY_title);
        url = getIntent().getStringExtra(BaseStringUtils.url);

        mTitle.setTitleText(title);
        switch (getIntent().getStringExtra(BaseStringUtils.WEB_TYPE)){

            case BaseStringUtils.WEB_TYPE_fileHtml5:
                x5WebView.loadDataWithBaseURL("file:///android_asset/", HfFileUtil.readAssetsByName(this, url, "utf-8"),"text/html","utf-8","");
                break;

            case BaseStringUtils.WEB_TYPE_url:
                x5WebView.loadUrl(url);
                break;

            case BaseStringUtils.WEB_TYPE_html5:
                x5WebView.loadData(url,"text/html","utf-8");
                break;
        }
    }

    @Override
    public int setLayout() {
        return R.layout.common_weblay;
    }

    @Override
    public void initBaseDatas(View view) {
        mTitle = (CommonCrosswiseBar) view.findViewById(R.id.ccb_title);
        x5WebView = (X5WebView) view.findViewById(R.id.web_filechooser);
        mTitle.setOnClickListener(R.id.common_bar_leftBtn,this);
        mTitle.setOnClickListener(R.id.common_bar_leftImage,this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (x5WebView != null) {
            x5WebView.destroy();
        }
        x5WebView.removeAllViews();
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
}
