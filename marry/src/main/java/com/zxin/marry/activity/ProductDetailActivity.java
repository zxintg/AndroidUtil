package com.zxin.marry.activity;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.baichuan.android.trade.page.AlibcMyOrdersPage;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.root.util.LogUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/6/27.
 */

public class ProductDetailActivity extends BaseActivity {
    private CommonCrosswiseBar titlrBar;
    private WebView mWebView;

    //public static final String AppKey = "23478512";
    public static final String AppKey = "24957736";
    //public static final String AppSecret = "2e6ed88bf56628c21430923eed470363";
    public static final String AppSecret = "bcd33e2b03d8c195ed30b6710b462a01";
    static final String url = "http://gw.api.taobao.com/router/rest";

    private ShopClassBean.TaoBaoProduct product;


    @Override
    public void initData() {
        product = getIntent().getParcelableExtra("TaoBaoProduct");
        titlrBar = getViewById(R.id.ccb_marray_title);
        mWebView = getViewById(R.id.webView);
        titlrBar.setTitleText(product == null ? "婚品订单" : "商品详情");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftImage, R.id.common_bar_leftBtn);
        if (product==null){
            showPage(new AlibcMyOrdersPage(0, true));
            return;
        }
        showPage(new AlibcDetailPage(product.getOpen_iid()));
    }

    @Override
    public int setLayout() {
        return R.layout.activity_product_detail;
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

    private void showPage(AlibcBasePage paramAlibcBasePage) {
        AlibcTaokeParams alibcTaokeParams = new AlibcTaokeParams();
        //alibcTaokeParams.setPid("mm_26632322_6858406_23810104");
        alibcTaokeParams.setPid("mm_133989074_0_0");
        AlibcShowParams localAlibcShowParams = new AlibcShowParams(OpenType.H5, false);
        HashMap localHashMap = new HashMap();
        localHashMap.put("isv_code", "appisvcode");
        AlibcTrade.show(this, this.mWebView, new WebViewClient(), new WebChromeClient(), paramAlibcBasePage, localAlibcShowParams, alibcTaokeParams, localHashMap, new AlibcTradeCallback() {
            @Override
            public void onTradeSuccess(AlibcTradeResult alibcTradeResult) {
                LogUtils.d("获取商品信息成功======》"+alibcTradeResult.toString());
            }

            public void onFailure(int paramAnonymousInt, String paramAnonymousString) {
                LogUtils.d("获取商品信息失败======》"+paramAnonymousString);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return;
        }
        finish();
    }

}
