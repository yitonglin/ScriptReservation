package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.RoomMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Room;
import com.script.scriptreservation.service.IRoomService;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Result getFreeRoom() {
        Result result = new Result();
        List<Room> rooms = roomMapper.getFreeRoom();
        if (rooms.size() > 0){
            result.setStatus(true);
            result.setMsg("可加入房间查询成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
            result.setData(rooms);
        } else {
            result.setStatus(false);
            result.setMsg("可加入房间为空或查询失败,详情见回传信息");
            result.setCode(ApplicationEnum.FAIT.getCode());
            result.setData(rooms);
        }
        return result;
    }

    @Override
    public Result getScriptFreeRoom(LimitPageVo limitPageVo) {
        Result result = new Result();
        //查询总数
        Integer count = roomMapper.getScriptFreeRoomCount(limitPageVo);
        //计算总页数
        Integer pageCount = 0;
        if (count % 5 == 0){
            pageCount = count / 5;
        } else {
            pageCount = count / 5 + 1;
        }
        limitPageVo.setCount(pageCount);
        limitPageVo.setPageCount(limitPageVo.getPageNum() * 5);
        List<Room> rooms = roomMapper.getScriptFreeRoom(limitPageVo);
        limitPageVo.setListData(rooms);
        result.setStatus(true);
        result.setMsg("可加入房间查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(limitPageVo);
        return result;
    }

    @Override
    public Result getCategoryScriptFreeRoom(String category) {
        Result result = new Result();
        List<Room> rooms = roomMapper.getCategoryScriptFreeRoom(category);
        result.setStatus(true);
        result.setMsg("分类可加入房间查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(rooms);
        return result;
    }

    @Override
    public Result getRoomById(String id) {
        Result result = new Result();
        Room room = roomMapper.selectByPrimaryKey(id);
        result.setStatus(true);
        result.setMsg("房间查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(room);
        return result;
    }
}
