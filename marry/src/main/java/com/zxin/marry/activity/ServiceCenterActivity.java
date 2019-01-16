package com.zxin.marry.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.marry.R;
import com.zxin.marry.base.BaseActivity;
import com.zxin.marry.mvp.presenter.CommonPresenter;
import com.zxin.marry.mvp.view.CommonContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.view.CommonCrosswiseBar;

/**
 * Created by Administrator on 2018/6/21.
 */

public class ServiceCenterActivity extends BaseActivity implements CommonContract.ServiceCenterView {
    @InjectPresenter
    CommonPresenter presenter;

    private String orderid;
    private String shopid;

    @Override
    public void initData() {
        orderid = getIntent().getStringExtra("orderid");
        shopid = getIntent().getStringExtra("shopid");
        presenter.initServiceCenterDatas(this);
        setTitleViewOnclick(R.id.ccb_marray_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.rl_phone1,R.id.rl_phone2,R.id.rl_qq1,R.id.rl_qq2,R.id.rl_weixin,R.id.ll_taking_pictures,R.id.ll_sample,R.id.ll_getphoto);
        presenter.getServiceCenterDatas(orderid,shopid);
    }

    @Override
    public int setLayout() {
        return R.layout.ac_service_center;
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
    public CommonCrosswiseBar getTitleView() {
        return getViewById(R.id.ccb_marray_title);
    }

    @Override
    public LinearLayout getLLPhone1View() {
        return getViewById(R.id.ll_phone1);
    }

    @Override
    public TextView getTVPhone1View() {
        return getViewById(R.id.tv_phone1);
    }

    @Override
    public RelativeLayout getRLPhone1View() {
        return getViewById(R.id.rl_phone1);
    }

    @Override
    public ImageView getImgPhone1View() {
        return getViewById(R.id.img_phone1);
    }

    @Override
    public LinearLayout getLLPhone2View() {
        return getViewById(R.id.ll_phone2);
    }

    @Override
    public TextView getTVPone2View() {
        return getViewById(R.id.tv_phone2);
    }

    @Override
    public RelativeLayout getRLPhone2View() {
        return getViewById(R.id.rl_phone2);
    }

    @Override
    public LinearLayout getLLTakingPicturesView() {
        return getViewById(R.id.ll_taking_pictures);
    }

    @Override
    public TextView getTVTakingPicturesView() {
        return getViewById(R.id.tv_taking_pictures);
    }

    @Override
    public RelativeLayout getRLTakingPicturesView() {
        return getViewById(R.id.rl_taking_pictures);
    }

    @Override
    public LinearLayout getLLSampleView() {
        return getViewById(R.id.ll_sample);
    }

    @Override
    public TextView getTVSampleView() {
        return getViewById(R.id.tv_sample);
    }

    @Override
    public RelativeLayout getRLSampleView() {
        return getViewById(R.id.rl_sample);
    }

    @Override
    public LinearLayout getLLPhotoView() {
        return getViewById(R.id.ll_getphoto);
    }

    @Override
    public TextView getTVPhotoView() {
        return getViewById(R.id.tv_getphoto);
    }

    @Override
    public RelativeLayout getRLPhotoView() {
        return getViewById(R.id.rl_getphoto);
    }

    @Override
    public LinearLayout getLLQQ1View() {
        return getViewById(R.id.ll_qq1);
    }

    @Override
    public TextView getTVQQ1View() {
        return getViewById(R.id.tv_qq1);
    }

    @Override
    public RelativeLayout getRLQQ1View() {
        return getViewById(R.id.rl_qq1);
    }

    @Override
    public LinearLayout getLLQQ2View() {
        return getViewById(R.id.ll_qq2);
    }

    @Override
    public TextView getTVQQ2View() {
        return getViewById(R.id.tv_qq2);
    }

    @Override
    public RelativeLayout getRLQQ2View() {
        return getViewById(R.id.rl_qq2);
    }

    @Override
    public LinearLayout getLLWeiXinView() {
        return getViewById(R.id.ll_weixin);
    }

    @Override
    public TextView getTVWeiXinView() {
        return getViewById(R.id.tv_weixin);
    }

    @Override
    public RelativeLayout getRLWeiXinView() {
        return getViewById(R.id.rl_weixin);
    }
}
