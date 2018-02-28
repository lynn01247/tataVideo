package com.tatait.tata_video.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lynn on 17/12/29.
 */

public class DateUtils {

    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        String str = format.format(curDate);
        return str;
    }

}
