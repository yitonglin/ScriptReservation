package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.OrderMapper;
import com.script.scriptreservation.dao.RoomMapper;
import com.script.scriptreservation.dao.UserMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Order;
import com.script.scriptreservation.po.Room;
import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IOrderService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.OrderScriptVo;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 实现逻辑
     * 1. 判断是否可退款（以六个小时为维度做逻辑）
     *      查询出房间的开始时间如果在六个小时内则不允许退款  时间大于当前时间+21600可退款
     *          a. 未拼团成功
     *          b. 拼团成功退款需要更新房间的拼团成功的状态
     *          c. 组团退款也需更新拼团成功状态
     * 2. 查询订单信息然后更新订单的状态为已退款
     * 3. 更新用户信息的账户加钱
     * @param orderId
     * @return
     */
    @Override
    public Result refundMoney(String orderId) {
        Result result = new Result();
        //查询出订单信息
        Order order = orderMapper.selectByPrimaryKey(orderId);
        //查询用户信息
        User user = userMapper.selectByPrimaryKey(order.getUserId());
        //查询出房间信息
        Room room = roomMapper.selectByPrimaryKey(order.getRoomId());
        //校验是否可退款逻辑  六小时 true可退 false不可退
        boolean refundSatus = room.getStartTime() - MoreUtils.getCurrentTime() >= 21600;
        if (refundSatus){
            //判断房间的状态 根据房间的状态进行修改 未拼团成功的修改拼团的人数及修改订单状态即可
            if (room.getStatus() == 1){
                room.setNeedNumber(room.getNeedNumber() + order.getForwardNum());
                //更新房间所需人数
                roomMapper.updateByPrimaryKey(room);
                //更新订单状态为已退款
                order.setOrderStatus(1);
                order.setRefundTime(MoreUtils.getCurrentTime());
                orderMapper.updateByPrimaryKey(order);
                //更新用户账户
                user.setMoney(user.getMoney() + order.getOrderMoney());
                userMapper.updateByPrimaryKey(user);
                result.setStatus(true);
                result.setMsg("退款成功，已付款项已退还到您的账户");
                result.setCode(ApplicationEnum.SUCCESS.getCode());
            } else if (room.getStatus() == 0){
                //此时已经拼团成功
                //更新房间信息为未拼团成功 并且修改所需人数
                room.setStatus(1);
                room.setNeedNumber(order.getForwardNum());
                roomMapper.updateByPrimaryKey(room);
                if (order.getOrderFlag() == 1){
                    //如果此人为包场则需要删除房间信息
                    roomMapper.deleteByPrimaryKey(room);
                }
                //更新订单状态为已退款
                order.setOrderStatus(1);
                order.setRefundTime(MoreUtils.getCurrentTime());
                orderMapper.updateByPrimaryKey(order);
                //更新用户账户
                user.setMoney(user.getMoney() + order.getOrderMoney());
                userMapper.updateByPrimaryKey(user);
                result.setStatus(true);
                result.setMsg("退款成功，已付款项已退还到您的账户,您所组房间已为可拼团状态");
                result.setCode(ApplicationEnum.SUCCESS.getCode());
            }
        } else {
            result.setStatus(true);
            result.setMsg("当前距离开场已不足六个小时，已不能退款");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        }
        return result;
    }

    @Override
    public Result historyOrder(LimitPageVo limitPageVo) {
        Result result = new Result();
        //参数 用户id  分页参数  当前时间戳
        Long timeCurrent = MoreUtils.getCurrentTime();
        //查询数据的总条数
        Integer count = orderMapper.getOrderCount(limitPageVo.getFiled(),timeCurrent);
        List<OrderScriptVo> orderScriptVos = orderMapper.historyOrder(limitPageVo.getFiled(),limitPageVo.getPageNum() * limitPageVo.getLen(),limitPageVo.getLen(),timeCurrent);
        limitPageVo.setCount(orderScriptVos.size());
        limitPageVo.setListData(orderScriptVos);
        limitPageVo.setCount(count);
        result.setStatus(true);
        result.setMsg("历史订单查询完成");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(limitPageVo);
        return result;
    }

    @Override
    public Result newHistoryOrder(LimitPageVo limitPageVo) {
        Result result = new Result();
        //参数 用户id  分页参数  当前时间戳
        Long timeCurrent = MoreUtils.getCurrentTime();
        //查询数据的总条数
        Integer count = orderMapper.getNewOrderCount(limitPageVo.getFiled(),timeCurrent);
        List<OrderScriptVo> orderScriptVos = orderMapper.newHistoryOrder(limitPageVo.getFiled(),limitPageVo.getPageNum() * limitPageVo.getLen(),limitPageVo.getLen(),timeCurrent);
        limitPageVo.setCount(orderScriptVos.size());
        limitPageVo.setListData(orderScriptVos);
        limitPageVo.setCount(count);
        result.setStatus(true);
        result.setMsg("最新订单查询完成");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(limitPageVo);
        return result;
    }

    @Override
    public Result updateOrederStats(Order order) {
        Result result = new Result();
        orderMapper.updateOrederStats(order);
        result.setStatus(true);
        result.setMsg("订单信息更新完成");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }


}
