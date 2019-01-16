package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zxin.marry.R;
import com.zxin.marry.activity.GoodsDetailsActivity;
import com.zxin.marry.activity.HotNewsDetailActivity;
import com.zxin.marry.activity.ProductDetailActivity;
import com.zxin.marry.activity.ShopCaseDetailsActivity;
import com.zxin.marry.activity.ShopDetailsActivity;
import com.zxin.marry.activity.TopicActivity;
import com.zxin.marry.bean.ArticlesBean;
import com.zxin.marry.bean.CircleForm;
import com.zxin.marry.bean.MainBarBean;
import com.zxin.marry.bean.PostsInfoBean;
import com.zxin.marry.bean.RecommendForm;
import com.zxin.marry.bean.ShopClassBean;
import com.zxin.marry.bean.TermsBean;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.fragment.topic.HotNewsItemFragment;
import com.zxin.marry.mvp.presenter.TopicPresenter;
import com.zxin.marry.util.AdvItemClickListener;
import com.zxin.marry.util.JsInterface;
import com.zxin.marry.util.StringUtils;
import com.zxin.marry.view.BannerHolderView;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.network.util.HtmlOperatorUtil;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.UiUtils;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.PagerSlidingTabStrip;
import com.zxin.zxinlib.view.RefreshCommonView;
import com.zxin.zxinlib.view.X5WebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class MainTopicContract implements IBaseView {
    private SimpleAdapter topicHeadAdapter, topicAdapter;
    private List<CircleForm.Affix> replyHeadList = new ArrayList<>();
    private List<TopicDetailForm.Reply> replyList = new ArrayList<>();
    private Context mContext;
    private TopicForm.Theme theme;

    @Override
    public void setParameter(Object... parameter) {
        theme = (TopicForm.Theme) parameter[0];
    }

    @Override
    public void initDatas() {
        iView.getHeadRecyclerView().setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        iView.getHeadRecyclerView().setNestedScrollingEnabled(false);
        topicHeadAdapter = new SimpleAdapter<CircleForm.Affix>(mContext, replyHeadList, R.layout.item_common_img) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final CircleForm.Affix affix) {
                ImageUtil.loadImageViewLoding(mContext, affix.getAffix_filethumb(), holder.<ImageView>getView(R.id.iv_common_image), R.drawable.icon_default, R.drawable.icon_default);
            }
        };
        iView.getHeadRecyclerView().setAdapter(topicHeadAdapter);

        topicAdapter = new SimpleAdapter<TopicDetailForm.Reply>(mContext, replyList, R.layout.item_topic) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final TopicDetailForm.Reply localTheme) {

                holder.setText(R.id.tv_nice, localTheme.getMember_name())
                        .setText(R.id.tv_reply_content, localTheme.getReply_content())
                        .setText(R.id.tv_day, localTheme.getReply_addtime())
                        .setText(R.id.tv_floor, String.valueOf(localTheme.getFloor_number()))
                        .setText(R.id.tv_floor_gray, localTheme.getReply_number())
                        .setText(R.id.tv_laud, localTheme.getReply_likecount())
                        .setVisible(R.id.view_topic_bottom,replyList.indexOf(localTheme)==replyList.size()-1);
                if (localTheme.getParent() != null) {
                    holder.setText(R.id.tv_nice_gray, localTheme.getParent().getMember_name())
                            .setText(R.id.tv_reply_content_gray, localTheme.getParent().getReply_content());
                }
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, TopicActivity.class);
                        intent.putExtra("Theme", localTheme);
                        intent.putExtra("CircleId", localTheme.getCircle_id());
                        mContext.startActivity(intent);
                    }
                });
                ImageUtil.loadCircleImageView(mContext, localTheme.getMember_avatar(), holder.<ImageView>getView(R.id.civ), R.mipmap.default_iamge);
                if (localTheme.getAffix() != null && !localTheme.getAffix().isEmpty())
                    ImageUtil.loadImageViewLoding(mContext, localTheme.getAffix().get(0).getAffix_filethumb(), holder.<ImageView>getView(R.id.iv_content), R.mipmap.default_iamge);
            }
        };

        iView.getRefreshCommonView().setRecyclerViewAdapter(topicAdapter);
        iView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            @Override
            public void startRefresh() {
                presenter.getTopicDetail(theme.getTheme_id());
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
        iView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        replyList.clear();
        TopicDetailForm datas = (TopicDetailForm) bean;
        setHeadViewDatas(datas.getData().getTheme());
        replyHeadList.clear();
        replyHeadList.addAll(datas.getData().getTheme().getAffix());
        iView.getHeadRecyclerView().setVisibility(replyHeadList == null || replyHeadList.isEmpty() ? View.GONE : View.VISIBLE);
        topicHeadAdapter.notifyDataSetChanged();

        replyList.addAll(datas.getData().getReply());
        iView.getRefreshCommonView().setIsEmpty(false);
        iView.getRefreshCommonView().setIsLoadMore(false);
        topicAdapter.notifyDataSetChanged();
    }

    private void setHeadViewDatas(CircleForm.Circle theme) {
        iView.getNickView().setText(theme.getMember_name());
        iView.getTitleView().setText(theme.getTheme_name());
        iView.getContentView().setText(StringUtils.textFormatHtml(theme.getTheme_content()));
        iView.getDayView().setText(theme.getTheme_addtime());
        iView.getLaudView().setText(theme.getTheme_likecount());
        iView.getReplyView().setText(theme.getTheme_commentcount());

        ImageUtil.loadCircleImageView(mContext, theme.getMember_avatar(), iView.getCivView(), R.mipmap.default_iamge);

        iView.getEssenceView().setVisibility(theme.getIs_digest() == 1 ? View.VISIBLE : View.GONE);
        iView.getRecommendView().setVisibility(theme.getIs_recommend() == 1 ? View.VISIBLE : View.GONE);

        List<String> tagList = new ArrayList<>();
        tagList.add(theme.getThclass_name());
        iView.getTagFlowLayoutView().setAdapter(new TagAdapter<String>(tagList) {
            @Override
            public View getView(FlowLayout parent, int position, String tag) {
                TextView textView = new TextView(mContext);
                textView.setPadding(20, 3, 20, 3);
                textView.setBackgroundResource(R.drawable.topic_shape);
                textView.setTextSize(2, 12.0F);
                textView.setTextColor(UiUtils.getColor(R.color.te64b50));
                textView.setText(tag);
                return textView;
            }
        });
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

    private TopicPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (TopicPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private MainTopicView iView;

    public void setMainTopicViewListener(MainTopicView testView) {
        this.iView = testView;
    }

    public interface MainTopicView {
        SimpleDraweeView getCivView();

        TextView getNickView();

        SimpleDraweeView getEssenceView();

        SimpleDraweeView getRecommendView();

        TextView getTitleView();

        TagFlowLayout getTagFlowLayoutView();

        TextView getContentView();

        RecyclerView getHeadRecyclerView();

        TextView getDayView();

        TextView getLaudView();

        TextView getReplyView();

        RefreshCommonView getRefreshCommonView();
    }

    private MineTopicView iMineTopicView;

    public void setMineTopicViewListener(MineTopicView iMineTopicView) {
        this.iMineTopicView = iMineTopicView;
    }

    public interface MineTopicView {
        RefreshCommonView getRefreshCommonView();
    }

    private String type;

    public void setMineTopicViewParameter(Object... parameter) {
        this.type = (String) parameter[0];
    }

    private SimpleAdapter mineTopicAdapter;
    private List<TopicForm.Theme> mineTopicList = new ArrayList<>();
    public void initMineTopicViewDatas() {
        mineTopicAdapter = new SimpleAdapter<TopicForm.Theme>(mContext, mineTopicList, R.layout.item_marriage_circle) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final TopicForm.Theme data) {
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

        iMineTopicView.getRefreshCommonView().setRecyclerViewAdapter(mineTopicAdapter);
        iMineTopicView.getRefreshCommonView().setIsAutoLoad(false);
        iMineTopicView.getRefreshCommonView().setEmptyText("暂无相关话题");
        iMineTopicView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum = 1;

            @Override
            public void startRefresh() {
                pageNum = 1;
                presenter.getMineTopicList(type, pageNum, null, "up");
            }

            @Override
            public void startLoadMore() {
                presenter.getMineTopicList(type, ++pageNum, topicForm.getPagedefault().getPagetime(), "down");
            }
        });
    }

    private TopicForm topicForm;

    public void onResultMineTopicListSuccess(Object bean) {
        iMineTopicView.getRefreshCommonView().finishRefresh();
        iMineTopicView.getRefreshCommonView().finishLoadMore();
        if (bean == null)
            return;
        topicForm = (TopicForm) bean;
        mineTopicList.addAll(topicForm.getData().getThemes());
        if (mineTopicList == null || mineTopicList.isEmpty()) {
            mineTopicList.clear();
            iMineTopicView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iMineTopicView.getRefreshCommonView().setIsEmpty(false);
            iMineTopicView.getRefreshCommonView().setIsLoadMore(topicForm.getData().getThemes().size() == topicForm.getPagedefault().getPagenumber());
        }
        mineTopicAdapter.notifyDataSetChanged();
    }


    private HotNewsDetailView iHotNewsDetailView;

    public void setHotNewsDetailViewListener(HotNewsDetailView iHotNewsDetailView) {
        this.iHotNewsDetailView = iHotNewsDetailView;
    }

    public interface HotNewsDetailView {
        CommonCrosswiseBar getCommonCrosswiseBarView();

        X5WebView getX5WebView();

        LinearLayout getMenuView();

        EditText getEDCommentsView();

        LinearLayout getLLNoFocusView();

        ImageView getIVPraiseView();

        TextView getTVPraiseCountView();

        TextView getTVCommentsCountView();

        TextView getTVSendView();
    }

    private String url, name, posts_id;

    public void setHotNewsDetailViewParameter(Object... parameter) {
        this.url = (String) parameter[0];
        this.name = (String) parameter[1];
        this.posts_id = (String) parameter[2];
    }

    public void initHotNewsDetailViewDatas() {
        iHotNewsDetailView.getCommonCrosswiseBarView().setTitleText(name);
        iHotNewsDetailView.getEDCommentsView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager pnput = (InputMethodManager) iHotNewsDetailView.getEDCommentsView().getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (hasFocus) {
                    iHotNewsDetailView.getLLNoFocusView().setVisibility(View.GONE);
                    iHotNewsDetailView.getTVSendView().setVisibility(View.VISIBLE);
                    pnput.toggleSoftInput(0, 2);
                    return;
                }
                iHotNewsDetailView.getLLNoFocusView().setVisibility(View.VISIBLE);
                iHotNewsDetailView.getTVSendView().setVisibility(View.GONE);
                pnput.hideSoftInputFromWindow(iHotNewsDetailView.getEDCommentsView().getWindowToken(), 0);
            }
        });
        iHotNewsDetailView.getX5WebView().loadUrl(url);
        iHotNewsDetailView.getX5WebView().addJavascriptInterface(new JsInterface(mContext), "AndroidWebView");
        presenter.getPostsInfo(posts_id);
    }

    public void onResultPostsInfoSuccess(Object obj) {
        if (obj == null)
            return;
        PostsInfoBean postInfo = (PostsInfoBean) obj;
        iHotNewsDetailView.getTVPraiseCountView().setText(postInfo.getPosts().getPost_like());
        iHotNewsDetailView.getTVCommentsCountView().setText(postInfo.getPosts().getComment_count());
        if (postInfo.getPosts().getLike_status().equals("1")) {
            iHotNewsDetailView.getIVPraiseView().setImageResource(R.drawable.ic_praise_un);
            iHotNewsDetailView.getTVPraiseCountView().setTextColor(UiUtils.getColor(R.color.text_e7));
        } else {
            iHotNewsDetailView.getIVPraiseView().setImageResource(R.drawable.ic_praise);
            iHotNewsDetailView.getTVPraiseCountView().setTextColor(UiUtils.getColor(R.color.color_666666));
        }
    }


    private HotNewsView iHotNewsView;

    public void setHotNewsViewListener(HotNewsView iHotNewsView) {
        this.iHotNewsView = iHotNewsView;
    }

    public interface HotNewsView {
        PagerSlidingTabStrip getPagerSlidingTabStripView();

        ViewPager getViewPagerView();
    }

    private ArrayList<TitleBean> titleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();//页卡视图集合
    private ViewPageFragmentAdapter pageAdapter;
    public void onResultHotNewsMenusSuccess(Object obj) {
        if (obj == null)
            return;
        titleList.clear();
        mFragmentList.clear();
        iHotNewsView.getViewPagerView().removeAllViews();

        TermsBean termsBean = (TermsBean) obj;
        for (TermsBean.Term term :termsBean.getTerms()){
            TitleBean titleBean = new TitleBean();
            titleBean.label = term.getName();
            titleBean.id2 = term.getTerm_id();
            titleList.add(titleBean);
            mFragmentList.add(HotNewsItemFragment.newInstance(titleBean.id2));
        }
        pageAdapter = new ViewPageFragmentAdapter(mFragmentList,titleList);
        iHotNewsView.getViewPagerView().setCurrentItem(0);
        iHotNewsView.getViewPagerView().setAdapter(pageAdapter);
        iHotNewsView.getViewPagerView().setOffscreenPageLimit(titleList.size());
        iHotNewsView.getPagerSlidingTabStripView().setViewPager(iHotNewsView.getViewPagerView());
    }

    private HotNewsItemView iHotNewsItemView;

    public void setHotNewsItemViewListener(HotNewsItemView iHotNewsItemView) {
        this.iHotNewsItemView = iHotNewsItemView;
    }

    public interface HotNewsItemView {
        ConvenientBanner getConvenientBannerView();
        RefreshCommonView getRefreshCommonView();
    }

    private  String term_id;
    public void setHotNewsItemViewParameter(Object... parameter) {
        term_id = (String) parameter[0];
    }

    private SimpleAdapter hotNewsAdapter;
    private List<ArticlesBean.Posts> hotNewsList = new ArrayList<>();
    private List<RecommendForm.RecommendAdv> adNationwideList = new ArrayList<>();
    public void initHotNewsItemViewDatas() {
        iHotNewsItemView.getConvenientBannerView().startTurning(3000L).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        iHotNewsItemView.getConvenientBannerView().setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, adNationwideList);
        iHotNewsItemView.getConvenientBannerView().setOnItemClickListener(new AdvItemClickListener(mContext, adNationwideList));
        hotNewsAdapter = new SimpleAdapter<ArticlesBean.Posts>(mContext, hotNewsList, R.layout.item_hotnews) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final ArticlesBean.Posts localPosts) {
                holder.setText(R.id.tv_praisecount, localPosts.getPost_like())
                        .setText(R.id.tv_commentcount, String.valueOf(localPosts.getComment_count()))
                        .setText(R.id.tv_title, localPosts.getPost_title())
                        .setText(R.id.tv_shopname, localPosts.getStore().getStore_name())
                        .setVisible(R.id.tv_recommendeds,localPosts.getRecommended().equals("1"))
                        .setVisible(R.id.ll_multiple,false)
                        .setVisible(R.id.type_line,hotNewsList.indexOf(localPosts)!=hotNewsList.size()-1)
                        .setVisible(R.id.item_line,hotNewsList.indexOf(localPosts)!=hotNewsList.size()-1)
                        .setVisible(R.id.ll_single,true);
                ImageUtil.loadCircleImageView(mContext, localPosts.getStore().getStore_avatar(), holder.<ImageView>getView(R.id.iv_storlogo), R.drawable.icon_default);
                ImageUtil.loadImageViewLoding(mContext, localPosts.getNewSmeta().get(0), holder.<ImageView>getView(R.id.image), R.drawable.icon_default, R.drawable.icon_default);

                if (localPosts.getNewSmeta().size() >= 2) {
                    holder.setText(R.id.tv_praisecount1, localPosts.getPost_like())
                            .setText(R.id.tv_commentcount1, String.valueOf(localPosts.getComment_count()))
                            .setText(R.id.tv_title1, localPosts.getPost_title())
                            .setText(R.id.tv_shopname1, localPosts.getStore().getStore_name())
                            .setVisible(R.id.ll_multiple,true)
                            .setVisible(R.id.tv_recommendeds1,localPosts.getRecommended().equals("1"))
                            .setVisible(R.id.ll_single,true);
                    ImageUtil.loadCircleImageView(mContext, localPosts.getStore().getStore_avatar(), holder.<ImageView>getView(R.id.iv_storlogo2), R.drawable.icon_default);
                    ImageUtil.loadImageViewLoding(mContext, localPosts.getNewSmeta().get(0), holder.<ImageView>getView(R.id.iv_example1), R.drawable.icon_default, R.drawable.icon_default);
                    ImageUtil.loadImageViewLoding(mContext, localPosts.getNewSmeta().get(1), holder.<ImageView>getView(R.id.iv_example2), R.drawable.icon_default, R.drawable.icon_default);
                    ImageUtil.loadImageViewLoding(mContext, localPosts.getNewSmeta().get(2), holder.<ImageView>getView(R.id.iv_example3), R.drawable.icon_default, R.drawable.icon_default);
                }
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, HotNewsDetailActivity.class);
                        intent.putExtra("url", localPosts.getUrl());
                        intent.putExtra("name", localPosts.getPost_title());
                        intent.putExtra("id", localPosts.getId());
                        mContext.startActivity(intent);
                    }
                });
            }
        };
        iHotNewsItemView.getRefreshCommonView().setRecyclerViewAdapter(hotNewsAdapter);
        iHotNewsItemView.getRefreshCommonView().setIsAutoLoad(false);
        iHotNewsItemView.getRefreshCommonView().setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {
            private int pageNum=1;
            @Override
            public void startRefresh() {
                pageNum=1;
                hotNewsList.clear();
                presenter.getHontNewsList(term_id,pageNum,"up","");
            }

            @Override
            public void startLoadMore() {
                presenter.getHontNewsList(term_id,++pageNum,"down",articlesBean.getPage().getPagetime());
            }
        });
    }

    private ArticlesBean articlesBean;
    public void onResultHontNewsListSuccess(Object obj) {
        iHotNewsItemView.getRefreshCommonView().finishRefresh();
        iHotNewsItemView.getRefreshCommonView().finishLoadMore();
        if (obj == null) {
            iHotNewsItemView.getRefreshCommonView().setIsLoadMore(false);
            return;
        }
        articlesBean = (ArticlesBean)obj;
        adNationwideList.clear();
        ArrayList<ArticlesBean.PostsIsTopRes> topBanner = articlesBean.getPostsIsTopRes();
        if (topBanner==null||topBanner.isEmpty()){
            iHotNewsItemView.getConvenientBannerView().setVisibility(View.GONE);
        }else{
            iHotNewsItemView.getConvenientBannerView().setVisibility(View.VISIBLE);
            for (ArticlesBean.PostsIsTopRes banner:topBanner){
                RecommendForm.RecommendAdv adv = new RecommendForm.RecommendAdv();
                adv.setPicurl(banner.getImg());
                adv.setUrl(banner.getUrl());
                adv.setTitle(banner.getTitle());
                adv.setObid(banner.getId());
                adv.setTypeid(4);
                adNationwideList.add(adv);
            }
            iHotNewsItemView.getConvenientBannerView().notifyDataSetChanged();
        }
        hotNewsList.addAll(articlesBean.getPosts());
        if (hotNewsList == null || hotNewsList.isEmpty()) {
            hotNewsList.clear();
            iHotNewsItemView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iHotNewsItemView.getRefreshCommonView().setIsEmpty(false);
            iHotNewsItemView.getRefreshCommonView().setIsLoadMore(articlesBean.getPosts().size()==articlesBean.getPage().getPagenumber());
        }
        hotNewsAdapter.notifyDataSetChanged();
    }

}
