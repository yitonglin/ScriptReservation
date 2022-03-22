package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Collection;
import com.script.scriptreservation.vo.CollectionVo;
import com.script.scriptreservation.vo.Result;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CollectionMapper extends Mapper<Collection> {
    List<CollectionVo> personalCollection(String id);
}