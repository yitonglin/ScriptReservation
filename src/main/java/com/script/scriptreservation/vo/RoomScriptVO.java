package com.script.scriptreservation.vo;

import lombok.Data;

@Data
public class RoomScriptVO {

    //剧本ID
    private String scriptId;

    //用户ID
    private String userId;

    //剧本一共所需人数
    private Integer scriptNum;

    //此次的拼团人数
    private Integer personNum;

    //主持人ID
    private String hostId;

    //剧本单价
    private Integer scriptMoney;

    //房间ID  非房间号  用于加入拼团的时候使用
    private String roomId;

    //剧本开始时间
    private Long startTime;




}
