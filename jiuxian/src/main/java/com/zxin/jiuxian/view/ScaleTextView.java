package com.zxin.jiuxian.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zxin.jiuxian.util.StringUtils;

/**
 * Created by Administrator on 2018/8/6.
 */

public class ScaleTextView extends android.support.v7.widget.AppCompatTextView {
    private String a = "http://schemas.android.com/apk/res/android";
    private float b;
    private float c;

    public ScaleTextView(Context paramContext) {
        super(paramContext);
    }

    public ScaleTextView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
        this.b = getPaint().getTextSize();
    }

    public ScaleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public static float a(Context paramContext, float paramFloat) {
        return (int) (paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        String str = paramAttributeSet.getAttributeValue(this.a, "layout_width");
        if ((!StringUtils.isEmpty(str)) && (str.contains("dip"))) {
            //this.c = ((float) h.b(str.substring(0, str.indexOf("dip")), 0));
            this.c = a(paramContext, this.c);
        }
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
    }

    public void setScaleText(String paramString) {
        getPaint().setTextSize(this.b);
        setText(paramString);
        float f = this.b;
        while (this.c - 20.0F < getPaint().measureText(getText().toString())) {
            f -= 1.0F;
            getPaint().setTextSize(f);
        }
        setText(paramString);
    }
}

