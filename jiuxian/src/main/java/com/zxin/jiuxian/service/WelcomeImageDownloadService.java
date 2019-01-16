package com.zxin.jiuxian.service;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import com.zxin.jiuxian.bean.LaunchPageInfoResult;
import com.zxin.jiuxian.mvp.presenter.MainPresenter;
import com.zxin.jiuxian.mvp.view.MainContract;
import com.zxin.jiuxian.util.HtmlJiuXianJumpUtil;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.view.dialog.BaseNiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialogViewHolder;
import com.zxin.zxinlib.view.dialog.ViewConvertListener;
import com.zxin.jiuxian.R;

/**
 * Created by Administrator on 2018/8/28.
 */

public class WelcomeImageDownloadService extends BaseService implements MainContract.WelcomeImageServiceListener {
    @InjectPresenter
    MainPresenter presenter;

    private NiceDialog niceDialog;

    @Override
    public void initData() {
        if (niceDialog == null) {
            niceDialog = NiceDialog.init();
        }
        niceDialog.setLayoutId(R.layout.service_welcome).setDimAmount(0.3f).setShowBottom(false);
        presenter.initWelcomeServiceDatas(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        presenter.openImage();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void loadBannerResult(final LaunchPageInfoResult launchInfo) {
        if (launchInfo == null) {
            stopSelf();
            return;
        }
        niceDialog.setConvertListener(new ViewConvertListener() {
            @Override
            public void convertView(final NiceDialogViewHolder holder, final BaseNiceDialog dialog) {
                if (!StringUtils.textIsEmpty(launchInfo.imageMap.url)) {
                    ImageUtil.loadImageViewLoding(getApplicationContext(), launchInfo.imageMap.url, holder.<ImageView>getView(R.id.iv_mainbanner), R.mipmap.default_iamge, R.drawable.icon_nullcate);
                    //倒计时
                    final CountDownTimer timer = new CountDownTimer(10000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            holder.setText(R.id.tv_mainbanner, millisUntilFinished / 1000 + "s  跳过");
                        }

                        @Override
                        public void onFinish() {
                            dialog.dismiss();
                        }
                    };
                    holder.setOnClickListener(R.id.iv_mainbanner, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            HtmlJiuXianJumpUtil.toJiuXianWebForUrlActivity("广告", launchInfo.imageMap.gotoUrl);
                            dialog.dismiss();
                            timer.onFinish();
                        }
                    });
                    holder.setOnClickListener(R.id.tv_mainbanner, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            timer.onFinish();
                        }
                    });
                    timer.start();
                }
            }
        }).show();
        stopSelf();
    }
}
