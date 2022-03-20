package com.script.scriptreservation.controller;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("register")
    public void register(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        user.setUserName("ytl");
        user.setPassword("123456");
        user.setPhotoAdress("https://blog.csdn.net/zengqiang1/article/details/79381418?utm_source=blogkpcl6");
        user.setStatus(0);
        user.setEmail("meyitonglin@163.com");
        user.setPhoneNumber("13271735031");
        user.setMoney(1000);
        userService.register(user);
    }

}
