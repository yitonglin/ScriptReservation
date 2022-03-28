package com.script.scriptreservation.dao;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.po.Script;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface ScriptMapper extends Mapper<Script> {
    void greatNumPlus(String id);
    void stepNum(String id);
    Integer scriptCollection(ScriptCollectionDto scriptCollectionDto);
}