package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.CommentsMapper;
import com.script.scriptreservation.dao.ScriptMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Comments;
import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IcommentsService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements IcommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private ScriptMapper scriptMapper;

    @Override
    public Result scriptComments(LimitPageVo limitPageVo) {
        Result result = new Result();
        //计算查询开始的位置
        limitPageVo.setPageCount(limitPageVo.getPageNum() * limitPageVo.getLen());
        List<Comments> comments = commentsMapper.scriptComments(limitPageVo);
        //总条数计算
        Integer len = commentsMapper.commentsCount(limitPageVo.getFiled());
        limitPageVo.setCount(comments.size());
        limitPageVo.setListData(comments);
        result.setStatus(true);
        result.setMsg("剧本查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(limitPageVo);
        return result;
    }

    @Override
    public Result getUserName(String userId) {
        Result result = new Result();
        String userName = commentsMapper.getUserName(userId);
        User user = new User();
        user.setId(userId);
        user.setUserName(userName);
        result.setMsg("用户名查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(user);
        return result;
    }

    @Override
    public Result createComments(Comments comments) {
        Result result = new Result();
        comments.setId(MoreUtils.createId());
        commentsMapper.insert(comments);
        //增加剧本评论数
        scriptMapper.setScriptReplyNumberPlus(comments.getScriptId());
        result.setMsg("评论成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }
}
