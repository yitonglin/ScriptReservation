package com.script.scriptreservation.service;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.vo.LimitPageVo;
import com.script.scriptreservation.vo.MoneyVo;
import com.script.scriptreservation.vo.Result;

import javax.jws.soap.SOAPBinding;

public interface IUserService {
    Result register(User user);
    Result login(User user);
    Result updateUserPassword(User user);
    void emailActive(User user);
    Result lookRecord(LimitPageVo limitPageVo);
    Result personalCollection(LimitPageVo limitPageVo);
    Result personalComments(LimitPageVo limitPageVo);
    Result updateUserHeadImage(User user);
    Result payMoney(MoneyVo moneyVo);
    Result getUserInfo(String userId);
}
