package com.script.scriptreservation.utils;
import java.util.UUID;

public class MoreUtils {

    /**
     * ID生成方法
     * @return
     */
    public static String createId(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
