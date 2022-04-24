package com.script.scriptreservation.service;

import com.script.scriptreservation.po.ScriptArticle;
import com.script.scriptreservation.vo.Result;

public interface IScriptArticleService {
    Result changeScriptStatus(ScriptArticle scriptArticle);
}
