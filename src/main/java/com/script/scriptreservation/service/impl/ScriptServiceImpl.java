package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.*;
import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.*;
import com.script.scriptreservation.service.IScriptService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ScriptServiceImpl implements IScriptService {

    @Autowired
    private ScriptMapper scriptMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Result greatNumPlus(ScriptArticle scriptArticle) {
        Result result = new Result();
        scriptArticle.setID(MoreUtils.createId());
        //首先判断是否已经点赞 如果已经点赞完毕的话则返回取消点赞成功
        Integer integerResult =  scriptMapper.getGoodStatus(scriptArticle);
        if ( integerResult ==0 ){
            result.setMsg("点赞成功");
            scriptMapper.greatNumPlus(scriptArticle);
        }else {
            result.setMsg("取消点赞成功");
            //删除点赞信息
            scriptMapper.deleteGoodScript(scriptArticle);
        }
        result.setStatus(true);
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result stepNum(ScriptArticle scriptArticle) {
        Result result = new Result();
        scriptArticle.setID(MoreUtils.createId());
        //首先判断是否已经点踩 如果已经点踩完毕的话则返回取消点赞成功
        Integer integerResult =  scriptMapper.getPoorStatus(scriptArticle);
        if ( integerResult == 0 ){
            result.setMsg("点踩成功");
            scriptMapper.stepNum(scriptArticle);
        }else {
            result.setMsg("取消点踩成功");
            //删除点踩息
            scriptMapper.deleteGoodScript(scriptArticle);
        }
        result.setStatus(true);
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result scriptCollection(ScriptCollectionDto scriptCollectionDto) {
        Result result = new Result();
        //判断是否已收藏 已收藏则取消收藏
        Integer integerResult = scriptMapper.getCollectionCount(scriptCollectionDto);
        if (integerResult == 0){
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
        }else {
            scriptMapper.deleteCollectionByuser(scriptCollectionDto);
            result.setStatus(true);
            result.setMsg("取消收藏成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        }


        return result;
    }

    @Override
    public Result scriptInfo(ScriptCollectionDto scriptCollectionDto) {
        Result result = new Result();
        //剧本信息查询
        Script script = scriptMapper.selectByPrimaryKey(scriptCollectionDto.getScriptId());
        //剧本评分计算
        //剧本评论总数
        Integer count = scriptMapper.getScriptCount(scriptCollectionDto.getScriptId());
        //剧本好评数
        Integer goodCount = scriptMapper.getScriptGoodCount(scriptCollectionDto.getScriptId());
        //剧本差评数
        Integer poorCount = scriptMapper.getScriptPoorCount(scriptCollectionDto.getScriptId());
        //评分计算
        double fraction = 0;
        if (count != 0){
            fraction = goodCount/count;
        }
        ScriptVo scriptVo = new ScriptVo();
        if (script == null){
            result.setStatus(false);
            result.setMsg("BeanUtiles 源对象为空");
            result.setCode(ApplicationEnum.FAIT.getCode());
            return result;
        }
        BeanUtils.copyProperties(script,scriptVo);
        scriptVo.setCount(count);
        scriptVo.setGoodCount(goodCount);
        scriptVo.setPoorCount(poorCount);
        scriptVo.setFraction(fraction);
        if ( script != null){
            result.setStatus(true);
            result.setMsg("剧本查询成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
            result.setData(scriptVo);
        } else {
            result.setStatus(false);
            result.setMsg("剧本查询失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
        }
        return result;
    }

    @Override
    public Result addRandomGroup(RoomScriptVO roomScriptVO) {
        Result result = new Result();
        /**
         * 房间信息构建
         */
        Room room = new Room();
        //主键ID
        room.setId(MoreUtils.createId());
        //房间号
        room.setRoomId(roomScriptVO.getScriptId()+roomScriptVO.getUserId());
        //一共人数
        room.setHasNumber(roomScriptVO.getScriptNum());
        room.setNeedNumber(roomScriptVO.getScriptNum() - roomScriptVO.getPersonNum());
        room.setCreateTime(MoreUtils.getCurrentTime());
        room.setScript(roomScriptVO.getScriptId());
        room.setScriptName(roomScriptVO.getScriptName());
        room.setCategoryId(roomScriptVO.getCategoryId());
        room.setStartTime(roomScriptVO.getStartTime());
        room.setEndTime(roomScriptVO.getEndTime());
        room.setHostId(roomScriptVO.getHostId());
        //此处为新建拼团，所以在逻辑上并不会完全拼成 拼成的逻辑应在建团的时候存在 所以此处为未拼完成状态
        room.setStatus(1);
        //房间信息创建
        Integer i = roomMapper.insert(room);
        if (i > 0){
            //此处为校验房间是否创建成功 校验成功后方可创建用户的订单信息
            /**
             * 订单信息构建
             */
            Order order = new Order();
            order.setId(MoreUtils.createId());
            order.setUserId(roomScriptVO.getUserId());
            order.setScriptId(roomScriptVO.getScriptId());
            order.setRoomId(room.getRoomId());
            order.setOrderFlag(0);
            order.setOrderNumber(MoreUtils.createId());
            order.setForwardNum(roomScriptVO.getPersonNum());
            order.setForwardDate(roomScriptVO.getStartTime());//剧本开始时间
            order.setForwardEndDate(roomScriptVO.getEndTime());//剧本结束时间
            order.setOrderMoney(roomScriptVO.getPersonNum() * roomScriptVO.getScriptMoney());
            order.setCreateTime(MoreUtils.getCurrentTime());
            //默认为拼场成功
            order.setOrderStatus(0);
            int j = orderMapper.createOrder(order);
            if (j > 0){
                result.setStatus(true);
                result.setMsg("拼团成功");
                result.setCode(ApplicationEnum.SUCCESS.getCode());
            } else {
                result.setStatus(false);
                result.setMsg("订单创建失败");
                result.setCode(ApplicationEnum.FAIT.getCode());
                return result;
            }
        } else {
            //此时创建失败
            result.setStatus(false);
            result.setMsg("房间创建失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
            return result;
        }
        return result;
    }

    @Override
    public Result allGroup(RoomScriptVO roomScriptVO) {
        Result result = new Result();
        /**
         * 包场房间信息构建
         */
        Room room = new Room();
        //主键ID
        room.setId(MoreUtils.createId());
        //房间号
        room.setRoomId(roomScriptVO.getScriptId()+roomScriptVO.getUserId());
        //一共人数
        room.setHasNumber(roomScriptVO.getScriptNum());
        room.setNeedNumber(0);
        room.setCreateTime(MoreUtils.getCurrentTime());
        room.setCategoryId(roomScriptVO.getCategoryId());
        room.setStartTime(roomScriptVO.getStartTime());
        room.setEndTime(roomScriptVO.getEndTime());
        room.setScript(roomScriptVO.getScriptId());
        room.setScriptName(roomScriptVO.getScriptName());
        room.setHostId(roomScriptVO.getHostId());
        //此处为新建包场，所以此处为拼成状态
        room.setStatus(0);
        //房间信息创建
        Integer i = roomMapper.insert(room);
        if (i > 0){
            //此处为校验房间是否创建成功 校验成功后方可创建用户的订单信息
            /**
             * 订单信息构建
             */
            Order order = new Order();
            order.setId(MoreUtils.createId());
            order.setUserId(roomScriptVO.getUserId());
            order.setScriptId(roomScriptVO.getScriptId());
            order.setRoomId(room.getRoomId());
            order.setOrderFlag(1);
            order.setOrderNumber(MoreUtils.createId());
            order.setForwardNum(roomScriptVO.getPersonNum());
            order.setForwardDate(roomScriptVO.getStartTime());//剧本开始时间
            order.setForwardEndDate(roomScriptVO.getEndTime());//剧本结束时间
            order.setOrderMoney(roomScriptVO.getPersonNum() * roomScriptVO.getScriptMoney());
            order.setCreateTime(MoreUtils.getCurrentTime());
            order.setRefundTime(MoreUtils.getCurrentTime());
            //默认为包场成功状态
            order.setOrderStatus(2);
            int j = orderMapper.createOrder(order);
            if (j > 0){
                result.setStatus(true);
                result.setMsg("包场成功");
                result.setCode(ApplicationEnum.SUCCESS.getCode());
            } else {
                result.setStatus(false);
                result.setMsg("订单创建失败");
                result.setCode(ApplicationEnum.FAIT.getCode());
                return result;
            }
        } else {
            //此时创建失败
            result.setStatus(false);
            result.setMsg("包场房间创建失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
            return result;
        }
        return result;
    }

    @Override
    public Result insetRandomGroup(RoomScriptVO roomScriptVO) {
        Result result = new Result();
        /**
         * 修改房间信息
         */
        //查询出房间信息
        Room room = roomMapper.selectByPrimaryKey(roomScriptVO.getRoomId());
        room.setNeedNumber(room.getNeedNumber() - 1);
        if ((room.getNeedNumber() - 1) == 0){
            //当所需人数为1时 此时这个人加入后便不缺人了
            room.setStatus(0);
        }
        int i = roomMapper.updateByPrimaryKey(room);
        if (i > 0){
            //当房间信息更新成功后则创建个人订单信息
            /**
             * 订单信息构建
             */
            Order order = new Order();
            order.setId(MoreUtils.createId());
            order.setUserId(roomScriptVO.getUserId());
            order.setScriptId(roomScriptVO.getScriptId());
            order.setRoomId(room.getRoomId());
            order.setOrderFlag(0);
            order.setOrderNumber(MoreUtils.createId());
            order.setForwardNum(roomScriptVO.getPersonNum());
            order.setForwardDate(roomScriptVO.getStartTime());//剧本开始时间
            order.setForwardEndDate(roomScriptVO.getEndTime());//剧本结束时间
            order.setOrderMoney(roomScriptVO.getPersonNum() * roomScriptVO.getScriptMoney());
            order.setCreateTime(MoreUtils.getCurrentTime());
            //默认为拼场成功
            order.setOrderStatus(0);
            Integer j = orderMapper.createOrder(order);
            if (j > 0){
                result.setStatus(true);
                result.setMsg("加入拼团成功");
                result.setCode(ApplicationEnum.SUCCESS.getCode());
            } else {
                result.setStatus(false);
                result.setMsg("加入拼团失败");
                result.setCode(ApplicationEnum.FAIT.getCode());
                return result;
            }
        } else {
            result.setStatus(false);
            result.setMsg("加入房间失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
            return result;
        }
        return result;
    }


    public Result serachScript(LimitPageVo limitPageVo){
        Result result = new Result();
        limitPageVo.setPageCount(limitPageVo.getPageNum() * 5);//计算查询的数据开始的地方
        limitPageVo.setLikeFiled("%"+limitPageVo.getFiled()+"%");
        limitPageVo.setCount(scriptMapper.serachScriptCount(limitPageVo));
        List<Script> scripts = scriptMapper.serachScript(limitPageVo);
        result.setStatus(true);
        result.setMsg("分页查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        limitPageVo.setListData(scripts);
        result.setData(limitPageVo);
        return result;
    }

    @Override
    public Result getScriptIdFreeRoom(String scriptId) {
        Result result = new Result();
        List<Room> rooms = roomMapper.getScriptIdFreeRoom(scriptId);
        result.setMsg("此剧本下可加入的房间查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(rooms);
        return result;
    }

    @Override
    public Result getIndexScript(LimitPageVo limitPageVo) {
        Result result = new Result();
        //计算分页开始查询的地方
        limitPageVo.setPageCount(limitPageVo.getPageNum() * limitPageVo.getLen());
        //查询总条数
        limitPageVo.setCount(scriptMapper.getIndexScriptCount(limitPageVo));
        List<Script> scripts = scriptMapper.getIndexScript(limitPageVo);
        limitPageVo.setListData(scripts);
        result.setMsg("列表查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(limitPageVo);
        return result;
    }

    @Override
    public Result getUserScript(UserScriptVo userScriptVo) {
        Result result = new Result();
        //查询点赞情况
        Integer goodStatu = scriptMapper.getGoodStatu(userScriptVo);
        userScriptVo.setGoodStatus(goodStatu);
        //获取收藏情况
        Integer collectionStatu = collectionMapper.getCollectionStatu(userScriptVo);
        userScriptVo.setCollectionStatus(collectionStatu);
        result.setMsg("用户点赞收藏信息查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(userScriptVo);
        return result;
    }

    @Override
    public Result createRecord(Record record) {
        Result result =  new Result();
        //剧本浏览量加一
        scriptMapper.updateRecordPlus(record.getScriptId());
        //用户足迹记录
        record.setId(MoreUtils.createId());
        record.setTime(MoreUtils.getCurrentTime());
        recordMapper.insert(record);
        result.setMsg("足迹记录成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setStatus(true);
        return result;
    }

}
