package com.script.scriptreservation.service;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.po.ScriptArticle;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.RoomScriptVO;
import com.script.scriptreservation.vo.UserScriptVo;

public interface IScriptService {
    Result greatNumPlus(ScriptArticle scriptArticle);
    Result stepNum(ScriptArticle scriptArticle);
    Result scriptCollection(ScriptCollectionDto scriptCollectionDto);
    Result scriptInfo(ScriptCollectionDto scriptCollectionDto);
    Result addRandomGroup(RoomScriptVO roomScriptVO);
    Result allGroup(RoomScriptVO roomScriptVO);
    Result insetRandomGroup(RoomScriptVO roomScriptVO);
    Result serachScript(LimitPageVo limitPageVo);
    Result getScriptIdFreeRoom(String scriptId);
    Result getIndexScript(LimitPageVo limitPageVo);
    Result getUserScript(UserScriptVo userScriptVo);
}
