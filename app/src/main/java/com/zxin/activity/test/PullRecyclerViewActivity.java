package com.zxin.activity.test;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.lzy.widget.PullZoomView;
import com.zxin.R;
import com.zxin.base.BaseActivity;
import com.zxin.util.ColorUtil;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.LogUtils;
import com.zxin.root.util.UiUtils;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/24.
 */

public class PullRecyclerViewActivity extends BaseActivity {
    @BindView(R.id.pzv)
    PullZoomView pzv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private SimpleAdapter adapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    public void initData() {
        dataList.clear();
        for (int i = 0; i < 30; i++) {
            dataList.add("条目：" + i);
        }

        pzv.setOnScrollListener(new PullZoomView.OnScrollListener() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                LogUtils.d("onScroll   t:" + t + "  oldt:" + oldt);
            }

            @Override
            public void onHeaderScroll(int currentY, int maxY) {
                LogUtils.d("onHeaderScroll   currentY:" + currentY + "  maxY:" + maxY);
            }

            @Override
            public void onContentScroll(int l, int t, int oldl, int oldt) {
                LogUtils.d("onContentScroll   t:" + t + "  oldt:" + oldt);
            }
        });
        pzv.setOnPullZoomListener(new PullZoomView.OnPullZoomListener() {
            @Override
            public void onPullZoom(int originHeight, int currentHeight) {
                LogUtils.d("onPullZoom  originHeight:" + originHeight + "  currentHeight:" + currentHeight);
            }

            @Override
            public void onZoomFinish() {
                LogUtils.d("onZoomFinish");
            }
        });
        recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new SimpleAdapter<String>(mContext, dataList, android.R.layout.simple_list_item_1) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, String data) {
                TextView textView = holder.getView(android.R.id.text1);
                textView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
                textView.setText(data);
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(ColorUtil.generateBeautifulColor());
            }
        };
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_pull_recyclerview;
    }

    @OnClick({R.id.common_bar_leftBtn})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.common_bar_leftBtn:
                onBackPressed();
                break;

        }
    }
}
