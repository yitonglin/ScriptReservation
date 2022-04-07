package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.RoomMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Room;
import com.script.scriptreservation.service.IRoomService;
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
}
