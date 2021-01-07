package com.joezhou.exception;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author JoeZhou
 */
public class CalendarTest {

    @Test
    public void calendarApi() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 将年份减去1
        calendar.add(Calendar.YEAR, -1);
        System.out.println(dateFormat.format(calendar.getTime()));

        // 将月份设置为1月
        calendar.set(Calendar.MONTH, 0);
        System.out.println(dateFormat.format(calendar.getTime()));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d-%d-%d 星期%d %d:%d:%s",
                year, month + 1, date, week + 1, hour, minute, second);
    }

}
