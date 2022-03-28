package com.script.scriptreservation.service;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.vo.Result;

public interface IScriptService {
    Result greatNumPlus(String id);
    Result stepNum(String id);
    Result scriptCollection(ScriptCollectionDto scriptCollectionDto);
    Result scriptInfo(String id);
}
