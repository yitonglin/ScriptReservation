package com.script.scriptreservation.dto;

import lombok.Data;

/**
 * 剧本收藏表
 */
@Data
public class ScriptCollectionDto {
    //剧本ID
    private String scriptId;
    //用户ID
    private String userId;
    //收藏ID
    private String collectionId;
    //收藏时间
    private Long collectionTime;
}
