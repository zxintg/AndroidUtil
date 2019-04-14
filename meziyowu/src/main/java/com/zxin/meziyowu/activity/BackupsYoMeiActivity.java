package com.zxin.meziyowu.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseActivity;
import com.zxin.meziyowu.util.IntegerUtil;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.basemodel.dao.MeiZiVideoDaoUtil;
import com.zxin.basemodel.entity.MeiZiCollect;
import com.zxin.root.util.ToastUtil;
import com.zxin.root.view.dialog.ProgressBarDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */

public class BackupsYoMeiActivity extends BaseActivity {
    private TextView tvSource;
    private EditText etBackups;
    private TextView tvVideoSource;
    private EditText etVideoBackups;
    private TextView tvBackups;

    private MeiZiVideoDaoUtil daoUtil;

    private ProgressBarDialog dialog = null;

    @Override
    public void initData() {
        tvSource = getViewById(R.id.et_youmei_source);
        etBackups = getViewById(R.id.et_youmei_backups);
        tvVideoSource = getViewById(R.id.et_youmei_videosource);
        etVideoBackups = getViewById(R.id.et_youmei_videobackups);

        tvBackups = getViewById(R.id.tv_youmei_backups);

        setTitleViewOnclick(R.id.ccb_youmei_title,R.id.common_bar_leftBtn);
        setViewOnclick(R.id.tv_youmei_copysource);
        setViewOnclick(R.id.tv_youmei_copybackups);

        tvBackups.setOnClickListener(this);
        if (daoUtil==null){
            daoUtil = MeiZiVideoDaoUtil.getInstance();
        }
        if(dialog == null){
            dialog = new ProgressBarDialog(mContext);
        }

        tvBackups.postDelayed(new Runnable() {
            @Override
            public void run() {
                String source = daoUtil.getMeiZiCollectList();
                String videoSource = daoUtil.getMeiZiVideoList();
                if(dialog!=null&&dialog.isShowing()){
                    dialog.closeProgress();
                }
                tvSource.setText(source);
                tvVideoSource.setText(videoSource);
            }
        },500);
        if (dialog != null) {
            dialog.showProgress();
        }
    }

    @Override
    public int setLayout() {
        return R.layout.activity_backupsyomei;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId() == R.id.tv_youmei_backups){
            final String backups = etBackups.getText().toString();
            final String videoBackups = etVideoBackups.getText().toString();
            if(StringUtils.textIsEmpty(backups))
                return;
            if(StringUtils.textIsEmpty(videoBackups))
                return;
            tvBackups.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(dialog!=null&&dialog.isShowing()){
                        dialog.closeProgress();
                    }
                    boolean isCollectSuccess = daoUtil.addMeiZiCollectJsonArray(backups);
                    boolean isVideoSuccess = daoUtil.addMeiZiVideoJsonArray(videoBackups);
                    if (isCollectSuccess||isVideoSuccess){
                        Bundle bundle = new Bundle();
                        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_31001);
                        EventBus.getDefault().post(bundle);
                        onBackPressed();
                        return;
                    }
                }
            },500);
        }else if(v.getId() == R.id.tv_youmei_copysource){
            //拷贝收藏
            // 从API11开始android推荐使用android.content.ClipboardManager
            // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            // 将文本内容放到系统剪贴板里。
            cm.setText(tvSource.getText());
            ToastUtil.showShort("收藏资源复制成功，可以发给朋友们了!");
        }else if(v.getId() == R.id.tv_youmei_copybackups){
            //拷贝视频
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            // 将文本内容放到系统剪贴板里。
            cm.setText(tvVideoSource.getText());
            ToastUtil.showShort("视频资源复制成功，可以发给朋友们了!");
        }
    }
}
