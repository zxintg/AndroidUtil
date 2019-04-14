package com.zxin.jdxsxp.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.jdxsxp.bean.AlbumModel;
import com.zxin.jdxsxp.mvp.presenter.XiGuaMainPresenter;
import com.zxin.jdxsxp.mvp.view.XiGuaMainContract;
import com.zxin.network.mvp.inject.InjectPresenter;
import com.zxin.root.view.RefreshCommonView;

/**
 * Created by Administrator on 2018/9/6.
 */

public class HPlayerActivity extends BaseActivity implements XiGuaMainContract.HPlayerView {
    @InjectPresenter
    XiGuaMainPresenter presenter;

    @Override
    public void initData() {
        AlbumModel albumModel = getIntent().getParcelableExtra("ALBUM_INFO");
        presenter.initHPlayerDatas(this,albumModel);

        presenter.getAlbumDetail(albumModel.getId());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_home_detail;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public IjkVideoView video_view() {
        return getViewById(R.id.video_view);
    }

    @Override
    public LinearLayout ll_bg() {
        return getViewById(R.id.ll_bg);
    }

    @Override
    public ImageView iv_trumb() {
        return getViewById(R.id.iv_trumb);
    }

    @Override
    public LinearLayout app_video_replay() {
        return getViewById(R.id.app_video_replay);
    }

    @Override
    public TextView app_video_status_text() {
        return getViewById(R.id.app_video_status_text);
    }

    @Override
    public TextView app_video_replay_icon() {
        return getViewById(R.id.app_video_replay_icon);
    }

    @Override
    public LinearLayout app_video_netTie() {
        return getViewById(R.id.app_video_netTie);
    }

    @Override
    public TextView app_video_netTie_icon() {
        return getViewById(R.id.app_video_netTie_icon);
    }

    @Override
    public LinearLayout app_video_freeTie() {
        return getViewById(R.id.app_video_freeTie);
    }

    @Override
    public TextView app_video_freeTie_icon() {
        return getViewById(R.id.app_video_freeTie_icon);
    }

    @Override
    public LinearLayout app_video_loading() {
        return getViewById(R.id.app_video_loading);
    }

    @Override
    public TextView app_video_speed() {
        return getViewById(R.id.app_video_speed);
    }

    @Override
    public RefreshCommonView getRefreshCommonView() {
        return getViewById(R.id.rcv_video_content);
    }

    @Override
    public TextView tv_video_title() {
        return getViewById(R.id.tv_video_title);
    }

    @Override
    public TextView tv_video_playnum() {
        return getViewById(R.id.tv_video_playnum);
    }

    @Override
    public TextView tv_video_thumcount() {
        return getViewById(R.id.tv_video_thumcount);
    }

    @Override
    public TextView tv_video_cllectcount() {
        return getViewById(R.id.tv_video_cllectcount);
    }

    @Override
    public TextView tv_video_buy() {
        return getViewById(R.id.tv_video_buy);
    }

    @Override
    public TextView image_video_head() {
        return getViewById(R.id.image_video_head);
    }

    @Override
    public TextView tv_video_v() {
        return getViewById(R.id.tv_video_v);
    }

    @Override
    public LinearLayout layout_video_1() {
        return getViewById(R.id.layout_video_1);
    }

    @Override
    public TextView tv_video_nick() {
        return getViewById(R.id.tv_video_nick);
    }

    @Override
    public TextView tv_video_time() {
        return getViewById(R.id.tv_video_time);
    }

    @Override
    public TextView tv_video_record() {
        return getViewById(R.id.tv_video_record);
    }

    @Override
    public LinearLayout ll_video_more() {
        return getViewById(R.id.ll_video_more);
    }

    @Override
    public RecyclerView rv_video_more() {
        return getViewById(R.id.rv_video_more);
    }

    @Override
    public TextView tv_video_commentnum() {
        return getViewById(R.id.tv_video_commentnum);
    }

    @Override
    public View getLayoutView() {
        return getCurrentView();
    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
        *//**demo的内容，恢复系统其它媒体的状态*//*
        MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
        *//**demo的内容，暂停系统其它媒体的状态*//*
        MediaUtils.muteAudioFocus(mContext, false);
        *//**demo的内容，激活设备常亮状态*//*
        if (wakeLock != null) {
            wakeLock.acquire();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
        *//**demo的内容，恢复设备亮度状态*//*
        if (wakeLock != null) {
            wakeLock.release();
        }
    }*/
}
