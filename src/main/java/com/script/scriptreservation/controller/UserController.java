package com.script.scriptreservation.controller;

import com.script.scriptreservation.po.User;
import com.script.scriptreservation.service.IUserService;
import com.script.scriptreservation.utils.MoreUtils;
import com.script.scriptreservation.utils.ValidateCodeUtil;
import com.script.scriptreservation.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * ========================================================登录注册相关接口========================================================
     */

    /***
     * 注册接口
     *
     */
    @PostMapping("register")
    public Result register(User user){
        return userService.register(user);
    }

    /**
     *
     * 邮箱激活方法
     * @param
     * @return
     */
    @GetMapping("emailActive")
    public String emailActive(int status,String emailAddress,String username){
        //封装激活邮件的信息（邮箱，状态码）
        User user = new User();
        if (status == 1){
            user.setStatus(status);
            user.setEmail(emailAddress);
            user.setUserName(username);
            userService.emailActive(user);
            return "emailActive";
        }else {
            return "failEmailActive";
        }

    }

    /**
     * 登录接口
     * @param user  用户信息
     * @return 标准返回
     */
    @PostMapping("login")
    public Result login(User user){
        Result result = userService.login(user);
        return result;
    }

    //验证码生成
    @PostMapping("/getCaptchaImg")
    public void getCaptchaImg(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        try {
            response.setContentType("image/png");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expire", "0");
            response.setHeader("Pragma", "no-cache");
            ValidateCodeUtil validateCode = new ValidateCodeUtil();
            // getRandomCodeImage方法会直接将生成的验证码图片写入response
            validateCode.getRandomCodeImage(request, response);
            // System.out.println("session里面存储的验证码为："+session.getAttribute("JCCODE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证码校验方法
     * 先验证验证码  如果验证码验证失败的话则不请求登录接口
     * @param code
     * @param session
     * @return
     */
    @PostMapping("/checkCaptcha")
    public boolean getCheckCaptcha(@RequestParam("code") String code, HttpSession session) {
        try {
            //toLowerCase() 不区分大小写进行验证码校验
            String sessionCode= String.valueOf(session.getAttribute("JCCODE")).toLowerCase();
            System.out.println("session里的验证码："+sessionCode);
            String receivedCode=code.toLowerCase();
            System.out.println("用户的验证码："+receivedCode);
            return !sessionCode.equals("") && !receivedCode.equals("") && sessionCode.equals(receivedCode);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * ========================================================个人中心相关接口========================================================
     */


    /**
     * 个人浏览记录查询
     * @param id
     * @return
     */
    @PostMapping("lookRecord")
    public Result lookRecord(String id){
        return userService.lookRecord(id);
    }

    /**
     * 个人收藏查询
     * @param id
     * @return
     */
    @PostMapping("personalCollection")
    public Result personalCollection(String id){
        return userService.personalCollection(id);
    }

    /**
     * 个人评论查询
     */
    @PostMapping("personalComments")
    public Result personalComments(String id){
        return userService.personalComments(id);
    }

    /**
     * 个人订单查询
     */


    /**
     * 密码修改
     * @return
     */
    @PostMapping("updateUserPassword")
    public Result updateUserPassword(User user){
        return userService.updateUserPassword(user);
    }

    //用户头像更新  接口使用方式：直接将新的网络头像封装到user对象中即可
    @PostMapping("updateUserHeadImage")
    public Result updateUserHeadImage(User user){
        return userService.updateUserHeadImage(user);
    }








}
