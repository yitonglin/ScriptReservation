package com.script.scriptreservation.controller;

import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.service.IScriptService;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.RoomScriptVO;
import org.apache.logging.log4j.util.PerformanceSensitive;
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
     * 剧本信息展示  todo 浏览记录  剧本查看量加一
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

    /**
     * 查询当前剧本所对应的可加入拼团的房间 测试完毕
     */
    @PostMapping("getScriptIdFreeRoom")
    public Result getScriptIdFreeRoom(String scriptId){
        return scriptService.getScriptIdFreeRoom(scriptId);
    }

    /**
     * 首页推荐&分类查询 传递分类信息的时候安分类查询  测试完毕
     * @return
     */
    @PostMapping("getIndexScript")
    public Result getIndexScript(LimitPageVo limitPageVo){
        return scriptService.getIndexScript(limitPageVo);
    }



}
