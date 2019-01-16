package com.zxin.zxinlib.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.util.SystemInfoUtil;

/****
 * 自定义浮动框
 */
public class MyFloatingActionButton extends ImageView {
    boolean mShowShadow = true;
    private Animation mShowAnimation;
    private Animation mHideAnimation;
    private boolean mShouldUpdateButtonPosition;
    private float mOriginalX = -1;
    private float mOriginalY = -1;

    public MyFloatingActionButton(Context context) {
        this(context, null);
    }

    public MyFloatingActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.MyFloatingActionButton, defStyleAttr, 0);
        if (attr.hasValue(R.styleable.MyFloatingActionButton_fab_elevationCompat)) {
            float elevation = attr.getDimensionPixelOffset(R.styleable.MyFloatingActionButton_fab_elevationCompat, 0);
            if (isInEditMode()) {
                setElevation(elevation);
            } else {
                setElevationCompat(elevation);
            }
        }

        initShowAnimation(attr);
        initHideAnimation(attr);
        attr.recycle();
        setClickable(true);
    }

    private void initShowAnimation(TypedArray attr) {
        int resourceId = attr.getResourceId(R.styleable.MyFloatingActionButton_fab_showAnimation, R.anim.fab_slide_in_from_right);
        mShowAnimation = AnimationUtils.loadAnimation(getContext(), resourceId);
    }

    private void initHideAnimation(TypedArray attr) {
        int resourceId = attr.getResourceId(R.styleable.MyFloatingActionButton_fab_hideAnimation, R.anim.fab_slide_out_to_right);
        mHideAnimation = AnimationUtils.loadAnimation(getContext(), resourceId);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (mShouldUpdateButtonPosition) {
            updateButtonPosition();
            mShouldUpdateButtonPosition = false;
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void updateButtonPosition() {
        float x = mOriginalX;
        ;
        float y = mOriginalY;
        setX(x);
        setY(y);
    }

    public void playShowAnimation() {
        mHideAnimation.cancel();
        startAnimation(mShowAnimation);
    }

    public void playHideAnimation() {
        mShowAnimation.cancel();
        startAnimation(mHideAnimation);
    }

    /**
     * Checks whether <b>MyFloatingActionButton</b> is hidden
     *
     * @return true if <b>MyFloatingActionButton</b> is hidden, false otherwise
     */
    public boolean isHidden() {
        return getVisibility() == INVISIBLE;
    }

    /**
     * Makes the <b>MyFloatingActionButton</b> to appear and sets its visibility to {@link #VISIBLE}
     *
     * @param animate if true - plays "show animation"
     */
    public void show(boolean animate) {
        if (isHidden()) {
            if (animate) {
                playShowAnimation();
            }
            super.setVisibility(VISIBLE);
        }
    }

    /**
     * Makes the <b>MyFloatingActionButton</b> to disappear and sets its visibility to {@link #INVISIBLE}
     *
     * @param animate if true - plays "hide animation"
     */
    public void hide(boolean animate) {
        if (!isHidden()) {
            if (animate) {
                playHideAnimation();
            }
            super.setVisibility(INVISIBLE);
        }
    }

    public void setShowAnimation(Animation showAnimation) {
        mShowAnimation = showAnimation;
    }

    public void setHideAnimation(Animation hideAnimation) {
        mHideAnimation = hideAnimation;
    }

    @Override
    public void setElevation(float elevation) {
        if (SystemInfoUtil.hasLollipop() && elevation > 0) {
            super.setElevation(elevation);
            if (!isInEditMode()) {
                mShowShadow = false;
            }
        }
    }

    /**
     * Sets the shadow color and radius to mimic the native elevation.
     * <p>
     * <p><b>API 21+</b>: Sets the native elevation of this view, in pixels. Updates margins to
     * make the view hold its position in layout across different platform versions.</p>
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setElevationCompat(float elevation) {
        if (SystemInfoUtil.hasLollipop()) {
            super.setElevation(elevation);
            mShowShadow = false;

            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                setLayoutParams(layoutParams);
            }
        } else {
            mShowShadow = true;
        }
    }

}
