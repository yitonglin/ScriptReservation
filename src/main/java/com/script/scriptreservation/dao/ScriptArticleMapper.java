package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Collection;
import com.script.scriptreservation.po.ScriptArticle;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface ScriptArticleMapper extends Mapper<Collection> {
    Integer dataCount(ScriptArticle scriptArticle);
    void updateScriptArticle(ScriptArticle scriptArticle);
    void insertScriptArticle(ScriptArticle scriptArticle);
}
