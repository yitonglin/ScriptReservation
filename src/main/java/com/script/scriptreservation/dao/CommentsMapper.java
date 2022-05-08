package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.Comments;
import com.script.scriptreservation.vo.CommentsVo;
import com.script.scriptreservation.vo.LimitPageVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CommentsMapper extends Mapper<Comments> {
    List<CommentsVo> personalComments(String id);
    List<Comments> scriptComments(LimitPageVo limitPageVo);
    Integer commentsCount(String scriptId);
    String getUserName(String userId);
}