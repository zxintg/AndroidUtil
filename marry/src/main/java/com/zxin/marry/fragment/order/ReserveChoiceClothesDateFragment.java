package com.zxin.marry.fragment.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/19.
 */

public class ReserveChoiceClothesDateFragment extends BaseFragment implements BaseFragment.LazyLoadingListener,OrderContract.ReserveChoiceClothesView {
    private FirstOrderBean.FourEntity fourEntity;

    @InjectPresenter
    OrderPresenter presenter;

    public static Fragment newInstance(FirstOrderBean.FourEntity datas) {
        ReserveChoiceClothesDateFragment fragment = new ReserveChoiceClothesDateFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, datas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        fourEntity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initReserveChoiceClothesDate(this,fourEntity);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_reserve_choice_clothes;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getReserveChoiceClothes(fourEntity.getOrderid(),fourEntity.getShopid());
    }

    @Override
    public TextView getServiceProgressView() {
        return getViewById(R.id.service_progress);
    }

    @Override
    public LinearLayout mYearView() {
        return getViewById(R.id.ll_year);
    }

    @Override
    public ImageView mYear1View() {
        return getViewById(R.id.year_1);
    }

    @Override
    public ImageView mYear2View() {
        return getViewById(R.id.year_2);
    }

    @Override
    public ImageView mYear3View() {
        return getViewById(R.id.year_3);
    }

    @Override
    public ImageView mYear4View() {
        return getViewById(R.id.year_4);
    }

    @Override
    public ImageView mMonth1View() {
        return getViewById(R.id.month_1);
    }

    @Override
    public ImageView mMonth2View() {
        return getViewById(R.id.month_2);
    }

    @Override
    public ImageView mDay1View() {
        return getViewById(R.id.day_1);
    }

    @Override
    public ImageView mDay2View() {
        return getViewById(R.id.day_2);
    }

    @Override
    public LinearLayout mLLTimeView() {
        return getViewById(R.id.ll_time);
    }

    @Override
    public ImageView mHour1View() {
        return getViewById(R.id.hour_1);
    }

    @Override
    public ImageView mHour2View() {
        return getViewById(R.id.hour_2);
    }

    @Override
    public ImageView mHour3View() {
        return getViewById(R.id.hour_3);
    }

    @Override
    public ImageView mHour4View() {
        return getViewById(R.id.hour_4);
    }

    @Override
    public TextView mTextToastView() {
        return getViewById(R.id.text_toast);
    }
}
