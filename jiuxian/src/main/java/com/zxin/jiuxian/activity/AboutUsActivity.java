package com.zxin.jiuxian.activity;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.zxin.jiuxian.R;
import com.zxin.jiuxian.base.BaseActivity;
import com.zxin.zxinlib.util.UiUtils;

/**
 * Created by Administrator on 2018/8/3.
 */

public class AboutUsActivity extends BaseActivity {

    @Override
    public void initData() {
        setTitleViewOnclick(R.id.ccb_jiuxian_title, R.id.common_bar_leftBtn);

        TextView licenceOne = getViewById(R.id.licence_1);
        TextView licenceTwo = getViewById(R.id.licence_2);

        String licence_1 = UiUtils.getString(R.string.jiuxian_licence_1);
        String licence_2 = UiUtils.getString(R.string.jiuxian_licence_2);

        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(licence_1);
        int m = licence_1.indexOf("酒仙网电子商务股份有限公司");
        int n = "酒仙网电子商务股份有限公司".length();
        stringBuilder.setSpan(new LicenceOne(0), m, n + m, 34);
        licenceOne.setText(stringBuilder);
        licenceOne.setMovementMethod(LinkMovementMethod.getInstance());


        SpannableStringBuilder stringBuilder1 = new SpannableStringBuilder(licence_2);
        m = licence_2.indexOf("酒仙网电子商务（天津）有限公司");
        n = "酒仙网电子商务（天津）有限公司".length();
        stringBuilder1.setSpan(new LicenceOne(1), m, n + m, 34);
        m = licence_2.indexOf("广东酒仙网络科技有限公司");
        n = "广东酒仙网络科技有限公司".length();
        stringBuilder1.setSpan(new LicenceOne(3), m, n + m, 34);
        m = licence_2.indexOf("上海酒仙电子商务有限公司");
        n = "上海酒仙电子商务有限公司".length();
        stringBuilder1.setSpan(new LicenceOne(4), m, n + m, 34);
        licenceTwo.setText(stringBuilder1);
        licenceTwo.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public int setLayout() {
        return R.layout.activity_about_us;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_bar_leftBtn) {
            onBackPressed();
        }
    }

    private class LicenceOne extends ClickableSpan {
        private int paramInt;

        public LicenceOne(int paramInt) {
            this.paramInt = paramInt;
        }

        public void onClick(View paramView) {
            Intent intent = new Intent(mContext, CompanyLicenseActivity.class);
            intent.putExtra("company-index", paramInt);
            startActivity(intent);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(Color.parseColor("#FF6666"));
            textPaint.setUnderlineText(true);
        }
    }
}
