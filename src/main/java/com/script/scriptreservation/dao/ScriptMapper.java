package com.script.scriptreservation.dao;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.po.Script;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ScriptMapper extends Mapper<Script> {
    void greatNumPlus(String id);
    void stepNum(String id);
    Integer scriptCollection(ScriptCollectionDto scriptCollectionDto);
    List<Script> serachScript(LimitPageVo limitPageVo);

    Integer serachScriptCount(LimitPageVo limitPageVo);

    List<Script> getIndexScript(LimitPageVo limitPageVo);

    Integer getIndexScriptCount(LimitPageVo limitPageVo);

    void updateRecordPlus(String scriptId);
}