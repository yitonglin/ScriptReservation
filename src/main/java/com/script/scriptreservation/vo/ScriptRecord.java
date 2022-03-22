package com.script.scriptreservation.vo;

import lombok.Data;

/**
 * 浏览记录VO
 */
@Data
public class ScriptRecord {

    //剧本名称
    private String scriptName;

    //浏览时间
    private String recordTime;

    //剧本ID
    private String scriptId;
}
