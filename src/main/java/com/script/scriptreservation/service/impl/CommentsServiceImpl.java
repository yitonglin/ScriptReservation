package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.CommentsMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Comments;
import com.script.scriptreservation.service.IcommentsService;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements IcommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

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
}
