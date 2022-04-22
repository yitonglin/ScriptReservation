package com.script.scriptreservation.utils;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MoreUtils {

    /**
     * ID生成方法
     * @return
     */
    public static String createId(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static Long getCurrentTime(){
        return new Date().getTime();
    }

    /**
     * @Author:whf
     * @param:
     * @Description: 获得“今天”零点秒级时间戳  一天的最后一秒应加上86399
     * @Date:2018/4/12 0012
     */
    public static Long getTodayZeroPointTimestamps(){
        Long currentTimestamps=System.currentTimeMillis();
        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
        return (currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps)/1000;
    }

    /**
     * @Author:whf
     * @param:
     * @Description: 获得“今天”最后一秒秒级时间戳  一天的最后一秒应加上86399
     * @Date:2018/4/12 0012
     */
    public static Long getTodayEndZeroPointTimestamps(){
        Long currentTimestamps=System.currentTimeMillis();
        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
        return (currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps)/1000+86399;
    }

}
