package com.zxin.meziyowu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zxin.meziyowu.R;
import com.zxin.meziyowu.base.BaseActivity;
import com.zxin.meziyowu.bean.YoMeiBean;
import com.zxin.meziyowu.util.IntegerUtil;
import com.zxin.meziyowu.util.StringUtils;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.dao.MeiZiVideoDaoUtil;
import com.zxin.root.entity.MeiZiCollect;
import com.zxin.root.util.DateUtil;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.view.RefreshCommonView;
import com.zxin.root.view.dialog.ProgressBarDialog;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/23.
 */

public class YoMeiCollectActivity extends BaseActivity{
    private RefreshCommonView commonView;
    private SimpleAdapter meinvAdapter;
    private List<MeiZiCollect> albumList = new ArrayList<>();
    private MeiZiVideoDaoUtil daoUtil;

    private ProgressBarDialog dialog = null;
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
        meinvAdapter = new SimpleAdapter<MeiZiCollect>(mContext, albumList, R.layout.item_video_list) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final MeiZiCollect localTheme) {
                holder.setText(R.id.tv_name,localTheme.getName())
                .setText(R.id.tv_time, DateUtil.getInstance().timeStamp(localTheme.getCreateTime(),"yyyy-MM-dd HH:mm"));
                ImageUtil.loadImageViewLoding(mContext, localTheme.getCover(), holder.<ImageView>getView(R.id.iv_cover), R.mipmap.default_iamge, R.mipmap.default_iamge);
                holder.setOnItemListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, YoMeiUserDetailActivity.class);
                        intent.putExtra(StringUtils.ACTIVITY_DATA, new YoMeiBean(localTheme.getId(),localTheme.getCover(),localTheme.getUrl()));
                        mContext.startActivity(intent);
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

    @Override
    protected void onResume() {
        super.onResume();
        if (isNotifyDatas){
            commonView.notifyData();
            isNotifyDatas = false;
        }
    }

    private boolean isNotifyDatas = false;
    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_31001:
                isNotifyDatas = true;
                break;

        }
        return false;
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
                List<MeiZiCollect> videoList = daoUtil.getMeiZiCollectList(pageNum, 20);
                Gson g = new Gson();
                String aa = g.toJson(videoList);
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
        return R.layout.activity_collectvideo;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.common_bar_leftBtn){
            onBackPressed();
        }else if (v.getId()==R.id.common_bar_rightBtn){
            startActivity(new Intent(mContext,BackupsYoMeiActivity.class));
        }
    }
}
