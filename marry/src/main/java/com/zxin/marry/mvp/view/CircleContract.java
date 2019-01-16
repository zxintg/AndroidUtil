package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.common.camera.callback.IPhotoCall;
import com.common.camera.utils.CameraAlbumUtils;
import com.common.camera.utils.VanCropType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.HomeCircleActivity;
import com.zxin.marry.activity.InputTopicActivity;
import com.zxin.marry.activity.ProductDetailActivity;
import com.zxin.marry.activity.SubjectDetailActivity;
import com.zxin.marry.activity.TopicActivity;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.GiftBean;
import com.zxin.marry.bean.LabelForm;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.marry.bean.SubjectDetailForm;
import com.zxin.marry.bean.SubjectForm;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.mvp.presenter.CirclePresenter;
import com.zxin.marry.util.AdvItemClickListener;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.util.TitleBarUtil;
import com.zxin.marry.view.BannerHolderView;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;
import com.zxin.zxinlib.view.RefreshCommonView;
import com.zxin.zxinlib.view.dialog.BaseNiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialogViewHolder;
import com.zxin.zxinlib.view.dialog.ViewConvertListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class CircleContract implements IBaseView {
    private SimpleAdapter adapter;
    private List<CircleForm.Circle> meiziTuList = new ArrayList<>();
    private Context mContext;

    @Override
    public void setParameter(Object... parameter) {

    }

    @Override
    public void initDatas() {
        meiziTuList.clear();
        adapter = new SimpleAdapter<CircleForm.Circle>(mContext, meiziTuList, R.layout.item_all_circle) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final CircleForm.Circle data) {
                holder.setText(R.id.tv_title, data.getCircle_name())
                        .setText(R.id.tv_describe, data.getCircle_desc())
                        .setText(R.id.tv_count, data.getCircle_thcount() + "个");
                ImageUtil.loadImageViewLoding(mContext, data.getCircle_smallimg(), holder.<ImageView>getView(R.id.imageView), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, HomeCircleActivity.class);
                        intent.putExtra("Circle", data);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iCircleView.getRefreshCommonView().setRecyclerViewAdapter(adapter);
        iCircleView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum = 1;

            @Override
            public void startRefresh() {
                pageNum = 1;
                meiziTuList.clear();
                presenter.getCircleList(pageNum);
            }

            @Override
            public void startLoadMore() {
                pageNum++;
                presenter.getCircleList(pageNum);
            }
        });
    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void onResultSuccess(Object bean) {
        iCircleView.getRefreshCommonView().finishRefresh();
        iCircleView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        CircleForm circleForm = (CircleForm) bean;
        meiziTuList.addAll(circleForm.getData());
        if (meiziTuList.isEmpty()) {
            meiziTuList.clear();
            iCircleView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iCircleView.getRefreshCommonView().setIsEmpty(false);
            iCircleView.getRefreshCommonView().setIsLoadMore(circleForm.getData().size() == 10);
        }
        adapter.notifyDataSetChanged();
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

    private CirclePresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (CirclePresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private MainCircleView iCircleView;

    public void setMainCircleViewListener(MainCircleView iCircleView) {
        this.iCircleView = iCircleView;
    }

    public interface MainCircleView {
        RefreshCommonView getRefreshCommonView();
    }


    private HomeCircleView iHomeCircleView;

    public void setHomeCircleViewListener(HomeCircleView iHomeCircleView) {
        this.iHomeCircleView = iHomeCircleView;
    }

    public interface HomeCircleView {
        AppBarLayout getAppBarLayoutView();

        SimpleDraweeView getIVTopView();

        TextView getTVTitleView();

        TextView getTVCountView();

        TextView getTVDescribeView();

        Toolbar getToolbarView();

        CommonCrosswiseBar getCommonCrosswiseBarView();

        PagerSlidingTabStrip getPagerSlidingTabStripView();

        ViewPager getViewPagerView();
    }

    private CircleForm.Circle mCircle;

    public void setHomeCircleViewParameter(Object... parameter) {
        mCircle = (CircleForm.Circle) parameter[0];
    }

    private float lastAlpha = 0;

    public void initHomeCircleViewDatas() {
        iHomeCircleView.getCommonCrosswiseBarView().setTitleText(mCircle.getCircle_name());
        iHomeCircleView.getTVTitleView().setText(mCircle.getCircle_name());
        iHomeCircleView.getTVCountView().setText("话题 :" + mCircle.getCircle_thcount() + "个");
        iHomeCircleView.getTVDescribeView().setText(mCircle.getCircle_desc());
        ImageUtil.loadImageViewLoding(mContext, mCircle.getCircle_smallimg(), iHomeCircleView.getIVTopView(), R.mipmap.default_iamge, R.mipmap.default_iamge);
        iHomeCircleView.getIVTopView().setAspectRatio(2.12F);

        iHomeCircleView.getAppBarLayoutView().addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int dy) {
                float alpha = (float) Math.abs(dy) / iHomeCircleView.getIVTopView().getMeasuredHeight();
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
            iHomeCircleView.getCommonCrosswiseBarView().setLeftButton(R.drawable.icon_back);
            iHomeCircleView.getCommonCrosswiseBarView().setBGColor(R.color.main_title_background);
        } else {
            iHomeCircleView.getCommonCrosswiseBarView().setLeftButton(R.drawable.gray_back);
            iHomeCircleView.getCommonCrosswiseBarView().setBGColor(R.color.color_00000000);
        }
        iHomeCircleView.getCommonCrosswiseBarView().setViewAlpha(alpha);
    }

    private ArrayList<MainBarBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;

    public void onResultHomeCircleListSuccess(Object bean) {
        if (bean == null)
            return;
        TopicForm topicForm = (TopicForm) bean;
        List<LabelForm.Label> labelList = topicForm.getData().getThclasses();
        labelList.add(0, new LabelForm.Label("0", "所有"));
        titleList.clear();
        mFragmentList.clear();
        iHomeCircleView.getViewPagerView().removeAllViews();
        titleList.addAll(TitleBarUtil.newInstance().getHomeCircleTitle(mCircle, labelList));
        for (MainBarBean bar : titleList) {
            mFragmentList.add(bar.fragment);
        }

        pageAdapter = new ViewPageFragmentAdapter(mFragmentList, titleList);
        iHomeCircleView.getViewPagerView().setCurrentItem(0);
        iHomeCircleView.getViewPagerView().setAdapter(pageAdapter);
        iHomeCircleView.getViewPagerView().setOffscreenPageLimit(titleList.size());
        iHomeCircleView.getPagerSlidingTabStripView().setViewPager(iHomeCircleView.getViewPagerView());
    }


    private HomeCircleItemView iHomeCircleItemView;

    public void setHomeCircleItemViewListener(HomeCircleItemView iHomeCircleItemView) {
        this.iHomeCircleItemView = iHomeCircleItemView;
    }

    public interface HomeCircleItemView {
        ConvenientBanner getConvenientBannerView();

        RecyclerView getRecyclerView();

        RefreshCommonView getRefreshCommonView();
    }

    private String titleId;
    public void setHomeCircleItemViewParameter(Object... obj) {
        mCircle = (CircleForm.Circle) obj[0];
        titleId = (String) obj[1];
    }

    private SimpleAdapter middleAdapter, circleAdapter;
    private List<TopicForm.Theme> themeList = new ArrayList<>();
    private List<TopicForm.Theme> circleList = new ArrayList<>();
    private List<RecommendForm.RecommendAdv> adList = new ArrayList<>();

    public void initHomeCircleItemViewDatas() {
        adList.clear();
        themeList.clear();
        circleList.clear();

        iHomeCircleItemView.getConvenientBannerView().startTurning(5000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iHomeCircleItemView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adList);
        iHomeCircleItemView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adList));

        iHomeCircleItemView.getRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iHomeCircleItemView.getRecyclerView().setNestedScrollingEnabled(false);
        middleAdapter = new SimpleAdapter<TopicForm.Theme>(mContext, themeList, R.layout.item_middle_circle) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final TopicForm.Theme localCircle) {
                holder.setText(R.id.title, localCircle.getTheme_name())
                        .setVisible(R.id.item_middle_line, themeList.indexOf(localCircle) == themeList.size() - 1);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, TopicActivity.class);
                        intent.putExtra("Theme", localCircle);
                        intent.putExtra("CircleId", localCircle.getCircle_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iHomeCircleItemView.getRecyclerView().setAdapter(middleAdapter);

        circleAdapter = new SimpleAdapter<TopicForm.Theme>(mContext, circleList, R.layout.item_marriage_circle) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final TopicForm.Theme data) {
                Drawable digest = UiUtils.getDrawable(R.drawable.digest);
                digest.setBounds(0, 0, digest.getIntrinsicWidth(), digest.getIntrinsicHeight());
                SpannableStringBuilder builder = new SpannableStringBuilder("占位" + data.getTheme_name());
                builder.setSpan(digest, 0, 1, 33);
                builder.setSpan(new ForegroundColorSpan(-1), 1, 2, 33);
                builder.setSpan(new AbsoluteSizeSpan(20), 1, 2, 33);
                holder.setText(R.id.tv_title, builder)
                        .setText(R.id.tv_content, data.getTheme_content())
                        .setText(R.id.tv_author, data.getMember_name())
                        .setText(R.id.tv_laud, data.getTheme_likecount())
                        .setText(R.id.tv_reply, data.getTheme_commentcount())
                        .setVisible(R.id.imageView, data.getHas_affix() == 1);
                ImageUtil.loadImageViewLoding(mContext, data.getHas_affix_url(), holder.<ImageView>getView(R.id.imageView), R.mipmap.default_iamge, R.mipmap.default_iamge);
                ImageUtil.loadCircleImageView(mContext, data.getMember_avatar(), holder.<ImageView>getView(R.id.civ), R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, TopicActivity.class);
                        intent.putExtra("Theme", data);
                        intent.putExtra("CircleId", data.getCircle_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iHomeCircleItemView.getRefreshCommonView().setRecyclerViewAdapter(circleAdapter);
        iHomeCircleItemView.getRefreshCommonView().setIsAutoLoad(false);
        iHomeCircleItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum = 1;

            @Override
            public void startRefresh() {
                pageNum = 1;
                adList.clear();
                themeList.clear();
                circleList.clear();
                presenter.getCircleItemList(pageNum, "up", null, mCircle.getCircle_id(), titleId);
            }

            @Override
            public void startLoadMore() {
                presenter.getCircleItemList(++pageNum, "down", topicForm.getPagedefault().getPagetime(), mCircle.getCircle_id(), titleId);
            }
        });

    }

    private TopicForm topicForm;

    public void onResultCircleItemListSuccess(Object obj) {
        iHomeCircleItemView.getRefreshCommonView().finishRefresh();
        iHomeCircleItemView.getRefreshCommonView().finishLoadMore();
        if (obj == null)
            return;
        topicForm = (TopicForm) obj;
        adList.addAll(topicForm.getData().getAdv());
        if (adList == null || adList.isEmpty()) {
            iHomeCircleItemView.getConvenientBannerView().setVisibility(View.GONE);
        } else {
            iHomeCircleItemView.getConvenientBannerView().setVisibility(View.VISIBLE);
            iHomeCircleItemView.getConvenientBannerView().notifyDataSetChanged();
        }
        themeList.addAll(topicForm.getData().getStick_themes());
        middleAdapter.notifyDataSetChanged();

        circleList.addAll(topicForm.getData().getThemes());
        if (circleList == null || circleList.isEmpty()) {
            circleList.clear();
            iHomeCircleItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iHomeCircleItemView.getRefreshCommonView().setIsEmpty(false);
            iHomeCircleItemView.getRefreshCommonView().setIsLoadMore(topicForm.getData().getThemes().size() == topicForm.getPagedefault().getPagenumber());
        }
        circleAdapter.notifyDataSetChanged();
    }

    public void onResultCheckNickSuccess(Object obj) {
        if (obj == null)
            return;
        TopicDetailForm topic = (TopicDetailForm) obj;
        if (topic.getCode() == 1) {
            Intent intent = new Intent(mContext, InputTopicActivity.class);
            intent.putExtra("Circle", mCircle);
            mContext.startActivity(intent);
            return;
        }
        if (topic.getCode() == 1000) {
            nickImageDialog(topic);
        }
    }

    private NiceDialog niceDialog;

    private void nickImageDialog(final TopicDetailForm topic) {
        if (niceDialog == null)
            niceDialog = NiceDialog.init();
        niceDialog.setLayoutId(R.layout.dialog_nick_image)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(NiceDialogViewHolder holder, final BaseNiceDialog dialog) {
                        final EditText mEtNick = holder.getView(R.id.et_nick);
                        final ImageView civ = holder.getView(R.id.civ);
                        ImageUtil.loadCircleImageView(mContext,topic.getData().getAvatar(), holder.<ImageView>getView(R.id.civ), R.mipmap.default_iamge);
                        holder.setOnClickListener(R.id.iv_cancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colseDialog();
                            }
                        });
                        holder.setOnClickListener(R.id.civ, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                CameraAlbumUtils.getInstance(mContext).setIPhotoCall(new IPhotoCall(){

                                    @Override
                                    public void onPhotoResult(String photoUrl) {
                                        ImageUtil.setItemRoundImageViewOnlyDisplay(civ, photoUrl);
                                    }
                                }).getPhoto().setTailorType(VanCropType.CROP_TYPE_CIRCLE).setSuperRotate(true).setParam(SystemInfoUtil.getScreenWidth()-10,SystemInfoUtil.getScreenWidth()-10);
                            }
                        });
                        holder.setOnClickListener(R.id.btn_submit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mEtNick.getText().toString().trim().isEmpty()) {
                                    ToastUtil.showShort( "请填写您的昵称");
                                    return;
                                }
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(false)
                .show();
    }

    private void colseDialog() {
        if (niceDialog != null && niceDialog.isVisible()) {
            niceDialog.dismiss();
        }
    }


    private SubjectListView iSubjectListView;

    public void setSubjectListViewListener(SubjectListView iSubjectListView) {
        this.iSubjectListView = iSubjectListView;
    }

    public interface SubjectListView {
        RefreshCommonView getRefreshCommonView();
    }

    private SimpleAdapter subjectAdapter;
    private List<SubjectForm.Subject> subjectList = new ArrayList<>();
    public void initSubjectListViewDatas(){
        subjectAdapter = new SimpleAdapter<SubjectForm.Subject>(mContext, subjectList, R.layout.item_subject_list) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final SubjectForm.Subject data) {
                ImageUtil.loadImageViewLoding(mContext, data.getPic_url(), holder.<ImageView>getView(R.id.sdv), R.mipmap.default_iamge, R.drawable.icon_default);
                RecyclerView recyclerView = holder.getView(R.id.dragRecyclerView);
                recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.HORIZONTAL));
                recyclerView.setAdapter(new SimpleAdapter<ShopClassBean.TaoBaoProduct>(mContext, data.getGoods(), R.layout.item_horizontal_subject_list) {
                    @Override
                    protected void onBindViewHolder(TrdViewHolder holder, final ShopClassBean.TaoBaoProduct product) {
                        holder.setText(R.id.tv_price, String.format("￥%s", new Object[] { product.getPromotion_price() }))
                                .setText(R.id.tv_primary_price, String.format("￥%s", new Object[] { product.getPrice() }));
                        TextPaint textPaint = holder.<TextView>getView(R.id.tv_primary_price).getPaint();
                        textPaint.setAntiAlias(true);
                        textPaint.setFlags(17);
                        ImageUtil.loadImageViewLoding(mContext, product.getPic_url(), holder.<ImageView>getView(R.id.imageView), R.mipmap.default_iamge, R.drawable.icon_default);
                        holder.setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                                intent.putExtra("TaoBaoProduct", product);
                                mContext.startActivity(intent);
                            }
                        });
                    }
                });

                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, SubjectDetailActivity.class);
                        intent.putExtra(SubjectForm.Subject.class.getSimpleName(), data);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iSubjectListView.getRefreshCommonView().setRecyclerViewAdapter(subjectAdapter);
        iSubjectListView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum = 1;

            @Override
            public void startRefresh() {
                pageNum = 1;
                subjectList.clear();
                presenter.getSubjectList(pageNum,"up",null);
            }

            @Override
            public void startLoadMore() {
                presenter.getSubjectList(++pageNum,"down",subjectForm.getPagedefault().getPagetime());
            }
        });
    }

    private SubjectForm subjectForm;
    public void onResultSubjectListSuccess(Object obj){
        iSubjectListView.getRefreshCommonView().finishRefresh();
        iSubjectListView.getRefreshCommonView().finishLoadMore();
        if (obj==null)
            return;
        subjectForm = (SubjectForm)obj;
        subjectList.addAll(subjectForm.getData());
        if (subjectList == null || subjectList.isEmpty()) {
            subjectList.clear();
            iSubjectListView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iSubjectListView.getRefreshCommonView().setIsEmpty(false);
            iSubjectListView.getRefreshCommonView().setIsLoadMore(subjectForm.getData().size() == Integer.parseInt(subjectForm.getPagedefault().getPagenumber()));
        }
        subjectAdapter.notifyDataSetChanged();
    }


    private SubjectDetailView iSubjectDetailView;

    public void setSubjectDetailViewListener(SubjectDetailView iSubjectDetailView) {
        this.iSubjectDetailView = iSubjectDetailView;
    }

    public interface SubjectDetailView {
        CommonCrosswiseBar getCommonCrosswiseBarView();
        RefreshCommonView getRefreshCommonView();
        ImageView getImageView();
        TextView getTitleView();
        TextView getCreateTimeView();
        TextView getTVDescribeView();
    }

    private SubjectForm.Subject mSubject;
    public void setSubjectDetailParameter(Object... obj) {
        mSubject = (SubjectForm.Subject) obj[0];
    }

    private List<ShopClassBean.TaoBaoProduct> productList = new ArrayList<>();
    private SimpleAdapter productAdapter;
    public void initSubjectDetailViewDatas() {
        productAdapter = new SimpleAdapter<ShopClassBean.TaoBaoProduct>(mContext, productList, R.layout.item_subject_detail) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ShopClassBean.TaoBaoProduct data) {
                holder.setText(R.id.tv_content,data.getContent())
                        .setText(R.id.tv_title,data.getTitle())
                        .setText(R.id.tv_title,data.getTitle())
                        .setText(R.id.tv_price, String.format("￥%s", new Object[] { data.getPromotion_price() }))
                        .setText(R.id.tv_primary_price, String.format("￥%s", new Object[] { data.getPrice() }))
                        .setVisible(R.id.tv_content, !StringUtils.textIsEmpty(data.getContent()))
                        .setVisible(R.id.ll_tao,data.getPic_url()!=null);

                TextPaint textPaint = holder.<TextView>getView(R.id.tv_primary_price).getPaint();
                textPaint.setAntiAlias(true);
                textPaint.setFlags(17);
                Drawable drawable = UiUtils.getDrawable("C".equals(data.getShop_type())?R.drawable.tao:R.drawable.mall);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                holder.<TextView>getView(R.id.tv_tao_type).setCompoundDrawables(drawable, null, null, null);

                ImageUtil.loadImageViewLoding(mContext, data.getPic_url(), holder.<ImageView>getView(R.id.imageView), R.mipmap.default_iamge, R.drawable.icon_default);

                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ProductDetailActivity.class);
                        intent.putExtra("TaoBaoProduct", data);
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iSubjectDetailView.getRefreshCommonView().setRecyclerViewAdapter(productAdapter);
        iSubjectDetailView.getRefreshCommonView().setIsLoadMore(false);
        iSubjectDetailView.getRefreshCommonView().setIsRefresh(false);
    }

    public void onResultSubjectDetailSuccess(Object obj){
        if (obj==null)
            return;
        SubjectDetailForm subjectDetail = (SubjectDetailForm)obj;
        productList.clear();
        productList.addAll(subjectDetail.getData().getGoods());
        productAdapter.notifyDataSetChanged();
        ImageUtil.loadImageViewLoding(mContext, subjectDetail.getData().getTopic().getPic_url(), iSubjectDetailView.getImageView(), R.mipmap.default_iamge, R.drawable.icon_default);
        iSubjectDetailView.getCommonCrosswiseBarView().setTitleText(subjectDetail.getData().getTopic().getTitle());
        iSubjectDetailView.getTitleView().setText(subjectDetail.getData().getTopic().getTitle());
        iSubjectDetailView.getCreateTimeView().setText(subjectDetail.getData().getTopic().getCreatetime());
        iSubjectDetailView.getTVDescribeView().setText(subjectDetail.getData().getTopic().getContent());
    }

}
