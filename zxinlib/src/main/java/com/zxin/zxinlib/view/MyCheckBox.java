package com.zxin.zxinlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by Administrator on 2018/1/16.
 */

public class MyCheckBox extends AppCompatCheckBox {

    public MyCheckBox(Context context) {
        super(context);
    }

    public MyCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable[] drawables = getCompoundDrawables();
        Drawable drawable = drawables[0];
        int gravity = getGravity();
        int left = 0;
        if (gravity == Gravity.CENTER) {
            left = ((int) (getWidth() - drawable.getIntrinsicWidth() - getPaint().measureText(getText().toString()))/ 2);
        }
        drawable.setBounds(left, 0, left + drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}