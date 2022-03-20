package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.UserMapper;
import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }
}
