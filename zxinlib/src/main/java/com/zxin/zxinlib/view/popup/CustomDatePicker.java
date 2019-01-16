package com.zxin.zxinlib.view.popup;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by liukui on 2016/9/28.
 */
public class CustomDatePicker {
    public enum SCROLL_TYPE {
        HOUR(1),
        MINUTE(2),
        SECOND(3);

        SCROLL_TYPE(int value) {
            this.value = value;
        }

        public int value;
    }

    private int scrollUnits = SCROLL_TYPE.HOUR.value + SCROLL_TYPE.MINUTE.value;
    private boolean canAccess = false;
    private PickerToolsView year_pv, month_pv, day_pv, hour_pv, minute_pv, sec_pv;
    private static final int MAX_SECONDS = 59;
    private static final int MAX_MINUTE = 59;
    private static final int MAX_HOUR = 23;
    private static final int MIN_SECONDS = 0;
    private static final int MIN_MINUTE = 0;
    private static final int MIN_HOUR = 0;
    private static final int MAX_MONTH = 12;

    private ArrayList<String> year, month, day, hour, minute, second;
    private int startYear, startMonth, startDay, startHour, startMinute, startSecond, endYear, endMonth, endDay, endHour, endMinute, endSecond;
    private boolean spanYear, spanMon, spanDay, spanHour, spanMin, spanSec;
    public Calendar selectedCalender, startCalendar, endCalendar;
    private String format = "yyyy-MM-dd HH:mm:ss";

    /*****
     * 实例化
     * @param startDate
     * @param endDate
     * @param format
     */
    public CustomDatePicker(String startDate, String endDate, String format) {
        try {
            this.format = TextUtils.isEmpty(format) ? this.format : format;
            startDate = TextUtils.isEmpty(startDate) ? new SimpleDateFormat(this.format).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1900-01-01 00:00:00")) : startDate;
            Calendar time = Calendar.getInstance();
            endDate = TextUtils.isEmpty(endDate) ? new SimpleDateFormat(this.format).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(time.get(Calendar.YEAR) + 10 + "-" + (time.get(Calendar.MONTH) + 1) + "-" + time.get(Calendar.DAY_OF_MONTH) + " 00:00:00")) : endDate;
            if (isValidDate(startDate) && isValidDate(endDate)) {
                canAccess = true;
                selectedCalender = Calendar.getInstance();
                startCalendar = Calendar.getInstance();
                endCalendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat(this.format, Locale.CHINA);
                startCalendar.setTime(sdf.parse(startDate));
                endCalendar.setTime(sdf.parse(endDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /****
     * 初始化组件
     */
    public void initView(PickerToolsView oneView,PickerToolsView twoView,PickerToolsView threeView,PickerToolsView fourView,PickerToolsView fiveView,PickerToolsView sixView) {
        switch (format) {
            case "yyyy-MM-dd HH:mm:ss"://yyyy-MM-dd HH:mm:ss
                year_pv = oneView;
                month_pv = twoView;
                day_pv = threeView;
                hour_pv = fourView;
                minute_pv = fiveView;
                sec_pv = sixView;
                break;

            case "yyyy-MM-dd HH:mm"://yyyy-MM-dd HH:mm
                year_pv = oneView;
                month_pv = twoView;
                day_pv = threeView;
                hour_pv = fourView;
                minute_pv = fiveView;
                break;

            case "yyyy-MM"://yyyy-MM
                year_pv = oneView;
                month_pv = twoView;
                break;

            case "yyyy-MM-dd"://yyyy-MM-dd
                year_pv = oneView;
                month_pv = twoView;
                day_pv = threeView;
                break;

            case "MM-dd"://MM-dd
                month_pv = oneView;
                day_pv = twoView;
                break;

            case "HH:mm:ss"://HH:mm:ss
                hour_pv = oneView;
                minute_pv = twoView;
                sec_pv = threeView;
                break;

            case "HH:mm"://HH:mm
                hour_pv = oneView;
                minute_pv = twoView;
                break;
        }
        initArrayList();
        setViewVISIBLE();
    }

    /*****
     * 初始化数据
     */
    private void initArrayList() {
        if(year_pv!=null){
            if (year == null) year = new ArrayList<>();
            year.clear();
        }

        if(month_pv!=null){
            if (month == null) month = new ArrayList<>();
            month.clear();
        }

        if(day_pv!=null){
            if (day == null) day = new ArrayList<>();
            day.clear();
        }

        if(hour_pv!=null){
            if (hour == null) hour = new ArrayList<>();
            hour.clear();
        }

        if(minute_pv!=null){
            if (minute == null) minute = new ArrayList<>();
            minute.clear();
        }

        if(sec_pv!=null){
            if (second == null) second = new ArrayList<>();
            second.clear();
        }
    }

    private void setViewVISIBLE() {
        if(year_pv!=null){
            year_pv.setVisibility(View.VISIBLE);//年
        }
        if(month_pv!=null){
            month_pv.setVisibility(View.VISIBLE);//月
        }
        if(day_pv!=null){
            day_pv.setVisibility(View.VISIBLE);//日
        }
        if(hour_pv!=null){
            hour_pv.setVisibility(View.VISIBLE);//时
        }
        if(minute_pv!=null){
            minute_pv.setVisibility(View.VISIBLE);//分
        }
        if(sec_pv!=null){
            sec_pv.setVisibility(View.VISIBLE);//秒
        }
    }

    public void setDateRange(String startDate, String endDate){
        try {
            startDate = TextUtils.isEmpty(startDate) ? new SimpleDateFormat(this.format).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1900-01-01 00:00:00")) : startDate;
            Calendar time = Calendar.getInstance();
            endDate = TextUtils.isEmpty(endDate) ? new SimpleDateFormat(this.format).format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(time.get(Calendar.YEAR) + 10 + "-" + (time.get(Calendar.MONTH) + 1) + "-" + time.get(Calendar.DAY_OF_MONTH) + " 00:00:00")) : endDate;
            if (isValidDate(startDate) && isValidDate(endDate)) {
                canAccess = true;
                startCalendar = Calendar.getInstance();
                endCalendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat(this.format, Locale.CHINA);
                startCalendar.setTime(sdf.parse(startDate));
                endCalendar.setTime(sdf.parse(endDate));
            } else{
                canAccess = false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*****
     * 显示数据
     * @param time
     */
    public void show(String time) {
        if (canAccess) {
            if (isValidDate(time)) {
                canAccess = true;
                initParameter();
                initTimer();
                loadComponent();
                addListener();
                setSelectedTime(time);
            } else {
                canAccess = false;
            }
        }
    }

    private void initParameter() {
        startYear = startCalendar.get(Calendar.YEAR);
        startMonth = startCalendar.get(Calendar.MONTH) + 1;
        startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
        startHour = startCalendar.get(Calendar.HOUR_OF_DAY);
        startMinute = startCalendar.get(Calendar.MINUTE);
        startSecond = startCalendar.get(Calendar.SECOND);
        endYear = endCalendar.get(Calendar.YEAR);
        endMonth = endCalendar.get(Calendar.MONTH) + 1;
        endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
        endHour = endCalendar.get(Calendar.HOUR_OF_DAY);
        endMinute = endCalendar.get(Calendar.MINUTE);
        endSecond = endCalendar.get(Calendar.SECOND);
        spanYear = startYear != endYear;
        spanMon = (!spanYear) && (startMonth != endMonth);
        spanDay = (!spanMon) && (startDay != endDay);
        spanHour = (!spanDay) && (startHour != endHour);
        spanMin = (!spanHour) && (startMinute != endMinute);
        spanSec = (!spanMin) && (startSecond != endSecond);
    }

    private void initTimer() {
        if (spanYear) {
            if(year!=null)
                for (int i = startYear; i <= endYear; i++) {
                    year.add(String.valueOf(i));
                }
            if(month!=null)
                for (int i = startMonth; i <= MAX_MONTH; i++) {
                    month.add(formatTimeUnit(i));
                }

            if(day!=null)
                for (int i = startDay; i <= startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                    day.add(formatTimeUnit(i));
                }
            if(hour!=null)
                if ((scrollUnits & SCROLL_TYPE.HOUR.value) != SCROLL_TYPE.HOUR.value) {
                    hour.add(formatTimeUnit(startHour));
                } else {
                    for (int i = startHour; i <= MAX_HOUR; i++) {
                        hour.add(formatTimeUnit(i));
                    }
                }

            if(minute!=null)
                if ((scrollUnits & SCROLL_TYPE.MINUTE.value) != SCROLL_TYPE.MINUTE.value) {
                    minute.add(formatTimeUnit(startMinute));
                } else {
                    for (int i = startMinute; i <= MAX_MINUTE; i++) {
                        minute.add(formatTimeUnit(i));
                    }
                }
            if(second!=null)
                if ((scrollUnits & SCROLL_TYPE.SECOND.value) != SCROLL_TYPE.SECOND.value) {
                    second.add(formatTimeUnit(startSecond));
                } else {
                    for (int i = startSecond; i <= endSecond; i++) {
                        second.add(formatTimeUnit(i));
                    }
                }
        } else if (spanMon) {
            if(year!=null)
                year.add(String.valueOf(startYear));

            if(month!=null)
                for (int i = startMonth; i <= endMonth; i++) {
                    month.add(formatTimeUnit(i));
                }

            if(day!=null)
            for (int i = startDay; i <= startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }

            if(hour!=null)
                if ((scrollUnits & SCROLL_TYPE.HOUR.value) != SCROLL_TYPE.HOUR.value) {
                    hour.add(formatTimeUnit(startHour));
                } else {
                    for (int i = startHour; i <= MAX_HOUR; i++) {
                        hour.add(formatTimeUnit(i));
                    }
                }
            if(minute!=null)
                if ((scrollUnits & SCROLL_TYPE.MINUTE.value) != SCROLL_TYPE.MINUTE.value) {
                    minute.add(formatTimeUnit(startMinute));
                } else {
                    for (int i = startMinute; i <= MAX_MINUTE; i++) {
                        minute.add(formatTimeUnit(i));
                    }
                }
            if(second!=null)
                if ((scrollUnits & SCROLL_TYPE.SECOND.value) != SCROLL_TYPE.SECOND.value) {
                    second.add(formatTimeUnit(startSecond));
                } else {
                    for (int i = startSecond; i <= endSecond; i++) {
                        second.add(formatTimeUnit(i));
                    }
                }
        } else if (spanDay) {
            if(year!=null)
                year.add(String.valueOf(startYear));
            if(month!=null)
                month.add(formatTimeUnit(startMonth));
            if(day!=null)
                for (int i = startDay; i <= endDay; i++) {
                    day.add(formatTimeUnit(i));
                }
            if(hour!=null)
                if ((scrollUnits & SCROLL_TYPE.HOUR.value) != SCROLL_TYPE.HOUR.value) {
                    hour.add(formatTimeUnit(startHour));
                } else {
                    for (int i = startHour; i <= MAX_HOUR; i++) {
                        hour.add(formatTimeUnit(i));
                    }
                }
            if(minute!=null)
                if ((scrollUnits & SCROLL_TYPE.MINUTE.value) != SCROLL_TYPE.MINUTE.value) {
                    minute.add(formatTimeUnit(startMinute));
                } else {
                    for (int i = startMinute; i <= MAX_MINUTE; i++) {
                        minute.add(formatTimeUnit(i));
                    }
                }
            if(second!=null)
                if ((scrollUnits & SCROLL_TYPE.SECOND.value) != SCROLL_TYPE.SECOND.value) {
                    second.add(formatTimeUnit(startSecond));
                } else {
                    for (int i = startSecond; i <= endSecond; i++) {
                        second.add(formatTimeUnit(i));
                    }
                }
        } else if (spanHour) {
            if(year!=null)
                year.add(String.valueOf(startYear));
            if(month!=null)
                month.add(formatTimeUnit(startMonth));
            if(day!=null)
                day.add(formatTimeUnit(startDay));

            if(hour!=null)
                if ((scrollUnits & SCROLL_TYPE.HOUR.value) != SCROLL_TYPE.HOUR.value) {
                    hour.add(formatTimeUnit(startHour));
                } else {
                    for (int i = startHour; i <= endHour; i++) {
                        hour.add(formatTimeUnit(i));
                    }
                }

            if(minute!=null)
                if ((scrollUnits & SCROLL_TYPE.MINUTE.value) != SCROLL_TYPE.MINUTE.value) {
                    minute.add(formatTimeUnit(startMinute));
                } else {
                    for (int i = startMinute; i <= MAX_MINUTE; i++) {
                        minute.add(formatTimeUnit(i));
                    }
                }
            if(second!=null)
                if ((scrollUnits & SCROLL_TYPE.SECOND.value) != SCROLL_TYPE.SECOND.value) {
                    second.add(formatTimeUnit(startSecond));
                } else {
                    for (int i = startSecond; i <= endSecond; i++) {
                        second.add(formatTimeUnit(i));
                    }
                }
        } else if (spanMin) {
            if(year!=null)
                year.add(String.valueOf(startYear));
            if(month!=null)
                month.add(formatTimeUnit(startMonth));
            if(day!=null)
                day.add(formatTimeUnit(startDay));
            if(hour!=null)
                hour.add(formatTimeUnit(startHour));

            if(minute!=null)
                if ((scrollUnits & SCROLL_TYPE.MINUTE.value) != SCROLL_TYPE.MINUTE.value) {
                    minute.add(formatTimeUnit(startMinute));
                } else {
                    for (int i = startMinute; i <= endMinute; i++) {
                        minute.add(formatTimeUnit(i));
                    }
                }
            if(second!=null)
                if ((scrollUnits & SCROLL_TYPE.SECOND.value) != SCROLL_TYPE.SECOND.value) {
                    second.add(formatTimeUnit(startSecond));
                } else {
                    for (int i = startSecond; i <= endSecond; i++) {
                        second.add(formatTimeUnit(i));
                    }
                }
        }else if(spanSec){
            if(year!=null)
                year.add(String.valueOf(startYear));
            if(month!=null)
                month.add(formatTimeUnit(startMonth));
            if(day!=null)
                day.add(formatTimeUnit(startDay));
            if(hour!=null)
                hour.add(formatTimeUnit(startHour));
            if(minute!=null)
                minute.add(formatTimeUnit(startMinute));
            if(second!=null)
                if ((scrollUnits & SCROLL_TYPE.SECOND.value) != SCROLL_TYPE.SECOND.value) {
                    second.add(formatTimeUnit(startSecond));
                } else {
                    for (int i = startSecond; i <= endSecond; i++) {
                        second.add(formatTimeUnit(i));
                    }
                }
        }
    }

    private void loadComponent() {
        if (year_pv != null) {
            year_pv.setData(year);
            year_pv.setSelected(0);
        }
        if (month_pv != null) {
            month_pv.setData(month);
            month_pv.setSelected(0);
        }
        if (day_pv != null) {
            day_pv.setData(day);
            day_pv.setSelected(0);
        }
        if (hour_pv != null) {
            hour_pv.setData(hour);
            hour_pv.setSelected(0);
        }
        if (minute_pv != null) {
            minute_pv.setData(minute);
            minute_pv.setSelected(0);
        }
        if (sec_pv != null) {
            sec_pv.setData(second);
            sec_pv.setSelected(0);
        }
        executeScroll();
    }

    private void addListener() {
        if (year_pv != null)
            year_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    selectedCalender.set(Calendar.YEAR, Integer.parseInt(text));
                    if(month_pv!=null)
                    monthChange();
                }
            });

        if (month_pv != null)
            month_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    selectedCalender.set(Calendar.DAY_OF_MONTH, 1);
                    selectedCalender.set(Calendar.MONTH, Integer.parseInt(text) - 1);
                    if(day_pv!=null)
                        dayChange();
                }
            });

        if (day_pv != null)
            day_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(text));
                    if(hour_pv!=null)
                        hourChange();
                }
            });

        if (hour_pv != null)
            hour_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    selectedCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(text));
                    if(minute_pv!=null)
                        minuteChange();
                }
            });

        if (minute_pv != null)
            minute_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    selectedCalender.set(Calendar.MINUTE, Integer.parseInt(text));
                    if(sec_pv!=null)
                        secondChange();
                }
            });

        if (sec_pv != null)
            sec_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    selectedCalender.set(Calendar.SECOND, Integer.parseInt(text));
                }
            });
    }
    //月份选择
    private void monthChange() {
        if(month.isEmpty())
            return;
        month.clear();
        int selectedYear = selectedCalender.get(Calendar.YEAR);
        if (selectedYear == startYear) {
            for (int i = startMonth; i <= MAX_MONTH; i++) {
                month.add(formatTimeUnit(i));
            }
        } else if (selectedYear == endYear) {
            for (int i = 1; i <= endMonth; i++) {
                month.add(formatTimeUnit(i));
            }
        } else {
            for (int i = 1; i <= MAX_MONTH; i++) {
                month.add(formatTimeUnit(i));
            }
        }
        selectedCalender.set(Calendar.MONTH, Integer.parseInt(month.get(0)) - 1);
        month_pv.setData(month);
        month_pv.setSelected(0);
        executeAnimator(month_pv);
        if(day_pv==null){
            executeScroll();
            return;
        }
        month_pv.postDelayed(new Runnable() {
            @Override
            public void run() {
                dayChange();
            }
        }, 100);
    }

    //日期选择
    private void dayChange() {
        if(day.isEmpty())
            return;
        day.clear();
        int selectedYear = selectedCalender.get(Calendar.YEAR);
        int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
        if (selectedYear == startYear && selectedMonth == startMonth) {
            for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }
        } else if (selectedYear == endYear && selectedMonth == endMonth) {
            for (int i = 1; i <= endDay; i++) {
                day.add(formatTimeUnit(i));
            }
        } else {
            for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                day.add(formatTimeUnit(i));
            }
        }
        selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day.get(0)));
        day_pv.setData(day);
        day_pv.setSelected(0);
        executeAnimator(day_pv);
        if(hour_pv==null){
            executeScroll();
            return;
        }
        day_pv.postDelayed(new Runnable() {
            @Override
            public void run() {
                hourChange();
            }
        }, 100);
    }
    //小时选择
    private void hourChange() {
        if(hour.isEmpty())
            return;
        if ((scrollUnits & SCROLL_TYPE.HOUR.value) == SCROLL_TYPE.HOUR.value) {
            hour.clear();
            int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
            if (selectedDay == startDay) {
                for (int i = startHour; i <= MAX_HOUR; i++) {
                    hour.add(formatTimeUnit(i));
                }
            } else if (selectedDay == endDay) {
                for (int i = MIN_HOUR; i <= endHour; i++) {
                    hour.add(formatTimeUnit(i));
                }
            } else {
                for (int i = MIN_HOUR; i <= MAX_HOUR; i++) {
                    hour.add(formatTimeUnit(i));
                }
            }
            selectedCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour.get(0)));
            hour_pv.setData(hour);
            hour_pv.setSelected(0);
            executeAnimator(hour_pv);
        }
        if(minute_pv==null){
            executeScroll();
            return;
        }
        hour_pv.postDelayed(new Runnable() {
            @Override
            public void run() {
                minuteChange();
            }
        }, 100);
    }
    //分钟选择
    private void minuteChange() {
        if(minute.isEmpty())
            return;
        if ((scrollUnits & SCROLL_TYPE.MINUTE.value) == SCROLL_TYPE.MINUTE.value) {
            minute.clear();
            int selectedHour = selectedCalender.get(Calendar.HOUR_OF_DAY);
            if (selectedHour == startHour) {
                for (int i = startMinute; i <= MAX_MINUTE; i++) {
                    minute.add(formatTimeUnit(i));
                }
            } else if (selectedHour == endHour) {
                for (int i = MIN_MINUTE; i <= endMinute; i++) {
                    minute.add(formatTimeUnit(i));
                }
            } else {
                for (int i = MIN_MINUTE; i <= MAX_MINUTE; i++) {
                    minute.add(formatTimeUnit(i));
                }
            }
            selectedCalender.set(Calendar.MINUTE, Integer.parseInt(minute.get(0)));
            minute_pv.setData(minute);
            minute_pv.setSelected(0);
            executeAnimator(minute_pv);
        }
        if(sec_pv==null){
            executeScroll();
            return;
        }
        minute_pv.postDelayed(new Runnable() {
            @Override
            public void run() {
                secondChange();
            }
        }, 100);
    }
    //秒选择
    private void secondChange() {
        if(second.isEmpty())
            return;
        if ((scrollUnits & SCROLL_TYPE.SECOND.value) == SCROLL_TYPE.SECOND.value) {
            minute.clear();
            int selectedMinute = selectedCalender.get(Calendar.MINUTE);
            if (selectedMinute == startMinute) {
                for (int i = startMinute; i <= MAX_MINUTE; i++) {
                    second.add(formatTimeUnit(i));
                }
            } else if (selectedMinute == endMinute) {
                for (int i = MIN_SECONDS; i <= endSecond; i++) {
                    second.add(formatTimeUnit(i));
                }
            } else {
                for (int i = MIN_SECONDS; i <= MAX_MINUTE; i++) {
                    second.add(formatTimeUnit(i));
                }
            }
            selectedCalender.set(Calendar.SECOND, Integer.parseInt(second.get(0)));
            sec_pv.setData(second);
            sec_pv.setSelected(0);
            executeAnimator(sec_pv);
        }
        executeScroll();
    }

    private void executeScroll() {
        if (year_pv != null) {
            year_pv.setCanScroll(year.size() > 1);
        }
        if (month_pv != null) {
            month_pv.setCanScroll(month.size() > 1);
        }
        if (day_pv != null) {
            day_pv.setCanScroll(day.size() > 1);
        }
        if (hour_pv != null) {
            hour_pv.setCanScroll(hour.size() > 1 && (scrollUnits & SCROLL_TYPE.HOUR.value) == SCROLL_TYPE.HOUR.value);
        }
        if (minute_pv != null) {
            minute_pv.setCanScroll(minute.size() > 1 && (scrollUnits & SCROLL_TYPE.MINUTE.value) == SCROLL_TYPE.MINUTE.value);
        }
        if (sec_pv != null) {
            sec_pv.setCanScroll(minute.size() > 1 && (scrollUnits & SCROLL_TYPE.SECOND.value) == SCROLL_TYPE.SECOND.value);
        }
    }

    /**
     * 设置日期控件是否可以循环滚动
     */
    public void setIsLoop(boolean isLoop) {
        if (canAccess) {
            if(this.year_pv!=null)
                this.year_pv.setIsLoop(isLoop);
            if(this.month_pv!=null)
                this.month_pv.setIsLoop(isLoop);
            if(this.day_pv!=null)
                this.day_pv.setIsLoop(isLoop);
            if(this.hour_pv!=null)
                this.hour_pv.setIsLoop(isLoop);
            if(this.minute_pv!=null)
                this.minute_pv.setIsLoop(isLoop);
            if(this.sec_pv!=null)
                this.sec_pv.setIsLoop(isLoop);
        }
    }

    /**
     * 设置日期控件默认选中的时间
     */
    public void setSelectedTime(String time) {
        if (canAccess) {
            switch (format) {
                case "yyyy-MM-dd HH:mm:ss"://yyyy-MM-dd HH:mm:ss
                {
                    String[] str = time.split(" ");
                    String[] dateStr = str[0].split("-");

                    year_pv.setSelected(dateStr[0]);
                    selectedCalender.set(Calendar.YEAR, Integer.parseInt(dateStr[0]));

                    month.clear();
                    int selectedYear = selectedCalender.get(Calendar.YEAR);
                    if (selectedYear == startYear) {
                        for (int i = startMonth; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear) {
                        for (int i = 1; i <= endMonth; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    }
                    month_pv.setData(month);
                    month_pv.setSelected(dateStr[1]);
                    selectedCalender.set(Calendar.MONTH, Integer.parseInt(dateStr[1]) - 1);
                    executeAnimator(month_pv);

                    day.clear();
                    int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
                    if (selectedYear == startYear && selectedMonth == startMonth) {
                        for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear && selectedMonth == endMonth) {
                        for (int i = 1; i <= endDay; i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    }
                    day_pv.setData(day);
                    day_pv.setSelected(dateStr[2]);
                    selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStr[2]));
                    executeAnimator(day_pv);

                    if (str.length == 2) {
                        String[] timeStr = str[1].split(":");
                        if ((scrollUnits & SCROLL_TYPE.HOUR.value) == SCROLL_TYPE.HOUR.value) {
                            hour.clear();
                            int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
                            if (selectedYear == startYear && selectedMonth == startMonth && selectedDay == startDay) {
                                for (int i = startHour; i <= MAX_HOUR; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            } else if (selectedYear == endYear && selectedMonth == endMonth && selectedDay == endDay) {
                                for (int i = MIN_HOUR; i <= endHour; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_HOUR; i <= MAX_HOUR; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            }
                            hour_pv.setData(hour);
                            hour_pv.setSelected(timeStr[0]);
                            selectedCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0]));
                            executeAnimator(hour_pv);
                        }

                        if ((scrollUnits & SCROLL_TYPE.MINUTE.value) == SCROLL_TYPE.MINUTE.value) {
                            minute.clear();
                            int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
                            int selectedHour = selectedCalender.get(Calendar.HOUR_OF_DAY);
                            if (selectedYear == startYear && selectedMonth == startMonth && selectedDay == startDay && selectedHour == startHour) {
                                for (int i = startMinute; i <= MAX_MINUTE; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            } else if (selectedYear == endYear && selectedMonth == endMonth && selectedDay == endDay && selectedHour == endHour) {
                                for (int i = MIN_MINUTE; i <= endMinute; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_MINUTE; i <= MAX_MINUTE; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            }
                            minute_pv.setData(minute);
                            minute_pv.setSelected(timeStr[1]);
                            selectedCalender.set(Calendar.MINUTE, Integer.parseInt(timeStr[1]));
                            executeAnimator(minute_pv);
                        }

                        if ((scrollUnits & SCROLL_TYPE.SECOND.value) == SCROLL_TYPE.SECOND.value) {
                            second.clear();
                            int selectedMinute = selectedCalender.get(Calendar.MINUTE);
                            if (selectedMinute == startMinute) {
                                for (int i = startSecond; i <= MAX_SECONDS; i++) {
                                    second.add(formatTimeUnit(i));
                                }
                            } else if (selectedMinute == endMinute) {
                                for (int i = MIN_SECONDS; i <= endSecond; i++) {
                                    second.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_SECONDS; i <= MAX_SECONDS; i++) {
                                    second.add(formatTimeUnit(i));
                                }
                            }
                            sec_pv.setData(minute);
                            sec_pv.setSelected(timeStr[2]);
                            selectedCalender.set(Calendar.SECOND, Integer.parseInt(timeStr[2]));
                            executeAnimator(sec_pv);
                        }
                    }

                }
                break;

                case "yyyy-MM-dd HH:mm"://yyyy-MM-dd HH:mm
                {
                    String[] str = time.split(" ");
                    String[] dateStr = str[0].split("-");

                    year_pv.setSelected(dateStr[0]);
                    selectedCalender.set(Calendar.YEAR, Integer.parseInt(dateStr[0]));

                    month.clear();
                    int selectedYear = selectedCalender.get(Calendar.YEAR);
                    if (selectedYear == startYear) {
                        for (int i = startMonth; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear) {
                        for (int i = 1; i <= endMonth; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    }
                    month_pv.setData(month);
                    month_pv.setSelected(dateStr[1]);
                    selectedCalender.set(Calendar.MONTH, Integer.parseInt(dateStr[1]) - 1);
                    executeAnimator(month_pv);

                    day.clear();
                    int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
                    if (selectedYear == startYear && selectedMonth == startMonth) {
                        for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear && selectedMonth == endMonth) {
                        for (int i = 1; i <= endDay; i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    }
                    day_pv.setData(day);
                    day_pv.setSelected(dateStr[2]);
                    selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStr[2]));
                    executeAnimator(day_pv);

                    if (str.length == 2) {
                        String[] timeStr = str[1].split(":");
                        if ((scrollUnits & SCROLL_TYPE.HOUR.value) == SCROLL_TYPE.HOUR.value) {
                            hour.clear();
                            int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
                            if (selectedYear == startYear && selectedMonth == startMonth && selectedDay == startDay) {
                                for (int i = startHour; i <= MAX_HOUR; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            } else if (selectedYear == endYear && selectedMonth == endMonth && selectedDay == endDay) {
                                for (int i = MIN_HOUR; i <= endHour; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_HOUR; i <= MAX_HOUR; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            }
                            hour_pv.setData(hour);
                            hour_pv.setSelected(timeStr[0]);
                            selectedCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0]));
                            executeAnimator(hour_pv);
                        }

                        if ((scrollUnits & SCROLL_TYPE.MINUTE.value) == SCROLL_TYPE.MINUTE.value) {
                            minute.clear();
                            int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
                            int selectedHour = selectedCalender.get(Calendar.HOUR_OF_DAY);
                            if (selectedYear == startYear && selectedMonth == startMonth && selectedDay == startDay && selectedHour == startHour) {
                                for (int i = startMinute; i <= MAX_MINUTE; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            } else if (selectedYear == endYear && selectedMonth == endMonth && selectedDay == endDay && selectedHour == endHour) {
                                for (int i = MIN_MINUTE; i <= endMinute; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_MINUTE; i <= MAX_MINUTE; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            }
                            minute_pv.setData(minute);
                            minute_pv.setSelected(timeStr[1]);
                            selectedCalender.set(Calendar.MINUTE, Integer.parseInt(timeStr[1]));
                            executeAnimator(minute_pv);
                        }
                    }
                }

                break;

                case "yyyy-MM-dd"://yyyy-MM-dd
                {
                    String[] dateStr = time.split("-");

                    year_pv.setSelected(dateStr[0]);
                    selectedCalender.set(Calendar.YEAR, Integer.parseInt(dateStr[0]));

                    month.clear();
                    int selectedYear = selectedCalender.get(Calendar.YEAR);
                    if (selectedYear == startYear) {
                        for (int i = startMonth; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear) {
                        for (int i = 1; i <= endMonth; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    }
                    month_pv.setData(month);
                    month_pv.setSelected(dateStr[1]);
                    selectedCalender.set(Calendar.MONTH, Integer.parseInt(dateStr[1]) - 1);
                    executeAnimator(month_pv);

                    day.clear();
                    int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
                    if (selectedYear == startYear && selectedMonth == startMonth) {
                        for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear && selectedMonth == endMonth) {
                        for (int i = 1; i <= endDay; i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    }
                    day_pv.setData(day);
                    day_pv.setSelected(dateStr[2]);
                    selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStr[2]));
                    executeAnimator(day_pv);
                }
                break;

                case "yyyy-MM"://yyyy-MM
                {
                    String[] dateStr = time.split("-");

                    year_pv.setSelected(dateStr[0]);
                    selectedCalender.set(Calendar.YEAR, Integer.parseInt(dateStr[0]));

                    month.clear();
                    int selectedYear = selectedCalender.get(Calendar.YEAR);
                    if (selectedYear == startYear) {
                        for (int i = startMonth; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear) {
                        for (int i = 1; i <= endMonth; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    }
                    month_pv.setData(month);
                    month_pv.setSelected(dateStr[1]);
                    selectedCalender.set(Calendar.MONTH, Integer.parseInt(dateStr[1]) - 1);
                    executeAnimator(month_pv);
                }
                break;

                case "MM-dd"://MM-dd
                {
                    String[] dateStr = time.split("-");
                    selectedCalender.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
                    month.clear();
                    int selectedYear = selectedCalender.get(Calendar.YEAR);
                    if (selectedYear == startYear) {
                        for (int i = startMonth; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear) {
                        for (int i = 1; i <= endMonth; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= MAX_MONTH; i++) {
                            month.add(formatTimeUnit(i));
                        }
                    }
                    month_pv.setData(month);
                    month_pv.setSelected(dateStr[0]);
                    selectedCalender.set(Calendar.MONTH, Integer.parseInt(dateStr[0]) - 1);
                    executeAnimator(month_pv);

                    day.clear();
                    int selectedMonth = selectedCalender.get(Calendar.MONTH) + 1;
                    if (selectedYear == startYear && selectedMonth == startMonth) {
                        for (int i = startDay; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else if (selectedYear == endYear && selectedMonth == endMonth) {
                        for (int i = 1; i <= endDay; i++) {
                            day.add(formatTimeUnit(i));
                        }
                    } else {
                        for (int i = 1; i <= selectedCalender.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                            day.add(formatTimeUnit(i));
                        }
                    }
                    day_pv.setData(day);
                    day_pv.setSelected(dateStr[1]);
                    selectedCalender.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateStr[1]));
                    executeAnimator(day_pv);
                }
                break;

                case "HH:mm:ss"://HH:mm:ss
                {
                        String[] timeStr = time.split(":");
                        if ((scrollUnits & SCROLL_TYPE.HOUR.value) == SCROLL_TYPE.HOUR.value) {
                            hour.clear();
                            int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
                            if (selectedDay == startDay) {
                                for (int i = startHour; i <= MAX_HOUR; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            } else if (selectedDay == endDay) {
                                for (int i = MIN_HOUR; i <= endHour; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_HOUR; i <= MAX_HOUR; i++) {
                                    hour.add(formatTimeUnit(i));
                                }
                            }
                            hour_pv.setData(hour);
                            hour_pv.setSelected(timeStr[0]);
                            selectedCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0]));
                            executeAnimator(hour_pv);
                        }

                        if ((scrollUnits & SCROLL_TYPE.MINUTE.value) == SCROLL_TYPE.MINUTE.value) {
                            minute.clear();
                            int selectedHour = selectedCalender.get(Calendar.HOUR_OF_DAY);
                            if (selectedHour == startHour) {
                                for (int i = startMinute; i <= MAX_MINUTE; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            } else if (selectedHour == endHour) {
                                for (int i = MIN_MINUTE; i <= endMinute; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            } else {
                                for (int i = MIN_MINUTE; i <= MAX_MINUTE; i++) {
                                    minute.add(formatTimeUnit(i));
                                }
                            }
                            minute_pv.setData(minute);
                            minute_pv.setSelected(timeStr[1]);
                            selectedCalender.set(Calendar.MINUTE, Integer.parseInt(timeStr[1]));
                            executeAnimator(minute_pv);
                        }

                    if ((scrollUnits & SCROLL_TYPE.SECOND.value) == SCROLL_TYPE.SECOND.value) {
                        second.clear();
                        int selectedMinute = selectedCalender.get(Calendar.MINUTE);
                        if (selectedMinute == startMinute) {
                            for (int i = startSecond; i <= MAX_SECONDS; i++) {
                                second.add(formatTimeUnit(i));
                            }
                        } else if (selectedMinute == endMinute) {
                            for (int i = MIN_SECONDS; i <= endSecond; i++) {
                                second.add(formatTimeUnit(i));
                            }
                        } else {
                            for (int i = MIN_SECONDS; i <= MAX_SECONDS; i++) {
                                second.add(formatTimeUnit(i));
                            }
                        }
                        sec_pv.setData(minute);
                        sec_pv.setSelected(timeStr[2]);
                        selectedCalender.set(Calendar.SECOND, Integer.parseInt(timeStr[2]));
                        executeAnimator(sec_pv);
                    }
                }

                break;

                case "HH:mm"://HH:mm
                {
                    String[] timeStr = time.split(":");
                    if ((scrollUnits & SCROLL_TYPE.HOUR.value) == SCROLL_TYPE.HOUR.value) {
                        hour.clear();
                        int selectedDay = selectedCalender.get(Calendar.DAY_OF_MONTH);
                        if (selectedDay == startDay) {
                            for (int i = startHour; i <= MAX_HOUR; i++) {
                                hour.add(formatTimeUnit(i));
                            }
                        } else if (selectedDay == endDay) {
                            for (int i = MIN_HOUR; i <= endHour; i++) {
                                hour.add(formatTimeUnit(i));
                            }
                        } else {
                            for (int i = MIN_HOUR; i <= MAX_HOUR; i++) {
                                hour.add(formatTimeUnit(i));
                            }
                        }
                        hour_pv.setData(hour);
                        hour_pv.setSelected(timeStr[0]);
                        selectedCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0]));
                        executeAnimator(hour_pv);
                    }

                    if ((scrollUnits & SCROLL_TYPE.MINUTE.value) == SCROLL_TYPE.MINUTE.value) {
                        minute.clear();
                        int selectedHour = selectedCalender.get(Calendar.HOUR_OF_DAY);
                        if (selectedHour == startHour) {
                            for (int i = startMinute; i <= MAX_MINUTE; i++) {
                                minute.add(formatTimeUnit(i));
                            }
                        } else if (selectedHour == endHour) {
                            for (int i = MIN_MINUTE; i <= endMinute; i++) {
                                minute.add(formatTimeUnit(i));
                            }
                        } else {
                            for (int i = MIN_MINUTE; i <= MAX_MINUTE; i++) {
                                minute.add(formatTimeUnit(i));
                            }
                        }
                        minute_pv.setData(minute);
                        minute_pv.setSelected(timeStr[1]);
                        selectedCalender.set(Calendar.MINUTE, Integer.parseInt(timeStr[1]));
                        executeAnimator(minute_pv);
                    }
                }
                break;
            }
            executeScroll();
        }
    }

    private void executeAnimator(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.3f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.3f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(200).start();
    }

    /**
     * 将“0-9”转换为“00-09”
     */
    private String formatTimeUnit(int unit) {
        return unit < 10 ? "0" + String.valueOf(unit) : String.valueOf(unit);
    }

    /**
     * 验证字符串是否是一个合法的日期格式
     */
    private boolean isValidDate(String date) {
        boolean convertSuccess = true;
        // 指定日期格式
        SimpleDateFormat format = new SimpleDateFormat(this.format, Locale.CHINA);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2015/02/29会被接受，并转换成2015/03/01
            format.setLenient(false);
            format.parse(date);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

}
