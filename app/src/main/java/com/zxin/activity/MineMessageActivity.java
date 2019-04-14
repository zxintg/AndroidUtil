package com.zxin.activity;

import android.content.Intent;
import android.view.View;
import com.zxin.camera.callback.IPhotoCall;
import com.zxin.camera.utils.CameraAlbumUtils;
import com.zxin.camera.utils.VanCropType;
import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.root.bean.Address;
import com.zxin.basemodel.dao.CityDaoUtil;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.dialog.BaseNiceDialog;
import com.zxin.root.view.dialog.NiceDialog;
import com.zxin.root.view.dialog.NiceDialogViewHolder;
import com.zxin.root.view.dialog.ViewConvertListener;
import com.zxin.root.view.popup.SelectorPickerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/30.
 */

public class MineMessageActivity extends BaseActivity implements IPhotoCall {
    @BindView(R.id.ccb_userhead)
    CommonCrosswiseBar mHead;
    @BindView(R.id.ccb_usernicename)
    CommonCrosswiseBar ccbUsernicename;
    @BindView(R.id.ccb_center_sex)
    CommonCrosswiseBar mSex;
    @BindView(R.id.ccb_center_opencity)
    CommonCrosswiseBar ccbCenterOpencity;

    private Address address;

    @Override
    public void initData() {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_minemessage;
    }

    private NiceDialog niceDialog;
    @OnClick({R.id.common_bar_leftBtn, R.id.ccb_userhead, R.id.ccb_usernicename,R.id.ccb_center_sex,R.id.ccb_center_opencity})
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.ccb_userhead:
                //头像选择
                CameraAlbumUtils.getInstance(mContext).setIPhotoCall(this).getPhoto().setTailorType(VanCropType.CROP_TYPE_CIRCLE).setParam(SystemInfoUtil.getScreenWidth()/2, SystemInfoUtil.getScreenWidth()/2);
                break;

            case R.id.ccb_center_sex:
                //性别
                if (niceDialog == null) {
                    niceDialog = NiceDialog.init();
                }
                niceDialog.setOnNiceDialogListener(new NiceDialog.NiceDialogListener() {
                    @Override
                    public void onItemListener(int index, String item) {
                        mSex.setRightText(item);
                    }
                });
                niceDialog.setCommonLayout(new String[]{"男","女"},true);
                break;

            case R.id.ccb_center_opencity:
                if (niceDialog == null) {
                    niceDialog = NiceDialog.init();
                }
                niceDialog.setLayoutId(R.layout.common_popup_address)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(NiceDialogViewHolder holder, final BaseNiceDialog dialog) {
                                SelectorPickerView pickerView = (SelectorPickerView) holder.getConvertView();
                                pickerView.setShowCityDatas(CityDaoUtil.getInstance().getAllCityProvince());
                                if (address != null) {
                                    pickerView.setShowAddressPicker(address);
                                }
                                holder.setOnClickListener(R.id.customer_picker_leftbtn, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        colseDialog();
                                    }
                                });
                                pickerView.setSelectPicker(new SelectorPickerView.SelectPickerListener() {

                                    @Override
                                    public void onResultPicker(Object obj) {
                                        if (address == null)
                                            address = new Address();
                                        address = (Address) obj;
                                        ccbCenterOpencity.setRightText(address.city+" "+address.district);
                                        colseDialog();
                                    }
                                });
                            }
                        })
                        .setDimAmount(0.3f)
                        .setShowBottom(true)
                        .show();

                break;
        }
    }

    private void colseDialog() {
        if (niceDialog != null && niceDialog.isVisible()) {
            niceDialog.dismiss();
        }
    }

    @Override
    public void onPhotoResult(String photoUrl) {
        ImageUtil.setItemRoundImageViewOnlyDisplay(mHead.getRightImage(), photoUrl);
    }
}
