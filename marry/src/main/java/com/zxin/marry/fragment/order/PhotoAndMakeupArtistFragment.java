package com.zxin.marry.fragment.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseFragment;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.mvp.presenter.PhotoGrapherPresenter;
import com.zxin.marry.mvp.view.PhotoGrapherContract;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;

/**
 * Created by Administrator on 2018/6/19.
 */

public class PhotoAndMakeupArtistFragment extends BaseFragment  implements BaseFragment.LazyLoadingListener,PhotoGrapherContract.PhotoAndMakeupArtistView {
    private FirstOrderBean.ThreeEntity threeEntity;

    @InjectPresenter
    PhotoGrapherPresenter presenter;

    public static Fragment newInstance(FirstOrderBean.ThreeEntity datas) {
        PhotoAndMakeupArtistFragment fragment = new PhotoAndMakeupArtistFragment();
        Bundle args = new Bundle();
        args.putParcelable(StringUtils.FRAGMENT_DATA, datas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData() {
        threeEntity = getArguments().getParcelable(StringUtils.FRAGMENT_DATA);
        presenter.initDatas(this,threeEntity);
        setViewOnclick(R.id.btn_on_line,R.id.btn_reserve_record,R.id.sdv_camera);
        setLazyLoadingListener(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_photogradper_artist;
    }

    @Override
    public void onClick(View v) {
        presenter.OnClick(v);
    }

    @Override
    public void loadLazyDatas(boolean bool) {
        presenter.getDesignAndCameraDetail(threeEntity.getOrderid(),threeEntity.getShopid());
    }

    @Override
    public LinearLayout getDepartmentView() {
        return getViewById(R.id.ll_department);
    }

    @Override
    public ImageView getInformationImageView() {
        return getViewById(R.id.information_image);
    }

    @Override
    public LinearLayout getRL1View() {
        return getViewById(R.id.rl_1);
    }

    @Override
    public TextView getManagerNameView() {
        return getViewById(R.id.tv_manager_name);
    }

    @Override
    public TextView getPhoneNumberView() {
        return getViewById(R.id.tv_phone_number);
    }

    @Override
    public LinearLayout getRLDepView() {
        return getViewById(R.id.rl_dep);
    }

    @Override
    public TextView getSectionView() {
        return getViewById(R.id.tv_section);
    }

    @Override
    public TextView getTVDepView() {
        return getViewById(R.id.tv_dep);
    }

    @Override
    public View getViewLineView() {
        return getViewById(R.id.viewLine);
    }

    @Override
    public LinearLayout getRLCallView() {
        return getViewById(R.id.rl_call);
    }

    @Override
    public ImageView getIV1View() {
        return getViewById(R.id.iv_1);
    }

    @Override
    public TextView getServiceProgressView() {
        return getViewById(R.id.service_progress);
    }

    @Override
    public SimpleDraweeView getSDVCameraView() {
        return getViewById(R.id.sdv_camera);
    }

    @Override
    public ImageView getIVOptionalCameraView() {
        return getViewById(R.id.iv_optional_camera);
    }

    @Override
    public TextView getMaquilleurView() {
        return getViewById(R.id.tv_maquilleur);
    }

    @Override
    public TextView getNum1View() {
        return getViewById(R.id.tv_num1);
    }

    @Override
    public TextView getMaquilleurNumView() {
        return getViewById(R.id.tv_maquilleur_num);
    }

    @Override
    public TextView getPhotographerView() {
        return getViewById(R.id.tv_photographer);
    }

    @Override
    public TextView getNum2View() {
        return getViewById(R.id.tv_num2);
    }

    @Override
    public TextView getPhotographerNumView() {
        return getViewById(R.id.tv_photographer_num);
    }

    @Override
    public LinearLayout getLLButtonView() {
        return getViewById(R.id.ll_button);
    }

    @Override
    public Button getOnLineView() {
        return getViewById(R.id.btn_on_line);
    }

    @Override
    public Button getReserveRecordView() {
        return getViewById(R.id.btn_reserve_record);
    }

    @Override
    public TextView getTextView3View() {
        return getViewById(R.id.textView3);
    }

    @Override
    public TextView getRemindView() {
        return getViewById(R.id.tv_remind);
    }
}
