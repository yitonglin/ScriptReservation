package com.script.scriptreservation.controller;

import com.script.scriptreservation.po.ScriptArticle;
import com.script.scriptreservation.service.IScriptArticleService;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 点赞点踩控制器
 */
@RestController
@RequestMapping("ScriptArticle")
public class ScriptArticleController {

    @Autowired
    private IScriptArticleService scriptArticleService;

    /**
     * 点赞或点踩  取决去status参数  0为点赞 1为点踩 数据只传用户id 剧本id 状态    即可
     * 此处的逻辑已经包含重复点击的问题了   用户哪怕重复点击也不会有多个点赞记录下来  只会有一条记录
     * @param scriptArticle
     * @return
     */
    @PostMapping("changeScriptStatus")
    public Result changeScriptStatus(ScriptArticle scriptArticle){
        return scriptArticleService.changeScriptStatus(scriptArticle);
    }


}
