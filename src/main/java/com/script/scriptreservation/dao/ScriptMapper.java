package com.script.scriptreservation.dao;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.po.Script;
import com.script.scriptreservation.po.ScriptArticle;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.UserScriptVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ScriptMapper extends Mapper<Script> {
    void greatNumPlus(ScriptArticle scriptArticle);
    void deleteGoodScript(ScriptArticle scriptArticle);
    Integer getGoodStatus(ScriptArticle scriptArticle);
    Integer getPoorStatus(ScriptArticle scriptArticle);
    void stepNum(ScriptArticle scriptArticle);
    Integer scriptCollection(ScriptCollectionDto scriptCollectionDto);
    Integer getCollectionCount(ScriptCollectionDto scriptCollectionDto);
    void deleteCollectionByuser(ScriptCollectionDto scriptCollectionDto);
    List<Script> serachScript(LimitPageVo limitPageVo);

    Integer serachScriptCount(LimitPageVo limitPageVo);

    List<Script> getIndexScript(LimitPageVo limitPageVo);
    Integer getGoodStatu(UserScriptVo userScriptVo);

    Integer getIndexScriptCount(LimitPageVo limitPageVo);

    void updateRecordPlus(String scriptId);
    Integer getScriptCount(String scriptId);
    Integer getScriptGoodCount(String scriptId);
    Integer getScriptPoorCount(String scriptId);
    void setScriptReplyNumberPlus(String scriptId);
}