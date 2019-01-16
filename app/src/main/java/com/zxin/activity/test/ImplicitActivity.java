package com.zxin.activity.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zxin.R;
import com.zxin.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/5/28.
 */

public class ImplicitActivity extends BaseActivity {
    @BindView(R.id.text_test)
    TextView text;

    @Override
    public void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && !bundle.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("id:")
                    .append(bundle.getString("id"))
                    .append("\n")
                    .append("status:")
                    .append(bundle.getString("status"));
            text.setText(sb.toString());
        }
    }

    @Override
    public int setLayout() {
        return R.layout.activity_scheme;
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
