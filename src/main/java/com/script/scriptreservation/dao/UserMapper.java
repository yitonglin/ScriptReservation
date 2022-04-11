package com.script.scriptreservation.dao;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.vo.MoneyVo;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    User getUserByUserName(String uaername);
    void emailActive(User user);
    Integer updateUserPassword(User user);
    void payMoney(MoneyVo moneyVo);
}