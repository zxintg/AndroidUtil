package com.zxin.activity.test;

import android.view.View;
import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.mvp.presenter.MeiZiHtmlPresenter;
import com.zxin.mvp.view.TestHtmlContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/21.
 */

public class TestHtmlActivity extends BaseActivity implements TestHtmlContract.TestView {
    @BindView(R.id.rcv_testhtml_commonlayout)
    RefreshCommonView mRefreshCommonView;

    @InjectPresenter
    private MeiZiHtmlPresenter presenter;

    @Override
    public void initData() {
        presenter.initDatas(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_testhtml;
    }

    @OnClick({R.id.common_bar_leftBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 断开View引用
        if (presenter != null)
            presenter.detachView();
    }

    @Override
    public RefreshCommonView getRecyclerView() {
        return mRefreshCommonView;
    }
}
