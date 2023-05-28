package com.moneytransfer.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtilImpl implements DateUtil {
    @Override
    public Date getNow() {
        return Calendar.getInstance().getTime();
    }

    @Override
    public Date addDay(Date date, int add) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, add);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getTime());
    }
}