package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Order;
import com.script.scriptreservation.vo.OrderScriptVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderMapper extends Mapper<Order> {
    List<OrderScriptVo> historyOrder(@Param("filed") String filed, @Param("i") int i,@Param("len") int len,@Param("timeCurrent") Long timeCurrent);
    Integer getOrderCount(@Param("filed") String filed,@Param("timeCurrent") Long timeCurrent);
    Integer getNewOrderCount(@Param("filed") String filed,@Param("timeCurrent") Long timeCurrent);
    List<OrderScriptVo> newHistoryOrder(@Param("filed") String filed, @Param("i") int i,@Param("len") int len,@Param("timeCurrent") Long timeCurrent);

    Integer createOrder(Order order);
}