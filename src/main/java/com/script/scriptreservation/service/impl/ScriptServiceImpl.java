package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.ScriptMapper;
import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.service.IScriptService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptServiceImpl implements IScriptService {

    @Autowired
    private ScriptMapper scriptMapper;

    @Override
    public Result greatNumPlus(String id) {
        Result result = new Result();
        scriptMapper.greatNumPlus(id);
        result.setStatus(true);
        result.setMsg("点赞成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result stepNum(String id) {
        Result result = new Result();
        scriptMapper.stepNum(id);
        result.setStatus(true);
        result.setMsg("点踩成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result scriptCollection(ScriptCollectionDto scriptCollectionDto) {
        Result result = new Result();
        scriptCollectionDto.setCollectionId(MoreUtils.createId());
        scriptCollectionDto.setCollectionTime(MoreUtils.getCurrentTime());
        Integer resultNum = scriptMapper.scriptCollection(scriptCollectionDto);
        if (resultNum > 0){
            result.setStatus(true);
            result.setMsg("收藏成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        } else {
            result.setStatus(false);
            result.setMsg("收藏失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
        }

        return result;
    }


}
