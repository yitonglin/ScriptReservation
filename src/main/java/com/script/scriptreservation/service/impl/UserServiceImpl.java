package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.UserMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IUserService;
import com.script.scriptreservation.utils.MailUtils;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result register(User user) {
        Result result = new Result();
        User userByUserName = userMapper.getUserByUserName(user.getUserName());
        if (userByUserName != null){
            result.setCode(ApplicationEnum.FAIT.getCode());
            result.setMsg("该用户名已注册，请换个用户名重新注册。");
            result.setStatus(false);
            return result;
        }
        user.setId(MoreUtils.createId());
        int resultInt = userMapper.insert(user);
        //如果注册成功
        if (resultInt == 1){
            //3,激活邮件发送，邮件正文
            String email = user.getEmail();
            String username = user.getUserName();
            String content ="<a href='http://127.0.0.1:8082/user/emailActive?status=1&emailAddress="+email+"+&username="+username+"'>点击激活【剧本杀预约系统】</a>";
            MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        }
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        result.setMsg("注册成功");
        result.setStatus(true);
        return result;
    }

    @Override
    public Result login(User user) {
        Result result = new Result();
        //根据用户名查询用户信息
        User userResult = userMapper.getUserByUserName(user.getUserName());
        //比对密码
        if (userResult != null && user.getPassword().equals(userResult.getPassword())){
            result.setCode(ApplicationEnum.SUCCESS.getCode());
            result.setMsg("登陆成功");
            result.setStatus(true);
            result.setData(userResult);
        } else {
            result.setStatus(false);
            result.setCode(ApplicationEnum.FAIT.getCode());
            result.setMsg("账号或密码错误");
        }
        return result;
    }

    /**
     * 邮箱激活方法
     * @param user
     */
    @Override
    public void emailActive(User user) {
        userMapper.emailActive(user);
    }
}
