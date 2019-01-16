package com.zxin.ncalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

import com.zxin.ncalendar.adapter.CalendarAdapter;
import com.zxin.ncalendar.utils.CalendarAttrs;
import com.zxin.ncalendar.utils.CalendarUtils;
import com.zxin.ncalendar.view.CalendarView;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by necer on 2017/8/25.
 * QQ群:127278900
 */

public abstract class CalendarPager extends ViewPager {

    protected CalendarAdapter calendarAdapter;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int mPageSize;
    protected int mCurrPage;
    protected LocalDate mInitialDate;//日历初始化date，即今天
    protected LocalDate mSelectDate;//当前页面选中的date
    protected List<String> pointList;//圆点

    protected boolean isPagerChanged = true;//是否是手动翻页
    protected LocalDate lastSelectDate;//上次选中的date
    protected boolean isDefaultSelect = true;//是否默认选中


    private OnPageChangeListener onPageChangeListener;

    public CalendarPager(Context context) {
        this(context, null);
    }

    public CalendarPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NCalendar);
        CalendarAttrs.solarTextColor = ta.getColor(R.styleable.NCalendar_solarTextColor, getResources().getColor(R.color.solarTextColor));
        CalendarAttrs.lunarTextColor = ta.getColor(R.styleable.NCalendar_lunarTextColor, getResources().getColor(R.color.lunarTextColor));
        CalendarAttrs.selectCircleColor = ta.getColor(R.styleable.NCalendar_selectCircleColor, getResources().getColor(R.color.selectCircleColor));
        CalendarAttrs.hintColor = ta.getColor(R.styleable.NCalendar_hintColor, getResources().getColor(R.color.hintColor));
        CalendarAttrs.solarTextSize = ta.getDimension(R.styleable.NCalendar_solarTextSize, CalendarUtils.sp2px(context, 18));
        CalendarAttrs.lunarTextSize = ta.getDimension(R.styleable.NCalendar_lunarTextSize, CalendarUtils.sp2px(context, 10));
        CalendarAttrs.selectCircleRadius = ta.getDimension(R.styleable.NCalendar_selectCircleRadius, CalendarUtils.dp2px(context, 20));

        CalendarAttrs.isShowLunar = ta.getBoolean(R.styleable.NCalendar_isShowLunar, true);

        CalendarAttrs.pointSize = ta.getDimension(R.styleable.NCalendar_pointSize, (int) CalendarUtils.dp2px(context, 2));
        CalendarAttrs.pointColor = ta.getColor(R.styleable.NCalendar_pointColor, getResources().getColor(R.color.pointColor));
        CalendarAttrs.hollowCircleColor = ta.getColor(R.styleable.NCalendar_hollowCircleColor, Color.WHITE);
        CalendarAttrs.hollowCircleStroke = ta.getDimension(R.styleable.NCalendar_hollowCircleStroke, CalendarUtils.dp2px(context, 1));


        CalendarAttrs.monthCalendarHeight = (int) ta.getDimension(R.styleable.NCalendar_calendarHeight, CalendarUtils.dp2px(context, 300));
        CalendarAttrs.duration = ta.getInt(R.styleable.NCalendar_duration, 240);

        CalendarAttrs.isShowHoliday = ta.getBoolean(R.styleable.NCalendar_isShowHoliday, true);
        CalendarAttrs.holidayColor = ta.getColor(R.styleable.NCalendar_holidayColor, getResources().getColor(R.color.holidayColor));
        CalendarAttrs.workdayColor = ta.getColor(R.styleable.NCalendar_workdayColor, getResources().getColor(R.color.workdayColor));

        CalendarAttrs.backgroundColor = ta.getColor(R.styleable.NCalendar_backgroundColor, getResources().getColor(R.color.white));

        String firstDayOfWeek = ta.getString(R.styleable.NCalendar_firstDayOfWeek);
        String defaultCalendar = ta.getString(R.styleable.NCalendar_defaultCalendar);

        String startString = ta.getString(R.styleable.NCalendar_startDate);
        String endString = ta.getString(R.styleable.NCalendar_endDate);

        CalendarAttrs.firstDayOfWeek = "Monday".equals(firstDayOfWeek) ? 1 : 0;
        CalendarAttrs.defaultCalendar = "Week".equals(defaultCalendar) ? NCalendar.WEEK : NCalendar.MONTH;

        ta.recycle();

        mInitialDate = new LocalDate();

        startDate = new LocalDate(startString == null ? "1901-01-01" : startString);
        endDate = new LocalDate(endString == null ? "2099-12-31" : endString);

        setDateInterval(null, null);

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                initCurrentCalendarView(mCurrPage);
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

        setBackgroundColor(CalendarAttrs.backgroundColor);
    }

    public void setDateInterval(String startString,String endString) {
        if (startString != null && !"".equals(startString)) {
            startDate = new LocalDate(startString);
        }
        if (endString != null && !"".equals(endString)) {
            endDate = new LocalDate(endString);
        }

        if (mInitialDate.isBefore(startDate) || mInitialDate.isAfter(endDate)) {
            throw new RuntimeException(getResources().getString(R.string.range_date));
        }

        calendarAdapter = getCalendarAdapter();
        setAdapter(calendarAdapter);
        setCurrentItem(mCurrPage);


        if (onPageChangeListener != null) {
            removeOnPageChangeListener(onPageChangeListener);
        }

        onPageChangeListener = new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initCurrentCalendarView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        addOnPageChangeListener(onPageChangeListener);

    }

    protected abstract CalendarAdapter getCalendarAdapter();

    protected abstract void initCurrentCalendarView(int position);

    protected abstract void setDate(LocalDate date);

    public void toToday() {
        setDate(new LocalDate());
    }


    /**
     * 下一页，月日历即是下一月，周日历即是下一周
     */
    public void toNextPager() {
        setCurrentItem(getCurrentItem() + 1, true);
    }

    /**
     * 上一页
     */
    public void toLastPager() {
        setCurrentItem(getCurrentItem() - 1, true);
    }

    //设置日期
    public void setDate(String formatDate) {
        setDate(new LocalDate(formatDate));
    }

    public void setPointList(List<String> pointList) {

        List<String> formatList = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            String format = new LocalDate(pointList.get(i)).toString("yyyy-MM-dd");
            formatList.add(format);
        }

        this.pointList = formatList;
        CalendarView calendarView = calendarAdapter.getCalendarViews().get(getCurrentItem());
        if (calendarView == null) {
            return;
        }
        calendarView.setPointList(formatList);
    }

    public void setDefaultSelect(boolean defaultSelect) {
        isDefaultSelect = defaultSelect;
    }

}
