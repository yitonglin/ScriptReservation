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

}
