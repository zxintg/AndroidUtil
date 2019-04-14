package com.zxin.sources.activity;

import android.content.Intent;
import android.view.View;
import com.zxin.router.annotation.Route;
import com.zxin.sources.R;
import com.zxin.sources.base.BaseActivity;
import com.zxin.root.view.CommonCrosswiseBar;

@Route({"sources", "router://filter/sources"})
public class SourcesMainActivity extends BaseActivity {
    private CommonCrosswiseBar mTitle;

    @Override
    public void initData() {
        initView();
    }

    private void initView() {
        mTitle = (CommonCrosswiseBar) getViewById(R.id.ccb_sources_head);
        mTitle.setOnClickListener(R.id.common_bar_leftBtn,this);
        setViewOnclick(R.id.ccb_test_sources,R.id.ccb_test_ynshangji,R.id.ccb_test_bus);
    }

    @Override
    public int setLayout() {
        return R.layout.activity_sources_main;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.common_bar_leftBtn) {
            onBackPressed();
        } else if (id == R.id.ccb_test_sources) {//项目资源
            startActivity(new Intent(mContext, CodeKKActivity.class));
        } else if (id == R.id.ccb_test_ynshangji) {//云商网
            startActivity(new Intent(mContext, YunShangActivity.class));
        } else if (id == R.id.ccb_test_bus) {//安卓BUS
            startActivity(new Intent(mContext, AndroidBusActivity.class));
        }
    }

}
