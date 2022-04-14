package com.script.scriptreservation.controller;

import com.script.scriptreservation.service.IRoomService;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    /**
     * 获取可加入的房间
     * 思路：查询未满的房间
     * @return
     */
    @PostMapping("getFreeRoom")
    public Result getFreeRoom(){
        return roomService.getFreeRoom();
    }

    /**
     * 获取剧本对应的未组队完成的房间 每次只展示五个 传递时传递剧本id和页数
     * @return
     */
    @PostMapping("getScriptFreeRoom")
    public Result getScriptFreeRoom(LimitPageVo limitPageVo){
        return roomService.getScriptFreeRoom(limitPageVo);
    }
}
