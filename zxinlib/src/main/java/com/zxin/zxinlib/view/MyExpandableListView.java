package com.zxin.zxinlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;

public class MyExpandableListView extends ExpandableListView {

    public MyExpandableListView(Context context) {
        super(context);
    }

    public MyExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /******
     * 处理父控件都不要拦截子控件的点击事件
     * @param event
     * @return
     * liukui 2017/07/10 15:30
     */
    private float touchDownX,touchDownY;
    private boolean mScrollingX,mScrollingY;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                touchDownX = event.getX();
                touchDownY = event.getY();
                mScrollingX = false;
                mScrollingY = false;
                break;

            case MotionEvent.ACTION_MOVE:
                //触发移动事件的最短距离，如果大于这个距离表示滑动事件
                if (Math.abs(touchDownY - event.getY()) >= ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    mScrollingY = true;
                } else {
                    mScrollingY = false;
                }
                if (Math.abs(touchDownX - event.getX()) >= ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    mScrollingX = true;
                } else {
                    mScrollingX = false;
                }
                break;

            case MotionEvent.ACTION_UP:
                mScrollingX = false;
                mScrollingY = false;
                break;

        }
        //滑动事件
        getParent().requestDisallowInterceptTouchEvent(!mScrollingY&&!mScrollingX);
        return mScrollingY;
    }
}
