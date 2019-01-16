package com.zxin.marry.fragment.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public class ReservePhotoGraphFragment extends BaseFragment  implements BaseFragment.LazyLoadingListener,OrderContract.ReservePhotographView {
    private FirstOrderBean.TwoEntity twoEntity;

    @InjectPresenter
    OrderPresenter presenter;

    public static Fragment newInstance(FirstOrderBean.TwoEntity datas) {
        ReservePhotoGraphFragment fragment = new ReservePhotoGraphFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, datas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        twoEntity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initReservePhotoGraphDatas(this,twoEntity);
        setViewOnclick(R.id.ll_department,R.id.rl_onlinebooking,R.id.btn_reserve_date,R.id.btn_reserve_camera);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_reserve_photograph_date;
    }

    @Override
    public void onClick(View v) {
        presenter.OnClick(v);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getReservePhotoGraphDetail(twoEntity.getOrderid(),twoEntity.getShopid());
    }

    @Override
    public LinearLayout pstLLdepartmentView() {
        return getViewById(R.id.ll_department);
    }

    @Override
    public ImageView mImageView() {
        return getViewById(R.id.information_image);
    }

    @Override
    public RelativeLayout mRL1View() {
        return getViewById(R.id.rl_1);
    }

    @Override
    public TextView mManagerNameView() {
        return getViewById(R.id.tv_manager_name);
    }

    @Override
    public TextView mPhoneNumberView() {
        return getViewById(R.id.tv_phone_number);
    }

    @Override
    public RelativeLayout mrDepView() {
        return getViewById(R.id.rl_dep);
    }

    @Override
    public TextView mSectionView() {
        return getViewById(R.id.tv_section);
    }

    @Override
    public TextView mDepView() {
        return getViewById(R.id.tv_dep);
    }

    @Override
    public View mLineView() {
        return getViewById(R.id.viewLine);
    }

    @Override
    public RelativeLayout mrCallView() {
        return getViewById(R.id.rl_call);
    }

    @Override
    public ImageView mrImageLView() {
        return getViewById(R.id.iv_1);
    }

    @Override
    public TextView mProgressView() {
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
    public TextView mTimeView() {
        return getViewById(R.id.tv_time);
    }

    @Override
    public LinearLayout mLayoutTimeView() {
        return getViewById(R.id.layout_time);
    }

    @Override
    public ImageView mTime1View() {
        return getViewById(R.id.time_1);
    }

    @Override
    public ImageView mTime2View() {
        return getViewById(R.id.time_2);
    }

    @Override
    public ImageView mTime3View() {
        return getViewById(R.id.time_3);
    }

    @Override
    public ImageView mTime4View() {
        return getViewById(R.id.time_4);
    }

    @Override
    public RelativeLayout mRLOnlineBookingView() {
        return getViewById(R.id.rl_onlinebooking);
    }

    @Override
    public TextView mOnlineBookingView() {
        return getViewById(R.id.tv_onlinebooking);
    }

    @Override
    public ImageView mOnlineBookingImgView() {
        return getViewById(R.id.icon_onlinebooking);
    }

    @Override
    public LinearLayout mLLButtonView() {
        return getViewById(R.id.ll_button);
    }

    @Override
    public RelativeLayout mRLReserveDateView() {
        return getViewById(R.id.rl_btn_reserve_date);
    }

    @Override
    public Button mReserveDateView() {
        return getViewById(R.id.btn_reserve_date);
    }

    @Override
    public RelativeLayout mRLReserveCameraView() {
        return getViewById(R.id.rl_btn_reserve_camera);
    }

    @Override
    public Button mReserveCameraView() {
        return getViewById(R.id.btn_reserve_camera);
    }

    @Override
    public RecyclerView mShootingTimeRecyclerViewView() {
        return getViewById(R.id.shootingTimeRecyclerView);
    }

    @Override
    public TextView mToastView() {
        return getViewById(R.id.text_toast);
    }
}
