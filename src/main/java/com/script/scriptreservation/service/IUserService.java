package com.script.scriptreservation.service;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.vo.Result;

import javax.jws.soap.SOAPBinding;

public interface IUserService {
    Result register(User user);
    Result login(User user);
    void emailActive(User user);
}
