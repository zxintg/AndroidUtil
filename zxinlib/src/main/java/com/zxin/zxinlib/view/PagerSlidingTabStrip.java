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
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.util.UiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*****
 * tabbar公共 liukui 2018/01/05
 */
public class PagerSlidingTabStrip extends HorizontalScrollView {

    public interface IconTabProvider {
        public int getPageIconResId(int position);
    }

    // @formatter:off
    private static final int[] ATTRS = new int[]{android.R.attr.textSize, android.R.attr.textColor};
    // @formatter:on

    private LinearLayout.LayoutParams tabLayoutParams;

    private final PageListener pageListener = new PageListener();
    public ViewPager.OnPageChangeListener delegatePageListener;

    private LinearLayout tabsContainer;
    private RadioGroup tabsContainerIcn;
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

    private boolean shouldExpand = false;
    private boolean textAllCaps = true;

    private int scrollOffset = 20;//滚动条偏移量
    private int indicatorHeight = 8;
    private int underlineHeight = 2;
    private int dividerPadding = 12;
    private int dividerWidth = 1;
    private int pstsShowType = 0;
    private int pstsIndicatorWight = 0;

    //未选中，选中字体大小
    private int tabTextSize = 13;
    private int selectedTabTextSize = 15;
    //未选中，选中字体颜色
    private int tabTextColor = 0xFF666666;
    private int selectedTabTextColor = 0xFF666666;
    private Typeface tabTypeface = null;
    private int tabTypefaceStyle = Typeface.NORMAL;

    private int lastScrollX = 0;

    private int tabBackgroundResId = R.drawable.background_tab;

    private Locale locale;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        int ScreenWidth = SystemInfoUtil.getScreenWidth();
        setFillViewport(true);
        setWillNotDraw(false);

        scrollOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, scrollOffset, SystemInfoUtil.getDisplayMetrics());
        indicatorHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, indicatorHeight, SystemInfoUtil.getDisplayMetrics());
        underlineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, underlineHeight, SystemInfoUtil.getDisplayMetrics());
        dividerPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dividerPadding, SystemInfoUtil.getDisplayMetrics());
        dividerWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dividerWidth, SystemInfoUtil.getDisplayMetrics());
        tabTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, tabTextSize, SystemInfoUtil.getDisplayMetrics());
        selectedTabTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, selectedTabTextSize, SystemInfoUtil.getDisplayMetrics());

        // get system attrs (android:textSize and android:textColor)
        //系统的字体大小，颜色
        TypedArray a = context.obtainStyledAttributes(attrs, ATTRS);
        tabTextSize = a.getDimensionPixelSize(0, tabTextSize);
        tabTextColor = a.getColor(1, tabTextColor);

        a.recycle();

        // get custom attrs
        a = context.obtainStyledAttributes(attrs, R.styleable.PagerSlidingTabStrip);
        //选中字体大小，颜色
        selectedTabTextColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsSelectTabTextColor, selectedTabTextColor);
        selectedTabTextSize = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsSelectTabTextSize, selectedTabTextSize);

        indicatorColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, indicatorColor);
        underlineColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsUnderlineColor, underlineColor);
        dividerColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsDividerColor, dividerColor);
        indicatorHeight = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, indicatorHeight);
        underlineHeight = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsUnderlineHeight, underlineHeight);
        dividerPadding = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsDividerPadding, dividerPadding);
        tabBackgroundResId = a.getResourceId(R.styleable.PagerSlidingTabStrip_pstsTabBackground, tabBackgroundResId);
        shouldExpand = a.getBoolean(R.styleable.PagerSlidingTabStrip_pstsShouldExpand, shouldExpand);
        scrollOffset = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsScrollOffset, scrollOffset);
        textAllCaps = a.getBoolean(R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, textAllCaps);
        pstsShowType = a.getInt(R.styleable.PagerSlidingTabStrip_pstsShowType, 0);
        pstsIndicatorWight = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsIndicatorWight, ScreenWidth);

        a.recycle();

        rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setStyle(Style.FILL);

        dividerPaint = new Paint();
        dividerPaint.setAntiAlias(true);
        dividerPaint.setStrokeWidth(dividerWidth);

        pstsShowType = pstsShowType==1&&Build.VERSION.SDK_INT < Build.VERSION_CODES.M?0:pstsShowType;

        if (pstsShowType == 0) {
            //纯文本
            tabsContainer = new LinearLayout(context);
            tabsContainer.setOrientation(LinearLayout.HORIZONTAL);
            tabsContainer.setGravity(Gravity.CENTER);
            tabsContainer.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            addView(tabsContainer);
            tabLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        } else if (pstsShowType == 1) {
            //纯图片
            tabsContainerIcn = new RadioGroup(context);
            tabsContainerIcn.setOrientation(LinearLayout.HORIZONTAL);
            tabsContainerIcn.setLayoutParams(new LayoutParams(shouldExpand ? LayoutParams.MATCH_PARENT : LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            addView(tabsContainerIcn);
        }

        if (locale == null) {
            locale = getResources().getConfiguration().locale;
        }
        setBackgroundResource(tabBackgroundResId);
        pstsIndicatorWight = pstsIndicatorWight < ScreenWidth ? pstsIndicatorWight : ScreenWidth;
    }

    public void setViewPager(ViewPager pager) {
        this.pager = pager;
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        pager.setOnPageChangeListener(pageListener);
        notifyDataSetChanged();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.delegatePageListener = listener;
    }

    public void notifyDataSetChanged() {
        if (pstsShowType == 0) {
            tabsContainer.removeAllViews();
        } else if (pstsShowType == 1) {
            tabsContainerIcn.removeAllViews();
            resIdList.clear();
        }

        tabCount = pager.getAdapter().getCount();
        for (int i = 0; i < tabCount; i++) {
            if (pstsShowType == 0||Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                addTextTab(i, pager.getAdapter().getPageTitle(i).toString(), tabCount);
            } else if (pstsShowType == 1) {
                addIconTab(i,pager.getAdapter().getPageTitle(i).toString(),((IconTabProvider) pager.getAdapter()).getPageIconResId(i));
            }
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

        if (pstsShowType == 1) {
            tabsContainerIcn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    pager.setCurrentItem(resIdList.indexOf(checkedId));
                }
            });
            tabsContainerIcn.check(resIdList.get(0));
        }
    }

    private void addTextTab(final int position, String title, int tabCount) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        TextView tab = new TextView(getContext());
        if (shouldExpand||((!shouldExpand)&&pager.getAdapter().getCount()<=5)) {
            //平分
            LayoutParams params = new LayoutParams(pstsIndicatorWight / tabCount, LayoutParams.WRAP_CONTENT);
            tab.setLayoutParams(params);
        }
        int padd = SystemInfoUtil.dip2px(10);
        tab.setPadding(padd, padd, padd, padd);
        tab.setText(title);
        tab.setGravity(Gravity.CENTER);
        tab.setSingleLine();
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(tab);
        addTab(position, linearLayout);
    }

    private List<Integer> resIdList = new ArrayList<>();

    private void addIconTab(int position,String mesg, int resId) {
        MyRadioButton radioButtton = new MyRadioButton(getContext());
        if (shouldExpand||((!shouldExpand)&&pager.getAdapter().getCount()<=5)) {
            //平分
            LayoutParams params = new LayoutParams(pstsIndicatorWight / tabCount, LayoutParams.WRAP_CONTENT);
            radioButtton.setLayoutParams(params);
        }
        int padd = SystemInfoUtil.dip2px(15);
        radioButtton.setPadding(padd, padd, padd, padd);
        radioButtton.setGravity(Gravity.CENTER);
        radioButtton.setButtonDrawable(UiUtils.getDrawable(resId));
        if (!BaseStringUtils.textIsEmpty(mesg)) {
            radioButtton.setTextSize(TypedValue.COMPLEX_UNIT_PX, tabTextSize);
            radioButtton.setText(mesg);
        }
        addTab(position, radioButtton);
    }

    private void addTab(final int position, View tab) {
        if (pstsShowType == 0) {
            tab.setFocusable(true);
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    pager.setCurrentItem(position);
                }
            });
            tabsContainer.addView(tab, position, tabLayoutParams);
        } else if (pstsShowType == 1) {
            tabsContainerIcn.addView(tab, position);
            resIdList.add(position, tab.getId());
        }
    }

    private void updateTabStyles() {
        for (int i = 0; i < tabCount; i++) {
            if (pstsShowType == 0) {
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
                    //设置选中后的状态
                    if (i == selectedPosition) {
                        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, selectedTabTextSize);
                        tab.setTextColor(selectedTabTextColor);
                    }
                }
            } else if (pstsShowType==1){
                RadioButton radioButton = (RadioButton) tabsContainerIcn.getChildAt(i);
                radioButton.setTextColor(tabTextColor);
                //设置选中后的状态
                if (i == selectedPosition) {
                    radioButton.setTextColor(selectedTabTextColor);
                }
            }
        }
    }

    private void scrollToChild(int position, int offset) {
        if (tabCount == 0) {
            return;
        }
        int newScrollX = 0;
        if (pstsShowType == 0) {
            newScrollX = tabsContainer.getChildAt(position).getLeft() + offset;
        } else if (pstsShowType == 1) {
            newScrollX = tabsContainerIcn.getChildAt(position).getLeft() + offset;
        }
        if (position > 0 || offset > 0) {
            newScrollX -= scrollOffset;
        }
        if (newScrollX != lastScrollX) {
            lastScrollX = newScrollX;
            scrollTo(newScrollX, 0);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isInEditMode() || tabCount == 0) {
            return;
        }
        final int height = getHeight();
        // draw underline 绘制灰色横线指示线
        rectPaint.setColor(underlineColor);
        if (pstsShowType == 0) {
            canvas.drawRect(0, height - underlineHeight, tabsContainer.getWidth(), height, rectPaint);
        } else if (pstsShowType == 1) {
            canvas.drawRect(0, height - underlineHeight, tabsContainerIcn.getWidth(), height, rectPaint);
        }
        // draw indicator line 绘制指示线
        rectPaint.setColor(indicatorColor);
        //2017-7-12 给textview 包了一层LinearLayout，为了使下滑线和文字宽度一致
        if (pstsShowType == 0) {
            LinearLayout currentTab = (LinearLayout) tabsContainer.getChildAt(currentPosition);
            View currentText = currentTab.getChildAt(0);

            float lineLeft = currentTab.getLeft() + currentText.getLeft();
            float lineRight = lineLeft + currentText.getWidth();
            if (currentPositionOffset > 0f && currentPosition < tabCount - 1) {
                // 计算滑动条的偏移，因为滑动过程中是有偏移的
                //2017-7-12 给textview 包了一层LinearLayout，为了使下滑线和文字宽度一致
                LinearLayout nextTabLin = (LinearLayout) tabsContainer.getChildAt(currentPosition + 1);
                View nextTab = nextTabLin.getChildAt(0);
                final float nextTabLeft = nextTab.getLeft() + nextTabLin.getLeft();
                final float nextTabRight = nextTabLeft + nextTab.getWidth();
                lineLeft = (currentPositionOffset * nextTabLeft + (1f - currentPositionOffset) * lineLeft);
                lineRight = (currentPositionOffset * nextTabRight + (1f - currentPositionOffset) * lineRight);
            }
            int excursion = 0;
            if (currentText instanceof TextView) {
                int width = ((TextView) currentText).getText().toString().length() * selectedTabTextSize;
                //excursion = ((currentText.getWidth() - width)/2)-10;
                excursion = (currentText.getWidth() - width) / 2;
            }
            canvas.drawRect(lineLeft + excursion, height - indicatorHeight, lineRight - excursion, height, rectPaint);
            // draw divider 分割线
            dividerPaint.setColor(dividerColor);
            for (int i = 0; i < tabCount - 1; i++) {
                View tab = tabsContainer.getChildAt(i);
                canvas.drawLine(tab.getRight(), dividerPadding, tab.getRight(), height - dividerPadding, dividerPaint);
            }
        } else if (pstsShowType == 1) {
            RadioButton currentTab = (RadioButton) tabsContainerIcn.getChildAt(currentPosition);
            float lineLeft = currentTab.getLeft();
            float lineRight = lineLeft + currentTab.getWidth();
            if (currentPositionOffset > 0f && currentPosition < tabCount - 1) {
                // 计算滑动条的偏移，因为滑动过程中是有偏移的
                //2017-7-12 给textview 包了一层LinearLayout，为了使下滑线和文字宽度一致
                RadioButton nextTabLin = (RadioButton) tabsContainerIcn.getChildAt(currentPosition + 1);
                final float nextTabLeft = nextTabLin.getLeft();
                final float nextTabRight = nextTabLeft + nextTabLin.getWidth();
                lineLeft = (currentPositionOffset * nextTabLeft + (1f - currentPositionOffset) * lineLeft);
                lineRight = (currentPositionOffset * nextTabRight + (1f - currentPositionOffset) * lineRight);
            }
            int excursion = (currentTab.getWidth() - SystemInfoUtil.dip2px(22)) / 2;
            canvas.drawRect(lineLeft + excursion, height - indicatorHeight, lineRight - excursion, height, rectPaint);
            // draw divider 分割线
            dividerPaint.setColor(dividerColor);
            for (int i = 0; i < tabCount - 1; i++) {
                View tab = tabsContainerIcn.getChildAt(i);
                canvas.drawLine(tab.getRight(), dividerPadding, tab.getRight(), height - dividerPadding, dividerPaint);
            }
        }
    }

    private class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            currentPosition = position;
            currentPositionOffset = positionOffset;
            if (pstsShowType == 0) {
                scrollToChild(position, (int) (positionOffset * tabsContainer.getChildAt(position).getWidth()));
            } else if (pstsShowType == 1) {
                scrollToChild(position, (int) (positionOffset * tabsContainerIcn.getChildAt(position).getWidth()));
            }
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
            if (pstsShowType == 1) {
                tabsContainerIcn.check(resIdList.get(position));
            }
        }

    }

    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
        invalidate();
    }

    public void setIndicatorColorResource(int resId) {
        this.indicatorColor = getResources().getColor(resId);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorHeight(int indicatorLineHeightPx) {
        this.indicatorHeight = indicatorLineHeightPx;
        invalidate();
    }

    public int getIndicatorHeight() {
        return indicatorHeight;
    }

    public void setUnderlineColor(int underlineColor) {
        this.underlineColor = underlineColor;
        invalidate();
    }

    public void setUnderlineColorResource(int resId) {
        this.underlineColor = getResources().getColor(resId);
        invalidate();
    }

    public int getUnderlineColor() {
        return underlineColor;
    }

    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
        invalidate();
    }

    public void setDividerColorResource(int resId) {
        this.dividerColor = getResources().getColor(resId);
        invalidate();
    }

    public int getDividerColor() {
        return dividerColor;
    }

    public void setUnderlineHeight(int underlineHeightPx) {
        this.underlineHeight = underlineHeightPx;
        invalidate();
    }

    public int getUnderlineHeight() {
        return underlineHeight;
    }

    public void setDividerPadding(int dividerPaddingPx) {
        this.dividerPadding = dividerPaddingPx;
        invalidate();
    }

    public int getDividerPadding() {
        return dividerPadding;
    }

    public void setScrollOffset(int scrollOffsetPx) {
        this.scrollOffset = scrollOffsetPx;
        invalidate();
    }

    public int getScrollOffset() {
        return scrollOffset;
    }

    public void setShouldExpand(boolean shouldExpand) {
        this.shouldExpand = shouldExpand;
        notifyDataSetChanged();
    }

    public boolean getShouldExpand() {
        return shouldExpand;
    }

    public boolean isTextAllCaps() {
        return textAllCaps;
    }

    public void setAllCaps(boolean textAllCaps) {
        this.textAllCaps = textAllCaps;
    }

    public void setTextSize(int textSizePx) {
        this.tabTextSize = textSizePx;
        updateTabStyles();
    }

    public void setSelectTextSize(int textSizePx) {
        this.selectedTabTextSize = textSizePx;
        updateTabStyles();
    }

    public int getTextSize() {
        return tabTextSize;
    }

    public void setTextColor(int textColor) {
        this.tabTextColor = textColor;
        updateTabStyles();
    }

    public void setTextColorResource(int resId) {
        this.tabTextColor = getResources().getColor(resId);
        updateTabStyles();
    }

    public int getTextColor() {
        return tabTextColor;
    }

    public void setSelectedTextColor(int textColor) {
        this.selectedTabTextColor = textColor;
        updateTabStyles();
    }

    public void setSelectedTextColorResource(int resId) {
        this.selectedTabTextColor = getResources().getColor(resId);
        updateTabStyles();
    }

    public int getSelectedTextColor() {
        return selectedTabTextColor;
    }

    public void setTypeface(Typeface typeface, int style) {
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = style;
        updateTabStyles();
    }

    public void setTabBackground(int resId) {
        this.tabBackgroundResId = resId;
        updateTabStyles();
    }

    public int getTabBackground() {
        return tabBackgroundResId;
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

    public int getCurrentPosition(){
        return selectedPosition;
    }

}
