package com.script.scriptreservation.vo;

import lombok.Data;

@Data
public class OrderScriptVo {
    //剧本名称
    private String scriptName;

    //订单创建时间
    private Long orderCreateTime;

    //订单状态
    private Integer orderStatus;

    //预约开始时间
    private Long forwardDate;

    //预约结束时间
    private Long forwardEndDate;

    //退款时间
    private Long refundTime;

    //订单人数
    private Integer orderNumber;

    //订单预约标志
    private Integer orderFlag;

    //剧本ID
    private String scriptId;

    //订单金额
    private Integer orderMoney;

}
