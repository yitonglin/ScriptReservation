package com.script.scriptreservation.vo;

import lombok.Data;

@Data
public class MoneyVo {

    //用户ID
    private String userId;

    //操作金额
    private Integer money;

    //操作状态 0付款 1退款
    private Integer status;
}
