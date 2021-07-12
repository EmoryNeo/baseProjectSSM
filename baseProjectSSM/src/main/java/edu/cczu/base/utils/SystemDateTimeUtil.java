package edu.cczu.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author iceorangeduxiaocheng@aliyun.com
 * @date 2021/7/12 11:24
 */
public class SystemDateTimeUtil {

    public static String getSysTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String dateStr = sdf.format(date);

        return dateStr;
    }
}
