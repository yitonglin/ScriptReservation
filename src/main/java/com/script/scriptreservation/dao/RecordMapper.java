package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Record;
import com.script.scriptreservation.vo.ScriptRecord;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RecordMapper extends Mapper<Record> {

    List<ScriptRecord> lookRecord(String id);
}