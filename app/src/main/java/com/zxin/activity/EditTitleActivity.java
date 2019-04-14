package com.zxin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.sort.SimpleTitleTip;
import com.zxin.sort.Tip;
import com.zxin.sort.adapter.AbsTipAdapter;
import com.zxin.sort.adapter.DragTipAdapter;
import com.zxin.sort.widget.DragDropGirdView;
import com.zxin.sort.widget.TipItemView;
import com.zxin.util.StringUtils;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.TitleBean;
import com.zxin.basemodel.dao.HttpUrlDaoUtil;
import com.zxin.root.util.IntegerUtil;
import com.zxin.root.util.SystemInfoUtil;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.dialog.ConfirmDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/16.
 */

public class EditTitleActivity extends BaseActivity implements AbsTipAdapter.DragDropListener, TipItemView.OnTipOnListener {

    @BindView(R.id.ccb_edittile_title)
    CommonCrosswiseBar mTitle;
    @BindView(R.id.ddgv_editview)
    DragDropGirdView mDropGirdView;
    @BindView(R.id.rv_editview)
    RecyclerView mRecyclerView;
    @BindView(R.id.rv_editunview)
    RecyclerView mRecyclerUnView;

    private DragTipAdapter dragTipAdapter;

    private ArrayList<Tip> mineLableList = new ArrayList<>();
    private List<TitleBean> mOutherList = new ArrayList<>();
    private List<TitleBean> unUsedList = new ArrayList<>();

    private SimpleAdapter adapter,unAdapter;

    @Override
    public void initData() {
        dragTipAdapter = new DragTipAdapter(mContext, this, this);
        dragTipAdapter.setData(mineLableList);
        mDropGirdView.setNestedScrollingEnabled(false);
        mDropGirdView.getDragDropController().addOnDragDropListener(dragTipAdapter);
        mDropGirdView.setAdapter(dragTipAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.setNestedScrollingEnabled(false);

        adapter = new SimpleAdapter<TitleBean>(mContext, mOutherList, R.layout.view_add_item) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final TitleBean data) {
                holder.setText(R.id.tagview_title, data.label)
                        .setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mTitle.getRightText().equals("编辑"))
                                    return;
                                mOutherList.remove(data);
                                SimpleTitleTip tip = new SimpleTitleTip();
                                tip.setTip(data.label);
                                tip.setId(data.id);
                                mineLableList.add(tip);
                                dragTipAdapter.setData(mineLableList);
                                dragTipAdapter.refreshData();
                                adapter.notifyDataSetChanged();
                            }
                        });
            }
        };
        mRecyclerView.setAdapter(adapter);

        mRecyclerUnView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerUnView.setNestedScrollingEnabled(false);

        unAdapter = new SimpleAdapter<TitleBean>(mContext, unUsedList, R.layout.view_add_item) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final TitleBean data) {
                holder.setText(R.id.tagview_title, data.label)
                        .setOnItemListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mTitle.getRightText().equals("完成"))
                                    return;
                                Intent intent = new Intent(mContext, EditHttpUrlActivity.class);
                                intent.putExtra(StringUtils.ACTIVITY_DATA, data.id);
                                startActivity(intent);
                            }
                        });
                holder.setOnItemLongClickListener(new View.OnLongClickListener(){

                    @Override
                    public boolean onLongClick(View v) {
                        if(backDialog==null) {
                            backDialog = ConfirmDialog.newInstance("", "您确定要删除无效“"+data.label+"”吗？", "取消", "确定");
                        }
                        backDialog.setMargin(60)
                                .setWidth(SystemInfoUtil.getScreenWidth()*2/3)
                                .setOutCancel(false)
                                .show();
                        backDialog.setConfirmDialogListener(new ConfirmDialog.ConfirmDialogListener(){

                            @Override
                            public void dialogStatusYes() {
                                colseDialog();
                                unUsedList.remove(data);
                                HttpUrlDaoUtil.getInstance().deleteHttpUrl(data.id);
                                unAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void dialogStatusNo() {

                            }
                        });
                        return false;
                    }
                });
            }
        };
        mRecyclerUnView.setAdapter(unAdapter);

        getTipList();
    }

    @Override
    public int setLayout() {
        return R.layout.activity_edittitle;
    }

    @OnClick({R.id.common_bar_leftBtn, R.id.common_bar_rightBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

            case R.id.common_bar_rightBtn:
                //编辑
                if(mTitle.getRightText().equals("完成")){
                    updatas();
                    return;
                }else if (mTitle.getRightText().equals("编辑")){
                    mTitle.setRightText("完成");
                    //开启编辑模式
                    dragTipAdapter.startEdittingStatus(mDropGirdView);
                }
                break;
        }
    }

    @Override
    public DragDropGirdView getDragDropGirdView() {
        return mDropGirdView;
    }

    @Override
    public void onDataSetChangedForResult(ArrayList<Tip> list) {
        mineLableList.clear();
        mineLableList.addAll(list);
    }

    @Override
    public void onTileSelected(Tip entity, View view) {
        mineLableList.remove(entity);
        dragTipAdapter.setData(mineLableList);
        dragTipAdapter.refreshData();
        mOutherList.add(HttpUrlDaoUtil.getInstance().getTitleBean(entity.getId()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLongClick(Tip entity, View view) {
        //第一次开始拖动item触发回调

    }

    private void getTipList() {
        List<TitleBean> titleList = HttpUrlDaoUtil.getInstance().getTitleAllList();
        mineLableList.clear();
        mOutherList.clear();
        unUsedList.clear();
        for (TitleBean titleBean: titleList) {
           if (titleBean.isEffective==0){
               //无效
               unUsedList.add(titleBean);
           }else if (titleBean.orderNum!=-1){
               SimpleTitleTip tip = new SimpleTitleTip();
               tip.setTip(titleBean.label);
               tip.setId(titleBean.id);
               mineLableList.add(tip);
           }else{
               mOutherList.add(titleBean);
           }
        }
        dragTipAdapter.setData(mineLableList);
        dragTipAdapter.refreshData();
        adapter.notifyDataSetChanged();
        unAdapter.notifyDataSetChanged();
    }

    private void updatas(){
        for (Tip title : mineLableList){
            //选中的
            HttpUrlDaoUtil.getInstance().updateHttpSelect(title.getId());
        }
        for (TitleBean title : mOutherList){
            //取消
            HttpUrlDaoUtil.getInstance().updateHttpEffective(title.id,1,-1);
        }

        //无效
        for (TitleBean title : unUsedList){
            HttpUrlDaoUtil.getInstance().updateHttpEffective(title.id,0,-1);
        }

        mTitle.setRightText("编辑");
        dragTipAdapter.cancelEditingStatus();
        sendEvenBusMesg();
    }

    //接受event事件
    @Override
    public boolean onEventMainThread(Bundle bundle) {
        switch (bundle.getInt(StringUtils.EVENT_ID)) {
            case IntegerUtil.EVENT_ID_11001:
                //添加标签后刷新界面
                getTipList();
                break;

        }
        return false;
    }

    private void sendEvenBusMesg(){
        Bundle bundle = new Bundle();
        bundle.putInt(StringUtils.EVENT_ID, IntegerUtil.EVENT_ID_11002);
        EventBus.getDefault().post(bundle);
    }

    private ConfirmDialog backDialog;

    private void colseDialog() {
        if (backDialog != null && backDialog.isVisible()) {
            backDialog.dismiss();
        }
    }

}
