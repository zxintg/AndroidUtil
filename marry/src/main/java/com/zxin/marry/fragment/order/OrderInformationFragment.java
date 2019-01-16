package com.zxin.marry.fragment.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
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

public class OrderInformationFragment extends BaseFragment  implements BaseFragment.LazyLoadingListener,OrderContract.OrderInformationView {

    @InjectPresenter
    OrderPresenter presenter;

    private FirstOrderBean.OneEntity oneEntity;

    public static Fragment newInstance(FirstOrderBean.OneEntity datas) {
        OrderInformationFragment fragment = new OrderInformationFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, datas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        oneEntity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initOrderInfoDatas(this,oneEntity);
        setLazyLoadingListener(this);
        setViewOnclick(R.id.ll_complaints);
    }

    @Override
    public int setLayout() {
        return R.layout.frag_order;
    }

    @Override
    public void onClick(View v) {
        presenter.OnClick(v);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getCurrentProcedure(oneEntity.getOrderid(),oneEntity.getShopid());
        presenter.getOrderInfoDetail(oneEntity.getOrderid(),oneEntity.getShopid());
    }

    @Override
    public SimpleDraweeView mImgView() {
        return getViewById(R.id.iv_img);
    }

    @Override
    public TextView mPhotoTypeView() {
        return getViewById(R.id.photo_type);
    }

    @Override
    public TextView mPhotoNameView() {
        return getViewById(R.id.photo_name);
    }

    @Override
    public TextView mMoneyView() {
        return getViewById(R.id.tv_money);
    }

    @Override
    public TextView mOrderPayForkeyView() {
        return getViewById(R.id.orderpayforkey);
    }

    @Override
    public TextView mBookSuccessDateView() {
        return getViewById(R.id.booksuccessdate);
    }

    @Override
    public RelativeLayout pstDepartmentView() {
        return getViewById(R.id.rl_department);
    }

    @Override
    public ImageView mInfoImageView() {
        return getViewById(R.id.information_image);
    }

    @Override
    public RelativeLayout mrRLLView() {
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
    public TextView mManNameView() {
        return getViewById(R.id.tv_manname);
    }

    @Override
    public TextView mManPhoneView() {
        return getViewById(R.id.tv_manphone);
    }

    @Override
    public TextView mWmanNameView() {
        return getViewById(R.id.tv_wmanname);
    }

    @Override
    public TextView mWmanPhoneView() {
        return getViewById(R.id.tv_wmanphone);
    }

    @Override
    public TextView mMarriedDateView() {
        return getViewById(R.id.tv_marriedDate);
    }

    @Override
    public TextView mShootLevelView() {
        return getViewById(R.id.tv_shootLevel);
    }

    @Override
    public TextView mPriceView() {
        return getViewById(R.id.tv_price);
    }

    @Override
    public TextView mManClothingView() {
        return getViewById(R.id.tv_manClothing);
    }

    @Override
    public TextView mTextView() {
        return getViewById(R.id.textView);
    }

    @Override
    public TextView mWmanClothingView() {
        return getViewById(R.id.tv_wmanClothing);
    }

    @Override
    public TextView mPhotoTotalNumberView() {
        return getViewById(R.id.tv_photoTotalNumber);
    }

    @Override
    public TextView mPhotoFinishingNumberView() {
        return getViewById(R.id.tv_photoFinishingNumber);
    }

    @Override
    public TextView mLocationShootView() {
        return getViewById(R.id.tv_locationShoot);
    }

    @Override
    public TextView mInteriorShootView() {
        return getViewById(R.id.tv_interiorShoot);
    }

    @Override
    public LinearLayout mSpecificProductView() {
        return getViewById(R.id.ll_specificProduct);
    }

    @Override
    public RecyclerView mNlvSpecificProductView() {
        return getViewById(R.id.nlv_specificProduct);
    }

    @Override
    public LinearLayout mLLNoteView() {
        return getViewById(R.id.ll_note);
    }

    @Override
    public TextView mNoteView() {
        return getViewById(R.id.tv_note);
    }

    @Override
    public TextView mOfSeriesPriceView() {
        return getViewById(R.id.tv_setOfSeriesPrice);
    }

    @Override
    public TextView mTailPaymentView() {
        return getViewById(R.id.tv_tailPayment);
    }
}
