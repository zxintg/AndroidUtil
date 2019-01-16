package com.zxin.marry.activity;

import android.view.View;
import android.widget.ImageView;

import com.common.camera.callback.IPhotoCall;
import com.common.camera.utils.CameraAlbumUtils;
import com.common.camera.utils.VanCropType;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.UserPresenter;
import com.zxin.marry.mvp.view.UserContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SharedPreferencesManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.dialog.NiceDialog;

/**
 * Created by Administrator on 2018/6/13.
 */

public class UserCentryActivity extends BaseActivity implements UserContract.MineUserCenterView,IPhotoCall {
    @InjectPresenter
    UserPresenter presenter;

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.ll_image,R.id.information_nickname,R.id.information_qianming,R.id.information_sex,R.id.information_wedding);
        presenter.initDatas(this);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_usercentry;
    }

    private NiceDialog niceDialog;
    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.common_bar_leftBtn) {
            onBackPressed();
        }else if (id == R.id.ll_image) {
            //头像
            CameraAlbumUtils.getInstance(mContext).setIPhotoCall(this).getPhoto().setTailorType(VanCropType.CROP_TYPE_CIRCLE).setSuperRotate(true).setParam(SystemInfoUtil.getScreenWidth()-10,SystemInfoUtil.getScreenWidth()-10);
        }else if (id == R.id.information_nickname) {
            //昵称

        }else if (id == R.id.information_qianming) {
           //签名

        }else if (id == R.id.information_sex) {
           //性别
            if (niceDialog == null) {
                niceDialog = NiceDialog.init();
            }
            niceDialog.setOnNiceDialogListener(new NiceDialog.NiceDialogListener() {
                @Override
                public void onItemListener(int index, String item) {
                    if (getSexView().getRightText().equals(item))
                        return;
                    getSexView().setRightText(item);
                    presenter.updateUserSex(SharedPreferencesManager.getMarryUid(),String.valueOf(index));
                }
            });
            niceDialog.setCommonLayout(new String[]{"保密","男","女"},true);
        }else if (id == R.id.information_wedding) {
            //婚期

        }
    }

    @Override
    public ImageView getUserHeadView() {
        return getViewById(R.id.information_image);
    }

    @Override
    public CommonCrosswiseBar getNickNameView() {
        return getViewById(R.id.information_nickname);
    }

    @Override
    public CommonCrosswiseBar getQianMingView() {
        return getViewById(R.id.information_qianming);
    }

    @Override
    public CommonCrosswiseBar getSexView() {
        return getViewById(R.id.information_sex);
    }

    @Override
    public CommonCrosswiseBar getWeddingView() {
        return getViewById(R.id.information_wedding);
    }

    @Override
    public CommonCrosswiseBar getPhoneView() {
        return getViewById(R.id.information_phone);
    }

    @Override
    public void onPhotoResult(String photoUrl) {
        ImageUtil.setItemRoundImageViewOnlyDisplay(getUserHeadView(), photoUrl);
    }
}
