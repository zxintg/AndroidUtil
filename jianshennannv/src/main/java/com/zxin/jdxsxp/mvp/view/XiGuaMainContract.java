package com.zxin.jdxsxp.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxin.camera.model.PhotoPreviewBean;
import com.zxin.camera.utils.CameraAlbumUtils;
import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.activity.MainActivity;
import com.zxin.jdxsxp.activity.VideoPlayerActivity;
import com.zxin.jdxsxp.activity.UserInfoActivity;
import com.zxin.jdxsxp.activity.UserLoginActivity;
import com.zxin.jdxsxp.bean.AlbumModel;
import com.zxin.root.bean.DynamicModel;
import com.zxin.root.bean.DynamicResources;
import com.zxin.jdxsxp.bean.HomeTagModel;
import com.zxin.jdxsxp.bean.MainBarBean;
import com.zxin.jdxsxp.bean.OtherUserAlbumModel;
import com.zxin.jdxsxp.bean.OtherUserInfoTopModel;
import com.zxin.jdxsxp.bean.SearchListModel;
import com.zxin.jdxsxp.bean.SearchTagModel;
import com.zxin.jdxsxp.bean.UserAlbumModel;
import com.zxin.jdxsxp.bean.UserModel;
import com.zxin.root.bean.VideoPlayBean;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.util.MeiNvPicturePreferences;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.jdxsxp.util.TitleBarUtil;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.adapter.ViewPageFragmentAdapter;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.util.UiUtils;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.PagerSlidingTabStrip;
import com.zxin.root.view.RefreshCommonView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class XiGuaMainContract implements IBaseView {
    private Context mContext;

    private int tagId;

    @Override
    public void setParameter(Object... parameter) {
        tagId = (int) parameter[0];
    }

    @Override
    public void loadDatas() {

    }


    private UserLoginView iUserLoginView;

    public void setUserLoginView(UserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
    }

    public interface UserLoginView {
        EditText ed_phone();

        EditText ed_password();

        TextView btn_login();
    }

    public void initUserLoginDatas() {
        iUserLoginView.btn_login().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = iUserLoginView.ed_phone().getText().toString().trim();
                String pwd = iUserLoginView.ed_password().getText().toString().trim();
                if (StringUtils.textIsEmpty(phone)) {
                    ToastUtil.showShort("请填写账号！");
                    return;
                }
                if (StringUtils.textIsEmpty(pwd)) {
                    ToastUtil.showShort("请填写密码！");
                    return;
                }
                presenter.userLogin(phone, pwd);
            }
        });
    }

    public void onResultLoginSuccess(Object bean) {
        if (bean == null)
            return;
        UserModel userModel = (UserModel) bean;
        if (StringUtils.textIsEmpty(userModel.getToken())) {
            AppManager.getAppManager().finishCurrentActivity();
            return;
        }
        MeiNvPicturePreferences.setUserInfo(userModel);
        MeiNvPicturePreferences.setUserId(userModel.getUserId());
        AppCompatActivity activity = AppManager.getAppManager().currentActivity();
        activity.startActivity(new Intent(mContext, MainActivity.class));
        activity.onBackPressed();
    }


    private XiGuaMainView iXiGuaMainView;

    public void setXiGuaMainView(XiGuaMainView iXiGuaMainView) {
        this.iXiGuaMainView = iXiGuaMainView;
    }

    public interface XiGuaMainView {
        PagerSlidingTabStrip getPagerSlidingTabStrip();

        ViewPager getViewPager();
    }

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        titleList.addAll(TitleBarUtil.newInstance().getHomeTagList((List<HomeTagModel>) bean));
        for (MainBarBean titleBean : titleList) {
            mFragmentList.add(titleBean.fragment);
        }
        iXiGuaMainView.getViewPager().removeAllViews();
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        iXiGuaMainView.getViewPager().setCurrentItem(0);
        iXiGuaMainView.getViewPager().setAdapter(pageAdapter);
        iXiGuaMainView.getViewPager().setOffscreenPageLimit(titleList.size());
        iXiGuaMainView.getPagerSlidingTabStrip().setViewPager(iXiGuaMainView.getViewPager());
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

    private XiGuaMainPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (XiGuaMainPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private XiGuaMainItemView iXiGuaMainItemView;

    public void setXiGuaMainItemView(XiGuaMainItemView iXiGuaMainItemView) {
        this.iXiGuaMainItemView = iXiGuaMainItemView;
    }

    public interface XiGuaMainItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter meinvAdapter;
    private List<AlbumModel> albumList = new ArrayList<>();
    private int pageMeiNvNum = 1;

    @Override
    public void initDatas() {
        meinvAdapter = new SimpleAdapter<AlbumModel>(mContext, albumList, R.layout.adapter_portrait_item) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final AlbumModel localTheme) {
                holder.setText(R.id.iv_portrait_name, localTheme.getNick())
                        .setVisible(R.id.iv_portrait_v, localTheme.isHasCertification())
                        .setText(R.id.iv_portrait_look, StringUtils.getLookContent(localTheme.getBrowseCount()));
                ImageUtil.loadImageViewLoding(mContext, localTheme.getUrl(), holder.<ImageView>getView(R.id.iv_portrait_photo), R.mipmap.default_iamge);
                ImageUtil.loadCircleImageView(mContext, localTheme.getFace(), holder.<ImageView>getView(R.id.iv_portrait_head), R.mipmap.default_iamge);
                holder.setOnClickListener(R.id.iv_portrait_more, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, UserInfoActivity.class);
                        intent.putExtra("KD", localTheme.getUserId());
                        intent.putExtra("clickPosition", albumList.indexOf(localTheme));
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iXiGuaMainItemView.getRefreshCommonView().setIsAutoLoad(false);
        iXiGuaMainItemView.getRefreshCommonView().setRecyclerViewAdapter(meinvAdapter);
        iXiGuaMainItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                pageMeiNvNum = 1;
                albumList.clear();
                presenter.getHomeList(tagId, pageMeiNvNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getHomeList(tagId, ++pageMeiNvNum);
            }
        });
    }

    public void onResultMeiNvListSuccess(Object bean) {
        iXiGuaMainItemView.getRefreshCommonView().finishRefresh();
        iXiGuaMainItemView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        List<AlbumModel> list = (List<AlbumModel>) bean;
        albumList.addAll(list);
        if (albumList == null || albumList.isEmpty()) {
            albumList.clear();
            iXiGuaMainItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iXiGuaMainItemView.getRefreshCommonView().setIsEmpty(false);
            iXiGuaMainItemView.getRefreshCommonView().setIsLoadMore(list.size() >= 20);
        }
        meinvAdapter.notifyDataSetChanged();
    }

    private UserInfoView iUserInfoView;

    public void setUserInfoView(UserInfoView iUserInfoView) {
        this.iUserInfoView = iUserInfoView;
    }

    public interface UserInfoView {
        AppBarLayout getAppBarLayoutView();

        Toolbar getToolbarView();

        CommonCrosswiseBar getCommonCrosswiseBarView();

        ImageView iv_user_ivImage();

        RelativeLayout head_bg();

        ImageView image_user_info_head();

        ImageView iv_user_v();

        TextView tv_atten();

        LinearLayout layout_follow();

        TextView tv_city();

        LinearLayout layout_gift();

        TextView tv_bwh();

        LinearLayout layout_level();

        TextView tv_height();
    }

    private float lastAlpha = 0;

    public void initUserInfoDatas() {
        iUserInfoView.getAppBarLayoutView().addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int dy) {
                float alpha = (float) Math.abs(dy) / iUserInfoView.iv_user_ivImage().getMeasuredHeight();
                alpha = alpha > 1 ? 1 : alpha;
                if (lastAlpha == alpha)
                    return;
                lastAlpha = alpha;
                setCCBTitleAlpha(lastAlpha);
            }
        });
    }

    private void setCCBTitleAlpha(float alpha) {
        if (alpha > 0.6) {
            iUserInfoView.getCommonCrosswiseBarView().setLeftButton(R.drawable.ic_gf_back);
            iUserInfoView.getCommonCrosswiseBarView().setBGColor(R.color.color_ffffc600);
        } else {
            iUserInfoView.getCommonCrosswiseBarView().setLeftButton(R.drawable.back_pressed);
            iUserInfoView.getCommonCrosswiseBarView().setBGColor(R.color.color_00000000);
        }
        iUserInfoView.getCommonCrosswiseBarView().setViewAlpha(alpha);
    }

    public void onResultUserInfoSuccess(Object bean) {
        if (bean == null)
            return;
        OtherUserInfoTopModel userInfoModel = (OtherUserInfoTopModel) bean;
        ImageUtil.loadRSBlurImage(mContext, userInfoModel.getFace(), iUserInfoView.iv_user_ivImage(),20);
        ImageUtil.loadCircleImageView(mContext, userInfoModel.getFace(), iUserInfoView.image_user_info_head(), R.mipmap.default_iamge);
        iUserInfoView.getCommonCrosswiseBarView().setTitleText(userInfoModel.getNick());
        iUserInfoView.iv_user_v().setVisibility(userInfoModel.isHasCertification() ? View.VISIBLE : View.GONE);
        if (userInfoModel.isHasFocus()) {
            ImageUtil.setCompoundDrawable(iUserInfoView.tv_atten(), 20, R.drawable.icon_attened, Gravity.LEFT, 0);
        }
        iUserInfoView.tv_atten().setText(userInfoModel.getFocus() + "人已关注");
        if (userInfoModel.getCity() != null) {
            iUserInfoView.tv_city().setText(userInfoModel.getCity());
        }
        if (userInfoModel.getBwh() != null) {
            iUserInfoView.tv_bwh().setText(userInfoModel.getBwh());
        }
        if (userInfoModel.getHeight() != 0) {
            iUserInfoView.tv_height().setText(userInfoModel.getHeight() + "cm");
        }
    }

    private UserAttenView iUserAttenView;

    public void setUserAttenView(UserAttenView iUserAttenView) {
        this.iUserAttenView = iUserAttenView;
    }

    public interface UserAttenView {
        RefreshCommonView getRefreshCommonView();
    }

    private int toUserId;

    public void setUserAttenParameter(Object... parameter) {
        toUserId = (int) parameter[0];
    }

    private SimpleAdapter userAttenAdapter;
    private List<OtherUserAlbumModel> userAttenList = new ArrayList<>();
    private int userAttenNum = 1;

    public void initUserAttenDatas() {
        userAttenAdapter = new SimpleAdapter<OtherUserAlbumModel>(mContext, userAttenList, R.layout.adapter_atten_item) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final OtherUserAlbumModel localTheme) {
                holder.setText(R.id.text_user_nick, localTheme.getNick())
                        .setText(R.id.text_time, StringUtils.getDateTimer(localTheme.getUpdateTime()))
                        .setText(R.id.text_record, "已被" + localTheme.getBrowseCount() + "人浏览")
                        .setText(R.id.text_user_sign, localTheme.getDsc())
                        .setText(R.id.text_user_age, StringUtils.getBirthDays(localTheme.getBirth()) + "岁")
                        .setText(R.id.text_thumbs_count, String.valueOf(localTheme.getThumbCount()))
                        .setText(R.id.tv_comment, String.valueOf(localTheme.getCommentCount()))
                        .setBackgroundRes(R.id.text_user_sex_icon, localTheme.getSex() == 2 ? R.drawable.img_female : R.drawable.img_male)
                        .setVisible(R.id.tv_user_v, localTheme.isHasCertification());

                if (localTheme.getUrls() == null || localTheme.getUrls().isEmpty()) {
                    holder.setVisible(R.id.image_user_info, false);
                } else {
                    holder.setVisible(R.id.image_user_info, true);
                    ImageUtil.loadImageViewLoding(mContext, localTheme.getUrls().get(0), holder.<ImageView>getView(R.id.image_user_info_01), R.mipmap.default_iamge);
                    holder.setVisible(R.id.image_user_isvideo_01, localTheme.getType() == 2);
                    if (localTheme.getUrls().size() > 1) {
                        holder.setInVisible(R.id.rl_user_info_02, true);
                        ImageUtil.loadImageViewLoding(mContext, localTheme.getUrls().get(1), holder.<ImageView>getView(R.id.image_user_info_02), R.mipmap.default_iamge);
                        holder.setInVisible(R.id.image_user_isvideo_02, localTheme.getType() == 2);
                    } else
                        holder.setInVisible(R.id.rl_user_info_02, false);
                }
                holder.setOnClickListener(R.id.image_user_info_01, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (localTheme.getType() == 2) {
                            //mContext.startActivity(new Intent(mContext,HPlayerActivity.class).putExtra("ALBUM_INFO",new AlbumModel(localTheme)));
                            return;
                        }
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = localTheme.getUrls().size();
                        previewBean.index = 0;
                        previewBean.content = localTheme.getDsc();
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = localTheme.getCommentCount();
                        previewBean.zanNum = localTheme.getThumbCount();
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (String picTotalBean : localTheme.getUrls()) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean;
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
                holder.setOnClickListener(R.id.image_user_info_02, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = localTheme.getUrls().size();
                        previewBean.index = 1;
                        previewBean.content = localTheme.getDsc();
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = localTheme.getCommentCount();
                        previewBean.zanNum = localTheme.getThumbCount();
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (String picTotalBean : localTheme.getUrls()) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean;
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
                ImageUtil.loadCircleImageView(mContext, localTheme.getFace(), holder.<ImageView>getView(R.id.image_user_head), R.mipmap.default_iamge);
            }
        };
        iUserAttenView.getRefreshCommonView().setIsAutoLoad(false);
        iUserAttenView.getRefreshCommonView().setRecyclerViewAdapter(userAttenAdapter);
        iUserAttenView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                userAttenNum = 1;
                userAttenList.clear();
                presenter.getUserAttenList(toUserId, userAttenNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getUserAttenList(toUserId, ++userAttenNum);
            }
        });
    }

    public void onResultUserAttenSuccess(Object bean) {
        iUserAttenView.getRefreshCommonView().finishRefresh();
        iUserAttenView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        List<OtherUserAlbumModel> list = (List<OtherUserAlbumModel>) bean;
        userAttenList.addAll(list);
        if (userAttenList == null || userAttenList.isEmpty()) {
            userAttenList.clear();
            iUserAttenView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iUserAttenView.getRefreshCommonView().setIsEmpty(false);
            iUserAttenView.getRefreshCommonView().setIsLoadMore(list.size() >= 10 && userAttenNum < 10);
        }
        userAttenAdapter.notifyDataSetChanged();
    }


    private UserDynamicView iUserDynamicView;

    public void setUserDynamicView(UserDynamicView iUserDynamicView) {
        this.iUserDynamicView = iUserDynamicView;
    }

    public interface UserDynamicView {
        CommonCrosswiseBar getCommonCrosswiseBar();

        RefreshCommonView getRefreshCommonView();
    }

    public void setUserDynamicParameter(Object... parameter) {
        toUserId = (int) parameter[0];
    }

    private SimpleAdapter userDynamicAdapter;
    private List<DynamicModel> userDynamicList = new ArrayList<>();
    private int userDynamicNum = 1;

    public void initUserDynamicDatas() {
        iUserDynamicView.getCommonCrosswiseBar().setVisibility(toUserId == -1 ? View.VISIBLE : View.GONE);
        userDynamicAdapter = new SimpleAdapter<DynamicModel>(mContext, userDynamicList, R.layout.adapter_dynamic_list_item) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final DynamicModel localTheme) {
                holder.setText(R.id.tv_dynamic_nickname, localTheme.getNick())
                        .setText(R.id.tv_dynamic_time, StringUtils.getDateTimer(localTheme.getUpdateTime()))
                        .setText(R.id.tv_dynamic_browsecount, "已被" + localTheme.getBrowseCount() + "人浏览")
                        .setText(R.id.tv_dynamic_desc, localTheme.getDesc())
                        .setText(R.id.text_user_age, StringUtils.getBirthDays(localTheme.getBirth()) + "岁")
                        .setText(R.id.tv_dynamic_thumb, String.valueOf(localTheme.getThumbCount()))
                        .setText(R.id.tv_dynamic_comment, String.valueOf(localTheme.getCommentCount()))
                        .setBackgroundRes(R.id.text_user_sex_icon, localTheme.getSex() == 2 ? R.drawable.img_female : R.drawable.img_male)
                        .setVisible(R.id.iv_dynamic_v, localTheme.isHasCertification())
                        .setVisible(R.id.image_dynamic_info, localTheme.getDynamicResources() != null && localTheme.getDynamicResources().size() > 0 && localTheme.getDynamicResources().size() < 3)
                        .setVisible(R.id.rv_dynamic_content, localTheme.getDynamicResources() != null && localTheme.getDynamicResources().size() >= 3)
                        .setVisible(R.id.tv_dynamic_buycontent, localTheme.getBuyTotalGold() > 0)
                        .setText(R.id.tv_dynamic_buycontent, "已有" + localTheme.getBuyCount() + "人解锁，购买总金额" + localTheme.getBuyTotalGold() + "猫币")
                        .setText(R.id.tv_dynamic_reward, localTheme.getGold() + "猫币打赏");
                if (localTheme.getDynamicResources() == null || localTheme.getDynamicResources().isEmpty())
                    return;

                if (localTheme.getDynamicResources().size() < 3) {
                    ImageUtil.loadImageViewLoding(mContext, localTheme.getDynamicResources().get(0).getThumbnailUrl(), holder.<ImageView>getView(R.id.image_dynamic_info_01), R.mipmap.default_iamge);
                    holder.setVisible(R.id.rl_dynamic_info_01, true);
                    holder.setVisible(R.id.image_dynamic_isvideo_01, localTheme.getType() == 2);
                    if (localTheme.getDynamicResources().size() > 1) {
                        holder.setInVisible(R.id.rl_dynamic_info_02, true);
                        holder.setVisible(R.id.image_dynamic_isvideo_02, localTheme.getType() == 2);
                        ImageUtil.loadImageViewLoding(mContext, localTheme.getDynamicResources().get(1).getThumbnailUrl(), holder.<ImageView>getView(R.id.image_dynamic_info_02), R.mipmap.default_iamge);
                    } else
                        holder.setInVisible(R.id.rl_dynamic_info_02, false);

                    holder.setOnClickListener(R.id.rl_dynamic_info_01, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (localTheme.getType() == 2) {
                                VideoPlayBean album = new VideoPlayBean(localTheme);
                                mContext.startActivity(new Intent(mContext, VideoPlayerActivity.class).putExtra(StringUtils.ACTIVITY_DATA, album));
                                return;
                            }
                            PhotoPreviewBean previewBean = new PhotoPreviewBean();
                            previewBean.count = localTheme.getDynamicResources().size();
                            previewBean.index = 0;
                            previewBean.content = localTheme.getDesc();
                            previewBean.explain = "评论看看好不好呀！！！！";
                            previewBean.explainNum = localTheme.getCommentCount();
                            previewBean.zanNum = localTheme.getThumbCount();
                            List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                            for (DynamicResources picTotalBean : localTheme.getDynamicResources()) {
                                PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                                photoPreview.imageUrl = picTotalBean.getUrl();
                                list.add(photoPreview);
                            }
                            previewBean.photoList = list;
                            CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                        }
                    });
                    holder.setOnClickListener(R.id.rl_dynamic_info_02, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (localTheme.getType() == 2) {
                                VideoPlayBean album = new VideoPlayBean(localTheme);
                                mContext.startActivity(new Intent(mContext, VideoPlayerActivity.class).putExtra(StringUtils.ACTIVITY_DATA, album));
                                return;
                            }
                            PhotoPreviewBean previewBean = new PhotoPreviewBean();
                            previewBean.count = localTheme.getDynamicResources().size();
                            previewBean.index = 1;
                            previewBean.content = localTheme.getDesc();
                            previewBean.explain = "评论看看好不好呀！！！！";
                            previewBean.explainNum = localTheme.getCommentCount();
                            previewBean.zanNum = localTheme.getThumbCount();
                            List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                            for (DynamicResources picTotalBean : localTheme.getDynamicResources()) {
                                PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                                photoPreview.imageUrl = picTotalBean.getUrl();
                                list.add(photoPreview);
                            }
                            previewBean.photoList = list;
                            CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                        }
                    });
                } else {
                    RecyclerView recyclerView = holder.getView(R.id.rv_dynamic_content);
                    recyclerView.setLayoutManager(UiUtils.getGridLayoutManager(3));
                    recyclerView.setNestedScrollingEnabled(false);
                    recyclerView.setAdapter(new SimpleAdapter<DynamicResources>(mContext, localTheme.getDynamicResources(), R.layout.item_common_pic) {
                        @Override
                        protected void onBindViewHolder(TrdViewHolder holder, final DynamicResources product) {
                            holder.setVisible(R.id.iv_common_isvideo_img, localTheme.getType() == 2);
                            ImageUtil.loadImageViewLoding(mContext, product.getThumbnailUrl(), holder.<ImageView>getView(R.id.iv_common_img), R.mipmap.default_iamge, R.mipmap.error);
                            holder.setOnItemListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (localTheme.getType() == 2) {
                                        VideoPlayBean album = new VideoPlayBean(localTheme);
                                        mContext.startActivity(new Intent(mContext, VideoPlayerActivity.class).putExtra(StringUtils.ACTIVITY_DATA, album));
                                        return;
                                    }
                                    PhotoPreviewBean previewBean = new PhotoPreviewBean();
                                    previewBean.count = localTheme.getDynamicResources().size();
                                    previewBean.index = localTheme.getDynamicResources().indexOf(product);
                                    previewBean.content = localTheme.getDesc();
                                    previewBean.explain = "评论看看好不好呀！！！！";
                                    previewBean.explainNum = localTheme.getCommentCount();
                                    previewBean.zanNum = localTheme.getThumbCount();
                                    List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                                    for (DynamicResources picTotalBean : localTheme.getDynamicResources()) {
                                        PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                                        photoPreview.imageUrl = picTotalBean.getUrl();
                                        list.add(photoPreview);
                                    }
                                    previewBean.photoList = list;
                                    CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                                }
                            });
                        }
                    });
                }
                ImageUtil.loadCircleImageView(mContext, localTheme.getFace(), holder.<ImageView>getView(R.id.iv_dynamic_face), R.mipmap.default_iamge);

                if (toUserId != -1)
                    return;
                holder.setOnClickListener(R.id.rl_dynamic_info, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, UserInfoActivity.class);
                        intent.putExtra("KD", localTheme.getUserId());
                        intent.putExtra("clickPosition", userDynamicList.indexOf(localTheme));
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iUserDynamicView.getRefreshCommonView().setIsAutoLoad(false);
        iUserDynamicView.getRefreshCommonView().setRecyclerViewAdapter(userDynamicAdapter);
        iUserDynamicView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                userDynamicNum = 1;
                userDynamicList.clear();
                presenter.getUserDynamicList(toUserId, userDynamicNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getUserDynamicList(toUserId, ++userDynamicNum);
            }
        });
    }

    public void onResultUserDynamicSuccess(Object bean) {
        iUserDynamicView.getRefreshCommonView().finishRefresh();
        iUserDynamicView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        List<DynamicModel> list = (List<DynamicModel>) bean;
        userDynamicList.addAll(list);
        if (userDynamicList == null || userDynamicList.isEmpty()) {
            userDynamicList.clear();
            iUserDynamicView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iUserDynamicView.getRefreshCommonView().setIsEmpty(false);
            iUserDynamicView.getRefreshCommonView().setIsLoadMore(list.size() >= 10);
        }
        userDynamicAdapter.notifyDataSetChanged();
    }

    private VideoItemView iVideoItemView;

    public void setVideoItemView(VideoItemView iVideoItemView) {
        this.iVideoItemView = iVideoItemView;
    }

    public interface VideoItemView {
        RefreshCommonView getRefreshCommonView();
    }

    public void setVideoItemParameter(Object... parameter) {
        tagId = (int) parameter[0];
    }

    private SimpleAdapter videoItemAdapter;
    private List<AlbumModel> videoItemList = new ArrayList<>();
    private int videoItemNum = 1;

    public void initVideoItemDatas() {
        videoItemAdapter = new SimpleAdapter<AlbumModel>(mContext, videoItemList, R.layout.item_video) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final AlbumModel localTheme) {
                holder.setText(R.id.tv_video_name, localTheme.getNick() + " (" + localTheme.getTitle() + ")")
                        .setText(R.id.tv_video_timer, "片长：" + localTheme.getSize())
                        .setText(R.id.tv_video_thumnum, localTheme.getBrowseCount() + "人查看")
                        .setText(R.id.tv_video_reward, localTheme.getIsVr() == 1 ? "已关注" : "关注");
                ImageUtil.loadImageViewLoding(mContext, localTheme.getUrl(), holder.<ImageView>getView(R.id.iv_video_image), R.mipmap.default_iamge);
                /*holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext,HPlayerActivity.class).putExtra("ALBUM_INFO",localTheme));
                    }
                });*/
            }
        };
        iVideoItemView.getRefreshCommonView().setIsAutoLoad(false);
        iVideoItemView.getRefreshCommonView().setRecyclerViewAdapter(videoItemAdapter);
        iVideoItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                videoItemNum = 1;
                videoItemList.clear();
                presenter.getVideoItemList(tagId, videoItemNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getVideoItemList(tagId, ++videoItemNum);
            }
        });
    }

    public void onResultVideoItemSuccess(Object bean) {
        iVideoItemView.getRefreshCommonView().finishRefresh();
        iVideoItemView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        List<AlbumModel> list = (List<AlbumModel>) bean;
        videoItemList.addAll(list);
        if (videoItemList == null || videoItemList.isEmpty()) {
            videoItemList.clear();
            iVideoItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iVideoItemView.getRefreshCommonView().setIsEmpty(false);
            iVideoItemView.getRefreshCommonView().setIsLoadMore(list.size() >= 20);
        }
        videoItemAdapter.notifyDataSetChanged();
    }


    private HPlayerView iHPlayerView;

    public void setHPlayerView(HPlayerView iHPlayerView) {
        this.iHPlayerView = iHPlayerView;
    }

    public interface HPlayerView {
        IjkVideoView video_view();

        LinearLayout ll_bg();

        ImageView iv_trumb();

        LinearLayout app_video_replay();

        TextView app_video_status_text();

        TextView app_video_replay_icon();

        LinearLayout app_video_netTie();

        TextView app_video_netTie_icon();

        LinearLayout app_video_freeTie();

        TextView app_video_freeTie_icon();

        LinearLayout app_video_loading();

        TextView app_video_speed();

        RefreshCommonView getRefreshCommonView();

        TextView tv_video_title();

        TextView tv_video_playnum();

        TextView tv_video_thumcount();

        TextView tv_video_cllectcount();

        TextView tv_video_buy();

        TextView image_video_head();

        TextView tv_video_v();

        LinearLayout layout_video_1();

        TextView tv_video_nick();

        TextView tv_video_time();

        TextView tv_video_record();

        LinearLayout ll_video_more();

        RecyclerView rv_video_more();

        TextView tv_video_commentnum();

        View getLayoutView();
    }

    private AlbumModel albumModel;

    public void setHPlayerParameter(Object... parameter) {
        albumModel = (AlbumModel) parameter[0];
    }

    public void initHPlayerDatas() {
        PowerManager.WakeLock wakeLock = SystemInfoUtil.getPowerManager();
        wakeLock.acquire();
        player = new PlayerView(AppManager.getAppManager().currentActivity(), iHPlayerView.getLayoutView()) {
            @Override
            public PlayerView toggleProcessDurationOrientation() {
                hideSteam(getScreenOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                return setProcessDurationOrientation(getScreenOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ? PlayStateParams.PROCESS_PORTRAIT : PlayStateParams.PROCESS_LANDSCAPE);
            }

            @Override
            public PlayerView setPlaySource(List<VideoijkBean> list) {
                return super.setPlaySource(list);
            }
        }.setTitle("返回")
                .setProcessDurationOrientation(PlayStateParams.PROCESS_PORTRAIT)
                .setScaleType(PlayStateParams.fillparent)
                .forbidTouch(false)
                .hideSteam(true)
                .hideCenterPlayer(true)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        ImageUtil.loadImageViewLoding(mContext, albumModel.getUrl(), ivThumbnail, R.mipmap.default_iamge);
                    }
                }).setChargeTie(true, 60);
    }

    private List<VideoijkBean> videoList = new ArrayList<>();
    private PlayerView player;

    public void onResultBrowseVideoSuccess(Object bean) {
        if (bean == null) {
            mContext.startActivity(new Intent(mContext, UserLoginActivity.class));
            return;
        }
        UserAlbumModel userAlbumModel = (UserAlbumModel) bean;

        videoList.clear();
        for (String url : userAlbumModel.getUrls()) {
            VideoijkBean localVideoijkBean = new VideoijkBean();
            localVideoijkBean.setUrl(url);
            videoList.add(localVideoijkBean);
        }
        player.setPlaySource(videoList)
                .startPlay();
    }

    private SearchMeiTuView iSearchMeiTuView;

    public void setSearchMeiTuView(SearchMeiTuView iSearchMeiTuView) {
        this.iSearchMeiTuView = iSearchMeiTuView;
    }

    public interface SearchMeiTuView {
        DrawerLayout getDrawerLayoutView();

        LinearLayout ll_search_head();

        SearchView et_search_search();

        TextView tv_search_tags();

        PagerSlidingTabStrip getPagerSlidingTabStrip();

        ViewPager vp_search_content();

        TextView tv_search_history();

        RecyclerView rv_search_history();

        RecyclerView rv_search_hot();
    }

    private SimpleAdapter historyAdapter;
    private SimpleAdapter hotAdapter;
    private List<String> historyList = new ArrayList<>();
    //初始化
    public void initSearchMeiTuDatas() {
        iSearchMeiTuView.ll_search_head().setPadding(iSearchMeiTuView.ll_search_head().getPaddingLeft(), iSearchMeiTuView.ll_search_head().getPaddingTop() + SystemInfoUtil.getStatusBarHeight(), iSearchMeiTuView.ll_search_head().getPaddingRight(), iSearchMeiTuView.ll_search_head().getPaddingBottom());
        iSearchMeiTuView.getDrawerLayoutView().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        iSearchMeiTuView.tv_search_tags().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!iSearchMeiTuView.getDrawerLayoutView().isDrawerOpen(GravityCompat.END)) {
                    iSearchMeiTuView.getDrawerLayoutView().openDrawer(GravityCompat.END);
                }
            }
        });
        // 设置搜索文本监听
        iSearchMeiTuView.et_search_search().setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //当点击搜索按钮时触发该方法
                if (!historyList.contains(query)) {
                    historyList.add(query);
                    historyAdapter.notifyDataSetChanged();
                    MeiNvPicturePreferences.setSearchHistoryArr(historyList);
                }
                Bundle bundle = new Bundle();
                bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11021);
                bundle.putString(StringUtils.EVENT_DATA, query);
                EventBus.getDefault().post(bundle);
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                //当搜索内容改变时触发该方法
                return false;
            }
        });

        iSearchMeiTuView.tv_search_history().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeiNvPicturePreferences.clearSearchHistory();
                historyList.clear();
                iSearchMeiTuView.tv_search_history().setVisibility(View.GONE);
                iSearchMeiTuView.rv_search_history().setVisibility(View.GONE);
                historyAdapter.notifyDataSetChanged();
            }
        });

        ArrayList<MainBarBean> titleList = new ArrayList<>();
        List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
        titleList.addAll(TitleBarUtil.newInstance().getSearchTitleList());
        for (MainBarBean titleBean : titleList) {
            mFragmentList.add(titleBean.fragment);
        }
        iSearchMeiTuView.vp_search_content().removeAllViews();
        iSearchMeiTuView.vp_search_content().setCurrentItem(0);
        iSearchMeiTuView.vp_search_content().setAdapter(new ViewPageFragmentAdapter(mFragmentList, titleList));
        iSearchMeiTuView.vp_search_content().setOffscreenPageLimit(titleList.size());
        iSearchMeiTuView.getPagerSlidingTabStrip().setViewPager(iSearchMeiTuView.vp_search_content());

        iSearchMeiTuView.rv_search_history().setLayoutManager(UiUtils.getGridLayoutManager(3));
        historyAdapter = new SimpleAdapter<String>(mContext, historyList, R.layout.item_tag) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final String localTheme) {
                holder.setText(R.id.tv_tag_name, localTheme);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iSearchMeiTuView.getDrawerLayoutView().closeDrawer(GravityCompat.END);
                        Bundle bundle = new Bundle();
                        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11021);
                        bundle.putString(StringUtils.EVENT_DATA, localTheme);
                        EventBus.getDefault().post(bundle);
                    }
                });
            }
        };
        iSearchMeiTuView.rv_search_history().setNestedScrollingEnabled(false);
        iSearchMeiTuView.rv_search_history().setAdapter(historyAdapter);

        iSearchMeiTuView.rv_search_hot().setLayoutManager(UiUtils.getGridLayoutManager(3));
        hotAdapter = new SimpleAdapter<SearchTagModel>(mContext, dataList, R.layout.item_tag) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final SearchTagModel localTheme) {
                holder.setText(R.id.tv_tag_name, localTheme.getTitle());
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iSearchMeiTuView.getDrawerLayoutView().closeDrawer(GravityCompat.END);
                        Bundle bundle = new Bundle();
                        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11021);
                        bundle.putString(StringUtils.EVENT_DATA, localTheme.getTitle());
                        EventBus.getDefault().post(bundle);
                    }
                });
            }
        };
        iSearchMeiTuView.rv_search_hot().setNestedScrollingEnabled(false);
        iSearchMeiTuView.rv_search_hot().setAdapter(hotAdapter);
    }

    private List<SearchTagModel> dataList = new ArrayList();

    public void onResultHistoryTagsSuccess(Object bean) {
        if (bean == null) {
            return;
        }
        historyList.clear();
        historyList.addAll(MeiNvPicturePreferences.getSearchHistoryArr());
        if (historyList.isEmpty()) {
            iSearchMeiTuView.tv_search_history().setVisibility(View.GONE);
            iSearchMeiTuView.rv_search_history().setVisibility(View.GONE);
        } else {
            iSearchMeiTuView.tv_search_history().setVisibility(View.VISIBLE);
            iSearchMeiTuView.rv_search_history().setVisibility(View.VISIBLE);
            historyAdapter.notifyDataSetChanged();
        }
        dataList.clear();
        dataList.addAll((List<SearchTagModel>) bean);
        hotAdapter.notifyDataSetChanged();
    }

    private SearchItemView iSearchItemView;

    public void setSearchItemView(SearchItemView iSearchItemView) {
        this.iSearchItemView = iSearchItemView;
    }

    public interface SearchItemView {
        RefreshCommonView getRefreshCommonView();
    }

    private int searchTag;
    public void setSearchItemParameter(Object... parameter) {
        searchTag = (int) parameter[0];
    }

    private SimpleAdapter searchItemAdapter;
    private List<UserAlbumModel> searchItemList = new ArrayList<>();
    private int searchItemNum = 1;
    public void initSearchItemDatas(){
        searchItemAdapter = new SimpleAdapter<UserAlbumModel>(mContext, searchItemList, R.layout.item_search) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final UserAlbumModel localTheme) {
                holder.setText(R.id.tv_search_num, localTheme.getType() == 1?localTheme.getUrls().length + "张":localTheme.getSize())
                        .setText(R.id.tv_search_desc,localTheme.getDsc())
                        .setText(R.id.tv_search_time,StringUtils.getDateTimer(localTheme.getUpdateTime()))
                        .setText(R.id.tv_search_name, localTheme.getNick())
                        .setText(R.id.tv_search_play, "已播放"+localTheme.getBrowseCount()+"次");
                ImageUtil.loadImageViewLoding(mContext, localTheme.getUrls()[0], holder.<ImageView>getView(R.id.iv_search_image), R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (localTheme.getType() == 2) {
                            return;
                        }
                        PhotoPreviewBean previewBean = new PhotoPreviewBean();
                        previewBean.count = localTheme.getUrls().length;
                        previewBean.index = 0;
                        previewBean.content = localTheme.getDsc();
                        previewBean.explain = "评论看看好不好呀！！！！";
                        previewBean.explainNum = localTheme.getCommentCount();
                        previewBean.zanNum = localTheme.getThumbCount();
                        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
                        for (String picTotalBean : localTheme.getUrls()) {
                            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
                            photoPreview.imageUrl = picTotalBean;
                            list.add(photoPreview);
                        }
                        previewBean.photoList = list;
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(previewBean);
                    }
                });
            }
        };
        iSearchItemView.getRefreshCommonView().setIsAutoLoad(false);
        iSearchItemView.getRefreshCommonView().setRecyclerViewAdapter(searchItemAdapter);
        iSearchItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                searchItemNum = 1;
                searchItemList.clear();
                presenter.getSearchItemList(searchTag,keyWord, searchItemNum);
            }

            @Override
            public void startLoadMore() {
                presenter.getSearchItemList(searchTag,keyWord, ++searchItemNum);
            }
        });
    }

    private String keyWord="";
    public void searchItemDatasNotify(String keyWord){
        this.keyWord = keyWord;
        iSearchItemView.getRefreshCommonView().notifyData();
    }

    public void onResultSearchItemSuccess(Object bean) {
        iSearchItemView.getRefreshCommonView().finishRefresh();
        iSearchItemView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        SearchListModel list = (SearchListModel) bean;
        searchItemList.addAll(list.getAlbums());
        if (searchItemList == null || searchItemList.isEmpty()) {
            searchItemList.clear();
            iSearchItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iSearchItemView.getRefreshCommonView().setIsEmpty(false);
            iSearchItemView.getRefreshCommonView().setIsLoadMore(list.getAlbums().size() >= 20);
        }
        searchItemAdapter.notifyDataSetChanged();
    }

}
