package com.zxin.marry.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.mvp.view.MainTopicContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.X5WebView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class HotNewsDetailActivity extends BaseActivity implements MainTopicContract.HotNewsDetailView {
    private String url, name, id;
    @InjectPresenter
    TopicPresenter presenter;

    @Override
    public void initData() {
        url = getIntent().getStringExtra("url");
        name = getIntent().getStringExtra("name");
        id = getIntent().getStringExtra("id");
        presenter.initHotNewsDetailDatas(this, url, name, id);
        setTitleViewOnclick(R.id.ccb_marray_title, R.id.common_bar_leftBtn, R.id.common_bar_rightBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_hotnews_detail;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        } else if (v.getId() == R.id.common_bar_rightBtn) {
            //分享

        }
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public X5WebView getX5WebView() {
        return getViewById(R.id.webcontent);
    }

    @Override
    public LinearLayout getMenuView() {
        return getViewById(R.id.menu);
    }

    @Override
    public EditText getEDCommentsView() {
        return getViewById(R.id.et_comments);
    }

    @Override
    public LinearLayout getLLNoFocusView() {
        return getViewById(R.id.ll_noFocus);
    }

    @Override
    public ImageView getIVPraiseView() {
        return getViewById(R.id.iv_praise);
    }

    @Override
    public TextView getTVPraiseCountView() {
        return getViewById(R.id.tv_praiseCount);
    }

    @Override
    public TextView getTVCommentsCountView() {
        return getViewById(R.id.tv_commentsCount);
    }

    @Override
    public TextView getTVSendView() {
        return getViewById(R.id.tv_send);
    }

    @Override
    public void onBackPressed() {
        if (getX5WebView().canGoBack()) {
            getX5WebView().goBack();
            return;
        }
        getX5WebView().loadUrl("about:blank");
        finish();
    }

}
