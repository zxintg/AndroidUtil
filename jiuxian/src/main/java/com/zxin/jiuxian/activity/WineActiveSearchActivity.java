package com.zxin.jiuxian.activity;

import android.app.Activity;
import android.view.View;

import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/3.
 */

public class WineActiveSearchActivity extends BaseActivity {
    @Override
    public void initData() {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_wine_active_search;
    }

    @Override
    public void onClick(View v) {

    }

    public static class SearchSourceInfo implements Serializable {
        public String mSearchEventId;
        public String mSearchHotEventId;
        public String mSearchRecentEventId;
    }
}
