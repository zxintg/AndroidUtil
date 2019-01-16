package com.zxin.zxinlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zxin.zxinlib.R;
import com.zxin.zxinlib.adapter.ViewPageFragmentAdapter;
import com.zxin.zxinlib.bean.TitleBean;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.UiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*****
 * tabbar公共 liukui 2018/01/05
 */
public class PagerSlidingVerTabStrip extends NestedScrollView {

    // @formatter:off
    private static final int[] ATTRS = new int[]{android.R.attr.textSize, android.R.attr.textColor};
    // @formatter:on

    private LinearLayout.LayoutParams tabLayoutParams;

    private final PageListener pageListener = new PageListener();
    public ViewPager.OnPageChangeListener delegatePageListener;

    private LinearLayout tabsContainer;
    private ViewPager pager;

    private int tabCount;

    private int currentPosition = 0;
    private int selectedPosition = 0;
    private float currentPositionOffset = 0f;

    private Paint rectPaint;
    private Paint dividerPaint;

    private int indicatorColor = 0xFF666666;
    private int underlineColor = 0x1A000000;
    private int dividerColor = 0x1A000000;
    private int pstsVerTextBgColor;
    private int pstsVerTextCheckedBgColor;

    private boolean shouldExpand = false;
    private boolean textAllCaps = true;
    private boolean pstsVerHasImage = true;

    private int scrollOffset = 20;//滚动条偏移量
    private int indicatorHeight = 0;
    private int underlineWeight = 2;
    private int dividerPadding = 12;
    private int pstsVerImageSize = 15;
    private int dividerWidth = 1;
    private int pstsIndicatorWight = 8;

    //未选中，选中字体大小
    private int tabTextSize = 13;
    private int selectedTabTextSize = 15;
    private int viewWidth = 0;
    //未选中，选中字体颜色
    private int tabTextColor = 0xFF666666;
    private int selectedTabTextColor = 0xFF666666;
    private Typeface tabTypeface = null;
    private int tabTypefaceStyle = Typeface.NORMAL;

    private int lastScrollY = 0;

    private Locale locale;

    public PagerSlidingVerTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingVerTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerSlidingVerTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        int ScreenHeight = SystemInfoUtil.getScreenHeight();
        setFillViewport(true);
        setWillNotDraw(false);

        scrollOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, scrollOffset, SystemInfoUtil.getDisplayMetrics());
        indicatorHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, indicatorHeight, SystemInfoUtil.getDisplayMetrics());
        underlineWeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, underlineWeight, SystemInfoUtil.getDisplayMetrics());
        dividerPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dividerPadding, SystemInfoUtil.getDisplayMetrics());
        dividerWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dividerWidth, SystemInfoUtil.getDisplayMetrics());
        tabTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, tabTextSize, SystemInfoUtil.getDisplayMetrics());
        selectedTabTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, selectedTabTextSize, SystemInfoUtil.getDisplayMetrics());

        //系统的字体大小，颜色
        TypedArray a = context.obtainStyledAttributes(attrs, ATTRS);
        tabTextSize = a.getDimensionPixelSize(0, tabTextSize);
        tabTextColor = a.getColor(1, tabTextColor);

        a.recycle();

        // get custom attrs
        a = context.obtainStyledAttributes(attrs, R.styleable.PagerSlidingVerTabStrip);
        //选中字体大小，颜色
        viewWidth = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerWith, 0);
        selectedTabTextColor = a.getColor(R.styleable.PagerSlidingVerTabStrip_pstsVerSelectTabTextColor, selectedTabTextColor);
        selectedTabTextSize = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerSelectTabTextSize, selectedTabTextSize);

        indicatorColor = a.getColor(R.styleable.PagerSlidingVerTabStrip_pstsVerIndicatorColor, indicatorColor);
        underlineColor = a.getColor(R.styleable.PagerSlidingVerTabStrip_pstsVerUnderlineColor, underlineColor);
        dividerColor = a.getColor(R.styleable.PagerSlidingVerTabStrip_pstsVerDividerColor, dividerColor);
        underlineWeight = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerUnderlineWeight, underlineWeight);
        dividerPadding = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerDividerPadding, dividerPadding);
        pstsVerTextBgColor = a.getColor(R.styleable.PagerSlidingVerTabStrip_pstsVerTextBgColor, UiUtils.getColor(R.color.color_ffffff));
        pstsVerTextCheckedBgColor = a.getColor(R.styleable.PagerSlidingVerTabStrip_pstsVerTextCheckedBgColor, UiUtils.getColor(R.color.color_ffffff));
        shouldExpand = a.getBoolean(R.styleable.PagerSlidingVerTabStrip_pstsVerShouldExpand, shouldExpand);
        textAllCaps = a.getBoolean(R.styleable.PagerSlidingVerTabStrip_pstsVerTextAllCaps, textAllCaps);
        pstsVerImageSize = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerImageSize, pstsVerImageSize);
        pstsVerHasImage = a.getBoolean(R.styleable.PagerSlidingVerTabStrip_pstsVerHasImage, true);

        indicatorHeight = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerIndicatorHeight, ScreenHeight);
        pstsIndicatorWight = a.getDimensionPixelSize(R.styleable.PagerSlidingVerTabStrip_pstsVerIndicatorWight, pstsIndicatorWight);

        a.recycle();

        rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setStyle(Style.FILL);

        dividerPaint = new Paint();
        dividerPaint.setAntiAlias(true);
        dividerPaint.setStrokeWidth(dividerWidth);

        tabsContainer = new LinearLayout(context);
        tabsContainer.setOrientation(LinearLayout.VERTICAL);
        tabsContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        tabLayoutParams = new LinearLayout.LayoutParams(viewWidth == 0 ? LayoutParams.WRAP_CONTENT : viewWidth, LayoutParams.WRAP_CONTENT);
        tabsContainer.setLayoutParams(tabLayoutParams);
        addView(tabsContainer);

        if (locale == null) {
            locale = getResources().getConfiguration().locale;
        }
        indicatorHeight = indicatorHeight < ScreenHeight ? indicatorHeight : ScreenHeight;
    }

    public void setViewPager(ViewPager pager) {
        this.pager = pager;
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        pager.setOnPageChangeListener(pageListener);
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        tabsContainer.removeAllViews();

        tabCount = pager.getAdapter().getCount();
        for (int i = 0; i < tabCount; i++) {
            addTextTab(i, pager.getAdapter().getPageTitle(i).toString(), tabCount);
        }

        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
                currentPosition = pager.getCurrentItem();
                scrollToChild(currentPosition, 0);
            }
        });
    }

    private void addTextTab(final int position, String title, int tabCount) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TextView tab = new TextView(getContext());
        LayoutParams params = new LayoutParams(viewWidth - underlineWeight, shouldExpand ? indicatorHeight / tabCount : LayoutParams.WRAP_CONTENT);
        tab.setLayoutParams(params);
        int padd = SystemInfoUtil.dip2px(10);
        tab.setPadding(padd, padd, padd, padd);
        if (pstsVerHasImage && pager.getAdapter() instanceof ViewPageFragmentAdapter) {
            TitleBean titleBean = ((ViewPageFragmentAdapter) pager.getAdapter()).getItemDatas(position);
            ImageUtil.setCompoundDrawable(tab, pstsVerImageSize, titleBean.labImage, Gravity.TOP, 5);
        }
        tab.setText(title);
        tab.setGravity(Gravity.CENTER);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(tab);
        addTab(position, linearLayout);
    }

    private void addTab(final int position, View tab) {
        tab.setFocusable(true);
        tab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(position);
            }
        });
        tabsContainer.addView(tab, position, tabLayoutParams);
    }

    private void updateTabStyles() {
        for (int i = 0; i < tabCount; i++) {
            LinearLayout v = (LinearLayout) tabsContainer.getChildAt(i);
            View textview = v.getChildAt(0);
            if (textview instanceof TextView) {
                TextView tab = (TextView) textview;
                tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, tabTextSize);
                tab.setTypeface(tabTypeface, tabTypefaceStyle);
                tab.setTextColor(tabTextColor);
                //是否字体大写
                if (textAllCaps) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                        tab.setAllCaps(true);
                    } else {
                        tab.setText(tab.getText().toString().toUpperCase(locale));
                    }
                }
                tab.setBackgroundColor(pstsVerTextBgColor);
                //设置选中后的状态
                if (i == selectedPosition) {
                    tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, selectedTabTextSize);
                    tab.setTextColor(selectedTabTextColor);
                    tab.setBackgroundColor(pstsVerTextCheckedBgColor);
                }
            }
        }
    }

    private void scrollToChild(int position, int offset) {
        if (tabCount == 0) {
            return;
        }
        int newScrollY = tabsContainer.getChildAt(position).getTop() + offset;
        if (position > 0 || offset > 0) {
            newScrollY -= scrollOffset;
        }
        if (newScrollY != lastScrollY) {
            lastScrollY = newScrollY;
            scrollTo(0, newScrollY);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isInEditMode() || tabCount == 0) {
            return;
        }
        // draw underline 绘制灰色竖线指示线
        rectPaint.setColor(underlineColor);
        // draw indicator line 绘制指示线
        rectPaint.setColor(indicatorColor);
        //2017-7-12 给textview 包了一层LinearLayout，为了使下滑线和文字宽度一致
        LinearLayout currentTab = (LinearLayout) tabsContainer.getChildAt(currentPosition);
        View currentText = currentTab.getChildAt(0);

        float lineTop = currentTab.getTop() + currentText.getTop();
        float lineButton = lineTop + currentText.getHeight();
        if (currentPositionOffset > 0f && currentPosition < tabCount - 1) {
            // 计算滑动条的偏移，因为滑动过程中是有偏移的
            //2017-7-12 给textview 包了一层LinearLayout，为了使下滑线和文字宽度一致
            LinearLayout nextTabLin = (LinearLayout) tabsContainer.getChildAt(currentPosition + 1);
            View nextTab = nextTabLin.getChildAt(0);
            final float nextTabTop = nextTab.getTop() + nextTabLin.getTop();
            final float nextTabButton = nextTabTop + nextTab.getHeight();
            lineTop = (currentPositionOffset * nextTabTop + (1f - currentPositionOffset) * lineTop);
            lineButton = (currentPositionOffset * nextTabButton + (1f - currentPositionOffset) * lineButton);
        }
        canvas.drawRect(0, lineTop, underlineWeight, lineButton, rectPaint);
    }

    private class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            currentPosition = position;
            currentPositionOffset = positionOffset;
            scrollToChild(position, (int) (positionOffset * tabsContainer.getChildAt(position).getWidth()));
            invalidate();
            if (delegatePageListener != null) {
                delegatePageListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                scrollToChild(pager.getCurrentItem(), 0);
            }
            if (delegatePageListener != null) {
                delegatePageListener.onPageScrollStateChanged(state);
            }
        }

        @Override
        public void onPageSelected(int position) {
            selectedPosition = position;
            updateTabStyles();
            if (delegatePageListener != null) {
                delegatePageListener.onPageSelected(position);
            }
        }
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.currentPosition = currentPosition;
        return savedState;
    }

    static class SavedState extends BaseSavedState {
        int currentPosition;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            currentPosition = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(currentPosition);
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

    public int getCurrentPosition() {
        return selectedPosition;
    }

}
