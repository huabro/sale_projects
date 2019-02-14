package com.tianyu.util;


import com.alibaba.druid.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by msh on 2017/10/18.
 */
public final class DateHelp {
    private static String dateFormat="yyyy-MM-dd";
    /*
     *字符转Calendar格式
     */
    public static Calendar convertStringToCalendar(String dateString) {
        return convertStringToCalendar(dateString, dateFormat);
    }

    public static Calendar convertStringToCalendar(String dateString, String dateFormat) {
        if (StringUtils.isEmpty(dateString)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            return null;
        }
        return convertDateToCalendar(date);
    }

    public static Calendar convertDateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static Calendar getNowCalendar() {
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateString = "";
        try {
            dateString = sdf.format(currentTime);
        } catch (Exception e) {
            return null;
        }
        return convertStringToCalendar(dateString);
    }

    public static Calendar getNowCalendar(Integer years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, years);
        return calendar;
    }

    public static String convertCalendarToString(Calendar date) {
        if (date==null) return "";//容错
        Date targetDate = date.getTime();
        return convertCalendarToString(targetDate);
    }

    public static String convertCalendarToString(Date date) {
        return convertCalendarToString(date, dateFormat);
    }

    public static String convertCalendarToString(Calendar calendar,String dateFormat) {
        if (calendar==null) return "";//容错
        Date  date=calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateString = "";
        try {
                dateString = sdf.format(date);
        } catch (Exception e) {
            return null;
        }
        return dateString;
    }
    public static String convertCalendarToString(Date date,String dateFormat) {
        if (date==null) return "";//容错
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateString = "";
        try {
                dateString = sdf.format(date);
        } catch (Exception e) {
            return null;
        }
        return dateString;
    }


    public static Calendar getCalendarEndTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }

    public  static long getDayDiff(Calendar beginCalendar,Calendar endCalendar){
        try {
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            String beginStr = convertCalendarToString(beginCalendar, dateFormat);
            String endStr = convertCalendarToString(endCalendar, dateFormat);
            Date beginDate = format.parse(beginStr);
            Date endDate = format.parse(endStr);
            return (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        }
        catch (Exception ex){
            return 0;
        }
    }

    public static Date addDays(int num,Date targetDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.add(Calendar.DATE,num);
        return  cal.getTime();
    }
}
