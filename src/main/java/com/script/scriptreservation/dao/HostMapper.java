package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Host;
import com.script.scriptreservation.vo.Result;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface HostMapper extends Mapper<Host> {
    List<Host> selectFreeHost(Long time);
}