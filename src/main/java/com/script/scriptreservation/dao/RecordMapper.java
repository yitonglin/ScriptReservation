package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Record;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.ScriptRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RecordMapper extends Mapper<Record> {

    List<ScriptRecord> lookRecord(LimitPageVo limitPageVo);
    List<ScriptRecord> lookRecord1(LimitPageVo limitPageVo);
}