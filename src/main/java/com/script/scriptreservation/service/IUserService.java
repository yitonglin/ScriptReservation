package com.script.scriptreservation.service;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.vo.MoneyVo;
import com.script.scriptreservation.vo.Result;

import javax.jws.soap.SOAPBinding;

public interface IUserService {
    Result register(User user);
    Result login(User user);
    Result updateUserPassword(User user);
    void emailActive(User user);
    Result lookRecord(String id);
    Result personalCollection(String id);
    Result personalComments(String id);
    Result updateUserHeadImage(User user);
    Result payMoney(MoneyVo moneyVo);
}
