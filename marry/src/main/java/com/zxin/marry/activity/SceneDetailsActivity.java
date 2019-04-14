package com.zxin.marry.activity;

import android.view.View;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.X5WebView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class SceneDetailsActivity extends BaseActivity implements CommonContract.SceneDetailsView {
    @InjectPresenter
    CommonPresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        presenter.initSceneDetailsDatas(this,getIntent());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_scene_details;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getX5WebViewView() != null) {
            getX5WebViewView().destroy();
        }
        getX5WebViewView().removeAllViews();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
            return;
        }
        presenter.OnClick(v);
    }

    @Override
    public void onBackPressed() {
        if (getX5WebViewView().canGoBack()) {
            getX5WebViewView().goBack();
            return;
        }
        finish();
    }

    @Override
    public CommonCrosswiseBar getTitleView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public X5WebView getX5WebViewView() {
        return getViewById(R.id.web_scene);
    }
}
