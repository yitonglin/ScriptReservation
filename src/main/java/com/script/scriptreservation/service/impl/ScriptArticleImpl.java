package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.ScriptArticleMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.ScriptArticle;
import com.script.scriptreservation.service.IScriptArticleService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptArticleImpl implements IScriptArticleService {

    @Autowired
    private ScriptArticleMapper scriptArticleMapper;

    @Override
    public Result changeScriptStatus(ScriptArticle scriptArticle) {
        Result result = new Result();
        //点赞和点踩一个用户只能共存一个，所以此处应该查询是否存在以用户和剧本为维度的数据存在
        Integer dataCount = scriptArticleMapper.dataCount(scriptArticle);
        if (dataCount != 0){
            //此时存在点赞或者点踩数据，此时直接更新状态即可
            scriptArticleMapper.updateScriptArticle(scriptArticle);
            result.setStatus(true);
            result.setMsg("状态更新完成");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        } else if (dataCount == 0){
            //此时无点赞点踩数据，直接新增数据即可
            scriptArticle.setID(MoreUtils.createId());
            scriptArticleMapper.insertScriptArticle(scriptArticle);
            result.setStatus(true);
            result.setMsg("点赞或点踩完成");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        }
        return result;
    }
}
