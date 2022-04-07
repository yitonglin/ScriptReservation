package com.script.scriptreservation.service;

import com.script.scriptreservation.vo.Result;

public interface IOrderService {
    Result refundMoney(String orderId);
}
