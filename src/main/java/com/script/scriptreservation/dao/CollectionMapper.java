package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Collection;
import com.script.scriptreservation.vo.CollectionVo;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.UserScriptVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CollectionMapper extends Mapper<Collection> {
    List<CollectionVo> personalCollection(LimitPageVo limitPageVo);
    List<CollectionVo> personalCollection1(LimitPageVo limitPageVo);
    Integer getCollectionStatu(UserScriptVo userScriptVo);
}