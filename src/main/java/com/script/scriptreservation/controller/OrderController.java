package com.script.scriptreservation.controller;

import com.script.scriptreservation.service.IOrderService;
import com.script.scriptreservation.vo.LimitPageVo;
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

    /**
     * 新增历史订单接口  此时不可退款 此时的时间大于剧本的开始时间则为历史订单 已测试
     */
    @PostMapping("historyOrder")
    public Result historyOrder(LimitPageVo limitPageVo){
        return orderService.historyOrder(limitPageVo);
    }

    /**
     * 新增最新订单接口  此时可退款 此时的时间小于剧本的开始时间   是否可退款前端根据此时的时间为剧本的开始时间的前六个小时显示可退款按钮 小于六个小时不可退款 已测试
     */
    @PostMapping("newHistoryOrder")
    public Result newHistoryOrder(LimitPageVo limitPageVo){
        return orderService.newHistoryOrder(limitPageVo);
    }
}
