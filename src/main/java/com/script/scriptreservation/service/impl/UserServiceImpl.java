package com.script.scriptreservation.service.impl;

import com.script.scriptreservation.dao.CollectionMapper;
import com.script.scriptreservation.dao.CommentsMapper;
import com.script.scriptreservation.dao.RecordMapper;
import com.script.scriptreservation.dao.UserMapper;
import com.script.scriptreservation.enums.ApplicationEnum;
import com.script.scriptreservation.po.Record;
import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IUserService;
import com.script.scriptreservation.utils.MailUtils;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.vo.CollectionVo;
import com.script.scriptreservation.vo.CommentsVo;
import com.script.scriptreservation.vo.Result;
import com.script.scriptreservation.vo.ScriptRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private CommentsMapper commentsMapper;

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

    @Override
    public Result updateUserPassword(User user) {
        Result result = new Result();
        Integer resultNum = userMapper.updateUserPassword(user);
        if (resultNum > 0){
            result.setStatus(true);
            result.setMsg("密码修改成功");
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        } else {
            result.setStatus(false);
            result.setMsg("密码修改失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
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

    @Override
    public Result lookRecord(String id) {
        Result result = new Result();
        List<ScriptRecord> recordList = recordMapper.lookRecord(id);
        result.setStatus(true);
        result.setMsg("浏览记录查询成功");
        result.setData(recordList);
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result personalCollection(String id) {
        Result result = new Result();
        List<CollectionVo> collectionVos = collectionMapper.personalCollection(id);
        result.setStatus(true);
        result.setMsg("剧本收藏查询成功");
        result.setData(collectionVos);
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result personalComments(String id) {
        Result result = new Result();
        List<CommentsVo> commentsVos = commentsMapper.personalComments(id);
        result.setStatus(true);
        result.setMsg("个人评论查询成功");
        result.setData(commentsVos);
        result.setCode(ApplicationEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result updateUserHeadImage(User user) {
        Result result = new Result();
        Integer i = userMapper.updateByPrimaryKey(user);
        if (i > 0){
            result.setMsg("用户头像修改成功");
            result.setData(user);
            result.setCode(ApplicationEnum.SUCCESS.getCode());
        } else {
            result.setStatus(false);
            result.setMsg("用户头像修改失败");
            result.setCode(ApplicationEnum.FAIT.getCode());
        }
        return result;
    }


}



















