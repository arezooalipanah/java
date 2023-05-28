package com.moneytransfer.utils;

import java.util.Date;

public interface DateUtil {
    Date getNow();

    Date addDay(Date date, int add);
}
