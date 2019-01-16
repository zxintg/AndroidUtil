package com.zxin.zxinlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by Administrator on 2018/1/16.
 */

public class MyRadioButton extends AppCompatRadioButton {

    public MyRadioButton(Context context) {
        super(context);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return;
        Drawable drawable = getButtonDrawable();
        if (drawable == null)
            return;
        int left = 0;
        int top = 0;
        int len = (int)getTextSize() * (getText().toString().trim().length());
        switch (getGravity()) {
            case Gravity.CENTER:
                left = (getWidth() - drawable.getIntrinsicWidth()- len) / 2;//(控件宽度 - 控件中图标宽度)/2
                top = (getHeight() - drawable.getIntrinsicHeight()) / 2;//(控件高度 - 控件中图标高度)/2
                break;
        }
        //设置Button所在位置
        if (left == 0 && top == 0) {
            drawable.draw(canvas);
        } else {
            canvas.translate(left, 0);
            drawable.draw(canvas);
        }
        super.onDraw(canvas);

        //设置点击市光标所在位置
        Drawable background = getBackground();
        if (background != null) {
            background.setHotspotBounds(left, top, left+drawable.getIntrinsicWidth()+len, top+drawable.getIntrinsicHeight());
        }

    }
}