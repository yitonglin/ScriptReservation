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
     * 已测试
     * 查询当前空闲的主持人  传入预约的时间  然后跟房间的开始时间进行对比  查询到的主持人再跟所有主持人进行diff处理
     */
    @PostMapping("selectFreeHost")
    public Result selectFreeHost(Long startTime){
        return hostService.selectFreeHost(startTime);
    }

    /**
     * 根据支持人ID查询主持人信息 已测试
     * @param id
     * @return
     */
    @PostMapping("selectHostById")
    public Result selectHostById(String id){
        return hostService.selectHostById(id);
    }

    /**
     * 首页主持人推荐 已测试
     * @return
     */
    @PostMapping("selectIndexHost")
    public Result selectIndexHost(){
        return hostService.selectIndexHost();
    }


}
