package com.zxin.meziyowu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zxin.camera.model.PhotoPreviewBean;
import com.zxin.camera.utils.CameraAlbumUtils;
import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseActivity;
import com.zxin.meziyowu.bean.YoMeiBean;
import com.zxin.meziyowu.bean.YoMeiDeatilBean;
import com.zxin.meziyowu.mvp.presenter.YoMeiMainPresenter;
import com.zxin.meziyowu.mvp.view.YoMeiMainContract;
import com.zxin.meziyowu.util.IntegerUtil;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.bean.DynamicResources;
import com.zxin.root.bean.VideoPlayBean;
import com.zxin.root.dao.MeiZiVideoDaoUtil;
import com.zxin.basemodel.entity.MeiZiCollect;
import com.zxin.basemodel.entity.MeiZiVideo;
import com.zxin.root.util.AppManager;
import com.zxin.root.util.ContentUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.dialog.ConfirmDialog;
import com.zxin.root.view.dialog.NiceDialog;
import com.zxin.root.view.dialog.ProgressBarDialog;
import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */

public class YoMeiUserDetailActivity extends BaseActivity implements YoMeiMainContract.YoMeiInfoView {
    private YoMeiBean yoMeiBean;
    @InjectPresenter
    YoMeiMainPresenter presenter;
    private ProgressBarDialog dialog = null;
    private ConfirmDialog backDialog;

    @Override
    public void initData() {
        yoMeiBean = getIntent().getParcelableExtra(StringUtils.ACTIVITY_DATA);
        setTitleViewOnclick(R.id.ccb_youmei_title,R.id.common_bar_leftBtn,R.id.common_bar_rightBtn);
        presenter.initYoMeiUserDetailDatas(this,yoMeiBean.getId());
        presenter.getYoMeiVideoDetail(yoMeiBean.getId());
        if (daoUtil==null){
            daoUtil = MeiZiVideoDaoUtil.getInstance();
        }
        if(dialog == null){
            dialog = new ProgressBarDialog(mContext);
        }
    }

    @Override
    public int setLayout() {
        return R.layout.activity_youmei_details;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
            return;
        }
        if (v.getId()==R.id.common_bar_rightBtn){
            //收藏
            if (getCommonCrosswiseBarView().getRightText().equals("取消收藏")){
                //取消收藏
                if(dialog!=null){
                    dialog.showProgress();
                }
                getCommonCrosswiseBarView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(dialog!=null&&dialog.isShowing()){
                            dialog.closeProgress();
                        }
                        if(collect==null)
                            return;
                        daoUtil.deleteMeiZiCollect(collect.getId());
                        getCommonCrosswiseBarView().setRightText("收藏");
                        sendNotifyDatas();
                    }
                },1000);
            }else{
                if(dialog!=null){
                    dialog.showProgress();
                }
                getCommonCrosswiseBarView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(dialog!=null&&dialog.isShowing()){
                            dialog.closeProgress();
                        }
                        MeiZiCollect meiZiCollect = daoUtil.addMeiZiCollect(yoMeiBean.getId(), yoMeiBean.getCover(), yoMeiBean.getUrl(),userName);
                        if (meiZiCollect!=null){
                            ToastUtil.showShort("收藏成功");
                            getCommonCrosswiseBarView().setRightText("取消收藏");
                            collect = meiZiCollect;
                            sendNotifyDatas();
                            return;
                        }
                        ToastUtil.showShort("收藏失败");
                    }
                },1000);
            }
            return;
        }
    }

    private void sendNotifyDatas(){
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_31001);
        EventBus.getDefault().post(bundle);
    }

    @Override
    public AppBarLayout getAppBarLayoutView() {
        return getViewById(R.id.ab_youmei_bar);
    }

    @Override
    public Toolbar getToolbarView() {
        return getViewById(R.id.appbar_layout_toolbar);
    }

    @Override
    public CommonCrosswiseBar getCommonCrosswiseBarView() {
        return getViewById(R.id.ccb_youmei_title);
    }

    @Override
    public ImageView iv_youmei_headbg() {
        return getViewById(R.id.iv_youmei_headbg);
    }

    @Override
    public ImageView iv_youmei_head() {
        return getViewById(R.id.iv_youmei_head);
    }

    @Override
    public TextView tv_youmei_username() {
        return getViewById(R.id.tv_youmei_username);
    }

    @Override
    public TextView tv_youmei_userdesc() {
        return getViewById(R.id.tv_youmei_userdesc);
    }

    @Override
    public TextView tv_youmei_videonum() {
        return getViewById(R.id.tv_youmei_videonum);
    }

    @Override
    public RecyclerView rv_youmei_tags() {
        return getViewById(R.id.rv_youmei_tags);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_youmei_commonlayout);
    }

    private String userName;
    private MeiZiCollect collect;
    @Override
    public void setResultName(String userName) {
        this.userName = userName;
        getCommonCrosswiseBarView().setRightIsShow(!StringUtils.textIsEmpty(this.userName));
        collect = daoUtil.getMeiZiCollect(userName);
        if (collect!=null){
            getCommonCrosswiseBarView().setRightText("取消收藏");
        }else{
            getCommonCrosswiseBarView().setRightText("收藏");
        }
    }

    private NiceDialog niceDialog;
    private MeiZiVideoDaoUtil daoUtil;
    @Override
    public void selectOnclick(final YoMeiDeatilBean yoMeiDeatil, final List<YoMeiBean> meinvDeatilList, final int imageIndex,final boolean hasVideo) {
        if (StringUtils.textIsEmpty(yoMeiDeatil.url)&&!hasVideo){
            CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(getPhotoPreview(meinvDeatilList,imageIndex));
            return;
        }
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
                        if (hasVideo){
                            MeiZiVideo video = daoUtil.getMeiZiVideo(yoMeiDeatil.id);
                            res.setDesc("本地视频 - " + video.getNickname());
                            res.setThumbnailUrl(video.getThumbUrl());
                            res.setUrl(video.getVideoUrl());
                        }else{
                            res.setDesc("优美视频 - "+yoMeiDeatil.nickname);
                            res.setThumbnailUrl(yoMeiDeatil.avatar.url);
                            res.setUrl(yoMeiDeatil.url);
                        }
                        VideoPlayBean album = new VideoPlayBean(res);
                        startActivity(new Intent(mContext, VideoPlayerActivity.class).putExtra(StringUtils.ACTIVITY_DATA, album));
                        break;

                    case 1:
                        //相册
                        CameraAlbumUtils.getInstance(mContext).startAlbumPreviewActivity(getPhotoPreview(meinvDeatilList,imageIndex));
                        break;

                }
            }
        });
        niceDialog.setCommonLayout(ContentUtil.getInstance().selectOperatorYoMei(), false);
    }

    @Override
    public void itemOnLongClick(final YoMeiBean localTheme) {
        if(collect==null)
            return;
        if(backDialog==null) {
            backDialog = ConfirmDialog.newInstance("", "您确定要替换封面么？", "取消", "确定");
        }
        backDialog.setMargin(60)
                .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                .setOutCancel(false)
                .show();
        backDialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){

            @Override
            public void dialogStatusYes() {
                collect.setCover(localTheme.getCover());
                daoUtil.updateMeiZiCollectImage(collect);
                sendNotifyDatas();
            }

            @Override
            public void dialogStatusNo() {

            }
        });
    }

    private PhotoPreviewBean getPhotoPreview(List<YoMeiBean> meinvDeatilList,int index){
        PhotoPreviewBean previewBean = new PhotoPreviewBean();
        previewBean.count = meinvDeatilList.size();
        previewBean.index = index;
        previewBean.content = "暂无评论";
        previewBean.explain = "评论看看好不好呀！！！！";
        previewBean.explainNum = 0;
        previewBean.zanNum = 0;
        List<PhotoPreviewBean.PhotoPreview> list = new ArrayList<>();
        for (YoMeiBean picTotalBean : meinvDeatilList) {
            PhotoPreviewBean.PhotoPreview photoPreview = new PhotoPreviewBean.PhotoPreview();
            photoPreview.imageUrl = picTotalBean.getCover();
            list.add(photoPreview);
        }
        previewBean.photoList = list;
        return previewBean;
    }
}
