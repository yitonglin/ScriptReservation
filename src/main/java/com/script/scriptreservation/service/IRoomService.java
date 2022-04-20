package com.script.scriptreservation.service;

import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;

public interface IRoomService {
    Result getFreeRoom();
    Result getScriptFreeRoom(LimitPageVo limitPageVo);
    Result getCategoryScriptFreeRoom(String category);
}
