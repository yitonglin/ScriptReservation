package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.HostMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Host;
import com.script.scriptreservation.service.IHostService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements IHostService {

    @Autowired
    private HostMapper hostMapper;

    @Override
    public Result selectFreeHost(Long startTime) {
        Result result = new Result();
        List<Host> hosts = hostMapper.selectFreeHost(startTime);
        if (hosts != null && !hosts.isEmpty()){
            result.setStatus(true);
            result.setMsg("主持人查询成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
            result.setData(hosts);
        } else {
            result.setStatus(false);
            result.setMsg("主持人查询失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
        }
        return result;
    }

    @Override
    public Result selectHostById(String id) {
        Result result = new Result();
        Host host = hostMapper.selectByPrimaryKey(id);
        result.setStatus(true);
        result.setMsg("主持人查询成功");
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setData(host);
        return result;
    }

    @Override
    public Result selectIndexHost() {
        Result result = new Result();
        List<Host> hosts = hostMapper.selectIndexHost();
        if (hosts != null && !hosts.isEmpty()){
            result.setStatus(true);
            result.setMsg("主持人推荐查询成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
            result.setData(hosts);
        } else {
            result.setStatus(false);
            result.setMsg("主持人推荐查询失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
        }
        return result;
    }
}
