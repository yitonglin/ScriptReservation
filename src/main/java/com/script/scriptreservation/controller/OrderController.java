package com.script.scriptreservation.controller;

import com.script.scriptreservation.service.IOrderService;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("refundMoney")
    public Result refundMoney(String orderId){
        return orderService.refundMoney(orderId);
    }
}
