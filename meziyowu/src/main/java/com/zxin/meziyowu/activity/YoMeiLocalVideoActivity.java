package com.zxin.meziyowu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.zxin.camera.model.PhotoPreviewBean;
import com.zxin.camera.utils.CameraAlbumUtils;
import com.google.gson.Gson;
import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseActivity;
import com.zxin.meziyowu.util.IntegerUtil;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.DynamicResources;
import com.zxin.root.bean.VideoPlayBean;
import com.zxin.basemodel.dao.MeiZiVideoDaoUtil;
import com.zxin.basemodel.dao.MeiZiVideo;
import com.zxin.root.util.ContentUtil;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.dialog.ConfirmDialog;
import com.zxin.root.view.dialog.NiceDialog;
import com.zxin.root.view.dialog.ProgressBarDialog;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/23.
 */

public class YoMeiLocalVideoActivity extends BaseActivity{
    private RefreshCommonView commonView;
    private SimpleAdapter meinvAdapter;
    private List<MeiZiVideo> albumList = new ArrayList<>();
    private MeiZiVideoDaoUtil daoUtil;

    private ProgressBarDialog dialog = null;
    private NiceDialog niceDialog;
    private ConfirmDialog backDialog;
    private int pageNum = 0;
    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_youmei_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        commonView = getViewById(R.id.rcv_mine_commonlayout);
        if (daoUtil==null){
            daoUtil = MeiZiVideoDaoUtil.getInstance();
        }
        if(dialog == null){
            dialog = new ProgressBarDialog(mContext);
        }
        meinvAdapter = new SimpleAdapter<MeiZiVideo>(mContext, albumList, R.layout.item_small_video_list) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiZiVideo localTheme) {
                ImageUtil.loadImageViewLoding(mContext, localTheme.getThumbUrl(), holder.<ImageView>getView(R.id.iv_cover), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (niceDialog == null) {
                            niceDialog = NiceDialog.init();
                        }
                        niceDialog.setShowCancelBtn(false);
                        niceDialog.setOnNiceDialogListener(new NiceDialog.NiceDialogListener() {
                            @Override
                            public void onItemListener(int index, String item) {
                                switch (index){
                                    case 0:
                                        //视频
                                        DynamicResources res = new DynamicResources();
                                        res.setDesc("本地视频 - " + localTheme.getNickname());
                                        res.setThumbnailUrl(localTheme.getThumbUrl());
                                        res.setUrl(localTheme.getVideoUrl());
                                        VideoPlayBean album = new VideoPlayBean(res);
                                        startActivity(new Intent(mContext, VideoPlayerActivity.class).putExtra(StringUtils.ACTIVITY_DATA, album));
                                        break;

                                    case 1:
                                        //相册
                                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(getPhotoPreview(albumList,albumList.indexOf(albumList)));
                                        break;
                                }
                            }
                        });
                        niceDialog.setCommonLayout(ContentUtil.getInstance().selectOperatorYoMei(), false);
                    }
                });

                holder.setOnItemLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        //退出
                        if(backDialog==null) {
                            backDialog = ConfirmDialog.newInstance("", "您确定要删除“"+localTheme.getNickname()+"”吗？", "删除", "取消");
                        }
                        backDialog.setMargin(60)
                                .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                                .setOutCancel(false)
                                .show();
                        backDialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){


                            @Override
                            public void dialogStatusYes() {

                            }

                            @Override
                            public void dialogStatusNo() {
                                colseDialog();
                                if(dialog!=null){
                                    dialog.showProgress();
                                }
                                commonView.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(dialog!=null&&dialog.isShowing()){
                                            dialog.closeProgress();
                                        }
                                        daoUtil.deleteMeiZiVideo(localTheme.getId());
                                        commonView.notifyData();
                                    }
                                },1000);
                            }
                        });
                        return false;
                    }
                });
            }
        };
        commonView.setRecyclerViewAdapter(meinvAdapter);
        commonView.setRefreshLoadMoreListener(new RefreshCommonView.RefreshLoadMoreListener() {

            @Override
            public void startRefresh() {
                albumList.clear();
                pageNum = 0;
                loadDatas(pageNum);
            }

            @Override
            public void startLoadMore() {
                loadDatas(++pageNum);
            }
        });
    }

    private void loadDatas(final int pageNum){
        if(dialog!=null){
            dialog.showProgress();
        }
        commonView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(dialog!=null&&dialog.isShowing()){
                    dialog.closeProgress();
                }
                List<MeiZiVideo> videoList = daoUtil.getMeiZiVideoList(pageNum, 20);
                commonView.finishRefresh();
                commonView.finishLoadMore();
                albumList.addAll(videoList);
                if (albumList == null || albumList.isEmpty()) {
                    albumList.clear();
                    commonView.setIsEmpty(true);
                } else {
                    commonView.setIsEmpty(false);
                    commonView.setIsLoadMore(videoList!=null&&videoList.size() >= 20);
                }
                meinvAdapter.notifyDataSetChanged();
            }
        },1000);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_localvideo;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            if (niceDialog!=null && niceDialog.isVisible()){
                niceDialog.dismiss();
                return;
            }
            if (backDialog!=null && backDialog.isVisible()){
                backDialog.dismiss();
                return;
            }
            onBackPressed();
        }else if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext,BackupsYoMeiActivity.class));
        }
    }

    private PhotoPreviewBean getPhotoPreview(List<MeiZiVideo> albumList, int index){
        PhotoPreviewBean previewBean = new PhotoPreviewBean();
        previewBean.count = albumList.size();
        previewBean.index = index;
        previewBean.content = "暂无评论";
        previewBean.explain = "评论看看好不好呀！！！！";
        previewBean.explainNum = 0;
        previewBean.zanNum = 0;
        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
        for (MeiZiVideo picTotalBean : albumList) {
            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
            photoPreview.imageUrl = picTotalBean.getThumbUrl();
            list.add(photoPreview);
        }
        previewBean.photoList = list;
        return previewBean;
    }

    private void colseDialog() {
        if (backDialog != null && backDialog.isVisible()) {
            backDialog.dismiss();
        }
    }

    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_31001:
                commonView.notifyData();
                break;
        }
        return false;
    }
}
