package com.zxin.marry.fragment.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.activity.PickUpDetailsActivity;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.mvp.presenter.OrderPresenter;
import com.zxin.marry.mvp.view.OrderContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/19.
 */

public class ReserveExpressDateFragment extends BaseFragment  implements BaseFragment.LazyLoadingListener,OrderContract.ReserveExpressView {
    private FirstOrderBean.TenEntity tenEntity;

    @InjectPresenter
    OrderPresenter presenter;

    public static Fragment newInstance(FirstOrderBean.TenEntity datas) {
        ReserveExpressDateFragment fragment = new ReserveExpressDateFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, datas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        tenEntity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initReserveExpressDate(this,tenEntity);
        setViewOnclick(R.id.rl_onlinebooking);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_reserve_express;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_onlinebooking){
            Intent intent = new Intent(mContext,PickUpDetailsActivity.class);
            intent.putExtra("shopid", tenEntity.getShopid());
            intent.putExtra("orderid",tenEntity.getOrderid());
            startActivity(intent);
            return;
        }
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getReserveExpressDate(tenEntity.getOrderid(),tenEntity.getShopid());
    }

    @Override
    public LinearLayout pstLLDepartmentView() {
        return getViewById(R.id.rl_department);
    }

    @Override
    public RelativeLayout mRLOnlineBookingView() {
        return getViewById(R.id.rl_onlinebooking);
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
    public LinearLayout mLLYunPanView() {
        return getViewById(R.id.ll_pan);
    }

    @Override
    public TextView mTVYunAddressView() {
        return getViewById(R.id.tv_yun_address);
    }

    @Override
    public TextView mTVCopyView() {
        return getViewById(R.id.tv_copy);
    }

    @Override
    public LinearLayout mLLPanMoreView() {
        return getViewById(R.id.ll_pan_more);
    }

    @Override
    public TextView mOnlineBookingView() {
        return getViewById(R.id.tv_onlinebooking);
    }

    @Override
    public TextView mToastView() {
        return getViewById(R.id.text_toast);
    }
}
