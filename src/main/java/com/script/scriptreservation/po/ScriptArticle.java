package com.script.scriptreservation.po;

import lombok.Data;

/**
 * 剧本点赞点踩表
 */
@Data
public class ScriptArticle {

    private String ID;

    private String userId;

    private String scriptId;

    //点赞点踩状态   0为点赞  1为点踩
    private Integer status;
}
