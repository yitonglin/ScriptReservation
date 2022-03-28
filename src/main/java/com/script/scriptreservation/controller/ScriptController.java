package com.script.scriptreservation.controller;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.service.IScriptService;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("script")
public class ScriptController {

    @Autowired
    private IScriptService scriptService;

    /**
     * 剧本点赞方法
     * @param id
     * @return
     */
    @PostMapping("GreatNumPlus")
    private Result greatNumPlus(String id){
        return scriptService.greatNumPlus(id);
    }

    /**
     * 剧本点踩方法
     * @param id
     * @return
     */
    @PostMapping("stepNum")
    private Result stepNum(String id){
        return scriptService.stepNum(id);
    }

    /**
     * 剧本收藏
     * @return
     */
    @PostMapping("scriptCollection")
    private Result scriptCollection(ScriptCollectionDto scriptCollectionDto){
        return scriptService.scriptCollection(scriptCollectionDto);
    }

}
