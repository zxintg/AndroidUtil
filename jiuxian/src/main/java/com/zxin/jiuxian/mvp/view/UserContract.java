package com.zxin.jiuxian.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.activity.IdeaFeedbackActivity;
import com.zxin.jiuxian.bean.ClubUserProduct;
import com.zxin.jiuxian.bean.LoginInfoResult;
import com.zxin.jiuxian.bean.UserCenterModuleData;
import com.zxin.jiuxian.bean.UserCenterResult;
import com.zxin.jiuxian.mvp.presenter.UserPresenter;
import com.zxin.jiuxian.util.JiuXianSharedPreferences;
import com.zxin.jiuxian.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SharedPreferencesManager;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class UserContract implements IBaseView {
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void loadDatas() {

    }


    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        LoginInfoResult infoResult = (LoginInfoResult) bean;
        JiuXianSharedPreferences.token(infoResult.mUserInfo.mToken);
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
        if (v.getId() == R.id.login_btn) {
            if (StringUtils.textIsEmpty(iPasswordLoginView.getEDTMobileView().getText().toString())) {
                ToastUtil.showShort("请填写手机号码");
                return;
            }
            if (StringUtils.textIsEmpty(iPasswordLoginView.getEDTPasswordView().getText().toString())) {
                ToastUtil.showShort("请填写密码");
                return;
            }
            presenter.passwordLogin(iPasswordLoginView.getEDTMobileView().getText().toString(), iPasswordLoginView.getEDTPasswordView().getText().toString());
        }
    }

    private PasswordLoginView iPasswordLoginView;

    public void setPasswordLoginView(PasswordLoginView iPasswordLoginView) {
        this.iPasswordLoginView = iPasswordLoginView;
    }

    public interface PasswordLoginView {
        EditText getEDTMobileView();

        EditText getEDTPasswordView();
    }

    private MineView iMineView;

    public void setMineView(MineView iMineView) {
        this.iMineView = iMineView;
    }

    public interface MineView {
        RefreshCommonView getRefreshCommonView();

        LinearLayout getHeadNotLoginView();

        RelativeLayout getHeadLoginView();

        TextView getAccountMoneyView();

        TextView getBackMoneyView();

        TextView getCouponView();

        TextView getGoldMoneyView();

        ImageView getCollectView();

        TextView getCollectCountView();

        ImageView getBrowseView();

        TextView getBrowseCountView();

        ImageView getChannelView();

        TextView getExchangeCountView();

        RecyclerView getModuleListView();

        RecyclerView getRecommondListView();
    }

    private List<UserCenterModuleData.ModuleData> clubCollectList = new ArrayList<>();
    private List<ClubUserProduct.Product> moduleList = new ArrayList<>();
    private SimpleAdapter clubCollectAdapter, moduleAdapter;

    public void initMineViewDatas() {
        iMineView.getRefreshCommonView().setIsAutoLoad(false);
        iMineView.getRefreshCommonView().setIsLoadMore(false);

        clubCollectList.clear();

        iMineView.getModuleListView().setLayoutManager(UiUtils.getGridLayoutManager(4));
        iMineView.getModuleListView().setNestedScrollingEnabled(false);
        clubCollectAdapter = new SimpleAdapter<UserCenterModuleData.ModuleData>(mContext, clubCollectList, R.layout.item_club_module_adapter_view) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final UserCenterModuleData.ModuleData moduleData) {
                holder.setText(R.id.name, moduleData.mName);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (moduleData.mType) {
                            case "TEL":
                                if (moduleData.mName.equals(UiUtils.getString(R.string.jiujiu_click_hot_line))) {
                                    //jiujiu_click_mine_hot_line
                                } else if (moduleData.mName.equals(UiUtils.getString(R.string.jiujiu_click_zhaoshan))) {
                                    //jiujiu_click_mine_zhaoshang
                                }
                                break;

                            case "INNER_LINK":
                                HtmlJumpUtil.toWebForUrlActivity(moduleData.mName, moduleData.mUrl);
                                break;

                            case "OUTER_LINK":
                                //jiujiu_click_mine_jiukuaidao
                                break;

                            case "NATIVE":
                                if ("FEEDBACK_KEY".equals(moduleData.mKey)) {
                                    mContext.startActivity(new Intent(mContext, IdeaFeedbackActivity.class));
                                }
                                break;

                            default:
                                HtmlJumpUtil.toWebForUrlActivity(moduleData.mName, moduleData.mUrl);
                                break;

                        }
                    }
                });
                ImageUtil.loadImageViewLoding(mContext, moduleData.mImageUrl, holder.<ImageView>getView(R.id.imageview), R.drawable.icon_club_default_product, R.drawable.icon_club_default_product);
            }
        };
        iMineView.getModuleListView().setAdapter(clubCollectAdapter);

        iMineView.getRecommondListView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
        moduleAdapter = new SimpleAdapter<ClubUserProduct.Product>(mContext, moduleList, R.layout.horizontal_winelist_gallery_item) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final ClubUserProduct.Product product) {
                if (product.mClubPrice > 0.0D) {
                    holder.setText(R.id.club_price, StringUtils.formatPriceE(product.mClubPrice))
                            .setVisible(R.id.club_price, true);
                } else {
                    holder.setVisible(R.id.club_price, false);
                }
                holder.setText(R.id.price, StringUtils.formatPriceA(product.mPrice));
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                ImageUtil.loadImageViewLoding(mContext, product.mImgPath, holder.<ImageView>getView(R.id.id_index_gallery_item_image), R.drawable.default_img, R.drawable.default_img);
            }
        };
        iMineView.getRecommondListView().setAdapter(moduleAdapter);

        iMineView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getModuleData();
                presenter.getWinebibber();
            }

            @Override
            public void startLoadMore() {

            }
        });
    }

    private boolean isZeroCount(String count) {
        if (StringUtils.textIsEmpty(count) && count.equals("0"))
            return true;
        int num = Integer.parseInt(count);
        return num != 32 && num != 9 && num != 13 && num != 10;
    }

    public void onResultMineViewSuccess(Object bean) {
        iMineView.getRefreshCommonView().finishRefresh();
        if (bean == null)
            return;

        if (bean instanceof UserCenterModuleData) {

        }

        if (bean instanceof UserCenterResult) {
            /*UserCenterResult centerResult = (UserCenterResult) bean;
            paramViewGroup.f.setVisibility(0);
            a(paramViewGroup.a, paramClubCollect.mCollCount);
            a(paramViewGroup.b, paramClubCollect.mBrowseCount);
            if ((!isZeroCount(paramClubCollect.mExchangeCount)) && (!"0".equals(paramClubCollect.mExchangeCount))) {
                paramViewGroup.e.setVisibility(0);
                paramViewGroup.e.setText(paramClubCollect.mExchangeCount);
                if (paramClubCollect.mExchangeCount.length() > 1) {
                    paramViewGroup.e.setBackgroundResource(2131231388);
                } else {
                    paramViewGroup.e.setBackgroundResource(2131232013);
                }
            } else {
                paramViewGroup.e.setVisibility(8);
            }*/
        }

        if (bean instanceof ClubUserProduct) {

        }
    }

}
