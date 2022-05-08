package com.script.scriptreservation.controller;

import com.script.scriptreservation.po.Comments;
import com.script.scriptreservation.service.IcommentsService;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private IcommentsService commentsService;

    /**
     * 剧本评论查询  参数传入剧本ID和分页参数
     * @param limitPageVo
     * @return
     */
    @PostMapping("scriptComments")
    public Result scriptComments(LimitPageVo limitPageVo){
        return commentsService.scriptComments(limitPageVo);
    }

    /**
     * 创建评论
     * @param comments
     * @return
     */
    @PostMapping("createComments")
    public Result createComments(Comments comments){
        return commentsService.createComments(comments);
    }

    @PostMapping("getUserName")
    public Result getUserName(String userId){
        return commentsService.getUserName(userId);
    }


}
