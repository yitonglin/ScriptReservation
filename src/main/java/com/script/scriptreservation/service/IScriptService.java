package com.script.scriptreservation.service;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.RoomScriptVO;

public interface IScriptService {
    Result greatNumPlus(String id);
    Result stepNum(String id);
    Result scriptCollection(ScriptCollectionDto scriptCollectionDto);
    Result scriptInfo(String id);
    Result addRandomGroup(RoomScriptVO roomScriptVO);
    Result allGroup(RoomScriptVO roomScriptVO);
    Result insetRandomGroup(RoomScriptVO roomScriptVO);
    Result serachScript(LimitPageVo limitPageVo);
    Result getScriptIdFreeRoom(String scriptId);
    Result getIndexScript(LimitPageVo limitPageVo);
}
