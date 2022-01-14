package com.hyt.date;

import cn.hutool.core.date.DateBetween;
import cn.hutool.core.date.DateUnit;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-09-06 9:46
 * @since 1.8
 **/
public class DateDemo {

    private static String MONOLOG_FORMAT = "不知不觉，郭萧已经住进侯英涛心里 %s 天了~";

    @Test
    public void calcDays() throws Exception {
        String beginStr = "2018-05-25";
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(beginStr);
        DateBetween dateBetween = new DateBetween(beginDate, new Date());
        long days = dateBetween.between(DateUnit.DAY);
        System.out.println(String.format(Locale.CHINESE, MONOLOG_FORMAT, days));
    }
}
