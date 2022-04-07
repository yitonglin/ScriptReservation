package com.script.scriptreservation.controller;

import com.script.scriptreservation.service.IHostService;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("host")
public class HostController {

    @Autowired
    private IHostService hostService;

    /**
     * 未测试
     * 查询当前空闲的主持人
     */
    @PostMapping("selectFreeHost")
    public Result selectFreeHost(){
        return hostService.selectFreeHost();
    }

}
