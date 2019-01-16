package com.zxin.marry.activity;

import android.view.View;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.CirclePresenter;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/26.
 */

public class SubjectListActivity extends BaseActivity implements CircleContract.SubjectListView {
    @InjectPresenter
    CirclePresenter presenter;

    @Override
    public void initData() {
        presenter.initSubjectListDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_subject_list;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_subject);
    }
}
