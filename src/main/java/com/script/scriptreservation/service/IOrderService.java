package com.script.scriptreservation.service;

import com.script.scriptreservation.po.Order;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;

public interface IOrderService {
    Result refundMoney(String orderId);
    Result historyOrder(LimitPageVo limitPageVo);
    Result newHistoryOrder(LimitPageVo limitPageVo);
    Result updateOrederStats(Order order);
}
