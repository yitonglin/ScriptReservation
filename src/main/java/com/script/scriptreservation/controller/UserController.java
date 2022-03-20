package com.script.scriptreservation.controller;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
        user.setUsername("ytl");
        user.setPassword("123456");
        userService.register(user);
    }

}
