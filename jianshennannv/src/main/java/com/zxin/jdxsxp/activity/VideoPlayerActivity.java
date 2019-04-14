package com.zxin.jdxsxp.activity;

import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;
import com.dou361.ijkplayer.listener.OnPlayerBackListener;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.zxin.jdxsxp.R;
import com.zxin.jdxsxp.base.BaseActivity;
import com.zxin.root.bean.VideoPlayBean;
import com.zxin.jdxsxp.util.StringUtils;
import com.zxin.root.util.ImageUtil;


/**
 * ========================================
 * <p/>
 * 版 权：深圳市晶网科技控股有限公司 版权所有 （C） 2015
 * <p/>
 * 作 者：陈冠明
 * <p/>
 * 个人网站：http://www.dou361.com
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2015/11/18 9:40
 * <p/>
 * 描 述：点播全屏竖屏场景
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class VideoPlayerActivity extends BaseActivity {
    private PlayerView player;
    private VideoPlayBean playBean;

    @Override
    public void initData() {
        playBean = getIntent().getParcelableExtra(StringUtils.ACTIVITY_DATA);
        player = new PlayerView(this, getCurrentView())
                .setTitle(playBean.getBalk())
                .setScaleType(PlayStateParams.fitparent)
                .forbidTouch(false)
                .hideMenu(true)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        ImageUtil.loadImageViewLoding(mContext, playBean.getImageUrl(), ivThumbnail, R.mipmap.default_iamge);
                    }
                })
                .setPlaySource(playBean.getResUrl())
                .setPlayerBackListener(new OnPlayerBackListener() {
                    @Override
                    public void onPlayerBack() {
                        //这里可以简单播放器点击返回键
                        finish();
                    }
                })
                .startPlay();
    }

    @Override
    public int setLayout() {
        return R.layout.simple_player_view_player;
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
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
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
    public void onClick(View v) {

    }
}
