package com.zxin.marry.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.bean.AddressBean;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/6/13.
 */

public class AddShippingAddressActivity extends BaseActivity implements CommonContract.AddressModifyView {
    @InjectPresenter
    CommonPresenter presenter;

    private AddressBean addressBean;

    @Override
    public void initData() {
        addressBean = getIntent().getParcelableExtra("info");
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        setViewOnclick(R.id.tv_area_info,R.id.ll_address_default);
        presenter.initAddShippingAddressDatas(this,addressBean);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_addaddress;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }
        presenter.OnClick(v);
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public EditText getEDTNameView() {
        return getViewById(R.id.edt_true_name);
    }

    @Override
    public EditText getEDTPhoneView() {
        return getViewById(R.id.edt_mob_phone);
    }

    @Override
    public CommonCrosswiseBar getAreaInfoView() {
        return getViewById(R.id.tv_area_info);
    }

    @Override
    public EditText getEDTAddressView() {
        return getViewById(R.id.tv_address);
    }

    @Override
    public LinearLayout getAddressDefaultView() {
        return getViewById(R.id.ll_address_default);
    }

    @Override
    public CheckBox getCBAddressView() {
        return getViewById(R.id.cb_address);
    }
}
