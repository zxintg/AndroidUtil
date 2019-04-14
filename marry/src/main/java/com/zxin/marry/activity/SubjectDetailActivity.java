package com.zxin.marry.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.SubjectForm;
import com.zxin.marry.mvp.presenter.CirclePresenter;
import com.zxin.marry.mvp.view.CircleContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class SubjectDetailActivity extends BaseActivity implements CircleContract.SubjectDetailView {

    private SubjectForm.Subject mSubject;

    @InjectPresenter
    CirclePresenter presenter;

    @Override
    public void initData() {
        mSubject = getIntent().getParcelableExtra(SubjectForm.Subject.class.getSimpleName());
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        presenter.initSubjectDetailDatas(this,mSubject);
        presenter.getSubjectDetail(mSubject.getId());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_subject_detail;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_subject_commonlayout);
    }

    @Override
    public ImageView getImageView() {
        return getViewById(R.id.sdv);
    }

    @Override
    public TextView getTitleView() {
        return getViewById(R.id.tv_title);
    }

    @Override
    public TextView getCreateTimeView() {
        return getViewById(R.id.tv_createTime);
    }

    @Override
    public TextView getTVDescribeView() {
        return getViewById(R.id.tv_describe);
    }
}
