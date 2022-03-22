package com.script.scriptreservation.vo;

import lombok.Data;

@Data
public class CommentsVo {
    //剧本名称
    private String scriptName;

    //评论时间
    private String commentsTime;

    //剧本ID
    private String scriptId;

    //评论内容
    private String comments;
}
