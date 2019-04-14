package com.zxin.marry.activity;

import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.X5WebView;

/*****
 * 公共网页加载
 */
public class MarriedProcessActivity extends BaseActivity implements CommonContract.MarriProcessView {
    @InjectPresenter
    CommonPresenter presenter;

    @Override
    public void initData() {
        presenter.initMarriedProcessDatas(this);
        presenter.getMarriProcess();
        setTitleViewOnclick(R.id.ccb_marray_title, R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_marriedprocess;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getX5WebView() != null) {
            getX5WebView().destroy();
        }
        getX5WebView().removeAllViews();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        if (getX5WebView().canGoBack()) {
            getX5WebView().goBack();
            return;
        }
        finish();
    }

    @Override
    public X5WebView getX5WebView() {
        return getViewById(R.id.web_filechooser);
    }
}
