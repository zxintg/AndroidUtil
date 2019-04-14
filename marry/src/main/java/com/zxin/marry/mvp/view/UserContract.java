package com.zxin.marry.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zxin.marry.R;
import com.zxin.marry.bean.UserCommon;
import com.zxin.marry.mvp.presenter.UserPresenter;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/5/24.
 */

public class UserContract implements IBaseView {

    private Context mContext;
    @Override
    public void setParameter(Object... parameter) {

    }

    private MineMainView iView;

    public void setMineMainViewListener(MineMainView testView) {
        this.iView = testView;
    }

    public interface MineMainView {
        RefreshCommonView getRefreshCommonView();
        ImageView getUserHeadView();
        TextView getPhoneView();
        TextView getDateView();
    }

    @Override
    public void initDatas() {
        iView.getRefreshCommonView().setIsAutoLoad(false);
        iView.getRefreshCommonView().setIsLoadMore(false);
        iView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getUserInfo(SharedPreferencesManager.getMarryUid());
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        iView.getRefreshCommonView().finishRefresh();
        if (bean == null)
            return;
        UserCommon common = (UserCommon)bean;
        SharedPreferencesManager.setMarryUserInfo(common);
        if (common.getData()==null)
            return;
        ImageUtil.loadCircleImageView(mContext, common.getData().getAvatar(), iView.getUserHeadView(), R.mipmap.default_iamge);
        iView.getPhoneView().setText(TextUtils.isEmpty(common.getData().getUser_nicename())?common.getData().getUser_login():common.getData().getUser_nicename());
        iView.getDateView().setText("婚期:"+common.getData().getMarrydate());
    }

    @Override
    public void onAddResult(boolean bool) {

    }

    @Override
    public void onUpdateResult(boolean bool) {

    }

    @Override
    public void onDeleteResult(boolean bool) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    private UserPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (UserPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private MineUserCenterView iUserCenterView;

    public void setMineUserCenterViewListener(MineUserCenterView testView) {
        this.iUserCenterView = testView;
    }

    public interface MineUserCenterView {
        ImageView getUserHeadView();
        CommonCrosswiseBar getNickNameView();
        CommonCrosswiseBar getQianMingView();
        CommonCrosswiseBar getSexView();
        CommonCrosswiseBar getWeddingView();
        CommonCrosswiseBar getPhoneView();
    }

    public void setUserCenterParameter(Object... parameter) {

    }

    public void initUserCenterDatas() {
        UserCommon.User user = SharedPreferencesManager.getMarryUserInfo(UserCommon.class).getData();
        ImageUtil.loadCircleImageView(mContext, user.getAvatar(), iUserCenterView.getUserHeadView(), R.mipmap.default_iamge);
        iUserCenterView.getNickNameView().setRightText(TextUtils.isEmpty(user.getUser_nicename())?user.getUser_login():user.getUser_nicename());
        iUserCenterView.getQianMingView().setRightText(TextUtils.isEmpty(user.getSignature())?"请设置签名":user.getSignature());
        iUserCenterView.getSexView().setRightText(user.getSex());
        iUserCenterView.getWeddingView().setRightText(TextUtils.isEmpty(user.getMarrydate())?"请选择婚期":user.getMarrydate());
        iUserCenterView.getPhoneView().setRightText(user.getUser_login());
    }

    public void onUpdateUserSexs(Object bean){
        if (bean == null)
            return;
        ToastUtil.showShort("性别更改成功");
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11003);
        EventBus.getDefault().post(bundle);
    }

    public void onUpdateUserSexsFail() {
        iUserCenterView.getSexView().setRightText(SharedPreferencesManager.getMarryUserInfo(UserCommon.class).getData().getSex());
    }

}
