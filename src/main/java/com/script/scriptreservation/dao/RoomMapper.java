package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Room;
import com.script.scriptreservation.vo.LimitPageVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RoomMapper extends Mapper<Room> {
    List<Room> getFreeRoom();
    List<Room> getScriptFreeRoom(LimitPageVo limitPageVo);
    Integer getScriptFreeRoomCount(LimitPageVo limitPageVo);
}