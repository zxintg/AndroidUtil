package com.zxin.marry.util;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.zxin.marry.activity.GoodsDetailsActivity;
import com.zxin.marry.activity.HotCommentsActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopDetailsActivity;

/**
 * Created by Administrator on 2018/7/3.
 */

public class JsInterface {
    private Context mContext;

    public JsInterface(Context mContext){
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void showInfoFromJs(String type, String parameter) {
        Intent intent = new Intent();
        switch (type) {
            case "1":
                intent.setClass(mContext, ShopDetailsActivity.class);
                intent.putExtra("store_id", parameter);
                break;

            case "2":
                intent.setClass(mContext, ShopCaseDetailsActivity.class);
                intent.putExtra("case_id", parameter);
                break;

            case "3":
                intent.setClass(mContext, GoodsDetailsActivity.class);
                intent.putExtra("goods_id", parameter);
                break;

            case "4":
                intent.setClass(mContext, HotCommentsActivity.class);
                intent.putExtra("id", parameter);
                break;
        }
        mContext.startActivity(intent);
    }
}
