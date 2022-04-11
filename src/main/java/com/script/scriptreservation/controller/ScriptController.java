package com.script.scriptreservation.controller;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.service.IScriptService;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.RoomScriptVO;
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
    public Result greatNumPlus(String id){
        return scriptService.greatNumPlus(id);
    }

    /**
     * 剧本点踩方法
     * @param id
     * @return
     */
    @PostMapping("stepNum")
    public Result stepNum(String id){
        return scriptService.stepNum(id);
    }

    /**
     * 剧本收藏
     * @return
     */
    @PostMapping("scriptCollection")
    public Result scriptCollection(ScriptCollectionDto scriptCollectionDto){
        return scriptService.scriptCollection(scriptCollectionDto);
    }

    /**
     * 剧本信息展示
     * @param id
     * @return
     */
    @PostMapping("scriptInfo")
    public Result scriptInfo(String id){
        return scriptService.scriptInfo(id);
    }

    /**
     * -----------------------------------------------剧本预约 > 新建拼团   以下均为测试  -----------------------------------------------------------------
     * 新建拼团
     * 1. 新建房间
     * 房间ID 剧本id+第一个用户id
     * 一共人数：前端传剧本信息中携带
     * 剩余人数：
     * 剧本建立时间：
     * 房间对应剧本：
     *
     * 字段信息：剧本全信息  拼团人数  价格后端计算
     * 2. 新建用户订单
     * 主要注意订单创建时间
     */
    @PostMapping("addRandomGroup")
    public Result addRandomGroup(RoomScriptVO roomScriptVO){
        return scriptService.addRandomGroup(roomScriptVO);
    }

    /**
     * 包场预定
     * @param roomScriptVO
     * @return
     */
    @PostMapping("allGroup")
    public Result allGroup(RoomScriptVO roomScriptVO){
        return scriptService.allGroup(roomScriptVO);
    }

    /**
     * 加入别人的拼团
     * @param roomScriptVO
     * @return
     */
    @PostMapping("insetRandomGroup")
    public Result insetRandomGroup(RoomScriptVO roomScriptVO){
        return scriptService.insetRandomGroup(roomScriptVO);
    }


    /**
     * 测试完毕
     * 1. 根据剧本名称模糊搜索剧本
     * 2. 根据分类ID分页查询
     * @return
     */
    @PostMapping("serachScript")
    public Result serachScript(LimitPageVo limitPageVo){
        return scriptService.serachScript(limitPageVo);
    }



}
