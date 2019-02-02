package com.zxin.zxinlib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hy on 2017/11/13.
 */

public class DateUtil {

    private static volatile DateUtil util = null;

    private DateUtil(){}

    public static DateUtil getInstance(){
        if (util==null)
            synchronized (DateUtil.class){
                if (util==null)
                    util = new DateUtil();
            }
        return util;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public String timeStampDate(long seconds, String format) {
        if (BaseStringUtils.textIsEmpty(format)) {
            format = "yyyy-MM-dd HH:mm";
        }
        return new SimpleDateFormat(format).format(new Date(seconds));
    }

    /*****
     * 时间戳转换成Calendar
     * @param stamp
     * @return
     */
    public Calendar timeStamp2Calendar(long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(stamp));
        return calendar;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public String timeStampWeek(long seconds, String format) {
        if (BaseStringUtils.textIsEmpty(format)) {
            format = "yyyy-MM-dd";
        }
        return dateToWeek(timeStamp(seconds, format), format);
    }

    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    private String dateToWeek(String datetime, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public String timeStamp(long seconds, String format) {
        return new SimpleDateFormat(format).format(new Date(seconds));
    }

    /**
     * 时间戳转换成周期字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public String weekTimeStamp(Long seconds, String format) {
        String week = null;
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(seconds));
        int mydate = cd.get(Calendar.DAY_OF_WEEK);
        // 获取指定日期转换成星期几
        if (mydate == 1) {
            week = "周日";
        } else if (mydate == 2) {
            week = "周一";
        } else if (mydate == 3) {
            week = "周二";
        } else if (mydate == 4) {
            week = "周三";
        } else if (mydate == 5) {
            week = "周四";
        } else if (mydate == 6) {
            week = "周五";
        } else if (mydate == 7) {
            week = "周六";
        }
        return week;
    }

    /**
     * 获取当前时间，  年月日时分秒
     *
     * @return
     */
    public String createTime() {
        String time = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date()).toString();
        return time;
    }

    /**
     * 比较两个时间或日期的大小
     *
     * @param time1
     * @param time2
     * @return
     * @throws ParseException
     */
    public boolean compare(String time1, String time2) throws ParseException {
        //如果想比较日期则写成"yyyy-MM-dd"就可以了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        //将字符串形式的时间转化为Date类型的时间
        Date a = sdf.parse(time1);
        Date b = sdf.parse(time2);
        //Date类的一个方法，如果a早于b返回true，否则返回false
        if (a.before(b))
            return false;
        else
            return true;

    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public String createDate() {
        String time = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()).toString();
        return time;
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    public String getWeek(String mMeek) {
        switch (mMeek) {
            case "周一":
                return "1";
            case "周二":
                return "2";
            case "周三":
                return "3";
            case "周四":
                return "4";
            case "周五":
                return "5";
            case "周六":
                return "6";
            case "周日":
                return "7";
        }
        return "1";
    }

    public String getWeekDisable(int mMeek) {
        switch (mMeek) {
            case Calendar.MONDAY:
                return "周一";
            case Calendar.TUESDAY:
                return "周二";
            case Calendar.WEDNESDAY:
                return "周三";
            case Calendar.THURSDAY:
                return "周四";
            case Calendar.FRIDAY:
                return "周五";
            case Calendar.SATURDAY:
                return "周六";
            case Calendar.SUNDAY:
                return "周日";
        }
        return "";
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public String dateTimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public Long dateTimeStampLong(String date_str, String format) {
        Long data = 0L;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date_str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);

        return cal.getTime();
    }

    public String getDefaultDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(getThisWeekMonday(date)) + " 00:00";
    }

    public long getThisFirstDay(String dateStr, String format) {
        try {
            Calendar current = Calendar.getInstance();
            Calendar cal = Calendar.getInstance();
            cal.setTime(new SimpleDateFormat(format).parse(dateStr));
            if (current.get(Calendar.MONTH) == cal.get(Calendar.MONTH))
                return cal.getTime().getTime();
            else
                //获取当前月第一天
                return getFirstDayCurrentMonth().getTime().getTime();
        } catch (ParseException e) {
            return new Date().getTime();
        }
    }

    /*****
     * 将时间戳数组转化为格式化数组
     * @param times
     * @param format
     * @return
     */
    public List<String> formatList(List<String> times, String format) {
        List<String> newTime = new ArrayList<>();
        if (times == null || times.isEmpty()) {
            return newTime;
        }
        for (String str : times) {
            String forTime = timeStamp(Long.parseLong(str), format);
            if (newTime.contains(forTime))
                continue;
            newTime.add(forTime);
        }
        return newTime;
    }

    /****
     * 获取前月的第一天
     * @return
     */
    public Calendar getFirstDayLastMonth() {
        Calendar calendar = Calendar.getInstance();//获取当前日期
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return calendar;
    }

    /****
     * 获取前月的最后一天
     * @return
     */
    public Calendar getLastDayLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
        return calendar;
    }

    /****
     * 获取当前月第一天
     * @return
     */
    public Calendar getFirstDayCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return calendar;
    }

    /***
     * 获取当前月最后一天
     * @return
     */
    public Calendar getLastDayCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar;
    }

    /**
     * 获取当前时间的后一天时间
     *
     * @param cl
     */
    public Calendar getAfterDay(Calendar cl) {
        // TODO Auto-generated method stub
        // 使用roll方法进行回滚到后一天的时间
        // cl.roll(Calendar.DATE, 1);
        // 使用set方法直接设置时间值
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day + 1);
        return cl;
    }

    /**
     * 获取时间的前一天时间
     *
     * @param cl
     */
    public Calendar getBeforeDay(Calendar cl) {
        // TODO Auto-generated method stub
        // 使用roll方法进行向前回滚
        // cl.roll(Calendar.DATE, -1);
        // 使用set方法直接进行设置
        int day = cl.get(Calendar.DATE);
        cl.set(Calendar.DATE, day - 1);
        return cl;
    }

    /**
     * 设置时间
     *
     * @param year
     * @param month
     * @param date
     * @return
     */
    public Calendar setCalendar(int year, int month, int date) {
        Calendar cl = Calendar.getInstance();
        cl.set(year, month - 1, date);
        return cl;
    }

    /*****
     * 格式化日期
     * @param year
     * @param month
     * @param day
     * @return
     */
    public String forMatDateYYMMDD(int year, int month, int day) {
        month += 1;
        return year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
    }

}
