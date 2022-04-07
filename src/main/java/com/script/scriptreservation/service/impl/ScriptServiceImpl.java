package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.OrderMapper;
import com.script.scriptreservation.dao.RoomMapper;
import com.script.scriptreservation.dao.ScriptMapper;
import com.script.scriptreservation.dto.ScriptCollectionDto;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Order;
import com.script.scriptreservation.po.Room;
import com.script.scriptreservation.po.Script;
import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IScriptService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.RoomScriptVO;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptServiceImpl implements IScriptService {

    @Autowired
    private ScriptMapper scriptMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result greatNumPlus(String id) {
        Result result = new Result();
        scriptMapper.greatNumPlus(id);
        result.setStatus(true);
        result.setMsg("点赞成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result stepNum(String id) {
        Result result = new Result();
        scriptMapper.stepNum(id);
        result.setStatus(true);
        result.setMsg("点踩成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result scriptCollection(ScriptCollectionDto scriptCollectionDto) {
        Result result = new Result();
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

        return result;
    }

    @Override
    public Result scriptInfo(String id) {
        Result result = new Result();
        Script script = scriptMapper.selectByPrimaryKey(id);
        if ( script != null){
            result.setStatus(true);
            result.setMsg("剧本查询成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
            result.setData(script);
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
        room.setStartTime(room.getStartTime());
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
            order.setForwardDate(MoreUtils.getCurrentTime());
            order.setOrderMoney(roomScriptVO.getPersonNum() * roomScriptVO.getScriptMoney());
            order.setCreateTime(MoreUtils.getCurrentTime());
            //默认为拼场成功
            order.setOrderStatus(0);
            int j = orderMapper.insert(order);
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
        room.setStartTime(room.getStartTime());
        room.setScript(roomScriptVO.getScriptId());
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
            order.setForwardDate(MoreUtils.getCurrentTime());
            order.setOrderMoney(roomScriptVO.getPersonNum() * roomScriptVO.getScriptMoney());
            order.setCreateTime(MoreUtils.getCurrentTime());
            order.setRefundTime(MoreUtils.getCurrentTime());
            //默认为包场成功状态
            order.setOrderStatus(2);
            int j = orderMapper.insert(order);
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
            order.setForwardDate(MoreUtils.getCurrentTime());
            order.setOrderMoney(roomScriptVO.getPersonNum() * roomScriptVO.getScriptMoney());
            order.setCreateTime(MoreUtils.getCurrentTime());
            //默认为拼场成功
            order.setOrderStatus(0);
            Integer j = orderMapper.insert(order);
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


}
